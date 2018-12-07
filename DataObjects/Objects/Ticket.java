package Objects;

import Common.Utilities;
import ENUM.SeatType;
import ENUM.Stations;

public class Ticket {

	private String departFrom;
	private String arriveAt;
	private String seatType;
	private String departDate;
	private String bookDate;
	private String expireDate;
	private int amount;
	private String totalPrice;

	public String getDepartStation() {
		return departFrom;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public String getDepartDate() {
		return departDate;
	}

	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getDepartFrom() {
		return departFrom;
	}

	public void setDepartFrom(String departFrom) {
		this.departFrom = departFrom;
	}

	public String getArriveAt() {
		return arriveAt;
	}

	public void setArriveAt(String arriveAt) {
		this.arriveAt = arriveAt;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Ticket() {
		super();
	}

	@Override
	public String toString() {
		return "Ticket [departFrom=" + departFrom + ", arriveAt=" + arriveAt + ", seatType=" + seatType
				+ ", departDate=" + departDate + ", bookDate=" + bookDate + ", expireDate=" + expireDate + ", amount="
				+ amount + ", totalPrice=" + totalPrice + "]";
	}

	public Ticket initRandomTicket() {
		this.departDate = Utilities.getDepartDate();
		this.departFrom = Stations.getRandomDepartStations();
		this.arriveAt = Stations.getRandomArriveStation(this.departFrom);
		this.seatType = SeatType.getRandomSeatType();
		this.amount = Utilities.getRandomAmount();
		return this;
	}
	

	
	
}
