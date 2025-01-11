package codes.sinister.increasedSpawners.plugin;

import codes.sinister.increasedSpawners.Main;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class increasedSpawnersPlugin extends JavaPlugin implements Listener {
    private @NotNull Main increasedSpawners;

    @Override
    public void onEnable() {
        increasedSpawners = new Main(this);
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        Optional.of(increasedSpawners).ifPresent(Main::disable);
    }
}
