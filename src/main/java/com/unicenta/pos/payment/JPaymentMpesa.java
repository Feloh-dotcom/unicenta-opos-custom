package com.unicenta.pos.payment;

import com.unicenta.pos.customers.CustomerInfoExt;
import com.unicenta.pos.forms.AppView;

import javax.swing.*;
import java.awt.*;

public class JPaymentMpesa extends JPanel implements JPaymentInterface {

    private final AppView app;

    private double amount;
    private String transactionId;

    public JPaymentMpesa(AppView app) {
        this.app = app;
        setLayout(new BorderLayout());
    }

    @Override
    public Component getComponent() {
        return this;
    }

    @Override
    public void activate(CustomerInfoExt customerext,
                         double dTotal,
                         String transactionID) {
        this.amount = dTotal;
        this.transactionId = transactionID;
    }

    @Override
    public PaymentInfo executePayment() {

        String tx = (transactionId != null)
                ? transactionId
                : "MPESA-" + System.currentTimeMillis();

        // For now, phoneNumber is "N/A" - you can extend UI later to collect it
        return new PaymentInfoMpesa(amount, tx, "N/A");
    }
}
