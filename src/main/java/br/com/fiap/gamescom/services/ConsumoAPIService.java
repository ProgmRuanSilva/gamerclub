package br.com.fiap.gamescom.services;

import br.com.fiap.gamescom.api.InfoJogo;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ConsumoAPIService {

    public InfoJogo buscaJogo(String id) throws IOException {
        InfoJogo infoJogo = null;

        HttpGet request = new HttpGet("https://www.cheapshark.com/api/1.0/games?id=" + id);
        CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
        CloseableHttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            String result = EntityUtils.toString(entity);
            Gson gson = new Gson();
            infoJogo = gson.fromJson(result, InfoJogo.class);
        }

        return infoJogo;
    }
}
