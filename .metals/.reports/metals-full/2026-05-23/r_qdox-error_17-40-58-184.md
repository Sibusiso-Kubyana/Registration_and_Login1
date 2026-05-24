error id: file:///C:/Users/sbuku/OneDrive%20-%20ADvTECH%20Ltd/Documents/School%20modules/PROG/1A/Registration_and_Login1/src/main/java/com/mycompany/registration_and_login1/Registration_and_Login1.java
file:///C:/Users/sbuku/OneDrive%20-%20ADvTECH%20Ltd/Documents/School%20modules/PROG/1A/Registration_and_Login1/src/main/java/com/mycompany/registration_and_login1/Registration_and_Login1.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[192,6]

error in qdox parser
file content:
```java
offset: 6624
uri: file:///C:/Users/sbuku/OneDrive%20-%20ADvTECH%20Ltd/Documents/School%20modules/PROG/1A/Registration_and_Login1/src/main/java/com/mycompany/registration_and_login1/Registration_and_Login1.java
text:
```scala
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registration_and_login1;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Registration_and_Login1 {
   
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        Login login = new Login();

        //Declaring variables for global use
        String username = "";
        String password = "";
        String cellnumber = "";
        
        
        
      boolean isLoggedIn = false;
    while (true) {
        System.out.println("Enter username to login:");
        String login_user = scan.nextLine();
        System.out.println("Enter password to login:");
        String login_pass = scan.nextLine();

        if (login.loginUser(login_user, username, login_pass, password)) {
            System.out.println(login.returnLoginStatus(login_user, username, login_pass, password));
            isLoggedIn = true;
            break; 
        } else {
            System.out.println("Username or password incorrect please try again");
        }
    }     
        
while (true) { //Loop until conditions for password are met
System.out.println("Enter your new password");
password = scan.nextLine();

String regex_password = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[\\W_]).{8,}$"; // Declaring and assigning regex

if (password.length() >=8 && password.matches(regex_password)) {
     /** ^,it means the beginning of the string
         (?=.*[A-Z], it scans for at least one uppercase
         (?=.*[0-9]), it scans for at least one number
         (?=.*[\\W_]), it scans for at least one special character
          {8,} , it means at least 8 characters long
         +$, means end of the string, containing one or more previous groups */ 
     System.out.println("Password successfully captured");
break;} //break loop
   else {
System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character");
}  
}

while(true) { //Loop until it meets the required conditions for cellphone
  System.out.println("Enter your cell phone number");
cellnumber= scan.nextLine();

String regex = "^\\+[0-9]{1,3}[0-9]{1,15}$"; //Declaring and assigning regex


if (cellnumber.matches(regex)) {
    /** Regex explanation :
^\+ means the cell number will start with a +
[0-9] country code, {1,3} only 1 to 3 digits allowed
[0-9] number parts, {1,15} only 1 to 15 digits allowed
$, means the last part must end with the last group*/
    
System.out.println("Cell phone number successfully added");
break;} 

else { 
System.out.println("Cell phone number incorrectly formatted or does not contain international code");
}
}

    
//Login Process with a loop
while (true) {
        System.out.println("Enter username to login:");
        String login_user = scan.nextLine();
        System.out.println("Enter password to login:");
        String login_pass = scan.nextLine();

        if (login.loginUser(login_user, username, login_pass, password)) {
            System.out.println(login.returnLoginStatus(login_user, username, login_pass, password));
            break;} // break loop
            
        else {
            System.out.println("Username or password incorrect please try again");
            }
           } 


if (isLoggedIn) {
        System.out.println("Enter recipient number:");
        String recipient = scan.nextLine();
        System.out.println("Enter your message:");
        String content = scan.nextLine();

        Message msg = new Message(recipient, content);
        // Ensure your Message class has this method implemented
        System.out.println(msg.checkMessageContent(content)); 

        if (msg.checkMessageContent(content).equals("Message sent")) {
            System.out.println("Hash: " + msg.createMessageHash());
            
            System.out.println("Select an option:\n1. Send Message\n0. Disregard Message\n3. Store Message");
            String choice = scan.nextLine();

            switch (choice) {
                case "1": System.out.println("Message successfully sent"); break;
                case "0": System.out.println("Press 0 to delete the message"); break;
                case "3": msg.storeMessage(); break;
            }
        }
    } else {
        System.out.println("Login failed.");
    }
}


class Login { // checking if the user meets certain conditions before granting access

       
       boolean checkUserName(String username) {
           if ((username.length() <=5 && username.contains("_"))) {
               return true;
           } else {
               return false;
           }
       }
       
    boolean checkPasswordComplexity(String password) {
        if (password.length() >=8 && password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[\\W_]).{8,}$")) {
            return true;
        } else {
            return false;
        }
        
    }
    boolean checkCellPhoneNumber (String cellnumber) {
        if (cellnumber.matches("^\\+[0-9]{1,3}[0-9]{1,15}$")) {
            return true;
        } else {
            return false;
        }
    } 
        String registerUser(String username, String password) {
        String message= "";
        
        
        if (!(username.length() <=5 && username.contains("_")))// "!", means if length is NOT valid
        {
            message+= "The username is incorrectly formatted";   // "+= means add and assign        
        }
        if (! (password.length() >=8 && password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[\\W_]).{8,}$"))) {
      
          message+="The password does not meet the complexity requirements";
            }
        if (message.isEmpty()) {
            message = "The above conditions have been met, and the user has been registered successfully";
        }
           return message;
    }
    boolean loginUser (String login_username, String username, String login_password, String password) {
        if (login_username.equals( username) && (login_password.equals(password) )) {
            return true;
        } else {
            return false;
        }
    }
        String returnLoginStatus (String login_username, String username, String login_password, String password) {
        String message ="";
        
        if (!login_username.equals( username) && (login_password.equals(password) ) ) {
            
        message+="A failed login"; 
        } else {
            message+="A successful login";
        }
            
       return message;
        }
   } @@
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

QDox parse error in file:///C:/Users/sbuku/OneDrive%20-%20ADvTECH%20Ltd/Documents/School%20modules/PROG/1A/Registration_and_Login1/src/main/java/com/mycompany/registration_and_login1/Registration_and_Login1.java