@org.hibernate.annotations.TypeDefs({
    @org.hibernate.annotations.TypeDef(name = "localDateUserType", typeClass = LocalDateUserType.class) ,
    @org.hibernate.annotations.TypeDef(name = "localDateTimeUserType", typeClass = LocalDateTimeUserType.class) ,
    @org.hibernate.annotations.TypeDef(name = "userInfoCompositeUserType", typeClass = UserInfoCompositeUserType.class) 
    })
package cn.javis.apms.domain;

import cn.javis.apms.domain.usertype.LocalDateTimeUserType;
import cn.javis.apms.domain.usertype.LocalDateUserType;
import cn.javis.apms.domain.usertype.UserInfoCompositeUserType;

