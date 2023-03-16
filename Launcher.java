package LargeFilesOutput;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Launcher {

    public static void searchFile(String folderPath, double minFileSize, List<File> files) {
        File folder = new File(folderPath);
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                searchFile(file.getAbsolutePath(), minFileSize, files);
            }
            if (file.exists() && file.length() > minFileSize * (1024 * 1024)) {
                files.add(file);
            }
        }
    }

    public static void main(final String[] args) {
       // System.out.println(Arrays.toString(args));
        try {
            FileRequest fileRequest = CommandLineParser.parse(args);
            List<File> files = new ArrayList<>();
            searchFile(fileRequest.getFolderPath(), fileRequest.getMinFileSize(), files);

            LargeFilesOutput.Comparator comparator = new Comparator();
            files.sort(comparator);
            for (File file : files) {
                if (file.length() >= 1024 * 1024 * 1024) {
                    System.out.println("Путь к файлу: " + file.getAbsolutePath() + " Размер: " + file.length() / (1024 * 1024 * 1024) + " GB");
                } else if (file.length() >= 1024 * 1024) {
                    System.out.println("Путь к файлу: " + file.getAbsolutePath() + " Размер: " + file.length() / (1024 * 1024) + " MB");
                } else if (file.length() >= 1024) {
                    System.out.println("Путь к файлу: " + file.getAbsolutePath() + " Размер: " + file.length() / (1024) + " KB");
                } else {
                    System.out.println("Путь к файлу: " + file.getAbsolutePath() + " Размер: " + file.length() + " B");
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Указанная директория пуста" + " " + e.getMessage());
        }
    }
}
