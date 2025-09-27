package com.sceptrenames;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("example")
public interface SceptreNamesConfig extends Config
{
	@ConfigItem(
		keyName = "jalsavrah",
		name = "Jalsavrah name",
		description = "The name to display for the Jalsavrah teleport"
	)
	default String jalsavrah()
	{
		return "Pyramid Plunder";
	}

    @ConfigItem(
            keyName = "jaleustrophos",
            name = "Jaleustrophos name",
            description = "The name to display for the Jaleustrophos teleport"
    )
    default String jaleustrophos()
    {
        return "Agility Pyramid";
    }

    @ConfigItem(
            keyName = "jaldraocht",
            name = "Jaldraocht name",
            description = "The name to display for the Jaldraocht teleport"
    )
    default String jaldraocht()
    {
        return "Desert Treasure Pyramid";
    }

    @ConfigItem(
            keyName = "jaltevas",
            name = "Jaltevas name",
            description = "The name to display for the Jaltevas teleport"
    )
    default String jaltevas()
    {
        return "Necropolis";
    }
}
