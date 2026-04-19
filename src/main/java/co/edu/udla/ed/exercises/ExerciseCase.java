package co.edu.udla.ed.exercises;

/**
 * Common contract for every guided exercise in the package.
 *
 * <p>An exercise exposes the same scenario through three implementations of the same abstract data
 * type: the scratch version written specifically for the course, the linear reference
 * implementation, and the collections-backed version. Each method returns a compact feedback string
 * that tests can compare directly.</p>
 */
interface ExerciseCase {

  /**
   * Solves the exercise with the scratch implementation.
   *
   * @return the normalized feedback string produced by the scratch structure
   */
  String solveWithScratch();

  /**
   * Solves the exercise with the linear reference implementation.
   *
   * @return the normalized feedback string produced by the linear structure
   */
  String solveWithLinear();

  /**
   * Solves the exercise with the collections-backed implementation.
   *
   * @return the normalized feedback string produced by the collections-based structure
   */
  String solveWithCollections();

}
