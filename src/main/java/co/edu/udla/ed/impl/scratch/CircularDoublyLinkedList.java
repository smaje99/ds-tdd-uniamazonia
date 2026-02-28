package co.edu.udla.ed.impl.scratch;

import java.util.Iterator;
import java.util.NoSuchElementException;

import co.edu.udla.ed.api.CircularList;

/**
 * CircularDoublyLinkedList is a concrete implementation of the CircularList
 * interface using a circular doubly linked list data structure. It provides
 * methods to add, remove, and access elements in the list, as well as to check
 * for the presence of elements and to clear the list. The class maintains
 * references to the head and tail nodes, as well as a size variable to keep
 * track of the number of elements in the list. The circular nature of the list
 * allows for efficient traversal in both directions, and the doubly linked
 * structure enables easy insertion and removal of elements at both ends of the
 * list.
 *
 * @param <T> the type of elements stored in the circular doubly linked list
 */
public class CircularDoublyLinkedList<T> implements CircularList<T> {

  /**
   * Node class representing each element in the circular doubly linked list. It
   * contains a value of type T, a reference to the previous node (prev), and a
   * reference to the next node (next). The constructor initializes the value and
   * sets the prev and next references to null. This inner class is used to create
   * the structure of the circular doubly linked list.
   *
   * @param <T> the type of elements stored in the circular doubly linked list
   */
  private static class Node<T> {
    final T value;
    Node<T> prev;
    Node<T> next;

    Node(T value) {
      this.value = value;
    }
  }

  private Node<T> head;
  private Node<T> tail;
  private int size;

  /**
   * Adds an element to the beginning of the circular doubly linked list. If the
   * list is empty, the new node becomes both the head and tail, and its next and
   * prev references point to itself. If the list is not empty, the new node is
   * linked to the current head and tail, and then becomes the new head. The size
   * of the list is incremented by one. This operation has a time complexity of
   * O(1) since it involves a constant number of pointer updates regardless of the
   * size of the list.
   *
   * @param element the element to be added to the beginning of the list
   */
  @Override
  public void addFirst(T element) {
    Node<T> newNode = new Node<>(element);

    if (head == null) {
      // primer nodo apunta a sí mismo en ambos sentidos
      head = tail = newNode;
      newNode.next = newNode;
      newNode.prev = newNode;
    } else {
      newNode.next = head;
      newNode.prev = tail;

      head.prev = newNode;
      tail.next = newNode;

      head = newNode;
    }

    size++;
  }

  /**
   * Adds an element to the end of the circular doubly linked list. If the list is
   * empty, it calls addFirst to add the element as the first node. If the list
   * is not empty, a new node is created and linked to the current head and tail,
   * and then becomes the new tail. The size of the list is incremented by one.
   * This operation has a time complexity of O(1) since it involves a constant
   * number of pointer updates regardless of the size of the list.
   *
   * @param element the element to be added to the end of the list
   */
  @Override
  public void addLast(T element) {
    if (head == null) {
      addFirst(element);
    } else {
      Node<T> newNode = new Node<>(element);
      newNode.next = head;
      newNode.prev = tail;

      head.prev = newNode;
      tail.next = newNode;

      tail = newNode;

      size++;
    }
  }

  /**
   * Removes and returns the first element of the circular doubly linked list. If
   * the list is empty, it throws a NoSuchElementException. If the list has only
   * one node, it sets head and tail to null and size to 0, effectively clearing
   * the list. If the list has more than one node, it updates the head to the
   * next node, adjusts the prev reference of the new head and the next reference
   * of the tail to maintain the circular structure, and decrements the size by
   * one. The removed value is returned. This operation has a time complexity of
   * O(1) since it involves a constant number of pointer updates regardless of the
   * size of the list.
   *
   * @return the value of the removed first element
   * @throws NoSuchElementException if the list is empty
   */
  @Override
  public T removeFirst() {
    if (head == null)
      throw new NoSuchElementException("List is empty.");

    T value = head.value;

    if (head == tail) {
      head = tail = null;
      size = 0;
      return value;
    }

    Node<T> newHead = head.next;

    newHead.prev = tail;
    tail.next = newHead;

    head = newHead;
    size--;
    return value;
  }

  /**
   * Removes and returns the last element of the circular doubly linked list. If
   * the list is empty, it throws a NoSuchElementException. If the list has only
   * one node, it sets head and tail to null and size to 0, effectively clearing
   * the list. If the list has more than one node, it updates the tail to the
   * previous node, adjusts the next reference of the new tail and the prev
   * reference of the head to maintain the circular structure, and decrements the
   * size by one. The removed value is returned. This operation has a time
   * complexity of O(1) since it involves a constant number of pointer updates
   * regardless of the size of the list.
   *
   * @return the value of the removed last element
   * @throws NoSuchElementException if the list is empty
   */
  @Override
  public T removeLast() {
    if (tail == null)
      throw new NoSuchElementException("List is empty");

    T value = tail.value;

    if (head == tail) {
      head = tail = null;
      size = 0;
      return value;
    }

    Node<T> newTail = tail.prev;

    newTail.next = head;
    head.prev = newTail;

    tail = newTail;
    size--;
    return value;
  }

