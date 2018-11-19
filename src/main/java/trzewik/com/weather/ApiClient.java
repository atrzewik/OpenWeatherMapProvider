package trzewik.com.weather;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ApiClient {

    private String basicUrl;
    private String apiKey;

    public ApiClient(String basicUrl, String apiKey) {
        this.basicUrl = basicUrl;
        this.apiKey = apiKey;
    }

    public String getResponseBody(String city) throws UnirestException {
        return Unirest.get(getUrlWithApiKey())
                .queryString("q", city)
                .asString()
                .getBody();

    }

    private String getUrlWithApiKey() {
        return this.basicUrl + "?appid=" + this.apiKey;
    }
}
