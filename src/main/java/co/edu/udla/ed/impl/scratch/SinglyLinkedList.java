package co.edu.udla.ed.impl.scratch;

import java.util.Iterator;
import java.util.NoSuchElementException;

import co.edu.udla.ed.api.SimpleList;

public class SinglyLinkedList<T> implements SimpleList<T> {

  /**
   * A private static inner class representing a node in the singly linked list.
   * Each node contains a reference to the data it holds and a reference to the
   * next node in the list. This class is used internally by the SinglyLinkedList
   * to manage the elements of the list.
   */
  private static class Node<T> {
    final T value;
    Node<T> next;

    Node(T value) {
      this.value = value;
      this.next = null;
    }
  }

  private Node<T> head;
  private Node<T> tail;
  private int size;

  /**
   * Adds an element to the front of the list. This method creates a new node with
   * the given element and updates the head reference to point to the new node. If
   * the list was previously empty, the tail reference is also updated to point to
   * the new node. The size of the list is incremented by one.
   *
   * @param element the element to add to the front of the list
   */
  @Override
  public void addFirst(T element) {
    Node<T> newNode = new Node<>(element);
    newNode.next = head;
    head = newNode;
    if (tail == null) {
      tail = head;
    }
    size++;
  }

  /**
   * Adds an element to the end of the list. This method creates a new node with
   * the given element and updates the tail reference to point to the new node. If
   * the list was previously empty, the head reference is also updated to point to
   * the new node. The size of the list is incremented by one.
   *
   * @param element the element to add to the end of the list
   */
  @Override
  public void addLast(T element) {
    Node<T> newNode = new Node<>(element);
    if (tail == null) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    size++;
  }

  /**
   * Removes and returns the first element of the list. This method updates the
   * head reference to point to the next node in the list. If the list becomes
   * empty after the removal, the tail reference is also set to null. The size of
   * the list is decremented by one. If the list is empty before the removal, a
   * NoSuchElementException is thrown.
   *
   * @return the removed element from the front of the list
   * @throws NoSuchElementException if the list is empty before the removal
   */
  @Override
  public T removeFirst() {
    if (head == null) {
      throw new NoSuchElementException("List is empty.");
    }
    T value = head.value;
    head = head.next;
    size--;
    if (size == 0) {
      tail = null;
    }
    return value;
  }

  /**
   * Removes and returns the last element of the list. This method traverses the
   * list to find the second-to-last node and updates the tail reference to point
   * to it. If the list becomes empty after the removal, the head reference is
   * also set to null. The size of the list is decremented by one. If the list is
   * empty before the removal, a NoSuchElementException is thrown.
   *
   * @return the removed element from the end of the list
   * @throws NoSuchElementException if the list is empty before the removal
   */
  @Override
  public T removeLast() {
    if (head == null) {
      throw new NoSuchElementException("List is empty.");
    }

    if (head == tail) { // Only one element in the list
      T value = head.value;
      head = tail = null;
      size = 0;
      return value;
    }

    // More than one element in the list
    Node<T> prevNode = head;
    while (prevNode.next != tail) {
      prevNode = prevNode.next;
    }
    T value = tail.value;
    prevNode.next = null;
    tail = prevNode;
    size--;
    return value;
  }

  /**
   * Retrieves the element at the specified index in the list. This method first
   * checks if the index is within the bounds of the list (0 to size-1). If the
   * index is valid, it traverses the list from the head node to the specified
   * index and returns the value of the node at that index. If the index is out of
   * bounds, an IndexOutOfBoundsException is thrown with a message indicating the
   * invalid index and the current size of the list.
   *
   * @param index the index of the element to retrieve
   * @return the element at the specified index in the list
   * @throws IndexOutOfBoundsException if the index is out of bounds (negative or
   *                                   greater than or equal to the size of the
   *                                   list)
   */
  @Override
  public T get(int index) {
    checkIndex(index);
    Node<T> current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current.value;
  }

  /**
   * Checks if the list contains the specified element. This method traverses the
   * list from the head node to the end, comparing each node's value with the
   * specified element. If a match is found, the method returns true. If the end
   * of the list is reached without finding a match, the method returns false.
   * The equality check is performed using the equals() method of the element, so
   * it is important that the element's class properly overrides the equals()
   * method for this method to work correctly.
   *
   * @param element the element to check for in the list
   * @return true if the element is found in the list, false otherwise
   */
  @Override
  public boolean contains(T element) {
    Node<T> current = head;
    while (current != null) {
      if (current.value.equals(element)) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  /**
   * Returns the number of elements currently in the list. This method simply
   * returns the value of the size field, which is updated whenever elements are
   * added or removed from the list. The size field is initialized to 0 when the
   * list is created and is incremented by one each time an element is added and
   * decremented by one each time an element is removed. This method provides a
   * constant time O(1) operation to retrieve the current size of the list.
   *
   * @return the number of elements currently in the list
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Removes all elements from the list, effectively clearing it. This method sets
   * the head and tail references to null and resets the size to 0. After calling
   * this method, the list will be empty and ready to accept new elements. This is a
   * constant time O(1) operation since it does not require traversing the list to remove
   * each element individually; instead, it simply resets the references and size.
   */
  @Override
  public void clear() {
    head = tail = null;
    size = 0;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private Node<T> current = head;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public T next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        T element = current.value;
        current = current.next;
        return element;
      }
    };
  }

  /**
   * Checks if the given index is within the bounds of the list. If the index is
   * negative or greater than or equal to the size of the list, an
   * IndexOutOfBoundsException is thrown with a message indicating the invalid
   * index and the current size of the list.
   *
   * @param index the index to check
   * @throws IndexOutOfBoundsException if the index is out of bounds
   */
  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("index=" + index + ", size=" + size);
    }
  }
}
