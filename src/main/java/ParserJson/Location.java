import Pos.java;

public class Location {
	private String title;
	private String locationType;
	private Number woeid;
	private Pos pos;


	public SetLocation(json){
		this.setTitle(testJson.title.toString());
		this.setTitle(testJson.location_type.toString());
		this.setWoeid(testJson.woeid);
		this.setPos(testJson.latt_long);
	}

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

	public String getTitle(){
		return this.title;
	}

	public String getLocationType(){
		return this.locationType;
	}

	public Number getWoreid(){
		return this.woeid;
	}

	public Pos getPos(){
		return this.pos;
	}
}