package pl.touk.wasjawa.java8.exercise.ex08;

import java.util.function.Supplier;

public class StupidLogger {
    private final LoggerMode mode;

    public StupidLogger(LoggerMode mode) {
        this.mode = mode;
    }

    public boolean isTraceEnable() {
        return isLevelEnable(LoggerMode.TRACE);
    }

    public boolean isDebugEnable() {
        return isLevelEnable(LoggerMode.DEBUG);
    }

    public boolean isInfoEnable() {
        return isLevelEnable(LoggerMode.INFO);
    }

    public boolean isWarnEnable() {
        return isLevelEnable(LoggerMode.WARNING);
    }

    public boolean isErrorEnable() {
        return isLevelEnable(LoggerMode.ERROR);
    }

    private boolean isLevelEnable(LoggerMode expectedMode) {
        return mode.getLevel() >= expectedMode.getLevel();
    }

    public void trace(Supplier<String> msg) {
        if (isTraceEnable()) {
            System.out.println(msg);
        }
    }

    public void debug(Supplier<String> msg) {
        if (isDebugEnable()) {
            System.out.println(msg.get());
        }
    }

    public void info(Supplier<String> msg) {
        if (isInfoEnable()) {
            System.out.println(msg.get());
        }
    }

    public void warn(Supplier<String> msg) {
        if (isWarnEnable()) {
            System.out.println(msg.get());
        }
    }

    public void error(Supplier<String> msg) {
        if (isErrorEnable()) {
            System.out.println(msg.get());
        }
    }
}
