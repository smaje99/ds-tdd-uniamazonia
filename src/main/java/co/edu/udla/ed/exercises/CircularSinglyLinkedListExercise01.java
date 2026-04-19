package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

/**
 * Guided exercise 01 for the circular singly linked list series.
 *
 * <p>This scenario walks through the empty, singleton, and multi-element states of the circular list. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class CircularSinglyLinkedListExercise01 extends AbstractCircularSinglyLinkedListExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addFirst("inicio");
    return ExerciseSupport.snapshot(list);
  }

}