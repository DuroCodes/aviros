package me.duro.aviros.datagen

import me.duro.aviros.Aviros
import me.duro.aviros.block.ModBlocks
import me.duro.aviros.item.ModItems
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.*
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
        suffix: String
    ) {
        ingredients.forEach {
            SimpleCookingRecipeBuilder.generic(
                Ingredient.of(it), category, result, experience, cookingTime, serializer, recipeFactory
            ).group(group).unlockedBy(getHasName(it), this.has(it))
                .save(this.output, Aviros.MOD_ID + ":" + (getItemName(result) + suffix) + "_" + getItemName(it))
        }
    }

    class Runner(
        output: PackOutput, provider: CompletableFuture<HolderLookup.Provider>
    ) : RecipeProvider.Runner(output, provider) {
        override fun createRecipeProvider(provider: HolderLookup.Provider, output: RecipeOutput) =
            ModRecipeProvider(provider, output)

        override fun getName() = "Aviros Recipes"
    }
}