/**
* A very basic Person class that describes a generic person as would be used in a
* Human Resources Application or Video Game Character
*
* @author	Brian Bourgon
* @version	1.0
*/

public class Person
{
	//Properties of a Person object
	private String firstName;
	private String lastName;
	private String middleName;
	private String courtesyTitle;
	private String suffix;
	private Gender gender;
	private byte age;

	/**
	* No argument constructor that creates a generic Person object
	*/
	public Person()
	{
		firstName = "Jane";
		lastName = "Doe";
		middleName = null;
		courtesyTitle = null;
		suffix = null;
		//With Enum types, we can reference any of the limited values as a public static constant of the class
		gender = Gender.female;
		age = 0;
	}

	/**
	* A constructor that creates a Person object with the most common properties set at
	* construction time
	*
	* @param fN		The first or given name of the new Person object
	* @param lN		The last of family name of the new Person object
	* @param sex	The gender or sex of the new Person object
	* @param age	The age in years of the new Person object (age must be a positive integer less than 128)
	* @throws IllegalArgumentException		Thrown if the passed in age is negative
	*/
	public Person(String fN, String lN, Gender sex, byte age)
	{
		firstName = fN;
		lastName = lN;
		//Since the Enum value is an integer constant, we can assign it directly.  integer constants pass by value, not by reference
		//Since the Enum type only allows a specified set of values, no data protection is needed.  If the Enum variable is set, it
		//  is valid.  An invalid Enum value will not compile.
		gender = sex;

		if (age < 0)
		{
			throw new IllegalArgumentException("All Person objects must be at least 0 years of age");
		}
		else
		{
			this.age = age;
		}
	}

	/**
	* A constructor that creates a Person object with all of the properties set at
	* construction time
	*
	* @param fN		The first or given name of the new Person object
	* @param lN		The last of family name of the new Person object
	* @param mN		The middle name of the new Person object
	* @param title	The courtesy title of the new Person object (valid values are "Mr", "Mrs", "Ms", "Miss", or "Dr")
	* @param suffix	The name suffix of the new Person object (valid values are "Jr", "II", "III", "IV", or "PhD")
	* @param sex	The gender or sex of the new Person object
	* @param age	The age in years of the new Person object (age must be a positive integer less than 128)
	* @throws IllegalArgumentException		Thrown if the passed in courtesty title is not one of "Mr", "Mrs", "Ms", "Miss", or "Dr";
	* 	the passed in name suffix is not one of "Jr", "II", "III", "IV", or "PhD"; or if the age is negative
	*/
	public Person(String fN, String lN, String mN, String title, String suffix, Gender sex, byte age)
	{
		firstName = fN;
		lastName = lN;
		middleName = mN;
		//Since the Enum value is an integer constant, we can assign it directly.  integer constants pass by value, not by reference
		//Since the Enum type only allows a specified set of values, no data protection is needed.  If the Enum variable is set, it
		//  is valid.  An invalid Enum value will not compile.
		gender = sex;

		if (title.equals("Mr") || title.equals( "Mrs") || title.equals("Ms") || title.equals("Miss") || title.equals("Dr"))
		{
			courtesyTitle = title;
		}
		else
		{
			throw new IllegalArgumentException("Person objects can only have courtesy titles of \"Mr\", \"Mrs\", \"Ms\". \"Miss\", or \"Dr\"");
		}
		if (suffix.equals("Jr") || suffix.equals("II") || suffix.equals("III") || suffix.equals("IV") || suffix.equals("PhD"))
		{
			this.suffix = suffix;
		}
		else
		{
			throw new IllegalArgumentException("Person objects can only have name suffixes of \"Jr\", \"II\", \"III\", \"IV\", or \"PhD\"");
		}
		if (age < 0)
		{
			throw new IllegalArgumentException("All Person objects must be at least 0 years of age");
		}
		else
		{
			this.age = age;
		}
	}

	/**
	* A method to set the value of this Person object's first or given name
	*
	* @param fN		The first or given name of this Person object
	*/
	public void setFirstName(String fN)
	{
		firstName = fN;
	}

