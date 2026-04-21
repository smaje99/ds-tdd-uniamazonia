package co.edu.udla.ed.exercises;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import co.edu.udla.ed.impl.scratch.AdjacencyListGraph;
import co.edu.udla.ed.impl.scratch.AdjacencyListWeightedGraph;
import co.edu.udla.ed.impl.scratch.BinaryHeapPriorityQueue;
import co.edu.udla.ed.impl.scratch.CircularDoublyLinkedList;
import co.edu.udla.ed.impl.scratch.CircularSinglyLinkedList;
import co.edu.udla.ed.impl.scratch.DoublyLinkedList;
import co.edu.udla.ed.impl.scratch.LinkedAVLTree;
import co.edu.udla.ed.impl.scratch.LinkedBTree;
import co.edu.udla.ed.impl.scratch.LinkedBinarySearchTree;
import co.edu.udla.ed.impl.scratch.LinkedBinaryTree;
import co.edu.udla.ed.impl.scratch.LinkedQueue;
import co.edu.udla.ed.impl.scratch.LinkedRedBlackTree;
import co.edu.udla.ed.impl.scratch.LinkedStack;
import co.edu.udla.ed.impl.scratch.OpenAddressingHashTable;
import co.edu.udla.ed.impl.scratch.SeparateChainingHashTable;
import co.edu.udla.ed.impl.scratch.SinglyLinkedList;
import co.edu.udla.ed.impl.scratch.StaticQueue;
import co.edu.udla.ed.impl.scratch.StaticSimpleList;
import co.edu.udla.ed.impl.scratch.StaticStack;
import co.edu.udla.ed.impl.scratch.UnionFindDisjointSet;

final class ExerciseAssertions {

  private ExerciseAssertions() {
  }

  static void assertAllResults(Object exercise, String expected) {
    assertThat(invoke(exercise, "solveWithCustomIterator", customArgumentFor(exercise)))
        .as("custom + iterator debe entregar la retroalimentación esperada")
        .isEqualTo(expected);
    assertThat(invoke(exercise, "solveWithJavaLoops", javaArgumentFor(exercise)))
        .as("java + bucles debe entregar la retroalimentación esperada")
        .isEqualTo(expected);
    assertThat(invoke(exercise, "solveWithStreams", javaArgumentFor(exercise)))
        .as("java + streams debe entregar la retroalimentación esperada")
        .isEqualTo(expected);
  }

  static void assertAllThrow(Object exercise, Class<? extends Throwable> type) {
    assertThatThrownBy(() -> invoke(exercise, "solveWithCustomIterator", customArgumentFor(exercise)))
        .as("custom + iterator debe lanzar la excepción esperada")
        .isInstanceOf(type);
    assertThatThrownBy(() -> invoke(exercise, "solveWithJavaLoops", javaArgumentFor(exercise)))
        .as("java + bucles debe lanzar la excepción esperada")
        .isInstanceOf(type);
    assertThatThrownBy(() -> invoke(exercise, "solveWithStreams", javaArgumentFor(exercise)))
        .as("java + streams debe lanzar la excepción esperada")
        .isInstanceOf(type);
  }

  private static String invoke(Object exercise, String methodName, Object argument) {
    try {
      Method method = findMethod(exercise, methodName);
      return (String) method.invoke(exercise, argument);
    } catch (InvocationTargetException exception) {
      Throwable cause = exception.getCause();
      if (cause instanceof RuntimeException runtimeException) {
        throw runtimeException;
      }
      if (cause instanceof Error error) {
        throw error;
      }
      throw new RuntimeException(cause);
    } catch (ReflectiveOperationException exception) {
      throw new IllegalStateException("No fue posible invocar " + methodName, exception);
    }
  }

  private static Method findMethod(Object exercise, String methodName) {
    for (Method method : exercise.getClass().getMethods()) {
      if (method.getName().equals(methodName) && method.getParameterCount() == 1) {
        return method;
      }
    }
    throw new IllegalStateException("No se encontró el método " + methodName + " en " + exercise.getClass());
  }

