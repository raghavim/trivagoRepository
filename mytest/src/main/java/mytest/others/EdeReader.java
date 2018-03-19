package mytest.others;


import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
public class EdeReader {
	public static JsonNode user;
	public static void main(String[] args) {
		int indexOfArtifactUrl = 0,artifactLenghth =0;String artifacturl;
		int indexOfDeployUrl = 0,devLenghth =0;String devurl;
		
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		try {


			
			JsonNode root =mapper.readTree(new File("ede.yaml"));

			String resultOriginal = mapper.writeValueAsString(root);
			System.out.println("Before Update " + resultOriginal);


			System.out.println("After Update " + resultOriginal);
			JsonNode innerNode = root.get("manifest");
			JsonNode aField = innerNode.get("application");
			JsonNode name=aField.get("name");
			String myApplicationName = name.asText();
			System.out.println("application name is:" + myApplicationName);

			JsonNode scm = aField.get("scm");
			JsonNode scm_url=scm.get("url");
			String scmurl=scm_url.asText();
			System.out.println("scm url is " + scmurl); 


			JsonNode artifactNode = innerNode.get("artifact");
			
			artifactLenghth =artifactNode.toString().length()-1; 	    
			if(artifactNode.toString().contains("url")){
				indexOfArtifactUrl =artifactNode.toString().indexOf("url", 0);
				artifacturl = artifactNode.toString().substring(indexOfArtifactUrl, artifactLenghth);
				System.out.println("artifact url is " + artifacturl);
			}
			else
				System.out.println("Could not find the label " + "deploy_url");

			JsonNode environmentNode = innerNode.get("environment");
			JsonNode devNode = environmentNode.get("dev");

			devLenghth =devNode.toString().length()-1; 	    
			if(devNode.toString().contains("deploy_url")){
				indexOfDeployUrl =devNode.toString().indexOf("deploy_url", 0);
				devurl = devNode.toString().substring(indexOfDeployUrl, devLenghth);
				System.out.println("dev url is " + devurl);
			}
			else
				System.out.println("Could not find the label " + "deploy_url");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
//}