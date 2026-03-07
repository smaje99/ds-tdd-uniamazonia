package co.edu.udla.ed.contract;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.BinarySearchTree;

public abstract class AbstractBSTContractTest {

  protected abstract BinarySearchTree<Integer> create();

  @Test
  void starts_empty() {
    var bst = create();
    assertThat(bst.isEmpty()).isTrue();
    assertThat(bst.size()).isZero();
    assertThat(bst.height()).isZero();
    assertThat(bst.inOrder()).isEmpty();
  }

  @Test
  void insert_contains_inOrder_sorted() {
    var bst = create();
    bst.insert(5);
    bst.insert(2);
    bst.insert(8);
    bst.insert(1);
    bst.insert(3);

    assertThat(bst.contains(3)).isTrue();
    assertThat(bst.contains(7)).isFalse();

    assertThat(bst.inOrder()).containsExactly(1, 2, 3, 5, 8);
    assertThat(bst.size()).isEqualTo(5);
  }

  @Test
  void insert_duplicate_should_not_increase_size() {
    var bst = create();
    bst.insert(5);
    bst.insert(5);
    bst.insert(5);

    assertThat(bst.size()).isEqualTo(1);
    assertThat(bst.inOrder()).containsExactly(5);
  }

  @Test
  void remove_leaf_one_child_two_children() {
    var bst = create();
    // Árbol típico
    // 5
    // / \
    // 2 8
    // / \ /
    // 1 3 6
    bst.insert(5);
    bst.insert(2);
    bst.insert(8);
    bst.insert(1);
    bst.insert(3);
    bst.insert(6);

    // leaf
    assertThat(bst.remove(3)).isTrue();
    assertThat(bst.inOrder()).containsExactly(1, 2, 5, 6, 8);

    // one child (8 tiene hijo izquierdo 6)
    assertThat(bst.remove(8)).isTrue();
    assertThat(bst.inOrder()).containsExactly(1, 2, 5, 6);

    // two children (5 tiene 2 y 6)
    assertThat(bst.remove(5)).isTrue();
    assertThat(bst.inOrder()).containsExactly(1, 2, 6);

    // no existe
    assertThat(bst.remove(999)).isFalse();
  }

  @Test
  void clear_should_reset() {
    var bst = create();
    bst.insert(1);
    bst.insert(2);
    bst.clear();

    assertThat(bst.isEmpty()).isTrue();
    assertThat(bst.inOrder()).isEmpty();
  }

}
