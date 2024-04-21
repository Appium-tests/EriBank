package qa.models;

import lombok.Getter;

@Getter
public class MortgageRequest {

    private String firstName;
    private String lastName;
    private String age;
    private String address1;
    private String address2;
    private String country;

    public MortgageRequest() { }
}
