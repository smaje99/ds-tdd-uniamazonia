package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.impl.scratch.StaticSimpleList;

public final class SimpleListStaticExercise02 {

  public String solveWithCustomIterator(StaticSimpleList<String> list) {
    list.addLast("uno");
    list.addLast("dos");
    list.addLast("tres");
    list.addLast("cuatro");
    String removedFirst = list.removeFirst();
    String removedLast = list.removeLast();
    return ExerciseSupport.format(
        ExerciseSupport.named("removedFirst", removedFirst),
        ExerciseSupport.named("removedLast", removedLast),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithIterator(list)));
  }

  public String solveWithJavaLoops(ArrayList<String> list) {
    list.add("uno");
    list.add("dos");
    list.add("tres");
    list.add("cuatro");
    String removedFirst = list.remove(0);
    String removedLast = list.remove(list.size() - 1);
    return ExerciseSupport.format(
        ExerciseSupport.named("removedFirst", removedFirst),
        ExerciseSupport.named("removedLast", removedLast),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithLoop(list)));
  }

  public String solveWithStreams(ArrayList<String> list) {
    list.add("uno");
    list.add("dos");
    list.add("tres");
    list.add("cuatro");
    String removedFirst = list.remove(0);
    String removedLast = list.remove(list.size() - 1);
    return ExerciseSupport.format(
        ExerciseSupport.named("removedFirst", removedFirst),
        ExerciseSupport.named("removedLast", removedLast),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithStreams(list)));
  }

}
