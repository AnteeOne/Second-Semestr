package IT.HW10;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CovidDataOutputStream extends OutputStream {
    private OutputStream out;

    public CovidDataOutputStream(OutputStream out) {
        this.out = out;
    }

    public void writeCovid(Covid covid) throws IOException {
        try(DataOutputStream oout = new DataOutputStream(out)){
            oout.writeUTF(covid.getType());
            oout.writeLong(covid.getMortality());
            oout.writeBoolean(covid.isIfVaccineExist());
        }
        catch (IOException e){
            throw new IOException("Problems with encoding",e);
        }
    }
    @Override
    public void write(int b) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void write(byte[] b) throws IOException {
        out.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        out.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        out.flush();
    }

    @Override
    public void close() throws IOException {
        out.close();
    }
}
