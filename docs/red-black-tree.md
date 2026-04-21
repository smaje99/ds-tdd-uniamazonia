# Red-Black Tree

## Invariant

A red-black tree is a balanced binary search tree. In this repository the
public exercises focus on observable behavior: sorted traversal, membership,
removal, and a height that stays logarithmically reasonable.

## Core Operations

- `insert`
- `contains`
- `remove`
- `inOrder`
- `height`

## Complexity

- search, insert, remove: `O(log n)`
- in-order traversal: `O(n)`

## Common Mistakes

- letting duplicates increase size
- breaking sorted traversal after removals
- exposing implementation details like colors in exercise results

## Exercise Mapping

- `RedBlackTreeExercise01-05`

