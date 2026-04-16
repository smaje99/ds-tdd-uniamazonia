#!/usr/bin/env python3
"""
Quick audit for Java documentation work in educational data-structures repos.

Reports:
1. Java files under the requested path
2. Potential public declarations without a nearby Javadoc block
3. Comment lines that likely contain Spanish text or mixed-language notes
"""

from __future__ import annotations

import re
import sys
from pathlib import Path


DECLARATION_RE = re.compile(
    r"^\s*(public\s+)?(?:(?:static|final|abstract|sealed|non-sealed)\s+)*"
    r"(class|interface|enum|record)\s+\w+|"
    r"^\s*public\s+[^=;]*\([^;]*\)\s*(?:throws\s+[^{]+)?\{?\s*$"
)

SPANISH_RE = re.compile(
    r"\b("
    r"altura|vacio|vacío|raiz|raíz|hijo|hijos|subarbol|subárbol|"
    r"debe|primer|primera|ultimo|último|solo|sólo|duplicado|"
    r"didactica|didáctica|cola|lista|arbol|árbol|nodo|buscar|"
    r"limpiar|capacidad|apunta|encontrado|inserta|mueve|queda"
    r")\b",
    re.IGNORECASE,
)


def has_javadoc(lines: list[str], index: int) -> bool:
    cursor = index - 1
    while cursor >= 0 and not lines[cursor].strip():
        cursor -= 1
    while cursor >= 0 and lines[cursor].strip().startswith("@"):
        cursor -= 1
        while cursor >= 0 and not lines[cursor].strip():
            cursor -= 1
    if cursor < 0:
        return False
    if lines[cursor].strip().endswith("*/"):
        while cursor >= 0:
            stripped = lines[cursor].strip()
            if stripped.startswith("/**"):
                return True
            if stripped.startswith("/*") and not stripped.startswith("/**"):
                return False
            cursor -= 1
    return False


def iter_java_files(root: Path) -> list[Path]:
    if root.is_file() and root.suffix == ".java":
        return [root]
    return sorted(path for path in root.rglob("*.java") if path.is_file())


def audit_file(path: Path) -> tuple[list[str], list[str]]:
    missing_javadoc: list[str] = []
    spanish_comments: list[str] = []
    lines = path.read_text(encoding="utf-8").splitlines()

    for idx, line in enumerate(lines):
        stripped = line.strip()
        indent = len(line) - len(line.lstrip())

        if DECLARATION_RE.match(line) and (
                        "private " not in line
                        and "protected " not in line
                        and (stripped.startswith("public class") or stripped.startswith("public interface") or indent < 4)
                        and not has_javadoc(lines, idx)
                    ):
            missing_javadoc.append(f"{path}:{idx + 1}: {stripped}")

        if (stripped.startswith("//") or stripped.startswith("*") or stripped.startswith("/*")) and SPANISH_RE.search(stripped):
            spanish_comments.append(f"{path}:{idx + 1}: {stripped}")

    return missing_javadoc, spanish_comments


def main() -> int:
    target = Path(sys.argv[1]) if len(sys.argv) > 1 else Path("src/main/java")
    if not target.exists():
      print(f"[ERROR] Path not found: {target}")
      return 1

    java_files = iter_java_files(target)
    print(f"Target: {target}")
    print(f"Java files: {len(java_files)}")
    for file_path in java_files:
        print(f"  - {file_path}")

    all_missing: list[str] = []
    all_spanish: list[str] = []

    for file_path in java_files:
        missing_javadoc, spanish_comments = audit_file(file_path)
        all_missing.extend(missing_javadoc)
        all_spanish.extend(spanish_comments)

    print("\nPotential public declarations without Javadoc:")
    if all_missing:
        for item in all_missing:
            print(f"  {item}")
    else:
        print("  none")

    print("\nPotential Spanish or mixed-language comments:")
    if all_spanish:
        for item in all_spanish:
            print(f"  {item}")
    else:
        print("  none")

    return 0


if __name__ == "__main__":
    raise SystemExit(main())
