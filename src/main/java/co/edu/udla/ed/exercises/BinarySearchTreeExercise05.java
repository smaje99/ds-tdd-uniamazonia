package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.BinarySearchTree;

public final class BinarySearchTreeExercise05 extends AbstractBinarySearchTreeDomainExercise {

  @Override
  protected String solve(BinarySearchTree<ExerciseSupport.RankedLearner> tree) {
    tree.insert(ExerciseSupport.rankedLearner("Luis", 40));
    tree.insert(ExerciseSupport.rankedLearner("Ana", 20));
    tree.insert(ExerciseSupport.rankedLearner("Mia", 60));
    tree.insert(ExerciseSupport.rankedLearner("Eva", 30));
    return ExerciseSupport.format(
        ExerciseSupport.named("containsEva", tree.contains(ExerciseSupport.rankedLearner("Eva", 30))),
        ExerciseSupport.named("size", tree.size()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshot(tree.inOrder())));
  }

}
