import api.SMSSender;
import api.TimService;
import api.VivoAdapter;
import api.VivoService;
import model.SMS;

public class AppSMSNotification {

	public static void main(String[] args)  {
		SMSSender sender = new TimService();
		
		SMS message = new SMS("83988885544","83988221133","Bom dia. Seu boleto ja esta disponivel para pagamento");
		
		sender.sendSMS(message);	

		SMSSender sender2 = new VivoAdapter();

		SMS message2 = new SMS("83988885544","83988221133","Bom dia. Seu boleto ja esta disponivel para pagamento/ vivo");

		sender2.sendSMS(message2);
	}
}
