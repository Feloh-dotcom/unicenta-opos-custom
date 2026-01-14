package com.unicenta.pos.payment;

public class PaymentInfoMpesa extends PaymentInfo {

    private static final long serialVersionUID = 1L;

    private final double amount;
    private final String transactionID;
    private final String phoneNumber;

    public PaymentInfoMpesa(double amount, String transactionID, String phoneNumber) {
        this.amount = amount;
        this.transactionID = transactionID;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getName() {
        return "M-Pesa";
    }

    @Override
    public double getTotal() {
        return amount;
    }

    @Override
    public PaymentInfo copyPayment() {
        return new PaymentInfoMpesa(amount, transactionID, phoneNumber);
    }

    @Override
    public String getTransactionID() {
        return transactionID;
    }

    @Override
    public double getPaid() {
        return amount;
    }

    @Override
    public double getChange() {
        return 0.0;
    }

    @Override
    public double getTendered() {
        return amount;
    }

    @Override
    public String getCardName() {
        return "M-Pesa";
    }

    @Override
    public String getVoucher() {
        return transactionID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
