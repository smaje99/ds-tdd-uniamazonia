/**
 * Guided exercises built on top of the data-structure implementations in this repository.
 *
 * <p>The classes in this package are intentionally small and scenario-driven. Each public
 * {@code ExerciseNN} class models one teaching activity, runs the same sequence on the scratch,
 * linear, and collections-based implementations, and returns a normalized feedback string that the
 * test suite can compare against a known expected result.</p>
 *
 * <p>The package is designed for students who copy an exercise template and complete or inspect
 * the logic locally. Because the feedback is generated through the public APIs of the structures,
 * these exercises reinforce observable behavior such as ordering, traversal semantics, membership
 * tests, empty-state transitions, and the effect of custom {@code equals}, {@code hashCode}, and
 * {@code compareTo} implementations.</p>
 *
 * <p>The exercise layer is separate from the contract tests for the production data structures. It
 * acts as student-facing practice material and can evolve without changing the implementation
 * contracts under {@code api} and {@code impl}.</p>
 */
package co.edu.udla.ed.exercises;
