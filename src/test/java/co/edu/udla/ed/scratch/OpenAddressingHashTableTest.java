package co.edu.udla.ed.scratch;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.HashTable;
import co.edu.udla.ed.contract.AbstractHashTableContractTest;
import co.edu.udla.ed.impl.scratch.OpenAddressingHashTable;

class OpenAddressingHashTableTest extends AbstractHashTableContractTest {

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
      return obj instanceof BadHashKey other && id.equals(other.id);
    }
  }

  @Override
  protected HashTable<String, Integer> create() {
    return new OpenAddressingHashTable<>();
  }

  @Test
  void collisions_tombstones_and_resize_should_preserve_entries() {
    OpenAddressingHashTable<BadHashKey, Integer> table = new OpenAddressingHashTable<>(4);
    BadHashKey a = new BadHashKey("A");
    BadHashKey b = new BadHashKey("B");
    BadHashKey c = new BadHashKey("C");

    table.put(a, 10);
    table.put(b, 20);
    table.put(c, 30);

    assertThat(table.remove(b)).isEqualTo(20);
    table.put(new BadHashKey("D"), 40);

    assertThat(table.get(a)).isEqualTo(10);
    assertThat(table.get(c)).isEqualTo(30);
    assertThat(table.size()).isEqualTo(3);
  }

  @Test
  void iterator_should_follow_slot_order() {
    OpenAddressingHashTable<Integer, String> table = new OpenAddressingHashTable<>(8);
    table.put(10, "A");
    table.put(18, "B");
    table.put(26, "C");

    ArrayList<Integer> keys = new ArrayList<>();
    for (HashTable.Entry<Integer, String> entry : table) {
      keys.add(entry.key());
    }

    assertThat(keys).containsExactly(10, 18, 26);
  }

}
