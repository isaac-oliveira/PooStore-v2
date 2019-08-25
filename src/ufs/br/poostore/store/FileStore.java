package ufs.br.poostore.store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileStore {
    private final FileType fileType;
    private String path;

    public FileStore(FileType fileType) {
        this.fileType = fileType;
    }

    public List read(String path) {
        List list = new ArrayList();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String row = bufferedReader.readLine();
            while(row != null) {
                List<String> attrs = new ArrayList<>();
                while (!row.equalsIgnoreCase("#")) {
                    attrs.add(row);
                    row = bufferedReader.readLine();
                }
                list.add(fileType.getObject(attrs));
                row = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
