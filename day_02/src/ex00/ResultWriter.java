package ex00;

import java.io.FileOutputStream;

public class ResultWriter {
    private FileOutputStream fout = null;

    public ResultWriter() throws Exception {
        fout = new FileOutputStream("ex00/results.txt", true);
    }

    public void write(String format) throws Exception {
        if (format != null) {
            fout.write(format.getBytes());
            fout.write('\n');
            System.out.println("PROCESSED");
        } else {
            System.out.println("UNDEFINED");
        }
    }

}
