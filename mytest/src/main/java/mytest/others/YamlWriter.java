package mytest.others;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.dataformat.yaml.snakeyaml.Yaml;

public class YamlWriter {
	
	//public static void main(String[] args) throws IOException{
	
	public void testDumpWriter() throws IOException {
		   Map<String, Object> data = new HashMap<String, Object>();
		   data.put("username", "Silenthand Olleander");
		   data.put("password", "Human");
		 //  data.put("traits", new String[] { "ONE_HAND", "ONE_EYE" });

		   Yaml yaml = new Yaml();
		   FileWriter writer = new FileWriter("C:\\Users\\mraghavi\\mytest\\sample.yml");
		   yaml.dump(data, writer);
		//}
	}
	public void testDumpWriter(String usrname, String pswrd) throws IOException {
		   Map<String, Object> data = new HashMap<String, Object>();
		   data.put("username", usrname);
		   data.put("password", pswrd);
		 //  data.put("traits", new String[] { "ONE_HAND", "ONE_EYE" });

		   Yaml yaml = new Yaml();
		   FileWriter writer = new FileWriter("C:\\Users\\mraghavi\\mytest\\sample.yml");
		   yaml.dump(data, writer);
		//}
	}
	
}
