package co.edu.udla.ed.contract;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.BTree;

public abstract class AbstractBTreeContractTest {

  protected abstract BTree<Integer> create();

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
    for (int value : new int[]{10, 20, 5, 6, 12, 30, 7, 17}) {
      tree.insert(value);
    }

    assertThat(tree.contains(6)).isTrue();
    assertThat(tree.contains(99)).isFalse();
    assertThat(tree.inOrder()).containsExactly(5, 6, 7, 10, 12, 17, 20, 30);
    assertThat(tree.height()).isLessThanOrEqualTo(4);
  }

  @Test
  void duplicates_should_not_grow() {
    var tree = create();
    tree.insert(4);
    tree.insert(4);

    assertThat(tree.size()).isEqualTo(1);
  }

  @Test
  void remove_should_keep_sorted_order() {
    var tree = create();
    for (int value : new int[]{10, 20, 5, 6, 12, 30, 7, 17}) {
      tree.insert(value);
    }

    assertThat(tree.remove(6)).isTrue();
    assertThat(tree.remove(20)).isTrue();
    assertThat(tree.remove(999)).isFalse();
    assertThat(tree.inOrder()).containsExactly(5, 7, 10, 12, 17, 30);
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
