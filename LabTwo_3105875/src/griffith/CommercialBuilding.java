//Mert Faruk Gunes - Computer Science 2nd year FT BcHons - 3105875
package griffith;

public class CommercialBuilding extends Building{
	private String buildName;
	private String desc;
	private String opHrs;
	private String webUrl;

	public CommercialBuilding(String buildName, String desc, String opHrs, String webUrl, Address address) {
		super(address);
		this.buildName = buildName;
		this.desc = desc;
		this.opHrs = opHrs;
		this.webUrl = webUrl;
	}
	public String getbuildName() {
		return buildName;
	}

	public void setbuildName(String buildName) {
		this.buildName = buildName;
	}

	public String getdesc() {
		return desc;
	}

	public void setdesc(String desc) {
		this.desc = desc;
	}

	public String getopHrs() {
		return opHrs;
	}

	public void setopHrs(String opHrs) {
		this.opHrs = opHrs;
	}
	public String getwebUrl() {
		return webUrl;
	}
	public void setwebUrl(String webUrl) {
		this.webUrl = webUrl;
	}
}
