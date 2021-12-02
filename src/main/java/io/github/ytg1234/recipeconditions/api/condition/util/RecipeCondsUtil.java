package io.github.ytg1234.recipeconditions.api.condition.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.github.ytg1234.recipeconditions.api.condition.base.RecipeCondition;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

/**
 * Various public utilities.
 *
 * @author YTG1234
 * @since 0.3.0
 */
public final class RecipeCondsUtil {
    /**
     * <p>
     * Generates and returns a {@link RecipeCondition}
     * that automatically converts its param to a {@link String}.
     * </p>
     * <p>
     * Useful for when you want to do things like
     * <code>
     * RecipeCondsUtil.stringParam(modid -> FabricLoader.getInstance().isModLoaded(modid));
     * </code>
     * </p>
     *
     * @param cond a predicate processing a String
     *
     * @return the generated {@link RecipeCondition} instance
     */
    @Contract(pure = true)
    public static @NotNull RecipeCondition stringParam(@NotNull Predicate<String> cond) {
        return param -> cond.test(param.string());
    }

    /**
     * Generates and returns a {@link RecipeCondition}
     * that automatically converts its param to a {@link Boolean boolean}.
     *
     * @param cond a predicate processing the aforementioned {@code boolean}
     *
     * @return the generated condition
     */
    @Contract(pure = true)
    public static @NotNull RecipeCondition boolParam(@NotNull Predicate<Boolean> cond) {
        return param -> cond.test(param.bool());
    }

    /**
     * Generates and returns a {@link RecipeCondition}
     * that automatically converts its param to an {@link Integer int}.
     *
     * @param cond a predicate processing the converted {@code int}
     *
     * @return the generated  condition
     */
    @Contract(pure = true)
    public static @NotNull RecipeCondition intParam(@NotNull Predicate<Integer> cond) {
        return param -> cond.test(param.integer());
    }

    /**
     * Generates and returns a {@link RecipeCondition}
     * that automatically converts its param to a {@link Float float}.
     *
     * @param cond a predicate processing the {@code float}
     *
     * @return the generated condition
     */
    @Contract(pure = true)
    public static @NotNull RecipeCondition floatParam(@NotNull Predicate<Float> cond) {
        return param -> cond.test(param.floatingPoint());
    }

    /**
     * Generates and returns a {@link RecipeCondition}
     * that automatically converts its param to a {@link JsonArray}.
     *
     * @param cond a predicate processing the array
     *
     * @return the generated condition
     */
    @Contract(pure = true)
    public static @NotNull RecipeCondition arrayParam(@NotNull Predicate<JsonArray> cond) {
        return param -> cond.test(param.array());
    }

    /**
     * Generates and returns a {@link RecipeCondition}
     * that automatically converts its param to a {@link JsonObject}.
     *
     * @param cond a predicate for processing the object
     *
     * @return the generated condition
     */
    @Contract(pure = true)
    public static @NotNull RecipeCondition objectParam(@NotNull Predicate<JsonObject> cond) {
        return param -> cond.test(param.object());
    }
}
