package dev.theturkey.flintBlock;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(FlintBlockCore.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FlintBlockCore
{
	public static final String MODID = "flintblock";

	private static Block theBlock;

	@SubscribeEvent
	public static void onBlockRegistry(RegistryEvent.Register<Block> e)
	{
		theBlock = new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(5.0F, 6.0F));
		theBlock.setRegistryName(MODID, "flint_block");
		e.getRegistry().register(theBlock);
	}

	@SubscribeEvent
	public static void onItemRegistry(RegistryEvent.Register<Item> e)
	{
		BlockItem ib = new BlockItem(theBlock, (new Item.Properties()).tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
		ib.setRegistryName(theBlock.getRegistryName());
		e.getRegistry().register(ib);
	}
}