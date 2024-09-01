package carreiras.com.github.listadecompras.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import carreiras.com.github.listadecompras.data.ItemDao
import carreiras.com.github.listadecompras.data.ItemDatabase
import carreiras.com.github.listadecompras.model.ItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Uma classe ViewModel que estende AndroidViewModel. Esta classe é responsável por gerenciar e preparar os dados para a UI.
 * Ela mantém uma referência para o DAO e um LiveData que contém a lista de itens.
 * A classe também fornece métodos para adicionar e remover itens.
 *
 * @author Ewerton Carreira
 * @version 1.0
 * @since 2023-03-01
 */
class ItemsViewModel(application: Application) : AndroidViewModel(application) {

    // Referência para o DAO que será usado para acessar o banco de dados.
    private val itemDao: ItemDao

    // LiveData que contém a lista de itens. A UI pode observar este LiveData para receber
    // atualizações quando os dados mudarem.
    val itemsLiveData: LiveData<List<ItemModel>>

    init {
        // Cria uma instância do banco de dados Room usando o método Room.databaseBuilder().
        // Este método recebe três parâmetros: o contexto da aplicação, a classe do banco de dados
        // e o nome do banco de dados.
        val database = Room.databaseBuilder(
            getApplication(),
            ItemDatabase::class.java,
            "items_database"
        ).build()

        // Obtém uma referência para o DAO chamando database.itemDao().
        // Esta referência será usada para acessar o banco de dados.
        itemDao = database.itemDao()

        // Inicializa o LiveData com a lista de itens do banco de dados chamando itemDao.getAll().
        itemsLiveData = itemDao.getAll()
    }

    /**
     * Método para adicionar um novo item.
     * Este método é chamado na thread IO, pois pode levar algum tempo para inserir o item no banco de dados.
     * @param item O nome do novo item.
     */
    fun addItem(item: String) {
        // Inicia uma nova corrotina no escopo do ViewModel. As corrotinas são leves e não
        // bloqueiam a thread principal.
        // O Dispatcher.IO é usado para executar a corrotina em uma thread que é otimizada para
        // operações de E/S, como acesso ao banco de dados.
        viewModelScope.launch(Dispatchers.IO) {
            // Cria um novo ItemModel com o nome fornecido.
            val newItem = ItemModel(name = item)
            // Insere o novo item no banco de dados. Como esta operação pode levar algum tempo,
            // ela é executada em uma corrotina para evitar bloquear a thread principal.
            itemDao.insert(newItem)
        }
    }

    /**
     * Método para remover um item.
     * Este método é chamado na thread IO, pois pode levar algum tempo para remover o item do banco de dados.
     * @param item O item a ser removido.
     */
    fun removeItem(item: ItemModel) {
        // Inicia uma nova corrotina no escopo do ViewModel. As corrotinas são leves e não
        // bloqueiam a thread principal.
        // O Dispatcher.IO é usado para executar a corrotina em uma thread que é otimizada para
        // operações de E/S, como acesso ao banco de dados.
        viewModelScope.launch(Dispatchers.IO) {
            // Remove o item do banco de dados. Como esta operação pode levar algum tempo, ela é
            // executada em uma corrotina para evitar bloquear a thread principal.
            itemDao.delete(item)
        }
    }
}