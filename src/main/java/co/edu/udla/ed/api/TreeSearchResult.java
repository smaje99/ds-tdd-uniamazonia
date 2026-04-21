package co.edu.udla.ed.api;

import java.util.List;

/**
 * Result of a search over an ordered tree.
 *
 * @param found whether the target exists
 * @param target requested value
 * @param visited observable values inspected by the search
 * @param <T> element type
 */
public record TreeSearchResult<T>(boolean found, T target, List<T> visited) {
}
