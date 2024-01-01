package qa.utils;

import lombok.Getter;

@Getter
public class Credentials {

    private final String username;
    private final String password;
    private final String title;
    private final String message;
    public Credentials(String username, String password, String title, String message) {

        this.username = username;
        this.password = password;
        this.title = title;
        this.message = message;
    }
}
