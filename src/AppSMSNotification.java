import api.*;
import api.factory.SMSFactoryOperadora;
import api.model.SMS;

public class AppSMSNotification {
	public static void main(String[] args) {

		SMS message1 = new SMS("83988885544", "4183988221133", "Bom dia. Seu boleto já está disponível para pagamento.");
		SMS message2 = new SMS("83988885544", "1583988221133", "Bom dia. Seu boleto já está disponível para pagamento / VIVO.");
		SMS message3 = new SMS("83996488531", "1583988221133", "Good Morning!");

		message3.setTranslate(true);

		enviarSMS(message1);
		enviarSMS(message2);
		enviarSMS(message3);
	}

	private static void enviarSMS(SMS sms) {
		try {;

			SMSSender sender = SMSFactoryOperadora.getRemetente(sms.getDestino(), sms.getTranslate());

			boolean sucesso = sender.sendSMS(sms);
			System.out.println(sucesso ? "SMS enviado com sucesso!" : "Falha no envio do SMS.");

		} catch (IllegalArgumentException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
