package com.gitwee.demo.shiro.realm;

import org.apache.shiro.authc.UsernamePasswordToken;

public class LoginToken extends UsernamePasswordToken{

    // 验证码
    private String captcha;

    private String ip;

    private boolean isIgnoreLogin = false;

    private String userId;

    public LoginToken(String userName, String passWord) {
        super(userName, passWord);
    }

    private LoginToken(Builder builder) {
        captcha = builder.captcha;
        ip = builder.ip;
        isIgnoreLogin = builder.isIgnoreLogin;
        userId = builder.userId;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public boolean isIgnoreLogin() {
        return isIgnoreLogin;
    }

    public void setIgnoreLogin(boolean ignoreLogin) {
        isIgnoreLogin = ignoreLogin;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static class Builder {

        private String userName;

        private String password;

        private String host;

        private boolean rememberMe = false;

        private String captcha;

        private String ip;

        private boolean isIgnoreLogin = false;

        private String userId;

        public Builder host(String host) {
            this.host = host;
            return  this;
        }

        public Builder rememberMe(boolean rememberMe) {
            this.rememberMe = rememberMe;
            return  this;
        }

        public Builder captcha(String captcha) {
            this.captcha = captcha;
            return  this;
        }

        public Builder ip(String ip) {
            this.ip = ip;
            return  this;
        }

        public Builder isIgnoreLogin(boolean isIgnoreLogin) {
            this.isIgnoreLogin = isIgnoreLogin;
            return  this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return  this;
        }

        public LoginToken build() {
            return new LoginToken(this);
        }
    }

}
