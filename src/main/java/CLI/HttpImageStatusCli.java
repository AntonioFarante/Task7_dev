package CLI;

import MethodsToGetCats.HttpStatusChecker;
import MethodsToGetCats.HttpStatusImageDownloader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() throws IOException, URISyntaxException, InterruptedException {
        boolean isNotExist = true;
        while (isNotExist){
            System.out.println("Enter HTTP status code");
            Scanner reader = new Scanner(System.in);
            String line = reader.nextLine();
            try {
                int statusCode = Integer.parseInt(line);
                try {
                    new HttpStatusImageDownloader().downloadStatusImage(statusCode);
                    isNotExist = false;
                } catch (FileNotFoundException e) {
                    System.out.println("There is not image for HTTP status <CODE>");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid number");
            }

        }
    }
}
