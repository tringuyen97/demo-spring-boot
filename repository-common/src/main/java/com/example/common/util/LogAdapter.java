package com.example.common.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

/**
 * Creator: Nguyen Ngoc Tri
 * Date: 6/26/2023
 * Time: 11:14 PM
 */
public class LogAdapter {


    public enum LogType {
        END_USER("USER_");
        private String type;

        LogType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }


    private final Logger logger;
    private static final String _logger_signal = "{}";
    private static final String _line = "%line%";
    private static final String _message = "%message%";
    private static final String _exception = "%exception%";
    private static final String _threadName = "%threadName%";
    private final String pattern_normal = "[id: " + _threadName + "] [line: " + _line + "] - " + _message;
    private final String pattern_exception = "[id: " + _threadName + "] [line: " + _line + "] - Error: " + _exception + " - " + _message;
    private final String pattern_only_exception = "[id: " + _threadName + "] [line: " + _line + "] - Error: " + _exception;

    public static <T> LogAdapter newInstance(Class<T> instance) {
        return new LogAdapter(instance);
    }

    public void setIdRequest(String idRequest) {
        if (States.isNullOrEmpty(idRequest)) {
            //logger.warn("idLog not found - do not set idLog");
            //collation is null or empty - do nothing
            return;
        }
        boolean isLegal = false;
        for(LogType l : LogType.values()){
            if(idRequest.contains(l.getType())){
                isLegal = true;
            }
        }
        if(!isLegal) return; //idLog must be contain USER_ or CORE_ or AUTO_
        String name = Thread.currentThread().getName();
        for (LogType it : LogType.values()) {
            if (name.contains(it.getType())) {
                name = name.split(" " + it.getType())[0];
            }
        }
        Thread.currentThread().setName(name + " " + idRequest);
    }

    public String getCollationId() {
        String currentName = Thread.currentThread().getName();
        try {
            return currentName.substring(currentName.length() - 37);
            //37 = generator.length + refix
        } catch (Exception e) {
            return "";
        }
    }

    private <T> LogAdapter(Class<T> instance) {
        logger = LogManager.getLogger(instance);
    }

    public <T extends Throwable> void error(T e) {
        Integer currentLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
        String name = Thread.currentThread().getName();
        String log = pattern_only_exception
                .replace(_line, currentLine.toString())
                .replace(_exception, e.getClass() + " " + e.getMessage())
                .replace(_threadName, name);
        logger.error(log);
        logger.error(e);
    }

    //
    public void error(String message) {
        message = checkNull(message);
        String name = Thread.currentThread().getName();
        String id = "ThreadErrorId";
        if (name.contains(" ")) {
            id = name.split(" ")[1];
        }
        Integer currentLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
        String log = pattern_normal.replace(_line, currentLine.toString()).replace(_message, message).replace(_threadName, name);
        logger.error(new MarkerManager.Log4jMarker(id), log);
    }

    public <T extends Throwable> void error(T e, String message) {
        message = checkNull(message);
        Integer currentLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
        String name = Thread.currentThread().getName();
        String id = "ThreadErrorId";
        if (name.contains(" ")) {
            id = name.split(" ")[1];
        }
        String log = pattern_exception
                .replace(_exception, e.getClass() + " " + e.getMessage())
                .replace(_line, currentLine.toString()).replace(_message, message)
                .replace(_threadName, name);
        logger.error(new MarkerManager.Log4jMarker(id), log);
    }

    public void error(String message, Object... lstObject) {
        message = checkNull(message);
        Integer currentLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
        String name = Thread.currentThread().getName();
        String id = "ThreadErrorId";
        if (name.contains(" ")) {
            id = name.split(" ")[1];
        }
        String log = pattern_normal
                .replace(_threadName, name)
                .replace(_line, currentLine.toString())
                .replace(_message, message);
        logger.error(new MarkerManager.Log4jMarker(id), log, lstObject);
    }

    public <T extends Throwable> void error(T e, String message, Object... lstObject) {
        message = checkNull(message);
        String name = Thread.currentThread().getName();
        String id = "ThreadErrorId";
        if (name.contains(" ")) {
            id = name.split(" ")[1];
        }
        Integer currentLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
        String log = pattern_exception
                .replace(_line, currentLine.toString())
                .replace(_message, message)
                .replace(_exception, e.getClass() + " " + e.getMessage())
                .replace(_threadName, name);
        logger.error(new MarkerManager.Log4jMarker(id), log);
    }

    public <T extends Throwable> void errorStackTrace(T e, String message, Object... lstObject) {
        message = checkNull(message);
        String name = Thread.currentThread().getName();
        String id = "ThreadErrorId";
        if (name.contains(" ")) {
            id = name.split(" ")[1];
        }
        Integer currentLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
        String log = pattern_exception
                .replace(_line, currentLine.toString())
                .replace(_exception, e.getClass() + " " + e.getMessage())
                .replace(_message, message)
                .replace(_threadName, name);
        logger.error(new MarkerManager.Log4jMarker(id), log, lstObject, e);
    }

    public <T extends Throwable> void errorStackTrace(T e, String message) {
        message = checkNull(message);
        String name = Thread.currentThread().getName();
        String id = "ThreadErrorId";
        if (name.contains(" ")) {
            id = name.split(" ")[1];
        }
        Integer currentLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
        String log = pattern_exception
                .replace(_line, currentLine.toString()).replace(_message, message)
                .replace(_exception, e.getClass() + " " + e.getMessage())
                .replace(_threadName, name);
        logger.error(new MarkerManager.Log4jMarker(id), log, e);
    }

