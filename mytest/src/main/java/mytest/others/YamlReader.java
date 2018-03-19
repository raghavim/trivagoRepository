package mytest.others;

import java.io.File;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
public class YamlReader {
	public static Guru99User user;
   // public static void main(String[] args) {
	public static void yamlReader(){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            User user = mapper.readValue(new File("Guru99User.yaml"), User.class);
        	// user=mapper.readValue(new File("ede.yaml"), EdeManifest.class);
        	 System.out.println(ReflectionToStringBuilder.toString(user,ToStringStyle.MULTI_LINE_STYLE));
        //    System.out.println("Inside Reader "+ user.getName());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    }
//}