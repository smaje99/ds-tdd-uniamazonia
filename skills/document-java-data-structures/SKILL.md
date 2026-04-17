---
name: document-java-data-structures
description: Rewrite or expand Java documentation for educational data-structures repositories. Use when Codex needs to improve English Javadoc in `src/main` or similar source trees for interfaces and implementations of lists, stacks, queues, graphs, binary trees, binary search trees, and AVL trees. Focus on student-facing explanations of ADT contracts, invariants, edge cases, exceptions, traversal semantics, and time complexity without changing behavior.
---

# Document Java Data Structures

Use this skill to turn sparse, inconsistent, or mixed-language comments into precise English Javadoc for student-facing Java code. Treat the documentation as teaching material: explain what the structure guarantees, how operations behave, what special cases exist, and why the implementation preserves the expected data-structure rules.

## Workflow

1. Inspect the target scope before editing.
- Prefer `src/main` unless the user says otherwise.
- Separate ADT interfaces from concrete implementations.
- Run `scripts/audit_java_docs.py <path>` first when you need a quick map of missing Javadoc, mixed-language comments, or public declarations that need attention.

2. Document interfaces before implementations.
- Define the contract of each public method in the API layer first.
- Explain insertion/removal order, indexing rules, duplicate-handling, empty-structure behavior, exception conditions, and traversal order.
- State time complexity explicitly for every public operation unless the method is too trivial to benefit from repetition.
- Keep contracts implementation-agnostic unless the API already commits to a specific semantic.

3. Document implementations as teaching material, not filler.
- Explain the internal representation only when it helps students preserve invariants.
- Describe the state variables that matter, such as `head`, `tail`, `size`, array capacities, circular links, subtree ordering, or AVL node heights.
- For helper methods, document the algorithmic role rather than repeating the code line by line.

4. Keep all documentation in English.
- Translate or replace inline Spanish comments and mixed-language notes.
- Preserve the actual semantics from the code; do not invent behavior to make the prose sound nicer.
- Prefer one accurate Javadoc block over several redundant inline comments.

5. Verify behavior after documenting.
- Make sure Javadoc matches thrown exceptions, return values, and edge-case behavior.
- Keep terminology consistent across related files.
- When one interface defines a rule, mirror that rule in implementing classes instead of contradicting it.

## Documentation Standard

Read [references/java-ds-documentation-standards.md](references/java-ds-documentation-standards.md) before making large documentation passes. Use it as the project-specific rubric for:

- interface and class summaries
- method contracts
- complexity language
- invariants students must understand
- repository-specific semantics already present in `src/main`

## What To Prioritize

- Public interfaces in `src/main/java/.../api`
- Public classes in `src/main/java/.../impl`
- Inner node classes when they clarify structure and invariants
- Constructors when capacity, ordering, or validation rules matter
- Private helpers only when they encode key reasoning such as rebalancing, traversal, or successor/minimum removal

## Required Content By Structure Type

For lists, stacks, and queues:
- State whether the structure is linear, circular, linked, or array-backed.
- Explain insertion/removal direction and whether indexing is zero-based.
- Document empty-state behavior and exception types for destructive reads.
- Mention whether `contains` relies on `equals`.
- Include time complexity and, when relevant, amortized behavior.

For binary trees:
- Define height semantics explicitly.
- Explain each traversal order in plain language.
- Document parent/child attachment rules and failure cases.

For binary search trees and AVL trees:
- State the ordering rule.
- State how duplicate insertions behave if the implementation reveals it.
- Explain the meaning of `inOrder()` output.
- Describe removal cases conceptually: no child, one child, two children.
- For AVL trees, explain balance factors, stored heights, and why rotations preserve logarithmic height.

For graphs:
- State whether the representation is adjacency-list or adjacency-matrix based.
- Explain the semantics of directed versus undirected edges.
- Clarify whether neighbor iteration order is deterministic.
- Explain traversal costs in terms of vertices and edges, preferably as `O(V + E)` when appropriate.
- Distinguish between logical edge count and internal duplicated storage in undirected adjacency lists.

## Writing Rules

- Write in plain, precise English aimed at a student who is learning the structure for the first time.
- Prefer concrete semantics over generic phrases such as "performs the operation."
- Name the edge cases explicitly: empty structure, singleton structure, out-of-range index, duplicate value, full backing array, null parent, existing child.
- Include complexity with enough precision to teach tradeoffs, for example average `O(1)` for hash-based lookups or `O(V + E)` for graph traversals.
- Avoid copy-pasting the same paragraph across unrelated files.
- Avoid narrating every assignment; explain the invariant that the assignments preserve.
- Keep complexity statements honest. If the method traverses the structure, say `O(n)`. If an array resizes occasionally, say amortized `O(1)` only when the code actually supports that claim.

## Output Expectations

When the user asks for documentation work, produce edits directly in the codebase unless they only asked for analysis. After editing, summarize:

- which files were documented
- the main semantic rules clarified
- any ambiguous behavior that still needs a product or teaching decision
