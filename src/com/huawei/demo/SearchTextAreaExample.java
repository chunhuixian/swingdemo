package com.huawei.demo;

import com.intellij.find.SearchTextArea;
import com.intellij.ui.components.JBTextArea;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SearchTextAreaExample extends JFrame {
    private SearchTextArea searchArea;
    private JTextField searchText;
    private JTextField replaceText;

    public SearchTextAreaExample() {
        super("Search TextArea Example");
        initComponents();
        setSize(400, 400);
    }

    private void initComponents() {
        JBTextArea jbTextArea = new JBTextArea();
        jbTextArea.setLineWrap(true);
        jbTextArea.setWrapStyleWord(true);
        searchArea = new SearchTextArea(jbTextArea,true,true);

        searchText = new JTextField(20);
        replaceText = new JTextField(20);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(ae -> {
//            searchArea.sets(searchText.getText());
//            searchArea.searchForward();
        });

        JButton replaceButton = new JButton("Replace");
        replaceButton.addActionListener(ae -> {
//                searchArea.setSearchText(searchText.getText());
//                searchArea.setReplaceText(replaceText.getText());
//                searchArea.replace();
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("Search"));
        panel.add(searchText);
        panel.add(new JLabel("Replace"));
        panel.add(replaceText);
        panel.add(searchButton);
        panel.add(replaceButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(searchArea, BorderLayout.CENTER);
        getContentPane().add(panel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SearchTextAreaExample frame = new SearchTextAreaExample();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

