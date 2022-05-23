This is a sample project to demonstrate how to use spring web socket
for server to client communication. 

Original spring example is here

https://spring.io/guides/gs/messaging-stomp-websocket/

Using spring STOMP protocol to communicate from server to client.

For full detail documentation, reffer 26.4 STOMP section of the following documentation.

https://docs.spring.io/spring-framework/docs/4.3.x/spring-framework-reference/html/websocket.html

How to demo the project ?

(1) Build the project

    > gradlew clean build

(2) Open http://localhost:8080 from the browser.

(3) First, browser need to do a handshake with the server. Click on 'connect' button. This will 
open a web socket connection with the server.

(3) Make a post request to the following end point through postman (or any other way)

    http://localhost:8080/update-payment_status?status=SUCCESS

    You can see the payment status is updated accordingly with the message coming from the server.

   