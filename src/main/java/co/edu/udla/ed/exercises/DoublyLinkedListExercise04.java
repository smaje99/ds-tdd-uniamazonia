package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

/**
 * Guided exercise 04 for the doubly linked list series.
 *
 * <p>This scenario clears and rebuilds the structure to show that the empty state is reusable. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class DoublyLinkedListExercise04 extends AbstractDoublyLinkedListExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("base-1");
    list.addLast("base-2");
    list.clear();
    list.addLast("nuevo-1");
    list.addLast("nuevo-2");
    list.addFirst("nuevo-0");
    return ExerciseSupport.snapshot(list);
  }

}