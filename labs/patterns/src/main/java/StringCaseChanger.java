public class StringCaseChanger implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        StringBuilder result = new StringBuilder();
        for (char c : drink.getText().toCharArray()) {
            c = Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c);
            result.append(c);
        }
        drink.setText(result.toString());
    }
}
