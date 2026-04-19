package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class AdjacencyListGraphExercise05Test {

  @Test
  void should_use_domain_objects_in_the_graph() {
    ExerciseAssertions.assertAllResults(new AdjacencyListGraphExercise05(),
        "containsAna=true|bfs=[Ana#101, Luis#203, Mia#305, Eva#99, Leo#404]|shortest=[Ana#101, Luis#203, Eva#99, Leo#404]");
  }

}
