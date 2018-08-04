package com.iem.safety.iembackend.expectenvir;

import com.iem.safety.iembackend.utils.Message;
import org.springframework.web.bind.annotation.*;

/**
 * @author MengQi 2018-06-20 15:24
 */
@RestController
@RequestMapping("ExpectEnvir")
public class ExpectEnvirController {

    private final ExpectEnvirService service;
    private final ExpectEnvirRepository repository;

    public ExpectEnvirController(ExpectEnvirService service, ExpectEnvirRepository repository) {
        this.service = service;
        this.repository = repository;
    }


    @RequestMapping(value = "getByAssessId", method = RequestMethod.GET)
    public Message getByAssessId(@RequestParam("id") String assessId) {
        return service.getByAssessId(assessId);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ExpectEnvir save(@RequestBody ExpectEnvir expectEnvir) {
        return repository.save(expectEnvir);
    }
}
