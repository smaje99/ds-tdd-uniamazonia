package co.edu.udla.ed.scratch;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.impl.scratch.UnionFindDisjointSet;
import co.edu.udla.ed.impl.scratch.search.ConnectivitySearch;
import co.edu.udla.ed.impl.scratch.search.RepresentativeSearch;

public class DisjointSetSearchTest {

  @Test
  void should_search_representatives_and_connectivity() {
    UnionFindDisjointSet<String> set = new UnionFindDisjointSet<>();
    set.makeSet("A");
    set.makeSet("B");
    set.makeSet("C");
    set.union("A", "B");

    var representative = new RepresentativeSearch<String>().search(set, "B");

    assertThat(representative.found()).isTrue();
    assertThat(representative.representative()).isEqualTo(set.find("A"));
    assertThat(new RepresentativeSearch<String>().search(set, "Z").found()).isFalse();
    assertThat(new ConnectivitySearch<String>().connected(set, "A", "B")).isTrue();
    assertThat(new ConnectivitySearch<String>().connected(set, "A", "C")).isFalse();
  }

}
