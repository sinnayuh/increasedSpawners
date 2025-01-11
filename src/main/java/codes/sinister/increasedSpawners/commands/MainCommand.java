package codes.sinister.increasedSpawners.commands;

import codes.sinister.increasedSpawners.Main;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.DefaultFor;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.annotation.CommandPermission;

@Command({"increasedspawners", "is", "inc"})
@CommandPermission("increasedspawners.admin")
public record MainCommand() {
    @DefaultFor({"increasedspawners", "is", "inc"})
    public void onBaseCommand(Player sender) {
        sender.sendMessage(Component.text("Increased Spawners Help", NamedTextColor.YELLOW).decoration(TextDecoration.BOLD, true));
        sender.sendMessage(Component.text("/inc help", NamedTextColor.YELLOW).append(Component.text(" - Shows this help menu", NamedTextColor.GRAY)));
        sender.sendMessage(Component.text("/inc version", NamedTextColor.YELLOW).append(Component.text(" - Shows the plugin version", NamedTextColor.GRAY)));
        sender.sendMessage(Component.text("/inc getradius", NamedTextColor.YELLOW).append(Component.text(" - Gets the spawner range", NamedTextColor.GRAY)));
        sender.sendMessage(Component.text("/inc setradius <int>", NamedTextColor.YELLOW).append(Component.text(" - Sets the spawner range", NamedTextColor.GRAY)));
    }

    @Subcommand({"help"})
    public void onHelpCommand(Player sender) {
        sender.sendMessage(Component.text("Increased Spawners Help", NamedTextColor.YELLOW).decoration(TextDecoration.BOLD, true));
        sender.sendMessage(Component.text("/inc help", NamedTextColor.YELLOW).append(Component.text(" - Shows this help menu", NamedTextColor.GRAY)));
        sender.sendMessage(Component.text("/inc version", NamedTextColor.YELLOW).append(Component.text(" - Shows the plugin version", NamedTextColor.GRAY)));
        sender.sendMessage(Component.text("/inc getradius", NamedTextColor.YELLOW).append(Component.text(" - Gets the spawner range", NamedTextColor.GRAY)));
        sender.sendMessage(Component.text("/inc setradius <int>", NamedTextColor.YELLOW).append(Component.text(" - Sets the spawner range", NamedTextColor.GRAY)));
    }

    @Subcommand({"version", "ver"})
    public void onVersionCommand(Player sender) {
        sender.sendMessage(Component.text("Increased Spawners v" + Main.getInstance().plugin.getDescription().getVersion(), NamedTextColor.YELLOW));
    }

    @Subcommand({"setradius"})
    public void onSetRadiusCommand(Player sender, int radius) {
        Block targetBlock = sender.getTargetBlock(null, 5);

        if (targetBlock.getType() != Material.SPAWNER) {
            sender.sendMessage(Component.text("You must be looking at a spawner!", NamedTextColor.RED));
            return;
        }

        CreatureSpawner spawner = (CreatureSpawner) targetBlock.getState();
        spawner.setRequiredPlayerRange(radius);
        spawner.update();

        sender.sendMessage(Component.text("Spawner range set to " + radius + " blocks", NamedTextColor.YELLOW));
    }

    @Subcommand({"getradius"})
    public void onGetRadiusCommand(Player sender) {
        Block targetBlock = sender.getTargetBlock(null, 5);

        if (targetBlock.getType() != Material.SPAWNER) {
            sender.sendMessage(Component.text("You must be looking at a spawner!", NamedTextColor.RED));
            return;
        }

        CreatureSpawner spawner = (CreatureSpawner) targetBlock.getState();
        int radius = spawner.getRequiredPlayerRange();

        sender.sendMessage(Component.text("Spawner range is currently " + radius + " blocks", NamedTextColor.YELLOW));
    }
}
