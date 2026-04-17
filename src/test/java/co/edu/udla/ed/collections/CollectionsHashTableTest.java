package co.edu.udla.ed.collections;

import co.edu.udla.ed.api.HashTable;
import co.edu.udla.ed.contract.AbstractHashTableContractTest;
import co.edu.udla.ed.impl.collections.CollectionsHashTable;

public class CollectionsHashTableTest extends AbstractHashTableContractTest {

  @Override
  protected HashTable<String, Integer> create() {
    return new CollectionsHashTable<>();
  }

}
