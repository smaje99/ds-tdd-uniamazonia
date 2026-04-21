# Weighted Graphs

## Invariant

A weighted graph associates a non-negative cost with each edge. The scratch
implementation preserves deterministic vertex and edge order so shortest paths
and minimum spanning trees remain reproducible in tests.

## Core Operations

- `addEdge(from, to, weight)`
- `edgeWeight`
- `dijkstraDistances`
- `shortestPathWeighted`
- `minimumSpanningTree`

## Complexity

- adjacency insertion and lookup: near `O(1)` average
- Dijkstra with a heap: `O((V + E) log V)`
- Kruskal MST: `O(E log E)`

## Common Mistakes

- accepting negative or `NaN` weights
- forgetting that MST is only valid for connected undirected graphs
- mixing weighted shortest path with the unweighted BFS version

## Exercise Mapping

- `WeightedGraphExercise01-05`

