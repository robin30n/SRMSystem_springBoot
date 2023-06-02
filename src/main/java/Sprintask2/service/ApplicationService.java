package Sprintask2.service;

import Sprintask2.models.ApplicationRequest;
import Sprintask2.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public List<ApplicationRequest> getApplicationRequestList() {
        return applicationRepository.findAll();
    }

    public ApplicationRequest findById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        applicationRepository.deleteById(id);
    }

    public void saveReq(ApplicationRequest app){
        applicationRepository.save(app);
    }

    public void addReq(ApplicationRequest app){
        applicationRepository.save(app);
    }

    public List<ApplicationRequest> handledFalse(){
        return applicationRepository.findAllByHandledFalse();
    }

    public List<ApplicationRequest> handledTrue(){
        return applicationRepository.findAllByHandledTrue();
    }
}
