package co.edu.udla.ed.exercises;

import org.junit.jupiter.api.Test;

public class AdjacencyListGraphExercise03Test {

  @Test
  void should_report_dfs_path_existence_and_shortest_path() {
    ExerciseAssertions.assertAllResults(new AdjacencyListGraphExercise03(),
        "dfs=[A, B, D, C, E]|hasPathAtoE=true|shortest=[A, B, D, E]");
  }

}