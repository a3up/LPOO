public class Order {
    private StringDrink drink;
    private StringRecipe recipe;
    private StringBar bar;

    public Order(StringDrink drink, StringRecipe recipe, StringBar bar) {
        this.drink = drink;
        this.recipe = recipe;
        this.bar = bar;
    }

    public StringDrink getDrink() {
        return drink;
    }

    public void setDrink(StringDrink drink) {
        this.drink = drink;
    }

    public StringRecipe getRecipe() {
        return recipe;
    }

    public void setRecipe(StringRecipe recipe) {
        this.recipe = recipe;
    }

    public StringBar getBar() {
        return bar;
    }

    public void setBar(StringBar bar) {
        this.bar = bar;
    }
}
