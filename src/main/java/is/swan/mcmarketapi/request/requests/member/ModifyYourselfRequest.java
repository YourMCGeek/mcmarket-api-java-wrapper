package is.swan.mcmarketapi.request.requests.member;

import com.google.gson.Gson;
import is.swan.mcmarketapi.request.Request;

import java.util.HashMap;

public class ModifyYourselfRequest implements Request<Void> {

    private final String customTitle, aboutMe, signature;

    public ModifyYourselfRequest(String customTitle, String aboutMe, String signature) {
        this.customTitle = customTitle;
        this.aboutMe = aboutMe;
        this.signature = signature;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/members/self";
    }

    @Override
    public Method getMethod() {
        return Method.PATCH;
    }

    @Override
    public String getBody() {
        Gson gson = new Gson();
        HashMap<String, String> parameters = new HashMap<>();

        if (customTitle != null) {
            parameters.put("custom_title", customTitle);
        }

        if (aboutMe != null) {
            parameters.put("about_me", aboutMe);
        }

        if (signature != null) {
            parameters.put("signature", signature);
        }

        return gson.toJson(parameters);
    }
}
