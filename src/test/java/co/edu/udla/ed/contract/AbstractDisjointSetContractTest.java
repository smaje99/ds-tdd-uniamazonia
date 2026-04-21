package co.edu.udla.ed.contract;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.DisjointSet;

public abstract class AbstractDisjointSetContractTest {

  protected abstract DisjointSet<String> create();

  @Test
  void starts_empty() {
    var set = create();

    assertThat(set.isEmpty()).isTrue();
    assertThat(set.size()).isZero();
    assertThat(set.setCount()).isZero();
  }

  @Test
  void makeSet_and_find_should_register_elements() {
    var set = create();
    set.makeSet("A");
    set.makeSet("B");
    set.makeSet("A");

    assertThat(set.size()).isEqualTo(2);
    assertThat(set.setCount()).isEqualTo(2);
    assertThat(set.find("A")).isEqualTo("A");
    assertThat(set.find("B")).isEqualTo("B");
  }

  @Test
  void union_and_connected_should_merge_components() {
    var set = create();
    set.makeSet("A");
    set.makeSet("B");
    set.makeSet("C");
    set.makeSet("D");

    set.union("A", "B");
    set.union("C", "D");
    set.union("B", "C");

    assertThat(set.connected("A", "D")).isTrue();
    assertThat(set.connected("A", "C")).isTrue();
    assertThat(set.setCount()).isEqualTo(1);
  }

  @Test
  void missing_elements_should_throw() {
    var set = create();
    set.makeSet("A");

    assertThatThrownBy(() -> set.find("Z")).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> set.union("A", "Z")).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> set.connected("A", "Z")).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void iterator_should_follow_insertion_order() {
    var set = create();
    set.makeSet("A");
    set.makeSet("B");
    set.makeSet("C");

    assertThat(set).containsExactly("A", "B", "C");
  }

  @Test
  void clear_should_reset() {
    var set = create();
    set.makeSet("A");
    set.makeSet("B");

    set.clear();

    assertThat(set.isEmpty()).isTrue();
    assertThat(set.setCount()).isZero();
  }

}
