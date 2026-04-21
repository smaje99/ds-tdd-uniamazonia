# ds-tdd-uniamazonia

Educational companion repository for the course **Estructuras de Datos**
at **Universidad de la Amazonia**.

## Goal

This repository helps students practice data structures in Java through a
test-driven workflow:

- students implement logic in `src/main/java`
- automated tests in `src/test/java` validate correctness
- the same contract tests are reused across different implementation
  approaches whenever the topic already has more than one variant

The project prioritizes readable implementations over clever shortcuts so the
code can serve as both a practice space and a study reference.

## Guided Exercises

The repository now includes a full guided exercise layer under
`src/main/java/co/edu/udla/ed/exercises`.

- each public `ExerciseNN` class models one classroom activity
- every exercise exposes the same problem through `custom + iterator`,
  `Java + loops`, and `Java + streams`
- tests under `src/test/java/co/edu/udla/ed/exercises` provide the feedback a
  student receives after copying or completing an exercise template
- `Exercise05` in every series uses custom domain objects instead of only
  `String` or `Integer` values

The exercise package is organized into 23 series:

- `SimpleListStatic`
- `SimpleListLinked`
- `DoublyLinkedList`
- `CircularSinglyLinkedList`
- `CircularDoublyLinkedList`
- `StackStatic`
- `StackLinked`
- `QueueStatic`
- `QueueLinked`
- `BinaryTree`
- `BinarySearchTree`
- `AVLTree`
- `AdjacencyListGraph`
- `HashTable`
- `PriorityQueue`
- `DisjointSet`
- `OpenAddressingHashTable`
- `RedBlackTree`
- `BTree`
- `DirectedAdjacencyListGraph`
- `WeightedGraph`
- `Sorting`
- `Search`

## Student Rules

1. Do not edit files under `src/test`.
2. Implement logic only in `src/main/java`, mainly in classes and TODO areas
   prepared for each topic.
3. Keep the public APIs consistent with the provided contracts.
4. Use Java 17+.
5. Respect the repository style rules from `.editorconfig`.
6. Throw `IndexOutOfBoundsException` for invalid list indices.
7. Throw `NoSuchElementException` for `pop`, `dequeue`, and empty list removals.
8. Keep traversal order deterministic when order affects tests. Graphs use
   `LinkedHashSet` for that reason.

## Repository Layout

```text
ds-tdd-uniamazonia/
  README.md
  pom.xml
  src/main/java/co/edu/udla/ed/
    api/
    common/
    impl/
      scratch/
    exercises/
  src/test/java/co/edu/udla/ed/
    contract/
    scratch/
    exercises/
```

## Build And Test

This repository currently uses Maven.

```bash
mvn test
```

To run a single test class:

```bash
mvn -Dtest=StaticSimpleListTest test
```

To run one guided exercise test class:

```bash
mvn -Dtest=SimpleListStaticExercise01Test test
```

## Exercise Approaches

- `custom + iterator`: students traverse their own structure with the iterator
  pattern
- `Java + loops`: the same problem is solved with JDK collections and
  traditional control flow
- `Java + streams`: the JDK-based solution is observed or reduced with
  `Collections` and `Stream` pipelines

## Study Notes

The repository also includes a short study guide under [docs/](/home/smaje/Documentos/Projects/2026/ds-tdd-uniamazonia/docs/README.md).
Use it together with the Javadoc in `src/main/java` before implementing or
debugging a topic.

The study notes now mirror the exercise package as well: each topic guide
points to the corresponding exercise series so students can move from reading
the invariant to running the targeted practice sequence.

## Progress Table

| Topic | Scratch | Guided 3-Approach Exercises |
| --- | --- | --- |
| Simple List (static + dynamic) | done | done |
| Doubly Linked List | done | done |
| Circular Singly Linked List | done | done |
| Circular Doubly Linked List | done | done |
| Stacks and Queues (static + dynamic) | done | done |
| Binary Tree (general) | done | done |
| Binary Search Tree (BST) | done | done |
| AVL Tree | done | done |
| Graphs | done | done |
| Hash Tables | done | done |
| Priority Queue / Heap | done | done |
| Disjoint Set / Union-Find | done | done |
| Open Addressing Hash Table | done | done |
| Red-Black Tree | done | done |
| B-Tree | done | done |
| Directed Graph Topological Workflows | done | done |
| Weighted Graphs | done | done |
| Sorting Algorithms For Linear Structures | done | done |
| Search Algorithms Across DS Families | done | done |

## Current Focus

- preserve the existing contract tests for the scratch implementations
- expand missing topics without redesigning working public APIs
- keep the exercise templates explicit and classroom-friendly
- keep the project friendly for classroom use and grading

## Notes For Instructors

- Contract tests are the reusable specification layer.
- Concrete tests under `scratch` bind each maintained implementation to the
  shared contract.
- Guided exercise tests under `src/test/java/co/edu/udla/ed/exercises`
  validate the three explicit student-facing approaches.
- `HashTable` now includes a separate-chaining scratch implementation with
  collision and resizing coverage.
- The expanded graph unit now includes directed topological workflows and
  weighted shortest-path / MST coverage.
- The sorting unit adds hand-written algorithms, non-mutating `sorted(...)`
  support for linear scratch structures, and JDK adapter utilities for
  `ArrayList` and `LinkedList`.
- The search unit adds rich search-result objects and family-specific
  algorithms for linear structures, trees, hash tables, disjoint sets, and
  graphs.
