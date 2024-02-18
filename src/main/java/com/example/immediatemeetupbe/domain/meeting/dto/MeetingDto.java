package com.example.immediatemeetupbe.domain.meeting.dto;

import com.example.immediatemeetupbe.domain.meeting.entity.Meeting;
import lombok.Getter;

@Getter
public class MeetingDto {

    private final Long id;
    private final String title;
    private final String content;
    private final String firstDay;
    private final String lastDay;
    private final String place;
    private final String timeZone;

    public MeetingDto(Long id, String title, String content, String firstDay, String lastDay,
        String place, String timeZone) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.firstDay = firstDay;
        this.lastDay = lastDay;
        this.place = place;
        this.timeZone = timeZone;
    }

    public static MeetingDto from(Meeting meeting) {
        return new MeetingDto(meeting.getId(), meeting.getTitle(), meeting.getContent(),
            meeting.getFirstDay(), meeting.getLastDay(), meeting.getPlace(), meeting.getTimeZone());
    }
}
