package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.UnionFindDisjointSet;

/**
 * Exercise 02 for the Disjoint Set series.
 *
 * <p><strong>Student task:</strong> Merge some sets and report connectivity information together with the remaining
 * number of components.</p>
 */
public final class DisjointSetExercise02 {

  public String solveWithCustomIterator(UnionFindDisjointSet<String> set) {
    set.makeSet("A");
    set.makeSet("B");
    set.makeSet("C");
    set.union("A", "B");
    return ExerciseSupport.format(
        ExerciseSupport.named("sets", set.setCount()),
        ExerciseSupport.named("AB", set.connected("A", "B")),
        ExerciseSupport.named("AC", set.connected("A", "C")));
  }

  public String solveWithJavaLoops(LinkedHashMap<String, String> parents) {
    ExerciseSupport.disjointSetMakeSet(parents, "A");
    ExerciseSupport.disjointSetMakeSet(parents, "B");
    ExerciseSupport.disjointSetMakeSet(parents, "C");
    ExerciseSupport.disjointSetUnion(parents, "A", "B");
    return ExerciseSupport.format(
        ExerciseSupport.named("sets", ExerciseSupport.disjointSetCount(parents)),
        ExerciseSupport.named("AB", ExerciseSupport.disjointSetConnected(parents, "A", "B")),
        ExerciseSupport.named("AC", ExerciseSupport.disjointSetConnected(parents, "A", "C")));
  }

  public String solveWithStreams(LinkedHashMap<String, String> parents) {
    ExerciseSupport.disjointSetMakeSet(parents, "A");
    ExerciseSupport.disjointSetMakeSet(parents, "B");
    ExerciseSupport.disjointSetMakeSet(parents, "C");
    ExerciseSupport.disjointSetUnion(parents, "A", "B");
    return ExerciseSupport.format(
        ExerciseSupport.named("sets", ExerciseSupport.disjointSetCount(parents)),
        ExerciseSupport.named("AB", ExerciseSupport.disjointSetConnected(parents, "A", "B")),
        ExerciseSupport.named("AC", ExerciseSupport.disjointSetConnected(parents, "A", "C")));
  }

}
