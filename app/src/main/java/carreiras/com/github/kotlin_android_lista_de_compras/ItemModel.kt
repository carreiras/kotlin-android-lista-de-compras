package carreiras.com.github.kotlin_android_lista_de_compras

data class ItemModel(
    val name: String,
    val onRemove: (ItemModel) -> Unit = { _ -> }
)
