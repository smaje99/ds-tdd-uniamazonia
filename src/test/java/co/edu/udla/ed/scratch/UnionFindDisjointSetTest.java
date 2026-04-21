package co.edu.udla.ed.scratch;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.api.DisjointSet;
import co.edu.udla.ed.contract.AbstractDisjointSetContractTest;
import co.edu.udla.ed.impl.scratch.UnionFindDisjointSet;

public class UnionFindDisjointSetTest extends AbstractDisjointSetContractTest {

  @Override
  protected DisjointSet<String> create() {
    return new UnionFindDisjointSet<>();
  }

  @Test
  void repeated_finds_should_keep_same_representative_after_compression() {
    UnionFindDisjointSet<String> set = new UnionFindDisjointSet<>();
    set.makeSet("A");
    set.makeSet("B");
    set.makeSet("C");
    set.union("A", "B");
    set.union("B", "C");

    String firstRepresentative = set.find("C");
    String secondRepresentative = set.find("C");

    assertThat(secondRepresentative).isEqualTo(firstRepresentative);
    assertThat(set.connected("A", "C")).isTrue();
  }

}
