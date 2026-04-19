package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

/**
 * Guided exercise 05 for the circular singly linked list series.
 *
 * <p>This scenario uses learner domain objects so students can inspect circular-list behavior with custom equality. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class CircularSinglyLinkedListExercise05 extends AbstractCircularSinglyLinkedListDomainExercise {

  @Override
  protected String solve(List<ExerciseSupport.Learner> list) {
    list.addLast(ExerciseSupport.learner("Ana", 101));
    list.addFirst(ExerciseSupport.learner("Luis", 203));
    list.addLast(ExerciseSupport.learner("Mia", 305));
    ExerciseSupport.Learner removed = list.removeFirst();
    list.addFirst(ExerciseSupport.learner("Eva", 99));
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshot(list)));
  }

}