    public <T extends Throwable> void errorStackTrace(T e) {
        String name = Thread.currentThread().getName();
        String id = "ThreadErrorId";
        if (name.contains(" ")) {
            id = name.split(" ")[1];
        }
        Integer currentLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
        String log = pattern_exception
                .replace(_line, currentLine.toString()).replace(_message, "ERROR!")
                .replace(_exception, e.getClass() + " " + e.getMessage())
                .replace(_threadName, name);
        logger.error(new MarkerManager.Log4jMarker(id), log, e);
    }

    //
    public void warn(Object message) {
        message = checkNull(message);
        String name = Thread.currentThread().getName();
        String id = "ThreadErrorId";
        if (name.contains(" ")) {
            id = name.split(" ")[1];
        }
        Integer currentLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
        logger.warn(new MarkerManager.Log4jMarker(id), pattern_normal
                .replace(_message, message.toString())
                .replace(_line, currentLine.toString())
                .replace(_threadName, name));
    }

    public void warn(String message) {
        message = checkNull(message);
        String name = Thread.currentThread().getName();
        String id = "ThreadErrorId";
        if (name.contains(" ")) {
            id = name.split(" ")[1];
        }
        Integer currentLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
        logger.warn(new MarkerManager.Log4jMarker(id), pattern_normal
                .replace(_message, message)
                .replace(_line, currentLine.toString())
                .replace(_threadName, name));
    }

    public void warn(String message, Object... lstObject) {
        message = checkNull(message);
        String name = Thread.currentThread().getName();
        String id = "ThreadErrorId";
        if (name.contains(" ")) {
            id = name.split(" ")[1];
        }
        Integer currentLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
        logger.warn(new MarkerManager.Log4jMarker(id), pattern_normal
                .replace(_message, message)
                .replace(_line, currentLine.toString())
                .replace(_threadName, name), lstObject);
    }

    //
    public void info(Object message) {
        message = checkNull(message);
        String name = Thread.currentThread().getName();
        String id = "ThreadErrorId";
        if (name.contains(" ")) {
            id = name.split(" ")[1];
        }
        Integer currentLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
        logger.info(new MarkerManager.Log4jMarker(id), pattern_normal
                .replace(_message, message.toString())
                .replace(_line, currentLine.toString())
                .replace(_threadName, name));
    }

    public void info(String message) {
        message = checkNull(message);
        String name = Thread.currentThread().getName();
        String id = "ThreadErrorId";
        if (name.contains(" ")) {
            id = name.split(" ")[1];
        }
        Integer currentLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
        Marker marker = new MarkerManager.Log4jMarker(id);
        logger.info(marker, pattern_normal
                .replace(_message, message)
                .replace(_line, currentLine.toString())
                .replace(_threadName, name));
    }

    public void info(String message, Object... lstObject) {
        message = checkNull(message);
        String name = Thread.currentThread().getName();
        String id = "ThreadErrorId";
        if (name.contains(" ")) {
            id = name.split(" ")[1];
        }
        Integer currentLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
        logger.info(new MarkerManager.Log4jMarker(id), pattern_normal
                .replace(_message, message)
                .replace(_line, currentLine.toString())
                .replace(_threadName, name), lstObject);
    }

    //
    public void debug(Object message) {
        message = checkNull(message);
        String name = Thread.currentThread().getName();
        String id = "ThreadErrorId";
        if (name.contains(" ")) {
            id = name.split(" ")[1];
        }
        Integer currentLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
        logger.debug(new MarkerManager.Log4jMarker(id), pattern_normal
                .replace(_message, message.toString())
                .replace(_line, currentLine.toString())
                .replace(_threadName, name));
    }

    public void debug(String message) {
        message = checkNull(message);
        String name = Thread.currentThread().getName();
        String id = "ThreadErrorId";
        if (name.contains(" ")) {
            id = name.split(" ")[1];
        }
        Integer currentLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
        logger.debug(new MarkerManager.Log4jMarker(id), pattern_normal
                .replace(_message, message)
                .replace(_line, currentLine.toString())
                .replace(_threadName, name));
    }

    public void debug(String message, Object... lstObject) {
        message = checkNull(message);
        String name = Thread.currentThread().getName();
        String id = "ThreadErrorId";
        if (name.contains(" ")) {
            id = name.split(" ")[1];
        }
        Integer currentLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
        logger.debug(new MarkerManager.Log4jMarker(id), pattern_normal
                .replace(_message, message)
                .replace(_line, currentLine.toString())
                .replace(_threadName, name), lstObject);
    }

    //
    public void trace(Object message) {
        message = checkNull(message);
        String name = Thread.currentThread().getName();
        String id = "ThreadErrorId";
        if (name.contains(" ")) {
            id = name.split(" ")[1];
        }
        Integer currentLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
        logger.trace(new MarkerManager.Log4jMarker(id), pattern_normal
                .replace(_message, message.toString())
                .replace(_line, currentLine.toString())
                .replace(_threadName, name));
    }

    public void trace(String message) {
        message = checkNull(message);
        String name = Thread.currentThread().getName();
        String id = "ThreadErrorId";
        if (name.contains(" ")) {
            id = name.split(" ")[1];
        }
        Integer currentLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
        logger.trace(new MarkerManager.Log4jMarker(id), pattern_normal
                .replace(_message, message)
                .replace(_line, currentLine.toString())
                .replace(_threadName, name));
    }

    public void trace(String message, Object... lstObject) {
        message = checkNull(message);
        String name = Thread.currentThread().getName();
        String id = "ThreadErrorId";
        if (name.contains(" ")) {
            id = name.split(" ")[1];
        }
        Integer currentLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
        logger.trace(new MarkerManager.Log4jMarker(id), pattern_normal
                .replace(_message, message)
                .replace(_line, currentLine.toString())
                .replace(_threadName, name), lstObject);
    }

    private String checkNull(Object param) {
        if (param == null) return "null";
        return param.toString();
    }
}
