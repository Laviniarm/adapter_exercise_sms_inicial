package decorator;

import api.SMSSender;
import model.SMS;

public class SMSDecorator implements SMSSender {
    protected SMSSender wrapper;

    public SMSDecorator() {
        this.wrapper = wrapper;
    }

    @Override
    public boolean sendSMS(SMS sms) {
        return wrapper.sendSMS(sms);
    }
}
