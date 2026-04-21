package co.edu.udla.ed.api;

/**
 * A disjoint-set structure tracks a partition of elements into non-overlapping
 * sets and supports efficient union/find operations.
 *
 * @param <T> the element type
 */
public interface DisjointSet<T> extends Iterable<T> {

  void makeSet(T value);

  T find(T value);

  void union(T a, T b);

  boolean connected(T a, T b);

  int setCount();

  int size();

  default boolean isEmpty() {
    return size() == 0;
  }

  void clear();

}
