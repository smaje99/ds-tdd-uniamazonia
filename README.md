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
- every exercise runs the same scenario on `scratch`, `linear`, and
  `collections`
- tests under `src/test/java/co/edu/udla/ed/exercises` provide the feedback a
  student receives after copying or completing an exercise template
- `Exercise05` in every series uses custom domain objects instead of only
  `String` or `Integer` values

The exercise package is organized into 14 series:

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
      collections/
      linear/
    exercises/
  src/test/java/co/edu/udla/ed/
    contract/
    scratch/
    collections/
    linear/
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

## Implementation Approaches

- `scratch`: custom nodes, arrays, and explicit algorithmic logic
- `collections`: adapters built directly on top of Java collections
- `linear`: Java-collection-based implementations that emphasize iterative,
  linear reasoning and minimal extra machinery

## Study Notes

The repository also includes a short study guide under [docs/](/home/smaje/Documentos/Projects/2026/ds-tdd-uniamazonia/docs/README.md).
Use it together with the Javadoc in `src/main/java` before implementing or
debugging a topic.

The study notes now mirror the exercise package as well: each topic guide
points to the corresponding exercise series so students can move from reading
the invariant to running the targeted practice sequence.

## Progress Table

| Topic | Scratch | Collections | Linear |
| --- | --- | --- | --- |
| Simple List (static + dynamic) | done | example done | example done |
| Doubly Linked List | done | done | done |
| Circular Singly Linked List | done | done | done |
| Circular Doubly Linked List | done | done | done |
| Stacks and Queues (static + dynamic) | done | example done | example done |
| Binary Tree (general) | done | done | done |
| Binary Search Tree (BST) | done | done | done |
| AVL Tree | done | done | done |
| Graphs | done | done | done |
| Hash Tables | done | done | done |

## Current Focus

- preserve the existing contract tests for the scratch implementations
- expand missing topics without redesigning working public APIs
- keep extending the `collections` and `linear` approaches to the remaining
  list variants already available in `scratch`
- keep the project friendly for classroom use and grading

## Notes For Instructors

- Contract tests are the reusable specification layer.
- Concrete tests under `scratch`, `collections`, and `linear` bind an
  implementation to the shared contract.
- Guided exercise tests under `src/test/java/co/edu/udla/ed/exercises`
  validate the normalized feedback strings returned by the student-facing
  exercise layer.
- `HashTable` now includes a separate-chaining scratch implementation with
  collision and resizing coverage.
