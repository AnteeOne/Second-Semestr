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

    public Object readCovid() throws IOException {
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
            throw new IOException("Problems with coding",e);
        }
        return res;
    }

    @Override
    public int read(byte[] b) throws IOException {
        return in.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return in.read(b, off, len);
    }

    @Override
    public long skip(long n) throws IOException {
        return in.skip(n);
    }

    @Override
    public int available() throws IOException {
        return in.available();
    }

    @Override
    public void close() throws IOException {
        in.close();
    }

    @Override
    public void mark(int readlimit) {
        in.mark(readlimit);
    }

    @Override
    public void reset() throws IOException {
        in.reset();
    }

    @Override
    public boolean markSupported() {
        return in.markSupported();
    }
}
