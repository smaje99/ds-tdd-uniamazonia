# Java Data Structures Documentation Standards

## Purpose

Use this reference when documenting Java data-structure code for students. The goal is not just API completeness; the documentation must help a learner understand the abstract data type, the internal representation, and the algorithmic tradeoffs without reading every line of code first.

## Repository Findings From `src/main`

- The codebase already uses Javadoc heavily, but the quality is inconsistent.
- English Javadoc is mixed with Spanish inline comments and short Spanish semantic notes.
- Several interfaces describe the structure at a high level but do not define individual method contracts.
- Some implementation comments are verbose but still miss the key invariant students actually need.
- Tree code uses height as number of levels, not number of edges: empty tree is `0`, root-only tree is `1`.
- `BinarySearchTree` and `AVLTree` insertions ignore duplicates instead of replacing existing values.
- Search-tree `inOrder()` traversal is expected to produce sorted output.
- Destructive reads on lists, stacks, and queues generally throw `NoSuchElementException` when empty.
- List indexing is zero-based and invalid indices throw `IndexOutOfBoundsException`.
- Array-backed structures resize dynamically even when their names say `Static`.
- Graph traversals should be documented in terms of visited vertices and traversed edges, not only with a generic `O(n)`.

## Minimum Standard For Interface Documentation

Document each public method with these points when relevant:

- what the operation does
- whether it mutates the structure
- what it returns
- what happens when the structure is empty
- what happens when the argument is invalid
- whether duplicate values are allowed, ignored, or rejected
- time complexity

Prefer exact structural variables when they improve teaching value, such as:

- `O(n)` for linear scans over list elements
- amortized `O(1)` for geometric array growth
- `O(V + E)` for full graph traversals
- `O(k)` for path reconstruction when `k` is the path length

For traversal methods, explain the order in words, not only by method name.

For boolean-returning removal methods, state exactly what `true` and `false` mean.

## Minimum Standard For Implementation Documentation

Each public class summary should explain:

- the concrete representation
- the core fields that preserve the invariant
- the learning value of the implementation
- the main performance profile

Document inner node classes only when it helps students understand the shape of the structure. Keep those explanations focused on the stored references and what they represent.

Document private helper methods when they encode algorithmic reasoning students should learn, such as:

- locating a node
- shifting or copying elements
- resizing an array
- finding the minimum in a subtree
- removing the successor
- updating AVL heights
- performing rotations

## Project-Specific Semantic Rules To Keep Consistent

### Lists

- `addFirst` inserts at index `0`.
- `addLast` inserts at the logical end.
- `removeFirst` and `removeLast` remove and return the element.
- `get(int index)` uses zero-based indexing.
- `contains` compares values with `equals`.
- `clear` removes all logical elements and resets the structure to the empty state.

### Circular Lists

- Explain the circular invariant explicitly.
- In singly circular lists, `tail.next` acts as the logical head when the list is not empty.
- In doubly circular lists, `head.prev == tail` and `tail.next == head` after valid updates.

### Array-Backed Structures

- Explain the difference between logical size and backing-array capacity.
- For circular buffers, distinguish physical indices from logical front/rear order.
- Say "amortized `O(1)`" only for operations backed by geometric resizing.

### Binary Trees

- Explain that a node has at most two children.
- Clarify whether attachment methods fail when a child already exists.
- Keep traversal descriptions aligned with the actual recursive or iterative implementation.

### Binary Search Trees

- State the ordering invariant: left subtree values are smaller, right subtree values are larger.
- State that duplicates are ignored in this repository.
- Explain the three deletion cases conceptually.
- Explain that `inOrder()` returns ascending order because of the BST invariant.

### AVL Trees

- State that the balance factor is `height(left) - height(right)`.
- Explain that stored node heights are part of the invariant.
- Explain when single vs. double rotations happen.
- Make the educational goal explicit: balancing preserves `O(log n)` search, insertion, and deletion in the usual case.

### Graphs

- State whether the implementation uses adjacency lists or an adjacency matrix.
- Explain whether vertex or neighbor order is deterministic and why.
- For hash-based adjacency maps or sets, describe lookup and insertion costs as average-case `O(1)` unless the implementation guarantees something different.
- For BFS and DFS, explain the cost as `O(V + E)` over the explored portion of the graph, or worst-case `O(V + E)` when the whole graph may be reached.
- For shortest paths in unweighted graphs, explain that BFS gives the minimum number of edges.
- For undirected adjacency-list implementations, clarify that a single logical edge may be stored twice internally while still counting as one public edge.

## Style Rules

- Write in English only.
- Use precise, student-oriented language.
- Prefer short paragraphs over giant blocks of repeated prose.
- Avoid tautologies such as "This method performs the operation."
- Avoid documenting obvious syntax-level details such as "assigns the variable."
- When a method has multiple branches, explain the branches by case.
- If a comment exists only to translate code literally, delete it or replace it with an invariant-focused explanation.

## Common Gaps To Fix In This Repository

- Replace Spanish inline comments with English explanations or remove them if Javadoc already covers the idea.
- Expand interface-level method contracts.
- Clarify height semantics consistently across `BinaryTree`, `BinarySearchTree`, `AVLTree`, and their implementations.
- Clarify duplicate-handling consistently across BST and AVL APIs and implementations.
- Clarify why `StaticQueue` and `StaticStack` still resize dynamically.
- Expand graph documentation with traversal semantics, edge-count rules, and complexity in terms of vertices and edges.
- Clarify iterator behavior only when it contributes to student understanding.

## Review Checklist

Before finishing a documentation pass, confirm all of the following:

- Every public type has an English summary.
- Every public method has a contract that matches the code.
- Exception behavior is documented when relevant.
- Complexity statements match the implementation.
- Invariants are explained for circular structures, search trees, and AVL balancing.
- Spanish comments have been removed, translated, or replaced.
- The documentation teaches the structure instead of paraphrasing the syntax.
