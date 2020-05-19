package IT.HW20;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileDownloader implements Runnable {

    private String URI;
    private int filesize;
    File file;

    public FileDownloader(String URI,int fileSize) {

        this.URI = URI;
        this.filesize = fileSize;

    }


    @Override
    public void run() {
        file = new File("src/IT/HW20/FileDownloads/newFile");
        Path target = Paths.get("src/IT/HW20/FileDownloads/newFile");
        URL website = null;
        try {
            website = new URL(URI);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try (InputStream in = website.openStream()) {
            Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e1){
            e1.printStackTrace();
        }

    }
}
