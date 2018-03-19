import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;




public class sikuliNotepad {
	public static final String FILENAME="C:\\Users\\mraghavi\\Desktop\\sikuli\\Log.txt";
	
	
	 
 
	public static void main(String[] args) throws FindFailed{
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		Screen s=new Screen();

		ImagePath.setBundlePath("C:\\Users\\mraghavi\\Desktop\\sikuli");
		s.click("minimizeEclipse.png");
		s.doubleClick("NotePadIcon.png");
		
		 s.find("NotePad.png");
	
		 s.type("NotePad.png","This is Nice Sikuli Tutorial!!!!");
		 
		 s.saveScreenCapture("C:\\Users\\mraghavi\\Desktop\\sikuli", "NotepadTutorial.png");
		
		try {

			String content = "This is the content to write into file\n";

			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(content);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		
	}
}
}
