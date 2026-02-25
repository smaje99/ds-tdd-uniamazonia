package co.edu.udla.ed.scratch;

import co.edu.udla.ed.api.SimpleList;
import co.edu.udla.ed.contract.AbstractSimpleListContractTest;
import co.edu.udla.ed.impl.scratch.SinglyLinkedList;

public class SinglyLinkedListTest extends AbstractSimpleListContractTest {

    @Override
    protected SimpleList<Integer> createList() {
        return new SinglyLinkedList<>();
    }

}
