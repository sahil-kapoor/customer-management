package cn.javis.apms.helper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import cn.javis.apms.domain.PropertyCondition;
import cn.javis.apms.domain.PropertyDefinition;
import cn.javis.apms.service.PropertyDefinitionService;
import cn.javis.apms.service.exception.PropertyDefinitionNotFoundException;

public final class PropertyDefinitionEvaluator {

    private static PropertyDefinitionService propertyDefinitionService;

    @Autowired
    public PropertyDefinitionEvaluator(PropertyDefinitionService propertyDefinitionService) {
        PropertyDefinitionEvaluator.propertyDefinitionService = propertyDefinitionService;
    }

    public static boolean eval(String strValue, PropertyCondition condition) throws PropertyDefinitionNotFoundException {
        String propertyName = condition.getPropertyName();
        PropertyDefinition pd = propertyDefinitionService.getPropertyDefinition(propertyName);
        switch (pd.getDateType()) {
            case BOOLEAN: {
                return compareBoolean(strValue, condition);
            }
            case DATE: {
                return compareDate(strValue, condition);
            }
            case DECIMAL:
            case INTEGER: {
                return compareNumer(strValue, condition);
            }
            case STRING: {
                return compareString(strValue, condition);
            }
        }
        return false;
    }

    private static boolean compareString(String strValue, PropertyCondition condition) {
        String propertyValue = condition.getPropertyValues();
        switch (condition.getCondition()) {
            case EQ: {
                return strValue.equals(propertyValue);
            }
            case NOT_EQ: {
                return !strValue.equals(propertyValue);
            }
            case IN: {
                for (String str : propertyValue.split(",")) {
                    if (strValue.equals(str)) {
                        return true;
                    }
                }
                return false;
            }
            case NOT_IN: {
                for (String str : propertyValue.split(",")) {
                    if (strValue.equals(str)) {
                        return false;
                    }
                }
                return true;
            }
            case REGEX: {
                Pattern pattern = Pattern.compile(propertyValue);
                return pattern.matcher(strValue).matches();
            }
            default: {
                return false;
            }
        }
    }

    private static boolean compareNumer(String strValue, PropertyCondition condition) {
        BigDecimal value = new BigDecimal(strValue);
        BigDecimal propertyValue = null;
        try {
            propertyValue = new BigDecimal(condition.getPropertyValues());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (condition.getCondition()) {
            case EQ: {
                return value.compareTo(propertyValue) == 0;
            }
            case NOT_EQ: {
                return value.compareTo(propertyValue) != 0;
            }
            case GT: {
                return value.compareTo(propertyValue) > 0;
            }
            case GET: {
                return value.compareTo(propertyValue) >= 0;
            }
            case LT: {
                return value.compareTo(propertyValue) < 0;
            }
            case LET: {
                return value.compareTo(propertyValue) <= 0;
            }
            case IN: {
                for (String decimal : condition.getPropertyValues().split(",")) {
                    propertyValue = new BigDecimal(decimal);
                    if (value.compareTo(propertyValue) == 0) {
                        return true;
                    }
                }
                return false;
            }
            case NOT_IN: {
                for (String decimal : condition.getPropertyValues().split(",")) {
                    propertyValue = new BigDecimal(decimal);
                    if (value.compareTo(propertyValue) == 0) {
                        return false;
                    }
                }
                return true;
            }
            default:
                break;
        }
        return false;
    }

    private static boolean compareBoolean(String strValue, PropertyCondition condition) {
        boolean value = Boolean.valueOf(strValue);
        boolean propertyValue = Boolean.valueOf(condition.getPropertyValues());
        switch (condition.getCondition()) {
            case EQ: {
                return propertyValue == value;
            }
            case NOT_EQ: {
                return propertyValue != value;
            }
            default: {
                return false;
            }
        }
    }

    private static boolean compareDate(String strValue, PropertyCondition condition) {
        LocalDate value = LocalDate.parse(strValue);
        LocalDate propertyValue = null;
        try {
            propertyValue = LocalDate.parse(condition.getPropertyValues());
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        switch (condition.getCondition()) {
            case EQ: {
                return value.compareTo(propertyValue) == 0;
            }
            case NOT_EQ: {
                return value.compareTo(propertyValue) != 0;
            }
            case GT: {
                return value.compareTo(propertyValue) > 0;
            }
            case GET: {
                return value.compareTo(propertyValue) >= 0;
            }
            case LT: {
                return value.compareTo(propertyValue) < 0;
            }
            case LET: {
                return value.compareTo(propertyValue) <= 0;
            }
            case IN: {
                for (String date : condition.getPropertyValues().split(",")) {
                    propertyValue = LocalDate.parse(date);
                    if (value.compareTo(propertyValue) == 0) {
                        return true;
                    }
                }
                return false;
            }
            case NOT_IN: {
                for (String date : condition.getPropertyValues().split(",")) {
                    propertyValue = LocalDate.parse(date);
                    if (value.compareTo(propertyValue) == 0) {
                        return false;
                    }
                }
                return true;
            }
            default:
                break;
        }
        return false;
    }
}
