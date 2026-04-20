package co.edu.udla.ed.exercises;

import java.util.TreeSet;

import co.edu.udla.ed.impl.scratch.LinkedBinarySearchTree;

public final class BinarySearchTreeExercise02 {

  public String solveWithCustomIterator(LinkedBinarySearchTree<Integer> tree) {
    insertSample(tree);
    return ExerciseSupport.format(
        ExerciseSupport.named("contains3", tree.contains(3)),
        ExerciseSupport.named("contains7", tree.contains(7)),
        ExerciseSupport.named("size", ExerciseSupport.countWithIterator(tree.inOrderIterable())));
  }

  public String solveWithJavaLoops(TreeSet<Integer> tree) {
    insertSample(tree);
    return ExerciseSupport.format(
        ExerciseSupport.named("contains3", tree.contains(3)),
        ExerciseSupport.named("contains7", tree.contains(7)),
        ExerciseSupport.named("size", tree.size()));
  }

  public String solveWithStreams(TreeSet<Integer> tree) {
    insertSample(tree);
    return ExerciseSupport.format(
        ExerciseSupport.named("contains3", tree.contains(3)),
        ExerciseSupport.named("contains7", tree.contains(7)),
        ExerciseSupport.named("size", tree.stream().count()));
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
