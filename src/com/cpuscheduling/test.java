package com.cpuscheduling;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class test extends JFrame{
    private JTable table1;
    private JPanel panel1;

    public test() {
        setTitle("DataForm");
        setSize(800, 600);
        DefaultTableModel tableModel = new DefaultTableModel();
        table1.setModel(tableModel);
        tableModel.addColumn("Languages");
        tableModel.addColumn("aaaa");
        tableModel.insertRow(0, new Object[] { "CSS" ,"aaa"});
        tableModel.insertRow(0, new Object[] { "CSS" ,"aaa"});
        tableModel.insertRow(0, new Object[] { "CSS" ,"aaa"});
        tableModel.insertRow(0, new Object[] { "CSS" ,"aaa"});
        tableModel.insertRow(0, new Object[] { "CSS" ,"aaa"});
        tableModel.insertRow(0, new Object[] { "CSS" ,"aaa"});
        tableModel.insertRow(0, new Object[] { "CSS" ,"aaa"});
        tableModel.insertRow(0, new Object[] { "CSS" ,"aaa"});
        tableModel.insertRow(0, new Object[] { "CSS" ,"aaa"});
        tableModel.insertRow(0, new Object[] { "CSS" ,"aaa"});
        tableModel.insertRow(0, new Object[] { "CSS" ,"aaa"});
        tableModel.insertRow(0, new Object[] { "CSS" ,"aaa"});
        tableModel.insertRow(0, new Object[] { "CSS" ,"aaa"});
        tableModel.insertRow(0, new Object[] { "CSS" ,"aaa"});

        add(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                test gui = new test();
                gui.setVisible(true);
            }
        });
    }
}
