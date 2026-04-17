# Circular Doubly Linked List

## What Makes It Circular And Doubly Linked

Each node stores both `next` and `prev`, and the ends wrap around:

- `head.prev == tail`
- `tail.next == head`

This combines two-way traversal with a circular structure.

## Core Invariant

- empty list: both head and tail are `null`
- singleton list:
  - `head == tail`
  - `head.next == head`
  - `head.prev == head`
- non-empty list:
  - `head.prev == tail`
  - `tail.next == head`

## Complexity Perspective

With head and tail:

- `addFirst`: `O(1)`
- `addLast`: `O(1)`
- `removeFirst`: `O(1)`
- `removeLast`: `O(1)`
- `get(index)`: `O(n)`

## How It Appears In This Repo

- `scratch`
  - `CircularDoublyLinkedList`
- `collections`
  - `CollectionsCircularDoublyLinkedList`
- `linear`
  - `LinearCircularDoublyLinkedList`

## Common Pitfalls

- updating `head` and `tail` but forgetting the circular links
- treating the one-node case as if it had neighbors distinct from itself
- forgetting to update both `prev` and `next`
