package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

/**
 * Guided exercise 04 for the array-backed simple-list series.
 *
 * <p>This scenario stresses mixed insertions so students can observe preserved order after growth. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class SimpleListStaticExercise04 extends AbstractSimpleListStaticExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addLast("C");
    list.addLast("D");
    list.addLast("E");
    list.addLast("F");
    list.addLast("G");
    list.addLast("H");
    list.addLast("I");
    list.addLast("J");
    list.addLast("K");
    list.addFirst("inicio-1");
    list.addFirst("inicio-2");

    return ExerciseSupport.snapshot(list);
  }

}