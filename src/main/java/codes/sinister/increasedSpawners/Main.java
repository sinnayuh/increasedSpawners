package codes.sinister.increasedSpawners;

import codes.sinister.increasedSpawners.listeners.SpawnerListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class Main {
    public final @NotNull JavaPlugin plugin;

    private static Main increasedSpawners;

    public static Main getInstance() {
        return increasedSpawners;
    }

    public Main(@NotNull JavaPlugin plugin) {
        increasedSpawners = this;
        this.plugin = plugin;

        registerListeners();
    }

    private void registerListeners() {
        List.of(
            new SpawnerListener()
        ).forEach(listener -> plugin.getServer().getPluginManager().registerEvents(listener, plugin));
    }

    public void disable() {
        increasedSpawners = null;
    }
}