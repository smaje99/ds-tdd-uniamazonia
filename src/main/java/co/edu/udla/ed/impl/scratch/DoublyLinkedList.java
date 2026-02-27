package co.edu.udla.ed.impl.scratch;

import java.util.Iterator;
import java.util.NoSuchElementException;

import co.edu.udla.ed.api.DoublyList;

/**
 * An implementation of a doubly linked list that provides basic operations for
 * adding, removing, and accessing elements in the list. This class implements
 * the DoublyList interface, which defines the contract for a doubly linked list
 * data structure. The DoublyLinkedList class uses a private static inner class
 * called Node to represent each node in the list, which contains a value of
 * type T and references to the next and previous nodes in the list. The class
 * maintains references to the head and tail of the list, as well as a size
 * field to keep track of the number of elements in the list. The implementation
 * provides efficient methods for adding and removing elements from both ends of
 * the list, as well as retrieving elements by index and checking for the
 * presence
 * of specific values in the list.
 *
 * @param <T> the type of elements stored in this list
 */
public class DoublyLinkedList<T> implements DoublyList<T> {

  /**
   * A private static inner class representing a node in the doubly linked list.
   * Each node contains a value of type T, a reference to the next node, and a
   * reference to the previous node. This class is used internally by the
   * DoublyLinkedList to manage the elements in the list. The Node class is not
   * exposed to the users of the DoublyLinkedList and is only used for internal
   * operations such as adding, removing, and traversing the list.
   *
   * @param <T> the type of elements stored in the node
   */
  private static class Node<T> {
    final T value;
    Node<T> next;
    Node<T> prev;

    Node(T value) {
      this.value = value;
    }
  }

  private Node<T> head;
  private Node<T> tail;
  private int size;

  /**
   * Adds a new element to the beginning of the doubly linked list. This method
   * creates a new node with the specified value and updates the head and tail
   * references accordingly. If the list is empty, the new node becomes both the
   * head and tail of the list. If the list is not empty, the new node is linked
   * to the current head, and the head reference is updated to point to the new
   * node. The size of the list is incremented by one after the new node is added.
   * This operation has a time complexity of O(1) since it only involves updating
   * a few references and does not require traversing the list.
   *
   * @param value the value to be added to the beginning of the list
   */
  @Override
  public void addFirst(T value) {
    Node<T> newNode = new Node<>(value);
    newNode.next = head;
    if (head != null) {
      head.prev = newNode;
    }
    head = newNode;
    if (tail == null) {
      tail = head;
    }
    size++;
  }

  /**
   * Adds a new element to the end of the doubly linked list. This method creates
   * a new node with the specified value and updates the head and tail references
   * accordingly. If the list is empty, the new node becomes both the head and
   * tail of the list. If the list is not empty, the new node is linked to
   * the current tail, and the tail reference is updated to point to the new node.
   * The size of the list is incremented by one after the new node is added. This
   * operation has a time complexity of O(1) since it only involves updating a few
   * references and does not require traversing the list.
   *
   * @param value the value to be added to the end of the list
   */
  @Override
  public void addLast(T value) {
    Node<T> newNode = new Node<>(value);
    newNode.prev = tail;
    if (tail != null) {
      tail.next = newNode;
    }
    tail = newNode;
    if (head == null) {
      head = tail;
    }
    size++;
  }

  /**
   * Removes and returns the first element from the doubly linked list. This
   * method checks if the list is empty and throws a NoSuchElementException if it
   * is. If the list is not empty, it retrieves the value of the head node,
   * updates the head reference to point to the next node, and updates the
   * previous reference of the new head node to null. If the list becomes empty
   * after the removal, the tail reference is also set to null. The size of the
   * list is decremented by one after the node is removed. This operation has a
   * time complexity of O(1) since it only involves updating a few references and
   * does not require traversing the list.
   *
   * @throws NoSuchElementException if the list is empty when attempting to remove
   *                                the first element
   * @return the value of the removed first element
   */
  @Override
  public T removeFirst() {
    if (head == null) {
      throw new NoSuchElementException("List is empty");
    }

    T value = head.value;
    head = head.next;
    if (head == null) {
      tail = null;
    } else {
      head.prev = null;
    }
    size--;
    return value;
  }

  /**
   * Removes and returns the last element from the doubly linked list. This method
   * checks if the list is empty and throws a NoSuchElementException if it is. If
   * the list is not empty, it retrieves the value of the tail node, updates the
   * tail reference to point to the previous node, and updates the next
   * reference of the new tail node to null. If the list becomes empty after the
   * removal, the head reference is also set to null. The size of the list is
   * decremented by one after the node is removed.
   * This operation has a time complexity of O(1) since it only involves updating
   * a few references and does not require traversing the list.
   *
   * @throws NoSuchElementException if the list is empty when attempting to remove
   *                                the last element
   * @return the value of the removed last element
   */
  @Override
  public T removeLast() {
    if (tail == null) {
      throw new NoSuchElementException("List is empty");
    }

    T value = tail.value;
    tail = tail.prev;
    if (tail == null) {
      head = null;
    } else {
      tail.next = null;
    }
    size--;
    return value;
  }

