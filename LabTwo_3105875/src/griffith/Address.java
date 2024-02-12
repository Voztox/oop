//Mert Faruk Gunes - Computer Science 2nd year FT BcHons - 3105875
package griffith;

public class Address extends Location {
	private String eircode;
	private String stName;
	private String county;

	public Address(String eircode, String stName, String county, double latitude , double longitude) {
		super(latitude, longitude);
		this.eircode = eircode;
		this.stName = stName;
		this.county = county;
	}
	public String getEircode() {
		return eircode;
	}

	public void setEircode(String eircode) {
		this.eircode = eircode;
	}

	public String getstName() {
		return stName;
	}

	public void setStreetName(String stName) {
		this.stName = stName;
	}

	public String getcounty() {
		return county;
	}

	public void setCityTown(String county) {
		this.county = county;
	}

	public String getFullAddress() {
		return eircode + ", " + stName + ", " + county;
	}
}