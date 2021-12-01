package io.github.ytg1234.recipeconditions.impl.registry;

import io.github.ytg1234.recipeconditions.RecipeCondsConstants;
import io.github.ytg1234.recipeconditions.api.RecipeConds;
import io.github.ytg1234.recipeconditions.api.condition.base.RecipeCondition;
import io.github.ytg1234.recipeconditions.api.condition.util.RecipeCondsUtil;
import io.github.ytg1234.recipeconditions.impl.util.ImplUtils;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class RecipeConditions {
    public static final RecipeCondition
            MOD_LOADED =
            register("mod_loaded", modid -> FabricLoader.getInstance().isModLoaded(modid.string()));
    public static final RecipeCondition
            MOD_LOADED_ADVANCMED =
            register("mod_loaded_advanced",
                RecipeCondsUtil.objectParam(object -> ImplUtils.modVersionLoaded(
                    object.get("id").getAsString(),
                    object.get("version").getAsString())
                )
            );

    // region Registry Conditions
    public static final RecipeCondition GAME_EVENT_REGISTERED = register("game_event", Registry.GAME_EVENT);
    public static final RecipeCondition SOUND_EVENT_REGISTERED = register("sound_event", Registry.SOUND_EVENT);
    public static final RecipeCondition FLUID_REGISTERED = register("fluid", Registry.FLUID);
    public static final RecipeCondition STATUS_EFFECT_REGISTERED = register("status_effect", Registry.STATUS_EFFECT);
    public static final RecipeCondition BLOCK_REGISTERED = register("block", Registry.BLOCK);
    public static final RecipeCondition ENCHANTMENT_REGISTERED = register("enchantment", Registry.ENCHANTMENT);
    public static final RecipeCondition ENTITY_TYPE_REGISTERED = register("entity_type", Registry.ENTITY_TYPE);
    public static final RecipeCondition ITEM_REGISTERED = register("item", Registry.ITEM);
    public static final RecipeCondition POTION_REGISTERED = register("potion", Registry.POTION);
    public static final RecipeCondition PARTICLE_TYPE_REGISTERED = register("particle_type", Registry.PARTICLE_TYPE);
    public static final RecipeCondition BLOCK_ENTITY_TYPE_REGISTERED = register("block_entity_type", Registry.BLOCK_ENTITY_TYPE);
    public static final RecipeCondition PAINTING_MOTIVE_REGISTERED = register("painting_motive", Registry.PAINTING_MOTIVE);
    public static final RecipeCondition CUSTOM_STAT_REGISTERED = register("custom_stat", Registry.CUSTOM_STAT);
    public static final RecipeCondition CHUNK_STATUS_REGISTERED = register("chunk_status", Registry.CHUNK_STATUS);
    public static final RecipeCondition RULE_TEST_REGISTERED = register("rule_test", Registry.RULE_TEST);
    public static final RecipeCondition POS_RULE_TEST_REGISTERED = register("pos_rule_test", Registry.POS_RULE_TEST);
    public static final RecipeCondition SCREEN_HANDLER_REGISTERED = register("screen_handler", Registry.SCREEN_HANDLER);
    public static final RecipeCondition RECIPE_TYPE_REGISTERED = register("recipe_type", Registry.RECIPE_TYPE);
    public static final RecipeCondition RECIPE_SERIALIZER_REGISTERED = register("recipe_serializer", Registry.RECIPE_SERIALIZER);
    public static final RecipeCondition ATTRIBUTE_REGISTERED = register("attribute", Registry.ATTRIBUTE);
    public static final RecipeCondition POSITION_SOURCE_TYPE_REGISTERED = register("position_source_type", Registry.POSITION_SOURCE_TYPE);
    public static final RecipeCondition STAT_TYPE_REGISTERED = register("stat_type", Registry.STAT_TYPE);
    public static final RecipeCondition VILLAGER_TYPE_REGISTERED = register("villager_type", Registry.VILLAGER_TYPE);
    public static final RecipeCondition VILLAGER_PROFESSION_REGISTERED = register("villager_profession", Registry.VILLAGER_PROFESSION);
    public static final RecipeCondition POINT_OF_INTEREST_TYPE_REGISTERED = register("point_of_interest_type", Registry.POINT_OF_INTEREST_TYPE);
    public static final RecipeCondition MEMORY_MODULE_TYPE_REGISTERED = register("memory_module_type", Registry.MEMORY_MODULE_TYPE);
    public static final RecipeCondition SENSOR_TYPE_REGISTERED = register("sensor_type", Registry.SENSOR_TYPE);
    public static final RecipeCondition SCHEDULE_REGISTERED = register("schedule", Registry.SCHEDULE);
    public static final RecipeCondition ACTIVITY_REGISTERED = register("activity", Registry.ACTIVITY);
    public static final RecipeCondition LOOT_POOL_ENTRY_TYPE_REGISTERED = register("loot_pool_entry_type", Registry.LOOT_POOL_ENTRY_TYPE);
    public static final RecipeCondition LOOT_FUNCTION_TYPE_REGISTERED = register("loot_function_type", Registry.LOOT_FUNCTION_TYPE);
    public static final RecipeCondition LOOT_CONDITION_TYPE_REGISTERED = register("loot_condition_type", Registry.LOOT_CONDITION_TYPE);
    public static final RecipeCondition LOOT_NUMBER_PROVIDER_TYPE_REGISTERED = register("loot_number_provider_type", Registry.LOOT_NUMBER_PROVIDER_TYPE);
    public static final RecipeCondition LOOT_NBT_PROVIDER_TYPE_REGISTERED = register("loot_nbt_provider_type", Registry.LOOT_NBT_PROVIDER_TYPE);
    public static final RecipeCondition LOOT_SCORE_PROVIDER_TYPE_REGISTERED = register("loot_score_provider_type", Registry.LOOT_SCORE_PROVIDER_TYPE);
    public static final RecipeCondition FLOAT_PROVIDER_TYPE_REGISTERED = register("float_provider_type", Registry.FLOAT_PROVIDER_TYPE);
    public static final RecipeCondition INT_PROVIDER_TYPE_REGISTERED = register("int_provider_type", Registry.INT_PROVIDER_TYPE);
    public static final RecipeCondition HEIGHT_PROVIDER_TYPE_REGISTERED = register("height_provider_type", Registry.HEIGHT_PROVIDER_TYPE);
    public static final RecipeCondition BLOCK_PREDICATE_TYPE_REGISTERED = register("block_predicate_type", Registry.BLOCK_PREDICATE_TYPE);
    public static final RecipeCondition CARVER_REGISTERED = register("carver", Registry.CARVER);
    public static final RecipeCondition FEATURE_REGISTERED = register("feature", Registry.FEATURE);
    public static final RecipeCondition STRUCTURE_FEATURE_REGISTERED = register("structure_feature", Registry.STRUCTURE_FEATURE);
    public static final RecipeCondition STRUCTURE_PIECE_REGISTERED = register("structure_piece", Registry.STRUCTURE_PIECE);
    public static final RecipeCondition PLACEMENT_MODIFIER_TYPE_REGISTERED = register("placement_modifier_type", Registry.PLACEMENT_MODIFIER_TYPE);
    public static final RecipeCondition BLOCK_STATE_PROVIDER_TYPE_REGISTERED = register("block_state_provider_type", Registry.BLOCK_STATE_PROVIDER_TYPE);
    public static final RecipeCondition FOLIAGE_PLACER_TYPE_REGISTERED = register("foliage_placer_type", Registry.FOLIAGE_PLACER_TYPE);
    public static final RecipeCondition TRUNK_PLACER_TYPE_REGISTERED = register("trunk_placer_type", Registry.TRUNK_PLACER_TYPE);
    public static final RecipeCondition TREE_DECORATOR_TYPE_REGISTERED = register("tree_decorator_type", Registry.TREE_DECORATOR_TYPE);
    public static final RecipeCondition FEATURE_SIZE_TYPE_REGISTERED = register("feature_size_type", Registry.FEATURE_SIZE_TYPE);
    public static final RecipeCondition BIOME_SOURCE_REGISTERED = register("biome_source", Registry.BIOME_SOURCE);
    public static final RecipeCondition CHUNK_GENERATOR_REGISTERED = register("chunk_generator", Registry.CHUNK_GENERATOR);
    public static final RecipeCondition MATERIAL_CONDITION_REGISTERED = register("material_condition", Registry.MATERIAL_CONDITION);
    public static final RecipeCondition MATERIAL_RULE_REGISTERED = register("material_rule", Registry.MATERIAL_RULE);
    public static final RecipeCondition STRUCTURE_PROCESSOR_REGISTERED = register("structure_processor", Registry.STRUCTURE_PROCESSOR);
    public static final RecipeCondition STRUCTURE_POOL_ELEMENT_REGISTERED = register("structure_pool_element", Registry.STRUCTURE_POOL_ELEMENT);
    public static final RecipeCondition REGISTRY_REGISTERED = register("registry", Registry.REGISTRIES);
    // endregion

    static {
        RecipeCondsConstants.LOGGER.trace("Static Initializer of " +
                                          RecipeConditions.class.getName() +
                                          " has been called.");
    }

    public static void initMod() {
        RecipeCondsConstants.LOGGER.info("Registered built-in conditions."); // Static initializer runs before any static method.
    }

    private static RecipeCondition register(String id, Registry<?> registry) {
        RecipeCondsConstants.LOGGER.debug("Registering registry condition for registry " +
                                          registry.getKey().getValue().toString());
        return register(id + "_registered",
            RecipeCondsUtil.stringParam(
                x -> registry.getIds().contains(new Identifier(x))
            )
        );
    }

    private static RecipeCondition register(String id, RecipeCondition cond) {
        RecipeCondsConstants.LOGGER.debug("Registring condition " + RecipeCondsConstants.MOD_ID + ":" + id);
        return Registry.register(RecipeConds.RECIPE_CONDITION, new Identifier(RecipeCondsConstants.MOD_ID, id), cond);
    }
}
