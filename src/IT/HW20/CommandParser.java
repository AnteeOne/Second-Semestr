// uri - https://anteeone.pythonanywhere.com/static/portfolio_image.jpg

package IT.HW20;

import java.util.Scanner;

public class CommandParser implements Runnable {

    FileDownloader fileDownloader;
    Thread fileDowloaderThread;

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        String command;
        int fileSize = 1;
        while(true) {
            command = sc.nextLine();
            switch (command) {
                case "download":
                    System.out.println("Input URI:");
                    fileDownloader = new FileDownloader(sc.nextLine(),883712);
                    fileDowloaderThread = new Thread(fileDownloader);
                    fileDowloaderThread.start();

                    break;

                case "pr":
                    if(fileDownloader == null){
                        System.out.println("No active downloading");
                    }
                    else{
                        System.out.println((int) fileDownloader.file.length() / 8830 + " % already downloaded");
                    }
                    break;

                case "stop":
                    fileDowloaderThread.stop();
                    System.out.println("File isn't fully downloaded");
                    if(fileDownloader == null ) System.out.println("fileDownloader == null");
                    return;


            }
        }
    }
}
