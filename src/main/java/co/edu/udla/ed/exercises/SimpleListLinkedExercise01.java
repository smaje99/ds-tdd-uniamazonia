package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

/**
 * Guided exercise 01 for the singly linked simple-list series.
 *
 * <p>This scenario builds the list from both the head and the tail so students can inspect the final order. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class SimpleListLinkedExercise01 extends AbstractSimpleListLinkedExercise {

  @Override
  protected String solve(List<String> list) {
    list.addFirst("B");
    list.addLast("C");
    list.addFirst("A");
    list.addLast("D");
    return ExerciseSupport.snapshot(list);
  }

}