/**
 * This class is used specifically for checking accounts.
 * It is a subclass of Account and overrides the two abstract methods.
 * It contains one additional attribute - directDeposit.
 * @author Devin Gulati, Emily Tronolone
 */
public class Checking extends Account {
    private boolean directDeposit;

    /**
     * Constructor for Checking, initializes values
     * @param holder: holder is passed to super
     * @param balance: balance is passed to super
     * @param dateOpen: dateOpen is passed to super
     * @param directDeposit: this.directDeposit is set equal to directDeposit
     */
    public Checking(Profile holder, double balance, Date dateOpen, boolean directDeposit) {
        super(holder, balance, dateOpen);
        this.directDeposit = directDeposit;
    }

    /**
     * Calculates monthly interest
     * @return monthly interest
     */
    @Override
    public double monthlyInterest() {
        double rate = (0.05/100)/12;
        return this.getBalance()*rate;
    }

    /**
     * Calculates monthly fee
     * @return monthly fee
     */
    @Override
    public double monthlyFee() {
        if ((this.getBalance() >= 1500) || (!directDeposit)) {
            return 0;
        }
        return 25;
    }
}