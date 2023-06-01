package com.plugin.chatgpt.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RemoteConfig {
    private static final String CONFIG_REMOTE_URL = "https://static.5yoo.com/files/idea-plugin/config.json";

    public RemoteConfig() {
    }

    public static String get(String key, String defaultValue) {
        String configStr = getFromRemote("https://static.5yoo.com/files/idea-plugin/config.json");
        return "";
    }

    public static String getFromRemote(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            HttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                return content;
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return null;
    }
}
