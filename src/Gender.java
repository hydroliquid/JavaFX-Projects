/**
* A basic Gender data type enumeration which allows for traditional Gender types of
* male and female, as well as for unspecified to denote a non-traditional Gender type,
* the user does not want to disclose Gender, or a non-binary Gender type
*/
public enum Gender
{
/** Gender type male */
male,
/** Gender type female */
female,
/** Gender type unspecified or non-binary */
unspecified
}

/*
The enumeration above works essentially as if we declared each member as a static constant:

public static final int male = 1;
public static final int female = 2;
public static final int unspecified = 3;

When printing the value of a variable of the enum type it displays as if there is a toString()
method like this:

public String toString()
{
	if (Gender.male) return "male";
	if (Gender.female) return "female";
	if (Gender.unspecified) return "unspecified";
}
*/