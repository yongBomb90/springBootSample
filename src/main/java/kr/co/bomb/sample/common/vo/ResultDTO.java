package kr.co.bomb.sample.common.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import kr.co.bomb.sample.common.constant.MessageConstants;
import lombok.Data;

@Data
public class ResultDTO {

    String code;
    String msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Object data;

    public ResultDTO(Object data) {
        this.data = data;
        init();
    }
    public ResultDTO(Object data,String code) {
        this.data = data;
        this.code = code;
        init();
    }
    public ResultDTO(Object data,String code,String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
        init();
    }
    public ResultDTO(MessageConstants.ResponseEnum code) {
        this.code = code.getCode();
        this.msg = code.getDesc();
        init();
    }

    protected void init() {
        this.msg = (this.msg == null ?  MessageConstants.ResponseEnum.SUCCESS.getDesc() : this.msg );
        this.code = (this.code == null ? MessageConstants.ResponseEnum.SUCCESS.getCode() : this.code);
    }

}
