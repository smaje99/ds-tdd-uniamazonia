package co.edu.udla.ed.contract;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.RedBlackTree;

public abstract class AbstractRedBlackTreeContractTest {

  protected abstract RedBlackTree<Integer> create();

  @Test
  void starts_empty() {
    var tree = create();
    assertThat(tree.isEmpty()).isTrue();
    assertThat(tree.size()).isZero();
    assertThat(tree.height()).isZero();
    assertThat(tree.inOrder()).isEmpty();
  }

  @Test
  void insert_contains_and_inOrder_should_work() {
    var tree = create();
    for (int value : new int[]{5, 2, 8, 1, 3, 7, 9}) {
      tree.insert(value);
    }

    assertThat(tree.contains(3)).isTrue();
    assertThat(tree.contains(6)).isFalse();
    assertThat(tree.inOrder()).containsExactly(1, 2, 3, 5, 7, 8, 9);
    assertThat(tree.height()).isLessThanOrEqualTo(4);
  }

  @Test
  void duplicate_insert_should_not_grow() {
    var tree = create();
    tree.insert(10);
    tree.insert(10);

    assertThat(tree.size()).isEqualTo(1);
    assertThat(tree.inOrder()).containsExactly(10);
  }

  @Test
  void remove_should_keep_sorted_order() {
    var tree = create();
    for (int value : new int[]{10, 5, 15, 3, 7, 12, 18}) {
      tree.insert(value);
    }

    assertThat(tree.remove(3)).isTrue();
    assertThat(tree.remove(10)).isTrue();
    assertThat(tree.remove(999)).isFalse();
    assertThat(tree.inOrder()).containsExactly(5, 7, 12, 15, 18);
    assertThat(tree.height()).isLessThanOrEqualTo(4);
  }

  @Test
  void clear_and_iterable_should_work() {
    var tree = create();
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);

    assertThat(tree.inOrderIterable()).containsExactly(1, 2, 3);
    tree.clear();
    assertThat(tree.isEmpty()).isTrue();
  }

}
