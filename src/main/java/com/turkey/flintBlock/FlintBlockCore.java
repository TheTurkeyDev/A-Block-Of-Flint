package com.turkey.flintBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
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
		theBlock = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0F, 6.0F));
		theBlock.setRegistryName(MODID, "flint_block");
		e.getRegistry().register(theBlock);
	}

	@SubscribeEvent
	public static void onItemRegistry(RegistryEvent.Register<Item> e)
	{
		BlockItem ib = new BlockItem(theBlock, (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS));
		ib.setRegistryName(theBlock.getRegistryName());
		e.getRegistry().register(ib);
	}
}