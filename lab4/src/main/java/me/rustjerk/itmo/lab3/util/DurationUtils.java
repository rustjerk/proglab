package me.rustjerk.itmo.lab3.util;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public final class DurationUtils {
    public static String format(Duration duration) {
        StringBuilder sb = new StringBuilder();

        long days = duration.toDays();
        long hours = duration.toHours() - TimeUnit.DAYS.toHours(duration.toDays());
        long minutes = duration.toMinutes() - TimeUnit.HOURS.toMinutes(duration.toHours());
        long seconds = duration.getSeconds() - TimeUnit.MINUTES.toSeconds(duration.toMinutes());

        if (days > 0)
            sb.append(days).append(" дн. ");
        if (hours > 0)
            sb.append(hours).append(" ч. ");
        if (minutes > 0)
            sb.append(minutes).append(" мин. ");
        if (seconds > 0)
            sb.append(seconds).append(" с. ");
        if (sb.length() == 0)
            sb.append("0 с.");

        return sb.toString().trim();
    }
}
