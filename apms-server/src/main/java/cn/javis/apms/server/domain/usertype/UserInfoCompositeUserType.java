package cn.javis.apms.server.domain.usertype;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;

import cn.javis.apms.server.domain.base.UserInfo;

public class UserInfoCompositeUserType implements CompositeUserType {

    @Override
    public Object assemble(Serializable arg0, SessionImplementor arg1, Object arg2) throws HibernateException {
        return arg0;
    }

    @Override
    public Object deepCopy(Object arg0) throws HibernateException {
        return arg0;
    }

    @Override
    public Serializable disassemble(Object arg0, SessionImplementor arg1) throws HibernateException {
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
    public String[] getPropertyNames() {
        return new String[] { "userName", "userTerminal" };
    }

    @Override
    public Type[] getPropertyTypes() {
        return new Type[] { StringType.INSTANCE, StringType.INSTANCE};
    }

    @Override
    public Object getPropertyValue(Object arg0, int arg1) throws HibernateException {
        UserInfo userInfo = (UserInfo) arg0;
        if (arg1 == 0) {
            return userInfo.getUserName();
        } else {
            return userInfo.getUserTerminal();
        }
    }

    @Override
    public int hashCode(Object arg0) throws HibernateException {
        return arg0.hashCode();
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Object nullSafeGet(ResultSet arg0, String[] arg1, SessionImplementor arg2, Object arg3)
            throws HibernateException, SQLException {
        String userName = arg0.getString(arg1[0]);
        if (arg0.wasNull())
            return null;
        String userTerminal = arg0.getString(arg1[1]);
        return new UserInfo(userName, userTerminal);
    }

    @Override
    public void nullSafeSet(PreparedStatement arg0, Object arg1, int arg2, SessionImplementor arg3)
            throws HibernateException, SQLException {
        if (arg1 == null) {
            arg0.setNull(arg2, Types.VARCHAR);
            arg0.setNull(arg2 + 1, Types.VARCHAR);
        } else {
            UserInfo userInfo = (UserInfo) arg1;
            arg0.setString(arg2, userInfo.getUserName());
            arg0.setString(arg2 + 1, userInfo.getUserTerminal());
        }

    }

    @Override
    public Object replace(Object arg0, Object arg1, SessionImplementor arg2, Object arg3) throws HibernateException {
        return deepCopy(arg0);
    }

    @Override
    public Class<UserInfo> returnedClass() {
        return UserInfo.class;
    }

    @Override
    public void setPropertyValue(Object arg0, int arg1, Object arg2) throws HibernateException {
        UserInfo userInfo = (UserInfo) arg0;
        String info = (String) arg2;
        if (arg1 == 0) {
            userInfo.setUserName(info);
        } else {
            userInfo.setUserTerminal(info);
        }
    }
}
