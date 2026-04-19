package co.edu.udla.ed.exercises;

import java.util.ArrayList;
import java.util.Objects;

final class ExerciseSupport {

  private ExerciseSupport() {
  }

  /**
   * Copies any iterable sequence into a regular Java list.
   *
   * <p>The exercise package uses this helper to normalize snapshots coming from custom ADTs and the
   * JDK-backed implementations into the same textual form.</p>
   *
   * @param values values to copy in iteration order
   * @param <T> element type
   * @return a mutable Java list with the same logical order
   */
  static <T> java.util.List<T> toJavaList(Iterable<T> values) {
    java.util.List<T> copy = new ArrayList<>();
    for (T value : values) {
      copy.add(value);
    }
    return copy;
  }

  static <T> String snapshot(Iterable<T> values) {
    return toJavaList(values).toString();
  }

  /**
   * Joins feedback fragments with the package-wide separator.
   *
   * @param parts named fragments such as {@code size=3} or {@code inOrder=[...]}
   * @return a single feedback string ready for tests
   */
  static String format(String... parts) {
    return String.join("|", parts);
  }

  static String named(String name, Object value) {
    return name + "=" + value;
  }

  /**
   * Factory for the identity-based learner object used in non-ordered exercises.
   *
   * @param name learner display name
   * @param code learner identifier used in equality checks
   * @return a learner value object
   */
  static Learner learner(String name, int code) {
    return new Learner(name, code);
  }

  static RankedLearner rankedLearner(String name, int level) {
    return new RankedLearner(name, level);
  }

  /**
   * Factory for the custom hash-table key used in the domain-based hash exercise.
   *
   * @param course course code
   * @param section section identifier
   * @return a key object with readable text and explicit equality semantics
   */
  static EnrollmentKey enrollmentKey(String course, String section) {
    return new EnrollmentKey(course, section);
  }

  /**
   * Identity/value object used by list, stack, queue, binary-tree, and graph exercises.
   *
   * <p>Two learners are equal when both their display name and numeric code match. The string form
   * is intentionally compact so test feedback remains easy to read.</p>
   */
  static final class Learner {
    private final String name;
    private final int code;

    Learner(String name, int code) {
      this.name = name;
      this.code = code;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (!(obj instanceof Learner other)) {
        return false;
      }
      return code == other.code && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, code);
    }

    @Override
    public String toString() {
      return name + "#" + code;
    }
  }

  /**
   * Comparable domain object used by BST and AVL exercises.
   *
   * <p>Ordering is primarily determined by {@code level}; ties break by name so {@code inOrder()}
   * remains deterministic and readable in test feedback.</p>
   */
  static final class RankedLearner implements Comparable<RankedLearner> {
    private final String name;
    private final int level;

    RankedLearner(String name, int level) {
      this.name = name;
      this.level = level;
    }

    @Override
    public int compareTo(RankedLearner other) {
      int byLevel = Integer.compare(level, other.level);
      if (byLevel != 0) {
        return byLevel;
      }
      return name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (!(obj instanceof RankedLearner other)) {
        return false;
      }
      return level == other.level && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, level);
    }

    @Override
    public String toString() {
      return name + "@" + level;
    }
  }

  /**
   * Custom hash-table key used to teach lookup and update semantics with domain objects.
   *
   * <p>The constant hash code forces collisions on purpose so the exercise can still validate
   * logical correctness when several distinct keys share the same bucket.</p>
   */
  static final class EnrollmentKey {
    private final String course;
    private final String section;

    EnrollmentKey(String course, String section) {
      this.course = course;
      this.section = section;
    }

    @Override
    public int hashCode() {
      return 17;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (!(obj instanceof EnrollmentKey other)) {
        return false;
      }
      return Objects.equals(course, other.course) && Objects.equals(section, other.section);
    }

    @Override
    public String toString() {
      return course + "-" + section;
    }
  }

  /**
   * Collision-heavy helper key used by the resizing and collision exercise in the hash-table series.
   */
  static final class BadHashKey {
    private final String id;

    BadHashKey(String id) {
      this.id = id;
    }

    @Override
    public int hashCode() {
      return 1;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (!(obj instanceof BadHashKey other)) {
        return false;
      }
      return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
      return id;
    }
  }

}
