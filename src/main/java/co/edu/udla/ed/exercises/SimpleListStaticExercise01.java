package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.impl.scratch.StaticSimpleList;

public final class SimpleListStaticExercise01 {

  public String solveWithCustomIterator(StaticSimpleList<String> list) {
    list.addLast("B");
    list.addFirst("A");
    list.addLast("C");
    list.addFirst("inicio");
    return ExerciseSupport.snapshotWithIterator(list);
  }

  public String solveWithJavaLoops(ArrayList<String> list) {
    list.add("B");
    list.add(0, "A");
    list.add("C");
    list.add(0, "inicio");
    return ExerciseSupport.snapshotWithLoop(list);
  }

  public String solveWithStreams(ArrayList<String> list) {
    list.add("B");
    list.add(0, "A");
    list.add("C");
    list.add(0, "inicio");
    return ExerciseSupport.snapshotWithStreams(list);
  }

}
