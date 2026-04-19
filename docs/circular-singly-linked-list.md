# Circular Singly Linked List

## What Makes It Circular

In a circular singly linked list, the last node does not point to `null`. It
points back to the logical first node.

In many implementations, the most practical invariant is:

- `tail.next` is the logical head

That makes it possible to insert or remove at the front in constant time while
keeping a reference to the tail.

## Core Invariant

- empty list: tail is `null`
- non-empty list: tail is not `null` and `tail.next` is the first logical node
- following `next` exactly `size` times visits every node once and returns to
  the start

## Complexity Perspective

With only a tail reference:

- `addFirst`: `O(1)`
- `addLast`: `O(1)`
- `removeFirst`: `O(1)`
- `removeLast`: usually `O(n)` because the predecessor of the tail must be
  found
- `get(index)`: `O(n)`

## How It Appears In This Repo

- `scratch`
  - `CircularSinglyLinkedList`
- `collections`
  - `CollectionsCircularSinglyLinkedList`
- `linear`
  - `LinearCircularSinglyLinkedList`

The `collections` and `linear` wrappers preserve the contract even if the JDK
backing structure is not literally circular.

## Guided Exercises

`CircularSinglyLinkedListExercise01-05` gives a staged path through the topic:

- early exercises cover the transitions between empty, singleton, and
  multi-node states
- the middle exercises focus on reusing the list after removals
- `Exercise05` switches to learner domain objects so students can verify that
  the public behavior still depends on logical equality and order

## Common Pitfalls

- breaking the circle after the first insertion
- forgetting that singleton lists are a special case
- not restoring `tail.next` after `addFirst` or `removeFirst`
- iterating forever because the stop condition ignores the circular shape
