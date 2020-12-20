package net.juligames.lobbyplugin.Navigator;

import net.juligames.lobbyplugin.LobbyPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CompassNavigator implements Listener {
  private final String GUI_NAME = "§a►  Teleporter";
  
  public void openGUI(Player player) {
    ItemStack netherstar = new ItemStack(Material.NETHER_STAR);
    ItemMeta itemMetaNetherstar = netherstar.getItemMeta();
    itemMetaNetherstar.setDisplayName("§lSpawn");
    netherstar.setItemMeta(itemMetaNetherstar);
    ItemStack slimeball = new ItemStack(Material.GRASS);
    ItemMeta itemMetaSlimeball = slimeball.getItemMeta();
    itemMetaSlimeball.setDisplayName("§lSkywars");
    slimeball.setItemMeta(itemMetaSlimeball);
    ItemStack BED = new ItemStack(Material.BED);
    ItemMeta itemMetaBED = BED.getItemMeta();
    itemMetaBED.setDisplayName("§lBedWars");
    BED.setItemMeta(itemMetaBED);
    ItemStack back = new ItemStack(Material.ARROW);
    ItemMeta itemMetaBack = back.getItemMeta();
    itemMetaBack.setDisplayName("§lZurück");
    back.setItemMeta(itemMetaBack);
    ItemStack diamond = new ItemStack(Material.DIAMOND_PICKAXE);
    ItemMeta itemMetaDiamond = diamond.getItemMeta();
    itemMetaDiamond.setDisplayName("§lCitybuild");
    diamond.setItemMeta(itemMetaDiamond);
    ItemStack diamondaxe = new ItemStack(Material.DIAMOND_AXE);
    ItemMeta itemMetaDiamondaxe = diamondaxe.getItemMeta();
    itemMetaDiamondaxe.setDisplayName("§lFreeBuild");
    diamondaxe.setItemMeta(itemMetaDiamondaxe);
    ItemStack diamondsword = new ItemStack(Material.DIAMOND_SWORD);
    ItemMeta itemMetaDiamondsword = diamondsword.getItemMeta();
    itemMetaDiamondsword.setDisplayName("§lKnockbackffa");
    diamondsword.setItemMeta(itemMetaDiamondsword);
    Inventory inventory = Bukkit.createInventory(null, 27, "§a►  Teleporter");
    inventory.setItem(13, new ItemStack(netherstar));
    inventory.setItem(10, new ItemStack(slimeball));
    inventory.setItem(16, new ItemStack(BED));
    inventory.setItem(26, new ItemStack(back));
    inventory.setItem(0, new ItemStack(diamond));
    inventory.setItem(8, new ItemStack(diamondaxe));
    inventory.setItem(18, new ItemStack(diamondsword));
    player.openInventory(inventory);
  }
  
  @EventHandler
  public void handleNavigatorOpen(PlayerInteractEvent event) {
    if (event.getItem() != null) {
      if (event.getItem().getType() != Material.COMPASS)
        return; 
      if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
        openGUI(event.getPlayer()); 
    } 
  }
  
  @EventHandler
  public void handleNavigatorGUIClick(InventoryClickEvent event) {
    if (!(event.getWhoClicked() instanceof Player))
      return; 
    Player player = (Player)event.getWhoClicked();
    if (event.getClickedInventory().getTitle().equals("§a►  Teleporter")) {
      FileConfiguration config;
      World world;
      double x, y, z;
      float yaw, pitch;
      Location location;
      FileConfiguration setlobbyspawn1config;
      World setlobbyspawn1world;
      double setlobbyspawn1x, setlobbyspawn1y, setlobbyspawn1z;
      float setlobbyspawn1yaw, setlobbyspawn1pitch;
      Location setlobbyspawn1location;
      FileConfiguration setlobbyspawn2config;
      World setlobbyspawn2world;
      double setlobbyspawn2x, setlobbyspawn2y, setlobbyspawn2z;
      float setlobbyspawn2yaw, setlobbyspawn2pitch;
      Location setlobbyspawn2location;
      FileConfiguration setlobbyspawn3config;
      World setlobbyspawn3world;
      double setlobbyspawn3x, setlobbyspawn3y, setlobbyspawn3z;
      float setlobbyspawn3yaw, setlobbyspawn3pitch;
      Location setlobbyspawn3location;
      FileConfiguration setlobbyspawn4config;
      World setlobbyspawn4world;
      double setlobbyspawn4x, setlobbyspawn4y, setlobbyspawn4z;
      float setlobbyspawn4yaw, setlobbyspawn4pitch;
      Location setlobbyspawn4location;
      FileConfiguration setlobbyspawn5config;
      World setlobbyspawn5world;
      double setlobbyspawn5x, setlobbyspawn5y, setlobbyspawn5z;
      float setlobbyspawn5yaw, setlobbyspawn5pitch;
      Location setlobbyspawn5location;
      event.setCancelled(true);
      switch (event.getCurrentItem().getType()) {
        case NETHER_STAR:
          config = LobbyPlugin.getPlugin().getConfig();
          world = Bukkit.getWorld(config.getString("Spawn.World"));
          x = config.getDouble("Spawn.X");
          y = config.getDouble("Spawn.Y");
          z = config.getDouble("Spawn.Z");
          yaw = (float)config.getDouble("Spawn.Yaw");
          pitch = (float)config.getDouble("Spawn.Pitch");
          location = new Location(world, x, y, z, yaw, pitch);
          player.teleport(location);
          player.playSound(player.getLocation(), Sound.FIREWORK_BLAST, 10.0F, 1.0F);
          return;
        case GRASS:
          setlobbyspawn1config = LobbyPlugin.getPlugin().getConfig();
          setlobbyspawn1world = Bukkit.getWorld(setlobbyspawn1config.getString("lobbySpawn1.World"));
          setlobbyspawn1x = setlobbyspawn1config.getDouble("lobbySpawn1.X");
          setlobbyspawn1y = setlobbyspawn1config.getDouble("lobbySpawn1.Y");
          setlobbyspawn1z = setlobbyspawn1config.getDouble("lobbySpawn1.Z");
          setlobbyspawn1yaw = (float)setlobbyspawn1config.getDouble("lobbySpawn1.Yaw");
          setlobbyspawn1pitch = (float)setlobbyspawn1config.getDouble("lobbySpawn1.Pitch");
          setlobbyspawn1location = new Location(setlobbyspawn1world, setlobbyspawn1x, setlobbyspawn1y, setlobbyspawn1z, setlobbyspawn1yaw, setlobbyspawn1pitch);
          player.teleport(setlobbyspawn1location);
          player.playSound(player.getLocation(), Sound.FIREWORK_TWINKLE, 10.0F, 1.0F);
          return;
        case BED:
          setlobbyspawn2config = LobbyPlugin.getPlugin().getConfig();
          setlobbyspawn2world = Bukkit.getWorld(setlobbyspawn2config.getString("lobbySpawn2.World"));
          setlobbyspawn2x = setlobbyspawn2config.getDouble("lobbySpawn2.X");
          setlobbyspawn2y = setlobbyspawn2config.getDouble("lobbySpawn2.Y");
          setlobbyspawn2z = setlobbyspawn2config.getDouble("lobbySpawn2.Z");
          setlobbyspawn2yaw = (float)setlobbyspawn2config.getDouble("lobbySpawn2.Yaw");
          setlobbyspawn2pitch = (float)setlobbyspawn2config.getDouble("lobbySpawn2.Pitch");
          setlobbyspawn2location = new Location(setlobbyspawn2world, setlobbyspawn2x, setlobbyspawn2y, setlobbyspawn2z, setlobbyspawn2yaw, setlobbyspawn2pitch);
          player.teleport(setlobbyspawn2location);
          player.playSound(player.getLocation(), Sound.FIREWORK_TWINKLE, 10.0F, 1.0F);
          return;
        case DIAMOND_PICKAXE:
          setlobbyspawn3config = LobbyPlugin.getPlugin().getConfig();
          setlobbyspawn3world = Bukkit.getWorld(setlobbyspawn3config.getString("lobbySpawn3.World"));
          setlobbyspawn3x = setlobbyspawn3config.getDouble("lobbySpawn3.X");
          setlobbyspawn3y = setlobbyspawn3config.getDouble("lobbySpawn3.Y");
          setlobbyspawn3z = setlobbyspawn3config.getDouble("lobbySpawn3.Z");
          setlobbyspawn3yaw = (float)setlobbyspawn3config.getDouble("lobbySpawn3.Yaw");
          setlobbyspawn3pitch = (float)setlobbyspawn3config.getDouble("lobbySpawn3.Pitch");
          setlobbyspawn3location = new Location(setlobbyspawn3world, setlobbyspawn3x, setlobbyspawn3y, setlobbyspawn3z, setlobbyspawn3yaw, setlobbyspawn3pitch);
          player.teleport(setlobbyspawn3location);
          player.playSound(player.getLocation(), Sound.FIREWORK_TWINKLE, 10.0F, 1.0F);
          return;
        case DIAMOND_AXE:
          setlobbyspawn4config = LobbyPlugin.getPlugin().getConfig();
          setlobbyspawn4world = Bukkit.getWorld(setlobbyspawn4config.getString("lobbySpawn4.World"));
          setlobbyspawn4x = setlobbyspawn4config.getDouble("lobbySpawn4.X");
          setlobbyspawn4y = setlobbyspawn4config.getDouble("lobbySpawn4.Y");
          setlobbyspawn4z = setlobbyspawn4config.getDouble("lobbySpawn4.Z");
          setlobbyspawn4yaw = (float)setlobbyspawn4config.getDouble("lobbySpawn4.Yaw");
          setlobbyspawn4pitch = (float)setlobbyspawn4config.getDouble("lobbySpawn4.Pitch");
          setlobbyspawn4location = new Location(setlobbyspawn4world, setlobbyspawn4x, setlobbyspawn4y, setlobbyspawn4z, setlobbyspawn4yaw, setlobbyspawn4pitch);
          player.teleport(setlobbyspawn4location);
          player.playSound(player.getLocation(), Sound.FIREWORK_TWINKLE, 10.0F, 1.0F);
          return;
        case DIAMOND_SWORD:
          setlobbyspawn5config = LobbyPlugin.getPlugin().getConfig();
          setlobbyspawn5world = Bukkit.getWorld(setlobbyspawn5config.getString("lobbySpawn5.World"));
          setlobbyspawn5x = setlobbyspawn5config.getDouble("lobbySpawn5.X");
          setlobbyspawn5y = setlobbyspawn5config.getDouble("lobbySpawn5.Y");
          setlobbyspawn5z = setlobbyspawn5config.getDouble("lobbySpawn5.Z");
          setlobbyspawn5yaw = (float)setlobbyspawn5config.getDouble("lobbySpawn5.Yaw");
          setlobbyspawn5pitch = (float)setlobbyspawn5config.getDouble("lobbySpawn5.Pitch");
          setlobbyspawn5location = new Location(setlobbyspawn5world, setlobbyspawn5x, setlobbyspawn5y, setlobbyspawn5z, setlobbyspawn5yaw, setlobbyspawn5pitch);
          player.teleport(setlobbyspawn5location);
          player.playSound(player.getLocation(), Sound.FIREWORK_TWINKLE, 10.0F, 1.0F);
          player.sendMessage("§8[§eInfo§8]§a Der Modus kommt noch!");
          return;
        case ARROW:
          player.closeInventory();
          return;
      } 
      player.sendMessage("§aDas ist ein leerer Slot.");
    } 
  }
}
