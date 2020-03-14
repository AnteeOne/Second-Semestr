package IT.HW2;

import IT.HW1.Money;

import java.util.Comparator;

public class MoneyCentComparator implements Comparator<Money> {

    @Override
    public int compare(Money o1, Money o2) {
        return Byte.compare(o1.getCent(),o2.getCent());
    }
}
