package co.edu.udla.ed.scratch;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.impl.scratch.LinkedBinarySearchTree;
import co.edu.udla.ed.impl.scratch.search.OrderedTreeSearch;

public class OrderedTreeSearchTest {

  @Test
  void should_report_found_state_and_observable_visited_values() {
    LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<>();
    tree.insert(8);
    tree.insert(3);
    tree.insert(10);
    tree.insert(1);
    tree.insert(6);

    var result = new OrderedTreeSearch<Integer>().search(tree, 6);

    assertThat(result.found()).isTrue();
    assertThat(result.visited()).containsExactly(1, 3, 6);
  }

  @Test
  void should_stop_after_passing_missing_target() {
    LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<>();
    tree.insert(2);
    tree.insert(4);
    tree.insert(8);

    var result = new OrderedTreeSearch<Integer>().search(tree, 5);

    assertThat(result.found()).isFalse();
    assertThat(result.visited()).containsExactly(2, 4, 8);
  }

}
