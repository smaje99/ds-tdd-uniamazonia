package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

/**
 * Guided exercise 05 for the singly linked simple-list series.
 *
 * <p>This scenario uses learner domain objects to reinforce that membership depends on logical equality, not object identity. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
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
