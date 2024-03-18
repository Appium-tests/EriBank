package qa.support;

import lombok.Getter;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.Reader;

public class FileReader {

    private static final String PATH = "./src/test/resources/testdata/";
    @Getter
    private static String source;


    public static void load(String fileName) {

        try {
            Reader reader = new java.io.FileReader(PATH + fileName);
            JSONParser jsonParser = new JSONParser();
            source = jsonParser.parse(reader).toString();
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String loadCredentials() {

        try {
            Reader reader = new java.io.FileReader(PATH + "EB_Credentials.json");
            JSONParser jsonParser = new JSONParser();
            return jsonParser.parse(reader).toString();
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
