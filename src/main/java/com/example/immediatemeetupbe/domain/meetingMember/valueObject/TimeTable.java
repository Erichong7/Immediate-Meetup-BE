package com.example.immediatemeetupbe.domain.meetingMember.valueObject;

import com.example.immediatemeetupbe.domain.meetingMember.entity.MeetingMember;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class TimeTable {

    private final LinkedHashMap<LocalDateTime, Integer> timeTable;
    private LocalDateTime currentDateTime;
    private LocalDateTime lastDateTime;

    public TimeTable() {
        this.timeTable = new LinkedHashMap<>();
    }


    public void setTimeTable(LocalDateTime firstDateTime, LocalDateTime lastDateTime) {
        this.currentDateTime = firstDateTime;
        this.lastDateTime = lastDateTime;
        while (currentDateTime.isBefore(lastDateTime) || currentDateTime.isEqual(
            lastDateTime)) {
            timeTable.put(currentDateTime, 0);
            currentDateTime = currentDateTime.plusMinutes(30);
        }
    }
    
    public void calculateSchedule(List<MeetingMember> meetingMemberList) {
        meetingMemberList.forEach(meetingMember ->
            Arrays.stream(meetingMember.getTimeZone().split("/"))
                .map(LocalDateTime::parse)
                .forEach(timezone -> timeTable.put(timezone, timeTable.get(timezone) + 1))
        );
    }
}
