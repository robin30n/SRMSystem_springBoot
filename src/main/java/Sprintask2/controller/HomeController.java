package Sprintask2.controller;

import Sprintask2.models.ApplicationRequest;
import Sprintask2.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ApplicationService applicationService;
    @GetMapping(value = "/")
    public String indexPage(Model model){
        model.addAttribute("requests",applicationService.getApplicationRequestList());
        return "main-page";
    }

    @GetMapping(value = "/req_page/{id}")
    public String appPage(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("req", applicationService.findById(id));
        return "details";
    }

    @PostMapping(value = "/delete-req")
    public String deleteReq(@RequestParam(name = "id") Long id){
        applicationService.deleteById(id);
        return "redirect:/";
    }

    @PostMapping(value = "/handledReq")
    public String checkApp(@RequestParam(name = "id") Long id){
        ApplicationRequest applicationRequest = applicationService.findById(id);
        applicationRequest.setHandled(true);
        applicationService.saveReq(applicationRequest);
        return "redirect:/";
    }

    @GetMapping(value = "/addReq")
    public String addRequest(){
        return "add-request";
    }

    @PostMapping(value = "addReq")
    public String addRequest(ApplicationRequest applicationRequest){
        applicationService.saveReq(applicationRequest);
        return "redirect:/";
    }

    @GetMapping(value = "/handled")
    public String handled(Model model){
        model.addAttribute("handled",applicationService.handledTrue());
        return "handled";
    }

    @GetMapping(value = "/unhandled")
    public String unHandled(Model model){
        model.addAttribute("handled",applicationService.handledFalse());
        return "handled";
    }
}
