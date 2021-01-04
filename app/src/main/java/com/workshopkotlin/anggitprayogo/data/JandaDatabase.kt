package com.workshopkotlin.anggitprayogo.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.workshopkotlin.anggitprayogo.data.dao.ProductDao
import com.workshopkotlin.anggitprayogo.data.dao.PurchaseDao
import com.workshopkotlin.anggitprayogo.data.dao.UserDao
import com.workshopkotlin.anggitprayogo.data.entity.ProductEntity
import com.workshopkotlin.anggitprayogo.data.entity.PurchaseEntity
import com.workshopkotlin.anggitprayogo.data.entity.UserEntity

@Database(entities = [UserEntity::class, ProductEntity::class, PurchaseEntity::class], version = 3)
abstract class JandaDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun productDao(): ProductDao

    abstract fun purchaseDao(): PurchaseDao

    companion object {
        @Volatile
        private var instances: JandaDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instances ?: synchronized(LOCK) {
            instances ?: buildDatabase(context).also { instances = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            JandaDatabase::class.java, "janda_database.db"
        ).fallbackToDestructiveMigration().setJournalMode(JournalMode.TRUNCATE).build()
    }
}