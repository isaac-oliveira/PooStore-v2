package ufs.br.poostore.controllers;

import java.util.List;
import ufs.br.poostore.models.Equals;
import ufs.br.poostore.store.FileStore;

public class ListController<T> {
    private List<T> list;
    private FileStore<T> fileStore;
    
    public ListController(String path) {
        this.fileStore = new FileStore<T>(path);
        this.list = fileStore.read();
    }

    public boolean add(T obj) {
        if(!exists(obj)) {
            this.list.add(obj);
            this.fileStore.write(list);
        } else {
            return false;
        }
        return true;
    }

    public boolean remove(T obj) {
        int index = getIndex(obj);
        if(exists(obj)) {
            this.list.remove(index);
            this.fileStore.write(list);
        } else {
            return false;
        }
        return true;
    }

    public boolean update(T obj) {        
        Equals<T> equals = (Equals<T>) obj;
        int index = getIndexById(equals.getId());
        if(!exists(obj)) {
            this.list.set(index, obj);
            this.fileStore.write(list);
        } else {
            return false;
        }
        return true;
    }

    public int getIndex(T obj) {
        Equals<T> equals = (Equals<T>) obj;
        for(int i = 0; i < list.size(); i++)
            if(equals.isRegistered(list.get(i)))
                return i;;
        
        return -1;
    }
    
    public int getIndexById(long id) {
        for(int i = 0; i < list.size(); i++) {
            Equals<T> equals = (Equals<T>) list.get(i);
            if(equals.getId() == id)
                return i;
        }
            
        
        return -1;
    }

    public boolean exists(T obj) {
        return getIndex(obj) != -1;
    }

    public T findOne(long id) {
        for(int i = 0; i < list.size(); i++) {
            Equals<T> equals = (Equals<T>) list.get(i);
            if(equals.getId() == id)
                return list.get(i);
        }
        return null;
    }

    public List<T> find(String value) {
        
        return null;//falta implementar 
    }

    public List<T> getAllList() {
        return this.fileStore.read();
    }
    
}