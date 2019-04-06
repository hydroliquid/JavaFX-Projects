/**
 * A very basic Legionnaire class that inherits from, or extends the basic Person class
 *
 * @author	Michael Benton
 * @version	1.0
 */

public class Legionnaire extends Person
{
	private String 	legionnaireID;
	private String 	legionTitle;
	private String 	faction;
	private String 	classType;
	private int 	rank;
	private String 	rankTitle;
	private double 	rankExperience;
	private int 	level;
	private double 	levelExperience;


	/**
	 * No argument constructor that creates a generic Legionnaire
	 */
	public Legionnaire()
	{
		super();
		legionnaireID = "Legion Trainee";
		classType = "Trainee";
		faction = "Mercenary";
		rank = 0;
		rankExperience = 0.0;
		rankTitle = "Private";
		legionTitle = faction + classType + rankTitle;
		levelExperience = 0.0;
		level = 1;
	}

	/**
	 * A constructor with the most common values supplied
	 *
	 * @param 	fN			The first or given name of the new Legionnaire object
	 * @param 	lN			The last or family name of the new Legionnaire object
	 * @param 	sex			The gender or sex of the new Legionnaire object
	 * @param 	age			The age in years of the new Legionnaire object (age must be a positive integer less than 128)
	 * @param 	legionID	The Legionnaire Number of the new Legionnaire object (valid Legionnaire Numbers are 7 digit numbers beginning with a non-zero integer)
	 * @param 	legionID	The Legionnaire Codename of the new Legionnaire object 
	 * @param	CType		The Class Type of the new Legionnaire object (valid values are "Trainee", "Ranger", "Storm", "Executioner", "Angelic", or "Berserk")
	 * @param	fact		The Faction of the new Legionnaire object (valid values are "Blood Cloud", "Blue Foundation", "Generation 17" or "Mercenary")
	 * 
	 * @throws IllegalArgumentException 
	 * 			if the job title is not one of "Ranger", "Storm", "Executioner", "Angelic", or "Berserk";
	 *			if the faction is not one of "Blood Cloud", "Blue Foundation", "Generation 17" or "Mercenary";
	 */
	
	public Legionnaire(String fN, String lN, Gender sex, byte age, String legionID, String CType, String fact) throws IllegalArgumentException
	{
		super(fN, lN, sex, age);
		legionnaireID = legionID;
		rank = 0;
		rankExperience = 0.0;
		rankTitle = "Private";
		levelExperience = 0.0;
		level = 1;

		if (CType.equals("Ranger") || CType.equals("Storm") || CType.equals("Executioner") || CType.equals("Angelic") || CType.equals("Berserk"))
		{
			classType = CType;
		}
		else
		{
			throw new IllegalArgumentException("All Legionnaire Class Type must be one of \"Ranger\", \"Storm\", \"Executioner\", \"Angelic\", or \"Berserk\"");
		}
		if (fact.equals("Blood Cloud") || fact.equals("Blue Foundation") || fact.equals("Generation 17") || fact.equals("Mercenary"))
		{
			faction = fact;
		}
		else
		{
			throw new IllegalArgumentException("All Legionnaire factions must be one of \"Blood Cloud\", \"Blue Foundation\", \"Generation 17\" or \"Mercenary\"");
		}

		legionTitle = faction + classType + rankTitle;
	}
	
