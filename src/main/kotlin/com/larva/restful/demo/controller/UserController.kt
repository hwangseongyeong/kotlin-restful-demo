package com.larva.restful.demo.controller

import com.larva.restful.demo.data.User
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.*

@Api(value = "User CRUD", tags = ["User"])
@RestController
@RequestMapping("/api/user")
class UserController {

    @GetMapping("/{id}")
    fun get(@PathVariable(value = "id", required = true) id: String )
            = User("larva","황성영", "홍제동")

    @PostMapping
    fun post(@RequestBody user: User)
            = User(user.id, user.name, user.address)

    @PutMapping("/{id}")
    fun put(@RequestBody user: User, @PathVariable(value = "id", required = true) id: String)
            = User(id,user.name, user.address)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id", required = true) id: String)
            = User(id,"황성영", "홍제동")
}