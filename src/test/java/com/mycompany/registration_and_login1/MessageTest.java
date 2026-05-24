package com.mycompany.registration_and_login1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MessageTest {

  
    // TEST 1: Message length VALID
  
    @Test
    public void testMessageLengthValid() {

        Message msg = new Message("+27123456789", "Hello Mike");

        String result = msg.checkMessageContent("Hello Mike");

        assertEquals("Message ready to send.", result);
    }

   
    // TEST 2: Message length INVALID
   
    @Test
    public void testMessageLengthInvalid() {

        Message msg = new Message("+27123456789", "x".repeat(260));

        String result = msg.checkMessageContent("x".repeat(260));

        assertEquals(
                "Message exceeds 250 characters by 10; please reduce the size.",
                result
        );
    }

   
    // TEST 3: Recipient VALID
  
    @Test
    public void testRecipientValid() {

        Message msg = new Message("+27123456789", "Hello");

        String result = msg.checkRecipientCell();

        assertEquals(
                "Cell phone number successfully captured.",
                result
        );
    }

  
    // TEST 4: Recipient INVALID
  
    @Test
    public void testRecipientInvalid() {

        Message msg = new Message("08575975889", "Hello");

        String result = msg.checkRecipientCell();

        assertEquals(
                "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
                result
        );
    }


    // TEST 5: MESSAGE ID GENERATION
   
    @Test
    public void testMessageIDGeneration() {

        Message msg = new Message("+27123456789", "Hello");

        String id = msg.getMessageID();

        assertEquals(10, id.length());

        assertTrue(id.matches("[0-9]{10}"));
    }

  
    // TEST 6: MESSAGE HASH FORMAT
    
    @Test
    public void testMessageHashFormat() {

        Message msg = new Message("+27123456789", "Hi John");

        String hash = msg.createMessageHash();

        assertTrue(hash.contains(":"));

        String[] parts = hash.split(":");

        assertEquals(3, parts.length);
    }

   
    // TEST 7: SEND MESSAGE OPTION
    
    @Test
    public void testSendMessage() {

        Message msg = new Message("+27123456789", "Hello");

        String result = msg.SentMessage("1");

        assertEquals("Message successfully sent.", result);
    }

    
    // TEST 8: DISREGARD MESSAGE
    
    @Test
    public void testDisregardMessage() {

        Message msg = new Message("+27123456789", "Hello");

        String result = msg.SentMessage("2");

        assertEquals("Press 0 to delete the message.", result);
    }

   
    // TEST 9: STORE MESSAGE
    
    @Test
    public void testStoreMessage() {

        Message msg = new Message("+27123456789", "Hello");

        String result = msg.SentMessage("3");

        assertEquals("Message successfully stored.", result);
    }

  
    // TEST 10: TOTAL MESSAGES COUNTER
  
    @Test
    public void testTotalMessages() {

        int before = new Message("+27123456789", "A").returnTotalMessages();

        new Message("+27123456789", "B");

        int after = new Message("+27123456789", "C").returnTotalMessages();

        assertTrue(after >= before);
    }
}