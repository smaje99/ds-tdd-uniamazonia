# Doubly Linked List

## What Makes It Different

A doubly linked list stores nodes with both `next` and `prev` references. That
lets the structure move in both directions.

## Core Invariant

- if the list is empty, both ends are `null`
- if the list has one node, head and tail point to the same node
- for every internal node:
  - `node.next.prev == node`
  - `node.prev.next == node`
- `size` matches the number of nodes reachable from head

## Expected Behavior

The public contract is the same as the general list contract:

- zero-based indexing
- `removeFirst` and `removeLast` throw `NoSuchElementException` when empty
- invalid indices throw `IndexOutOfBoundsException`

## Complexity Perspective

With head and tail references:

- `addFirst`: `O(1)`
- `addLast`: `O(1)`
- `removeFirst`: `O(1)`
- `removeLast`: `O(1)`
- `get(index)`: `O(n)`

Some implementations can optimize `get(index)` by choosing whether to traverse
from head or tail.

## How It Appears In This Repo

- `scratch`
  - `DoublyLinkedList`
- `collections`
  - `CollectionsDoublyLinkedList`
- `linear`
  - `LinearDoublyLinkedList`

## Guided Exercises

Use `DoublyLinkedListExercise01-05` to study this topic in progression:

- `Exercise01-04` cover ordering, trimming both ends, indexed access, and
  rebuilding after `clear`
- `Exercise05` repeats the same API ideas with learner domain objects so
  equality and readable snapshots become part of the feedback

## Common Pitfalls

- forgetting to update both links during insertion or removal
- leaving a stale `prev` or `next` reference after deleting the first or last
  node
- not resetting both head and tail when the last element is removed
