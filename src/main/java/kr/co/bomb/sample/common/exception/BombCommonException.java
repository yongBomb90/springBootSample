package kr.co.bomb.sample.common.exception;

import kr.co.bomb.sample.common.constant.MessageConstants;
import org.springframework.http.HttpHeaders;

import javax.servlet.ServletException;

public class BombCommonException extends Exception {

    private MessageConstants.ResponseEnum res;

    public BombCommonException(MessageConstants.ResponseEnum code) {
        this.res = code;
    }

    public MessageConstants.ResponseEnum getRes() {
        return res;
    }

    public void setRes(MessageConstants.ResponseEnum res) {
        this.res = res;
    }
}
