# Simple List

## What It Models

A simple list stores elements in a linear sequence. The repository uses the
following operations:

- `addFirst`
- `addLast`
- `removeFirst`
- `removeLast`
- `get(int index)`
- `contains`
- `size`
- `clear`

Indexing is zero-based.

## Core Invariant

- the logical order of the elements must match insertion and removal behavior
- index `0` is always the first logical element
- `size` must equal the number of logical elements currently stored
- `clear` must return the structure to the empty state

## Expected Behavior

- `addFirst(x)` inserts `x` at index `0`
- `addLast(x)` inserts `x` at the logical end
- `removeFirst()` removes and returns the first logical element
- `removeLast()` removes and returns the last logical element
- invalid indices throw `IndexOutOfBoundsException`
- removing from an empty list throws `NoSuchElementException`
- `contains` compares values with `equals`

## Complexity Perspective

Typical costs by representation:

- array-backed list:
  - `addFirst`: `O(n)`
  - `addLast`: amortized `O(1)`
  - `removeFirst`: `O(n)`
  - `removeLast`: `O(1)`
  - `get`: `O(1)`
- linked list:
  - `addFirst`: `O(1)`
  - `addLast`: `O(1)` if tail is available
  - `removeFirst`: `O(1)`
  - `removeLast`: can be `O(n)` in singly linked variants
  - `get`: `O(n)`

## How It Appears In This Repo

- `scratch`
  - `StaticSimpleList`: dynamic array
  - `SinglyLinkedList`: linked nodes
- `collections`
  - `CollectionsSimpleList`: wrapper over `ArrayList`
- `linear`
  - `LinearSimpleList`: wrapper over `LinkedList` with explicit iterative
    access logic

## Guided Exercises

The exercise package splits this topic into two parallel series:

- `SimpleListStaticExercise01-05`
  - focuses on the array-backed list
  - ends with `Exercise05`, which uses learner domain objects
- `SimpleListLinkedExercise01-05`
  - focuses on the singly linked list
  - also ends with a domain-object scenario in `Exercise05`

The first four exercises move from basic insertions to mixed command sequences.
The fifth exercise checks that `contains` and observable order still work when
the stored values rely on custom `equals` logic.

## Common Pitfalls

- forgetting to decrement `size` after a removal
- allowing `get(size)` instead of rejecting it
- mixing physical array capacity with logical element count
- returning the wrong element after shifting array contents
- using `==` instead of `equals` in `contains`
