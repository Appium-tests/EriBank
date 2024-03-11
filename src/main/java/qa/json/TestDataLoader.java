package qa.json;

import com.google.common.io.Resources;
import org.json.JSONArray;
import org.json.JSONObject;
import qa.models.Credentials;
import qa.models.MortgageRequest;
import qa.models.Payment;
import qa.utils.*;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.IntStream;

public class TestDataLoader {

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

    public static Credentials[] getCredentials(String key) {

        JSONObject jsonObject = new JSONObject(FileReader.getSource());
        JSONArray jsonArray = jsonObject.getJSONArray(key);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new Credentials(
                        jsonArray.getJSONObject(i).getString("username"),
                        jsonArray.getJSONObject(i).getString("password")
                ))
                .toArray(Credentials[]::new);
    }

    public static Payment[] getPayments(String key) {

        JSONObject jsonObject = new JSONObject(FileReader.getSource());
        JSONArray jsonArray = jsonObject.getJSONArray(key);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new Payment(
                        jsonArray.getJSONObject(i).getString("phone"),
                        jsonArray.getJSONObject(i).getString("name"),
                        jsonArray.getJSONObject(i).getString("amount"),
                        jsonArray.getJSONObject(i).getString("country")
                ))
                .toArray(Payment[]::new);
    }

    public static MortgageRequest[] getMortgageRequests(String node) {

        JSONArray jsonArray = getJSONArray("mortageRequest", node);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new MortgageRequest(
                        jsonArray.getJSONObject(i).getString("firstName"),
                        jsonArray.getJSONObject(i).getString("lastName"),
                        jsonArray.getJSONObject(i).getString("age"),
                        jsonArray.getJSONObject(i).getString("address1"),
                        jsonArray.getJSONObject(i).getString("address2"),
                        jsonArray.getJSONObject(i).getString("country"),
                        jsonArray.getJSONObject(i).getString("title"),
                        jsonArray.getJSONObject(i).getString("message")
                ))
                .toArray(MortgageRequest[]::new);
    }

    public static Country[] getCountries() {

        JSONArray jsonArray = jsonObject.getJSONArray("countries");

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new Country(
                        jsonArray.getJSONObject(i).getString("name"),
                        jsonArray.getJSONObject(i).getInt("index")
                ))
                .toArray(Country[]::new);
    }
}
