package fr.uge.jee.onlineshop;

public class StandardDelivery implements Delivery {
    private int delay;

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public String getDescription() {
        return "Standard Delivery with a delay of " + String.valueOf(delay) + " days";
    }
}
