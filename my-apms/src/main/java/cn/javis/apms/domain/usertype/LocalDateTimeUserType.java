package cn.javis.apms.domain.usertype;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

public class LocalDateTimeUserType implements UserType {

    @Override
    public Object assemble(Serializable arg0, Object arg1) throws HibernateException {
        return arg0;
    }

    @Override
    public Object deepCopy(Object arg0) throws HibernateException {
        return arg0;
    }

    @Override
    public Serializable disassemble(Object arg0) throws HibernateException {
        return (Serializable) arg0;
    }

    @Override
    public boolean equals(Object arg0, Object arg1) throws HibernateException {
        if (arg0 == arg1)
            return true;
        if (arg0 == null || arg1 == null)
            return false;
        return arg0.equals(arg1);
    }

    @Override
    public int hashCode(Object arg0) throws HibernateException {
        return arg0.hashCode();
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Object nullSafeGet(ResultSet arg0, String[] arg1, SessionImplementor arg2, Object arg3)
            throws HibernateException, SQLException {
        Timestamp timestamp = arg0.getTimestamp(arg1[0]);
        if (arg0.wasNull()) {
            return null;
        }
        return timestamp.toLocalDateTime();
    }

    @Override
    public void nullSafeSet(PreparedStatement arg0, Object arg1, int arg2, SessionImplementor arg3)
            throws HibernateException, SQLException {
        if (arg1 == null) {
            arg0.setNull(arg2, Types.TIMESTAMP);
        } else {
            LocalDateTime dateTime = (LocalDateTime) arg1;
            arg0.setTimestamp(arg2, Timestamp.valueOf(dateTime));
        }

    }

    @Override
    public Object replace(Object arg0, Object arg1, Object arg2) throws HibernateException {
        return arg0;
    }

    @Override
    public Class<LocalDateTime> returnedClass() {
        return LocalDateTime.class;
    }

    @Override
    public int[] sqlTypes() {
        return new int[] { Types.TIMESTAMP };
    }
}
