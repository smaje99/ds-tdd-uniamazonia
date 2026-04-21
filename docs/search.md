# Search

## Invariant

Search is a transversal topic in this repository. It applies to linear
structures, ordered trees, hash tables, disjoint sets, and graphs, but each
family has a different meaningful result.

Linear searches report an index, key-value searches report a value for a key,
tree searches report observable visited values, disjoint-set searches report a
representative, and graph searches report traversal order plus a path when the
algorithm computes one.

## Included Algorithms

- `LinearSearch`
- `BinarySearch`
- `JumpSearch`
- `HashTableKeySearch`
- `OrderedTreeSearch`
- `BreadthFirstSearch`
- `DepthFirstSearch`
- `UnweightedShortestPathSearch`
- `WeightedShortestPathSearch`
- `RepresentativeSearch`
- `ConnectivitySearch`

## Core Rules

- `BinarySearch` and `JumpSearch` require sorted indexed input
- linear searches return the first matching index
- tree searches do not expose private nodes; they report public observable order
- graph searches preserve deterministic traversal order
- disjoint-set searches treat unknown elements as not found when looking up a
  representative

## Complexity

- `LinearSearch`: `O(n)`
- `BinarySearch`: `O(log n)` over indexed sorted input
- `JumpSearch`: `O(sqrt(n))` over indexed sorted input
- hash key search: expected `O(1)`
- ordered tree search: depends on tree height; public observable search may
  inspect up to `O(n)` values
- graph BFS/DFS: `O(V + E)`
- weighted shortest path: Dijkstra-style cost based on the weighted graph
  implementation

## Common Mistakes

- using binary search on unsorted data
- returning only a boolean when the exercise expects index, value, path, or
  visited order
- assuming tree searches can expose private node paths without changing the API
- treating graph reachability and shortest path as the same exercise
- forgetting that hash lookup must distinguish absent keys from present keys

## Exercise Mapping

- `SearchExercise01-05`
