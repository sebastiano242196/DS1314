package client;

import javax.jms.*;
import javax.naming.*;
import java.io.Serializable;

public class JMSRequestProducer {	

	private QueueConnection qConn;
	private QueueSession qSess;
	private Queue queue;

	private final String connectionFactory;
	private final String queueLookUp;

	/**
	 * Creates a JMS producer, to send the flight request to the queue;
	 * Esatablish a connection with the queue and creates the session
	 * @param connectionFactory
	 * @param queueLookUp
	 */
	public JMSRequestProducer (String connectionFactory, String queueLookUp) {
		this.connectionFactory = connectionFactory;
		this.queueLookUp = queueLookUp;		

		try {
			Context ctx = new InitialContext();
			QueueConnectionFactory queueFactory = (QueueConnectionFactory)
					ctx.lookup(this.connectionFactory);

			this.qConn = queueFactory.createQueueConnection();
			this.qSess = qConn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			this.queue = (Queue) ctx.lookup(this.queueLookUp);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/**
	 * Sends to the connected queue a Flight request, as a String
	 * @param text
	 * @throws JMSException
	 */
	public void sendFlightRequest (String text) throws JMSException {
		QueueSender sender = qSess.createSender(queue);
		TextMessage msg = qSess.createTextMessage();
		msg.setText(text);
		sender.send(msg);				
	}

	/**
	 * Sends to the connected queue a Flight request as a serialized object
	 * @param flight
	 * @throws JMSException
	 */
	public void sendFlightRequest (Object flight) throws JMSException {
		QueueSender sender = qSess.createSender(queue);
		ObjectMessage msg = qSess.createObjectMessage();		
		
		msg.setObject((Serializable) flight);
		sender.send(msg);
	}
	
	/**
	 * Terminates the session and closes the connection with the queue
	 * @throws JMSException
	 */
	public void closeConnection() throws JMSException {
		qConn.stop();
		qSess.close();
		qConn.close();
	}
}
