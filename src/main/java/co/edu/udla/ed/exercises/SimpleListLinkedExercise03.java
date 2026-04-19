package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

/**
 * Guided exercise 03 for the singly linked simple-list series.
 *
 * <p>This scenario focuses on indexed reads and membership checks after a scripted sequence of insertions. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class SimpleListLinkedExercise03 extends AbstractSimpleListLinkedExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("rojo");
    list.addLast("verde");
    list.addLast("azul");
    list.addLast("amarillo");

    return ExerciseSupport.format(
        ExerciseSupport.named("get1", list.get(1)),
        ExerciseSupport.named("get3", list.get(3)),
        ExerciseSupport.named("containsAzul", list.contains("azul")),
        ExerciseSupport.named("containsNegro", list.contains("negro")));
  }

}