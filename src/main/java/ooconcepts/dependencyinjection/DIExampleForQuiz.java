package ooconcepts.dependencyinjection;


import org.springframework.core.annotation.Order;

public class DIExampleForQuiz {

    // Problem: Rewrite the following method to reduce coupling to the concrete class. You can make any assumptions
    // you like about superclasses or interfaces concerning the concrete class:
//    void processOrder(Order order) {
//        updateDatabase(order);
//        sendToShipping(order);
//        PayPalPaymentService paymentService = new PayPalPaymentService();
//        paymentService.getFunds(order.amount);
//    }

    // Solution:
//    void processOrderWithDI(Order order, PaymentService paymentService) {
//        updateDatabase(order);
//        sendToShipping(order);
//        paymentService.getFunds(order.amount);
//    }

    // Follow-up Question: How does the above solution help us with testing this method?

    // Answer: It allows us to pass in a different implementation of the payment service that does not require a PayPal
    // account or even an internet connection if we pass in an appropriate test implementation.
}
