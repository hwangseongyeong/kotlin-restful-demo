package com.larva.restful.demo.domain.master.entity

import javax.persistence.*

@Entity
data class User (
        @Id
        var id: String,
        var name: String,
        var address: String
) {
        constructor() : this("2","2","2")
}
