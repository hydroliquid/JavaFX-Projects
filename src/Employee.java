/**
* A very basic Employee class that inherits from, or extends the basic Person class
*
* @author	Brian Bourgon
* @version	1.0
*/

public class Employee extends Person
{
	private int employeeNumber;
	private String jobTitle;
	private String department;
	private double salary;

	/**
	* No argument constructor that creates a generic Employee
	*/
	public Employee()
	{
		super();
		//We need to change the Gender type to "male" since the no argument constructor sets it as "female"
		this.setGender(Gender.male);
		employeeNumber = 1000000;
		jobTitle = "Trainee";
		department = "Human Resources";
		salary = 0.0;
	}

	/**
	* A constructor with the most common values supplied
	*
	* @param 	fN		The first or given name of the new Employee object
	* @param 	lN		The last or family name of the new Employee object
	* @param 	sex		The gender or sex of the new Employee object
	* @param 	age		The age in years of the new Employee object (age must be a positive integer less than 128)
	* @param 	empNum	The Employee Number of the new Employee object (valid Employee Numbers are 7 digit numbers beginning with a non-zero integer)
	* @throws IllegalArgumentException Thrown if the passed in Employee Number is not a 7 digit number starting with a non-zero integer
	*/

	public Employee(String fN, String lN, Gender sex, byte age, int empNum) throws IllegalArgumentException
	{
		super(fN, lN, sex, age);
		//Since we are limiting the Gener type to "male" if any other Gender type was passed, we throw an Exception and do not create the object
		//Note we do have to test this after calling the super constructor since that has to be first in the method (or the compiler will yell at you)
		if (sex != Gender.male)
		{
			throw new IllegalArgumentException("Employee objects can only be \"male\"");
		}
		if (empNum < 1000000 || empNum > 9999999)
		{
			throw new IllegalArgumentException("All Employee Numbers must be 7 digit numbers beginning with a non-zero integer");
		}
		else
		{
			employeeNumber = empNum;
		}
	}

	/**
	* A constructor with all of the properties set at construction time
	*
	* @param 	fN		The first or given name of the new Employee object
	* @param 	lN		The last or family name of the new Employee object
	* @param 	mN		The middle name of the new Employee object
	* @param 	title	The courtesy title of the new Employee object (valid values are "Mr", "Mrs", "Ms", "Miss", or "Dr")
	* @param 	suffix	The name suffix of the new Employee object (valid values are "Jr", "II", "III", "IV", or "PhD")
	* @param 	sex		The gender or sex of the new Employee object
	* @param 	age		The age in years of the new Employee object (age must be a positive integer less than 128)
	* @param 	empNum	The Employee Number of the new Employee object (valid Employee Numbers are 7 digit numbers beginning with a non-zero integer)
	* @param	jTitle	The job title of the new Employee object (valid values are "Trainee", "Analyst", "Programmer", "Manager", or "Director")
	* @param	dept	The organizational department of the new Employee object (valid values are "Human Resources", "Coding", "Marketing", or "Sales")
	* @param	wage	The annual salary in U.S. dollars for the new Employee object
	*
	* @throws	IllegalArgumentException Thrown if the passed in employee number is not a 7 digit number beginning with a non-zero integer;
	*			if the job title is not one of "Trainee", "Analyst", "Programmer", "Manage", or "Director";
	*			if the department is not one of "Human Resources", "Coding", "Marketing", or "Sales";
	*			or if the salary is less than zero
	*/
	public Employee(String fN, String lN, String mN, String title, String suffix, Gender sex, byte age, int empNum, String jTitle, String dept, int wage) throws IllegalArgumentException
	{
		super(fN, lN, mN, title, suffix, sex, age);
		//Since we are limiting the Gener type to "male" if any other Gender type was passed, we throw an Exception and do not create the object
		//Note we do have to test this after calling the super constructor since that has to be first in the method (or the compiler will yell at you)
		if (sex != Gender.male)
		{
			throw new IllegalArgumentException("Employee objects can only be \"male\"");
		}
		if (empNum < 1000000 || empNum > 9999999)
		{
			throw new IllegalArgumentException("All Employee Numbers must be 7 digit numbers beginning with a non-zero integer");
		}
		else
		{
			employeeNumber = empNum;
		}
		if (jTitle.equals("Trainee") || jTitle.equals("Analyst") || jTitle.equals("Programmer") || jTitle.equals("Manager") || jTitle.equals("Director"))
		{
			jobTitle = jTitle;
		}
		else
		{
			throw new IllegalArgumentException("All Employee Job Titles must be one of \"Trainee\", \"Analyst\", \"Programmer\", \"Manager\", or \"Director\"");
		}
		if (dept.equals("Human Resources") || dept.equals("Coding") || dept.equals("Marketing") || dept.equals("Sales"))
		{
			department = dept;
		}
		else
		{
			throw new IllegalArgumentException("All Employee Departments must be one of \"Human Resources\", \"Coding\", \"Marketing\", or \"Sales\"");
		}
		if (wage >= 0.0)
		{
			salary = wage;
		}
		else
		{
			throw new IllegalArgumentException("Employee object salaries cannot be negative");
		}
	}

