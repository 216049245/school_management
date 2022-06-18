package helper;
import org.springframework.util.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

/*
 * Siphiwe Edson Chauque -219084777
 * Application Development Practice 3
 * Due Date: 18 June 2022
 * ***Name*** entity
 */

public class GenericHelper {

    public static boolean isEmptyOrNull(String str) {
        return StringUtils.isEmpty(str);
    }
    public static String setEmptyIfNull(String str){
        if (isEmptyOrNull(str)){
            return null;
        }
        return str;
    }

    public static void checkStringParam(String paramName, String paramValue) {
        if (isEmptyOrNull(paramValue))
            throw new IllegalArgumentException(String.format("Invalid value for: %s", paramName));
    }

    public static void checkEmail(String s){ //Method that ensures that emails are valid.
        EmailValidator emailValidator = EmailValidator.getInstance();
        if (!emailValidator.isValid(s))
            throw new IllegalArgumentException("Email not valid");
    }

    public static void checkIfObjectNull(String objectName, Object object) { //Checks object attributes to ensure they are not null.
        if (object == null) {
            throw new IllegalArgumentException(String.format("%s is null", objectName));
        }
    }
}