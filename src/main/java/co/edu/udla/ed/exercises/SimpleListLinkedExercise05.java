package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class SimpleListLinkedExercise05 extends AbstractSimpleListLinkedDomainExercise {

  @Override
  protected String solve(List<ExerciseSupport.Learner> list) {
    list.addFirst(ExerciseSupport.learner("Luis", 203));
    list.addLast(ExerciseSupport.learner("Mia", 305));
    list.addFirst(ExerciseSupport.learner("Ana", 101));
    ExerciseSupport.Learner removed = list.removeLast();
    list.addLast(ExerciseSupport.learner("Leo", 404));
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("containsAna", list.contains(ExerciseSupport.learner("Ana", 101))),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshot(list)));
  }

}
