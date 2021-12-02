package io.github.ytg1234.recipeconditions.api.condition;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.github.ytg1234.recipeconditions.RecipeCondsConstants;
import net.minecraft.util.collection.DefaultedList;

import io.github.ytg1234.recipeconditions.api.condition.base.ConditionCheckable;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * Represents a list of {@link SingleCondition}s, that all
 * of them have to match for this list to match.
 *
 * @author YTG1234
 */
public record EveryCondition(DefaultedList<SingleCondition> conditions) implements ConditionCheckable {
    /**
     * Parses a Json object to a list of {@link SingleCondition}s.
     *
     * @param object the object to be parsed
     *
     * @return the parsed representation
     */
    @Contract("_ -> new")
    public static @NotNull EveryCondition fromJson(@NotNull JsonObject object) {
        DefaultedList<SingleCondition> list = DefaultedList.of();
        for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
            list.add(SingleCondition.fromJson(entry));
        }
        return new EveryCondition(list);
    }

    /**
     * Checks if all the conditions in the list match.
     *
     * @return whether they match
     */
    public boolean check() {
        RecipeCondsConstants.LOGGER.debug("Checking an EveryCondition...");
        return conditions.stream().allMatch(SingleCondition::check);
    }
}
