package is.swan.mcmarketapi.request.requests.member.profilepost;

import com.google.gson.Gson;
import is.swan.mcmarketapi.request.Request;

import java.util.HashMap;

public class EditProfilePostRequest implements Request<Void> {

    private final int profilePostId;
    private final String message;

    public EditProfilePostRequest(int profilePostId, String message) {
        this.profilePostId = profilePostId;
        this.message = message;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/members/self/profile-posts/" + profilePostId;
    }

    @Override
    public Method getMethod() {
        return Method.PATCH;
    }

    @Override
    public String getBody() {
        Gson gson = new Gson();
        HashMap<String, String> parameters = new HashMap<>();

        parameters.put("message", message);

        return gson.toJson(parameters);
    }
}
