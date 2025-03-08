package api.decorator;

import api.SMSSender;
import api.model.SMS;

public class SMSDecorator implements SMSSender {
    protected SMSSender wrapper;

    public SMSDecorator(SMSSender wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public boolean sendSMS(SMS sms) {
        return wrapper.sendSMS(sms);
    }
}
