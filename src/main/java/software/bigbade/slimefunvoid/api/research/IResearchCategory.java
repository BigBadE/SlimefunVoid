package software.bigbade.slimefunvoid.api.research;

import org.bukkit.ChatColor;

import java.util.List;

public interface IResearchCategory {
    List<IVoidResearch> getResearches();

    String getName();

    ChatColor getColor();

    int getId();
}
