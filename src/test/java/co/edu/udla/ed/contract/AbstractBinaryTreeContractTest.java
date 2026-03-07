package co.edu.udla.ed.contract;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.BinaryTree;

public abstract class AbstractBinaryTreeContractTest {

  protected abstract BinaryTree<String> create();

  @Test
  void empty_tree_properties() {
    var t = create();
    assertThat(t.isEmpty()).isTrue();
    assertThat(t.size()).isZero();
    assertThat(t.height()).isZero();
    assertThat(t.preOrder()).isEmpty();
    assertThat(t.levelOrder()).isEmpty();
  }

  @Test
  void traversals_size_height_should_match() {
    var t = create();

    var a = t.makeRoot("A");
    var b = t.attachLeft(a, "B");
    var c = t.attachRight(a, "C");
    t.attachLeft(b, "D");
    t.attachRight(b, "E");
    t.attachRight(c, "F");

    assertThat(t.size()).isEqualTo(6);
    assertThat(t.height()).isEqualTo(3);

    assertThat(t.preOrder()).containsExactly("A", "B", "D", "E", "C", "F");
    assertThat(t.inOrder()).containsExactly("D", "B", "E", "A", "C", "F");
    assertThat(t.postOrder()).containsExactly("D", "E", "B", "F", "C", "A");
    assertThat(t.levelOrder()).containsExactly("A", "B", "C", "D", "E", "F");
  }

  @Test
  void attach_left_right_twice_should_throw() {
    var t = create();
    var a = t.makeRoot("A");
    t.attachLeft(a, "B");

    assertThatThrownBy(() -> t.attachLeft(a, "X"))
        .isInstanceOf(IllegalStateException.class);
  }

  @Test
  void clear_should_reset() {
    var t = create();
    t.makeRoot("A");
    t.clear();

    assertThat(t.isEmpty()).isTrue();
    assertThat(t.size()).isZero();
    assertThat(t.height()).isZero();
  }

}
