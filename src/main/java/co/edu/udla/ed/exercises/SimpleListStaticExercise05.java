package co.edu.udla.ed.exercises;

import java.util.ArrayList;

import co.edu.udla.ed.impl.scratch.StaticSimpleList;

/**
 * Exercise 05 for the Static Simple List series.
 *
 * <p><strong>Student task:</strong> Work with domain objects and verify equality-based search together with the final snapshot.</p>
 *
 * <p><strong>Required implementations:</strong></p>
 * <ul>
 *   <li>{@code solveWithCustomIterator(...)}: solve the activity with the scratch structure created by the student and use iteration to observe the result.</li>
 *   <li>{@code solveWithJavaLoops(...)}: solve the same activity with the equivalent JDK structure and traditional control flow.</li>
 *   <li>{@code solveWithStreams(...)}: solve the same activity with the equivalent JDK structure and collections/stream operations.</li>
 * </ul>
 */
public final class SimpleListStaticExercise05 {

  /**
   * Solves Exercise 05 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(StaticSimpleList<ExerciseSupport.Learner> list) {
    list.addLast(ExerciseSupport.learner("Ana", 101));
    list.addLast(ExerciseSupport.learner("Luis", 203));
    list.addFirst(ExerciseSupport.learner("Eva", 99));
    return ExerciseSupport.format(
        ExerciseSupport.named("containsLuis", list.contains(ExerciseSupport.learner("Luis", 203))),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithIterator(list)));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(ArrayList<ExerciseSupport.Learner> list) {
    list.add(ExerciseSupport.learner("Ana", 101));
    list.add(ExerciseSupport.learner("Luis", 203));
    list.add(0, ExerciseSupport.learner("Eva", 99));
    boolean containsLuis = false;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).equals(ExerciseSupport.learner("Luis", 203))) {
        containsLuis = true;
        break;
      }
    }
    return ExerciseSupport.format(
        ExerciseSupport.named("containsLuis", containsLuis),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithLoop(list)));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(ArrayList<ExerciseSupport.Learner> list) {
    list.add(ExerciseSupport.learner("Ana", 101));
    list.add(ExerciseSupport.learner("Luis", 203));
    list.add(0, ExerciseSupport.learner("Eva", 99));
    return ExerciseSupport.format(
        ExerciseSupport.named("containsLuis", list.stream()
            .anyMatch(ExerciseSupport.learner("Luis", 203)::equals)),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithStreams(list)));
  }

}
