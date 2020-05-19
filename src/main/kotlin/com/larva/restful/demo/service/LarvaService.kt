package com.larva.restful.demo.service

import com.larva.restful.demo.data.LarvaDto
import com.larva.restful.demo.domain.slave.entity.Larva
import com.larva.restful.demo.domain.slave.repository.LarvaRepository
import org.springframework.stereotype.Service

@Service
class LarvaService (
        private val larvaRepository: LarvaRepository
) {

    fun find(id: Int) : LarvaDto {
        val larva: Larva = larvaRepository.findById(id).orElse(Larva(1,"1",1))
        return LarvaDto(larva.id, larva.name, larva.age)
    }

    fun save(larvaDto: LarvaDto) : Larva {
        return larvaRepository.save(
                Larva(larvaDto.id, larvaDto.name, larvaDto.age)
        )
    }

    fun delete(id: Int) : Boolean {
        larvaRepository.deleteById(id)
        return true
    }
}