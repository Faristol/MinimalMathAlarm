package com.faristol.minimalmathalarm.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.faristol.minimalmathalarm.AlarmApp
import com.faristol.minimalmathalarm.data.repository.AlarmRepository
import com.faristol.minimalmathalarm.data.repository.AlarmRepositoryImpl
import com.faristol.minimalmathalarm.data.source.local.AlarmDatabase
import com.faristol.minimalmathalarm.domain.mapper.AlarmMapper
import com.faristol.minimalmathalarm.domain.mapper.AlarmMapperImpl
import com.faristol.minimalmathalarm.domain.usecase.DeleteAlarmUseCase
import com.faristol.minimalmathalarm.domain.usecase.GetAlarmByIdUseCase
import com.faristol.minimalmathalarm.domain.usecase.GetAllAlarmsUseCase
import com.faristol.minimalmathalarm.domain.usecase.InsertAlarmUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAlarmDatabase(app: Application): AlarmDatabase {
        return Room.databaseBuilder(app, AlarmDatabase::class.java, "alarm_db").build()
    }

    @Provides
    @Singleton
    fun provideAlarmRepository(db: AlarmDatabase): AlarmRepository {
        return AlarmRepositoryImpl(db.dao)
    }

    @Provides
    @Singleton
    fun provideAlarmMapper() : AlarmMapper{
        return AlarmMapperImpl()
    }

    @Provides
    @Singleton
    fun provideDeleteAlarmUseCase(repo: AlarmRepository, mapper: AlarmMapper) : DeleteAlarmUseCase{
        return DeleteAlarmUseCase(repo,mapper)
    }
    @Provides
    @Singleton
    fun provideGetAlarmByIdUseCase (repo: AlarmRepository, mapper: AlarmMapper) : GetAlarmByIdUseCase{
        return GetAlarmByIdUseCase(repo,mapper)
    }
    @Provides
    @Singleton
    fun provideGetAllAlarmsUseCase(repo: AlarmRepository, mapper: AlarmMapper) : GetAllAlarmsUseCase{
        return GetAllAlarmsUseCase(repo,mapper)
    }
    @Provides
    @Singleton
    fun provideInsertAlarmUseCase(repo: AlarmRepository, mapper: AlarmMapper) : InsertAlarmUseCase {
        return InsertAlarmUseCase(repo,mapper)
    }


}