	/**
	 * A constructor with all of the properties set at construction time
	 *
	 * @param 	fN			The first or given name of the new Legionnaire object
	 * @param 	lN			The last or family name of the new Legionnaire object
	 * @param 	mN			The middle name of the new Legionnaire object
	 * @param 	title		The courtesy title of the new Legionnaire object (valid values are "Mr", "Mrs", "Ms", "Miss", or "Dr")
	 * @param 	suffix		The name suffix of the new Legionnaire object (valid values are "Jr", "II", "III", "IV", or "PhD")
	 * @param 	sex			The gender or sex of the new Legionnaire object
	 * @param 	age			The age in years of the new Legionnaire object (age must be a positive integer less than 128)
	 * @param 	legionID	The Legionnaire Codename of the new Legionnaire object 
	 * @param	CType		The Class Type of the new Legionnaire object (valid values are "Trainee", "Ranger", "Storm", "Executioner", "Angelic", or "Berserk")
	 * @param	fact		The Faction of the new Legionnaire object (valid values are "Blood Cloud", "Blue Foundation", "Generation 17" or "Mercenary")
	 * @param	rankXP		The rank experience of the new Legionnaire object(This will increase as missions(from factions) are completed
	 * @param	lvlXP		The level experience of the new Legionnaire object(This will increase as missions are completed or monsters are killed)
	 *                     Not in constructor
	 * 	// rankTitle 	The rank title of the Legionnaire object(This is only allowed to be increased if the rank experience is increased)
	 * 	// legionTitle	The legion title of the Legionnaire object(This is autofilled using rTitle, fact and CType)
	 *
	 * @throws	IllegalArgumentException
	 *			if the job title is not one of "Trainee", "Ranger", "Storm", "Executioner", "Angelic", or "Berserk";
	 *			if the faction is not one of "Blood Cloud", "Blue Foundation", "Generation 17" or "Mercenary";
	 *			or if the rank is less than zero
	 */
	public Legionnaire(String fN, String lN, String mN, String title, String suffix, Gender sex, byte age, String legionID, String CType, String fact, double rankXP, double lvlXP) throws IllegalArgumentException
	{
		super(fN, lN, mN, title, suffix, sex, age);
		legionnaireID = legionID;
		if (CType.equals("Trainee") || CType.equals("Ranger") || CType.equals("Storm") || CType.equals("Executioner") || CType.equals("Angelic") || CType.equals("Berserk"))
		{
			classType = CType;
		}
		else
		{
			throw new IllegalArgumentException("All Legionnaire Class Type must be one of \"Trainee\", \"Ranger\", \"Storm\", \"Executioner\", \"Angelic\", or \"Berserk\"");
		}
		if (fact.equals("Blood Cloud") || fact.equals("Blue Foundation") || fact.equals("Generation 17") || fact.equals("Mercenary"))
		{
			faction = fact;
		}
		else
		{
			throw new IllegalArgumentException("All Legionnaire factions must be one of \"Blood Cloud\", \"Blue Foundation\", \"Generation 17\" or \"Mercenary\"");
		}
		if (rankXP >= 0.0)
		{
			rank = (int)rankXP;
			setRankTitle(rankXP);
			rankTitle = getRankTitle();
		}
		else
		{
			throw new IllegalArgumentException("Legionnaire object rank experience cannot be negative");
		}
		if (lvlXP >= 0.0)
		{
			level = (int)lvlXP;
		}
		else
		{
			throw new IllegalArgumentException("Legionnaire object level experience cannot be negative");
		}

		legionTitle = fact + CType + rankTitle;
	}

	/*___________________________________________________________________________
	 * 		 _      _	_ _ _ _   _ _ _ _ _   _       _ _ _ _       _     _ _ _   |
	 * 		|  \  /  | |  _ _  | |_ _ _ _ _| | |     |   _   |     | |   /   _ \  |
	 * 		| |\\//| | |  _ _ _|     | |     | |_ _  |  | |	 |  _ _| |  _ \ \ \_| |
	 * 		| | \/ | | | |_ _ _      | |	 |  _  | |  |_|	 | | _   | | \_\ \    |
	 * 		|_|	   |_| |_ _ _ _|     |_|	 |_| |_| |_ _ _ _| |_ _ _|  \ _ _ /   |
	 * ___________________________________________________________________________|
	 */

    /**
	 * A mutator method (setter) method that sets the value of the Legionnaire object's Legionnaire Number
	 *
	 * @param legionID		The Legionnaire Codename of the new Legionnaire object
	 */
	public void setMylegionID(String legionID)
	{
		legionnaireID = legionID;
	}
	
