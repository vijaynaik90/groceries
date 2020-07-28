package com.iyengarcoders.groceries.utils;

public class Constants {

    public enum OrderStatus {
        PENDING, SHIPPED, DELIVERED, CANCELLED, UNKNOWN
    }

    // address type will be default always. When user explicitly marks set as Default Shipping address, then addressType will change to SHIPPING.
    public enum AddressType {
        BILLING, SHIPPING, DEFAULT, UNKNOWN
    }

    // maybe need to add more UOM later.
    public enum UnitOfMeasure {
        KILOGRAM("kg"),
        GRAM("gram"),
        DOZEN("dozen"),
        PACKET("packet"),
        LITRE("litre"),
        UNKNOWN("unknown");


        private String value;


        UnitOfMeasure(String value) {
            this.value = value;
        }

        public String getValue(){
            return this.value;
        }
    }

    public enum RoleName {
        ROLE_USER,
        ROLE_ADMIN
    }
}
