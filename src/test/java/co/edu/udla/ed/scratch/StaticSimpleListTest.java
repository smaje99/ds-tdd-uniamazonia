package co.edu.udla.ed.scratch;

import co.edu.udla.ed.api.SimpleList;
import co.edu.udla.ed.contract.AbstractSimpleListContractTest;
import co.edu.udla.ed.impl.scratch.StaticSimpleList;

public class StaticSimpleListTest extends AbstractSimpleListContractTest {

    @Override
    protected SimpleList<Integer> createList() {
        return new StaticSimpleList<>();
    }

}
