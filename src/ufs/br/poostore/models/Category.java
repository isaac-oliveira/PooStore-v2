package ufs.br.poostore.models;

import java.io.Serializable;

public class Category implements Serializable, Equals<Category>{
    
    private long id;
    private String name;

    Category() {}

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    @Override
    public String toString(){
        return "Código: " + id + " - Nome: " + name;
    }
    
    @Override
    public boolean isRegistered(Category obj){
        return this.name.equalsIgnoreCase(obj.getName());
    }
}