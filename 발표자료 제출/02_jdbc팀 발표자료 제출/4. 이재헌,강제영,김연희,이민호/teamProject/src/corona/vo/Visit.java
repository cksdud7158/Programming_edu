package corona.vo;

public class Visit extends Place{
	private int ssn;
	private String visitDate;
	private String cleanDate;
	
	public Visit() {
		
	}
	public Visit(String cleanDate) {
		this(null, null, 0, null, cleanDate);
		
	}
	public Visit(String address, String name, int ssn, String visitDate, String cleanDate) {
		super(address, name);
		this.ssn = ssn;
		this.visitDate = visitDate;
		this.cleanDate = cleanDate;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public String getCleanDate() {
		return cleanDate;
	}

	public void setCleanDate(String cleanDate) {
		this.cleanDate = cleanDate;
	}

	@Override
    public String toString() {
        return super.toString() + " Visit [ssn=" + ssn + ", visitDate=" + visitDate + ", cleanDate=" + cleanDate + "]";
    }
	
	
	
	
}
