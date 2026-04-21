# Disjoint Set

## Invariant

A disjoint-set structure partitions elements into non-overlapping components.
Each registered element belongs to exactly one set, and `find` returns a
representative of that component.

## Core Operations

- `makeSet`: register a new singleton component
- `find`: locate the representative of the component
- `union`: merge two components
- `connected`: check whether two elements share the same representative

## Complexity

With path compression and union by rank, `find` and `union` are almost
constant in practice.

## Common Mistakes

- calling `find` or `union` before `makeSet`
- forgetting that duplicate `makeSet` calls should not grow the structure
- updating parents without keeping connectivity coherent

## Exercise Mapping

- `DisjointSetExercise01-05`

