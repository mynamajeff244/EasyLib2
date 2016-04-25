//Version 1.0.1 at school currently, added a few new features.
package EasyLib2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

/**<h1>EasyLib2</h1>
 * <p> Instantiating this class allows the user to easily do tasks such as get the computers screen width and height, write to log files, print to the console and many more
 * unique features!
 * 
 * HINT: Import the class by doing: import EasyLib2.EasyLib2;
 * HINT: Intantiate by typing: EasyLib2 ANYTHING = new EasyLib2();
 * 
 * @author romponu
 * @since 25/4/2016
 */
public class EasyLib2 {
	static Random r = new Random();
	String fileName;
	String fileLocation;
	/**
	* <h1>Hello, World!</h1>
	* The HelloWorld program implements an application that
	* simply displays "Hello World!" to the standard output.
	* <p>
	* Basic hello world function to start with(if you are a new programmer!)
	
	* 
	* @param none
	*/
	public void HelloWorld(){
		System.out.println("Hello World!");
	}
	/** <p>
	* Simple print method that works for (virtually)every thing you'd need to print.
	* 
	* @param none
	*/
	public void print(Object o){ 
		System.out.print(o);
	}
	/** <p>
	* Simple println method that works for (virtually)every thing you'd need to print.
	* 
	* @param none
	*/
	public void println(Object o){
		System.out.println(o);
	}	
	/** <p>
	* Creates a log file in a given location.
	* 
	* @param logName The name of the log file you want to create.
	* @param location The location in which you would like the log file to be created.
	* @param hasBranding Allows the programmer to give me credit or not when writing a log file.
	*/
	public void CreateLog(String logName, String location, boolean hasBranding) throws IOException{
		File file = new File(location.concat(logName));
		PrintWriter writer = new PrintWriter(location.concat(logName), "UTF-8");
		fileName = logName;
		fileLocation = location;
		if(!file.exists()){
			file.createNewFile();
		}if(hasBranding){
			writer.println("A text file generated by EasyLib2");
		}
		writer.close();
	}
	/** <p>
	* Writes to a specified log file, if none exists this function will create one.
	* 
	* @param logName The name of the log file.
	* @param location The location in which you would like the log file to be written to.
	* @param phraseToWrite The phrase or sentence the user wants to write into the log file.
	*/
	public void WriteToLog(String logName, String location, String phraseToWrite) throws IOException{
		File file = new File(location.concat(logName));
		PrintWriter writer = new PrintWriter(new FileWriter(location.concat(logName), true));
		if(!file.exists()){
			CreateLog(logName, location, false);
		}
		writer.println(phraseToWrite);
		writer.close();
	}
	/**<p>
	 * Returns the contents of the specified line.
	 * @param logName the name of the log file
	 * @param location the location of the log file
	 * @param specificLine a specific line in a log file.
	 */
	public String ReadLog(String logName, String location, int specificLine) throws IOException{
		FileReader reader = new FileReader(location.concat(logName));
		BufferedReader bReader = new BufferedReader(reader);
		for(int i = 0; i < specificLine; i++){
			bReader.readLine();
		}
		String line = bReader.readLine();
		return line;
	}
	/**<p>
	 * Returns the username as an actual username, instead of recieveing /Users/USERNAME, you will get USERNAME.
	 */
	public String GetComputerName(){
		String computerName = new String(System.getProperty("user.home"));
		String last = "";
		
		for(int i = 1; i < computerName.length(); i++){
			if(computerName.charAt(i) == '/'){
				for(int x = i + 1; x < computerName.length(); x++){
					last += computerName.charAt(x);
				}
			}
		}
		return last;
	}
	/**<p>
	 * Gets the directory of the previously given log file. 
	 */
	public String GetDIR(String logName){
		File file = new File(fileLocation.concat(logName));
		if(!file.exists()) return "This file does not has not been previously created by EasyLib2.";
		return file.getAbsolutePath();
	}
	/** <p>
	* Deletes the specified log files contents.
	* 
	* @param logName The name of the log file you want to clear.
	* @param location The location in which the log file is to be cleared.
	*/
	public void ClearLog(String logName, String location) throws IOException{
		PrintWriter writer = new PrintWriter(location.concat(logName));
		writer.flush();
		writer.close();
	}
	/** <p>
	* Generates a random string.
	* 
	* @param numOfLetters The amount of letters the user would like to generate.
	* 
	*/
	public String RandomString(int numOfLetters){ //Generates a random string
		char[] chars = new char[numOfLetters];
		for(int i = 0; i < numOfLetters;){
			int rand = r.nextInt(90);
			if(rand > 65){
				chars[i] = (char)rand;
				i++;
			}
		}
		String str = new String(chars);
		return str;
	}
	/** <p>
	* Encrypts a given string, can be decrypted.
	* 
	* @param stringToEncrypt The string you would like to encrypt.
	*/
	public String EncryptString(String stringToEncrypt){ //Encrypts a given string, can be decrypted with a custom decrypter below.
		char[] strChar = stringToEncrypt.toCharArray(); 
		for(int i = 0; i < strChar.length; i++) {
			if(i == 0){
				strChar[i] = (char)((int)strChar[i] - (i + 1));
				continue;
			}
			strChar[i] = (char)((int)strChar[i] + i);
		}
		String string = new String(strChar);
		return string;	
	}
	/** <p>
	* Decrypts a given string, most first be encrypyed by using the encrypter above.
	* 
	* @param stringToDecrypt The string to decrypt.
	*/
	public String DecryptString(String stringToDecrypt){ //TODO: Reverse the loop, subtracting every value in the array, ending up w/ the original numbers, then translatied to a char 
		char[] strChar = stringToDecrypt.toCharArray(); 
		for(int i = 0; i < strChar.length; i++){
			if(i == 0){
				strChar[i] = (char)((int)strChar[i] - i + 1);
				continue;
			}
			strChar[i] = (char)((int)strChar[i] - i);
		}
		String string = new String(strChar);
		return string;
	}
	/** <p>
	* Returns the current OS.
	* 
	* 
	* @param none
	*/
	
	public String GetOS(){
		return System.getProperty("os.name");
	}
	/** <p>
	* Returns if the give number is even.
	* 
	* @param n The given number.
	*/
	
	public boolean IsEven(int n){
		return n % 2 == 0;
	}
	/** <p>
	* Returns if the give number is odd.
	* 
	* @param n The given number.
	*/
	
	public boolean IsOdd(int n){
		if(n % 2 != 0){
			return true;
		}
		return false;
	}
	/** <p>
	* Returns the current time, can cause depreciation unfortunately..
	* 
	* @param none 
	**/
	@SuppressWarnings("deprecation")
	public String GetCurrentTime(){
		Date date = new Date();
		return date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
	}
}
