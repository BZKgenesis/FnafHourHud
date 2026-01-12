package net.bzkgns.fnafhourhudmod;

public class ClientScoreData {
    private static int isEnabled = 0;
    private static int time = 0;

    public static void setIsEnabled(int value) {
        isEnabled = value;
    }

    public static int getIsEnabled() {
        return isEnabled;
    }

    public static void setTime(int value) {
        time = value;
    }

    public static int getTime() {
        return time;
    }
}