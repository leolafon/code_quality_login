import {Pos.java};

public class Location {
	private String: title;
	private String: locationType;
	private Number: woeid;
	private Pos: pos;

	public setTitle(String title){
		this.title = title;
	}

	public setLocationType(String locationType){
		this.locationType = title;
	}

	public setWoeid(Number woeid){
		this.woeid = woeid;
	}

	public setPos(String pos){		
		String lattString;
		String longString;
		lattString = pos.substring(0,pos.find(','));
		longString = pos.substring(str.fin(',')+1,pos.lenght)
	}
}