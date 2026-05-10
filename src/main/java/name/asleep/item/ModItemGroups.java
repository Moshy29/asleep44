package name.asleep.item;

import name.asleep.Asleep44;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup SLEEPING_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Asleep44.MOD_ID, "moon"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.moon"))
                    .icon(() -> new ItemStack(ModItems.MOON)).entries((displayContext, entries) -> {

                        entries.add(ModItems.MOON);
                        entries.add(ModItems.LONDON_VINCENT);

                        entries.add(ModItems.HUMMUS);

                        entries.add(ModItems.RYLAN_RAGE);

                        entries.add(Items.GLOW_ITEM_FRAME);


                    }).build());


    public static void registerItemGroups(){
        Asleep44.LOGGER.info("yada yada registering item groups n whatnot for " + Asleep44.MOD_ID);
    }
}
