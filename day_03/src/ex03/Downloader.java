package ex03;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Downloader implements Runnable {
    private List<URL> urls = null;
    private CommonCounter counter = null;

    Downloader(Urls urls, CommonCounter counter) {
        this.urls = urls.getList();
        this.counter = counter;
    }

    private void download(Integer current) {
        try {
            URL url = urls.get(current);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            InputStream in = connection.getInputStream();
            String outDir = "ex03/downloads/";
            FileOutputStream out = null;
            byte[] buffer = new byte[4096];
            int bytesRead;

            if (!Files.exists(Paths.get(outDir))) {
                Files.createDirectory(Paths.get(outDir));
            }

            out = new FileOutputStream(
                    outDir + Paths.get(url.getFile()).getFileName());

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            out.flush();
            out.close();
            in.close();
            connection.disconnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        while (counter.getCounter() < urls.size()) {
            Integer current = 0;

            synchronized (counter) {
                current = counter.getCounter();
                counter.increment();
            }

            System.out.println(Thread.currentThread().getName()
                    + " start download file number " + (current + 1));
            download(current);
            System.out.println(Thread.currentThread().getName()
                    + " finish download file number " + (current + 1));
        }
    }

}
