package carreiras.com.github.kotlin_android_lista_de_compras

import androidx.lifecycle.ViewModel

/**
 * O objetivo dessa ViewModel será abstrair comportamentos
 * que, até então, estavam sendo feitos na Activity e no Adapter
 * em nosso projeto.
 *
 *
 */
class ItemsViewModel : ViewModel() {

    private var items = mutableListOf<ItemModel>()

    fun addItem(name: String) {
        val item = ItemModel(
            name = name,
            onRemove = ::removeItem
        )

        items.add(item)
    }

    private fun removeItem(item: ItemModel) {
        items.remove(item)
    }
}