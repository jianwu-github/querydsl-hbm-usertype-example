package com.querydslexample.hibernate;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.mysema.query.jpa.hibernate.HibernateQuery;
import com.querydslexample.hibernate.usertype.FacebookId;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTypeTest {

    private static SessionFactory sessionFactory;
    private static Session session;

    @BeforeClass
    public static void init() throws Exception {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            sessionFactory = configuration.buildSessionFactory();
            session = sessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace(System.out);

            throw e;
        }
    }

    @Test
    public void test() {
        QSubscriber subscriber = new QSubscriber("subscriber");
        FacebookId facebookId = new FacebookId();
        facebookId.setFbId("jian.wu@querydslexample.com");

        HibernateQuery query = new HibernateQuery(session);
        Subscriber fbSubscriber = query.from(subscriber).where(subscriber.facebookId.eq(facebookId))
                        .uniqueResult(subscriber);

        assertNotNull(fbSubscriber);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        session.close();
        sessionFactory.close();
    }
}
