package kws.ejb.mdb;

import org.jboss.ejb3.annotation.ResourceAdapter;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by IntelliJ IDEA. User: uchan Date: 6/13/11 Time: 5:49 PM To change
 * this template use File | Settings | File Templates.
 */
@MessageDriven(name = "myMqMDrivenBean", activationConfig = {
		@ActivationConfigProperty(propertyName = "messagingType", propertyValue = "javax.jms.MessageListener"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "myAppleQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "channel", propertyValue = "SYSTEM.DEF.SVRCONN"),
		@ActivationConfigProperty(propertyName = "useJNDI", propertyValue = "true") })
@ResourceAdapter(value = "wmq.jmsra.rar")
public class MqMDBean implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {

			if (message instanceof TextMessage) {
				TextMessage txtMsg = (TextMessage) message;
				System.out.println("Message Received ...");
				System.out.println(" >> " + txtMsg.getText());
			} else {
				System.out
						.println("Unknown message received. type of message is "
								+ message.getClass());
			}
		} catch (Exception e) {
			System.out
					.println("Exception occurred while processing the message");
		}

	}
}
