package kr.co.bomb.sample.common.constant;

import java.util.Arrays;

public class MessageConstants {
    public static final String CODE = "code";
    public static final String MESSAGE = "message";

    // COMMON MESSAGE
    public static final String SUCCESS = "OK";
    public static final String FAIL = "FAIL";


    public enum ResponseEnum {
        SUCCESS("1", "SUCCESS"),
        BAD_REQUEST("9400", "BAD_REQUEST"),


        LOGIN_FAIL("9100", "아이디 비밀번호를 확인해주세요."),



        FILE_SIZE_TOO_BIG("9420", "파일사이즈 2MB를 넘을 수 없습니다."),
        PARAM_REQUIRED("9403", "필수 파라미터가 없습니다."),

        SERVER_ERROR("9500", "SERVER_ERROR"),

        MEMBER_ID_AVAILABLE("9200", "사용 가능한 아이디 입니다."),
        MEMBER_ID_DUPLICATED("9201", "해당 아이디는 이미 가입되어 있습니다."),
        MEMBER_ID_NOT_FOUND("9202", "아이디를 찾을 수 없습니다."),

        NOT_EXIST_RESPONSE("9999", "NOT_FOUNT");

        private String code;
        private String desc;

        ResponseEnum(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

        public static String findDescByCode(String code) {
            return Arrays.stream(values()).
                    filter(responseEnum -> responseEnum.getCode().equals(code)).findAny().
                    orElse(NOT_EXIST_RESPONSE).getDesc();
        }


    }

}
