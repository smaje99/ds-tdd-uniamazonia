package co.edu.udla.ed.impl.scratch;

import java.util.Iterator;
import java.util.NoSuchElementException;

import co.edu.udla.ed.api.CircularList;

public class CircularSinglyLinkedList<T> implements CircularList<T> {

  /**
   * Node class represents a single node in the circular singly linked list. It
   * contains a value of type T and a reference to the next node in the list. The
   * next reference will point to itself if it's the only node in the list,
   * creating a circular structure.
   *
   * @param <T> the type of the value stored in the node
   */
  private static class Node<T> {
    final T value;
    Node<T> next;

    Node(T value) {
      this.value = value;
    }
  }

  private Node<T> tail; // tail.next es head cuando size > 0
  private int size;

  /**
   * Adds a new element at the beginning of the circular singly linked list. If
   * the list is empty, the new node will point to itself, making it the only node
   * in the list. If the list is not empty, the new node will point to the current
   * head (which is tail.next), and the tail will be updated to point to the new
   * node as the new head of the list. This operation has a time complexity of
   * O(1) since it only involves updating a few references.
   *
   * @param value the value to be added to the list
   */
  @Override
  public void addFirst(T value) {
    Node<T> newNode = new Node<>(value);

    if (tail == null) {
      // primera inserción: se apunta a sí mismo
      tail = newNode;
      tail.next = tail;
    } else {
      // head actual es tail.next
      newNode.next = tail.next;
      tail.next = newNode; // nuevo head
    }

    size++;
  }

  /**
   * Adds a new element at the end of the circular singly linked list. This method
   * first calls addFirst to insert the new value at the beginning of the list,
   * and then updates the tail reference to point to the newly added node,
   * effectively making it the last node in the list. This operation has a time
   * complexity of O(1) since it only involves a constant number of reference
   * updates.
   *
   * @param value the value to be added to the end of the list
   */
  @Override
  public void addLast(T value) {
    addFirst(value); // lo inserta como head
    tail = tail.next; // y lo mueve a tail, quedando al final
  }

  /**
   * Removes and returns the first element of the circular singly linked list. If
   * the list is empty, it throws a NoSuchElementException. If the list has only
   * one element, it removes that element and sets the tail to null. If the list
   * has more than one element, it updates the tail's next reference to skip the
   * head and point to the second node, effectively removing the head from the
   * list. This operation has a time complexity of O(1) since it only involves
   * updating a few references.
   *
   * @return the value of the removed first element
   */
  @Override
  public T removeFirst() {
    if (tail == null)
      throw new NoSuchElementException("List is empty.");

    Node<T> head = tail.next;
    T value = head.value;

    if (head == tail) {
      // solo 1 elemento
      tail = null;
    } else {
      tail.next = head.next; // saltar el head
    }

    size--;
    return value;
  }

  /**
   * Removes and returns the last element of the circular singly linked list. If
   * the list is empty, it throws a NoSuchElementException. If the list has only
   * one element, it removes that element and sets the tail to null. If the list
   * has more than one element, it traverses the list to find the node just before
   * the tail (the last node), updates its next reference to point to the head
   * (which is tail.next), and then updates the tail reference to point to this
   * node, effectively removing the last element from the list. This operation has
   * a time complexity of O(n) in the worst case since it may require traversing
   * the entire list to find the node before the tail.
   *
   * @throws NoSuchElementException if the list is empty
   * @return the value of the removed last element
   */
  @Override
  public T removeLast() {
    if (tail == null)
      throw new NoSuchElementException("List is empty");

    Node<T> head = tail.next;

    if (head == tail) {
      T value = tail.value;
      tail = null;
      size = 0;
      return value;
    }

    // buscar el nodo anterior al tail
    Node<T> prev = head;
    while (prev.next != tail) {
      prev = prev.next;
    }

    T value = tail.value;
    prev.next = tail.next; // apunta a head
    tail = prev;

    size--;
    return value;
  }

  /**
   * Returns the element at the specified index in the circular singly linked
   * list. If the index is out of bounds (less than 0 or greater than or equal to
   * size), it throws an IndexOutOfBoundsException. The method starts from the
   * head of the list (which is tail.next) and traverses the list until it reaches
   * the node at the specified index, then returns the value of that node. This
   * operation has a time complexity of O(n) in the worst case since it may
   * require traversing up to n nodes to reach the specified index.
   *
   * @param index the index of the element to return
   * @return the value of the element at the specified index
   * @throws IndexOutOfBoundsException if the index is out of range (index < 0 ||
   *                                   index >= size)
   */
  @Override
  public T get(int index) {
    checkIndex(index);
    Node<T> currentNode = tail.next; // head
    for (int i = 0; i < index; i++)
      currentNode = currentNode.next;
    return currentNode.value;
  }

  /**
   * Checks if the circular singly linked list contains a specific value. The
   * method starts from the head of the list (which is tail.next) and traverses
   * the list, comparing each node's value with the specified value. If a match is
   * found, it returns true. If the traversal completes without finding a match
   * (i.e., it returns to the head), it returns false. If the list is empty (tail
   * is null), it immediately returns false. This operation has a time complexity
   * of O(n) in the worst case since it may require traversing the entire list to
   * find the specified value.
   *
   * @param value the value to be checked for containment in the list
   * @return true if the list contains the specified value, false otherwise
   */
  @Override
  public boolean contains(T value) {
    if (tail == null)
      return false;
    Node<T> current = tail.next; // head
    do {
      if (current.value.equals(value)) {
        return true;
      }
      current = current.next;
    } while (current != tail.next); // volver a head
    return false;
  }

  /**
   * Returns the number of elements in the circular singly linked list. This
   * method simply returns the value of the size field, which is updated whenever
   * elements are added or removed from the list. This operation has a time
   * complexity of O(1) since it only involves returning a stored value.
   *
   * @return the number of elements in the list
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Removes all elements from the circular singly linked list. This method sets
   * the tail reference to null and resets the size to 0, effectively clearing the
   * list. After calling this method, the list will be empty and any subsequent
   * operations that depend on the presence of elements (like removeFirst or
   * removeLast) will throw exceptions until new elements are added. This
   * operation has a time complexity of O(1) since it only involves updating a
   * couple of references and resetting a counter.
   */
  @Override
  public void clear() {
    tail = null;
    size = 0;
  }

  /**
   * Returns an iterator over the elements in the circular singly linked list. The
   * iterator starts from the head of the list (which is tail.next) and iterates
   * through the list until it has returned all elements. The hasNext method
   * checks if there are more elements to return based on a count of how many
   * elements have been returned so far, while the next method returns the current
   * element's value and advances the iterator to the next node. If next is called
   * when there are no more elements to return, it throws a
   * NoSuchElementException. This operation has a time complexity of O(1) for each
   * call to hasNext and next, but iterating through the entire list will have a
   * time complexity of O(n).
   *
   * @return an iterator over the elements in the list
   */
  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private Node<T> current = (tail != null) ? tail.next : null; // head
      private int count = 0;

      @Override
      public boolean hasNext() {
        return count < size;
      }

      @Override
      public T next() {
        if (!hasNext())
          throw new NoSuchElementException();
        T value = current.value;
        current = current.next;
        count++;
        return value;
      }
    };
  }

  /**
   * Checks if the provided index is within the valid range of 0 (inclusive) to
   * size (exclusive). If the index is out of bounds, it throws an
   * IndexOutOfBoundsException with a message indicating the invalid index and the
   * current size of the list.
   *
   * @param index the index to be checked
   */
  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("index=" + index + ", size=" + size);
    }
  }

}
