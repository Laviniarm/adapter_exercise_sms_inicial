package api.decorator;

import api.SMSSender;
import api.model.SMS;

public class TranslationDecorator extends SMSDecorator {
    public TranslationDecorator(SMSSender wrapper) {
        super(wrapper);
    }

    @Override
    public boolean sendSMS(SMS sms) {
        if (sms.getTranslate()) {
            try {
                String translatedText = translate(sms.getTexto(), "en", "pt");
                sms.setTexto(translatedText);
            } catch (Exception e) {
                throw new RuntimeException("Erro ao traduzir a mensagem.", e);
            }
        }
        return super.sendSMS(sms);
    }

    public String translate(String text, String from, String to) throws Exception {
        return Translator.translate(from, to, text);
    }
}
