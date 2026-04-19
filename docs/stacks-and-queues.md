# Stacks And Queues

## Stack

A stack follows LIFO: last in, first out.

Operations:

- `push`
- `pop`
- `peek`
- `size`
- `clear`

### Stack Invariant

- the element returned by `pop` must be the same one returned by `peek`
- `push` changes the logical top
- `pop` and `peek` on an empty stack throw `NoSuchElementException`

### Typical Complexity

- array-backed with resizing:
  - `push`: amortized `O(1)`
  - `pop`: `O(1)`
  - `peek`: `O(1)`
- linked:
  - all top operations in `O(1)`

## Queue

A queue follows FIFO: first in, first out.

Operations:

- `enqueue`
- `dequeue`
- `peek`
- `size`
- `clear`

### Queue Invariant

- `dequeue` removes the oldest logical element
- `peek` returns the same value that `dequeue` would remove next
- `dequeue` and `peek` on an empty queue throw `NoSuchElementException`

### Typical Complexity

- circular-buffer queue:
  - `enqueue`: amortized `O(1)`
  - `dequeue`: `O(1)`
  - `peek`: `O(1)`
- linked queue with head/tail:
  - all front/rear operations in `O(1)`

## How They Appear In This Repo

- `scratch`
  - `StaticStack`, `LinkedStack`
  - `StaticQueue`, `LinkedQueue`
- `collections`
  - `CollectionsStack`, `CollectionsQueue`
- `linear`
  - `LinearStack`, `LinearQueue`

## Guided Exercises

This topic is split into four exercise series:

- `StackStaticExercise01-05`
- `StackLinkedExercise01-05`
- `QueueStaticExercise01-05`
- `QueueLinkedExercise01-05`

Across the four series, the first exercises introduce `peek`, `pop`, and
`dequeue`, the middle ones compose operations and size changes, and `Exercise05`
uses learner domain objects to confirm that LIFO and FIFO behavior remain
visible with custom values.

## Common Pitfalls

- mixing top with bottom in stack implementations
- dequeuing from the wrong end in queues
- not resetting head/tail or front/rear when the last element is removed
- confusing array capacity with logical size in circular buffers
