

public class MarketDetailsDTO {
	private int id;
	private String name;
	private String location;
	private int noOfshop;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getNoOfshop() {
		return noOfshop;
	}
	public void setNoOfshop(int noOfshop) {
		this.noOfshop = noOfshop;
	}
	@Override
	public String toString()
	{
		return "id="+id+",name="+name+",location="+location+",noOfshop="+noOfshop+"]";
		
	}

}