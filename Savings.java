/**
This class is used specifically for savings accounts.
It is a subclass of Account and overrides the two abstract methods.
It contains one additional attribute - isLoyal.
@author Devin Gulati, Emily Tronolone
*/

public class Savings extends Account {
    private boolean isLoyal;

    /**
     * Constructor for Checking, initializes values
     * @param holder: holder is passed to super
     * @param balance: balance is passed to super
     * @param dateOpen: dateOpen is passed to super
     * @param isLoyal: this.isLoyal is set equal to isLoyal
     */
    public Savings(Profile holder, double balance, Date dateOpen, boolean isLoyal) {
        super(holder, balance, dateOpen);
        this.isLoyal = isLoyal;
    }
    
	/**
	 * Calculates monthly interest
	 * @return monthly interest
	 */
	@Override
    public double monthlyInterest() {
    	double rate = 0;
    	if (isLoyal) {
    		rate = (0.35/100)/12;
    	} else {
    		rate = (0.25/100)/12;
    	}
    	return this.getBalance()*rate;
	}
    
    /**
     * Calculates monthly fee
     * @return monthly fee
     */
    @Override
	public double monthlyFee() {
		if (this.getBalance() >= 300) {
			return 0;
		}
		return 5;
	}
}