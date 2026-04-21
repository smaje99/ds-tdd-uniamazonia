# Sorting

## Invariant

Sorting in this repository applies only to linear list-like structures. The
public operation is `sorted(...)`, which always returns a new ordered copy and
never mutates the original structure.

Comparison-based algorithms accept either natural order or a custom
`Comparator`. Integer-only algorithms are limited to non-negative `Integer`
values and natural ascending order.

## Included Algorithms

- `BubbleSort`
- `SelectionSort`
- `InsertionSort`
- `ShellSort`
- `MergeSort`
- `QuickSort`
- `HeapSort`
- `CountingSort`
- `RadixSort`

## Stability And Tradeoffs

- `BubbleSort`, `InsertionSort`, `MergeSort`, `CountingSort`, and `RadixSort`
  are stable in this repository
- `SelectionSort`, `ShellSort`, `QuickSort`, and `HeapSort` are not stable
- `MergeSort` uses auxiliary storage to keep the implementation simple and
  predictable
- `QuickSort` uses the last element as the deterministic pivot
- `ShellSort` uses a halving gap sequence
- `HeapSort` relies on internal heap logic local to the algorithm, not on the
  priority-queue abstraction

## Complexity

- `BubbleSort`: `O(n^2)`
- `SelectionSort`: `O(n^2)`
- `InsertionSort`: `O(n^2)` worst case, efficient on nearly sorted input
- `ShellSort`: depends on the gap sequence; this implementation is subquadratic
  in many practical cases
- `MergeSort`: `O(n log n)`
- `QuickSort`: `O(n log n)` average, `O(n^2)` worst case
- `HeapSort`: `O(n log n)`
- `CountingSort`: `O(n + k)`
- `RadixSort`: `O(d(n + k))`

## Common Mistakes

- mutating the original list instead of returning a sorted copy
- calling JDK built-in sorting methods inside the scratch algorithms
- forgetting to add `set(int, T)` support to every linear structure
- assuming integer-only algorithms should accept negatives or custom comparators
- trying to add instance methods directly to `ArrayList` or `LinkedList`
  instead of using adapters

## JDK Integration

The repository does not modify JDK collections. Instead, it uses adapter
utilities so the same hand-written algorithms can operate on `ArrayList` and
`LinkedList` through a shared mutable indexed view.

## Exercise Mapping

- `SortingExercise01-05`
