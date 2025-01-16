package me.duro.aviros.datagen

import me.duro.aviros.Aviros
import me.duro.aviros.block.ModBlocks
import me.duro.aviros.item.ModItems
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.*
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.AbstractCookingRecipe
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.item.crafting.RecipeSerializer
import net.minecraft.world.level.ItemLike
import java.util.concurrent.CompletableFuture

class ModRecipeProvider(lookupProvider: HolderLookup.Provider, output: RecipeOutput) :
    RecipeProvider(lookupProvider, output) {
    override fun buildRecipes() {
        ShapedRecipeBuilder.shaped(
            registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModBlocks.SKYRITE_BLOCK
        ).pattern("###").pattern("###").pattern("###").define('#', ModBlocks.SKYRITE_ORE)
            .unlockedBy("has_skyrite", has(ModItems.SKYRITE)).save(output)

        ShapelessRecipeBuilder.shapeless(
            registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModItems.SKYRITE, 9
        ).requires(ModBlocks.SKYRITE_BLOCK).unlockedBy("has_skyrite_block", has(ModBlocks.SKYRITE_BLOCK)).save(output)

        oreSmelting(
            listOf(ModBlocks.SKYRITE_ORE, ModBlocks.DEEPSLATE_SKYRITE_ORE),
            RecipeCategory.MISC,
            ModItems.SKYRITE,
            0.7f,
            200,
            "skyrite"
        )

        oreBlasting(
            listOf(ModBlocks.SKYRITE_ORE, ModBlocks.DEEPSLATE_SKYRITE_ORE),
            RecipeCategory.MISC,
            ModItems.SKYRITE,
            0.7f,
            100,
            "skyrite"
        )

        ShapedRecipeBuilder.shaped(
            registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModItems.JYNWOOD_ROD, 4
        ).pattern("  #").pattern(" # ").pattern("#  ").define('#', ModBlocks.JYNWOOD_PLANKS)
            .unlockedBy("has_jynwood_planks", has(ModBlocks.JYNWOOD_PLANKS)).save(output)

        pickaxeRecipe(RecipeCategory.TOOLS, ModItems.SKYRITE_PICKAXE, ModItems.SKYRITE)
        axeRecipe(RecipeCategory.TOOLS, ModItems.SKYRITE_AXE, ModItems.SKYRITE)
        hoeRecipe(RecipeCategory.TOOLS, ModItems.SKYRITE_HOE, ModItems.SKYRITE)
        shovelRecipe(RecipeCategory.TOOLS, ModItems.SKYRITE_SHOVEL, ModItems.SKYRITE)
        swordRecipe(RecipeCategory.COMBAT, ModItems.SKYRITE_SWORD, ModItems.SKYRITE)
        helmetRecipe(RecipeCategory.COMBAT, ModItems.SKYRITE_HELMET, ModItems.SKYRITE)
        chestplateRecipe(RecipeCategory.COMBAT, ModItems.SKYRITE_CHESTPLATE, ModItems.SKYRITE)
        leggingsRecipe(RecipeCategory.COMBAT, ModItems.SKYRITE_LEGGINGS, ModItems.SKYRITE)
        bootsRecipe(RecipeCategory.COMBAT, ModItems.SKYRITE_BOOTS, ModItems.SKYRITE)

        shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JYNWOOD_PLANKS, 4).requires(ModBlocks.JYNWOOD_LOG)
            .unlockedBy("has_jynwood_log", has(ModBlocks.JYNWOOD_LOG))
            .save(output, "${Aviros.MOD_ID}:jynwood_planks_from_jynwood_log")
        shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JYNWOOD_PLANKS, 4).requires(ModBlocks.STRIPPED_JYNWOOD_LOG)
            .unlockedBy("has_jynwood_log", has(ModBlocks.JYNWOOD_LOG))
            .save(output, "${Aviros.MOD_ID}:jynwood_planks_from_stripped_jynwood_log")
        shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JYNWOOD_PLANKS, 4).requires(ModBlocks.JYNWOOD_WOOD)
            .unlockedBy("has_jynwood_wood", has(ModBlocks.JYNWOOD_WOOD))
            .save(output, "${Aviros.MOD_ID}:jynwood_planks_from_jynwood_wood")
        shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JYNWOOD_PLANKS, 4).requires(ModBlocks.STRIPPED_JYNWOOD_WOOD)
            .unlockedBy("has_jynwood_wood", has(ModBlocks.JYNWOOD_WOOD))
            .save(output, "${Aviros.MOD_ID}:jynwood_planks_from_stripped_jynwood_wood")

        ShapedRecipeBuilder.shaped(
            registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModBlocks.JYNWOOD_WOOD
        ).pattern("##").pattern("##").define('#', ModBlocks.JYNWOOD_LOG)
            .unlockedBy("has_jynwood_log", has(ModItems.SKYRITE)).save(output)

        ShapedRecipeBuilder.shaped(
            registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModBlocks.STRIPPED_JYNWOOD_WOOD
        ).pattern("##").pattern("##").define('#', ModBlocks.STRIPPED_JYNWOOD_LOG)
            .unlockedBy("has_stripped_jynwood_log", has(ModBlocks.STRIPPED_JYNWOOD_LOG)).save(output)

        stairBuilder(ModBlocks.JYNWOOD_STAIRS, Ingredient.of(ModBlocks.JYNWOOD_PLANKS)).group("jynwood")
            .unlockedBy("has_jynwood_planks", has(ModBlocks.JYNWOOD_PLANKS)).save(output)
        slabBuilder(
            RecipeCategory.BUILDING_BLOCKS, ModBlocks.JYNWOOD_SLAB, Ingredient.of(ModBlocks.JYNWOOD_PLANKS)
        ).group("jynwood").unlockedBy("has_jynwood_planks", has(ModBlocks.JYNWOOD_PLANKS)).save(output)
        buttonBuilder(ModBlocks.JYNWOOD_BUTTON, Ingredient.of(ModBlocks.JYNWOOD_PLANKS)).group("jynwood")
            .unlockedBy("has_jynwood_planks", has(ModBlocks.JYNWOOD_PLANKS)).save(output)
        fenceBuilder(ModBlocks.JYNWOOD_FENCE, Ingredient.of(ModBlocks.JYNWOOD_PLANKS)).group("jynwood")
            .unlockedBy("has_jynwood_planks", has(ModBlocks.JYNWOOD_PLANKS)).save(output)
        fenceGateBuilder(ModBlocks.JYNWOOD_FENCE_GATE, Ingredient.of(ModBlocks.JYNWOOD_PLANKS)).group("jynwood")
            .unlockedBy("has_jynwood_planks", has(ModBlocks.JYNWOOD_PLANKS)).save(output)
        doorBuilder(ModBlocks.JYNWOOD_DOOR, Ingredient.of(ModBlocks.JYNWOOD_PLANKS)).group("jynwood")
            .unlockedBy("has_jynwood_planks", has(ModBlocks.JYNWOOD_PLANKS)).save(output)
        trapdoorBuilder(ModBlocks.JYNWOOD_TRAPDOOR, Ingredient.of(ModBlocks.JYNWOOD_PLANKS)).group("jynwood")
            .unlockedBy("has_jynwood_planks", has(ModBlocks.JYNWOOD_PLANKS)).save(output)
        pressurePlateBuilder(
            RecipeCategory.BUILDING_BLOCKS, ModBlocks.JYNWOOD_PRESSURE_PLATE, Ingredient.of(ModBlocks.JYNWOOD_PLANKS)
        ).group("jynwood")

        ShapedRecipeBuilder.shaped(
            registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModBlocks.AVIROS_PORTAL
        ).pattern("NNN").pattern("NSN").pattern("NNN").define('N', Items.NETHERITE_INGOT).define('S', Items.NETHER_STAR)
            .unlockedBy("has_netherite_ingot", has(Items.NETHERITE_INGOT))
            .unlockedBy("has_nether_star", has(Items.NETHER_STAR)).save(output)
    }

    override fun <T : AbstractCookingRecipe?> oreCooking(
        serializer: RecipeSerializer<T>,
        recipeFactory: AbstractCookingRecipe.Factory<T>,
        ingredients: MutableList<ItemLike>,
        category: RecipeCategory,
        result: ItemLike,
        experience: Float,
        cookingTime: Int,
        group: String,
        suffix: String,
    ) {
        ingredients.forEach {
            SimpleCookingRecipeBuilder.generic(
                Ingredient.of(it), category, result, experience, cookingTime, serializer, recipeFactory
            ).group(group).unlockedBy(getHasName(it), this.has(it))
                .save(this.output, Aviros.MOD_ID + ":" + (getItemName(result) + suffix) + "_" + getItemName(it))
        }
    }

    private fun pickaxeRecipe(category: RecipeCategory, result: ItemLike, ingredient: ItemLike) =
        ShapedRecipeBuilder.shaped(
            registries.lookupOrThrow(Registries.ITEM), category, result
        ).pattern("###").pattern(" S ").pattern(" S ").define('#', ingredient).define('S', ModItems.JYNWOOD_ROD)
            .unlockedBy("has_" + getItemName(ingredient), has(ingredient)).save(output)

    private fun axeRecipe(category: RecipeCategory, result: ItemLike, ingredient: ItemLike) =
        ShapedRecipeBuilder.shaped(
            registries.lookupOrThrow(Registries.ITEM), category, result
        ).pattern("##").pattern("#S").pattern(" S").define('#', ingredient).define('S', ModItems.JYNWOOD_ROD)
            .unlockedBy("has_" + getItemName(ingredient), has(ingredient)).save(output)

    private fun hoeRecipe(category: RecipeCategory, result: ItemLike, ingredient: ItemLike) =
        ShapedRecipeBuilder.shaped(
            registries.lookupOrThrow(Registries.ITEM), category, result
        ).pattern("##").pattern(" S").pattern(" S").define('#', ingredient).define('S', ModItems.JYNWOOD_ROD)
            .unlockedBy("has_" + getItemName(ingredient), has(ingredient)).save(output)

    private fun shovelRecipe(category: RecipeCategory, result: ItemLike, ingredient: ItemLike) =
        ShapedRecipeBuilder.shaped(
            registries.lookupOrThrow(Registries.ITEM), category, result
        ).pattern("#").pattern("S").pattern("S").define('#', ingredient).define('S', ModItems.JYNWOOD_ROD)
            .unlockedBy("has_" + getItemName(ingredient), has(ingredient)).save(output)

    private fun swordRecipe(category: RecipeCategory, result: ItemLike, ingredient: ItemLike) =
        ShapedRecipeBuilder.shaped(
            registries.lookupOrThrow(Registries.ITEM), category, result
        ).pattern("#").pattern("#").pattern("S").define('#', ingredient).define(
            'S', ModItems.JYNWOOD_ROD
        ).unlockedBy("has_" + getItemName(ingredient), has(ingredient)).save(output)

    private fun helmetRecipe(category: RecipeCategory, result: ItemLike, ingredient: ItemLike) =
        ShapedRecipeBuilder.shaped(
            registries.lookupOrThrow(Registries.ITEM), category, result
        ).pattern("###").pattern("# #").define('#', ingredient)
            .unlockedBy("has_" + getItemName(ingredient), has(ingredient)).save(output)

    private fun chestplateRecipe(category: RecipeCategory, result: ItemLike, ingredient: ItemLike) =
        ShapedRecipeBuilder.shaped(
            registries.lookupOrThrow(Registries.ITEM), category, result
        ).pattern("# #").pattern("###").pattern("###").define('#', ingredient)
            .unlockedBy("has_" + getItemName(ingredient), has(ingredient)).save(output)

    private fun leggingsRecipe(category: RecipeCategory, result: ItemLike, ingredient: ItemLike) =
        ShapedRecipeBuilder.shaped(
            registries.lookupOrThrow(Registries.ITEM), category, result
        ).pattern("###").pattern("# #").pattern("# #").define('#', ingredient)
            .unlockedBy("has_" + getItemName(ingredient), has(ingredient)).save(output)

    private fun bootsRecipe(category: RecipeCategory, result: ItemLike, ingredient: ItemLike) =
        ShapedRecipeBuilder.shaped(
            registries.lookupOrThrow(Registries.ITEM), category, result
        ).pattern("# #").pattern("# #").define('#', ingredient)
            .unlockedBy("has_" + getItemName(ingredient), has(ingredient)).save(output)

    class Runner(
        output: PackOutput, provider: CompletableFuture<HolderLookup.Provider>,
    ) : RecipeProvider.Runner(output, provider) {
        override fun createRecipeProvider(provider: HolderLookup.Provider, output: RecipeOutput) =
            ModRecipeProvider(provider, output)

        override fun getName() = "Aviros Recipes"
    }
}