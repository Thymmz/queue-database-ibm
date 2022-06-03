package com.walmart.queuedatabase.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.walmart.queuedatabase.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Service
public class ListenerService {

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "INPUT")
    public void listen(Message message) throws JMSException, JsonProcessingException {
        //Get text message from queue and map it to JPA Entity
        TextMessage textMessage = (TextMessage) message;
        String personString = textMessage.getText();
        ObjectMapper mapper = new ObjectMapper();
        People person = mapper.readValue(personString, People.class);

        //Save the JPA message entity to database
        peopleService.savePersontoDb(person);
    }
}
