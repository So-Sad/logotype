package com.softarex.app.logotype.controller;

import com.softarex.app.logotype.entity.Response;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResponseController {

    @MessageMapping("/response")
    @SendTo("/topic/responses")
    public Response getResponses(Response response) {
        return response;
    }

    @GetMapping("/responses")
    public String responsesPage() {
        return "responses";
    }

}
