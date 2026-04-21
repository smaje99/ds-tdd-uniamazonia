package co.edu.udla.ed.scratch;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.impl.scratch.SeparateChainingHashTable;
import co.edu.udla.ed.impl.scratch.search.HashTableKeySearch;

public class HashTableKeySearchTest {

  @Test
  void should_search_existing_and_missing_keys() {
    SeparateChainingHashTable<String, Integer> table = new SeparateChainingHashTable<>();
    table.put("Ana", 90);
    table.put("Luis", 85);

    var search = new HashTableKeySearch<String, Integer>();

    assertThat(search.search(table, "Luis").found()).isTrue();
    assertThat(search.search(table, "Luis").value()).isEqualTo(85);
    assertThat(search.search(table, "Eva").found()).isFalse();
  }

}
