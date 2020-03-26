import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SmartStrategy implements OrderingStrategy {
    List<Order> orders = new ArrayList<>();

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if (bar.isHappyHour())
            bar.order(drink, recipe);
        else
            orders.add(new Order(drink, recipe, bar));
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        for (Iterator<Order> iter = orders.listIterator(); iter.hasNext(); ) {
            Order order = iter.next();
            if (order.getBar() == bar) {
                bar.order(order.getDrink(), order.getRecipe());
                iter.remove();
            }
        }
    }

    @Override
    public void happyHourEnded(StringBar bar) {

    }
}
