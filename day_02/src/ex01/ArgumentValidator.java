package ex01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ArgumentValidator {

    public void validate(String[] args) throws Exception {
        validateNumber(args);
        validateAreDiffrent(args[0], args[1]);

        for (int i = 0; i < args.length; ++i) {
            File file = new File(args[i]);

            validateExists(file);
            checkReadable(file);
        }
    }

    private void validateNumber(String[] args) throws IllegalArgumentException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Two arguments expected");
        }
    }

    private void validateAreDiffrent(String path1, String path2)
            throws IllegalArgumentException {
        if (path1.equals(path2)) {
            throw new IllegalArgumentException("Same file");
        }
    }

    private void validateExists(File file) throws FileNotFoundException {
        if ((!file.exists())) {
            throw new FileNotFoundException("File doesn't exist");
        }
    }

    private void checkReadable(File file) throws IOException {
        if ((!file.canRead())) {
            throw new IOException("File can't be read");
        }
    }

}
