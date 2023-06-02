package MethodsToGetCats;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) throws IOException, URISyntaxException, InterruptedException {

        URL url = new URL(new HttpStatusChecker().getStatusImage(code));
        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1!=(n=in.read(buf)))
        {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] response = out.toByteArray();

        FileOutputStream fos = new FileOutputStream("C:\\Users\\HP\\IdeaProjects\\Task7_dev\\src\\image.jpg");
        fos.write(response);
        fos.close();
    }
}
