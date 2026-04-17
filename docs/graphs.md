# Graphs

## What The Graph API Covers

The repository graph API focuses on:

- vertices and edges
- adjacency queries
- BFS
- DFS
- path existence
- shortest path in unweighted graphs

## Directed vs Undirected

- directed graph:
  - edge `(u, v)` does not imply `(v, u)`
- undirected graph:
  - the connection is symmetric

In adjacency-list implementations, an undirected edge is often stored twice
internally, but it still counts as one logical edge.

## Deterministic Traversal

Graph tests are sensitive to visitation order. This repository therefore uses
deterministic neighbor order, especially in the `scratch` and `collections`
adjacency-list implementations.

That is why `LinkedHashSet` is important: it preserves insertion order.

## BFS vs DFS

- BFS explores by layers
- DFS explores one path deeply before backtracking

For unweighted shortest paths, BFS is the correct traversal because it finds a
path with the minimum number of edges.

## Complexity Perspective

For adjacency-list graphs:

- `addVertex`: average `O(1)`
- `addEdge`: average `O(1)` in hash-based variants
- BFS: `O(V + E)` in the explored region
- DFS: `O(V + E)` in the explored region
- shortest path with BFS: `O(V + E)`

In the `linear` graph wrapper, visited checks are done with lists, so traversal
cost is intentionally worse than the usual hash-based complexity.

## How It Appears In This Repo

- `scratch`
  - `AdjacencyListGraph`
- `collections`
  - `CollectionsAdjacencyListGraph`
- `linear`
  - `LinearAdjacencyListGraph`

## Common Pitfalls

- forgetting to create missing endpoint vertices before adding an edge
- counting one undirected edge as two public edges
- using non-deterministic neighbor order and breaking stable tests
- implementing shortest path without storing parents
