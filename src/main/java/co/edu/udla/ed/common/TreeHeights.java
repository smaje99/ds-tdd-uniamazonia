package co.edu.udla.ed.common;

/**
 * Utility methods for reporting tree heights in the educational conventions
 * used by this repository.
 *
 * <p>
 * Tree-related APIs in this project define height as the number of levels:
 * an empty tree has height {@code 0}, and a tree containing only the root has
 * height {@code 1}. These helpers let wrapper implementations report a
 * meaningful height even when the underlying Java collection does not expose
 * its internal node structure.
 * </p>
 */
public final class TreeHeights {

  private TreeHeights() {
  }

  /**
   * Returns the number of levels needed to place {@code size} nodes in a
   * complete tree shape.
   *
   * <p>
   * This method is useful for wrappers around balanced structures, such as
   * {@code TreeSet}, when the code needs a didactic height estimate but cannot
   * inspect internal nodes directly. The result corresponds to the smallest
   * complete-tree height that can hold the given number of nodes.
   * </p>
   *
   * @param size the number of nodes stored in the logical tree
   * @return the height in levels according to the repository convention
   *
   * @implNote Time complexity is {@code O(log n)} because the method advances
   *           one level at a time until the complete-tree capacity covers all
   *           {@code n} nodes.
   */
  public static int completeTreeHeight(int size) {
    if (size <= 0) {
      return 0;
    }

    int height = 0;
    int levelCapacity = 1;
    int remaining = size;
    while (remaining > 0) {
      height++;
      remaining -= levelCapacity;
      levelCapacity <<= 1;
    }
    return height;
  }

}
