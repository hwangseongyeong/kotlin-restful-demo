package com.larva.restful.demo.domain

import javax.persistence.*

@Entity
data class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: String,
        @Column(nullable = false)
        var name: String,
        @Column(nullable = false)
        var address: String
)