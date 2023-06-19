package moadda.moazzi.constant;

public enum PlaceType {
	ENTERTAINMENT(1, "유원시설"),
	TOUR(2, "관광지"),
	SPORTS(3, "체육시설"),
	CITY_PARK(4, "도시공원"),
	RIVER(5, "하천"),
	SCHOOL(6, "학교"),
	REST_AREA(7, "졸음쉼터"),
	COMMON_PROPERTY(8, "공용재산"),
	OTHER_PLACE(99, "기타장소");
	
	private final int value;
	private final String name;
	
	PlaceType(int value, String name){
		this.value = value;
		this.name = name;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static PlaceType valueOf(int value) {
		for(PlaceType placeType : PlaceType.values()) {
			if(placeType.getValue() == value) return placeType;
		}
		
		return null;
	}
}
