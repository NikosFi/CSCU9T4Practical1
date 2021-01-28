// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;


import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;

    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor

    // add a record to the list
    public void addEntry(Entry e) {
        // addClass

        tr.add(e);
        if(checkKeys()){
            tr.remove(tr.size() - 1);
            System.out.println("name exists");
        }
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
                    i++;
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