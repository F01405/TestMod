package f01405.TestMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import f01405.TestMod.Armor.softFireBootsArmor;
import f01405.TestMod.Armor.softFireChestplateArmor;
import f01405.TestMod.Armor.softFireHelmetArmor;
import f01405.TestMod.Armor.softFireLeggingsArmor;
import f01405.TestMod.Biomes.biomeFireBiome;
import f01405.TestMod.Blocks.blockFireDirt;
import f01405.TestMod.Blocks.blockFireGrass;
import f01405.TestMod.Blocks.blockFireLeaf;
import f01405.TestMod.Blocks.blockFireLog;
import f01405.TestMod.Blocks.blockFireSapling;
import f01405.TestMod.Blocks.blockFireTest;
import f01405.TestMod.Crop.blockChilliCrop;
import f01405.TestMod.Entity.EntityFireBug;
import f01405.TestMod.Food.chilliItem;
import f01405.TestMod.Food.foodCupCake;
import f01405.TestMod.Food.itemChilliSeeds;
import f01405.TestMod.Items.hotSauceItem;
import f01405.TestMod.Model.fireBug;
import f01405.TestMod.Render.RenderFireBug;
import f01405.TestMod.Spawn.customSpawner;
import f01405.TestMod.Tools.hardFirePickaxeItem;
import f01405.TestMod.Tools.hardFireSwordItem;
import f01405.TestMod.Tools.softFirePickaxeItem;
import f01405.TestMod.Tools.softFireSwordItem;

