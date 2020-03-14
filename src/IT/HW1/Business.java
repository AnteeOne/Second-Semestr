package IT.HW1;

public class Business implements Comparable<Business> {
    long income;
    long outcome;

    public long CalculateMagically(){
        return 5 * this.income - 4 * this.outcome + 10;
    }

    @Override
    public int compareTo(Business o) {
        if(this.CalculateMagically() - o.CalculateMagically() > 10){
            return 1;
        }
        if(this.CalculateMagically() - o.CalculateMagically() == 10){
            return 0;
        }
        else{
            return -1;
        }
    }
}
