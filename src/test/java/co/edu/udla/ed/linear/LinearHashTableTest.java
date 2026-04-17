package co.edu.udla.ed.linear;

import co.edu.udla.ed.api.HashTable;
import co.edu.udla.ed.contract.AbstractHashTableContractTest;
import co.edu.udla.ed.impl.linear.LinearHashTable;

public class LinearHashTableTest extends AbstractHashTableContractTest {

  @Override
  protected HashTable<String, Integer> create() {
    return new LinearHashTable<>();
  }

}
