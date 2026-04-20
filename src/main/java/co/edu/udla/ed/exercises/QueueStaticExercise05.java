package co.edu.udla.ed.exercises;

import java.util.ArrayDeque;

import co.edu.udla.ed.impl.scratch.StaticQueue;

public final class QueueStaticExercise05 {

  public String solveWithCustomIterator(StaticQueue<ExerciseSupport.Learner> queue) {
    queue.enqueue(ExerciseSupport.learner("Ana", 101));
    queue.enqueue(ExerciseSupport.learner("Luis", 203));
    queue.enqueue(ExerciseSupport.learner("Mia", 305));
    boolean frontMatches = queue.peek().equals(ExerciseSupport.learner("Ana", 101));
    ExerciseSupport.Learner served = queue.dequeue();
    return ExerciseSupport.format(
        ExerciseSupport.named("frontMatches", frontMatches),
        ExerciseSupport.named("served", served),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithIterator(queue)));
  }

  public String solveWithJavaLoops(ArrayDeque<ExerciseSupport.Learner> queue) {
    queue.addLast(ExerciseSupport.learner("Ana", 101));
    queue.addLast(ExerciseSupport.learner("Luis", 203));
    queue.addLast(ExerciseSupport.learner("Mia", 305));
    boolean frontMatches = queue.peekFirst().equals(ExerciseSupport.learner("Ana", 101));
    ExerciseSupport.Learner served = queue.removeFirst();
    return ExerciseSupport.format(
        ExerciseSupport.named("frontMatches", frontMatches),
        ExerciseSupport.named("served", served),
        ExerciseSupport.named("remaining", ExerciseSupport.drainDequeWithLoop(queue)));
  }

  public String solveWithStreams(ArrayDeque<ExerciseSupport.Learner> queue) {
    queue.addLast(ExerciseSupport.learner("Ana", 101));
    queue.addLast(ExerciseSupport.learner("Luis", 203));
    queue.addLast(ExerciseSupport.learner("Mia", 305));
    boolean frontMatches = queue.peekFirst().equals(ExerciseSupport.learner("Ana", 101));
    ExerciseSupport.Learner served = queue.removeFirst();
    return ExerciseSupport.format(
        ExerciseSupport.named("frontMatches", frontMatches),
        ExerciseSupport.named("served", served),
        ExerciseSupport.named("remaining", ExerciseSupport.snapshotWithStreams(queue)));
  }

}
