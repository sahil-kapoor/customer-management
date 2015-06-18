package cn.javis.apms.helper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.javis.apms.domain.EmployeeProperty;
import cn.javis.apms.domain.PropertyDefinition;
import cn.javis.apms.domain.property.PropertyValue;
import cn.javis.apms.service.PropertyDefinitionService;
import cn.javis.apms.service.exception.PropertyDefinitionNotFoundException;

@Component
public final class PropertyValueConverter {

    private static PropertyDefinitionService propertyDefinitionService;

    @Autowired
    public PropertyValueConverter(PropertyDefinitionService propertyDefinitionService) {
        PropertyValueConverter.propertyDefinitionService = propertyDefinitionService;
    }

    public static PropertyValue<?> fromEmployeeProperty(EmployeeProperty property)
            throws PropertyDefinitionNotFoundException {
        PropertyDefinition pd = propertyDefinitionService.getPropertyDefinition(property.getName());
        switch (pd.getDateType()) {
            case BOOLEAN:
                PropertyValue<Boolean> bool = new PropertyValue<Boolean>();
                bool.setStartDate(property.getStartDate());
                bool.setEndDate(property.getEndDate());
                bool.setValue(Boolean.valueOf(property.getValue()));
                return bool;
            case MONEY_JPY:
            case MONEY_CNY:
            case MONEY_SGD:
            case MONEY_USD:
            case DECIMAL:
                PropertyValue<BigDecimal> bigdeicmal = new PropertyValue<BigDecimal>();
                bigdeicmal.setStartDate(property.getStartDate());
                bigdeicmal.setEndDate(property.getEndDate());
                bigdeicmal.setValue(new BigDecimal(property.getValue()));
                return bigdeicmal;
            case INTEGER:
                PropertyValue<Integer> integer = new PropertyValue<Integer>();
                integer.setStartDate(property.getStartDate());
                integer.setEndDate(property.getEndDate());
                integer.setValue(Integer.valueOf(property.getValue()));
                return integer;
            case DATE:
                PropertyValue<String> date = new PropertyValue<String>();
                date.setStartDate(property.getStartDate());
                date.setEndDate(property.getEndDate());
                LocalDate localDate = LocalDate.parse(property.getValue());
                date.setValue(localDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
                return date;
            case STRING:
            default:
                PropertyValue<String> string = new PropertyValue<String>();
                string.setStartDate(property.getStartDate());
                string.setEndDate(property.getEndDate());
                string.setValue(property.getValue());
                return string;
        }

    }

}