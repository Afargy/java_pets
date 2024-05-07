
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

public class Downloader {

    public void download(List<URL> list) {
        try {
            for (int i = 0; i < list.size(); ++i) {
                URL url = list.get(i);
                HttpURLConnection connection = (HttpURLConnection) url
                        .openConnection();
                InputStream in = connection.getInputStream();
                String outPath = "ex03/res/"
                        + Paths.get(url.getFile()).getFileName();
                FileOutputStream out = new FileOutputStream(outPath);

                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }

                out.flush();
                out.close();
                in.close();
                connection.disconnect();

                System.out.println("File downloaded successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
