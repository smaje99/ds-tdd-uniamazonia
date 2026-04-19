package co.edu.udla.ed.exercises;

import co.edu.udla.ed.api.List;

public final class SimpleListStaticExercise04 extends AbstractSimpleListStaticExercise {

  @Override
  protected String solve(List<String> list) {
    list.addLast("A");
    list.addLast("B");
    list.addLast("C");
    list.addLast("D");
    list.addLast("E");
    list.addLast("F");
    list.addLast("G");
    list.addLast("H");
    list.addLast("I");
    list.addLast("J");
    list.addLast("K");
    list.addFirst("inicio-1");
    list.addFirst("inicio-2");

    return ExerciseSupport.snapshot(list);
  }

}