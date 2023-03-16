package LargeFilesOutput;

public class FileRequest {
    private final String folderPath;
    private final double minFileSize;

    public FileRequest(String folderPath, double minFileSize) {
        this.folderPath = folderPath;
        this.minFileSize = minFileSize;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public double getMinFileSize() {
        return minFileSize;
    }

    public static FileRequest create(String folderPath, double minFileSize) {
        return new FileRequest(folderPath, minFileSize);
    }
}
