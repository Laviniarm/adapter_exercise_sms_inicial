import api.*;
import api.factory.SMSFactoryOperadora;
import api.model.SMS;

import java.util.Scanner;

public class AppSMSNotification {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite o telefone de destino (Formato: DDD + Número): ");
		String numeroDestino = scanner.nextLine();

		System.out.print("Digite a mensagem: ");
		String texto = scanner.nextLine();

		System.out.print("Deseja traduzir a mensagem de Inglês para Português? (s/n): ");
		boolean traduzir = scanner.nextLine().equalsIgnoreCase("s");

		try {

			SMS sms = new SMS("83988885544", numeroDestino, texto);
			sms.setTranslate(traduzir);

			SMSSender sender = SMSFactoryOperadora.getRemetente(numeroDestino, traduzir);
			sender.sendSMS(sms);

		} catch (IllegalArgumentException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}


//		SMS message1 = new SMS("83988885544", "4183988221133", "Bom dia. Seu boleto já está disponível para pagamento.");
//		SMS message2 = new SMS("83988885544", "1583988221133", "Bom dia. Seu boleto já está disponível para pagamento / VIVO.");
//		SMS message3 = new SMS("83996488531", "1583988221133", "Good Morning!");
