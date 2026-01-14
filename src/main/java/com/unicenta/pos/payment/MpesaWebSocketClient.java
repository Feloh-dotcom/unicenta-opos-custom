package com.unicenta.pos.payment;

import java.util.logging.Logger;

public class MpesaWebSocketClient {

    private static final Logger LOGGER =
            Logger.getLogger(MpesaWebSocketClient.class.getName());

    private MpesaPaymentListener listener;

    public MpesaWebSocketClient(MpesaPaymentListener listener) {
        this.listener = listener;
    }

    public void connect() {
        LOGGER.info("M-Pesa WebSocket client connected (stub)");
    }

    public void close() {
        LOGGER.info("M-Pesa WebSocket client closed (stub)");
    }

    /* ===== Simulation helpers ===== */

    public void simulateSuccess(String transactionId) {
        if (listener != null) {
            listener.onPaymentSuccess(transactionId);
        }
    }

    public void simulateFailure(String reason) {
        if (listener != null) {
            listener.onPaymentFailed(reason);
        }
    }
}
