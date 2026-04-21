# B-Tree

## Invariant

A B-Tree stores multiple keys per node and keeps all leaves at the same depth.
The exercises in this repository focus on the observable contract: sorted
traversal, membership, removal, and reasonable height growth.

## Core Operations

- `insert`
- `contains`
- `remove`
- `inOrder`
- `height`

## Complexity

For balanced B-Trees, search, insertion, and deletion are logarithmic in the
number of keys.

## Common Mistakes

- treating the structure like a plain binary tree
- letting duplicate keys grow the tree
- forgetting that traversal output must still be globally sorted

## Exercise Mapping

- `BTreeExercise01-05`

