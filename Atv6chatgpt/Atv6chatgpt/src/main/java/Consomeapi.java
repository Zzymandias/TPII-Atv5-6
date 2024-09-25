import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class Consomeapi {
    private final String apiKey;
    private final String apiUrl = "https://api.openai.com/v1/chat/completions";

    public Consomeapi(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getResponse(String message) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(apiUrl);
            post.setHeader("Authorization", "Bearer " + apiKey);
            post.setHeader("Content-Type", "application/json");

            JSONObject json = new JSONObject();
            json.put("model", "gpt-3.5-turbo"); // ou o modelo que você estiver usando
            json.put("messages", new JSONArray().put(new JSONObject().put("role", "user").put("content", message)));

            post.setEntity(new StringEntity(json.toString()));

            try (CloseableHttpResponse response = client.execute(post)) {
                String responseBody = EntityUtils.toString(response.getEntity());
                return responseBody; // você pode precisar processar isso para obter apenas a resposta do ChatGPT
            }
        }
    }
}

