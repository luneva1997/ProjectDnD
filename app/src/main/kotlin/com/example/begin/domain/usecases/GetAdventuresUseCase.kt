package com.example.begin.domain.usecases

import com.example.begin.data.db.dao.AdventuresDao
import com.example.begin.data.db.entities.Adventure

interface GetAdventuresUseCase {
    operator fun invoke(status: Adventure.Status): List<Adventure>
}

class GetAdventuresUseCaseImpl(
    private val adventuresDao: AdventuresDao,
) : GetAdventuresUseCase {
    override operator fun invoke(status: Adventure.Status): List<Adventure> {
        return adventuresDao.getByStatus(status)
    }
}