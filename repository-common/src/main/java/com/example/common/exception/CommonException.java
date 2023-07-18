package com.example.common.exception;

/**
 * Copyright by Intelin.
 * Creator: Nguyen Ngoc Chau
 * Date: 4/17/19
 * Time: 9:58 AM
 */
public class CommonException {

    public static class DeployException extends BaseException {
        public DeployException(String msg) {
            super(msg);
        }

        public DeployException(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    public static class FileException extends BaseException {
        public FileException(String msg) {
            super(msg);
        }

        public FileException(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    public static class NotFoundValuesException extends BaseException {
        public NotFoundValuesException(String msg) {
            super(msg);
        }

        public NotFoundValuesException(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    public static class GenerateException extends BaseException {
        public GenerateException(String msg) {
            super(msg);
        }

        public GenerateException(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    public static class ForbiddenException extends BaseException {
        public ForbiddenException(String msg) {
            super(msg);
        }

        public ForbiddenException(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    public static class TimeoutException extends BaseException {
        public TimeoutException(String msg) {
            super(msg);
        }

        public TimeoutException(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    public static class ValidationError extends BaseException {
        public ValidationError(String msg) {
            super(msg);
        }

        public ValidationError(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    public static class HMACException extends BaseException {
        public HMACException(String msg) {
            super(msg);
        }

        public HMACException(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    public static class ConfigException extends BaseException {
        public ConfigException(String msg) {
            super(msg);
        }

        public ConfigException(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    public static class JsonException extends BaseException {
        public JsonException(String msg) {
            super(msg);
        }

        public JsonException(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    public static class XmlException extends BaseException {
        public XmlException(String msg) {
            super(msg);
        }

        public XmlException(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    public static class UnsupportException extends BaseException {
        public UnsupportException(String msg) {
            super(msg);
        }

        public UnsupportException(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    public static class UnknownValuesException extends BaseException {
        public UnknownValuesException(String msg) {
            super(msg);
        }

        public UnknownValuesException(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    public static class UnknownException extends BaseException {
        public UnknownException(String msg) {
            super(msg);
        }

        public UnknownException(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    public static class DuplicationException extends BaseException {
        public DuplicationException(String msg) {
            super(msg);
        }

        public DuplicationException(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

}
