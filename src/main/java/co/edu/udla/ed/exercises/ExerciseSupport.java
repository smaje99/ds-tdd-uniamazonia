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
