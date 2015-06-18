package cn.javis.apms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ErrorInfo {
    @Getter
    String errMsg;

    @Getter
    StackTraceElement cause;

    @Getter 
    Class<?> reason;


}
