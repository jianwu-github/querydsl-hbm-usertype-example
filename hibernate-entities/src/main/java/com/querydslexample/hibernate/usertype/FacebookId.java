package com.querydslexample.hibernate.usertype;

import java.io.Serializable;

public class FacebookId implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fbId;

    public FacebookId() {
    }

    public String getFbId() {
        return fbId;
    }

    public void setFbId(String fbId) {
        this.fbId = fbId;
    }
}
