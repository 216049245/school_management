package helper;
import org.springframework.util.StringUtils;


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

    public static void checkIfObjectNull(String objectName, Object object) { //Checks object attributes to ensure they are not null.
        if (object == null) {
            throw new IllegalArgumentException(String.format("%s is null", objectName));
        }
    }
}