package practice.ch3.source;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FileUtils {
    public static File[] searchAllSubDirectory(String directoryName) {
        File file = new File(directoryName);

        if(file.isDirectory()) {
            return file.listFiles(File::isDirectory);
        } else {
            return null;
        }
    }

    public static String[] searchFileForExtension(String directoryName, String extension) {
        File file = new File(directoryName);

        if(file.isDirectory()) {
            return file.list((subFile, fileName) -> fileName.endsWith(extension));
        } else {
            return null;
        }
    }

    public static void sortFile(File[] files) {
        Arrays.sort(files, Comparator.comparing(File::isFile).thenComparing(File::getName));
    }
}
