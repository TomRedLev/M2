package fr.uge.jee.ex3;

public class CountMessagePrinter implements MessagePrinter {
    private int count = 0;

    @Override
    public void printMessage() {
        System.out.println("This message number " + count);
        count += 1;
    }
}
