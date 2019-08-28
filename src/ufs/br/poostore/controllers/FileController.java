package ufs.br.poostore.controllers;

import java.util.List;

/**
 *
 * @author isaac
 */
public interface FileController {
    void add(Object object);
    void remove(Object object);
    int getIndex(Object object);
    boolean isExists(Object object);
    Object findOne(String value);
    List find(String value);
    List getAllList();
}
