package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

/**
 * Guided exercise 03 for the array-backed simple-list series.
 *
 * <p>This scenario checks zero-based access and membership queries on the resulting list. The solver runs the same scripted operations on the scratch, linear, and
 * collections-based implementations and returns the feedback string that the exercise tests
 * compare against.</p>
 */
public final class SimpleListStaticExercise03 extends AbstractSimpleListStaticExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("casa");
    list.addLast("perro");
    list.addLast("gato");
    list.addLast("pez");

    return ExerciseSupport.format(
        ExerciseSupport.named("get0", list.get(0)),
        ExerciseSupport.named("get2", list.get(2)),
        ExerciseSupport.named("containsPerro", list.contains("perro")),
        ExerciseSupport.named("containsLoro", list.contains("loro")));
  }

}