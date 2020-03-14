package IT.HW1;

public class Money implements Comparable<Money> {
    private int dollars;
    private byte cent;

    @Override
    public int compareTo(Money o) {
        return Integer.compare(this.dollars * 100 + this.cent , o.dollars * 100 + o.cent);
    }

    public int getDollars() {
        return dollars;
    }

    public byte getCent() {
        return cent;
    }
}
