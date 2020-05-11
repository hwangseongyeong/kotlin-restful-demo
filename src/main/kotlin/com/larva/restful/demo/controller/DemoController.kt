package com.larva.restful.demo.controller

import com.larva.restful.demo.data.Demo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController {

    @GetMapping("/")
    fun demo(@RequestParam(value = "id", defaultValue = "larva") id: String,
             @RequestParam(value = "name", defaultValue = "seongyeong") name: String) =
            Demo(id, name)

}