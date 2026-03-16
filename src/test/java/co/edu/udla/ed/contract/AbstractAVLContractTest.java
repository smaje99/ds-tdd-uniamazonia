package co.edu.udla.ed.contract;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.AVLTree;

public abstract class AbstractAVLContractTest {

  protected abstract AVLTree<Integer> create();

  @Test
  void starts_empty() {
    var avl = create();
    assertThat(avl.isEmpty()).isTrue();
    assertThat(avl.size()).isZero();
    assertThat(avl.height()).isZero();
    assertThat(avl.inOrder()).isEmpty();
  }

  @Test
  void insert_should_keep_sorted_inOrder_and_contains() {
    var avl = create();
    avl.insert(5);
    avl.insert(2);
    avl.insert(8);
    avl.insert(1);
    avl.insert(3);
    avl.insert(6);
    avl.insert(9);

    assertThat(avl.contains(3)).isTrue();
    assertThat(avl.contains(7)).isFalse();
    assertThat(avl.inOrder()).containsExactly(1, 2, 3, 5, 6, 8, 9);
    assertThat(avl.size()).isEqualTo(7);
  }

  @Test
  void insert_duplicate_should_not_increase_size() {
    var avl = create();
    avl.insert(10);
    avl.insert(10);
    avl.insert(10);

    assertThat(avl.size()).isEqualTo(1);
    assertThat(avl.inOrder()).containsExactly(10);
  }

  @Test
  void rotations_LL_RR_LR_RL_should_work() {
    // LL: 30,20,10
    var ll = create();
    ll.insert(30); ll.insert(20); ll.insert(10);
    assertThat(ll.inOrder()).containsExactly(10, 20, 30);
    assertThat(ll.height()).isLessThanOrEqualTo(2);

    // RR: 10,20,30
    var rr = create();
    rr.insert(10); rr.insert(20); rr.insert(30);
    assertThat(rr.inOrder()).containsExactly(10, 20, 30);
    assertThat(rr.height()).isLessThanOrEqualTo(2);

    // LR: 30,10,20
    var lr = create();
    lr.insert(30); lr.insert(10); lr.insert(20);
    assertThat(lr.inOrder()).containsExactly(10, 20, 30);
    assertThat(lr.height()).isLessThanOrEqualTo(2);

    // RL: 10,30,20
    var rl = create();
    rl.insert(10); rl.insert(30); rl.insert(20);
    assertThat(rl.inOrder()).containsExactly(10, 20, 30);
    assertThat(rl.height()).isLessThanOrEqualTo(2);
  }

  @Test
  void remove_should_keep_sorted_and_balanced_height_reasonable() {
    var avl = create();
    int[] values = {50, 20, 70, 10, 30, 60, 80, 25, 35, 65};
    for (int v : values) avl.insert(v);

    assertThat(avl.inOrder()).containsExactly(10, 20, 25, 30, 35, 50, 60, 65, 70, 80);

    // remove leaf
    assertThat(avl.remove(10)).isTrue();
    assertThat(avl.inOrder()).doesNotContain(10);

    // remove node with one child (por cómo queda, puede variar; validamos solo orden)
    assertThat(avl.remove(80)).isTrue();

    // remove node with two children
    assertThat(avl.remove(50)).isTrue();

    assertThat(avl.contains(50)).isFalse();

    // el árbol debería seguir relativamente balanceado:
    // para ~7 nodos, altura típica <= 4
    assertThat(avl.height()).isLessThanOrEqualTo(4);

    // si no existe
    assertThat(avl.remove(999)).isFalse();
  }

  @Test
  void clear_should_reset() {
    var avl = create();
    avl.insert(1);
    avl.insert(2);
    avl.clear();

    assertThat(avl.isEmpty()).isTrue();
    assertThat(avl.size()).isZero();
    assertThat(avl.height()).isZero();
    assertThat(avl.inOrder()).isEmpty();
  }

}
