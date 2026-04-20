package co.edu.udla.ed.exercises;

import java.util.ArrayList;
import java.util.TreeSet;

import co.edu.udla.ed.impl.scratch.LinkedBinarySearchTree;

public final class BinarySearchTreeExercise01 {

  public String solveWithCustomIterator(LinkedBinarySearchTree<Integer> tree) {
    insertSample(tree);
    return ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithIterator(tree.inOrderIterable()));
  }

  public String solveWithJavaLoops(TreeSet<Integer> tree) {
    insertSample(tree);
    return ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithLoop(new ArrayList<>(tree)));
  }

  public String solveWithStreams(TreeSet<Integer> tree) {
    insertSample(tree);
    return ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithStreams(tree));
  }

  private void insertSample(LinkedBinarySearchTree<Integer> tree) {
    tree.insert(5);
    tree.insert(2);
    tree.insert(8);
    tree.insert(1);
    tree.insert(3);
  }

  private void insertSample(TreeSet<Integer> tree) {
    tree.add(5);
    tree.add(2);
    tree.add(8);
    tree.add(1);
    tree.add(3);
  }

}
