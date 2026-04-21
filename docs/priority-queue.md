# Priority Queue

## Invariant

A minimum priority queue always exposes the smallest stored element first.
The scratch implementation in this repository uses a binary heap, so the
internal array must satisfy the heap-order property: every parent is less than
or equal to its children.

## Core Operations

- `insert`: place a new value and restore heap order with sift-up
- `peekMin`: inspect the minimum without removing it
- `removeMin`: remove the root and restore heap order with sift-down
- `iterator`: expose the internal heap order deterministically

## Complexity

- `insert`: `O(log n)`
- `peekMin`: `O(1)`
- `removeMin`: `O(log n)`
- `iterator`: `O(n)`

## Common Mistakes

- confusing a min-heap with a max-heap
- forgetting to preserve duplicates
- breaking the heap after replacing the root on removal
- assuming iterator order must be sorted instead of heap order

## Exercise Mapping

- `PriorityQueueExercise01-05`

