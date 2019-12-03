package vultures;

public class OrderThread extends Thread {
	private int userID;
	private int dealID;
	
	public OrderThread(int userID, int dealID) {
		this.userID = userID;
		this.dealID = dealID;
	}
	
	public void run() {
		DatabaseDriver.initConnection();
		DatabaseDriver.addOrder(userID, dealID);
		return;
	}
}
