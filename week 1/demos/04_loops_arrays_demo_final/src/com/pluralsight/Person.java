package com.pluralsight;

public class Person
{
    private String firstName = "";
    private String middleName = "";
    private String lastName = "";
    private String suffix = "";

    // constructors
    public Person(){}

    public Person(String firstName, String middleName, String lastName, String suffix)
    {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
    }

    public Person(String fullName){
        parseFullName(fullName);
    }

    // regular properties
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getSuffix()
    {
        return suffix;
    }

    public void setSuffix(String suffix)
    {
        this.suffix = suffix;
    }

    // derived properties (or calculated properties)
    public String getFullName()
    {
        // add first name to the full name
        String fullName = firstName + " ";
        // add middle name if they have one
        if(!middleName.equals("")) {
            fullName += middleName + " ";
        }
        //add last name
        fullName += lastName;
        // add suffix if they have one
        if(!suffix.equals("")){
            fullName += ", " + suffix;
        }

        return fullName;
    }

    // class methods
    private void parseFullName(String fullName)
    {
        // check for suffix and remove it
        int commaIndex = fullName.indexOf(",");
        if(commaIndex >= 0)
        {
            suffix = fullName.substring(commaIndex + 2);
            fullName = fullName.substring(0, commaIndex);
        }

        String[] nameParts = fullName.split(" ");
        firstName = nameParts[0];
        if(nameParts.length > 2)
        {
            middleName = nameParts[1];
            lastName = nameParts[2];
        }
        else
        {
            lastName = nameParts[1];
        }
    }


}
