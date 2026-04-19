package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class DoublyLinkedListExercise05 extends AbstractDoublyLinkedListDomainExercise {

  @Override
  protected String solve(List<ExerciseSupport.Learner> list) {
    list.addLast(ExerciseSupport.learner("Ana", 101));
    list.addLast(ExerciseSupport.learner("Luis", 203));
    list.addLast(ExerciseSupport.learner("Mia", 305));
    return ExerciseSupport.format(
        ExerciseSupport.named("middleIsLuis", list.get(1).equals(ExerciseSupport.learner("Luis", 203))),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshot(list)));
  }

}
