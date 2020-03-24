package IT.HW10;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class CovidDataOutputStream extends OutputStream {
    private OutputStream out;

    public CovidDataOutputStream(OutputStream out) {
        this.out = out;
    }

    public void writeCovid(Covid covid){
        try(DataOutputStream oout = new DataOutputStream(out)){
            oout.writeUTF(covid.getType());
            oout.writeLong(covid.getMortality());
            oout.writeBoolean(covid.isIfVaccineExist());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void write(int b) throws IOException {
        throw new UnsupportedOperationException();
    }
}
