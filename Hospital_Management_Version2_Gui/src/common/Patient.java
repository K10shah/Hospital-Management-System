package common;
import java.util.*;
import java.io.*;

public class Patient {
	private String name = "";
	private String username = "";
	private double accountbalance = 0;
	private ArrayList<PatientRecord> patientRecord = new ArrayList<PatientRecord>();

	
	Patient(String username, String name)
	{
		this.name = name;
		this.username = username;
	}
	
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
		this.accountbalance = this.accountbalance + newBalance;
	}



	//getter for the PatientRecord
	public ArrayList<PatientRecord> getPatientRecord()
	{
		return this.patientRecord;
	}
	

	//@Requires("pr!=null")
	public void AddRecord(PatientRecord pr)
	{
		this.patientRecord.add(pr);
	}


	//Function to view all the records of the patient
	//@Requires("patientRecord != null")
	//@Ensures(records!=null)
	public String ViewRecords()
	{
		String records = "";
		for(int i = 0; i< patientRecord.size(); i++)
		{
			records = records + (patientRecord.iterator().next().toString());
		}

		if(records.isEmpty())
		{
			return "Nothing to show";
		}
		else
		{
			return records;
		}
		
	}

	//Displaying account info of the patient
	public void ViewAccount()
	{
		System.out.println("Your outstanding amount to be paid is " + accountbalance);
	}
}
