package com.walmart.queuedatabase.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.jms.JMSObjectMessage;
import com.walmart.queuedatabase.model.People;
import com.walmart.queuedatabase.model.PeopleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import java.io.*;

@Service
public class ListenerService {

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "INPUT")
    public void listen(Message message) throws JMSException, JsonProcessingException {
        TextMessage textMessage = (TextMessage) message;
        String personString = textMessage.getText();
        ObjectMapper mapper = new ObjectMapper();
        People person = mapper.readValue(personString, People.class);

        System.out.println(person);
    }

    public Object cloneObject(Object originalObject) {
        Object clonedObject = null;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(originalObject);
            //retrieve back
            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            clonedObject = objectInputStream.readObject();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }

        return clonedObject;
    }
}
