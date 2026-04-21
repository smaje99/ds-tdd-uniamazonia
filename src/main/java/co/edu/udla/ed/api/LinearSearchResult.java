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

  public static <T> LinearSearchResult<T> found(int index, T value) {
    return new LinearSearchResult<>(true, index, value);
  }

  public static <T> LinearSearchResult<T> notFound() {
    return new LinearSearchResult<>(false, -1, null);
  }

}
