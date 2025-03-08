package api;

import api.model.SMS;

public interface SMSSender {

	public boolean sendSMS( SMS sms);
}
