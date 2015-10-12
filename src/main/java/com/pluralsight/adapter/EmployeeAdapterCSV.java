package com.pluralsight.adapter;

public class EmployeeAdapterCSV implements Employee {

	private EmployeeCSV instance;
	
	public EmployeeAdapterCSV(EmployeeCSV instance)
	{
		this.instance = instance;
	}
	
	@Override
	public String getId() {
		return String.valueOf(instance.getId());
	}

	@Override
	public String getFirstName() {
		return instance.getFirstName();
	}

	@Override
	public String getLastName() {
		return instance.getLastName();
	}

	@Override
	public String getEmail() {
		return instance.getEmailAddress();
	}

	public String toString()
	{
		return "ID: " + instance.getId() + ", FirstName: " + instance.getFirstName() + ", LastName: " + instance.getLastName() + ", Email: " + instance.getEmailAddress() + "\n";
	}
}
