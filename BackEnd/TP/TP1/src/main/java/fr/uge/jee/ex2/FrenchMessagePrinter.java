package fr.uge.jee.ex2;

public class FrenchMessagePrinter implements MessagePrinter {
    @Override
    public void printMessage() {
        System.out.println("Bonjour Monde !");
    }
}
