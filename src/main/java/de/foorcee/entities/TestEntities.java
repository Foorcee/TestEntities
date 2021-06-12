package de.foorcee.entities;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

public class TestEntities extends JavaPlugin {

    @Override
    public void onEnable() {
        World world = Bukkit.getWorlds().get(0);
        Chunk chunk = world.getChunkAt(world.getSpawnLocation());
        System.out.println("Chunk loaded: " + chunk.isLoaded() + " entities: " + chunk.getEntities().length);
        String name = "ID: " + System.currentTimeMillis();
        ArmorStand armorStand = (ArmorStand) world.spawnEntity(world.getSpawnLocation(), EntityType.ARMOR_STAND);
        armorStand.setCustomName(name);
        armorStand.setCustomNameVisible(true);

        System.out.println("Chunk loaded: " + chunk.isLoaded() + " " + chunk.getEntities().length);
        boolean unloaded = chunk.unload();
        System.out.println("Chunk unloaded: " + unloaded);
        chunk.load();
        System.out.println("Chunk loaded: " + chunk.isLoaded() + " " + chunk.getEntities().length);
        System.out.println("Please restart server");
    }
}
