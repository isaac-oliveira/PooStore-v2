package ufs.br.poostore.store;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStore {
    private final TypeFile fileType;
    private String path;

    public FileStore(TypeFile fileType) {
        this.fileType = fileType;
        this.path = "./Poo.txt";
    }

    public List read() {
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
                list.add(fileType.parseObject(attrs));
                row = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean write(Object object) {
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            List<String> rows = fileType.parseRegister(object);
            for(String row : rows) {
                bufferedWriter.append(row);
                bufferedWriter.newLine();
            }
            bufferedWriter.append("#");
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
