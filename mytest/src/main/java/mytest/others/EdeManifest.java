package mytest.others;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.sun.xml.xsom.impl.scd.Iterators.Map;

@JsonRootName(value = "manifest")
public class EdeManifest {
	@JsonProperty
	private Map<String, String> manifest;
   
		
	 public Map<String, String> getmanifest() {
	        return manifest;
	    }
	    public void setmanifest(Map<String, String> address) {
	        this.manifest = address;
	    }
		
	    // getter methods ommitted
	

}
