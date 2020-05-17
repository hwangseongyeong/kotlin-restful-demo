package com.larva.restful.demo.controller

import com.larva.restful.demo.data.UserDto
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.*

@Api(value = "User CRUD", tags = ["User"])
@RestController
@RequestMapping("/api/user")
class UserController {

    @GetMapping("/{id}")
    fun get(@PathVariable(value = "id", required = true) id: String )
            = UserDto("larva","황성영", "홍제동")

    @PostMapping
    fun post(@RequestBody user: UserDto)
            = UserDto(user.id, user.name, user.address)

    @PutMapping("/{id}")
    fun put(@RequestBody user: UserDto, @PathVariable(value = "id", required = true) id: String)
            = UserDto(id,user.name, user.address)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id", required = true) id: String)
            = UserDto(id,"황성영", "홍제동")
}