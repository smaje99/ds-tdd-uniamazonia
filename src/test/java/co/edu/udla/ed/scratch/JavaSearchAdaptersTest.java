package co.edu.udla.ed.scratch;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import co.edu.udla.ed.common.JavaSearchAdapters;

public class JavaSearchAdaptersTest {

  @Test
  void should_search_jdk_linear_and_ordered_structures() {
    ArrayList<Integer> values = new ArrayList<>(java.util.List.of(2, 4, 6, 8));
    TreeSet<Integer> tree = new TreeSet<>(java.util.List.of(8, 3, 10, 1, 6));

    assertThat(JavaSearchAdapters.binarySearch(values, 6, null).index()).isEqualTo(2);
    assertThat(JavaSearchAdapters.orderedTreeSearch(tree, 6).visited()).containsExactly(1, 3, 6);
  }

  @Test
  void should_search_jdk_hash_and_graph_structures() {
    LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
    map.put("Ana", 90);
    map.put("Luis", 85);
    LinkedHashMap<String, LinkedHashSet<String>> graph = new LinkedHashMap<>();
    addEdge(graph, "A", "B");
    addEdge(graph, "A", "C");
    addEdge(graph, "C", "E");

    assertThat(JavaSearchAdapters.keyValueSearch(map, "Luis").value()).isEqualTo(85);
    assertThat(JavaSearchAdapters.breadthFirstSearch(graph, "A", "E").path()).containsExactly("A", "C", "E");
  }

  private void addEdge(LinkedHashMap<String, LinkedHashSet<String>> graph, String from, String to) {
    graph.computeIfAbsent(from, ignored -> new LinkedHashSet<>());
    graph.computeIfAbsent(to, ignored -> new LinkedHashSet<>());
    graph.get(from).add(to);
    graph.get(to).add(from);
  }

}
