package co.edu.udla.ed.exercises;

import java.util.ArrayList;
import java.util.TreeSet;

import co.edu.udla.ed.impl.scratch.LinkedAVLTree;

public final class AVLTreeExercise03 {

  public String solveWithCustomIterator(LinkedAVLTree<Integer> tree) {
    tree.insert(3);
    tree.insert(2);
    tree.insert(4);
    tree.insert(1);
    boolean removed = tree.remove(4);
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("height", tree.height()),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithIterator(tree.inOrderIterable())));
  }

  public String solveWithJavaLoops(TreeSet<Integer> tree) {
    tree.add(3);
    tree.add(2);
    tree.add(4);
    tree.add(1);
    boolean removed = tree.remove(4);
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("height", ExerciseSupport.avlHeightFromValues(tree)),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithLoop(new ArrayList<>(tree))));
  }

  public String solveWithStreams(TreeSet<Integer> tree) {
    tree.add(3);
    tree.add(2);
    tree.add(4);
    tree.add(1);
    boolean removed = tree.remove(4);
    return ExerciseSupport.format(
        ExerciseSupport.named("removed", removed),
        ExerciseSupport.named("height", ExerciseSupport.avlHeightFromValues(tree)),
        ExerciseSupport.named("inOrder", ExerciseSupport.snapshotWithStreams(tree)));
  }

}
