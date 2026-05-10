package name.asleep.item;

import name.asleep.Asleep44;
import name.asleep.item.custom.RylanRageItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item MOON = registerItem("moon", new Item(new FabricItemSettings()));
    public static final Item LONDON_VINCENT = registerItem("london_vincent", new Item(new FabricItemSettings()));

    public static final Item HUMMUS = registerItem("hummus", new Item(new FabricItemSettings().food(ModFoodComponents.HUMMUS)));

    public static final Item RYLAN_RAGE = registerItem("rylan_rage", new RylanRageItem(
            new FabricItemSettings().maxDamage(64)));

    private static void addItemstoIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(MOON);
        entries.add(LONDON_VINCENT);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Asleep44.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Asleep44.LOGGER.info("Registering Mod Items for " + Asleep44.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemstoIngredientItemGroup);
    }
}
