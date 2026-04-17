package co.edu.udla.ed.contract;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.HashTable;

public abstract class AbstractHashTableContractTest {

  protected abstract HashTable<String, Integer> create();

  @Test
  void starts_empty() {
    var table = create();

    assertThat(table.isEmpty()).isTrue();
    assertThat(table.size()).isZero();
    assertThat(table.get("missing")).isNull();
    assertThat(table.remove("missing")).isNull();
  }

  @Test
  void put_get_contains_should_work() {
    var table = create();

    assertThat(table.put("A", 10)).isNull();
    assertThat(table.put("B", 20)).isNull();

    assertThat(table.size()).isEqualTo(2);
    assertThat(table.containsKey("A")).isTrue();
    assertThat(table.containsKey("B")).isTrue();
    assertThat(table.containsKey("C")).isFalse();
    assertThat(table.get("A")).isEqualTo(10);
    assertThat(table.get("B")).isEqualTo(20);
    assertThat(table.get("C")).isNull();
  }

  @Test
  void put_existing_key_should_overwrite_without_growing() {
    var table = create();

    assertThat(table.put("A", 10)).isNull();
    assertThat(table.put("A", 99)).isEqualTo(10);

    assertThat(table.size()).isEqualTo(1);
    assertThat(table.get("A")).isEqualTo(99);
  }

  @Test
  void remove_should_delete_entry() {
    var table = create();
    table.put("A", 10);
    table.put("B", 20);

    assertThat(table.remove("A")).isEqualTo(10);
    assertThat(table.remove("A")).isNull();
    assertThat(table.containsKey("A")).isFalse();
    assertThat(table.get("A")).isNull();
    assertThat(table.size()).isEqualTo(1);
  }

  @Test
  void clear_should_reset() {
    var table = create();
    table.put("A", 10);
    table.put("B", 20);

    table.clear();

    assertThat(table.isEmpty()).isTrue();
    assertThat(table.size()).isZero();
    assertThat(table.get("A")).isNull();
    assertThat(table.containsKey("B")).isFalse();
  }

}
