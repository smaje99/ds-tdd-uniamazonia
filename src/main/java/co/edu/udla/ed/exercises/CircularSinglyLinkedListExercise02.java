package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

/**
 * Guided exercise 02 for the circular singly linked list series.
 *
 * <p>This scenario alternates front and back insertions while preserving the externally visible order. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class CircularSinglyLinkedListExercise02 extends AbstractCircularSinglyLinkedListExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("B");
    list.addFirst("A");
    list.addLast("C");
    list.addFirst("inicio");
    list.addLast("D");
    return ExerciseSupport.snapshot(list);
  }

}