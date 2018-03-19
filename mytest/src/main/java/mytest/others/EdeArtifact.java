package mytest.others;

public class EdeArtifact {

    private static String artifact_url;

   
	
	  public String getartifact_url() {
			return artifact_url;
		}
		public void setartifact_url(String url) {
			this.artifact_url = url;
		} 
		
		
		
	@Override
	public String toString() {
		return "EdeArtifact [artifact_url=" + artifact_url  + "]";
	}

}
