package co.edu.udla.ed.exercises;

import java.util.ArrayList;
import java.util.TreeSet;

import co.edu.udla.ed.impl.scratch.LinkedBinarySearchTree;

public final class BinarySearchTreeExercise05 {

  public String solveWithCustomIterator(LinkedBinarySearchTree<ExerciseSupport.RankedLearner> tree) {
    insertDomainSample(tree);
    return ExerciseSupport.format(
        ExerciseSupport.named("containsEva", tree.contains(ExerciseSupport.rankedLearner("Eva", 30))),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(tree.inOrderIterable())),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithIterator(tree.inOrderIterable())));
  }

  public String solveWithJavaLoops(TreeSet<ExerciseSupport.RankedLearner> tree) {
    insertDomainSample(tree);
    return ExerciseSupport.format(
        ExerciseSupport.named("containsEva", tree.contains(ExerciseSupport.rankedLearner("Eva", 30))),
        ExerciseSupport.named("size", tree.size()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithLoop(new ArrayList<>(tree))));
  }

  public String solveWithStreams(TreeSet<ExerciseSupport.RankedLearner> tree) {
    insertDomainSample(tree);
    return ExerciseSupport.format(
        ExerciseSupport.named("containsEva", tree.contains(ExerciseSupport.rankedLearner("Eva", 30))),
        ExerciseSupport.named("size", tree.stream().count()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithStreams(tree)));
  }

  private void insertDomainSample(LinkedBinarySearchTree<ExerciseSupport.RankedLearner> tree) {
    tree.insert(ExerciseSupport.rankedLearner("Luis", 40));
    tree.insert(ExerciseSupport.rankedLearner("Ana", 20));
    tree.insert(ExerciseSupport.rankedLearner("Mia", 60));
    tree.insert(ExerciseSupport.rankedLearner("Eva", 30));
  }

  private void insertDomainSample(TreeSet<ExerciseSupport.RankedLearner> tree) {
    tree.add(ExerciseSupport.rankedLearner("Luis", 40));
    tree.add(ExerciseSupport.rankedLearner("Ana", 20));
    tree.add(ExerciseSupport.rankedLearner("Mia", 60));
    tree.add(ExerciseSupport.rankedLearner("Eva", 30));
  }

}
