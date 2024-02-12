//Mert Faruk Gunes - Computer Science 2nd year FT BcHons - 3105875
package griffith;

public class Building {
	private Address address;

	public Building (Address address) {
		this.address = address;
	}
	public Address getaddress() {
		return address;
	}

	public void setaddress(Address address) {
		this.address = address;
	}
	public String getInfo() {
		return "Address: " + address.getFullAddress();
	}
}
