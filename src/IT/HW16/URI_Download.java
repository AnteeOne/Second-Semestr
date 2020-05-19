package IT.HW16;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URI_Download {

    public void run() {
        String path = "https://ru.wikipedia.org/wiki/Монтеро,_Ирене";
        String filepath = "src/IT/HW16/result";
        File file = new File(filepath);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new URI(path).toURL().openConnection().getInputStream()));
             FileWriter out = new FileWriter(file)) {
            String contentType = new URI(path).toURL().openConnection().getContentType();
            String line;
            int stringCount = 0;
            int divcount = 0;
            while ((line = in.readLine()) != null) {
                out.write(line + "\n");
                stringCount++;
                Matcher matcher = Pattern.compile("(<div>|<div|/div>|</div>)").matcher(line);
                while (matcher.find()){
                    divcount++;
                }
            }
            System.out.println("Count of lines in file = " + stringCount);
            System.out.println("Count of divs in file = " + divcount);
            if (contentType != null || !contentType.equals("")) {
                File file2 = new File(file.getParent() + stringCount +"result." + contentType.split("[;./|]+")[1]);
                Files.copy(file.toPath(), file2.toPath());
            }
        } catch (URISyntaxException e) {
            System.out.println("Incorrect URI");
        } catch (FileAlreadyExistsException e1) {
            System.out.println("This file is already exist!");
        } catch (IOException e2) {
            System.out.println("Problems with encoding!");
        }

    }
}
