package client;

import javax.jms.*;
import javax.naming.*;

public class FlightRequestProducer {

	
	//////////////
	
	
	
	private QueueConnection qConn;
	private QueueSession qSess;
	private Queue queue;
	
	private final String CONNECTION_FACTORY = "QueueConnectionFactory";
	private final String QUEUE_LOOKUP = "FlightRequest";
	
	private void setUp() {
		try {
			Context ctx = new InitialContext();
			QueueConnectionFactory queueFactory = (QueueConnectionFactory)
					ctx.lookup(this.CONNECTION_FACTORY);
			
			this.qConn = queueFactory.createQueueConnection();
			this.qSess = qConn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			this.queue = (Queue) ctx.lookup(this.QUEUE_LOOKUP);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void sendFightRequest (String text) throws JMSException {
		this.setUp();
		QueueSender sender = qSess.createSender(queue);
		TextMessage msg = qSess.createTextMessage();
		msg.setText(text);
		sender.send(msg);				
	}
	
	public void closeConnection() throws JMSException {
		qConn.stop();
		qSess.close();
		qConn.close();
	}
}
