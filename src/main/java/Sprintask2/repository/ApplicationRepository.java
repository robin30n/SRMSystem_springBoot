package Sprintask2.repository;

import Sprintask2.models.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<ApplicationRequest, Long> {
    public List<ApplicationRequest> findAllByHandledFalse();

    public List<ApplicationRequest> findAllByHandledTrue();
}