	/**
	 * A mutator method (setter) for updating the Class Type for this Legionnaire object
	 *
	 * @param	CType		The class type of the new Legionnaire object (valid values are "Trainee", "Ranger", "Storm", "Executioner", "Angelic", or "Berserk")
	 *
	 * @throws	IllegalArgumentException Thrown if the passed in Legion Class Types must be one of "Trainee", "Ranger", "Storm", "Executioner", "Angelic", or "Berserk"
	 */
	public void setClassType(String CType)
	{
		if (CType.equals("Trainee") || CType.equals("Ranger") || CType.equals("Storm") || CType.equals("Executioner") || CType.equals("Angelic") || CType.equals("Berserk"))
		{
			classType = CType;
		}
		else
		{
			throw new IllegalArgumentException("All Legionnaire Class Types must be one of \"Trainee\", \"Ranger\", \"Storm\", \"Executioner\", \"Angelic\", or \"Berserk\"");
		}
	}
	
	/**
	 * A mutator method (setter) for updating the Legion Faction for this Legionnaire object
	 *
	 * @param	fact		The Legion Faction of the new Legionnaire object (valid values are "Blood Cloud", "Blue Foundation" or "Generation 17")
	 *
	 * @throws	IllegalArgumentException Thrown if the passed in faction is not one of "Blood Cloud", "Blue Foundation" or "Generation 17";
	 */
	public void setFaction(String fact)
	{
		if (fact.equals("Blood Cloud") || fact.equals("Blue Foundation") || fact.equals("Generation 17") || fact.equals("Mercenary"))
		{
			faction = fact;
		}
		else
		{
			throw new IllegalArgumentException("All Legionnaire factions must be of \"Blood Cloud\", \"Blue Foundation\", \"Generation 17\" or \"Mercenary\"");
		}
	}
	
	/**
	 * A mutator method (setter) for updating the rank in experienced earned for this Legionnaire object
	 *
	 * @param	rankXP		The rank experience for the new Legionnaire object (valid values cannot be negative)
	 *
	 * @throws	IllegalArgumentException Thrown if the passed in rank experience is less than zero
	 */
	public void setRank(double rankXP)
	{
		try
		{
			if (rankXP >= 0.0)
			{
				rank = (int)rankXP;
			}
		}
		catch(Exception e)
		{
			throw new IllegalArgumentException("Legionnaire object rank experience cannot be negative");
		}
	}
	/**
	 * A mutator method (setter) for updating the rank in experienced earned for this Legionnaire object
	 * Ranks: "Private", "Private 1st Class", "Specialist", "Sargent", "Staff Sargent", "Sargent 1st Class",
	 * "Master Sargent", "1st Sargent", "Sargent Major", "Command Sargent Major",  "Sargent Major of the Army".
	 * Rank Will Auto update as rankXP is changed.
	 * @param	rankXP		The rank experience for the new Legionnaire object (valid values cannot be negative)
	 * 
	 * @throws	IllegalArgumentException Thrown if the passed in rank experience is less than zero
	 */
	public void setRankTitle(double rankXP)
	{
		int rankUp;
		try {
			if (rankXP >= 0.0)
			{
			for(rankUp = 0; rankUp < (int)rankXP; rankUp++)
			{
				if(rankXP >= 0.0)
				{
					rankUp++;
				}
			}
				switch (rankUp) {
					case 0:
						this.rankTitle = "Private";
						break;
					case 1:
						this.rankTitle = "Private";
						break;
					case 2:
						this.rankTitle = "Private 1st Class";
						break;
					case 3:
						this.rankTitle = "Specialist";
						break;
					case 4:
						this.rankTitle = "Sargent";
						break;
					case 5:
						this.rankTitle = "Staff Sargent";
						break;
					case 6:
						this.rankTitle = "Sargent 1st Class";
						break;
					case 7:
						this.rankTitle = "Master Sargent";
						break;
					case 8:
						this.rankTitle = "1st Sargent";
						break;
					case 9:
						this.rankTitle = "Sargent Major";
						break;
					case 10:
						this.rankTitle = "Command Sargent Major";
						break;
					case 11:
						this.rankTitle = "Sargent Major of the Army";
						break;
					default:
						this.rankTitle = "Private";
						break;
				}
				rank = rankUp;
			}
		}
		catch(Exception e)
		{
			throw new IllegalArgumentException(e + " and Legionnaire object rank experience cannot be negative");
		}

	}
	/** 
	 * A mutator method (setter) for updating the rank in experienced earned for this Legionnaire object
	 *
	 * @param	rankXP	The rank experience for the new Legionnaire object (valid values cannot be negative)
	 * 
	 * @throws	IllegalArgumentException Thrown if the passed in rank experience is less than zero
	 */
	public void setRankXP(double rankXP)
	{
		if (rankXP >= 0.0)
		{
			rankExperience = rankXP;
		}
		else
		{
			throw new IllegalArgumentException("Legionnaire object rank experience cannot be negative");
		}
	}

