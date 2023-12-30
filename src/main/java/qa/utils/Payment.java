package qa.utils;

import lombok.Getter;

@Getter
public class Payment {

    private final String phone;
    private final String name;
    private final String amount;
    private final String country;
    private final String alertTitle;
    private final String alertMessage;

    public Payment(String phone, String name, String amount, String country, String alertTitle, String alertMessage) {

        this.phone = phone;
        this.name = name;
        this.amount = amount;
        this.country = country;
        this.alertTitle = alertTitle;
        this.alertMessage = alertMessage;
    }
}
