package pomRepository;

public enum PageLink {
	OPEN_ACCOUNT("Open Account"), APPLY_DEBIT_CARD("Apply Debit Card"), FUND_TRANSFER("Fund Transfer");
	
	private String pageLink;

	private  PageLink(String pageLink) {
		this.pageLink = pageLink;
	}
	
	public String getPageLink() {
		return pageLink;
	}
}
