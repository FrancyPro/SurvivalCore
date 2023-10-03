package gq.francypro149.survivalcore.Utils;

import gq.francypro149.survivalcore.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.Objects;

public class SpawnUtil {
    private static Location location;

    public static void getSpawn() {
        String setted = Main.plugin.getConfig().getString("Functions.Spawn.Setted");
        World world = Main.plugin.getServer().getWorld(Objects.requireNonNull(Main.plugin.getConfig().getString("Functions.Spawn.world")));
        double x = Main.plugin.getConfig().getDouble("Functions.Spawn.x");
        double y = Main.plugin.getConfig().getDouble("Functions.Spawn.y");
        double z = Main.plugin.getConfig().getDouble("Functions.Spawn.z");
        float yaw = (float) Main.plugin.getConfig().getDouble("Functions.Spawn.yaw");
        float pitch = (float) Main.plugin.getConfig().getDouble("Functions.Spawn.pitch");
        if (Objects.equals(setted, "true")) {
            location = new Location(world, x, y, z, yaw, pitch);
        } else {
            Bukkit.getLogger().warning("Spawn non settato!");
        }
    }

    public static void setSpawn() {
        Main.plugin.getConfig().set("Functions.Spawn.Setted", "true");
        Main.plugin.getConfig().set("Functions.Spawn.world", location.getWorld().getName());
        Main.plugin.getConfig().set("Functions.Spawn.x", location.getX());
        Main.plugin.getConfig().set("Functions.Spawn.y", location.getY());
        Main.plugin.getConfig().set("Functions.Spawn.z", location.getZ());
        Main.plugin.getConfig().set("Functions.Spawn.yaw", location.getYaw());
        Main.plugin.getConfig().set("Functions.Spawn.pitch", location.getPitch());
    }
}
