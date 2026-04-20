package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.LinkedQueue;

public final class QueueLinkedExercise05 {

  public String solveWithCustomIterator(LinkedQueue<ExerciseSupport.Learner> queue) {
    queue.enqueue(ExerciseSupport.learner("Eva", 99));
    queue.enqueue(ExerciseSupport.learner("Ana", 101));
    queue.enqueue(ExerciseSupport.learner("Luis", 203));
    ExerciseSupport.Learner served = queue.dequeue();
    queue.enqueue(ExerciseSupport.learner("Mia", 305));
    return ExerciseSupport.format(
        ExerciseSupport.named("served", served),
        ExerciseSupport.named("peekIsAna", queue.peek().equals(ExerciseSupport.learner("Ana", 101))),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithIterator(queue)));
  }

  public String solveWithJavaLoops(ArrayDeque<ExerciseSupport.Learner> queue) {
    queue.addLast(ExerciseSupport.learner("Eva", 99));
    queue.addLast(ExerciseSupport.learner("Ana", 101));
    queue.addLast(ExerciseSupport.learner("Luis", 203));
    ExerciseSupport.Learner served = queue.removeFirst();
    queue.addLast(ExerciseSupport.learner("Mia", 305));
    return ExerciseSupport.format(
        ExerciseSupport.named("served", served),
        ExerciseSupport.named("peekIsAna", queue.peekFirst().equals(ExerciseSupport.learner("Ana", 101))),
        ExerciseSupport.named("remaining", ExerciseSupport.drainDequeWithLoop(queue)));
  }

  public String solveWithStreams(ArrayDeque<ExerciseSupport.Learner> queue) {
    queue.addLast(ExerciseSupport.learner("Eva", 99));
    queue.addLast(ExerciseSupport.learner("Ana", 101));
    queue.addLast(ExerciseSupport.learner("Luis", 203));
    ExerciseSupport.Learner served = queue.removeFirst();
    queue.addLast(ExerciseSupport.learner("Mia", 305));
    return ExerciseSupport.format(
        ExerciseSupport.named("served", served),
        ExerciseSupport.named("peekIsAna", queue.peekFirst().equals(ExerciseSupport.learner("Ana", 101))),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithStreams(queue)));
  }

}
