package co.edu.udla.ed.impl.scratch;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

import co.edu.udla.ed.api.DisjointSet;

/**
 * Disjoint-set implementation with path compression and union by rank.
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

  @Override
  public void makeSet(T value) {
    if (nodes.containsKey(value)) {
      return;
    }
    nodes.put(value, new Node<>(value));
    setCount++;
  }

  @Override
  public T find(T value) {
    requirePresent(value);
    Node<T> node = nodes.get(value);
    if (!node.parent.equals(value)) {
      node.parent = find(node.parent);
    }
    return node.parent;
  }

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

  @Override
  public boolean connected(T a, T b) {
    return find(a).equals(find(b));
  }

  @Override
  public int setCount() {
    return setCount;
  }

  @Override
  public int size() {
    return nodes.size();
  }

  @Override
  public void clear() {
    nodes.clear();
    setCount = 0;
  }

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
