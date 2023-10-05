package gq.francypro149.survivalcore.Commands;

import gq.francypro149.survivalcore.Economy.VaultHook;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class EconomyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");

            return true;
        }

        if (args.length < 2)
            return false;

        String param = args[0];
        String playerName = args[1];
        String amountRaw = args.length == 3 ? args[2] : "";

        OfflinePlayer target = Bukkit.getOfflinePlayer(playerName);
        Audience audience = Audience.audience((Audience) sender);

        if (!target.hasPlayedBefore()) {
            audience.sendMessage(MiniMessage.miniMessage().deserialize("<gradient:#116903:#63C754><bold>SURVIVAL</bold></gradient> <gradient:#669160:#B0E6A8>"+playerName+" non è mai entrato nel server!</gradient>"));

            return true;
        }

        if (!VaultHook.hasEconomy()) {
            audience.sendMessage(MiniMessage.miniMessage().deserialize("<gradient:#116903:#63C754><bold>SURVIVAL</bold></gradient> <gradient:#669160:#B0E6A8>Vault mancancante!</gradient>"));

            return true;
        }

        if ("view".equals(param)) {
            double balance = VaultHook.getBalance(target);

            audience.sendMessage(MiniMessage.miniMessage().deserialize("<gradient:#116903:#63C754><bold>SURVIVAL</bold></gradient> <gradient:#669160:#B0E6A8>Soldi del conto di "+target.getName()+": "+VaultHook.formatCurrencySymbol(balance)+"</gradient>"));

        } else if ("take".equals(param) || "give".equals(param)) {
            double amount;

            try {
                amount = Double.parseDouble(amountRaw);

            } catch (NumberFormatException e) {
                audience.sendMessage(MiniMessage.miniMessage().deserialize("<gradient:#116903:#63C754><bold>SURVIVAL</bold></gradient> <gradient:#669160:#B0E6A8>Valore decimale valido! "+args[1]+"</gradient>"));

                return true;
            }

            if ("take".equals(param)) {
                String errorMessage = VaultHook.withdraw(target, amount);

                if (errorMessage != null && !errorMessage.isEmpty()) {
                    audience.sendMessage(MiniMessage.miniMessage().deserialize("<gradient:#116903:#63C754><bold>SURVIVAL</bold></gradient> <gradient:#669160:#B0E6A8>Errore: "+errorMessage+"</gradient>"));
                } else {
                    audience.sendMessage(MiniMessage.miniMessage().deserialize("<gradient:#116903:#63C754><bold>SURVIVAL</bold></gradient> <gradient:#669160:#B0E6A8>Rimossi "+VaultHook.formatCurrencySymbol(amount)+" a "+target.getName()+"</gradient>"));
                }

            } else {
                String errorMessage = VaultHook.deposit(target, amount);

                if (errorMessage != null && !errorMessage.isEmpty()) {
                    audience.sendMessage(MiniMessage.miniMessage().deserialize("<gradient:#116903:#63C754><bold>SURVIVAL</bold></gradient> <gradient:#669160:#B0E6A8>Errore: " + errorMessage + "</gradient>"));
                } else {
                    audience.sendMessage(MiniMessage.miniMessage().deserialize("<gradient:#116903:#63C754><bold>SURVIVAL</bold></gradient> <gradient:#669160:#B0E6A8>Dati "+VaultHook.formatCurrencySymbol(amount)+" a "+target.getName()+"</gradient>"));
                }
            }

        } else {
            audience.sendMessage(MiniMessage.miniMessage().deserialize("<gradient:#116903:#63C754><bold>SURVIVAL</bold></gradient> <gradient:#669160:#B0E6A8>Comando sconosciuto!</gradient>"));
        }

        return false;
    }
}