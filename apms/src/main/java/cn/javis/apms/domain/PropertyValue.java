package cn.javis.apms.domain;

import java.time.LocalDate;

import lombok.Getter;
import cn.javis.apms.serialize.LocalDateSerializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * This used for transmit through network in JSON.
 * */
public class PropertyValue implements Comparable<PropertyValue> {
    @JsonIgnore
    private static final LocalDate INFINITE_FUTURE = LocalDate.MAX;
    @JsonIgnore
    private static final LocalDate INFINITE_PAST = LocalDate.MIN;

    public PropertyValue(LocalDate start, LocalDate end, Object value) {
        this.startDate = start;
        this.endDate = end;
        this.value = value;
    }

    @Getter
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate startDate;

    @Getter
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate endDate;

    @Getter
    private Object value;

    public boolean within(LocalDate date) {
        return date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0;
    }

    public boolean within(LocalDate startDate, LocalDate endDate) {
        return !((this.startDate.compareTo(endDate) >= 0) || (this.endDate
                .compareTo(startDate) <= 0));
    }

    @Override
    public int compareTo(PropertyValue o) {
        int startDataCompare = this.startDate.compareTo(o.startDate);
        if (startDataCompare == 0) {
            return this.endDate.compareTo(o.endDate);
        }
        return startDataCompare;
    }

}
