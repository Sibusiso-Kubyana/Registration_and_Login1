error id: file:///C:/Users/sbuku/OneDrive%20-%20ADvTECH%20Ltd/Documents/School%20modules/PROG/1A/Registration_and_Login1/src/main/java/com/mycompany/registration_and_login1/Message.java:_empty_/Gson#
file:///C:/Users/sbuku/OneDrive%20-%20ADvTECH%20Ltd/Documents/School%20modules/PROG/1A/Registration_and_Login1/src/main/java/com/mycompany/registration_and_login1/Message.java
empty definition using pc, found symbol in pc: _empty_/Gson#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 3900
uri: file:///C:/Users/sbuku/OneDrive%20-%20ADvTECH%20Ltd/Documents/School%20modules/PROG/1A/Registration_and_Login1/src/main/java/com/mycompany/registration_and_login1/Message.java
text:
```scala
package com.mycompany.registration_and_login1;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Message {

    // =========================
    // ATTRIBUTES
    // =========================

    private String messageID;
    private static int messageCounter = 0;
    private int messageNumber;
    private String recipient;
    private String message;

    // =========================
    // CONSTRUCTOR
    // =========================

    public Message(String recipient, String message) {

        this.messageID = generateMessageID(); // 10-digit ID
        messageCounter++;
        this.messageNumber = messageCounter;

        this.recipient = recipient;
        this.message = message;
    }

    // =========================
    // GENERATE MESSAGE ID (10 DIGITS)
    // =========================

    private String generateMessageID() {

        Random rand = new Random();

        long id = 1000000000L + (long)(rand.nextDouble() * 8999999999L);

        return String.valueOf(id);
    }

    // =========================
    // REQUIREMENT: checkMessageID()
    // =========================

    public boolean checkMessageID() {

        return messageID != null && messageID.length() == 10;
    }

    // =========================
    // REQUIREMENT: checkRecipientCell()
    // =========================

    public String checkRecipientCell() {

        if (recipient.matches("^\\+[0-9]{1,3}[0-9]{1,10}$")
                && recipient.length() <= 10) {

            return "Cell phone number successfully captured.";

        } else {

            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    // =========================
    // MESSAGE VALIDATION (IMPORTANT FOR TESTS)
    // =========================

    public String checkMessageContent(String msg) {

        if (msg.length() <= 250) {

            return "Message ready to send.";

        } else {

            int excess = msg.length() - 250;

            return "Message exceeds 250 characters by " + excess + "; please reduce the size.";
        }
    }

    // =========================
    // REQUIREMENT: MESSAGE HASH
    // Format: 00:0:HITHANKS
    // =========================

    public String createMessageHash() {

        String[] words = message.trim().split(" ");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        String firstTwoDigits = messageID.substring(0, 2);

        return firstTwoDigits + ":" + messageNumber + ":" + firstWord + lastWord;
    }

    // =========================
    // SEND / DISCARD / STORE
    // =========================

    public String SentMessage(String option) {

        switch (option) {

            case "1":
                return "Message successfully sent.";

            case "2":
                return "Press 0 to delete the message.";

            case "3":
                storeMessage();
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    // =========================
    // PRINT MESSAGE DETAILS
    // =========================

    public String printMessages() {

        return "Message ID: " + messageID +
                "\nMessage Hash: " + createMessageHash() +
                "\nRecipient: " + recipient +
                "\nMessage: " + message;
    }

    // =========================
    // RETURN TOTAL MESSAGES
    // =========================

    public int returnTotalMessages() {

        return messageCounter;
    }

    // =========================
    // STORE MESSAGE TO JSON (GSON)
    // =========================

    public void storeMessage() {

        Gson gson = new Gs@@on();

        try (FileWriter writer = new FileWriter("messages.json", true)) {

            gson.toJson(this, writer);
            writer.write(System.lineSeparator());

            System.out.println("Message stored successfully.");

        } catch (IOException e) {

            System.out.println("Error storing message.");
        }
    }

  
    public String getMessageID() {
        return messageID;
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Gson#