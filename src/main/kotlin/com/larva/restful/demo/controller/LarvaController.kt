package com.larva.restful.demo.controller

import com.larva.restful.demo.data.LarvaDto
import com.larva.restful.demo.service.LarvaService
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.*

@Api(value = "Larva CRUD", tags = ["Larva"])
@RestController
@RequestMapping("/api/larva")
class LarvaController (
        private val larvaService: LarvaService
) {

    @GetMapping("/{id}")
    fun get(@PathVariable(value = "id", required = true) id: Int )
            = larvaService.find(id)

    @PostMapping
    fun post(@RequestBody larvaDto: LarvaDto)
            = larvaService.save(larvaDto)

    @PutMapping
    fun put(@RequestBody larvaDto: LarvaDto, @PathVariable(value = "id", required = true) id: Int)
            = larvaService.save(larvaDto)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id", required = true) id: Int)
            = larvaService.delete(id)
}