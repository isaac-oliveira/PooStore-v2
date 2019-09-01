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
    private static final int WRITE = 0;
    private static final int READ = 1;

    public FileStore(String path) {
        this.path = path;
    }
    
    public List<T> read() {
        List<T> list = new ArrayList();
        try {
            if(checkFile(path, READ)) {
                FileInputStream file = new FileInputStream(path);
                ObjectInputStream objectRead = new ObjectInputStream(file);
                list = (List<T>) objectRead.readObject();
                objectRead.close();
                file.close();
            }
          } catch(Exception e) {
            e.printStackTrace();
          }
        return list;
    }

    public boolean write(List<T> list) {
        try {
            if(checkFile(path, WRITE)) {
                FileOutputStream file = new FileOutputStream(path);
                ObjectOutputStream objectWrite = new ObjectOutputStream(file);
                objectWrite.writeObject(list);
                objectWrite.flush();
                objectWrite.close();
                file.flush();
                file.close();   
            }
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean checkFile(String path, int op) throws IOException {
        File file = new File(path);
        if(!file.exists() && op != READ)
            file.createNewFile();
        return op == WRITE ? file.canWrite() : file.canRead();
    }
}
