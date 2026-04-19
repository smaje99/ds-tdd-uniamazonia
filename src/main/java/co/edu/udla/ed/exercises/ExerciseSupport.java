package co.edu.udla.ed.exercises;

import java.util.ArrayList;
import java.util.Objects;

final class ExerciseSupport {

  private ExerciseSupport() {
  }

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

  static String format(String... parts) {
    return String.join("|", parts);
  }

  static String named(String name, Object value) {
    return name + "=" + value;
  }

  static Learner learner(String name, int code) {
    return new Learner(name, code);
  }

  static RankedLearner rankedLearner(String name, int level) {
    return new RankedLearner(name, level);
  }

  static EnrollmentKey enrollmentKey(String course, String section) {
    return new EnrollmentKey(course, section);
  }

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
