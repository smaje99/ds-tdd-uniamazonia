package co.edu.udla.ed.exercises;

import java.util.ArrayList;
import java.util.TreeSet;

import co.edu.udla.ed.impl.scratch.LinkedAVLTree;

public final class AVLTreeExercise04 {

  public String solveWithCustomIterator(LinkedAVLTree<Integer> tree) {
    tree.insert(10);
    tree.insert(20);
    tree.insert(30);
    tree.insert(40);
    tree.insert(50);
    tree.insert(25);
    tree.remove(50);
    return ExerciseSupport.format(
        ExerciseSupport.named("contains25", tree.contains(25)),
        ExerciseSupport.named("height", tree.height()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithIterator(tree.inOrderIterable())));
  }

  public String solveWithJavaLoops(TreeSet<Integer> tree) {
    tree.add(10);
    tree.add(20);
    tree.add(30);
    tree.add(40);
    tree.add(50);
    tree.add(25);
    tree.remove(50);
    return ExerciseSupport.format(
        ExerciseSupport.named("contains25", tree.contains(25)),
        ExerciseSupport.named("height", ExerciseSupport.avlHeightFromValues(tree)),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithLoop(new ArrayList<>(tree))));
  }

  public String solveWithStreams(TreeSet<Integer> tree) {
    tree.add(10);
    tree.add(20);
    tree.add(30);
    tree.add(40);
    tree.add(50);
    tree.add(25);
    tree.remove(50);
    return ExerciseSupport.format(
        ExerciseSupport.named("contains25", tree.contains(25)),
        ExerciseSupport.named("height", ExerciseSupport.avlHeightFromValues(tree)),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithStreams(tree)));
  }

}
