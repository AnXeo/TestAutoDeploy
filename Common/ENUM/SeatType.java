package ENUM;

import java.util.Random;

public enum SeatType {
	HARDSEAT("Hard seat"), SOFTSEAT("Soft seat"), SOFTSEATWITHAIR("Soft seat with air conditioner"), HARDBED(
			"Hard bed"), SOFTBED("Soft bed"), SOFTBEDWITHAIR("Soft bed with air conditioner");

	private String seatType;

	SeatType(String seatType) {
		this.seatType = seatType;
	}

	public String getSeatTypeName() {
		return this.seatType;
	}

	public static String getRandomSeatType() {
		int index = new Random().nextInt(SeatType.values().length);
		return SeatType.values()[index].getSeatTypeName().toString();
	}

}