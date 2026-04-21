package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.UnionFindDisjointSet;

/**
 * Exercise 04 for the Disjoint Set series.
 *
 * <p><strong>Student task:</strong> Attempt to query a missing element and observe the expected exception.</p>
 */
public final class DisjointSetExercise04 {

  public String solveWithCustomIterator(UnionFindDisjointSet<String> set) {
    set.makeSet("A");
    set.find("Z");
    return "unreachable";
  }

  public String solveWithJavaLoops(LinkedHashMap<String, String> parents) {
    ExerciseSupport.disjointSetMakeSet(parents, "A");
    ExerciseSupport.disjointSetFind(parents, "Z");
    return "unreachable";
  }

  public String solveWithStreams(LinkedHashMap<String, String> parents) {
    ExerciseSupport.disjointSetMakeSet(parents, "A");
    ExerciseSupport.disjointSetFind(parents, "Z");
    return "unreachable";
  }

}
