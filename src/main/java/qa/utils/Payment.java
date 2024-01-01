package qa.utils;

import lombok.Getter;

@Getter
public class Payment {

    private final String phone;
    private final String name;
    private final String amount;
    private final String country;
    private final String question;
    private final String title;
    private final String message;

    public Payment(String phone, String name, String amount, String country, String question, String title, String message) {

        this.phone = phone;
        this.name = name;
        this.amount = amount;
        this.country = country;
        this.question = question;
        this.title = title;
        this.message = message;
    }
}
