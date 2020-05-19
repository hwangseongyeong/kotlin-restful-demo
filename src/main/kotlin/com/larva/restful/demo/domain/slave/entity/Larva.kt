package com.larva.restful.demo.domain.slave.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Larva(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int,
        var name: String,
        var age: Int
) {
    constructor() : this(1,"default",42)
}