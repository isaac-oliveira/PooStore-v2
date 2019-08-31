package ufs.br.poostore.store;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author isaac
 */
public class FileStore<T> {
    private String path;

    public FileStore(String path) {
        this.path = path;
    }
    
    public List<T> read() {
        List<T> list = new ArrayList();
        try {
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream objectRead = new ObjectInputStream(file);
            list = (List<T>) objectRead.readObject();
            objectRead.close();
            file.close();
          } catch(Exception e) {
            e.printStackTrace();
          }
        return list;
    }

    public boolean write(List<T> list) {
        try {
            FileOutputStream file = new FileOutputStream(path);
            ObjectOutputStream objectWrite = new ObjectOutputStream(file);
            objectWrite.writeObject(list);
            objectWrite.flush();
            objectWrite.close();
            file.flush();
            file.close();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
