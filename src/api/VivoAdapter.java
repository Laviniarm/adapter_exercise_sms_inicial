package api;

import model.SMS;

import java.util.ArrayList;
import java.util.List;

public class VivoAdapter implements SMSSender {
    private VivoService service;

    public VivoAdapter() {
        this.service = new VivoService();
    }

    @Override
    public boolean sendSMS(SMS sms) {
        try {
            List<String> partes = new ArrayList<>();
            int inicio = 0;

            while (inicio < sms.getTexto().length()) {
                int fim = Math.min(inicio + 120, sms.getTexto().length());
                partes.add(sms.getTexto().substring(inicio, fim));
                inicio = fim;
            }

            String[] mensagens = partes.toArray(new String[0]);

            service.enviarSMS(sms.getOrigem(), sms.getDestino(), sms.getTimestamp(), mensagens);

            return true;

        } catch (SMSException e) {
            System.out.println("Erro ao enviar SMS pela Vivo: " + e.getMessage());
            return false;
        }
    }

}
