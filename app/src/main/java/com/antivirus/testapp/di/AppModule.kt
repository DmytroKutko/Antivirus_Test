package com.antivirus.testapp.di

import android.content.Context
import androidx.room.Room
import com.antivirus.testapp.database.IssueDao
import com.antivirus.testapp.database.IssuesRepositoryImpl
import com.antivirus.testapp.database.LocalDatabase
import com.antivirus.testapp.feature.home.domain.IssuesRepository
import com.antivirus.testapp.feature.home.domain.usecases.GetAllIssues
import com.antivirus.testapp.feature.home.domain.usecases.InsertIssue
import com.antivirus.testapp.feature.home.domain.usecases.IssuesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            LocalDatabase::class.java,
            "local_database"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideIssueDao(database: LocalDatabase) = database.issueDao()


    @Provides
    @Singleton
    fun provideHeroRepository(issueDao: IssueDao): IssuesRepository = IssuesRepositoryImpl(dao = issueDao)

    @Provides
    @Singleton
    fun provideUseCases(repository: IssuesRepository) = IssuesUseCases(
        insertIssue = InsertIssue(repository),
        getAllIssues = GetAllIssues(repository)
    )
}