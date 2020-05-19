package IT.HW10;

import java.io.Serializable;
import java.util.Objects;

public class Covid implements Serializable {
    private String type;
    private long mortality;
    private boolean ifVaccineExist;

    public Covid(String type, long mortality,  boolean ifVaccineExist) {
        this.type = type;
        this.mortality = mortality;
        this.ifVaccineExist = ifVaccineExist;
    }

    public String getType() {
        return type;
    }

    public long getMortality() {
        return mortality;
    }

    public boolean isIfVaccineExist() {
        return ifVaccineExist;
    }

    @Override
    public String toString() {
        return "Covid{" +
                "type='" + type + '\'' +
                ", mortality=" + mortality +
                ", ifVaccineExist=" + ifVaccineExist +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Covid covid = (Covid) o;
        return mortality == covid.mortality &&
                ifVaccineExist == covid.ifVaccineExist &&
                Objects.equals(type, covid.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, mortality, ifVaccineExist);
    }
}