  /**
   * Retrieves the element at the specified index in the doubly linked list. This
   * method first checks if the index is valid by calling the checkIndex method.
   * If the index is valid, it uses the nodeAt method to retrieve the node at the
   * specified index and returns the value stored in that node. The checkIndex
   * method ensures that the index is within the valid range for the list, and the
   * nodeAt method optimizes the retrieval of the node by determining whether to
   * start traversing from the head or the tail of the list based on the index's
   * position relative to the size of the list. This operation has a time
   * complexity of O(n) in the worst case, but it can be O(1) if the index is at
   * the beginning or end of the list, due to the optimization in the nodeAt
   * method.
   *
   * @throws IndexOutOfBoundsException if the index is out of range (index < 0 ||
   *                                   index >= size of the list)
   * @param index the index of the element to be retrieved, which must be a valid
   *              index within the bounds of the list
   * @return the value of the element at the specified index in the list
   */
  @Override
  public T get(int index) {
    checkIndex(index);
    return nodeAt(index).value;
  }

  /**
   * Checks if the specified value is present in the doubly linked list. This
   * method iterates through the list starting from the head node and compares
   * each node's value with the specified value using the equals method. If a
   * match is found, the method returns true. If the end of the list is reached
   * without finding a match, the method returns false.
   * This operation has a time complexity of O(n) in the worst case, as it may
   * require traversing the entire list to find the specified value or determine
   * that it is not present in the list.
   *
   * @param value the value to be checked for presence in the list
   * @return true if the specified value is present in the list, false otherwise
   */
  @Override
  public boolean contains(T value) {
    if (head.value.equals(value) || tail.value.equals(value)) {
      return true;
    }

    for (Node<T> currentNode = head.next; currentNode != null; currentNode = currentNode.next) {
      if (currentNode.value.equals(value)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns the number of elements in the doubly linked list. This method simply
   * returns the value of the size field, which is updated whenever elements are
   * added or removed from the list. The size field is maintained to provide an
   * efficient way to track the number of elements in the list without needing to
   * traverse the list to count the elements each time this method is called. This
   * operation has a time complexity of O(1) since it only involves returning the
   * value of the size field.
   *
   * @return the number of elements in the list
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Removes all elements from the doubly linked list, effectively clearing the
   * list. This method sets the head and tail references to null and resets the
   * size to 0. By setting the head and tail to null, all nodes in the list become
   * eligible for garbage collection, and the list is effectively emptied. This
   * operation has a time complexity of O(1) since it only involves updating a few
   * references and does not require traversing the list to remove each element
   * individually. After calling this method, the list will be empty, and any
   * subsequent calls to methods that access elements in the list (such as get,
   * removeFirst, or removeLast) will throw exceptions due to the list being
   * empty. It is important to ensure that the list is not accessed after it has
   * been cleared, unless new elements have been added to the list again.
   */
  @Override
  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }

  /**
   * Returns an iterator over the elements in the doubly linked list in proper
   * sequence. This method creates and returns an anonymous inner class that
   * implements the Iterator interface. The iterator maintains a reference to the
   * current node being iterated over, starting with the head of the list. The
   * hasNext method checks if there are more elements to iterate over by checking
   * if the current node is not null. The next method retrieves the value of the
   * current node, advances the current node reference to the next node in the
   * list, and returns the value. If the next method is called when there are no
   * more elements to iterate over (i.e., when the current node is null), it
   * throws a NoSuchElementException. This iterator allows users of the
   * DoublyLinkedList to traverse the list using enhanced for loops or any other
   * context where an iterator is required. The time complexity of iterating
   * through the list using this iterator is O(n) in the worst case, as it may
   * require traversing the entire list to access all elements. However, each call
   * to hasNext and next operates in O(1) time, as they only involve checking and
   * updating references without needing to traverse the list.
   *
   * @return an iterator over the elements in the list in proper sequence
   */
  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private Node<T> currentNode = head;

      @Override
      public boolean hasNext() {
        return currentNode != null;
      }

      @Override
      public T next() {
        if (currentNode == null) {
          throw new NoSuchElementException();
        }
        T value = currentNode.value;
        currentNode = currentNode.next;
        return value;
      }
    };
  }

  /**
   * Retrieves the node at the specified index in the doubly linked list. This
   * method
   * first checks if the index is valid by calling the checkIndex method. If the
   * index is valid, it determines whether to start traversing from the head or
   * the tail of the list based on the index's position relative to the size of
   * the list. If the index is in the first half of the list, it starts from the
   * head and traverses forward until it reaches the desired index. If the index
   * is in the second half of the list, it starts from the tail and traverses
   * backward until it reaches the desired index. This optimization allows for
   * faster access to nodes in the list, especially for larger lists, as it
   * minimizes the number of nodes that need to be traversed to reach a specific
   * index. The method returns the node at the specified index, which can then be
   * used to access the value stored in that node or to perform other operations
   * on the list.
   * This method is used internally by the DoublyLinkedList to efficiently access
   * nodes at specific indices, and it is not exposed to the users of the list. It
   * is a crucial part of the implementation that helps to ensure that operations
   * that require access to specific indices (such as getting an element at a
   * specific index) are performed efficiently.
   *
   * @param index the index of the node to be retrieved, which must be a valid
   *              index within the bounds of the list
   * @return the node at the specified index in the list
   */
  private Node<T> nodeAt(int index) {
    // optimización: desde head o tail
    if (index < (size / 2)) {
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
   * Checks if the provided index is within the valid range for the list. This
   * method is used internally by the DoublyLinkedList to ensure that operations
   * that require an index (such as getting an element at a specific index) are
   * performed with valid indices. If the index is less than 0 or greater than or
   * equal to the size of the list, an IndexOutOfBoundsException is thrown with a
   * message indicating the invalid index and the current size of the list. This
   * method helps to prevent errors and ensure that the list is accessed in a safe
   * manner.
   *
   * @param index the index to be checked for validity
   */
  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("index=" + index + ", size=" + size);
    }
  }

}
