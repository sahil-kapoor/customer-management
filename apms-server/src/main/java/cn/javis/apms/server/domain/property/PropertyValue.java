package cn.javis.apms.server.domain.property;

import java.time.LocalDate;

import lombok.Data;
import cn.javis.apms.server.LocalDateSerializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Data
public class PropertyValue<E> implements Comparable<PropertyValue<E>> {

    @JsonIgnore
    protected static final LocalDate INFINITE_FUTURE = LocalDate.MAX;
    @JsonIgnore
    protected static final LocalDate INFINITE_PAST = LocalDate.MIN;

//    private Long id;
    @JsonSerialize(using = LocalDateSerializer.class)
    protected LocalDate startDate = INFINITE_FUTURE;
    @JsonSerialize(using = LocalDateSerializer.class)
    protected LocalDate endDate = INFINITE_PAST;

    protected E value;

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
