package qa.models;

import lombok.Getter;

@Getter
public class Payment {

    private final String phone;
    private final String name;
    private final String amount;
    private final String country;

    public Payment(String phone, String name, String amount, String country) {

        this.phone = phone;
        this.name = name;
        this.amount = amount;
        this.country = country;
    }
}
