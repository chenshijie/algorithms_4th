package com.jason.algs4ex;

public class SmartDate implements Comparable<SmartDate> {

    private static final int[] DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final int month;
    private final int day;
    private final int year;

    public SmartDate(int month, int day, int year) {
        if (!isValid(month, day, year)) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public SmartDate(String date) {
        String[] fields = date.split("/");
        if (fields.length != 3) {
            throw new IllegalArgumentException("Invalid date");
        }
        try {
            month = Integer.parseInt(fields[0]);
            day = Integer.parseInt(fields[1]);
            year = Integer.parseInt(fields[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid date");
        }

        if (!isValid(month, day, year)) {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    private static boolean isValid(int m, int d, int y) {
        if (m < 1 || m > 12) return false;
        if (d < 1 || d > DAYS[m]) return false;
        return m != 2 || d != 29 || isLeapYear(y);
    }

    private static boolean isLeapYear(int y) {
        if (y % 400 == 0) return true;
        if (y % 100 == 0) return false;
        return y % 4 == 0;
    }

    public int month() {
        return month;
    }

    public int day() {
        return month;
    }

    public int year() {
        return month;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        SmartDate that = (SmartDate) other;
        return (this.month == that.month) && (this.day == that.day) && (this.year == that.year);
    }

    public int compareTo(SmartDate that) {
        if (this.year > that.year) {
            return 1;
        }
        if (this.year < that.year) {
            return -1;
        }
        if (this.month > that.month) {
            return 1;
        }
        if (this.month < that.month) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }
}
