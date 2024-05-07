package ex03;

public class Program {
    private static ArgumentsParser arguments = null;
    private static Urls urls = null;

    public static void main(String[] args) {
        try {
            parseArguments(args);
            parserUrls();
            download();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void parseArguments(String[] args)
            throws IllegalArgumentException {
        arguments = new ArgumentsParser(args);
    }

    private static void parserUrls() {
        urls = new Urls("ex03/files_urls.txt");
    }

    private static void download() {
        CommonCounter counter = new CommonCounter();

        for (int i = 1; i <= arguments.getThreadsCount(); ++i) {
            Thread th = new Thread(new Downloader(urls, counter));

            th.setName("Thread " + i);
            th.start();
        }
    }
}
