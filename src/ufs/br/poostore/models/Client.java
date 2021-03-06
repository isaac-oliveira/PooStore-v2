package ufs.br.poostore.models;

import java.io.Serializable;

/**
 *
 * @author isaac
 */
public class Client implements Serializable, Equals<Client> {
    private long id;
    private String name;
    private String cpf;
    private String phone;

    public Client() {}

    public Client(long id, String name, String cpf, String phone) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Código " + id + " - Nome: " + name;
    }
    
    @Override
    public boolean isRegistered(Client obj) {
        return this.cpf.equalsIgnoreCase(obj.getCpf());
    }
}
