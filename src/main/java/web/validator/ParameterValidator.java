package web.validator;

public class ParameterValidator {

    public boolean isNumber(String parameter){
        try {
            Double.parseDouble(parameter);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public boolean isNull(String parameter){
        if (parameter == null){
            return false;
        }
        return true;
    }

    public boolean isBlank(String parameter){
        if (parameter.isBlank()){
            return false;
        }
        return true;
    }

}
