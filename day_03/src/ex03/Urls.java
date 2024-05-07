package ex03;

import java.net.URL;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Urls {
    private List<URL> list = new ArrayList<URL>();

    Urls(String filePath) {
        try {
            List<String> strs = Files.readAllLines(Paths.get(filePath));

            for (String str : strs) {
                list.add(new URL(str.split(" ")[1]));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<URL> getList() {
        return list;
    }

    public synchronized URL getUrl(Integer index) {
        return list.get(index);
    }

    public Integer getSize() {
        return list.size();
    }

}
