package qa.support;

import lombok.Getter;

@Getter
public class Country {

    private final String name;
    private final int index;

    public Country(String name, int index) {

        this.name = name;
        this.index = index;
    }
}
