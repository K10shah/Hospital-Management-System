import java.util.*;
import java.io.*;

public class Patient {
	String name = "";
	String username = "";
	double accountbalance = 0;
	ArrayList<PatientRecord> patientRecord = new ArrayList<PatientRecord>();
	
	Patient(String name, String username)
	{
		this.name = name;
		this.username = username;
	}
	
	public void ViewRecords()
	{
		while(patientRecord.iterator().hasNext())
		{
			System.out.println(patientRecord.iterator().next().toString());
		}
	}
}
