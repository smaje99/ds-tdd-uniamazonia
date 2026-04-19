package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class SimpleListStaticExercise05 extends AbstractSimpleListStaticDomainExercise {

  @Override
  protected String solve(List<ExerciseSupport.Learner> list) {
    list.addLast(ExerciseSupport.learner("Ana", 101));
    list.addLast(ExerciseSupport.learner("Luis", 203));
    list.addFirst(ExerciseSupport.learner("Eva", 99));
    return ExerciseSupport.format(
        ExerciseSupport.named("containsLuis", list.contains(ExerciseSupport.learner("Luis", 203))),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshot(list)));
  }

}
