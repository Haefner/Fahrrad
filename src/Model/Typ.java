package Model;

public enum Typ {

	MOUNTAINBIKE, CITYRAD, RENNRAD;

	public String toString() {
		switch (this) {
		case MOUNTAINBIKE:
			return "Mountainbike";
		case CITYRAD:
			return "Cityrad";
		case RENNRAD:
			return "Rennrad";
		default:
			return "";
		}
	}

}
