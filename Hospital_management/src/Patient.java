import java.util.*;
import java.io.*;

public class Patient {
	private String name = "";
	private String username = "";
	private double accountbalance = 0;
	private ArrayList<PatientRecord> patientRecord = new ArrayList<PatientRecord>();

	//getter and setter for name
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}


	//getter and setter for username
	public String getUserName()
	{
		return this.username;
	}

	public void setUserName(String username)
	{
		this.username = username;
	}
	
	//getter and setter for account
	public double getAccountBalance()
	{
		return this.accountbalance;
	}
	
	public void setAccountBalance(double newBalance)
	{
		this.accountbalance = newBalance;
	}


	
	//getter for the PatientRecord
	public ArrayList<PatientRecord> getPatientRecord()
	{
		return this.patientRecord;
	}
	Patient(String name, String username)
	{
		this.name = name;
		this.username = username;
	}

	//@Requires("pr!=null")
	public void AddRecord(PatientRecord pr)
	{
		this.patientRecord.add(pr);
	}
	
	
	//Function to view all the records of the patient
	//@Requires("patientRecord != null")
	//@Ensures(records!=null)
	public void ViewRecords()
	{
		String records = "";
		for(int i = 0; i< patientRecord.size(); i++)
		{
			records = records + (patientRecord.iterator().next().toString());
		}

		if(records.isEmpty())
		{
			System.out.println("Nothing to show");
		}
		else
		{
			System.out.println(records);
		}
	}

	//Displaying account info of the patient
	public void ViewAccount()
	{
		System.out.println("Your outstanding amount to be paid is " + accountbalance);
	}
}
