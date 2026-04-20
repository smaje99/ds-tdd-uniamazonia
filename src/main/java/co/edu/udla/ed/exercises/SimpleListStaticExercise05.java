package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.impl.scratch.StaticSimpleList;

public final class SimpleListStaticExercise05 {

  public String solveWithCustomIterator(StaticSimpleList<ExerciseSupport.Learner> list) {
    list.addLast(ExerciseSupport.learner("Ana", 101));
    list.addLast(ExerciseSupport.learner("Luis", 203));
    list.addFirst(ExerciseSupport.learner("Eva", 99));
    return ExerciseSupport.format(
        ExerciseSupport.named("containsLuis", list.contains(ExerciseSupport.learner("Luis", 203))),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithIterator(list)));
  }

  public String solveWithJavaLoops(ArrayList<ExerciseSupport.Learner> list) {
    list.add(ExerciseSupport.learner("Ana", 101));
    list.add(ExerciseSupport.learner("Luis", 203));
    list.add(0, ExerciseSupport.learner("Eva", 99));
    boolean containsLuis = false;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).equals(ExerciseSupport.learner("Luis", 203))) {
        containsLuis = true;
        break;
      }
    }
    return ExerciseSupport.format(
        ExerciseSupport.named("containsLuis", containsLuis),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithLoop(list)));
  }

  public String solveWithStreams(ArrayList<ExerciseSupport.Learner> list) {
    list.add(ExerciseSupport.learner("Ana", 101));
    list.add(ExerciseSupport.learner("Luis", 203));
    list.add(0, ExerciseSupport.learner("Eva", 99));
    return ExerciseSupport.format(
        ExerciseSupport.named("containsLuis", list.stream()
            .anyMatch(ExerciseSupport.learner("Luis", 203)::equals)),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithStreams(list)));
  }

}
