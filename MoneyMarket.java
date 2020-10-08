/**
This class is used specifically for money market accounts.
It is a subclass of Account and overrides the two abstract methods.
It contains one additional attribute - the number of withdrawals.
@author Devin Gulati, Emily Tronolone
*/

public class MoneyMarket extends Account {
    private int withdrawals;

    /**
     * Constructor for Checking, initializes values
     * @param holder: holder is passed to super
     * @param balance: balance is passed to super
     * @param dateOpen: dateOpen is passed to super
     */
    public MoneyMarket(Profile holder, double balance, Date dateOpen) {
        super(holder, balance, dateOpen);
        this.withdrawals = 0;
    }
    
	/**
	 * Calculates monthly interest
	 * @return monthly interest
	 */
	@Override
    public double monthlyInterest() {
    	double rate = (0.65/100)/12;
    	return this.getBalance()*rate;
	}
    
	/**
     * Calculates monthly fee
     * @return monthly fee
     */
    @Override
	public double monthlyFee() {
		if ((this.getBalance() >= 2500) && (withdrawals<=6)) {
			return 0;
		}
		return 12;
	}
}