package com.example.begin.domain.usecases

import com.example.begin.data.db.dao.AdventuresDao
import com.example.begin.data.db.entities.Adventure

interface CreateAdventureUseCase {
    operator fun invoke(adventure: Adventure)
}

class CreateAdventureUseCaseImpl(
    private val adventuresDao: AdventuresDao,
) : CreateAdventureUseCase {
    override fun invoke(adventure: Adventure) {
        adventuresDao.create(adventure)
    }
}