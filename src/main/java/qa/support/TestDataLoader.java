package qa.support;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import qa.models.Credentials;
import qa.models.MortgageRequest;
import qa.models.Payment;
import java.util.stream.IntStream;

public class TestDataLoader {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static JSONArray getJSONArray(String source, String key) {

        JSONObject jsonObject = new JSONObject(source);
        return jsonObject.getJSONArray(key);
    }

    private static <T> T[] getObjectArray(String source, String key, Class<T> clazz) throws JsonProcessingException {

        JSONArray jsonArray = getJSONArray(source, key);
        T[] objects = (T[]) java.lang.reflect.Array.newInstance(clazz, jsonArray.length());

        for (int i = 0; i < jsonArray.length(); i++) {
            objects[i] = objectMapper.readValue(jsonArray.getJSONObject(i).toString(), clazz);
        }

        return objects;
    }

    public static String[] getStringArray(String key, int startInclusive) {

        JSONArray jsonArray = getJSONArray(FileReader.getSource(), key);

        return IntStream.range(startInclusive, jsonArray.length())
                .mapToObj(jsonArray::getString)
                .toArray(String[]::new);
    }

    public static Credentials[] getCredentialsFromSource(String source, String key) throws JsonProcessingException {

        return getObjectArray(source, key, Credentials.class);
    }

    public static Credentials[] getCredentials(String key) throws JsonProcessingException {

        return getCredentialsFromSource(FileReader.getSource(), key);
    }

    public static Payment[] getPayments(String key) throws JsonProcessingException {

        return getObjectArray(FileReader.getSource(), key, Payment.class);
    }

    public static MortgageRequest[] getMortgageRequests(String key) throws JsonProcessingException {

        return getObjectArray(FileReader.getSource(), key, MortgageRequest.class);
    }
}
