package com.turkey.flintBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = FlintBlockCore.MODID, version = FlintBlockCore.VERSION, name = FlintBlockCore.NAME)
public class FlintBlockCore
{
	public static final String MODID = "flintblock";
	public static final String NAME = "A Block of Flint";
	public static final String VERSION = "1.0";

	public static Block theBlock;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(this);
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		if(event.getSide() == Side.CLIENT)
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(theBlock), 0, new ModelResourceLocation(MODID + ":flint_block", "inventory"));

		ResourceLocation group = new ResourceLocation(NAME);
		GameRegistry.addShapedRecipe(new ResourceLocation(MODID, "Flint Block Compression"), group, new ItemStack(theBlock, 1), "III", "III", "III", 'I', new ItemStack(Items.FLINT, 1));
		GameRegistry.addShapelessRecipe(new ResourceLocation(MODID, "Flint Block Uncompression"), group, new ItemStack(Items.FLINT, 9), Ingredient.func_193369_a(new ItemStack(theBlock, 1)));
	}

	@SubscribeEvent
	public void onBlockRegistry(RegistryEvent.Register<Block> e)
	{
		theBlock = new Block(Material.GROUND);
		theBlock.setCreativeTab(CreativeTabs.MATERIALS);
		theBlock.setHardness(5);
		theBlock.setRegistryName(MODID, "flint_block");
		theBlock.setUnlocalizedName("flint_block");
		e.getRegistry().register(theBlock);
	}

	@SubscribeEvent
	public void onItemRegistry(RegistryEvent.Register<Item> e)
	{
		ItemBlock ib = new ItemBlock(theBlock);
		ib.setRegistryName(theBlock.getRegistryName());
		e.getRegistry().register(ib);
	}
}