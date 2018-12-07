package ENUM;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum Stations {

	SGN("Sài Gòn"), PT("Phan Thiết"), NT("Nha Trang"), DN("Đà Nẵng"), QN("Quảng Ngãi"), HUE("Huế");

	private String value;

	public void setValue(String value) {
		this.value = value;
	}

	Stations(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static List<Stations> listOfStations() {
		List<Stations> stationsList = new ArrayList<Stations>();

		stationsList.add(Stations.SGN);
		stationsList.add(Stations.DN);
		stationsList.add(Stations.PT);
		stationsList.add(Stations.HUE);
		stationsList.add(Stations.QN);
		stationsList.add(Stations.NT);

		return stationsList;
	}

	public static List<Stations> destinationList(Stations city) {

		List<Stations> resultList = listOfStations();
		for (int i = 0; i < resultList.size(); i++) {

			switch (city) {
			case SGN:
				resultList.remove(Stations.SGN);
				break;
			case PT: {
				resultList.remove(Stations.PT);
				resultList.remove(Stations.HUE);
				resultList.remove(Stations.QN);
			}
				break;
			case NT: {
				resultList.remove(Stations.NT);
				resultList.remove(Stations.QN);
			}
				break;
			case DN: {
				resultList.remove(Stations.DN);
				resultList.remove(Stations.PT);
			}
				break;
			case HUE: {
				resultList.remove(Stations.HUE);
				resultList.remove(Stations.PT);
			}
				break;
			case QN: {
				resultList.remove(Stations.QN);
				resultList.remove(Stations.PT);
			}
				break;
			default: {
			}
				break;
			}
		}

		return resultList;
	}

	public static Stations getEnum(String cityName) {
		Stations city = null;
		switch (cityName) {
		case "Sài Gòn":
			city = Stations.SGN;
			break;
		case "Phan Thiết":
			city = Stations.PT;
			break;
		case "Huế":
			city = Stations.HUE;
			break;
		case "Quảng Ngãi":
			city = Stations.QN;
			break;
		case "Đà Nẵng":
			city = Stations.DN;
			break;
		case "Nha Trang":
			city = Stations.NT;
			break;
		}
		return city;
	}

	public static String getRandomDepartStations() {
		int index = new Random().nextInt(Stations.values().length);
		return Stations.values()[index].getValue().toString();
	}

	public static String getRandomArriveStation(String station) {
		List<Stations> list = destinationList(getEnum(station));
		int index = new Random().nextInt(list.size());
		return list.get(index).getValue().toString();
	}
}