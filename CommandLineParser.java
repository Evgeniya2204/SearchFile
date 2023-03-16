package LargeFilesOutput;

public class CommandLineParser {
    public static FileRequest parse(final String[] args) {

        String folderPath = args[0];
        double minFileSize = Double.parseDouble(args[1]);
        return FileRequest.create(folderPath, minFileSize);
    }
}
