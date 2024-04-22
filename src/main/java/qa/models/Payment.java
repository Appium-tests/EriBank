package qa.models;

import lombok.Getter;

@Getter
public class Payment {

    private String phone;
    private String name;
    private String amount;
    private String country;

    public Payment() { }
}
