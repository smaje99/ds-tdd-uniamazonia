# Open Addressing Hash Table

## Invariant

An open-addressing hash table stores entries directly in an array and resolves
collisions by probing alternative slots. This repository uses linear probing
with tombstones.

## Core Operations

- `put`
- `get`
- `remove`
- `containsKey`
- iteration over occupied slots

## Complexity

Average insertion, lookup, and removal remain close to `O(1)` when the load
factor stays under control.

## Common Mistakes

- stopping a probe too early after encountering a tombstone
- returning the wrong removed value
- forgetting to resize before the table becomes too full

## Exercise Mapping

- `OpenAddressingHashTableExercise01-05`

