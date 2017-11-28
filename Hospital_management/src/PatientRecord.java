import java.io.*;
import java.time.LocalTime;
public class PatientRecord {

	LocalTime timestamp = null;
	String diagnosis = "";
	String prescription = "";
	String doctorName = "";
	
	PatientRecord(LocalTime timestamp, String diag, String pres, String doctorName)
	{
		this.timestamp = timestamp;
		this.diagnosis = diag;
		this.prescription = pres;
		this.doctorName = doctorName;
	}
	
	public String toString()
	{
		String formattedString = "";
		formattedString = this.doctorName + " " + this.timestamp.toString() + "                           \n";
		formattedString = formattedString + "Diagnosis" + "\n" + this.diagnosis + "\n";
		formattedString = formattedString + "Prescription" + "\n" + this.prescription + "\n";
		return formattedString;
	}
}
