/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufs.br.poostore.store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isaac
 */
public class IdFile {
    public static final String CLIENT_ID = "client_id";
    public static final String CATEGORY_ID = "category_id";
    public static final String SALE_ID = "sale_id";
    public static final String PRODUCT_STOCK_ID = "product_stock_id";
    public static final String PRODUCT_SALE_ID = "product_sale_id";
    private String path = "./ids.txt";
    
    private IdFile() {}
    
    public static IdFile getInstance() {
        return new IdFile();
    }
    
    public long generateID(String type) {
        List<String> list = read();
        long id = 0;
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            String[] parts = list.get(i).split(":");
            if(parts[0].equals(type)) {
                id = Long.parseLong(parts[1]) + 1;
                list.set(i, type + ":" + id);
                System.out.println(list.get(i));
            }
        }
        write(list);
        return id;
    }
    
    private List<String> read() {
        List<String> list = new ArrayList<>();
        try {
            if(checkFile(path)) {
                FileReader file = new FileReader(path);
                BufferedReader bufferedReader = new BufferedReader(file);
                String line = bufferedReader.readLine();
                while(line != null) {
                    list.add(line);
                    line = bufferedReader.readLine();
                }
                file.close();
                bufferedReader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    private void write(List<String> list) {
        try {
            FileWriter file = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            bufferedWriter.append("");
            bufferedWriter = new BufferedWriter(new FileWriter(path, true));
            for(String line : list) {
                bufferedWriter.append(line);
                bufferedWriter.newLine();
            }
            file.flush();
            file.close();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean checkFile(String path) throws IOException {
        File file = new File(path);
        if(!file.exists()) {
            file.createNewFile();
            List<String> list = new ArrayList<>();
            list.add(CLIENT_ID + ":0");
            list.add(CATEGORY_ID + ":0");
            list.add(SALE_ID + ":0");
            list.add(PRODUCT_STOCK_ID + ":0");
            list.add(PRODUCT_SALE_ID + ":0");
            write(list);
        }
                 
        return file.canRead();
    }
}
