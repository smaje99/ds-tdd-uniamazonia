package co.edu.udla.ed.scratch;

import co.edu.udla.ed.api.CircularList;
import co.edu.udla.ed.contract.AbstractCircularListContractTest;
import co.edu.udla.ed.impl.scratch.CircularSinglyLinkedList;

public class CircularSinglyLinkedListTest extends AbstractCircularListContractTest {

    @Override
    protected CircularList<Integer> create() {
        return new CircularSinglyLinkedList<>();
    }

}
