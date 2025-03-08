package api.strategy;

public class BrazilianValidator implements Validator {
    @Override
    public boolean isValid(String number) {
        return number.matches("^\\d{2}\\d{2}9\\d{4}\\d{4}$");
    }
}
