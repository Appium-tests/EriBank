package qa.enums;

public enum WebViewContext {

    CHROME("WEBVIEW_chrome");

    private final String name;

    WebViewContext(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
}
