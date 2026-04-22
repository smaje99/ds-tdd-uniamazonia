package co.edu.udla.ed.impl.scratch;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

import co.edu.udla.ed.api.DisjointSet;

/**
 * Disjoint-set implementation with path compression and union by rank.
 *
 * <p>Each value maps to a node that stores its parent representative and rank.
 * The structure partitions values into equivalence classes, making repeated
 * connectivity queries very close to constant time in practice.</p>
 *
 * @param <T> the element type
 */
public class UnionFindDisjointSet<T> implements DisjointSet<T> {

  private static final class Node<T> {
    private T parent;
    private int rank;

    private Node(T parent) {
      this.parent = parent;
      this.rank = 0;
    }
  }

  private final LinkedHashMap<T, Node<T>> nodes = new LinkedHashMap<>();
  private int setCount = 0;

  /**
   * Creates a singleton set for a value that is not already present.
   *
   * @param value value to register
   * @implNote Average time complexity is {@code O(1)}.
   */
  @Override
  public void makeSet(T value) {
    if (nodes.containsKey(value)) {
      return;
    }
    nodes.put(value, new Node<>(value));
    setCount++;
  }

  /**
   * Finds the representative of the set containing {@code value}.
   *
   * @param value value to locate
   * @return the current representative
   * @throws IllegalArgumentException if {@code value} is not present
   * @implNote Uses path compression; amortized time is effectively
   *           {@code O(alpha(n))}.
   */
  @Override
  public T find(T value) {
    requirePresent(value);
    Node<T> node = nodes.get(value);
    if (!node.parent.equals(value)) {
      node.parent = find(node.parent);
    }
    return node.parent;
  }

  /**
   * Merges the sets that contain {@code a} and {@code b}.
   *
   * @param a first value
   * @param b second value
   * @throws IllegalArgumentException if either value is absent
   * @implNote Uses union by rank with amortized {@code O(alpha(n))} time.
   */
  @Override
  public void union(T a, T b) {
    T rootA = find(a);
    T rootB = find(b);
    if (rootA.equals(rootB)) {
      return;
    }

    Node<T> nodeA = nodes.get(rootA);
    Node<T> nodeB = nodes.get(rootB);
    if (nodeA.rank < nodeB.rank) {
      nodeA.parent = rootB;
    } else if (nodeA.rank > nodeB.rank) {
      nodeB.parent = rootA;
    } else {
      nodeB.parent = rootA;
      nodeA.rank++;
    }
    setCount--;
  }

  /**
   * Checks whether two values belong to the same set.
   *
   * @param a first value
   * @param b second value
   * @return {@code true} when both values have the same representative
   */
  @Override
  public boolean connected(T a, T b) {
    return find(a).equals(find(b));
  }

  /**
   * Returns the number of disjoint sets currently represented.
   *
   * @return set count
   */
  @Override
  public int setCount() {
    return setCount;
  }

  /**
   * Returns the number of registered values.
   *
   * @return element count
   */
  @Override
  public int size() {
    return nodes.size();
  }

  /**
   * Removes all values and sets.
   */
  @Override
  public void clear() {
    nodes.clear();
    setCount = 0;
  }

  /**
   * Iterates over values in insertion order.
   *
   * @return an iterator over registered values
   */
  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private final Iterator<T> delegate = nodes.keySet().iterator();

      @Override
      public boolean hasNext() {
        return delegate.hasNext();
      }

      @Override
      public T next() {
        if (!hasNext()) {
          throw new NoSuchElementException("Disjoint-set iterator exhausted.");
        }
        return delegate.next();
      }
    };
  }

  private void requirePresent(T value) {
    if (!nodes.containsKey(value)) {
      throw new IllegalArgumentException("Element does not exist in the disjoint set: " + value);
    }
  }
}
