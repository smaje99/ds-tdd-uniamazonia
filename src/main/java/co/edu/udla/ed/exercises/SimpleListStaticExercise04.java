package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.impl.scratch.StaticSimpleList;

public final class SimpleListStaticExercise04 {

  public String solveWithCustomIterator(StaticSimpleList<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addLast("C");
    list.addLast("D");
    list.addLast("E");
    list.addLast("F");
    list.addLast("G");
    list.addLast("H");
    list.addLast("I");
    list.addLast("J");
    list.addLast("K");
    list.addFirst("inicio-1");
    list.addFirst("inicio-2");
    return ExerciseSupport.snapshotWithIterator(list);
  }

  public String solveWithJavaLoops(ArrayList<String> list) {
    list.add("A");
    list.add("B");
    list.add("C");
    list.add("D");
    list.add("E");
    list.add("F");
    list.add("G");
    list.add("H");
    list.add("I");
    list.add("J");
    list.add("K");
    list.add(0, "inicio-1");
    list.add(0, "inicio-2");
    return ExerciseSupport.snapshotWithLoop(list);
  }

  public String solveWithStreams(ArrayList<String> list) {
    list.add("A");
    list.add("B");
    list.add("C");
    list.add("D");
    list.add("E");
    list.add("F");
    list.add("G");
    list.add("H");
    list.add("I");
    list.add("J");
    list.add("K");
    list.add(0, "inicio-1");
    list.add(0, "inicio-2");
    return ExerciseSupport.snapshotWithStreams(list);
  }

}
