package IT.HW10;

import java.io.*;

public class CovidObjectOutputStream extends OutputStream {

    private OutputStream out;

    public CovidObjectOutputStream(OutputStream out) {
        this.out = out;
    }

    public void writeCovid(Covid covid) throws IOException {
        try(ObjectOutputStream oout = new ObjectOutputStream(out)){
            oout.writeObject(covid);
        }
        catch (IOException e){
            throw new IOException("Problems with coding",e);
        }
    }

    @Override
    public void write(int b) throws IOException {
        throw new UnsupportedOperationException();
    }
}
