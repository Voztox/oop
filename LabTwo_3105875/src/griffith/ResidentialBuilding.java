//Mert Faruk Gunes - Computer Science 2nd year FT BcHons - 3105875
package griffith;

public class ResidentialBuilding extends Building{
	private double buildNo;

	public ResidentialBuilding(double buildNo, Address address) {
		super(address);
		this.buildNo = buildNo;
	}
	public double getbuildNo() {
		return buildNo;
	}

	public void setbuildNo(double buildNo) {
		this.buildNo = buildNo;
	}
}
