package co.edu.udla.ed.api;

/**
 * Result of a search over an indexed linear sequence.
 *
 * @param found whether the target was found
 * @param index index of the target, or {@code -1} when absent
 * @param value matched value, or {@code null} when absent
 * @param <T> element type
 */
public record LinearSearchResult<T>(boolean found, int index, T value) {

  /**
   * Creates a successful result for a value discovered at a zero-based index.
   *
   * @param index the matching index in the searched sequence
   * @param value the value stored at that index
   * @param <T> element type
   * @return a result whose {@code found} flag is {@code true}
   */
  public static <T> LinearSearchResult<T> found(int index, T value) {
    return new LinearSearchResult<>(true, index, value);
  }

  /**
   * Creates an unsuccessful result for a search that reached no matching value.
   *
   * @param <T> element type
   * @return a result with {@code index == -1}, {@code value == null}, and
   *         {@code found == false}
   */
  public static <T> LinearSearchResult<T> notFound() {
    return new LinearSearchResult<>(false, -1, null);
  }

}
