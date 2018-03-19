package mytest.others;

public class EdeScm {
	private static String scm_url;
	public String getscm_url() {
		return scm_url;
	}
	public void setscm_url(String url) {
		this.scm_url = url;
	}
	@Override
	public String toString() {
		return "EdeScm [scm_url=" + scm_url + "]";
	}

}
