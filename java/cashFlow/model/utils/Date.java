package model.utils;

public class Date {

    public static int getYearOfDate(String date) {
        int INICIAL_INDEX = 6;
        int FINAL_INDEX = 9;
        String partStr = getPartString(date, INICIAL_INDEX, FINAL_INDEX);
        int year = Integer.parseInt(partStr);

        return year;
    }

    public static int getDayOfDate(String date) {
        int INICIAL_INDEX = 0;
        int FINAL_INDEX = 1;
        String partStr = getPartString(date, INICIAL_INDEX, FINAL_INDEX);
        int intPartStr = Integer.parseInt(partStr);

        int day = 0;

        if (intPartStr > 0 && intPartStr <= limit(getMonthOfDate(date), getYearOfDate(date))) {
            day = intPartStr;
        }

        return day;
    }

    private static int limit(int monthOfDate, int year) {
        int limitDayOfMonth = 0;

        if (monthOfDate >= 1 && monthOfDate <= 12) {
            if (!yearIsLeap(year)) {
                switch (monthOfDate) {
                    case 2:
                        limitDayOfMonth = 28;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        limitDayOfMonth = 30;
                        break;
                    default:
                        limitDayOfMonth = 31;
                        break;
                }
            } else {
                switch (monthOfDate) {
                    case 2:
                        limitDayOfMonth = 29;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        limitDayOfMonth = 30;
                        break;
                    default:
                        limitDayOfMonth = 31;
                        break;
                }
            }
        }

        return limitDayOfMonth;
    }

    private static int getMonthOfDate(String date) {
        int INICIAL_INDEX = 3;
        int FINAL_INDEX = 4;
        String partStr = getPartString(date, INICIAL_INDEX, FINAL_INDEX);
        int intPartStr = Integer.parseInt(partStr);

        int month = 0;

        if (intPartStr >= 1 && intPartStr <= 12) {
            month = intPartStr;
        }

        return month;
    }

    private static String getPartString(String str, int indexIni, int indexEnd) {
        String partStr = new String();
        for (int i = indexIni; i <= indexEnd; i++) {
            partStr += i;
        }
        return partStr;
    }

    private static boolean yearIsLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

}
