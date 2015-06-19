package cn.javis.apms.domain;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "myapms_property_factor")
@Data
public class PropertyFactor implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 8405101729570250103L;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "OPTION_ID")
    @JoinColumn(name = "FACTOR_ID")
    @OneToMany(cascade = { CascadeType.ALL })
    private Set<PropertyCondition> conditions;

    public boolean isSatisfied(Map<String, String> propertyNameValueMap) {
        for (PropertyCondition condition : conditions) {
            String propertyName = condition.getPropertyName();
            String propertyValue = propertyNameValueMap.get(propertyName);
            if (!condition.isSatisfied(propertyValue)) {
                return false;
            }
        }
        return true;
    }
}
