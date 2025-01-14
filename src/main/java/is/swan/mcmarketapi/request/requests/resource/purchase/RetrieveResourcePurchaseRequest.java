package is.swan.mcmarketapi.request.requests.resource.purchase;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.ResourcePurchase;
import is.swan.mcmarketapi.request.Request;

public class RetrieveResourcePurchaseRequest implements Request<ResourcePurchase> {

    private final int resourceId, purchaseId;

    public RetrieveResourcePurchaseRequest(int resourceId, int purchaseId) {
        this.resourceId = resourceId;
        this.purchaseId = purchaseId;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/resources/" + resourceId + "/purchases/" + purchaseId;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public ResourcePurchase handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String resourcePurchaseJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        ResourcePurchase resourcePurchase = gson.fromJson(resourcePurchaseJson, ResourcePurchase.class);

        return resourcePurchase;
    }
}
