package api;

public class SMSFactoryOperadora {

    public static SMSSender getRemetente(String numeroDestino) {
        String csp = numeroDestino.substring(0, 2);

        return switch (csp) {
            case "41" -> new TimService();
            case "15" -> new VivoAdapter();
            default -> throw new IllegalArgumentException("Operadora desconhecida para o CSP: " + csp);
        };
    }
}
