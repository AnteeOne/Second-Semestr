package IT.HW10;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;


public class CovidObjectInputStream extends InputStream {
    private InputStream in;

    public CovidObjectInputStream(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        throw new UnsupportedOperationException();
    }

    public Object readCovid(){
        Covid res = null;
        try(ObjectInputStream oin = new ObjectInputStream(in)){
             res = (Covid) oin.readObject();
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return res;
    }
}