	/** 
	 * A mutator method (setter) for updating the level in experienced earned for this Legionnaire object
	 *
	 * @param	lvlXP			The level experience for the new Legionnaire object (valid values cannot be negative)
	 * 
	 * @throws	IllegalArgumentException Thrown if the passed in rank experience is less than zero
	 */
	public void setLevel(double lvlXP)
	{
		if (lvlXP >= 0.0)
		{
			level = (int)Math.round(lvlXP);
		}
		else
		{
			throw new IllegalArgumentException("Legionnaire object level experience cannot be negative");
		}
	}

	/** 
	 * A mutator method (setter) for updating the level in experienced earned for this Legionnaire object
	 *
	 * @param	lvlXP		The level experience for the new Legionnaire object (valid values cannot be negative)
	 * 
	 * @throws	IllegalArgumentException Thrown if the passed in level experience is less than zero
	 */
	public void setLevelXP(double lvlXP)
	{
		if (lvlXP >= 0.0)
		{
			levelExperience = lvlXP;
		}
		else
		{
			throw new IllegalArgumentException("Legionnaire object level experience cannot be negative");
		}
	}

	/** 
	 * A mutator method (setter) for updating the Legion Title for this Legionnaire object(This setter just calls the getLegionTitle method as an update method)
	 * 
	 */
	public void setLegionTitle()
	{
		legionTitle = legionnaireID + " of " + faction + " " + classType + " " + rankTitle;
	}

	/*		   _ _ _ _ 
	 * 		 / _ _ _ _ \
	 * 		| /       \_\
	 *      | |   _ _ _ _    
	 *      | |  |  _ _  \
	 *      | |  |_|   \  |
	 *      | |_ _ _ _ /  |etters
	 *      \_ _ _ _ _ _ /
	 */ 

	/**
	 * An accessor method (getter) to retrieve this Legionnaire object's Legionnaire Codename
	 *
	 * @return legionnaireID	The legionnaire codename of this Legionnaire object
	 */
	public String getLegionnaireID()
	{
		return legionnaireID;
	}
	
	/**
	 * An accessor method (getter) to retrieve this Legionnaire object's Class Type
	 *
	 * @return classType	The Class Type of this Legionnaire object
	 */
	public String getClassType()
	{
		return classType;
	}
	
	/**
	 * An accessor method (getter) to retrieve this Legionnaire object's Faction
	 *
	 * @return faction		The faction of this Legionnaire object
	 */
	public String getFaction()
	{
		return faction;
	}
	
	/**
	 * An accessor method (getter) to retrieve this Legionnaire object's Rank
	 *
	 * @return rank			The rank of this Legionnaire object
	 */
	public int getRank()
	{
		return rank;
	}

	/**
	 * An accessor method (getter) to retrieve this Legionnaire object's Rank Title
	 *
	 * @return rankTitle		The rank title of this Legionnaire object
	 */
	public String getRankTitle()
	{
		return rankTitle;
	}
	
	/**
	 * An accessor method (getter) to retrieve this Legionnaire object's amount of Rank Experience
	 *
	 * @return rankExperience	The rank experiance of this Legionnaire object
	 */
	public Double getRankXP()
	{
		return rankExperience;
	}

	/**
	 * An accessor method (getter) to retrieve this Legionnaire object's Level
	 *
	 * @return level		The level of this Legionnaire object
	 */
	public int getLevel()
	{
		return level;
	}

	/**
	 * An accessor method (getter) to retrieve this Legionnaire object's amount of Level Experiance
	 *
	 * @return levelExperience		The level experience of this Legionnaire object
	 */
	public Double getLevelXP()
	{
		return levelExperience;
	}

	/**
	 * An accessor method (getter) to retrieve this Legionnaire object's Legion Title
	 *
	 * @return legionTitle		The legion title of this Legionnaire object
	 */
	public String getLegionTitle()
	{
		return legionTitle;
	}
}