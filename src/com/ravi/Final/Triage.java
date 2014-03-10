package com.ravi.Final;

public class Triage {

	
	public String algo(String conscious,String breathe,String walk,String faid,String raccident,
	String pain,String minjuries,String age,String itime)
	
	{
		if(conscious.equals("yes"))
		{
			if(walk.equals("yes"))
			{
				if(age.equals("low"))
				{
					return("case 2");
				}
				else if(age.equals("high"))
				{
					return("case 3");	
				}
				else
				{
					return("case 5");
				}
			}
			else
			{
				if(raccident.equals("yes"))
				{
					if(conscious.equals("yes"))
					{
						if(minjuries.equals("yes"))
						{
							return("case 1");
						}
						else
						{
							return("case 2");
						}
					}
					else
					{
						return("Immediate");
					}
				}
				else
				{
					if(faid.equals("yes"))
					{
						if(pain.equals("yes"))
						{
							return("Immediate");
						}
						else
						{
							return("case 2");
						}
					}
					else
					{ if(itime.equals("high"))
					  {
						return("case 3");
					  }
					else if(itime.equals("low"))
					  {
						return("case 1");
					  }
					else
					 {	
						return("case 2");
					 }
					}
				}
			}
		}
		else
		{
			if(breathe.equals("no"))
			{
				return("Immediate attention needed");
			}
			else
			{
				if(walk.equals("yes"))
				{
					if(age.equals("low"))
					{
						return("case 2");
					}
					else if(age.equals("high"))
					{
						return("case 3");	
					}
					else
					{
						return("case 5");
					}
				}
				else
				{
					if(raccident.equals("yes"))
					{
						if(conscious.equals("yes"))
						{
							if(minjuries.equals("yes"))
							{
								return("case 1");
							}
							else
							{
								return("case 2");
							}
						}
						else
						{
							return("Immediate");
						}
					}
					else
					{
						if(faid.equals("yes"))
						{
							if(pain.equals("yes"))
							{
								return("Immediate");
							}
							else
							{
								return("case 2");
							}
						}
						else
						{   if(itime.equals("high"))
						    {
							return("case 3");
						    }
						    else if(itime.equals("low"))
						    {
							return("case 1");
						    }
						    else
						    {	
							return("case 2");
						    }
					    }
					}
				}
			}
		}
		
	}
}
