package carreiras.com.github.kotlin_android_lista_de_compras

/**
 * ItemModel é uma classe de dados em Kotlin que representa um item na lista de compras.
 * Esta classe contém um id para o item, um nome para o item e uma função de remoção que é chamada quando o item é removido da lista.
 *
 * @property id O identificador único do item. Este é um valor Int que é passado para o construtor da classe.
 * @property name O nome do item. Este é um valor String que é passado para o construtor da classe.
 * @property onRemove Uma função que é chamada quando o item é removido da lista.
 *                    Esta função recebe um ItemModel e não retorna nada.
 *                    O valor padrão é uma função que não faz nada.
 *
 * @author Seu Nome
 * @version 1.0
 * @since 14/09/2021
 */
data class ItemModel(
    val id: Int,
    val name: String,
    val onRemove: (ItemModel) -> Unit
)
