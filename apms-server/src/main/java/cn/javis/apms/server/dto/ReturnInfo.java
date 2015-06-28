package cn.javis.apms.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import cn.javis.apms.common.ReturnCode;

@Getter
@AllArgsConstructor
public class ReturnInfo {

    public static ReturnInfo newInstance(ReturnCode code) {
        return new ReturnInfo(code);
    }

    private final ReturnCode code;

}
