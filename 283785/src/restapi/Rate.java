package restapi;

import javax.xml.bind.annotation.XmlElement;


public class Rate {
	private String no;
	private String effectiveDate;
	private Float mid;

	@XmlElement(name = "No")
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	@XmlElement(name = "EffectiveDate")
	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@XmlElement(name = "Mid")
	public Float getMid() {
		return mid;
	}

	public void setMid(Float mid) {
		this.mid = mid;
	}
}
