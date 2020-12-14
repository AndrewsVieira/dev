package model.utils;

public class StringDate {
    public static String getDayOfDate(String originalFormatDate) {
        String day = "";
        for (int i = 0; i < originalFormatDate.length(); i++) {
            if (i > 7 && i < 10) {
                day += originalFormatDate.charAt(i);
            }
        }
        return day;
    }

    public static String getMonthOfDate(String originalFormatDate) {
        String month = "";
        for (int i = 0; i < originalFormatDate.length(); i++) {
            if (i > 4 && i < 7) {
                month += originalFormatDate.charAt(i);
            }
        }
        return month;
    }

    public static String getYearOfDate(String originalFormatDate) {
        String year = "";
        for (int i = 0; i < originalFormatDate.length(); i++) {
            if (i >= 0 && i < 4) {
                year += originalFormatDate.charAt(i);
            }
        }
        return year;
    }
}
