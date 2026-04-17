# Hash Tables

## What A Hash Table Does

A hash table maps keys to values through hashing. The key idea is:

1. compute a bucket from the key
2. store or search the entry in that bucket

## Core Concepts

- hash function
- bucket array
- collision handling
- load factor
- resizing / rehashing

## Collision Handling In This Repo

The scratch implementation uses separate chaining:

- each bucket stores a linked chain of entries
- entries that land in the same bucket are linked together

This is different from open addressing, where collisions are resolved by moving
to another slot in the array.

## Load Factor

The load factor is approximately:

`size / numberOfBuckets`

When it grows too much, average performance starts to degrade because collision
chains become longer.

## Complexity Perspective

With a good hash distribution:

- `put`: average `O(1)`
- `get`: average `O(1)`
- `remove`: average `O(1)`
- `containsKey`: average `O(1)`

Worst case with many collisions:

- all of those operations can degrade to `O(n)`

Resizing is usually `O(n)` because every entry must be rehashed.

## How It Appears In This Repo

- `api`
  - `HashTable<K, V>`
- `scratch`
  - `SeparateChainingHashTable`
- `collections`
  - `CollectionsHashTable`
- `linear`
  - `LinearHashTable`

The `linear` version is intentionally not a true hashed implementation. It is a
contrast case for studying API compatibility versus algorithmic efficiency.

## Common Pitfalls

- forgetting to update an existing key instead of inserting a duplicate entry
- losing entries during rehashing
- miscomputing the bucket index
- implementing `containsKey` incorrectly when a stored key maps to a `null`
  value
