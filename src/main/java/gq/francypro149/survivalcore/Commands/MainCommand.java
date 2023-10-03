package gq.francypro149.survivalcore.Commands;

import gq.francypro149.survivalcore.Main;
import gq.francypro149.survivalcore.Utils.ColorUtil;
import gq.francypro149.survivalcore.Utils.SpawnUtil;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ColorUtil.getColor("&cNon puoi eseguire questo comando dalla console!"));
            return true;
        }
        Player p = (Player) sender;
        Audience audience = Audience.audience((Audience) p);

        if (args.length == 0) {
            audience.sendMessage(MiniMessage.miniMessage().deserialize("<gradient:#116903:#63C754><bold>SURVIVAL</bold></gradient> <gradient:#669160:#B0E6A8>"+Main.plugin.getDescription().getName()+" made by "+Main.plugin.getDescription().getAuthors().get(0)+" v"+Main.plugin.getDescription().getVersion()+"</gradient>"));
            return true;
        } else if (args.length == 1 && args[0].equalsIgnoreCase("setspawn")) {
            SpawnUtil.setSpawn(p.getLocation());
            audience.sendMessage(MiniMessage.miniMessage().deserialize("<gradient:#116903:#63C754><bold>SURVIVAL</bold></gradient> <gradient:#669160:#B0E6A8>Hai settato lo spawn!</gradient>"));
        } else if (args.length == 1 && args[0].equalsIgnoreCase("spawn")) {
            if (!Main.plugin.getConfig().getString("Functions.Spawn.Setted").equalsIgnoreCase("true")) {
                audience.sendMessage(MiniMessage.miniMessage().deserialize("<gradient:#116903:#63C754><bold>SURVIVAL</bold></gradient> <gradient:#669160:#B0E6A8>Lo spawn non è stato settato!</gradient>"));
            }
            p.teleport(SpawnUtil.location);
            audience.sendMessage(MiniMessage.miniMessage().deserialize("<gradient:#116903:#63C754><bold>SURVIVAL</bold></gradient> <gradient:#669160:#B0E6A8>Sei stato teletrasportato allo spawn!</gradient>"));
        }
        return false;
    }
}
