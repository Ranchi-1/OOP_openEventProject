package com.mycompany.openevent.ui;

/**
 * Friendly display labels leave database status codes unchanged.
 */
public final class DisplayText {

    private DisplayText() {
    }

    public static String ticketStatus(String status) {
        if ("VALID".equals(status)) {
            return "Ready for entry";
        }
        if ("USED".equals(status)) {
            return "Checked in";
        }
        if ("CANCELLED".equals(status)) {
            return "Cancelled";
        }
        return status;
    }

    public static String paymentStatus(String status) {
        if ("SIMULATED_SUCCESS".equals(status)) {
            return "Simulated payment completed";
        }
        if ("SIMULATED_REFUNDED".equals(status)) {
            return "Simulated refund completed";
        }
        return status;
    }

    public static String category(String category) {
        if ("REGULAR".equals(category)) {
            return "Regular";
        }
        if ("EARLY_BIRD".equals(category)) {
            return "Early Bird";
        }
        return category;
    }

    public static String method(String method) {
        if ("CARD".equals(method)) {
            return "Credit card";
        }
        if ("EWALLET".equals(method)) {
            return "E-wallet";
        }
        if ("CASH".equals(method)) {
            return "Cash";
        }
        return method;
    }
}
