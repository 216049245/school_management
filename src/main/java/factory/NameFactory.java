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

        GenericHelper.checkStringParam("firstName", firstName);
        GenericHelper.checkStringParam("middleName", middleName);
        GenericHelper.checkStringParam("lastName", lastName);
        return new Name.Builder().firstName(firstName).middleName(middleName).lastName(lastName).build();
    }
}


