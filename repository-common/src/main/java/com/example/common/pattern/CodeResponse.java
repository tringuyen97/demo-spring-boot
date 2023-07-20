package com.example.common.pattern;

import com.example.common.exception.CommonException;
import com.example.common.pattern.ICodeResponse;

/**
 * Creator: Nguyen Ngoc Tri
 * Date: 6/26/2023
 * Time: 10:19 PM
 */
public class CodeResponse implements ICodeResponse {

    @Override
    public String getCode() {
        return codeResponse.getCode();
    }

    public static String getMessage(String filter) {
        for (ICodeResponse t : SuccessCode.values()) {
            if (t.getCode() == filter) {
                return t.getMessage();
            }
        }
        return null;
    }

    @Override
    public String getMessage() {
        return codeResponse.getMessage();
    }

    public enum SuccessCode implements ICodeResponse {
        ;

        private String code;
        private String message;

        SuccessCode(String code, String message) {
            this.code = code;
            this.message = message;
        }

        @Override
        public String getCode() {
            return code;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }

    public enum ClientErrorCode implements ICodeResponse {
        ;

        private String code;
        private String message;

        ClientErrorCode(String code, String message) {
            this.code = code;
            this.message = message;
        }

        @Override
        public String getCode() {
            return String.valueOf(code);
        }

        @Override
        public String getMessage() {
            return message;
        }
    }

    public enum ServerErrorCode implements ICodeResponse {
        SERVER_ERROR(5000, "Unknown error from server"),
        DATABASE_ERROR(5001, "Error from database"),
        INTERNAL_SERVER(500, "Internal Server Error"),
        NOT_IMPLEMENTED(501, "Not Implemented"),
        BAD_GATEWAY(5020, "Bad Gateway"),
        SERVICE_UNAVAILABLE(503, "Service Unavailable"),
        GATEWAY_TIMEOUT(504, "Gateway Timeout"),
        HTTP_VER_NOT_SUPPORT(505, "HTTP Version Not Supported"),
        VARIANT_NEGOTIATES(506, "Variant Also Negotiates"),
        INSUFFICIENT(507, "Insufficient Storage"),
        LOOP_DETECTED(508, "Loop Detected"),
        NOT_EXTENDED(510, "Not Extended"),
        NETWORK_AUTHEN_REQUIRED(511, "Network Authentication Required"),
        CHECK_POINT(103, "Checkpoint"),
        METHO_FAILURE(420, "Method Failure"),
        IM_A_FOX(419, "I'm a fox (Smoothwall/Foxwall)"),
        ENHANCE_UR_CALM(420, "Enhance Your Calm (Twitter)"),
        BLOCK_BY_WINDOWS(450, "Blocked by Windows Parental Controls (Microsoft)"),
        INVAILID_TOKEN(498, "Invalid Token (Esri)"),
        TOKEN_REQUIRED(499, "Token Required (Esri)"),
        ANTIVIRUS(499, "Request has been forbidden by antivirus"),
        BANDWIDTH_LIMIT_EXCEEDED(509, "Bandwidth Limit Exceeded"),
        SITE_FROZEN(530, "Site is frozen"),
        LOGIN_TIMEOUT(440, "Login Timeout"),
        RETRY_WITH(449, "Retry With"),
        REDIRECT(451, "Redirect"),
        NO_RESPONSE(444, "No Response"),
        SSL_CERT_ERR(495, "SSL Certificate Error"),
        SSL_CERT_REQ(496, "SSL Certificate Required"),
        HTTP_REQUEST_SENT_HTTPS_PORT(497, "HTTP Request Sent to HTTPS Port"),
        CLIENT_CLOSE_REQUEST(499, "Client Closed Request"),
        UNKNOWN_ERROR(520, "Unknown Error"),
        SERVER_DOWN(521, "Web Server Is Down"),
        CONNECTION_TIMEOUT(522, "Connection Timed Out"),
        ORIGIN_UNREACHABLE(523, "Origin Is Unreachable"),
        TIMEOUT_OCCURRED(524, "A Timeout Occurred"),
        SSL_HANDSHAKE_FAILED(525, "SSL Handshake Failed"),
        INVALID_SSL(526, "Invalid SSL Certificate"),
        RAILGUN_ERROR(527, "Railgun Error");

