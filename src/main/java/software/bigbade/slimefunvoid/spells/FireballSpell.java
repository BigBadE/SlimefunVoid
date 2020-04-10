package software.bigbade.slimefunvoid.spells;

import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import software.bigbade.slimefunvoid.api.Elements;
import software.bigbade.slimefunvoid.api.Researches;
import software.bigbade.slimefunvoid.impl.BasicSpell;

public class FireballSpell extends BasicSpell {
    public FireballSpell() {
        super(Researches.FIREBALL.getResearch(), Elements.FIRE, new CustomItem(Material.FIRE_CHARGE, Elements.FIRE.getColor() + "Fireball"), 2);
    }

    @Override
    public void onCast(Player player, ItemStack wand) {
        Fireball fireball = (Fireball) player.getWorld().spawnEntity(player.getEyeLocation(), EntityType.FIREBALL);
        Vector direction = player.getEyeLocation().getDirection().normalize();
        fireball.setVelocity(direction);
        fireball.getLocation().add(direction);
        fireball.setIsIncendiary(true);
        fireball.setShooter(player);
        fireball.setYield(getMultipliedDamage(wand, 1f, Elements.VOID));
    }

    @Override
    public void onBackfire(Player player, ItemStack wand) {
        player.getWorld().createExplosion(player.getLocation(), getBackfireDamage(wand, 1f, Elements.FIRE), true, true);
    }
}