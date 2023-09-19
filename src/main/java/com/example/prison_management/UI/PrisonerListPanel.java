package com.example.prison_management.UI;

import com.example.prison_management.classes.PrisonDAO;
import com.example.prison_management.classes.Prisoner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PrisonerListPanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnView;

    PrisonDAO prisonDAO;
    private List<Prisoner> prisonerList;

    Home home;

    public PrisonerListPanel(Home home) {
        this.home = home;
        prisonDAO = new PrisonDAO();
        this.prisonerList = prisonDAO.getAllPrisoners();
        initializeComponents();
        createTable();
        createUI();
    }
    private void initializeComponents() {
        tableModel = new DefaultTableModel(new Object[]{"Name", "Name of father", "End date"}, 0);
        table = new JTable(tableModel);
        btnView = new JButton("View");
        btnView.setEnabled(false);

        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                btnView.setEnabled(selectedRow != -1);
            }
        });

        btnView.addActionListener(e -> onViewButtonClicked());
    }

    private void createTable() {
        for (Prisoner prisoner : prisonerList) {
            tableModel.addRow(new Object[]{prisoner.getName(), prisoner.getFathersName(), prisoner.getEndDate()});
        }
    }

    private void onViewButtonClicked() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            Prisoner selectedPrisoner = prisonerList.get(selectedRow);
            showPrisonerDetails(selectedPrisoner);
        }
    }

    private void showPrisonerDetails(Prisoner prisoner) {
        // Create a panel to display the prisoner details
        JPanel detailsPanel = new PrisonerDetailsPanel(prisoner, home);


        home.mainPanel.removeAll();
        // Add the prisoner details panel to the main panel
        home.mainPanel.add(detailsPanel, "prisonerDetails");
        // Switch to the prisoner details panel
        home.cardLayout.show(home.mainPanel, "prisonerDetails");
        // Update the UI
        home.mainPanel.revalidate();
        home.mainPanel.repaint();
    }

    private void createUI() {
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(btnView, BorderLayout.SOUTH);
    }
}

