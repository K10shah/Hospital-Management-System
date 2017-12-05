package common;
import java.io.*;
import java.time.LocalTime;
public class PatientRecord {

	private LocalTime timestamp = null;
	private String diagnosis = "";
	private String prescription = "";
	private String doctorName = "";
	
	//getter and setter for diagnosis
	public String getDiagnosis()
	{
		return this.diagnosis;
	}
	public void setDiagnosis(String diag)
	{
		this.diagnosis = diag;
	}
	
	//getter and setter for prescription
	public String getPrescription()
	{
		return this.prescription;
	}
	public void setPrescription(String pres)
	{
		this.prescription = pres;
	}
	
	
	//getter for doctorname
	public String getDoctorName()
	{
		return this.doctorName;
	}
	
	//getter for timestamp
	public LocalTime getTimeStamp()
	{
		return this.timestamp;
	}
	
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
