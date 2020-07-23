package ru.vitaSoft.restController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vitaSoft.service.VitaService;


import java.util.*;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final Logger logger = LoggerFactory.getLogger(RestController.class);

    private final VitaService service;

    public RestController(@Qualifier(value = "sv") VitaService service) {
        this.service = service;
    }

    @PostMapping("json")
    public List<String> getMessages(@RequestBody List<String> list) {
        logger.info("list: " + list.toString());
        return service.getMessages(list);
    }

    @GetMapping("month")
    public String getMonth(@RequestParam int month) {
        logger.info("month: " + month);
        return service.getMonth(month);
    }

}
