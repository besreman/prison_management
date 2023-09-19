package com.example.prison_management.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {

    JButton btnAdd;
    JButton btnBack;
    JPanel mainPanel;
    JPanel addPrisonerPanel;
    JPanel prisonersList;

    JPanel PrisonerDetailsPanel;
    AdminHome home;
    CardLayout cardLayout;

    JButton btnList;

    public Home() {
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        home = new AdminHome();
        btnAdd = home.btnAdd;
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "addPrisoner");
            }
        });
        btnAdd.setBounds(20,280,200,30);
        home.add(btnAdd);

        addPrisonerPanel = new AddPrisoner();
        btnBack = new JButton("back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "home");
            }
        });
        addPrisonerPanel.add(btnBack);
        btnBack.setBounds(0,2,80,20);
        btnBack.setVisible(true);



        prisonersList = new PrisonerListPanel(this);
        btnList = home.jButton2;
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "prisoners list");
            }
        });
        btnList.setBounds(20,280,200,30);
        home.add(btnList);


        mainPanel.add(home, "home");
        mainPanel.add(addPrisonerPanel, "addPrisoner");
        mainPanel.add(prisonersList, "prisoners list");

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setVisible(true);
    }


    public static void main(String[] args) {
        new Home();
    }
}