  private static Object customArgumentFor(Object exercise) {
    String name = exercise.getClass().getSimpleName();
    if (name.startsWith("Sorting")) {
      return new StaticSimpleList<>();
    }
    if (name.startsWith("SimpleListStatic")) {
      return new StaticSimpleList<>();
    }
    if (name.startsWith("SimpleListLinked")) {
      return new SinglyLinkedList<>();
    }
    if (name.startsWith("DoublyLinkedList")) {
      return new DoublyLinkedList<>();
    }
    if (name.startsWith("CircularSinglyLinkedList")) {
      return new CircularSinglyLinkedList<>();
    }
    if (name.startsWith("CircularDoublyLinkedList")) {
      return new CircularDoublyLinkedList<>();
    }
    if (name.startsWith("StackStatic")) {
      return new StaticStack<>();
    }
    if (name.startsWith("StackLinked")) {
      return new LinkedStack<>();
    }
    if (name.startsWith("QueueStatic")) {
      return new StaticQueue<>();
    }
    if (name.startsWith("QueueLinked")) {
      return new LinkedQueue<>();
    }
    if (name.startsWith("BinaryTree")) {
      return new LinkedBinaryTree<>();
    }
    if (name.startsWith("BinarySearchTree")) {
      return new LinkedBinarySearchTree<>();
    }
    if (name.startsWith("AVLTree")) {
      return new LinkedAVLTree<>();
    }
    if (name.startsWith("AdjacencyListGraph")) {
      return new AdjacencyListGraph<>(false);
    }
    if (name.startsWith("HashTable")) {
      return new SeparateChainingHashTable<>();
    }
    if (name.startsWith("PriorityQueue")) {
      return new BinaryHeapPriorityQueue<>();
    }
    if (name.startsWith("DisjointSet")) {
      return new UnionFindDisjointSet<>();
    }
    if (name.startsWith("OpenAddressingHashTable")) {
      return new OpenAddressingHashTable<>();
    }
    if (name.startsWith("RedBlackTree")) {
      return new LinkedRedBlackTree<>();
    }
    if (name.startsWith("BTree")) {
      return new LinkedBTree<>();
    }
    if (name.startsWith("DirectedAdjacencyListGraph")) {
      return new AdjacencyListGraph<>(true);
    }
    if (name.startsWith("WeightedGraph")) {
      return new AdjacencyListWeightedGraph<>(false);
    }
    throw new IllegalArgumentException("Serie de ejercicio no soportada: " + name);
  }

  private static Object javaArgumentFor(Object exercise) {
    String name = exercise.getClass().getSimpleName();
    if (name.startsWith("Sorting")) {
      return new ArrayList<>();
    }
    if (name.startsWith("SimpleListStatic")) {
      return new ArrayList<>();
    }
    if (name.startsWith("SimpleListLinked")
        || name.startsWith("DoublyLinkedList")
        || name.startsWith("CircularSinglyLinkedList")
        || name.startsWith("CircularDoublyLinkedList")) {
      return new LinkedList<>();
    }
    if (name.startsWith("Stack") || name.startsWith("Queue")) {
      return new ArrayDeque<>();
    }
    if (name.startsWith("BinaryTree")) {
      return new ArrayList<>();
    }
    if (name.startsWith("BinarySearchTree") || name.startsWith("AVLTree")) {
      return new TreeSet<>();
    }
    if (name.startsWith("AdjacencyListGraph")) {
      return new LinkedHashMap<Object, LinkedHashSet<Object>>();
    }
    if (name.startsWith("HashTable")) {
      return new LinkedHashMap<>();
    }
    if (name.startsWith("PriorityQueue")) {
      return new PriorityQueue<>();
    }
    if (name.startsWith("DisjointSet")) {
      return new LinkedHashMap<>();
    }
    if (name.startsWith("OpenAddressingHashTable")) {
      return new LinkedHashMap<>();
    }
    if (name.startsWith("RedBlackTree") || name.startsWith("BTree")) {
      return new TreeSet<>();
    }
    if (name.startsWith("DirectedAdjacencyListGraph")) {
      return new LinkedHashMap<Object, LinkedHashSet<Object>>();
    }
    if (name.startsWith("WeightedGraph")) {
      return new LinkedHashMap<Object, LinkedHashMap<Object, Double>>();
    }
    throw new IllegalArgumentException("Serie de ejercicio no soportada: " + name);
  }

}
