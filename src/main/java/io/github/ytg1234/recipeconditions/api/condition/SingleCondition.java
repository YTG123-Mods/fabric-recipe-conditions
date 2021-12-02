package io.github.ytg1234.recipeconditions.api.condition;

import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import io.github.ytg1234.recipeconditions.RecipeCondsConstants;
import io.github.ytg1234.recipeconditions.api.RecipeConds;
import io.github.ytg1234.recipeconditions.api.condition.base.RecipeCondition;
import io.github.ytg1234.recipeconditions.api.condition.base.RecipeConditionParameter;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Represents a Json entry that specifies a condition identifier
 * and either one parameter or an array of them.
 *
 * @author YTG1234
 */
public record SingleCondition(RecipeCondition condition, @Nullable RecipeConditionParameter param, @Nullable DefaultedList<RecipeConditionParameter> params, boolean negated) {
    public SingleCondition(@NotNull RecipeCondition condition, @NotNull RecipeConditionParameter param) {
        this(condition, param, false);
    }

    public SingleCondition(@NotNull RecipeCondition condition, @NotNull RecipeConditionParameter param, boolean negated) {
    	this(condition, param, null, negated);
    }

    public SingleCondition(
            @NotNull RecipeCondition condition,
            @NotNull DefaultedList<RecipeConditionParameter> params
    ) {
        this(condition, params, false);
    }

    public SingleCondition(
            @NotNull RecipeCondition condition,
            @NotNull DefaultedList<RecipeConditionParameter> params,
            boolean negated
    ) {
        this(condition, null, params, negated);
    }

    /**
     * Parses a Json entry to get the condition and value(s) from it.
     *
     * @param entry the Json entry to parse
     *
     * @return the new representation of the entry
     */
    @Contract("_ -> new")
    public static @NotNull SingleCondition fromJson(@NotNull Map.Entry<String, JsonElement> entry) {
        boolean negated = entry.getKey().startsWith("!");
        if (entry.getValue().isJsonArray()) {
            DefaultedList<RecipeConditionParameter> values = DefaultedList.of();
            for (JsonElement element : entry.getValue().getAsJsonArray()) {
                values.add(RecipeConditionParameter.createJsonElement(element));
            }
            Identifier conditionId = new Identifier(entry.getKey().replace("!", ""));
            RecipeCondition condition = RecipeConds.RECIPE_CONDITION.get(conditionId);
            if (condition == null) {
                throw new JsonParseException(new IllegalArgumentException("Unknown condition %s!".formatted(conditionId)));
            }
            return new SingleCondition(condition, values, negated);
        } else {
            JsonElement value = entry.getValue();
            Identifier conditionId = new Identifier(entry.getKey().replace("!", ""));
            RecipeCondition condition = RecipeConds.RECIPE_CONDITION.get(conditionId);
            if (condition == null) {
                throw new JsonParseException(new IllegalArgumentException("Unknown condition %s!".formatted(conditionId)));
            }
            return new SingleCondition(condition, RecipeConditionParameter.createJsonElement(value), negated);
        }
    }

    /**
     * A convenient way to check if the internal condition matched for all values.
     *
     * @return whether the condition matched
     */
    public boolean check() {
        RecipeCondsConstants.LOGGER.debug("Checking condition " + RecipeConds.RECIPE_CONDITION.getId(condition) + " , SingleCondition inverted: " + negated);
        if (param != null) {
            RecipeCondsConstants.LOGGER.debug("Param is not null, " + param.toString());
            return negated != condition.check(param);
        }
        if (params != null) {
            RecipeCondsConstants.LOGGER.debug("Params is not null, " + params.toString());
            return negated != params.stream().allMatch(condition::check);
        }
        throw new IllegalStateException("How did this happen? params and param are null!");
    }
}
