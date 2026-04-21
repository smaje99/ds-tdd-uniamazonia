package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.UnionFindDisjointSet;

/**
 * Exercise 05 for the Disjoint Set series.
 *
 * <p><strong>Student task:</strong> Clear the structure, rebuild a small partition, and report the final state.</p>
 */
public final class DisjointSetExercise05 {

  public String solveWithCustomIterator(UnionFindDisjointSet<String> set) {
    set.makeSet("A");
    set.makeSet("B");
    set.clear();
    set.makeSet("C");
    set.makeSet("D");
    set.union("C", "D");
    return ExerciseSupport.format(
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(set)),
        ExerciseSupport.named("sets", set.setCount()),
        ExerciseSupport.named("connected", set.connected("C", "D")));
  }

  public String solveWithJavaLoops(LinkedHashMap<String, String> parents) {
    ExerciseSupport.disjointSetMakeSet(parents, "A");
    ExerciseSupport.disjointSetMakeSet(parents, "B");
    parents.clear();
    ExerciseSupport.disjointSetMakeSet(parents, "C");
    ExerciseSupport.disjointSetMakeSet(parents, "D");
    ExerciseSupport.disjointSetUnion(parents, "C", "D");
    return ExerciseSupport.format(
        ExerciseSupport.named("size", parents.size()),
        ExerciseSupport.named("sets", ExerciseSupport.disjointSetCount(parents)),
        ExerciseSupport.named("connected", ExerciseSupport.disjointSetConnected(parents, "C", "D")));
  }

  public String solveWithStreams(LinkedHashMap<String, String> parents) {
    ExerciseSupport.disjointSetMakeSet(parents, "A");
    ExerciseSupport.disjointSetMakeSet(parents, "B");
    parents.clear();
    ExerciseSupport.disjointSetMakeSet(parents, "C");
    ExerciseSupport.disjointSetMakeSet(parents, "D");
    ExerciseSupport.disjointSetUnion(parents, "C", "D");
    return ExerciseSupport.format(
        ExerciseSupport.named("size", parents.keySet().stream().count()),
        ExerciseSupport.named("sets", ExerciseSupport.disjointSetCount(parents)),
        ExerciseSupport.named("connected", ExerciseSupport.disjointSetConnected(parents, "C", "D")));
  }

}
