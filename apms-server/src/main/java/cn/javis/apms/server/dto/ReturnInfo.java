package cn.javis.apms.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import cn.javis.apms.common.ReturnCode;

@AllArgsConstructor
@Getter
public class ReturnInfo {
    private final ReturnCode code;

}
