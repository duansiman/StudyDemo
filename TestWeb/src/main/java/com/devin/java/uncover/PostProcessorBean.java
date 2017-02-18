package com.devin.java.uncover;

/**
 * Created by devin on 2017/1/19.
 */
public class PostProcessorBean implements PasswordDecodable {

    private String url;
    private String driver;
    private String username;
    private String password;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PostProcessorBean{" +
                "url='" + url + '\'' +
                ", driver='" + driver + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public String getEncodedPassword() {
        return password;
    }

    @Override
    public void setDecodedPassword(String password) {
        this.password = password;
    }
}
