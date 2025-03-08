package api.factory;

import api.decorator.TranslationDecorator;
import api.strategy.BrazilianValidator;
import api.strategy.Validator;
import api.SMSSender;
import api.TimService;
import api.adapter.VivoAdapter;

public class SMSFactoryOperadora {

    public static SMSSender getRemetente(String numeroDestino, boolean translate) {
        String csp = numeroDestino.substring(0, 2);
        Validator validator = new BrazilianValidator();

        if (!validator.isValid(numeroDestino)) {
            throw new IllegalArgumentException("Número de telefone inválido: " + numeroDestino);
        }

        SMSSender remetente = switch (csp) {
            case "41" -> TimService.getInstance();
            case "15" -> new VivoAdapter();
            default -> throw new IllegalArgumentException("Operadora desconhecida para o CSP: " + csp);
        };

        if (translate) {
            return new TranslationDecorator(remetente);
        }

        return remetente;
    }
}
