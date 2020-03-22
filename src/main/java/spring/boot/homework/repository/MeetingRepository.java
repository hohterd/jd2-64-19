package spring.boot.homework.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.boot.homework.entity.Meeting;

@Repository
public interface MeetingRepository extends CrudRepository<Meeting, Long> {

    Meeting getAllEById(Long id);
}
