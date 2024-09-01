package carreiras.com.github.listadecompras.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import carreiras.com.github.listadecompras.model.ItemModel

@Dao
interface ItemDao {

    @Query("SELECT * FROM ItemModel")
    fun getAll(): LiveData<List<ItemModel>>

    @Insert
    fun insert(item: ItemModel)

    @Delete
    fun delete(item: ItemModel)
}