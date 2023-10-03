package gq.francypro149.survivalcore.Handlers;

import gq.francypro149.survivalcore.Utils.ColorUtil;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.title.Title;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinHandler implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Audience audience = Audience.audience((Audience) p);

        MiniMessage miniMessage = MiniMessage.miniMessage();

        //Title
        Component Titles = miniMessage.deserialize("<gradient:#116903:#63C754><bold>SURVIVAL</bold></gradient>");
        String title = ColorUtil.getColor(LegacyComponentSerializer.legacyAmpersand().serialize(Titles));

        //SubTitle
        Component SubTitles = miniMessage.deserialize("<gradient:#669160:#B0E6A8>Benvenuto nel Server!</gradient>");
        String subtitle = ColorUtil.getColor(LegacyComponentSerializer.legacyAmpersand().serialize(SubTitles));

        audience.showTitle(Title.title(Component.text(title), Component.text(subtitle)));

        //JoinMessage
        Component Joins = miniMessage.deserialize("<gradient:#116903:#63C754><bold>SURVIVAL</bold></gradient> <gradient:#669160:#B0E6A8>"+p.getName()+" è entrato nel server!</gradient>");
        String join = ColorUtil.getColor(LegacyComponentSerializer.legacyAmpersand().serialize(Joins));

        e.setJoinMessage(join);
    }
}
