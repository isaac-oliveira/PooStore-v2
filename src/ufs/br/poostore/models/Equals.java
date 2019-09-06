package ufs.br.poostore.models;

/**
 *
 * @author isaac
 */
public interface Equals<T> {
    boolean isRegistered(T obj);
    long getId();
}