	/**
	* A method to set the value of this Person object's last or family name
	*
	* @param lN		The last or family name of this Person object
	*/
	public void setLastName(String lN)
	{
		lastName = lN;
	}

	/**
	* A method to set the value of the Person object's middle name
	*
	* @param mN		The middle name of the new Person object
	*/
	public void setMiddleName(String mN)
	{
		middleName = mN;
	}

	/**
	* A method to set the value of the Person object's courtesy title
	*
	* @param title	The courtesy title of the new Person object (valid values are "Mr", "Mrs", "Ms", "Miss", or "Dr")
	*
	* @throws IllegalArgumentException		Thrown if the passed in courtesty title is not one of "Mr", "Mrs", "Ms", "Miss", or "Dr"
	*/
	public void setCourtesyTitle(String title)
	{
		if (title.equals("Mr") || title.equals( "Mrs") || title.equals("Ms") || title.equals("Miss") || title.equals("Dr"))
		{
			courtesyTitle = title;
		}
		else
		{
			throw new IllegalArgumentException("Person objects can only have courtesy titles of \"Mr\", \"Mrs\", \"Ms\". \"Miss\", or \"Dr\"");
		}
	}

	/**
	* A method to set the value of the Person object's name suffixes
	*
	* @param suffix	The name suffix of the new Person object (valid values are "Jr", "II", "III", "IV", or "PhD")
	*
	* @throws IllegalArgumentException		Thrown if the passed in name suffix is not one of "Jr", "II", "III", "IV", or "PhD"
	*/
	public void setSuffix(String suffix)
	{
		if (suffix.equals("Jr") || suffix.equals("II") || suffix.equals("III") || suffix.equals("IV") || suffix.equals("PhD"))
		{
			this.suffix = suffix;
		}
		else
		{
			throw new IllegalArgumentException("Person objects can only have name suffixes of \"Jr\", \"II\", \"III\", \"IV\", or \"PhD\"");
		}
	}

	/**
	* A method to set the value of this Person object's gender
	*
	* @param sex	The gender or sex of the new Person object
	*/
	public void setGender(Gender sex)
	{
		//Since the Enum value is an integer constant, we can assign it directly.  integer constants pass by value, not by reference
		//Since the Enum type only allows a specified set of values, no data protection is needed.  If the Enum variable is set, it
		//  is valid.  An invalid Enum value will not compile.
		gender = sex;
	}

	/**
	* A method to set the value of this Person object's age
	* (age must be a positive integer less than 128)
	*
	* @param age	The age in years of the new Person object (age must be a positive integer less than 128)
	*
	* @throws IllegalArgumentException		Thrown if the passed in age is negative
	*/
	public void setAge(byte age)
	{
		if (age < 0)
		{
			throw new IllegalArgumentException("All Person objects must be at least 0 years of age");
		}
		else
		{
			this.age = age;
		}
	}

	/**
	* A method to retrieve the first or given name of this Person object
	*
	* @return firstName		The first or given name of this Person object
	*/
	public String getFirstName()
	{
		return firstName;
	}

	/**
	* A method to retrieve the last or family name of this Person object
	*
	* @return lastName	The last or family name of this Person object
	*/
	public String getLastName()
	{
		return lastName;
	}

	/**
	* A method to retrieve the middle name of this Person object
	*
	* @return middleName	The middle name of this Person object
	*/
	public String getMiddleName()
	{
		return middleName;
	}

	/**
	* A method to retrieve the courtesyTitle of this Person object
	*
	* @return courtesyTitle	The courtesy title of this Person object
	*/
	public String getCourtesyTitle()
	{
		return courtesyTitle;
	}

	/**
	* A method to retrieve the name suffix of this Person object
	*
	* @return suffix	The name suffix of this Person object
	*/
	public String getSuffix()
	{
		return suffix;
	}

	/**
	* A method to retrieve the gender of this Person object
	*
	* @return gender	The gender of this Person object
	*/
	public Gender getGender()
	{
		return gender;
	}

	/**
	* A method to retrieve the age of this Person object
	*
	* @return age	The age of this Person object
	*/
	public byte getAge()
	{
		return age;
	}
}