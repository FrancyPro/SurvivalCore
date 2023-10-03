package gq.francypro149.survivalcore.Utils;

import org.bukkit.ChatColor;

public class ColorUtil {
    public static String getColor(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
