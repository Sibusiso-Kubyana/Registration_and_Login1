error id: file:///C:/Users/sbuku/OneDrive%20-%20ADvTECH%20Ltd/Documents/School%20modules/PROG/1A/Registration_and_Login1/src/main/java/com/mycompany/registration_and_login1/Message.java
file:///C:/Users/sbuku/OneDrive%20-%20ADvTECH%20Ltd/Documents/School%20modules/PROG/1A/Registration_and_Login1/src/main/java/com/mycompany/registration_and_login1/Message.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[85,2]

error in qdox parser
file content:
```java
offset: 3211
uri: file:///C:/Users/sbuku/OneDrive%20-%20ADvTECH%20Ltd/Documents/School%20modules/PROG/1A/Registration_and_Login1/src/main/java/com/mycompany/registration_and_login1/Message.java
text:
```scala
package com.mycompany.registration_and_login1;

import java.util.ArrayList;
import java.util.Random; // Import Random class
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

public class Message {
    private String messageID;
    private String recipient;
    private String messageContent;
    private static int totalMessages = 0;
    private static ArrayList<String> messageList = new ArrayList<>();

    // Updated Constructor: No longer requires messageID as a parameter
    public Message(String recipient, String messageContent) {
        this.messageID = generateRandomID(); // Auto-generate the ID
        this.recipient = recipient;
        this.messageContent = messageContent;
        totalMessages++;
        messageList.add(messageContent);
    }

    // New method to generate a 10-digit random number
    private String generateRandomID() {
        Random rand = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            id.append(rand.nextInt(10)); // Appends a random digit 0-9
        }
        return id.toString();
    }

   // Ensures cell number is <= 10 characters and starts with a code
    public String checkRecipientCell(String cellnumber) {
        String regex = "^\\+[0-9]{1,3}[0-9]{1,15}$";
        if (cellnumber.length() <= 10 && cellnumber.matches(regex)) {
            return "Cell phone number successfully captured.";
        }
        return "Cell phone number is incorrectly formatted or does not contain an international code.";
    }

    // Creates and returns the Message Hash
    public String createMessageHash() {
    String idPart = messageID.substring(0, 2);
    String[] words = messageContent.trim().split("\\s+");
    String firstWord = words[0];
    String lastWord = (words.length > 1) ? words[words.length - 1] : words[0];
    
    // Ensure the index matches the requirement: (totalMessages - 1)
    // For your test to be "00:0:HITONIGHT", the index must be 0
    return (idPart + ":" + (totalMessages - 1) + ":" + firstWord + lastWord).toUpperCase();
}

    // Allows user to choose to send, store, or disregard
    public String SentMessage(String choice) {
        switch (choice) {
            case "1": return "Message sent";
            case "3": storeMessage(); return "Message successfully stored";
            default: return "Press 0 to delete the message";
        }
    }

    // Returns all messages sent while program is running
    public String printMessages() {
        return messageList.toString();
    }

    // Returns the total number of messages sent
    public int returnTotalMessagess() {
        return totalMessages;
    }
public void storeMessage() {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    try (FileWriter writer = new FileWriter("messages.json")) {
        // Converts the messageList to a JSON string and writes it to the file
        gson.toJson(messageList, writer);
        System.out.println("Messages successfully stored in JSON format.");
    } catch (IOException e) {
        System.out.println("Error storing messages to JSON: " + e.getMessage());
    }
}@@
```

```



#### Error stacktrace:

```
com.thoughtworks.qdox.parser.impl.Parser.yyerror(Parser.java:2025)
	com.thoughtworks.qdox.parser.impl.Parser.yyparse(Parser.java:2147)
	com.thoughtworks.qdox.parser.impl.Parser.parse(Parser.java:2006)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:232)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:190)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:94)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:89)
	com.thoughtworks.qdox.library.SortedClassLibraryBuilder.addSource(SortedClassLibraryBuilder.java:162)
	com.thoughtworks.qdox.JavaProjectBuilder.addSource(JavaProjectBuilder.java:174)
	scala.meta.internal.mtags.JavaMtags.indexRoot(JavaMtags.scala:49)
	scala.meta.internal.metals.SemanticdbDefinition$.foreachWithReturnMtags(SemanticdbDefinition.scala:99)
	scala.meta.internal.metals.Indexer.indexSourceFile(Indexer.scala:560)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3(Indexer.scala:691)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3$adapted(Indexer.scala:688)
	scala.collection.IterableOnceOps.foreach(IterableOnce.scala:630)
	scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:628)
	scala.collection.AbstractIterator.foreach(Iterator.scala:1313)
	scala.meta.internal.metals.Indexer.reindexWorkspaceSources(Indexer.scala:688)
	scala.meta.internal.metals.MetalsLspService.$anonfun$onChange$2(MetalsLspService.scala:940)
	scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.scala:18)
	scala.concurrent.Future$.$anonfun$apply$1(Future.scala:691)
	scala.concurrent.impl.Promise$Transformation.run(Promise.scala:500)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1090)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:614)
	java.base/java.lang.Thread.run(Thread.java:1474)
```
#### Short summary: 

QDox parse error in file:///C:/Users/sbuku/OneDrive%20-%20ADvTECH%20Ltd/Documents/School%20modules/PROG/1A/Registration_and_Login1/src/main/java/com/mycompany/registration_and_login1/Message.java