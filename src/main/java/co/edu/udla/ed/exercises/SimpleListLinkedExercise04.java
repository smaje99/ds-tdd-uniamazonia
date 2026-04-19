package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

/**
 * Guided exercise 04 for the singly linked simple-list series.
 *
 * <p>This scenario replays a longer mixed command sequence and reports the final snapshot. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class SimpleListLinkedExercise04 extends AbstractSimpleListLinkedExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("uno");
    list.addLast("dos");
    list.addFirst("cero");
    list.removeFirst();
    list.addLast("tres");
    list.addLast("cuatro");
    list.addFirst("cabecera");
    list.addLast("cinco");

    return ExerciseSupport.snapshot(list);
  }

}