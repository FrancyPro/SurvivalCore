package gq.francypro149.survivalcore.Commands;

import gq.francypro149.survivalcore.Main;
import gq.francypro149.survivalcore.Utils.ColorUtil;
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
        }
        return false;
    }
}
