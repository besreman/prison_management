package com.example.prison_management.UI;

import com.example.prison_management.classes.PrisonDAO;
import com.example.prison_management.classes.Prisoner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrisonerDetailsPanel extends JPanel {

    private JLabel lblImage;
    private JLabel lblName;
    private JLabel lblFathersName;
    private JLabel lblGrandFathersName;
    private JLabel lblSex;
    private JLabel lblAge;
    private JLabel lblStartDate;
    private JLabel lblEndDate;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnCancel;
    private Home home;

    PrisonDAO prisonDAO = new PrisonDAO();

    public PrisonerDetailsPanel(Prisoner prisoner, Home home) {
        this.home = home;
        setLayout(new BorderLayout());

        // Create and configure the image label on the left side
        lblImage = new JLabel(new ImageIcon(prisoner.getImage()));
        lblImage.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblImage, BorderLayout.WEST);

        // Create and configure the details panel on the right side
        JPanel detailsPanel = new JPanel(new GridLayout(8, 2, 5, 1));
        lblName = new JLabel("Name:");
        lblFathersName = new JLabel("Father's Name:");
        lblGrandFathersName = new JLabel("Grandfather's Name:");
        lblSex = new JLabel("Sex:");
        lblAge = new JLabel("Age:");
        lblStartDate = new JLabel("Start Date:");
        lblEndDate = new JLabel("End Date:");
        detailsPanel.add(lblName);
        detailsPanel.add(new JLabel(prisoner.getName()));
        detailsPanel.add(lblFathersName);
        detailsPanel.add(new JLabel(prisoner.getFathersName()));
        detailsPanel.add(lblGrandFathersName);
        detailsPanel.add(new JLabel(prisoner.getGrandFathersName()));
        detailsPanel.add(lblSex);
        detailsPanel.add(new JLabel(String.valueOf(prisoner.getSex())));
        detailsPanel.add(lblAge);
        detailsPanel.add(new JLabel(String.valueOf(prisoner.getAge())));
        detailsPanel.add(lblStartDate);
        detailsPanel.add(new JLabel(String.valueOf(prisoner.getStartDate())));
        detailsPanel.add(lblEndDate);
        detailsPanel.add(new JLabel(String.valueOf(prisoner.getEndDate())));
        add(detailsPanel, BorderLayout.EAST);

        // Create and configure the buttons panel at the bottom
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnEdit = new JButton("Edit");
        btnDelete = new JButton("Delete");
        btnCancel = new JButton("Cancel");
        buttonsPanel.add(btnEdit);
        buttonsPanel.add(btnDelete);
        buttonsPanel.add(btnCancel);
        add(buttonsPanel, BorderLayout.SOUTH);

        // Add action listeners to the buttons
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdatePrisoner updatePrisoner = new UpdatePrisoner(prisoner);
                home.mainPanel.removeAll();
                // Add the prisoner details panel to the main panel
                home.mainPanel.add(updatePrisoner, "prisonerUpdate");
                // Switch to the prisoner details panel
                home.cardLayout.show(home.mainPanel, "prisonerUpdate");
                // Update the UI
                home.mainPanel.revalidate();
                home.mainPanel.repaint();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prisonDAO.delete(prisoner);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) home.mainPanel.getLayout();
                cardLayout.show(home.mainPanel, "main");
            }
        });

    }
}
