package carreiras.com.github.kotlin_android_lista_de_compras

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ItemsViewModel é uma classe que estende ViewModel.
 * Esta classe gerencia uma lista de ItemModel. Ela contém métodos para adicionar e remover itens da lista.
 * A lista de itens é exposta através de um LiveData.
 *
 * @property items Uma lista mutável de ItemModel. Esta lista é privada e só pode ser modificada através dos métodos addItem e removeItem.
 * @property itemsLiveData Um MutableLiveData que contém a lista de itens. Este LiveData é público e pode ser observado para receber atualizações quando a lista de itens é modificada.
 *
 * @author Ewerton Carreira
 * @version 1.0
 * @since 05/08/2021
 */
class ItemsViewModel : ViewModel() {

    /**
     * Uma lista mutável de ItemModel. Esta lista é privada e só pode ser modificada através dos métodos addItem e removeItem.
     */
    private var items = mutableListOf<ItemModel>()

    /**
     * Um MutableLiveData que contém a lista de itens. Este LiveData é público e pode ser observado para receber atualizações quando a lista de itens é modificada.
     */
    val itemsLiveData = MutableLiveData<List<ItemModel>>()

    /**
     * Este método é responsável por adicionar um novo item à lista.
     * Ele cria um novo ItemModel e o adiciona à lista de itens.
     *
     * @param name O nome do item a ser adicionado.
     */
    fun addItem(name: String) {

        /**
         * Este bloco de código é responsável por adicionar um novo item à lista.
         * Ele cria um novo ItemModel e o adiciona à lista de itens.
         */
        val item = ItemModel(
            id = 0,
            name = name,
            onRemove = ::removeItem
        )

        /**
         * Observa as alterações na lista de itens na ViewModel.
         * Quando a lista de itens é alterada, atualiza o ItemsAdapter com a nova lista.
         */
        if (!items.contains(item)) {
            items.add(item)
            itemsLiveData.value = items
        }
    }

    /**
     * Este método é responsável por remover um item da lista.
     * Ele remove o item da lista de itens.
     *
     * @param item O item a ser removido.
     */
    private fun removeItem(item: ItemModel) {
        items.remove(item)
        itemsLiveData.value = items
    }
}