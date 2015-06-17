package cn.javis.apms.domain.property;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@AllArgsConstructor
public class PropertyValue implements Comparable<PropertyValue> {

    @JsonIgnore
    private static final LocalDate INFINITE_FUTURE = LocalDate.MAX;
    @JsonIgnore
    private static final LocalDate INFINITE_PAST = LocalDate.MIN;

    private Long id;
    private LocalDate startDate = INFINITE_FUTURE;
    private LocalDate endDate = INFINITE_PAST;
    private Object value;

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
