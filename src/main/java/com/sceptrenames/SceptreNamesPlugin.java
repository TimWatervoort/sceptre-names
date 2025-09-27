package com.sceptrenames;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Pharaoh's Sceptre"
)
public class SceptreNamesPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private SceptreNamesConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Example started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Example stopped!");
	}

    @Subscribe
    public void onMenuOpened(MenuOpened event) {
        MenuEntry[] entries = event.getMenuEntries();
        boolean isSceptre = false;
        for (MenuEntry entry : entries) {
            if (entry.getTarget().contains("Pharaoh's sceptre")) {
                isSceptre = true;
                break;
            }
        }
        if (!isSceptre) {
            return;
        }

        for (MenuEntry entry : event.getMenuEntries()) {
            if (entry.getOption().equals("Teleport")) {
                log.info(String.valueOf(entry));
            }
            boolean hasSubmenu = entry.getSubMenu() != null;
            if (hasSubmenu) {
                MenuEntry[] submenuEntries = entry.getSubMenu().getMenuEntries();
                for (MenuEntry submenuEntry : submenuEntries) {
                    if (submenuEntry.getOption().equals("Jalsavrah")) {
                        submenuEntry.setOption(config.jalsavrah());
                    }
                    if (submenuEntry.getOption().equals("Jaleustrophos")) {
                        submenuEntry.setOption(config.jaleustrophos());
                    }
                    if (submenuEntry.getOption().equals("Jaldraocht")) {
                        submenuEntry.setOption(config.jaldraocht());
                    }
                    if (submenuEntry.getOption().equals("Jaltevas")) {
                        submenuEntry.setOption(config.jaltevas());
                    }
                }
            }

        }
    }

	@Provides
    SceptreNamesConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SceptreNamesConfig.class);
	}
}
