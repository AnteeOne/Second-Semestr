package IT.HW10;

import java.io.*;

public class CovidObjectOutputStream extends OutputStream {

    private OutputStream out;

    public CovidObjectOutputStream(OutputStream out) {
        this.out = out;
    }

    public void writeCovid(Covid covid){
        try(ObjectOutputStream oout = new ObjectOutputStream(out)){
            oout.writeObject(covid);
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
