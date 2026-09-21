package net.montoyo.wd.core;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.montoyo.wd.WebDisplays;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/*
 * TODO registration-only port. Every item below is registered as a plain vanilla Item for now --
 * none of the original use/right-click/tooltip logic (see legacy-1.12.2/.../item) has been ported.
 *
 * The original mod modeled upgrades, craft components and advancement icons as a single Item
 * subclass per group with NBT/damage-value variants (the "ItemMulti" pattern). That pattern was
 * phased out of vanilla Minecraft around 1.13; each variant is registered as its own distinct item
 * here instead, which is the modern convention.
 */
public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WebDisplays.MODID);

    public static final DeferredItem<BlockItem> SCREEN = ITEMS.registerSimpleBlockItem("screen", ModBlocks.SCREEN);
    public static final DeferredItem<BlockItem> PERIPHERAL = ITEMS.registerSimpleBlockItem("peripheral", ModBlocks.PERIPHERAL);
    // No item for keyboard_right -- it's a companion block auto-placed next to a keyboard peripheral, never held/placed directly.

    public static final DeferredItem<Item> SCREEN_CONFIGURATOR = ITEMS.registerSimpleItem("screencfg", p -> p.stacksTo(1));
    public static final DeferredItem<Item> OWNERSHIP_THIEF = ITEMS.registerSimpleItem("ownerthief", p -> p.stacksTo(1));
    public static final DeferredItem<Item> LINKER = ITEMS.registerSimpleItem("linker", p -> p.stacksTo(1));
    public static final DeferredItem<Item> MINE_PAD = ITEMS.registerSimpleItem("minepad", p -> p.stacksTo(1));
    public static final DeferredItem<Item> LASER_POINTER = ITEMS.registerSimpleItem("laserpointer", p -> p.stacksTo(1));

    public static final java.util.Map<DefaultUpgrade, DeferredItem<Item>> UPGRADES = registerPerVariant("upgrade_", DefaultUpgrade.values(), DefaultUpgrade::toString);
    public static final java.util.Map<CraftComponent, DeferredItem<Item>> CRAFT_COMPONENTS = registerPerVariant("craftcomp_", CraftComponent.values(), CraftComponent::toString);
    public static final java.util.Map<AdvancementIcon, DeferredItem<Item>> ADVANCEMENT_ICONS = registerPerVariant("advicon_", AdvancementIcon.values(), AdvancementIcon::toString);

    private static <E extends Enum<E>> java.util.Map<E, DeferredItem<Item>> registerPerVariant(String prefix, E[] values, java.util.function.Function<E, String> nameOf) {
        java.util.Map<E, DeferredItem<Item>> map = new java.util.EnumMap<>(values[0].getDeclaringClass());
        for (E value : values)
            map.put(value, ITEMS.registerSimpleItem(prefix + nameOf.apply(value)));

        return map;
    }

}
