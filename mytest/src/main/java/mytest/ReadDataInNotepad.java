package mytest;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadDataInNotepad {

	private static Integer EMPLOYEE_NAME_COLUMN = 0;
	private static Integer BOOK_CD_INDEX = 32;
	private static Integer STATUS_COLUMN = 41;
	static int arraylength;

	public static void main( String[] args) throws IOException{

		ArrayList<String > empNames = new ArrayList<String>();
		ArrayList<String > bookCD = new ArrayList<String>();
		//		ArrayList<String > status = new ArrayList<String>();

		FileInputStream fstream = new  FileInputStream("C:\\Users\\mraghavi\\Desktop\\softwares\\7-1-BOOKOFF_BOARD_INQUIRY.log");

		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;

		int character;


//		while (((strLine = br.readLine()) != null &&  (character = br.read()) != -1)){
//
//			strLine = strLine.trim();
//		//	System.out.println("printing first Line" + strLine.toString());
//
//			//    System.out.println("printing read line " + strLine);
//			if ((strLine.length()!=0)) {
//					String[] emps = strLine.split("\\s{6,}");
//				//String[] emps = strLine.split("\\t+");
//				empNames.add(emps[EMPLOYEE_NAME_COLUMN]);
//
//			}
//
//		} 
//		
//		System.out.println(empNames.get(0));
//		empNames.remove(0);
//		System.out.println("Removing first  line");
//		System.out.println(empNames.get(0));
//		empNames.remove(0);
//		System.out.println("Removing second  line");
//		int empNamesLength = empNames.size();
//		System.out.println(empNames.get(0));
//		empNames.remove(0);
//		System.out.println("Removing last  line");
//		System.out.println(empNames.get(empNamesLength-2));
//		empNames.remove(empNamesLength-2);
//		empNamesLength=empNames.size();
//		System.out.println("Removing last but one  line");
//		System.out.println(empNames.get(empNamesLength-1));
//		empNames.remove(empNamesLength-1);
	
		
//		System.out.println("Printing Employye Names \n");
//		for (String s : empNames) {	
//			System.out.println(s);
//		}
				while (((strLine = br.readLine()) != null  &&  (character = br.read()) != -1)){
		
					strLine = strLine.trim();
		
					//    System.out.println("printing read line " + strLine);
					if ((strLine.length()!=0)) {
						
						String[] bookCd = strLine.split("\\t");
					//	if(bookCd.toString().contains("ESB") || bookCd.toString().contains("SET-UP ENG"))
							
						bookCD.add(bookCd[0]);
					}
					
		
				}
				
			System.out.println(bookCD.get(5).charAt(32));
//				for (String s : bookCD) {					
//					
//					System.out.println(s);
//					
//					
//				}
				
				
				System.out.println(bookCD.get(0));
				bookCD.remove(0);
				System.out.println("Removing first  line");
				System.out.println(bookCD.get(0));
				bookCD.remove(0);
				System.out.println("Removing second  line");
				 arraylength = bookCD.size();
				System.out.println(bookCD.get(0));
				bookCD.remove(0);
				System.out.println("Removing last  line");
				System.out.println(bookCD.get(arraylength-2));
				bookCD.remove(arraylength-2);
				arraylength=bookCD.size();
				System.out.println("Removing last but one  line");
				System.out.println(bookCD.get(arraylength-1));
				bookCD.remove(arraylength-1);
	
				arraylength=bookCD.size();
				char[] bookCDfetched = new char[arraylength];
				char[] statusfetched = new char[arraylength];
				String[] employeeNames = new String[arraylength];
				
			try{
				
			
				for( int i =0; i< arraylength ; i++ ){
					bookCDfetched[i] = bookCD.get(i).charAt(BOOK_CD_INDEX);
					statusfetched[i] = bookCD.get(i).charAt(STATUS_COLUMN);
					employeeNames[i] = bookCD.get(i).substring(0, 27).trim();
					//System.out.println(bookCDfetched[i]);
				}
				
			}catch(Exception e){
	            //StringIndexOutOfBoundsException cannot be caught explicitly
	            System.out.println("Caught exception : "+e.toString());
	        }
				
				for( int i =0; i< arraylength ; i++ ){
					System.out.println(bookCDfetched[i]);
				}
				for( int i =0; i< arraylength ; i++ ){
					System.out.println(statusfetched[i]);
				}
				for( int i =0; i< arraylength ; i++ ){
					System.out.println(employeeNames[i]);
				}

	}
	
	

}
