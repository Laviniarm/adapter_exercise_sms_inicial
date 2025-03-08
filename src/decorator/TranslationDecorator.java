package decorator;

import api.SMSSender;
import api.model.SMS;
import api.decorator.Translator;

public class TranslationDecorator extends SMSDecorator {
    public TranslationDecorator(SMSSender wrapper) {
        super(wrapper);
    }

    @Override
    public boolean sendSMS(SMS sms) {
        if (sms.isTranslate()) {
            try {
                String translatedText = Translator.translate(sms.getTexto(), "pt", "en");
                sms.setTexto(translatedText);
            } catch (Exception e) {
                throw new RuntimeException("Erro ao traduzir a mensagem.", e);
            }
        }
        return super.sendSMS(sms);
    }
}
