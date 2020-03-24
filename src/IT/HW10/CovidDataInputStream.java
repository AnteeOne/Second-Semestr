package IT.HW10;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class CovidDataInputStream extends InputStream {
    private InputStream in;

    public CovidDataInputStream(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        throw new UnsupportedOperationException();
    }

    public Object readCovid(){
        Covid res = null;
        String type;
        long mortality;
        boolean ifExistVaccine;
        try(DataInputStream oin = new DataInputStream(in)){
            type = oin.readUTF();
            mortality = oin.readLong();
            ifExistVaccine = oin.readBoolean();
            res = new Covid(type,mortality,ifExistVaccine);
        }
        catch (IOException  e){
            e.printStackTrace();
        }
        return res;
    }
}
