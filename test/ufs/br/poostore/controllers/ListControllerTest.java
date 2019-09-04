/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufs.br.poostore.controllers;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import ufs.br.poostore.models.Client;
import ufs.br.poostore.store.FileStore;

/**
 *
 * @author isaac
 */
public class ListControllerTest {
    
    public ListControllerTest() {
    }

    @Test
    public void testAdd() {
        System.out.println("add");
        Client obj = new Client(1, "", "2", "");
        ListController<Client> instance = new ListController<Client>("./clienttest.dat");
        boolean expResult = false;
        boolean result = instance.add(obj);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testUpdate() {
        System.out.println("update");
        Client obj = new Client(1, "", "2", "");
        ListController<Client> instance = new ListController<Client>("./clienttest.dat");
        boolean expResult = true;
        boolean result = instance.update(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRemove() {
        System.out.println("remove");
        Client obj = new Client(1, "", "", "");
        ListController<Client> instance = new ListController<Client>("./clienttest.dat");
        boolean expResult = false;
        boolean result = instance.remove(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetIndex() {
        System.out.println("getIndex");
        Client obj = new Client(1, "Nome", "135363", "52565623656");
        ListController<Client> instance = new ListController<Client>("./clienttest.dat");
        int expResult = -1;
        int result = instance.getIndex(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testExists() {
        System.out.println("exists");
        Client obj = new Client(1, "", "", "");
        ListController<Client> instance = new ListController<Client>("./clienttest.dat");
        boolean expResult = false;
        boolean result = instance.exists(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindOne() {
        System.out.println("findOne");//implentar teste
    }

    @Test
    public void testFind() {
        System.out.println("find");//implentar teste
    }

    @Test
    public void testGetAllList() {
        System.out.println("getAllList");
        ListController<Client> instance = new ListController<Client>("./clienttest.dat");
        int expResult = new FileStore<Client>("./clienttest.dat").read().size();
        int result = instance.getAllList().size();
        assertEquals(expResult, result);
    }    
}
