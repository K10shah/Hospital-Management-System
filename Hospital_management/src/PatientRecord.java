import java.io.*;
import java.time.LocalTime;
public class PatientRecord {

	LocalTime timestamp = null;
	String diagnosis = "";
	String prescription = "";
	
	PatientRecord(LocalTime timestamp, String diag, String pres)
	{
		this.timestamp = timestamp;
		this.diagnosis = diag;
		this.prescription = pres;
	}
	
	public String toString()
	{
		String formattedString = "";
		formattedString = this.timestamp.toString() + "                           \n";
		formattedString = formattedString + "Diagnosis" + "\n" + this.diagnosis + "\n";
		formattedString = formattedString + "Prescription" + "\n" + this.prescription + "\n";
		return formattedString;
	}
}
