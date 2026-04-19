# Binary Tree

## What It Models

A binary tree is a hierarchical structure where each node has at most two
children:

- left child
- right child

In this repository, the general binary tree is not ordered like a BST. It only
models shape and traversal behavior.

## Height Convention

This project defines height as number of levels:

- empty tree: `0`
- root only: `1`

That convention must stay consistent across tests and documentation.

## Core Invariant

- each node has at most one left child and at most one right child
- attaching a second left or right child to the same parent is invalid
- `size` equals the number of nodes currently reachable from the root

## Traversals

- pre-order: node, left, right
- in-order: left, node, right
- post-order: left, right, node
- level-order: breadth-first by levels

## Complexity Perspective

For a tree with `n` nodes:

- `makeRoot`: `O(1)`
- `attachLeft`, `attachRight`: `O(1)`
- `size`: `O(1)` if tracked
- `height`: `O(n)` unless stored incrementally
- any full traversal: `O(n)`

## How It Appears In This Repo

- `scratch`
  - `LinkedBinaryTree`
- `collections`
  - `CollectionsBinaryTree`
- `linear`
  - `LinearBinaryTree`

The `collections` and `linear` implementations still use real nodes because the
API exposes nodes directly.

## Guided Exercises

`BinaryTreeExercise01-05` follows the same learning order as the notes:

- `Exercise01-03` focus on the main traversals and the repository height
  convention
- `Exercise04` turns the occupied-child case into an explicit exercise
- `Exercise05` uses learner domain objects so traversal output is checked with
  custom values rather than plain strings

## Common Pitfalls

- forgetting that `makeRoot` replaces the previous tree
- allowing a second left or right attachment
- mixing the height convention of levels with the height convention of edges
