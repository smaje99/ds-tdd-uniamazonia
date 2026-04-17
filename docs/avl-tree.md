# AVL Tree

## What Makes AVL Different

An AVL tree is a self-balancing BST. It keeps the BST ordering rule and also
maintains a balance condition.

## Balance Factor

The usual balance factor is:

`height(left) - height(right)`

For AVL trees, each node must stay in the range:

- `-1`
- `0`
- `1`

## Why Rotations Matter

After insertions and removals, a subtree may become unbalanced. Rotations
restore balance without breaking the BST ordering rule.

The classic cases are:

- LL
- RR
- LR
- RL

## Complexity Perspective

Because the tree stays balanced:

- `insert`: `O(log n)`
- `contains`: `O(log n)`
- `remove`: `O(log n)`
- `inOrder`: `O(n)`

## How It Appears In This Repo

- `scratch`
  - `LinkedAVLTree`
- `collections`
  - `CollectionsAVLTree`
- `linear`
  - `LinearAVLTree`

The wrapper implementations preserve the contract, but only the scratch version
shows the real rebalancing mechanics students should learn first.

## Common Pitfalls

- updating links but forgetting to update stored heights
- using the wrong rotation for LR or RL cases
- decrementing size twice during two-child removal
- confusing “balanced shape” with “sorted traversal”
