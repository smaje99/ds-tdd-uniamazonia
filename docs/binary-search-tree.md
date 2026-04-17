# Binary Search Tree

## Ordering Rule

For every node:

- values in the left subtree are smaller
- values in the right subtree are larger

In this repository, duplicate insertions are ignored.

## Why `inOrder()` Matters

Because of the BST invariant, an in-order traversal must produce the stored
values in ascending order.

## Removal Cases

Students should understand the three classic cases:

1. node with no children
2. node with one child
3. node with two children

The third case is usually solved by replacing the node with its in-order
successor or predecessor.

## Complexity Perspective

For a balanced BST:

- `insert`: `O(log n)`
- `contains`: `O(log n)`
- `remove`: `O(log n)`

For a degenerate BST shaped like a chain:

- those same operations degrade to `O(n)`

`inOrder()` is `O(n)` because it visits all nodes.

## How It Appears In This Repo

- `scratch`
  - `LinkedBinarySearchTree`
- `collections`
  - `CollectionsBinarySearchTree`
- `linear`
  - `LinearBinarySearchTree`

The `linear` version keeps sorted order but does not store a real tree, so it
is useful as a contrast between API semantics and internal representation.

## Common Pitfalls

- inserting duplicates instead of ignoring them
- breaking sorted order during removal
- forgetting to update size only when a real insertion or removal happens
