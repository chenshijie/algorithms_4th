package com.jason.algs4ex;

public class ConsoleColor {
    public static final int COLOR_BLACK = 0;
    public static final int COLOR_RED = 1;
    public static final int COLOR_GREEN = 2;
    public static final int COLOR_YELLOW = 3;
    public static final int COLOR_BLUE = 4;
    public static final int COLOR_MAGENTA = 5;
    public static final int COLOR_CYAN = 6;
    public static final int COLOR_GRAY = 7;

    public static final int FONT_TYPE_END = 0;
    public static final int FONT_TYPE_BOLD = 1;
    public static final int FONT_TYPE_ITALIC = 3;
    public static final int FONT_TYPE_UNDERLINE = 4;
    public static final int FONT_TYPE_BLINK = 5;
    public static final int FONT_TYPE_QUICK_BLINK = 6;
    public static final int FONT_TYPE_DELETE = 9;

    public static String color(String content, int fontColor, int fontType, int backgroundColor) {
        return String.format("\033[%d;%d;%dm%s\033[0m", 30 + fontColor, fontType, 40 + backgroundColor, content);
    }

    public static String color(String content, int fontColor) {
        return String.format("\033[%dm%s\033[0m", 30 + fontColor, content);
    }

    public static String color(String content, String contentFormat, int fontColor) {
        return String.format("\033[%dm" + contentFormat + "\033[0m", 30 + fontColor, content);
    }

    public static String color(String content, int fontColor, int fontType) {
        return String.format("\033[%d;%dm%s\033[0m", 30 + fontColor, fontType, content);
    }

    public static String color(String content, String contentFormat, int fontColor, int fontType) {
        return String.format("\033[%d;%dm" + contentFormat + "\033[0m", 30 + fontColor, fontType, content);
    }
}
