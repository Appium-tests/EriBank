package qa.json;

import com.google.common.io.Resources;
import org.json.JSONArray;
import org.json.JSONObject;
import qa.utils.Credentials;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.IntStream;

public class JSONReader {

    private static JSONObject jsonObject;

    private static JSONArray getJSONArray(String key, String node) {

        Object object = jsonObject.get(key);
        JSONObject jsonObject1 = (JSONObject) object;

        return jsonObject1.getJSONArray(node);
    }
    public static void read() throws IOException {

        URL url = Resources.getResource("testdata.json");
        jsonObject = new JSONObject(Resources.toString(url, StandardCharsets.UTF_8));
    }

    public static Credentials[] getCredentials(String node) {

        JSONArray jsonArray = getJSONArray("credentials", node);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new Credentials(
                        jsonArray.getJSONObject(i).getString("username"),
                        jsonArray.getJSONObject(i).getString("password")
                ))
                .toArray(Credentials[]::new);
    }
}
