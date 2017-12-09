package common;

public class Employee {

	private String name = "";
	private String username = "";
	private int salary = 0;

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


	//getter and setter for salary
	public int getSalary()
	{
		return this.salary;
	}

	public void setSalary(int salary)
	{
		this.salary = salary;
	}
}
