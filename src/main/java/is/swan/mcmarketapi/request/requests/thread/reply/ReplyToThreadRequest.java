package is.swan.mcmarketapi.request.requests.thread.reply;

import com.google.gson.Gson;
import is.swan.mcmarketapi.request.Request;

import java.util.HashMap;

public class ReplyToThreadRequest implements Request<Void> {

    private final int threadId;
    private final String message;

    public ReplyToThreadRequest(int threadId, String message) {
        this.threadId = threadId;
        this.message = message;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/threads/" + threadId + "/replies";
    }

    @Override
    public Method getMethod() {
        return Method.POST;
    }

    @Override
    public String getBody() {
        Gson gson = new Gson();
        HashMap<String, String> parameters = new HashMap<>();

        parameters.put("message", message);

        return gson.toJson(parameters);
    }
}
