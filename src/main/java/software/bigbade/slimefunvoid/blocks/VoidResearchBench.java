package software.bigbade.slimefunvoid.blocks;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SimpleSlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockUseHandler;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import software.bigbade.slimefunvoid.items.Items;
import software.bigbade.slimefunvoid.menus.research.ResearchBenchMenu;
import software.bigbade.slimefunvoid.utils.RecipeItems;

import javax.annotation.Nonnull;

public final class VoidResearchBench extends SimpleSlimefunItem<BlockUseHandler> {

    private ResearchBenchMenu menu = new ResearchBenchMenu();

    public VoidResearchBench(@Nonnull Category category) {
        super(category, Items.VOID_RESEARCH_BENCH, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{RecipeItems.ENDER_EYE, RecipeItems.BOOK, RecipeItems.ENDER_EYE,
                RecipeItems.OBSIDIAN, RecipeItems.END_CRYSTAL, RecipeItems.OBSIDIAN,
                RecipeItems.ENDER_EYE, RecipeItems.ENCHANTING_TABLE, RecipeItems.ENDER_EYE}, Items.VOID_RESEARCH_BENCH);
    }

    @Override
    public BlockUseHandler getItemHandler() {
        return event -> {
            menu.open(event.getPlayer());
            event.setUseBlock(Event.Result.DENY);
        };
    }
}
