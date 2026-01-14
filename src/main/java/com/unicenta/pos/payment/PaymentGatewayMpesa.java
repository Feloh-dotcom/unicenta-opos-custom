package com.unicenta.pos.payment;

import com.unicenta.pos.forms.AppProperties;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class PaymentGatewayMpesa implements PaymentGateway {

    private static final Logger LOGGER =
            Logger.getLogger(PaymentGatewayMpesa.class.getName());

    private final ExecutorService executor =
            Executors.newSingleThreadExecutor();

    private MpesaPaymentListener listener;

    public PaymentGatewayMpesa(AppProperties props) {
    }

    public void setListener(MpesaPaymentListener listener) {
        this.listener = listener;
    }

    public void startPayment(final double amount,
                             final String transactionId) {

        executor.submit(() -> {
            try {
                Thread.sleep(3000);
                if (listener != null) {
                    listener.onPaymentSuccess("MPESA-" + transactionId);
                }
            } catch (Exception e) {
                if (listener != null) {
                    listener.onPaymentFailed(e.getMessage());
                }
            }
        });
    }

    // ✅ REQUIRED BY INTERFACE
    @Override
    public void execute(PaymentInfoMagcard payinfo) {
        // Not used for async M-Pesa
    }
}
