package com.plugin.chatgpt.constant;


import com.plugin.chatgpt.service.RemoteConfig;

public class ConfigConstants {
    public static final String SCENE_UUID = "uuid";
    public static final String LOGIN_INFO = "login_info";
    public static final String INITIAL_QUOTA = "quota";
    public static String DOMAIN = RemoteConfig.get("api.domain", "https://chat.5yoo.com");
    public static String HOME_URL = RemoteConfig.get("home.url", "https://chat.5yoo.com/");
    public static String DONATE_URL = RemoteConfig.get("donate.url", "https://blog.5yoo.com/375.html");
    public static String HOME_TITLE = RemoteConfig.get("home.title", "<html>Welcome to ChatGPT!<br/>Tips: <a href=''>ChatGPT h5 group chat version</a></html>");
    public static final String CONVERSATION_URL = "/chatGPT/ask2?prompt=";
    public static final String INITIAL_QUOTA_URL = "/chatGPT/initialQuota";
    public static final String CURRENT_QUOTA_URL = "/chatGPT/currentQuota";
    public static final String LOGIN_QRCODE_URL = "/wx/qrcode/create";
    public static final String LOGININFO_URL = "/login/polling";

    public ConfigConstants() {
    }

    public static void main(String[] args) {
        System.out.println(DOMAIN);
    }
}