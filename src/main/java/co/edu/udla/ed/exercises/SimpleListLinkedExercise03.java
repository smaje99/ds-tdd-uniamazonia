package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.SinglyLinkedList;

/**
 * Exercise 03 for the Linked Simple List series.
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
public final class SimpleListLinkedExercise03 {

  /**
   * Solves Exercise 03 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(SinglyLinkedList<String> list) {
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

  /**
   * Solves Exercise 03 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(LinkedList<String> list) {
    list.addLast("rojo");
    list.addLast("verde");
    list.addLast("azul");
    list.addLast("amarillo");
    boolean containsAzul = false;
    boolean containsNegro = false;
    for (int i = 0; i < list.size(); i++) {
      String value = list.get(i);
      if ("azul".equals(value)) {
        containsAzul = true;
      }
      if ("negro".equals(value)) {
        containsNegro = true;
      }
    }
    return ExerciseSupport.format(
        ExerciseSupport.named("get1", list.get(1)),
        ExerciseSupport.named("get3", list.get(3)),
        ExerciseSupport.named("containsAzul", containsAzul),
        ExerciseSupport.named("containsNegro", containsNegro));
  }

  /**
   * Solves Exercise 03 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(LinkedList<String> list) {
    list.addLast("rojo");
    list.addLast("verde");
    list.addLast("azul");
    list.addLast("amarillo");
    return ExerciseSupport.format(
        ExerciseSupport.named("get1", list.get(1)),
        ExerciseSupport.named("get3", list.get(3)),
        ExerciseSupport.named("containsAzul", list.stream().anyMatch("azul"::equals)),
        ExerciseSupport.named("containsNegro", list.stream().anyMatch("negro"::equals)));
  }

}
