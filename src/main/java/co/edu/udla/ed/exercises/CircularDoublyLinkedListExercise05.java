package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

/**
 * Guided exercise 05 for the circular doubly linked list series.
 *
 * <p>This scenario uses learner domain objects to show that circular updates still preserve readable logical order. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
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
