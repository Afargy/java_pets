package ex02;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class WorkingDirectory {
    private Path curDir = null;

    WorkingDirectory(Path path) throws FileNotFoundException {
        curDir = path;
    }

    public void ls() throws Exception {
        Stream<Path> stream = Files.list(curDir);

        stream.forEach(file -> {
            try {
                System.err.print(file.getFileName() + " ");
                System.out.println((Files.size(file) / 1000) + " KB");
            } catch (Exception e) {
                System.out.println("Can't read size " + e.getMessage());
            }
        });

        stream.close();
    }

    public void cd(String str) throws IllegalArgumentException {
        Path path = resolve(str);

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("cd: no such directory " + path);
        }

        curDir = path;
        System.out.println(curDir);
    }

    public void mv(String str) throws Exception {
        String[] args = str.split("\\s+");
        Path what = null;
        Path where = null;

        if (args.length != 2) {
            throw new IllegalArgumentException("mv: wrong arguments");
        }

        what = resolve(args[0]);
        where = resolve(args[1]);

        if (!Files.exists(what)) {
            throw new IllegalArgumentException(
                    "mv: " + what + " doesn't exist");
        }

        if (Files.isDirectory(where)) {
            where = where.resolve(what.getFileName());
        }

        Files.move(what, where);
    }

    private Path resolve(String path) {
        Path resolved = Paths.get(path);

        if (!resolved.isAbsolute()) {
            resolved = curDir.resolve(path);
        }

        return resolved.normalize();
    }

}
