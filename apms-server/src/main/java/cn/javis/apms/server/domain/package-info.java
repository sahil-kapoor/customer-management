@org.hibernate.annotations.TypeDefs({
    @org.hibernate.annotations.TypeDef(name = "localDateUserType", typeClass = LocalDateUserType.class) ,
    @org.hibernate.annotations.TypeDef(name = "localDateTimeUserType", typeClass = LocalDateTimeUserType.class) ,
    @org.hibernate.annotations.TypeDef(name = "userInfoCompositeUserType", typeClass = UserInfoCompositeUserType.class) 
    })
package cn.javis.apms.server.domain;

import cn.javis.apms.server.domain.usertype.LocalDateTimeUserType;
import cn.javis.apms.server.domain.usertype.LocalDateUserType;
import cn.javis.apms.server.domain.usertype.UserInfoCompositeUserType;

