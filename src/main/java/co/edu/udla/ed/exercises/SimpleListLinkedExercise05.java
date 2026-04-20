package co.edu.udla.ed.exercises;

import java.util.LinkedList;

import co.edu.udla.ed.impl.scratch.SinglyLinkedList;

/**
 * Exercise 05 for the Linked Simple List series.
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
public final class SimpleListLinkedExercise05 {

  /**
   * Solves Exercise 05 with the custom structure and iterator-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithCustomIterator(SinglyLinkedList<ExerciseSupport.Learner> list) {
    list.addFirst(ExerciseSupport.learner("Luis", 203));
    list.addLast(ExerciseSupport.learner("Mia", 305));
    list.addFirst(ExerciseSupport.learner("Ana", 101));
    ExerciseSupport.Learner removed = list.removeLast();
    list.addLast(ExerciseSupport.learner("Leo", 404));
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("containsAna", list.contains(ExerciseSupport.learner("Ana", 101))),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithIterator(list)));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and traditional loops.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithJavaLoops(LinkedList<ExerciseSupport.Learner> list) {
    list.addFirst(ExerciseSupport.learner("Luis", 203));
    list.addLast(ExerciseSupport.learner("Mia", 305));
    list.addFirst(ExerciseSupport.learner("Ana", 101));
    ExerciseSupport.Learner removed = list.removeLast();
    list.addLast(ExerciseSupport.learner("Leo", 404));
    boolean containsAna = false;
    for (ExerciseSupport.Learner learner : list) {
      if (learner.equals(ExerciseSupport.learner("Ana", 101))) {
        containsAna = true;
        break;
      }
    }
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("containsAna", containsAna),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithLoop(list)));
  }

  /**
   * Solves Exercise 05 with the equivalent JDK structure and stream-based observation.
   *
   * @return normalized feedback for the expected result of the exercise
   */
  public String solveWithStreams(LinkedList<ExerciseSupport.Learner> list) {
    list.addFirst(ExerciseSupport.learner("Luis", 203));
    list.addLast(ExerciseSupport.learner("Mia", 305));
    list.addFirst(ExerciseSupport.learner("Ana", 101));
    ExerciseSupport.Learner removed = list.removeLast();
    list.addLast(ExerciseSupport.learner("Leo", 404));
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("containsAna", list.stream()
            .anyMatch(ExerciseSupport.learner("Ana", 101)::equals)),
        ExerciseSupport.named("snapshot", ExerciseSupport.snapshotWithStreams(list)));
  }

}
