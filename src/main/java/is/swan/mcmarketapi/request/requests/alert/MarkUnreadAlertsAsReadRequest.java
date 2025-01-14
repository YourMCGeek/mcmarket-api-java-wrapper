package is.swan.mcmarketapi.request.requests.alert;

import com.google.gson.Gson;
import is.swan.mcmarketapi.request.Request;

import java.util.HashMap;

public class MarkUnreadAlertsAsReadRequest implements Request<Void> {

    private final boolean read;

    public MarkUnreadAlertsAsReadRequest(boolean read) {
        this.read = read;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/alerts";
    }

    @Override
    public Method getMethod() {
        return Method.PATCH;
    }

    @Override
    public String getBody() {
        Gson gson = new Gson();
        HashMap<String, Boolean> parameters = new HashMap<>();

        parameters.put("read", read);

        return gson.toJson(parameters);
    }
}
