package com.querydslexample.hibernate.usertype;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

/**
 * FacebookIdUserType
 *
 * @author <a herf="mailto:hellojianwu@gmail.com">jianwu</a>
 */
public class FacebookIdUserType implements UserType {
    private static final int[] FACEBOOKID_TYPES = new int[] { Types.VARCHAR };

    public FacebookIdUserType() {
    }

    public int[] sqlTypes() {
        return FACEBOOKID_TYPES;
    }

    @SuppressWarnings("rawtypes")
    public Class returnedClass() {
        return FacebookId.class;
    }

    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == null && y != null) {
            return false;
        }

        if (x != null && y == null) {
            return false;
        }

        if (x == y) {
            return true;
        }

        if (x.equals(y)) {
            return true;
        }

        return false;
    }

    public int hashCode(Object x) throws HibernateException {
        return Objects.hashCode(x);
    }

    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
                    throws HibernateException, SQLException {
        String idString = rs.getString(names[0]);

        if (idString == null || idString.trim().length() == 0) {
            return null;
        }

        FacebookId fbId = new FacebookId();
        fbId.setFbId(idString);

        return fbId;
    }

    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
                    throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, Types.VARCHAR);
        }

        FacebookId fbId = (FacebookId) value;
        st.setString(index, fbId.getFbId());
    }

    public Object deepCopy(Object value) throws HibernateException {
        if (value == null) {
            return null;
        }

        FacebookId original = (FacebookId) value;
        FacebookId clone = new FacebookId();
        clone.setFbId(new String(original.getFbId()));

        return clone;
    }

    public boolean isMutable() {
        // as FacebookId has set method
        return true;
    }

    public Serializable disassemble(Object value) throws HibernateException {
        Object deepCopy = deepCopy(value);

        if (deepCopy instanceof Serializable)
            return (Serializable) deepCopy;

        return null;
    }

    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return deepCopy(cached);
    }

    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return deepCopy(original);
    }
}
