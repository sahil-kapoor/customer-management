package cn.javis.apms.server.domain;

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
@Table(name = "myapms_property_option")
@Data
public class PropertyOption implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 9036227364991999800L;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @JoinColumn(name = "OPTION_ID")
    @OneToMany(cascade = { CascadeType.ALL })
    private Set<PropertyFactor> factors;

    public boolean isSatisfied(Map<String, String> propertyNameValueMap) {
        for (PropertyFactor factor : factors) {
            if (factor.isSatisfied(propertyNameValueMap)) {
                return true;
            }
        }
        return false;
    }

}
