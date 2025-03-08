import api.*;
import api.factory.SMSFactoryOperadora;
import model.SMS;

public class AppSMSNotification {
	public static void main(String[] args) {

		SMS message1 = new SMS("83988885544", "41888221133", "Bom dia. Seu boleto já está disponível para pagamento.");
		SMS message2 = new SMS("83988885544", "15888221133", "Bom dia. Seu boleto já está disponível para pagamento / VIVO.");

		enviarSMS(message1);
		enviarSMS(message2);
	}

	private static void enviarSMS(SMS sms) {
		try {

			SMSSender sender = SMSFactoryOperadora.getRemetente(sms.getDestino());

			boolean sucesso = sender.sendSMS(sms);
			System.out.println(sucesso ? "SMS enviado com sucesso!" : "Falha no envio do SMS.");

		} catch (IllegalArgumentException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
