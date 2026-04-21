package co.edu.udla.ed.exercises;

import java.util.LinkedHashMap;

import co.edu.udla.ed.impl.scratch.UnionFindDisjointSet;

/**
 * Exercise 01 for the Disjoint Set series.
 *
 * <p><strong>Student task:</strong> Register independent elements and report the number of elements, the number of
 * sets, and the representative of one element.</p>
 */
public final class DisjointSetExercise01 {

  public String solveWithCustomIterator(UnionFindDisjointSet<String> set) {
    set.makeSet("A");
    set.makeSet("B");
    set.makeSet("C");
    return ExerciseSupport.format(
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(set)),
        ExerciseSupport.named("sets", set.setCount()),
        ExerciseSupport.named("findA", set.find("A")));
  }

  public String solveWithJavaLoops(LinkedHashMap<String, String> parents) {
    ExerciseSupport.disjointSetMakeSet(parents, "A");
    ExerciseSupport.disjointSetMakeSet(parents, "B");
    ExerciseSupport.disjointSetMakeSet(parents, "C");
    return ExerciseSupport.format(
        ExerciseSupport.named("size", parents.size()),
        ExerciseSupport.named("sets", ExerciseSupport.disjointSetCount(parents)),
        ExerciseSupport.named("findA", ExerciseSupport.disjointSetFind(parents, "A")));
  }

  public String solveWithStreams(LinkedHashMap<String, String> parents) {
    ExerciseSupport.disjointSetMakeSet(parents, "A");
    ExerciseSupport.disjointSetMakeSet(parents, "B");
    ExerciseSupport.disjointSetMakeSet(parents, "C");
    return ExerciseSupport.format(
        ExerciseSupport.named("size", parents.keySet().stream().count()),
        ExerciseSupport.named("sets", ExerciseSupport.disjointSetCount(parents)),
        ExerciseSupport.named("findA", ExerciseSupport.disjointSetFind(parents, "A")));
  }

}
