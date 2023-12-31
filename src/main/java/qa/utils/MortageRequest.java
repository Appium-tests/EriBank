package qa.utils;

import lombok.Getter;

@Getter
public class MortageRequest {

    private final String firstName;
    private final String lastName;
    private final String age;
    private final String address1;
    private final String address2;
    private final String country;
    private final String title;
    private final String message;

    public MortageRequest(String firstName, String lastName, String age, String address1, String address2, String country, String title, String message) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address1 = address1;
        this.address2 = address2;
        this.country = country;
        this.title = title;
        this.message = message;
    }
}
