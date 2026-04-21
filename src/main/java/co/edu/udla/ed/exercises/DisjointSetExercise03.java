package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.UnionFindDisjointSet;

/**
 * Exercise 03 for the Disjoint Set series.
 *
 * <p><strong>Student task:</strong> Build a larger component with multiple unions and inspect the shared
 * representative.</p>
 */
public final class DisjointSetExercise03 {

  public String solveWithCustomIterator(UnionFindDisjointSet<String> set) {
    set.makeSet("A");
    set.makeSet("B");
    set.makeSet("C");
    set.makeSet("D");
    set.union("A", "B");
    set.union("C", "D");
    set.union("B", "C");
    return ExerciseSupport.format(
        ExerciseSupport.named("repA", set.find("A")),
        ExerciseSupport.named("repD", set.find("D")),
        ExerciseSupport.named("connected", set.connected("A", "D")));
  }

  public String solveWithJavaLoops(LinkedHashMap<String, String> parents) {
    ExerciseSupport.disjointSetMakeSet(parents, "A");
    ExerciseSupport.disjointSetMakeSet(parents, "B");
    ExerciseSupport.disjointSetMakeSet(parents, "C");
    ExerciseSupport.disjointSetMakeSet(parents, "D");
    ExerciseSupport.disjointSetUnion(parents, "A", "B");
    ExerciseSupport.disjointSetUnion(parents, "C", "D");
    ExerciseSupport.disjointSetUnion(parents, "B", "C");
    return ExerciseSupport.format(
        ExerciseSupport.named("repA", ExerciseSupport.disjointSetFind(parents, "A")),
        ExerciseSupport.named("repD", ExerciseSupport.disjointSetFind(parents, "D")),
        ExerciseSupport.named("connected", ExerciseSupport.disjointSetConnected(parents, "A", "D")));
  }

  public String solveWithStreams(LinkedHashMap<String, String> parents) {
    ExerciseSupport.disjointSetMakeSet(parents, "A");
    ExerciseSupport.disjointSetMakeSet(parents, "B");
    ExerciseSupport.disjointSetMakeSet(parents, "C");
    ExerciseSupport.disjointSetMakeSet(parents, "D");
    ExerciseSupport.disjointSetUnion(parents, "A", "B");
    ExerciseSupport.disjointSetUnion(parents, "C", "D");
    ExerciseSupport.disjointSetUnion(parents, "B", "C");
    return ExerciseSupport.format(
        ExerciseSupport.named("repA", ExerciseSupport.disjointSetFind(parents, "A")),
        ExerciseSupport.named("repD", ExerciseSupport.disjointSetFind(parents, "D")),
        ExerciseSupport.named("connected", ExerciseSupport.disjointSetConnected(parents, "A", "D")));
  }

}
