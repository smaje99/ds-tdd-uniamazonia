package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

/**
 * Guided exercise 04 for the circular singly linked list series.
 *
 * <p>This scenario combines several updates and reports the final logical snapshot. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class CircularSinglyLinkedListExercise04 extends AbstractCircularSinglyLinkedListExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("sol");
    list.addLast("luna");
    list.addFirst("inicio");
    list.removeFirst();
    list.addLast("estrella");
    list.addFirst("ancla");
    return ExerciseSupport.snapshot(list);
  }

}