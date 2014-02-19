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
 * InternalAttrUserType
 *
 * @author <a herf="mailto:hellojianwu@gmail.com">jianwu</a>
 */
public class InternalAttrUserType implements UserType {
    private static final int[] INTERNALATTR_TYPES = new int[] { Types.INTEGER };

    public InternalAttrUserType() {
    }

    public int[] sqlTypes() {
        return INTERNALATTR_TYPES;
    }

    @SuppressWarnings("rawtypes")
    public Class returnedClass() {
        return InternalAttr.class;
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

    public Object nullSafeGet(ResultSet rs, String[] names,
                    SessionImplementor session, Object owner)
                    throws HibernateException, SQLException {
        Integer attrValue = rs.getInt(names[0]);

        if (attrValue == null) {
            return null;
        }

        InternalAttr internalAttr = new InternalAttr();
        internalAttr.setAttrValue(attrValue);

        return internalAttr;
    }

    public void nullSafeSet(PreparedStatement st, Object value, int index,
                    SessionImplementor session) throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, Types.INTEGER);
        }

        InternalAttr internalAttr = (InternalAttr) value;
        st.setInt(index, internalAttr.getAttrValue());
    }

    public Object deepCopy(Object value) throws HibernateException {
        if (value == null) {
            return null;
        }

        InternalAttr original = (InternalAttr) value;
        InternalAttr clone = new InternalAttr();
        clone.setAttrValue(Integer.valueOf(original.getAttrValue().intValue()));

        return clone;
    }

    public boolean isMutable() {
        // as InternalAttr has set method
        return true;
    }

    public Serializable disassemble(Object value) throws HibernateException {
        Object deepCopy = deepCopy(value);

        if (deepCopy instanceof Serializable)
            return (Serializable) deepCopy;

        return null;
    }

    public Object assemble(Serializable cached, Object owner)
                    throws HibernateException {
        return deepCopy(cached);
    }

    public Object replace(Object original, Object target, Object owner)
                    throws HibernateException {
        return deepCopy(original);
    }
}