  /**
   * Retrieves the element at the specified index in the circular doubly linked
   * list. This method first checks if the index is valid using the checkIndex
   * method, which throws an exception if the index is out of bounds. If the index
   * is valid, it calls the nodeAt method to retrieve the node at the specified
   * index and returns its value. The time complexity of this operation is O(n) in
   * the worst case, where n is the size of the list, due to the need to traverse
   * the list to find the target node. However, it can be more efficient on
   * average due to the optimization in the nodeAt method that decides whether to
   * traverse from the head or tail based on the index.
   *
   * @param index the index of the element to retrieve
   * @return the value of the element at the specified index
   * @throws IndexOutOfBoundsException if the index is out of bounds
   */
  @Override
  public T get(int index) {
    checkIndex(index);
    return nodeAt(index).value;
  }

  /**
   * Checks if the circular doubly linked list contains a specific element. This
   * method iterates through the list starting from the head and compares each
   * node's value with the provided element using the equals method. If a match is
   * found, it returns true; otherwise, it continues until it has checked all
   * nodes. If no match is found after checking all nodes, it returns false. The
   * time complexity of this operation is O(n) in the worst case, where n is the
   * size of the list, since it may need to check each element once.
   *
   * @param element the element to check for in the list
   * @return true if the element is found in the list, false otherwise
   */
  @Override
  public boolean contains(T element) {
    Node<T> currentNode = head;
    for (int i = 0; i < size; i++) {
      if (currentNode.value.equals(element)) {
        return true;
      }
      currentNode = currentNode.next;
    }
    return false;
  }

  /**
   * Returns the number of elements in the circular doubly linked list. This
   * method simply returns the value of the size variable, which is updated
   * whenever elements are added or removed from the list. The time complexity of
   * this operation is O(1) since it does not depend on the number of elements in
   * the list.
   *
   * @return the number of elements in the list
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Checks if the circular doubly linked list is empty. This method returns true
   * if the size of the list is 0, indicating that there are no elements in the
   * list, and false otherwise. The time complexity of this operation is O(1)
   * since it simply checks the value of the size variable.
   *
   * @return true if the list is empty, false otherwise
   */
  @Override
  public void clear() {
    head = tail = null;
    size = 0;
  }

  /**
   * Returns an iterator over the elements in the circular doubly linked list. The
   * iterator is implemented as an anonymous inner class that maintains a
   * reference to the current node and the number of remaining elements to iterate
   * over. The hasNext method checks if there are more elements to iterate, while
   * the next method returns the value of the current node and advances the
   * iterator to the next node. If there are no more elements to iterate, the next
   * method throws a NoSuchElementException. The time complexity of creating the
   * iterator is O(1), and each call to hasNext and next is also O(1).
   *
   * @return an iterator over the elements in the list
   */
  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private Node<T> currentNode = head;
      private int remaining = size;

      @Override
      public boolean hasNext() {
        return remaining > 0;
      }

      @Override
      public T next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }

        T value = currentNode.value;
        currentNode = currentNode.next;
        remaining--;
        return value;
      }
    };
  }

  /**
   * Returns the node at the specified index in the circular doubly linked list.
   * This method uses a small optimization to determine whether to traverse the
   * list from the head or the tail, depending on which is closer to the target
   * index. If the index is less than half of the size of the list, it starts from
   * the head and traverses forward; otherwise, it starts from the tail and
   * traverses backward. This optimization helps to reduce the number of steps
   * needed to reach the target node, especially for larger lists. The time
   * complexity of this operation is O(n) in the worst case, where n is the size
   * of the list, but it can be more efficient on average due to the optimization.
   *
   * @param index the index of the node to retrieve
   * @return the node at the specified index
   */
  private Node<T> nodeAt(int index) {
    // pequeña optimización: desde head o tail
    if (index < size / 2) {
      Node<T> currentNode = head;
      for (int i = 0; i < index; i++)
        currentNode = currentNode.next;
      return currentNode;
    } else {
      Node<T> currentNode = tail;
      for (int i = size - 1; i > index; i--)
        currentNode = currentNode.prev;
      return currentNode;
    }
  }

  /**
   * Checks if the provided index is within the valid range for the circular
   * doubly linked list. The valid range is from 0 to size - 1, inclusive. If the
   * index is less than 0 or greater than or equal to the size of the list, this
   * method throws an IndexOutOfBoundsException with a message indicating the
   * invalid index and the current size of the list. This method is typically used
   * to validate indices before performing operations that require access to
   * specific positions in the list, such as retrieving or removing elements. The
   * time complexity of this operation is O(1) since it only involves a couple of
   * comparisons and does not depend on the size of the list.
   *
   * @param index the index to check
   * @throws IndexOutOfBoundsException if the index is out of the valid range
   */
  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("index=" + index + ", size=" + size);
    }
  }
}
