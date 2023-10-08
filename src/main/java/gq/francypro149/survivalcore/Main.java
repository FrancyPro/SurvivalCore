package gq.francypro149.survivalcore;

import gq.francypro149.survivalcore.Commands.EconomyCommand;
import gq.francypro149.survivalcore.Commands.GamemodeCommand;
import gq.francypro149.survivalcore.Commands.MainCommand;
import gq.francypro149.survivalcore.Economy.EconomyManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Main plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        if (getServer().getPluginManager().getPlugin("Vault") != null) {
            EconomyManager.register();
        }

        registerCommands();

        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands() {
        getCommand("survival").setExecutor(new MainCommand());
        getCommand("economy").setExecutor(new EconomyCommand());
        getCommand("gmc").setExecutor(new GamemodeCommand());
    }
}
