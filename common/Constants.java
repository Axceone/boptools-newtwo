package com.baiwang.bophttpapi.common;

public class Constants {

    private String url;
    private String appKey;
    private String appSecret;
    private String userName;
    private String password;
    private String userSalt;
    private String apiName;
    private String body;

    /** TOP默认时间格式 **/
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /** UTF-8字符集 **/
    public static final String CHARSET_UTF8 = "UTF-8";

    /** TOP JSON 应格式 */
    public static final String FORMAT_JSON = "json";

    /** TOP XML 应格式 */
    public static final String FORMAT_XML = "xml";

    /**SDK版本*/
    public static final String V_NO = "2.1";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
