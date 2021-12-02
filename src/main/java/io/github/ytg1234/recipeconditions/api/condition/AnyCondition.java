package io.github.ytg1234.recipeconditions.api.condition;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import io.github.ytg1234.recipeconditions.RecipeCondsConstants;
import net.minecraft.util.collection.DefaultedList;

import io.github.ytg1234.recipeconditions.api.condition.base.ConditionCheckable;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an array of {@link EveryCondition}s - The highest level
 * of condition representation.
 *
 * @author YTG1234
 */
public record AnyCondition(DefaultedList<EveryCondition> conditions) implements ConditionCheckable {
    /**
     * Parses a Json array into a simple list of {@link EveryCondition}s.
     *
     * @param array the array to be parsed
     *
     * @return the parsed form of the array
     */
    @Contract("_ -> new")
    public static @NotNull AnyCondition fromJson(@NotNull JsonArray array) {
        DefaultedList<EveryCondition> list = DefaultedList.of();
        for (JsonElement element : array) {
            if (!(element instanceof JsonObject)) throw new JsonParseException("Conditions must be objects!");
            list.add(EveryCondition.fromJson((JsonObject) element));
        }
        return new AnyCondition(list);
    }

    /**
     * Checks if the array matches - if any of its elements match.
     *
     * @return whether the array matches
     */
    public boolean check() {
        RecipeCondsConstants.LOGGER.debug("Checking an AnyCondition...");
        return conditions.stream().anyMatch(EveryCondition::check);
    }
}
