package io.github.ytg1234.recipeconditions.impl.registry;

import java.util.HashMap;
import java.util.Map;

import io.github.ytg1234.recipeconditions.RecipeCondsConstants;
import io.github.ytg1234.recipeconditions.api.RecipeConds;
import io.github.ytg1234.recipeconditions.api.condition.base.RecipeCondition;
import io.github.ytg1234.recipeconditions.api.condition.util.RecipeCondsUtil;
import io.github.ytg1234.recipeconditions.impl.util.ImplUtils;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class RecipeConditions {
    public static final RecipeCondition MOD_LOADED = register("mod_loaded",
        modid -> FabricLoader.getInstance().isModLoaded(modid.string())
    );

    public static final RecipeCondition MOD_LOADED_ADVANCMED = register("mod_loaded_advanced",
                RecipeCondsUtil.objectParam(object -> ImplUtils.modVersionLoaded(
                    object.get("id").getAsString(),
                    object.get("version").getAsString())
                )
    );

    public static final Map<Registry<?>, RecipeCondition> REGISTRY_CONDITIONS = new HashMap<>();

    public static void initMod() {
        // Unfortunately, this might not work for modded registries
        // because it depends on mod load order.
        REGISTRY_CONDITIONS.put(Registry.REGISTRIES, register(Registry.REGISTRIES, "registered/registry"));
        Registry.REGISTRIES.forEach(it -> REGISTRY_CONDITIONS.putIfAbsent(it, register(it)));
        RecipeCondsConstants.LOGGER.info("Registered built-in conditions.");
    }

    private static RecipeCondition condForReg(Registry<?> registry) {
        return RecipeCondsUtil.stringParam(
            x -> registry.getIds().contains(new Identifier(x))
        );
    }

    private static RecipeCondition register(Registry<?> registry) {
        var regId = registry.getKey().getValue();

        RecipeCondsConstants.LOGGER.debug("Registering registry condition for registry %s, conditions name is %s".formatted(
            registry.getKey().getValue().toString(),
            new Identifier(RecipeCondsConstants.MOD_ID, "registered/" + regId.getNamespace() + "/" + regId.getPath())
        ));

        return register("registered/" + regId.getNamespace() + "/" + regId.getPath(), condForReg(registry));
    }

    private static RecipeCondition register(Registry<?> registry, String customId) {
        RecipeCondsConstants.LOGGER.debug("Registering registry condition for registry %s, conditions name is %s".formatted(
            registry.getKey().getValue().toString(),
            new Identifier(RecipeCondsConstants.MOD_ID, customId)
        ));

        return register(customId, condForReg(registry));
    }

    private static RecipeCondition register(String id, RecipeCondition cond) {
        RecipeCondsConstants.LOGGER.debug("Registering condition " + RecipeCondsConstants.MOD_ID + ":" + id);
        return Registry.register(RecipeConds.RECIPE_CONDITION, new Identifier(RecipeCondsConstants.MOD_ID, id), cond);
    }
}
