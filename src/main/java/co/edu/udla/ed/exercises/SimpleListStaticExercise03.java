package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.impl.scratch.StaticSimpleList;

/**
 * Exercise 03 for the Static Simple List series.
 *
 * <p><strong>Student task:</strong> Insert several elements and validate indexed access together with membership checks.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class SimpleListStaticExercise03 {

  /**
   * Solves Exercise 03 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(StaticSimpleList<String> list) {
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

  /**
   * Solves Exercise 03 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayList<String> list) {
    list.add("casa");
    list.add("perro");
    list.add("gato");
    list.add("pez");
    boolean containsPerro = false;
    boolean containsLoro = false;
    for (int i = 0; i < list.size(); i++) {
      String value = list.get(i);
      if ("perro".equals(value)) {
        containsPerro = true;
      }
      if ("loro".equals(value)) {
        containsLoro = true;
      }
    }
    return ExerciseSupport.format(
        ExerciseSupport.named("get0", list.get(0)),
        ExerciseSupport.named("get2", list.get(2)),
        ExerciseSupport.named("containsPerro", containsPerro),
        ExerciseSupport.named("containsLoro", containsLoro));
  }

  /**
   * Solves Exercise 03 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayList<String> list) {
    list.add("casa");
    list.add("perro");
    list.add("gato");
    list.add("pez");
    return ExerciseSupport.format(
        ExerciseSupport.named("get0", list.get(0)),
        ExerciseSupport.named("get2", list.get(2)),
        ExerciseSupport.named("containsPerro", list.stream().anyMatch("perro"::equals)),
        ExerciseSupport.named("containsLoro", list.stream().anyMatch("loro"::equals)));
  }

}
