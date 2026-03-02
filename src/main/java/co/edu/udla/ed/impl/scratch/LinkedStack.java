package co.edu.udla.ed.impl.scratch;

import java.util.NoSuchElementException;

import co.edu.udla.ed.api.Stack;

/**
 * LinkedStack is a stack implementation that uses a linked list to store its
 * elements. It provides methods to push, pop, peek, check the size, and clear
 * the stack. The stack follows the Last-In-First-Out (LIFO) principle, meaning
 * that the last element pushed onto the stack will be the first one to be popped
 * off. This implementation allows for dynamic resizing of the stack as elements
 * are added or removed.
 *
 * @param <T> the type of elements stored in the stack
 */
public class LinkedStack<T> implements Stack<T> {

  /**
   * Node class represents a single node in the linked list. It contains a value
   * and a reference to the next node. The value is final, meaning it cannot be
   * changed once assigned. The next reference can be updated to point to the next
   * node in the stack. This class is private and static, meaning it can only be
   * accessed within the LinkedStack class and does not require an instance of
   * LinkedStack to be created.
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

  private Node<T> top;
  private int size;

  /**
   * Pushes a value onto the top of the stack. A new node is created with the
   * given value, and it becomes the new top of the stack. The next reference of
   * the new node is set to the previous top node, and the size of the stack is
   * incremented by one. If the stack was previously empty, the new node will be
   * the only node in the stack. This operation has a time complexity of O(1)
   * since it only involves updating a few references and incrementing the size
   * counter.
   *
   * @param value the value to be pushed onto the stack
   */
  @Override
  public void push(T value) {
    Node<T> newNode = new Node<>(value);
    newNode.next = top;
    top = newNode;
    size++;
  }

  /**
   * Pops a value from the top of the stack. The value of the top node is
   * retrieved, and the top reference is updated to point to the next node in the
   * stack. The size of the stack is decremented by one. If the stack is empty,
   * a NoSuchElementException is thrown. This operation has a time complexity of
   * O(1) since it only involves updating a few references and decrementing the
   * size counter.
   *
   * @return the value popped from the top of the stack
   * @throws NoSuchElementException if the stack is empty
   */
  @Override
  public T pop() {
    if (top == null) {
      throw new NoSuchElementException("Stack is empty.");
    }
    T value = top.value;
    top = top.next;
    size--;
    return value;
  }

  /**
   * Peeks at the value on the top of the stack without removing it. The value of
   * the top node is retrieved and returned. If the stack is empty, a
   * NoSuchElementException is thrown. This operation has a time complexity of
   * O(1) since it only involves retrieving the value from the top node.
   *
   * @return the value on the top of the stack
   * @throws NoSuchElementException if the stack is empty
   */
  @Override
  public T peek() {
    if (top == null) {
      throw new NoSuchElementException("Stack is empty.");
    }
    return top.value;
  }

  /**
   * Returns the number of elements in the stack. This operation has a time
   * complexity of O(1) since it only involves returning the value of the size
   * field.
   *
   * @return the number of elements in the stack
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Clears the stack by setting the top reference to null and resetting the size
   * to zero. This effectively removes all elements from the stack. This operation
   * has a time complexity of O(1) since it only involves updating a few references
   * and resetting the size counter.
   */
  @Override
  public void clear() {
    top = null;
    size = 0;
  }

}
