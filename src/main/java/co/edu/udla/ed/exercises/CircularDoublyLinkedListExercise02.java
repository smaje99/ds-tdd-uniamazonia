package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

/**
 * Guided exercise 02 for the circular doubly linked list series.
 *
 * <p>This scenario alternates operations at both ends and inspects the resulting sequence. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class CircularDoublyLinkedListExercise02 extends AbstractCircularDoublyLinkedListExercise {

  @Override
  protected String solve(List<String> list) {
    list.addFirst("B");
    list.addLast("C");
    list.addFirst("A");
    list.addLast("D");
    return ExerciseSupport.format(
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshot(list)),
        ExerciseSupport.named("middle", list.get(2)));
  }

}