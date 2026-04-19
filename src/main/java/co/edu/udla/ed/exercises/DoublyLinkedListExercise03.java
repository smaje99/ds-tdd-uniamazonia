package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

/**
 * Guided exercise 03 for the doubly linked list series.
 *
 * <p>This scenario reads representative positions so students can reason about zero-based indexing. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class DoublyLinkedListExercise03 extends AbstractDoublyLinkedListExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("uno");
    list.addLast("dos");
    list.addLast("tres");
    list.addLast("cuatro");
    list.addLast("cinco");

    return ExerciseSupport.format(
        ExerciseSupport.named("first", list.get(0)),
        ExerciseSupport.named("middle", list.get(2)),
        ExerciseSupport.named("last", list.get(4)));
  }

}