package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class CircularDoublyLinkedListExercise05 extends AbstractCircularDoublyLinkedListDomainExercise {

  @Override
  protected String solve(List<ExerciseSupport.Learner> list) {
    list.addLast(ExerciseSupport.learner("Ana", 101));
    list.addLast(ExerciseSupport.learner("Luis", 203));
    list.addFirst(ExerciseSupport.learner("Eva", 99));
    ExerciseSupport.Learner removed = list.removeLast();
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("containsAna", list.contains(ExerciseSupport.learner("Ana", 101))),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshot(list)));
  }

}
