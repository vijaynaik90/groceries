package com.iyengarcoders.groceries.utils;

public class Constants {

    public static enum OrderStatus {
        PENDING, SHIPPED, DELIVERED, CANCELLED, UNKNOWN
    }

    // address type will be default always. When user explicitly marks set as Default Shipping address, then addressType will change to SHIPPING.
    public static enum AddressType {
        BILLING, SHIPPING, DEFAULT, UNKNOWN
    }
}
