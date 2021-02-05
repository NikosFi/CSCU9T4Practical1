// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;


import java.util.*;
import java.util.stream.Collectors;


public class TrainingRecord {
    private List<Entry> tr;

    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor

    // add a record to the list
    public void addEntry(Entry e) {
        tr.add(e);
    }


    public void removeLastEntry() {
        tr.remove(tr.size() - 1);
    }

    public String removeEntry(String n, int d, int m, int y) {
        tr.removeIf(e -> e.getName().equals(n) && e.getDay() == d && e.getMonth() == m && e.getYear() == y);
        return n;
    }


    public boolean checkKeys() {
        boolean flag = false;
        int i = tr.size() - 1;
        for (int j = 0; j < i; j++) {
            if (tr.get(i).getName().compareTo(tr.get(j).getName()) == 0) {
                flag = true;
            }
            System.out.println(flag);
        } return flag;
    }

    public String findAllByName(String name) {
        ListIterator<Entry> iter = tr.listIterator();
        int i = 0;
        StringBuilder result = new StringBuilder();
        for (Entry current: tr) {
            if(iter.hasNext()) {
                current = iter.next();
                if(current.getName().equals(name)){
                    result.append(current.getEntry());
                } else {
                    i++; // this is a counter
                }
            }
        }
        if (i == tr.size()) {
            return "No entries found";
        } else {
            return result.toString();

        }
    }

    // look up the entry of a given day and month
    public String lookupEntry(int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No entries found";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                result = current.getEntry();
            }
        }
        return result;
    } // lookupEntry

    public String findAllEntries(int d, int m, int y) {
        //StringBuilder sb = new StringBuilder();
        ListIterator<Entry> iter = tr.listIterator();
        String result = "";
        int i = 0;
        for (Entry current : tr) {
            if (iter.hasNext()) {  //validation
                current = iter.next();
                if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                    result = result.concat(current.getEntry());
                    // sb.append(result);
                } else {
                    i++; // this is a counter
                }
            }
        }
        if (i == tr.size()) {
            return "No entries found";
        } else {
            return result;
            //sb.toString();
        }
    }


    // Count the number of entries
    public int getNumberOfEntries() {
        return tr.size();
    }

    // Clear all entries
    public void clearAllEntries() {
        tr.clear();
    }

} // TrainingRecord