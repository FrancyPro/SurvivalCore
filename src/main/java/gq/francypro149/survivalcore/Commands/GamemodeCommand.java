package gq.francypro149.survivalcore.Commands;

import gq.francypro149.survivalcore.Utils.ColorUtil;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ColorUtil.getColor("&cNon puoi eseguire questo comando dalla console!"));
            return true;
        }
        Player p = (Player) sender;
        Audience audience = Audience.audience((Audience) p);

        if(!p.hasPermission("survival.admin.gmc")) {
            audience.sendMessage(MiniMessage.miniMessage().deserialize("<gradient:#116903:#63C754><bold>SURVIVAL</bold></gradient> <gradient:#669160:#B0E6A8>Non puoi eseguire questo comando!</gradient>"));
            return true;
        }

        if (p.getGameMode() == GameMode.SURVIVAL) {
            p.setGameMode(GameMode.CREATIVE);
            audience.sendMessage(MiniMessage.miniMessage().deserialize("<gradient:#116903:#63C754><bold>SURVIVAL</bold></gradient> <gradient:#669160:#B0E6A8>GMC attivata!</gradient>"));
            return true;
        } else if (p.getGameMode() == GameMode.CREATIVE) {
            p.setGameMode(GameMode.SURVIVAL);
            audience.sendMessage(MiniMessage.miniMessage().deserialize("<gradient:#116903:#63C754><bold>SURVIVAL</bold></gradient> <gradient:#669160:#B0E6A8>GMC disattivata!</gradient>"));
            return true;
        }
        return false;
    }
}
