package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

/**
 * Guided exercise 01 for the doubly linked list series.
 *
 * <p>This scenario creates an ordered list whose final snapshot is easy to inspect. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class DoublyLinkedListExercise01 extends AbstractDoublyLinkedListExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("lunes");
    list.addLast("martes");
    list.addLast("miércoles");
    list.addLast("jueves");
    return ExerciseSupport.snapshot(list);
  }

}