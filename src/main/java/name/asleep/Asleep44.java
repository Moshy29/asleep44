package name.asleep;

import name.asleep.item.ModItemGroups;
import name.asleep.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Asleep44 implements ModInitializer {
	public static final String MOD_ID = "asleep44";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("-- FABRIC WORLD LOADED -- ");
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();

	}
}