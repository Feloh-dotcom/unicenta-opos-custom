package com.unicenta.pos.payment;

import javax.swing.*;
import java.awt.*;

public class JMpesaWaitingDialog extends JDialog {

    public JMpesaWaitingDialog(Window parent, double amount) {
        super(parent, "Waiting for M-Pesa Payment", ModalityType.APPLICATION_MODAL);
        initUI(amount);
    }

    private void initUI(double amount) {

        JLabel label = new JLabel(
                "Waiting for M-Pesa payment of " + amount,
                SwingConstants.CENTER
        );

        label.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(label, BorderLayout.CENTER);

        setSize(350, 120);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    public void close() {
        setVisible(false);
        dispose();
    }
}
