package io.github.ytg1234.recipeconditions.api.condition.base;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * This class represents a parameter that can be fed into a {@link RecipeCondition}
 * to later match.
 * <p>
 * It contains some helper methods as well.
 * </p>
 *
 * @author YTG1234
 */
public final class RecipeConditionParameter {
    @NotNull
    private final JsonElement value;

    public RecipeConditionParameter(@NotNull JsonElement json) {
        this.value = json;
    }

    /**
     * A utility method, shortcut, to create a new
     * instance using a {@link JsonPrimitive}.
     *
     * @param string string that is the param
     *
     * @return new parameter instance
     */
    @Contract("_ -> new")
    public static @NotNull RecipeConditionParameter createString(@NotNull String string) {
        return createJsonElement(new JsonPrimitive(string));
    }

    /**
     * I don't know why I made this, it's actually <em>longer</em> than
     * calling the constructor, but I made it anyway.
     *
     * @param json the param's internal value
     *
     * @return new parameter instance
     */
    @Contract(value = "_ -> new", pure = true)
    public static @NotNull RecipeConditionParameter createJsonElement(@NotNull JsonElement json) {
        return new RecipeConditionParameter(json);
    }

    /**
     * A utility method, shortcut, to create a new
     * instance using a {@link JsonPrimitive}.
     *
     * @param i integer that is the param
     *
     * @return new parameter instance.
     */
    @Contract("_ -> new")
    public static @NotNull RecipeConditionParameter createInt(int i) {
        return createJsonElement(new JsonPrimitive(i));
    }

    @NotNull
    public JsonElement getValue() {
        return value;
    }

    // region I'd use extension functions if this was Kotlin
    public @NotNull String string() {
        return value.getAsString();
    }

    public int integer() {
        return value.getAsInt();
    }

    public double doublePersicion() {
        return value.getAsDouble();
    }

    public float floatingPoint() {
        return value.getAsFloat();
    }

    public @NotNull JsonObject object() {
        return value.getAsJsonObject();
    }

    public boolean bool() {
        return value.getAsBoolean();
    }

    public @NotNull JsonArray array() {
        return value.getAsJsonArray();
    }
    // endregion

    @Override
    public String toString() {
        return value.toString();
    }
}
