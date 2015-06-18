package cn.javis.apms.domain.property;

import java.time.LocalDate;

import lombok.Data;
import cn.javis.apms.LocalDateSerializer;
import cn.javis.apms.domain.DataType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Data
public class PropertyValue<E> implements Comparable<PropertyValue> {

    @JsonIgnore
    private static final LocalDate INFINITE_FUTURE = LocalDate.MAX;
    @JsonIgnore
    private static final LocalDate INFINITE_PAST = LocalDate.MIN;

//    private Long id;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate startDate = INFINITE_FUTURE;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate endDate = INFINITE_PAST;

    @JsonIgnore
    private DataType targetDataType; // used for money converter, currently not used.   
    private E value;

    public boolean within(LocalDate date) {
        return date.compareTo(startDate) >= 0
                && date.compareTo(endDate) <= 0;
    }

    public boolean within(LocalDate startDate, LocalDate endDate) {
        return !((this.startDate.compareTo(endDate) >= 0) || (this.endDate.compareTo(startDate) <= 0));
    }

    @Override
    public int compareTo(PropertyValue o) {
        int startCompare = this.startDate.compareTo(o.startDate);
        if (startCompare == 0) {
            return this.endDate.compareTo(o.endDate);
        }
        return startCompare;
    }

}