@Mod(modid="TestMod", name="TestMod", version="v1.5.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class testMod {
	
	@Instance(value = "TestMod")
	public static testMod instance;
	
	//creative tabs
	public static CreativeTabs tabFire = new CreativeTabs("tabFire"){
		
		public ItemStack getIconItemStack(){
			return new ItemStack(softFireIngot);
		}
	};
	
	//armor
	public static Item softFireHelmet;
	public static Item softFireChestplate;
	public static Item softFireLeggings;
	public static Item softFireBoots;
	
	//tools
	public static Item softFireSword;
	public static Item softFirePickaxe;
	public static Item hardFireSword;
	public static Item hardFirePickaxe;
	
	//Define Mobs id
	public static int startEntityId = 300;
	
	//materials
	public static EnumToolMaterial materialSoftFireIngot = EnumHelper.addToolMaterial("materialSoftFireIngot", 2, 1261, 9, 4.0F, 9);
	public static EnumToolMaterial materialHardFireIngot = EnumHelper.addToolMaterial("materialHardFireIngot", 3, 1961, 7, 2.0F, 11);
	public static EnumArmorMaterial materialSoftFireIngotArmor = EnumHelper.addArmorMaterial("materialSoftFireIngotArmor", 66, new int[] {3, 7, 6, 3}, 30);
	
	public static Block chilliBlock;
	
	//food
	public static Item cupCake;
	public static Item hotSauce;
	public static Item chilli;
	public static Item chilliSeeds;
	
	//biomes
	public static BiomeGenBase fireBiome;
	
	//Define Custom Mob Spawner
	public static Item customSpawner;
	
	//mob gen
	public static int getUniqueEntityId() {
		do {
			startEntityId++;
		}
		while (EntityList.getStringFromID(startEntityId) != null);
		return startEntityId++;
	}
	
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) {
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}
	
	//items
	public final static Item fireRock = new TestModBasicItems(2000)
	.setUnlocalizedName("fireRock")
	.setMaxStackSize(64)
	.setCreativeTab(tabFire)
	.func_111206_d("testmod:fireRock");
	
	public final static Item softFireIngot = new TestModBasicItems(2001)
	.setUnlocalizedName("softFireIngot")
	.setMaxStackSize(64)
	.setCreativeTab(tabFire)
	.func_111206_d("testmod:softFireIngot");
	
	public final static Item hardFireIngot = new TestModBasicItems(2030)
	.setMaxStackSize(64).setUnlocalizedName("hardFireIngot")
	.setCreativeTab(tabFire)
	.func_111206_d("testmod:hardFireIngot");
	
	//blocks
	
	public static Block fireDirt;
	public static Block fireGrass;
	public static Block fireLog;
	public static Block fireLeaf;
	public static Block fireSapling;
	public static Block fireTest;
	
	public final static Block oreFire = new oreFire(2004, Material.rock)
	.setHardness(3.0F)
	.setUnlocalizedName("oreFire")
	.setStepSound(Block.soundStoneFootstep)
	.setCreativeTab(tabFire)
	.func_111022_d("testmod:oreFire");
	
	
	@SidedProxy(clientSide="f01405.TestMod.client.ClientProxy", serverSide="f01405.TestMod.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void load(FMLPreInitializationEvent event) {
		proxy.registerRenderThings();
		proxy.registerServerTickHandler();
		
		//items
		hotSauce = new hotSauceItem(3447).setUnlocalizedName("hotSauce").setCreativeTab(tabFire).setMaxStackSize(1);
		
		//blocks
		fireDirt = new blockFireDirt(161, Material.ground).setUnlocalizedName("fireDirt").setHardness(0.5F).setResistance(0.5F).setStepSound(Block.soundGrassFootstep).setCreativeTab(tabFire);
		fireGrass = new blockFireGrass(160, Material.grass).setUnlocalizedName("fireGrass").setHardness(0.5F).setResistance(0.5F).setStepSound(Block.soundGrassFootstep).setCreativeTab(tabFire);
		chilliBlock = new blockChilliCrop(3501).setUnlocalizedName("chilliBlock");
		fireLog = new blockFireLog(1017).setUnlocalizedName("fireLog").setHardness(1.5F).setStepSound(Block.soundWoodFootstep).setCreativeTab(this.tabFire);
		fireLeaf = new blockFireLeaf(1018).setUnlocalizedName("fireLeaf").setHardness(0.2F).setStepSound(Block.soundGrassFootstep).setCreativeTab(this.tabFire);
		fireSapling = new blockFireSapling(1019).setUnlocalizedName("fireSapling").setHardness(0.0F).setCreativeTab(this.tabFire);
		fireTest = new blockFireTest(1020).setUnlocalizedName("fireTest").setHardness(0.5F).setCreativeTab(this.tabFire);
		
		GameRegistry.registerBlock(fireDirt, "fireDirt");
		LanguageRegistry.addName(fireDirt, "Fire Dirt");
		
		GameRegistry.registerBlock(fireTest, "fireTest");
		LanguageRegistry.addName(fireTest, "Fire Test");
		
		GameRegistry.registerBlock(fireLog, "fireLog");
		LanguageRegistry.addName(fireLog, "Fire Log");
		
		GameRegistry.registerBlock(fireLeaf, "fireLeaf");
		LanguageRegistry.addName(fireLeaf, "Fire Leaves");
		
		GameRegistry.registerBlock(fireSapling, "fireSapling");
		LanguageRegistry.addName(fireSapling, "Fire Tree Sapling");
		
		GameRegistry.registerBlock(fireGrass, "fireGrass");
		LanguageRegistry.addName(fireGrass, "Fire Grass");
				
		GameRegistry.registerBlock(chilliBlock, "chilliBlock");
		LanguageRegistry.addName(chilliBlock, "Chilli Crop Block");
				
		GameRegistry.registerBlock(oreFire, "oreFire");
		LanguageRegistry.addName(oreFire, "Fire Ore");
		MinecraftForge.setBlockHarvestLevel(oreFire, "pickaxe", 2);
		
		//settings armor
		softFireHelmet = new softFireHelmetArmor(3505, materialSoftFireIngotArmor, ModLoader.addArmor("softFireIngot"), 0).setUnlocalizedName("softFireIngotHelmet").setCreativeTab(tabFire);
		softFireChestplate = new softFireChestplateArmor(3506, materialSoftFireIngotArmor, ModLoader.addArmor("softFireIngot"), 1).setUnlocalizedName("softFireIngotChestplate").setCreativeTab(tabFire);
		softFireLeggings = new softFireLeggingsArmor(3507, materialSoftFireIngotArmor, ModLoader.addArmor("softFireIngot"), 2).setUnlocalizedName("softFireIngotLeggings").setCreativeTab(tabFire);
		softFireBoots = new softFireBootsArmor(3508, materialSoftFireIngotArmor, ModLoader.addArmor("softFireIngot"), 3).setUnlocalizedName("softFireIngotBoots").setCreativeTab(tabFire);
		
				
		
		//food
		cupCake = new foodCupCake(3446, 3, 0.5F, false).setUnlocalizedName("testmod:cupCake").setCreativeTab(CreativeTabs.tabFood).setMaxStackSize(16);
		chilli = new chilliItem(3500, 4, 0.3F, false).setUnlocalizedName("chilli");
		chilliSeeds = new itemChilliSeeds(3502, chilliBlock.blockID, Block.tilledField.blockID).setUnlocalizedName("chilliSeeds");
		GameRegistry.registerItem(chilliSeeds, "chilliSeeds");
		LanguageRegistry.addName(chilliSeeds, "Chilli Seeds");
		
		
		//tools
		softFireSword = new softFireSwordItem(2121, materialSoftFireIngot).setUnlocalizedName("testmod:softFireSword").setCreativeTab(tabFire);
		softFirePickaxe = new softFirePickaxeItem(2122, materialSoftFireIngot).setUnlocalizedName("testmod:softFirePickaxe").setCreativeTab(tabFire);
		hardFireSword = new hardFireSwordItem(2123, materialHardFireIngot).setUnlocalizedName("testmod:hardFireSword").setCreativeTab(tabFire);
		hardFirePickaxe = new hardFirePickaxeItem(2124, materialHardFireIngot).setUnlocalizedName("testmod:hardFirePickaxe").setCreativeTab(tabFire);
		
		//settings for biomes
		fireBiome = new biomeFireBiome(150).setBiomeName("Cake").setMinMaxHeight(0.23F, 0.22F);
		
		//Settings for Custom Spawner
		customSpawner = new customSpawner(1016).setUnlocalizedName("customSpawner").func_111206_d("testmod:customSpawner").setCreativeTab(this.tabFire);
		
		//Settings for mob
		EntityRegistry.registerGlobalEntityID(EntityFireBug.class, "FireBug", 1);
		EntityRegistry.addSpawn(EntityFireBug.class, 10, 2, 4, EnumCreatureType.monster);
		EntityRegistry.addSpawn(EntityFireBug.class, 10, 2, 4, EnumCreatureType.monster, fireBiome);
		EntityRegistry.findGlobalUniqueEntityId();
		//registerEntityEgg(EntityFireBug.class, 0x3c768c, 0xb50000);
		RenderingRegistry.registerEntityRenderingHandler(EntityFireBug.class, new RenderFireBug(new fireBug(), 0.3F));
		
		LanguageRegistry.instance().addStringLocalization("entity.FireBug.name", "Fire Bug");
		
		//register biome
		GameRegistry.addBiome(fireBiome);
		
		//register custom spawner
		LanguageRegistry.addName(customSpawner, "Spawn");
		
		//creative tabs
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabFire", "en_US", "Fire Stone Mod");
		
		//items
		GameRegistry.registerItem(fireRock, "fireRock");
		LanguageRegistry.addName(fireRock, "Fire Rock");
		
		GameRegistry.registerItem(softFireIngot, "softFireIngot");
		LanguageRegistry.addName(softFireIngot, "Soft Fire Ingot");
		
		GameRegistry.registerItem(hardFireIngot, "hardFireIngot");
		LanguageRegistry.addName(hardFireIngot, "Hard Fire Ingot");
		
		GameRegistry.registerItem(hotSauce, "hotSauce");
		LanguageRegistry.addName(hotSauce, "Hot Sauce");
		
		GameRegistry.registerItem(chilli, "chilli");
		LanguageRegistry.addName(chilli, "Chilli");
	
		//register food
		GameRegistry.registerItem(cupCake, "cupCake");
		LanguageRegistry.addName(cupCake, "Cupcake");
		
		//events
		MinecraftForge.EVENT_BUS.register(new Fire_Bonemeal_Event());
		
		//register armor
		GameRegistry.registerItem(softFireHelmet, "softFireHelmet");
		LanguageRegistry.addName(softFireHelmet, "Soft Fire Helmet");
		
		GameRegistry.registerItem(softFireChestplate, "softFireChestplate");
		LanguageRegistry.addName(softFireChestplate, "Soft Fire Chestplate");
		
		GameRegistry.registerItem(softFireLeggings, "softFireLeggings");
		LanguageRegistry.addName(softFireLeggings, "Soft Fire Leggings");
		
		GameRegistry.registerItem(softFireBoots, "softFireBoots");
		LanguageRegistry.addName(softFireBoots, "Soft Fire Boots");
		
		//register tools
		GameRegistry.registerItem(softFireSword, "softFireSword");
		LanguageRegistry.addName(softFireSword, "Soft Fire Sword");
		
		GameRegistry.registerItem(softFirePickaxe, "softFirePickaxe");
		LanguageRegistry.addName(softFirePickaxe, "Soft Fire Pickaxe");
		
		GameRegistry.registerItem(hardFireSword, "hardFireSword");
		LanguageRegistry.addName(hardFireSword, "Hard Fire Sword");
		
		GameRegistry.registerItem(hardFirePickaxe, "hardFirePickaxe");
		LanguageRegistry.addName(hardFirePickaxe, "Hard Fire Pickaxe");
		
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		
		//crafting	
	    GameRegistry.addRecipe(new ItemStack(softFireIngot, 4), " S ", "SOS", " S ", 'S', fireRock, 'O', Block.obsidian);
	    GameRegistry.addRecipe(new ItemStack(softFireIngot, 4), "S S", " O ", "S S", 'S', fireRock, 'O', Block.obsidian);
	    GameRegistry.addRecipe(new ItemStack(softFireSword), " S ", " S ", " T ", 'S', softFireIngot, 'T', Item.stick);
	    GameRegistry.addRecipe(new ItemStack(softFirePickaxe), "SSS", " T ", " T ", 'S', softFireIngot, 'T', Item.stick);
	    GameRegistry.addRecipe(new ItemStack(hardFireSword), " H ", " H ", " S ", 'H', hardFireIngot, 'S', Item.stick);
	    GameRegistry.addRecipe(new ItemStack(hardFirePickaxe), "HHH", " S ", " S ", 'H', hardFireIngot, 'S', Item.stick);
	    GameRegistry.addRecipe(new ItemStack(cupCake, 8), new Object[] {"CWC", "SMS", "PEP", 'S', new ItemStack(Item.sugar, 1), 'W', new ItemStack(Item.wheat, 1), 'M', new ItemStack(Item.bucketMilk, 1), 'P', new ItemStack(Item.paper, 1), 'E', new ItemStack(Item.egg, 1), 'C', new ItemStack(Item.dyePowder, 1, 3)});
	    GameRegistry.addRecipe(new ItemStack(hotSauce), new Object[] {" L ", "CBC", " C ", 'L', new ItemStack(Item.bucketLava, 1), 'C', new ItemStack(chilli, 1), 'B', new ItemStack (Item.glassBottle, 1)});
	    GameRegistry.addRecipe(new ItemStack(softFireHelmet), new Object[] {"SSS", "S S", 'S', new ItemStack(softFireIngot, 1)});
	    GameRegistry.addRecipe(new ItemStack(softFireChestplate), new Object[] {"S S", "SSS", "SSS", 'S', new ItemStack(softFireIngot, 1)});
	    GameRegistry.addRecipe(new ItemStack(softFireLeggings), new Object[] {"SSS", "S S", "S S", 'S', new ItemStack(softFireIngot, 1)});
	    GameRegistry.addRecipe(new ItemStack(softFireBoots), new Object[] {"S S", "S S", 'S', new ItemStack(softFireIngot, 1)});
	    
	    //smelting
	    GameRegistry.addSmelting(softFireIngot.itemID, new ItemStack (hardFireIngot), 0.1f);
	    
	    //world generators
	    GameRegistry.registerWorldGenerator(new WorldGeneratorTestMod());
		
	}
	
	@EventHandler
	public void load(FMLPostInitializationEvent event) {
		
	}

}
