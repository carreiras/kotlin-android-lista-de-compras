package carreiras.com.github.listadecompras

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ItemModel::class], version = 1)
abstract class ItemDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao
}