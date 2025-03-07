package is.swan.mcmarketapi.request.requests.resource;

import com.google.gson.Gson;
import is.swan.mcmarketapi.request.Request;

import java.util.HashMap;

public class ModifyResourceRequest implements Request<Void> {

    private final int resourceId;
    private final String title, tag_line, description;

    public ModifyResourceRequest(int resourceId, String title, String tag_line, String description) {
        this.resourceId = resourceId;
        this.title = title;
        this.tag_line = tag_line;
        this.description = description;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/resources/" + resourceId;
    }

    @Override
    public Method getMethod() {
        return Method.PATCH;
    }

    @Override
    public String getBody() {
        Gson gson = new Gson();
        HashMap<String, String> parameters = new HashMap<>();

        if (title != null) {
            parameters.put("title", title);
        }

        if (tag_line != null) {
            parameters.put("tag_line", tag_line);
        }

        if (description != null) {
            parameters.put("description", description);
        }

        return gson.toJson(parameters);
    }
}