	//We override the setGender method inherited from the Person class in order to make sure that no one can change the Gender to something other than "male"
	@Override
	public void setGender(Gender sex)
	{
		if (sex != Gender.male)
		{
			throw new IllegalArgumentException("Employee objects can only be \"male\"");
		}
	}

	/**
	* A mutator method (setter) method that sets the value of the Employee object's Employee Number
	*
	* @param empNum	The Employee Number of the new Employee object (valid Employee Numbers are 7 digit numbers beginning with a non-zero integer)
	* @throws IllegalArgumentException Thrown if the passed in Employee Number is not a 7 digit number starting with a non-zero integer
	*/
	public void setEmployeeNumber(int empNum)
	{
		if (empNum < 1000000 || empNum > 9999999)
				{
					throw new IllegalArgumentException("All Employee Numbers must be 7 digit numbers beginning with a non-zero integer");
				}
				else
				{
					employeeNumber = empNum;
		}
	}

	/**
	* A mutator method (setter) for updating the Job Title for this Employee object
	*
	* @param	jTitle		The job title of the new Employee object (valid values are "Trainee", "Analyst", "Programmer", "Manager", or "Director")
	*
	* @throws	IllegalArgumentException Thrown if the passed in job title is not one of "Trainee", "Analyst", "Programmer", "Manage", or "Director"
	*/
	public void setJobTitle(String jTitle)
	{
		if (jTitle.equals("Trainee") || jTitle.equals("Analyst") || jTitle.equals("Programmer") || jTitle.equals("Manager") || jTitle.equals("Director"))
		{
			jobTitle = jTitle;
		}
		else
		{
			throw new IllegalArgumentException("All Employee Job Titles must be one of \"Trainee\", \"Analyst\", \"Programmer\", \"Manager\", or \"Director\"");
		}
	}

	/**
	* A mutator method (setter) for updating the organizational Department for this Employee object
	*
	* @param	dept		The organizational department of the new Employee object (valid values are "Human Resources", "Coding", "Marketing", or "Sales")
	*
	* @throws	IllegalArgumentException Thrown if the passed in department is not one of "Human Resources", "Coding", "Marketing", or "Sales";
	*/
	public void setDepartment(String dept)
	{
		if (dept.equals("Human Resources") || dept.equals("Coding") || dept.equals("Marketing") || dept.equals("Sales"))
		{
			department = dept;
		}
		else
		{
			throw new IllegalArgumentException("All Employee Departments must be one of \"Human Resources\", \"Coding\", \"Marketing\", or \"Sales\"");
		}
	}

	/**
	* A mutator method (setter) for updating the annual Salary in U.S. dollars for this Employee object
	*
	* @param	wage		The annual salary in U.S. dollars for the new Employee object (valid values cannot be negative)
	*
	* @throws	IllegalArgumentException Thrown if the passed in salary is less than zero
	*/
	public void setSalary(double wage)
	{
		if (wage >= 0.0)
		{
			salary = wage;
		}
		else
		{
			throw new IllegalArgumentException("Employee object salaries cannot be negative");
		}
	}

	/**
	* An accessor method (getter) to retrieve this Employee object's Employee Number
	*
	* @return employeeNumber	The EmployeeNumber of this Employee object
	*/
	public int getEmployeeNumber()
	{
		return employeeNumber;
	}

	/**
	* An accessor method (getter) to retrieve this Employee object's Job Title
	*
	* @return jobTitle	The Job Title of this Employee object
	*/
	public String getJobTitle()
	{
		return jobTitle;
	}

	/**
	* An accessor method (getter) to retrieve this Employee object's Department
	*
	* @return department	The Department of this Employee object
	*/
	public String getDepartment()
	{
		return department;
	}

	/**
	* An accessor method (getter) to retrieve this Employee object's Salary
	*
	* @return salary	The annual Salary in U.S. dollars of this Employee object
	*/
	public double getSalary()
	{
		return salary;
	}
}