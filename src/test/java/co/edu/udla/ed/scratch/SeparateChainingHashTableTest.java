package co.edu.udla.ed.scratch;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.HashTable;
import co.edu.udla.ed.contract.AbstractHashTableContractTest;
import co.edu.udla.ed.impl.scratch.SeparateChainingHashTable;

class SeparateChainingHashTableTest extends AbstractHashTableContractTest {

  private static final class BadHashKey {
    private final String id;

    private BadHashKey(String id) {
      this.id = id;
    }

    @Override
    public int hashCode() {
      return 1;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (!(obj instanceof BadHashKey other)) {
        return false;
      }
      return id.equals(other.id);
    }
  }

  @Override
  protected HashTable<String, Integer> create() {
    return new SeparateChainingHashTable<>();
  }

  @Test
  void collisions_should_keep_all_values_accessible() {
    SeparateChainingHashTable<BadHashKey, Integer> table = new SeparateChainingHashTable<>(2);

    BadHashKey a = new BadHashKey("A");
    BadHashKey b = new BadHashKey("B");
    BadHashKey c = new BadHashKey("C");

    table.put(a, 10);
    table.put(b, 20);
    table.put(c, 30);

    assertThat(table.get(a)).isEqualTo(10);
    assertThat(table.get(b)).isEqualTo(20);
    assertThat(table.get(c)).isEqualTo(30);
    assertThat(table.remove(b)).isEqualTo(20);
    assertThat(table.get(a)).isEqualTo(10);
    assertThat(table.get(c)).isEqualTo(30);
  }

  @Test
  void resizing_should_preserve_entries() {
    SeparateChainingHashTable<Integer, String> table = new SeparateChainingHashTable<>(2);

    for (int i = 0; i < 100; i++) {
      table.put(i, "V" + i);
    }

    assertThat(table.size()).isEqualTo(100);
    for (int i = 0; i < 100; i++) {
      assertThat(table.get(i)).isEqualTo("V" + i);
    }
  }

}
