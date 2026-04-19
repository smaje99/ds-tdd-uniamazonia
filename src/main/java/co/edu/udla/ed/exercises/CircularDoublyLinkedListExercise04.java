package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

/**
 * Guided exercise 04 for the circular doubly linked list series.
 *
 * <p>This scenario rebuilds the list after a full reset and reports the final snapshot. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class CircularDoublyLinkedListExercise04 extends AbstractCircularDoublyLinkedListExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("base");
    list.addLast("temporal");
    list.clear();
    list.addFirst("nuevo-inicio");
    list.addLast("nuevo-final");
    list.addLast("cierre");
    return ExerciseSupport.snapshot(list);
  }

}