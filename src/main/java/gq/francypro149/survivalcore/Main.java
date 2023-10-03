package gq.francypro149.survivalcore;

import gq.francypro149.survivalcore.Commands.MainCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Main plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        registerCommands();

        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands() {
        getCommand("survival").setExecutor(new MainCommand());
    }
}
