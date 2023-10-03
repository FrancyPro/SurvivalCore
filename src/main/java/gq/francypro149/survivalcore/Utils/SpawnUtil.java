package gq.francypro149.survivalcore.Utils;

import gq.francypro149.survivalcore.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.Objects;

public class SpawnUtil {
    public static Location location;

    public static void getSpawn() {
        World world = Main.plugin.getServer().getWorld(Objects.requireNonNull(Main.plugin.getConfig().getString("Functions.Spawn.world")));
        double x = Main.plugin.getConfig().getDouble("Functions.Spawn.x");
        double y = Main.plugin.getConfig().getDouble("Functions.Spawn.y");
        double z = Main.plugin.getConfig().getDouble("Functions.Spawn.z");
        float yaw = (float) Main.plugin.getConfig().getDouble("Functions.Spawn.yaw");
        float pitch = (float) Main.plugin.getConfig().getDouble("Functions.Spawn.pitch");
        location = new Location(world, x, y, z, yaw, pitch);
    }

    public static void setSpawn(Location setLocation) {
        Main.plugin.getConfig().set("Functions.Spawn.Setted", "true");
        Main.plugin.getConfig().set("Functions.Spawn.world", setLocation.getWorld().getName());
        Main.plugin.getConfig().set("Functions.Spawn.x", setLocation.getX());
        Main.plugin.getConfig().set("Functions.Spawn.y", setLocation.getY());
        Main.plugin.getConfig().set("Functions.Spawn.z", setLocation.getZ());
        Main.plugin.getConfig().set("Functions.Spawn.yaw", setLocation.getYaw());
        Main.plugin.getConfig().set("Functions.Spawn.pitch", setLocation.getPitch());
    }
}
