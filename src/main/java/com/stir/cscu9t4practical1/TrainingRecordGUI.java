// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;


import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);

    private JTextField repetitions = new JTextField(2);
    private JTextField recoveryTime = new JTextField(2);
    private JTextField tookPlace = new JTextField(2);
    private JTextField terrain = new JTextField(2);
    private JTextField tempo = new JTextField(2);


    private JLabel labrepetitions = new JLabel(" Reps:");
    private JLabel labrecoveryTime = new JLabel(" Rest Time:");
    private JLabel labtookPlace = new JLabel(" Place:");
    private JLabel labtempo = new JLabel(" Tempo:");
    private JLabel labterrain = new JLabel(" Terrain:");

    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");

    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find All By Date");
    private JButton findAllByName = new JButton("Find By Name");
    private JButton remove = new JButton("Remove");


    private String[] types = {"Sprint", "Cycle", "Swim"}; //declare the three types of Entries
    private String drdTitle = "-Type-";

    JComboBox type = new JComboBox(types); //type name for dropdown for choosing type of entry
    //initializing the combo box


    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);


    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();

    } // main


    // set up the GUI
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());

        type.setRenderer(new DropDown.MyComboBoxRenderer(drdTitle));
        type.setSelectedIndex(-1);
        add(type);
        type.addActionListener(this);


        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);

        // ---------- Sprint Fields -------------- //
        add(labrepetitions);
        add(repetitions);
        repetitions.setEditable(false);//repetitions
        add(labrecoveryTime);
        add(recoveryTime);
        recoveryTime.setEditable(false);///recoveryTime

        // ---------- Cycle Fields -------------- //
        add(labterrain);//
        add(terrain);//
        terrain.setEditable(false);///terrain
        add(labtempo);//
        add(tempo);//
        tempo.setEditable(false);//tempo

        // ---------- Swim Fields -------------- //
        add(labtookPlace);
        add(tookPlace);
        tookPlace.setEditable(false);// tookPlace

        //-----------------------------------------//

        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        add(findAllByName);
        findAllByName.addActionListener(this);
        add(remove);
        remove.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 300);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)

    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate) {
            message = findAllByDate();
        }
        if(event.getSource() == findAllByName ) {
            message = findAllByName();
        }
        if(event.getSource() == remove) {
            message = removeEntry();
        }

        //declare switch cases for the options of the entry (event source is the type drpdown;)
        if (event.getSource() == type) {
            String cases = (String) type.getSelectedItem();//get the selected item from the typeArray
            //casting is necessary because getSelectedItem returns an Object

            switch (cases) {//check for a match
                case "Sprint":
                    System.out.println("Sprint selected"); //temporary console check
                    recoveryTime.setEditable(true);
                    repetitions.setEditable(true);

                    terrain.setEditable(false);
                    tempo.setEditable(false);
                    tookPlace.setEditable(false);
                    repaint();
                    break;
                case "Cycle":
                    System.out.println("Cycle selected");//temporary console check
                    terrain.setEditable(true);
                    tempo.setEditable(true);

                    recoveryTime.setEditable(false);
                    repetitions.setEditable(false);
                    tookPlace.setEditable(false);
                    break;
                case "Swim":
                    System.out.println("Swim selected"); //temporary console check
                    tookPlace.setEditable(true);

                    recoveryTime.setEditable(false);
                    repetitions.setEditable(false);
                    terrain.setEditable(false);
                    tempo.setEditable(false);
                    break;
            }
        }

        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed


    //-------------------- Functionality for the DropDown ------------------------ //

    // Main Functionality of the dropDown + validation functions

    //(if there is time, transfer them to @TrainingRecord class)


    /**
     * typeSprint method
     * Checking whether the selected type on the dropdown "type"
     * equals Sprint
     * Utilizes the getSelectedItem pre-build function
     *
     * @return Returns true if the type equals to Sprint
     */
    public boolean typeSprint() { //type checking for sprint
        if (type.getSelectedIndex() == 1) {
            System.out.println("Sprint type is selected");
        }
        return true;
    }

    /**
     * typeCycle method
     * Checking whether the selected type on the dropdown "type"
     * equals Cycle
     * Utilizes the getSelectedItem pre-build function
     *
     * @return Returns true if the type equals to Cycle
     */
    public boolean typeCycle() { //type checking for cycle
        if (type.getSelectedItem() == "Cycle") {
            System.out.println("i made it");
        }
        return true;
    }

    /**
     * typeSwim method
     * Checking whether the selected type on the dropdown "type"
     * equals Swim
     * Utilizes the getSelectedItem pre-build function
     *
     * @return Returns true if the type equals to Swim
     */
    public boolean typeSwim() { //type checking for cycle
        if (type.getSelectedItem() == "Swim") {
            System.out.println("i made it");
        }
        return true;
    }
    // -------------------------------------------------------------------------//

    public void validateSprint() {
        if (repetitions.getText().isEmpty() || recoveryTime.getText().isEmpty()) {
            throw new IllegalArgumentException();
        }

    }

    public void validateCycle() {
        if (terrain.getText().isEmpty() || tempo.getText().isEmpty())
            throw new IllegalArgumentException();
    }

    public void validateSwim() {
        if (tookPlace.getText().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }


    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding " + what + " entry to the records");


        String n = name.getText();
        if (name.getText().isEmpty()) {
            return message = "Please fill the 'Name field'";

        } // make it


        int m, d, y;
        try {
            m = Integer.parseInt(month.getText());
            d = Integer.parseInt(day.getText());
            y = Integer.parseInt(year.getText());
            dateRangeException(m, d, y); //date out of range (not completed implementation)
        } catch (NumberFormatException e) {
            return message = "Please enter a valid date";
        } catch (IllegalArgumentException e) {
            return message = "Please enter a valid date";
        }

        float km;
        int h, mm, s;
        try {
            h = Integer.parseInt(hours.getText());
            mm = Integer.parseInt(mins.getText());
            s = Integer.parseInt(secs.getText());
            km = java.lang.Float.parseFloat(dist.getText());
        } catch (NumberFormatException e) {
            return message = "Please enter a valid time and distance";
        }


        if (type.getSelectedIndex() == 0) {
            try {
                int reps = Integer.parseInt(repetitions.getText());
                int rest = Integer.parseInt(recoveryTime.getText());
                SprintEntry sprint = new SprintEntry(n, m, d, y, h, mm, s, km, reps, rest);
                if (myAthletes.checkKeys()) {
                    message = "This name already exists"; //CHANGE THE METHOD TO GO THROUGH THE ARRAY WITH AN OBJECT
                } else {
                    myAthletes.addEntry(sprint);
                }
                validateSprint();
            } catch (NumberFormatException e) {
                return message = "Please fill the fields 'Reps' and 'Rest Time' while" +
                        "Sprint is selected";
            }
        }
        if (type.getSelectedIndex() == 1) {
            try {
                String ter = (terrain.getText());
                String temp =(tempo.getText());
                CycleEntry cycle = new CycleEntry(n, m, d, y, h, mm, s, km, ter, temp);
                if (myAthletes.checkKeys()) {
                    message = "This name already exists"; //CHANGE THE METHOD TO GO THROUGH THE ARRAY WITH AN OBJECT
                } else {
                    myAthletes.addEntry(cycle);
                }
                validateCycle();
            } catch (NumberFormatException e) {
                return message = "Please fill the fields 'Terrain' and 'Tempo' while" ;
            }
        }
        if (type.getSelectedIndex() == 2) {
            try {
                String place = tookPlace.getText();
                SwimEntry swim = new SwimEntry(n, m, d, y, h, mm, s, km, place);
                if (myAthletes.checkKeys()) {
                    message = "This name already exists"; //CHANGE THE METHOD TO GO THROUGH THE ARRAY WITH AN OBJECT
                } else {
                    myAthletes.addEntry(swim);
                }

                validateSwim();
            } catch (NumberFormatException e) {
                return message = "Please fill the fields 'Place' ";
            }
        }

        try {
            checkForDuplicate();
        } catch (IllegalArgumentException exception) {
            message = "This already exists";
            myAthletes.removeLastEntry();
        }
        return message;
    }


    public void dateRangeException(int d, int m, int y) {
        if (d > 31 || d < 1 || m > 12 || m < 1 || y > 2021 || y < 1950) {
            throw new IllegalArgumentException();
        }
    }

    public void checkForDuplicate() {
        if (myAthletes.checkKeys()) {
            throw new IllegalArgumentException();
        }
    }

    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    public String removeEntry() {
        String n = name.getText();
        int d = Integer.parseInt(day.getText());
        int m = Integer.parseInt(month.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("deleting record ...");
        String message = myAthletes.removeEntry(n,d, m, y);
        return message;
    }

    // Find all function
    public String findAllByDate() {
        int d = Integer.parseInt(day.getText());
        int m = Integer.parseInt(month.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.findAllEntries(d, m, y);
        return message;
    }

    public String findAllByName() {
        String n = name.getText();
        outputArea.setText("looking up record ...");
        String message = myAthletes.findAllByName(n);
        return message;
    }


    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        repetitions.setText("");
        recoveryTime.setText("");
        terrain.setText("");
        tempo.setText("");
        tookPlace.setText("");
    }// blankDisplay

    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }


} // TrainingRecordGUI

