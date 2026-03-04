package co.edu.udla.ed.impl.scratch;

import java.util.NoSuchElementException;

import co.edu.udla.ed.api.Queue;

/**
 * LinkedQueue is a queue implementation that uses a linked list structure to store
 * elements. It maintains references to the head and tail nodes of the list, as
 * well as a size variable to track the number of elements in the queue. The
 * enqueue operation adds new nodes to the tail of the list, while the dequeue
 * operation removes nodes from the head of the list. This implementation allows
 * for efficient enqueue and dequeue operations with a time complexity of O(1) for
 * both operations, regardless of the number of elements in the queue.
 *
 * @param <T> the type of elements held in this queue
 */
public class LinkedQueue<T> implements Queue<T> {

  /**
   * Node is a private static inner class that represents an individual element in
   * the linked queue. Each node contains a value of type T and a reference to the
   * next node in the queue. This structure allows for efficient enqueue and
   * dequeue operations, as nodes can be easily added or removed without the need
   * for shifting elements, as in an array-based implementation. The Node class is
   * designed to be simple and efficient, with a constructor that initializes the
   * value and sets the next reference to null.
   *
   * @param <T> the type of value stored in the node
   */
  private static class Node<T> {
    T value;
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
   * Adds the specified value to the rear of the queue. The method creates a new
   * node with the given value and updates the tail reference to point to this new
   * node. If the queue is empty, both head and tail references are set to the new
   * node. The size of the queue is incremented by one. This operation has a time
   * complexity of O(1) since it involves only a few pointer updates regardless of
   * the number of elements in the queue.
   *
   * @param value the value to be added to the rear of the queue
   */
  @Override
  public void enqueue(T value) {
    Node<T> newNode = new Node<>(value);
    if (tail == null) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    size++;
  }

  /**
   * Removes and returns the value at the front of the queue. If the queue is
   * empty, it throws a NoSuchElementException. The method retrieves the value at
   * the head node, updates the head reference to point to the next node, and
   * decrements the size of the queue. If the queue becomes empty after this
   * operation, the tail reference is also set to null. This operation has a time
   * complexity of O(1) since it involves only a few pointer updates regardless of
   * the number of elements in the queue.
   *
   * @return the value at the front of the queue
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public T dequeue() {
    if (head == null)
      throw new NoSuchElementException("Queue is empty");

    T value = head.value;
    head = head.next;
    size--;
    if (size == 0)
      tail = null;
    return value;
  }

  /**
   * Returns the value at the front of the queue without removing it. If the queue
   * is empty, it throws a NoSuchElementException. The method retrieves the value
   * at the head node and returns it without modifying the queue's state. This
   * operation has a time complexity of O(1) since it involves only a single
   * pointer access regardless of the number of elements in the queue.
   *
   * @return the value at the front of the queue
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public T peek() {
    if (head == null)
      throw new NoSuchElementException("Queue is empty");

    return head.value;
  }

  /**
   * Returns the number of elements currently in the queue. This method simply
   * returns the value of the size variable, which is updated during enqueue and
   * dequeue operations. The time complexity of this operation is O(1) since it
   * involves only a single variable access regardless of the number of elements
   * in the queue.
   *
   * @return the number of elements in the queue
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Clears the queue by resetting the head and tail references to null and
   * setting the size to zero. This effectively removes all elements from the
   * queue and allows for garbage collection of the nodes. The operation has a
   * time complexity of O(1) since it involves only a few pointer updates
   * regardless of the number of elements in the queue.
   */
  @Override
  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }

}
