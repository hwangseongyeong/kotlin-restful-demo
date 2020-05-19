package com.larva.restful.demo.domain.slave.repository

import com.larva.restful.demo.domain.slave.entity.Larva
import org.springframework.data.repository.CrudRepository

interface LarvaRepository: CrudRepository<Larva, Int> {
}