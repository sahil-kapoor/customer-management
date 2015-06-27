package cn.javis.apms.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import cn.javis.apms.common.ApmsErrorCode;

@AllArgsConstructor
@Getter
public class ErrorInfo {
    private final ApmsErrorCode errorCode;

}
