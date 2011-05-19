package com.autonavi.traffic.location.value;

public final class LocationInfo {
	final public String code;
	final public LocationType locationType;
	final public String subType;
	final public String roadName;
	final public String firstName;
	final public String secondName;
	final public String codeOfAreaRef;
	final public String codeOfLineRef;
	final public String codeOfnOffset;
	final public String codeOfpOffset;
	public LocationInfo(String code, LocationType locationType, String subType,
			String roadName, String firstName, String secondName,
			String codeOfAreaRef, String codeOfLineRef, String codeOfnOffset,
			String codeOfpOffset) {
		this.code = code;
		this.locationType = locationType;
		this.subType = subType;
		this.roadName = roadName;
		this.firstName = firstName;
		this.secondName = secondName;
		this.codeOfAreaRef = codeOfAreaRef;
		this.codeOfLineRef = codeOfLineRef;
		this.codeOfnOffset = codeOfnOffset;
		this.codeOfpOffset = codeOfpOffset;
	}
	@Override
	final public String toString() {
		return String
				.format("LocationInfo [code=%s, locationType=%s, subType=%s, roadName=%s, firstName=%s, secondName=%s, codeOfAreaRef=%s, codeOfLineRef=%s, codeOfnOffset=%s, codeOfpOffset=%s]",
						code, locationType, subType, roadName, firstName,
						secondName, codeOfAreaRef, codeOfLineRef,
						codeOfnOffset, codeOfpOffset);
	}
}
