package LargeFilesOutput;

import java.io.File;

public class Comparator implements java.util.Comparator<File> {
    @Override
    public int compare(File o1, File o2) {
        return (int) (o2.length() - o1.length());
    }

}
