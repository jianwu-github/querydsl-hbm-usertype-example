package com.querydslexample.hibernate;

import com.mysema.query.annotations.PropertyType;
import com.mysema.query.annotations.QueryType;
import com.querydslexample.hibernate.usertype.FacebookId;
import com.querydslexample.hibernate.usertype.InternalAttr;

/**
 * Subscriber is a Hibernate Entity mapping to "subscriber" table in Postgresql DB
 *
 * @author <a herf="mailto:hellojianwu@gmail.com">jianwu</a>
 */
public class Subscriber {
    private Long id;
    private String name;
    private Integer age;

    @QueryType(PropertyType.SIMPLE)
    private FacebookId facebookId;

    @QueryType(PropertyType.NONE)
    private InternalAttr internalAttr;

    public Subscriber() {
    }

    public Subscriber(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public FacebookId getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(FacebookId facebookId) {
        this.facebookId = facebookId;
    }

    @SuppressWarnings("unused")
    private InternalAttr getInternalAttr() {
        return internalAttr;
    }

    @SuppressWarnings("unused")
    private void setInternalAttr(InternalAttr internalAttr) {
        this.internalAttr = internalAttr;
    }

}
