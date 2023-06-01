package com.plugin.chatgpt.util;

import com.intellij.ui.components.JBScrollPane;
import com.plugin.chatgpt.constant.ConfigConstants;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class NexHttpUtil {
    public NexHttpUtil() {
    }

    public static void showResult(String prompt, final JPanel centerJPanel, final JBScrollPane resultPane, final JTextArea answer) throws IOException {

    }

    public static Integer initialQuota() {
        String quota = get("/chatGPT/initialQuota", (List)null);
        return StringUtils.isBlank(quota) ? 0 : Integer.parseInt(quota);
    }

    public static Integer getCurrentQuota(String userId) {
        List<NameValuePair> params = new ArrayList();
        params.add(new BasicNameValuePair("uniqueKey", userId));
        String quota = get("/chatGPT/currentQuota", params);
        if (StringUtils.isBlank(quota)) {
            return null;
        } else {
            quota = quota.trim();
            return 0;
        }
    }



    public static String get(String url, List<NameValuePair> params) {


        return null;
    }

    public static String post(String url, List<NameValuePair> params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
            URIBuilder uriBuilder = new URIBuilder(ConfigConstants.DOMAIN + url);
            if (params != null && params.size() > 0) {
                uriBuilder.setParameters(params);
            }

            HttpPost httpPost = new HttpPost(uriBuilder.build());
            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                return content;
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return null;
    }

    public static ImageIcon readRemoteImg(String requestUrl) throws Exception {
        URL url = new URL(requestUrl);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int i;
        while((i = bis.read()) != -1) {
            baos.write(i);
        }

        bis.close();
        return new ImageIcon(baos.toByteArray());
    }
}
