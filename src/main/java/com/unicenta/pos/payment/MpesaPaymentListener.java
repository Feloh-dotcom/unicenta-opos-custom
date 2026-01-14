package com.unicenta.pos.payment;

public interface MpesaPaymentListener {

    void onPaymentSuccess(String mpesaTransactionId);

    void onPaymentFailed(String reason);

    void onPaymentPending();
}
