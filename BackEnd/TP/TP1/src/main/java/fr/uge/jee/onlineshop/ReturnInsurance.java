package fr.uge.jee.onlineshop;

public class ReturnInsurance implements Insurance {
    private boolean everyone;

    public void setEveryone(boolean everyone) {
        this.everyone = everyone;
    }

    @Override
    public String getDescription() {
        if (everyone) {
            return "Return insurance for everyone";
        }
        return "Return insurance only for members";
    }
}
