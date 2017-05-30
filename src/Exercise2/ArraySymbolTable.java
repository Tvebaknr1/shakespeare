/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise2;

import Interfaces.OrderedSymbolTable;

/**
 *
 * @author LouiseB
 */
public class ArraySymbolTable implements OrderedSymbolTable<String, Integer> {

    private FlexibleArray<Words> words = new FlexibleArray<>();

    public void print() {
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i).key + ": " + words.get(i).value);
        }
    }

    @Override
    public Integer get(String key) {
        for (int i = 0; i < words.size(); i++) {
            int compare = words.get(i).key.compareTo(key);
            
            // nedstående virker ikke - den laver en leksikalsk sammenligning. 
            // Hvis a sammenlignes med b giver det minus 1. 
            // hvis b sammenlignes med c giver det plus 1. 
            // Hvis den derfor er større er der ikke noget der tager højde for det
            
            //if (compare > 0) {
            //    return null;
            //}
            
            if (compare == 0) {
                return words.get(i).value;
            }
        }
        return null;
    }

    @Override
    public void put(String key, Integer value) {
        boolean insert = true;

        if (words.size() == 0) {
            Words word = new Words(key, value);
            words.add(word);
            words.add(word);
        }

        for (int i = 0; i < words.size(); i++) {
            Words word = words.get(i);
            int compareValue = word.key.compareTo(key);
            
            // Could also be != ???
            if (compareValue < 0) {
                continue;
            }
            if (compareValue == 0) {
                insert = false;
                word.value = value;

            } else {
            }
        }

        if (insert) {
            Words word = new Words(key, value);
            word.key = key;
            word.value = value;
            words.add(word);
        }
    }

    @Override
    public String min() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String max() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String floor(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ceiling(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int rank(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String select(int rank) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size(String low, String high) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<String> keys(String low, String high) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<String> keys() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
