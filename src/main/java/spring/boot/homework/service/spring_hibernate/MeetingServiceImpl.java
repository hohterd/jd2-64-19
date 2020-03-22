package spring.boot.homework.service.spring_hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.homework.entity.Meeting;
import spring.boot.homework.repository.MeetingRepository;

import java.io.Serializable;
import java.util.Optional;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    @Override
    public Meeting add(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public Meeting update(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public Meeting get(Serializable id) {
        Optional<Meeting> meeting = meetingRepository.findById(Long.valueOf(id.toString()));
        return meeting.orElse(null);
    }

    @Override
    public void remove(Serializable id) {
            meetingRepository.deleteById(Long.valueOf(id.toString()));
    }
}
