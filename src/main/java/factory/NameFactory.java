package factory;

import domain.Name;
import helper.GenericHelper;

/*
 * Siphiwe Edson Chauque -219084777
 * Application Development Practice 3
 * Due Date: 18 June 2022
 * ***Name*** entity
 */
public class NameFactory {
    public static Name buildName(String firstName, String middleName, String lastName){

        GenericHelper.checkStringParam("Siphiwe", firstName);
        GenericHelper.checkStringParam(null, middleName);
        GenericHelper.checkStringParam("Last Name", lastName);
        middleName = GenericHelper.setEmptyIfNull(middleName);

        return new Name.Builder().firstName(firstName).middleName(middleName).lastName(lastName).build();

    }
}