        private int code;
        private String message;

        ServerErrorCode(int code, String message) {
            this.code = code;
            this.message = message;
        }

        @Override
        public String getCode() {
            return String.valueOf(code);
        }

        public int getIntCode() {
            return code;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }

    public ICodeResponse codeResponse;

    public CodeResponse(ICodeResponse codeResponse) {
        this.codeResponse = codeResponse;
    }

    public enum HttpStatusCode implements ICodeResponse {
        CONTINUE(100, "Continue"),
        SWITCHINGPROTOCOLS(101, "Switching Protocols"),
        PROCESSING(102, "Processing"),
        OK(200, "OK"),
        CREATE(201, "The request has been fulfilled, resulting in the creation of a new resource."),
        ACCEPTED(202, "Accepted"),
        NON_AUTHOR_INFO(203, "Non-Authoritative Information"),
        NO_CONTENT(204, "No Content"),
        RESET_CONTENT(205, "Reset Content"),
        PARTIAL_CONTENT(206, "Partial Content"),
        MULTI_STATUS(207, "Multi-Status"),
        ALREADY_REPORTED(208, "Already Reported"),
        IM_USED(226, "IM Used"),
        BAD_REQUEST(400, "Bad Request"),
        UNAUTHORIZED(401, "Unauthorized"),
        PAYMENT_REQUIRED(402, "Payment Required"),
        FORBIDDEN(403, "Forbidden"),
        NOT_FOUND(404, "Not Found"),
        METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
        NOT_ACCEPTABLE(406, "Not Acceptable"),
        PROXY_AUTHEN_REQUIRED(407, "Proxy Authentication Required"),
        REQUEST_TIMEOUT(408, "Request Timeout"),
        CONFLICT(409, "Conflict"),
        GONE(410, "Gone"),
        LENGTH_REQUIRED(411, "Length Required"),
        PRECONDITION_FAILED(412, "Precondition Failed"),
        PAYLOAD_LARGE(413, "Payload Too Large"),
        URI_LONG(414, "URI Too Long"),
        UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
        RANGE_NOT_SATISFIABLE(416, "Range Not Satisfiable"),
        EXPECTATION_FAILED(417, "Expectation Failed"),
        RFC_203204(418, "I'm a teapot"),
        TRANSFER_FAILED(420, "BankTek internal transfer failed"),
        RFC_7540(421, "Misdirected Request"),
        RFC_4918(422, "Unprocessable Entity"),
        LOCKED(423, "Locked"),
        FAILED_DEPENDENCY(424, "Failed Dependency"),
        UPGRADE_REQUIRED(426, "Upgrade Required"),
        PRECONDITION_REQ(428, "Precondition Required"),
        MANY_REQUEST(429, "Too Many Requests"),
        UNAVAILABLE_LEGAL(451, "Unavailable For Legal Reasons"),
        HEADER_LARGE(431, "Request Header Fields Too Large"),
        CONFLICT_PHONE(441, "Conflict phone"),
        CONFLICT_SME_LICENSE(442, "Conflict sme license"),
        CONFLICT_EMAIL(443, "Conflict email"),
        CONFLICT_USERNAME(445, "Conflict username");

        private int code;
        private String message;

        HttpStatusCode(int code, String message) {
            this.code = code;
            this.message = message;
        }

        @Override
        public String getCode() {
            return String.valueOf(code);
        }

        public int getIntCode() {
            return code;
        }

        @Override
        public String getMessage() {
            return message;
        }


        public static HttpStatusCode safeValueOf(int code) {
            for (HttpStatusCode item : values()) {
                if (item.getIntCode() == code)
                    return item;
            }
            throw new CommonException.UnknownValuesException("Not found enum with code " + code);
        }
    }

}
