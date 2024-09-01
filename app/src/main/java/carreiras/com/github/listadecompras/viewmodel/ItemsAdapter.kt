package carreiras.com.github.listadecompras.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import carreiras.com.github.kotlin_android_lista_de_compras.R
import carreiras.com.github.listadecompras.model.ItemModel

/**
 * Uma classe Adapter que estende RecyclerView.Adapter. Esta classe é responsável por fornecer os dados e criar cada item na lista.
 * Ela mantém uma lista de ItemModel e um callback para quando um item é removido.
 *
 * @property onItemRemoved Callback que é chamado quando um item é removido.
 * @property items Lista de itens que serão exibidos no RecyclerView.
 * @author Ewerton Carreira
 * @version 1.0
 * @since 2023-03-01
 */
class ItemsAdapter(private val onItemRemoved: (ItemModel) -> Unit) :
    RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    // Lista de itens que serão exibidos no RecyclerView.
    private var items = listOf<ItemModel>()

    /**
     * Uma classe interna ViewHolder que estende RecyclerView.ViewHolder.
     * Esta classe é responsável por manter as referências para as views de cada item e preencher os dados.
     *
     * @property textView Referência para a view TextView de cada item.
     * @property button Referência para a view ImageButton de cada item.
     */
    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // Referências para as views de cada item.
        val textView = view.findViewById<TextView>(R.id.textViewItem)
        val button = view.findViewById<ImageButton>(R.id.imageButton)

        /**
         * Método que preenche os dados nas views.
         * @param item O item que será exibido neste ViewHolder.
         */
        fun bind(item: ItemModel) {
            // Define o texto do TextView para o nome do item.
            textView.text = item.name
            // Define um listener para o botão, que chama o callback onItemRemoved quando clicado
            button.setOnClickListener {
                onItemRemoved(item)
            }
        }
    }

    /**
     * Método chamado quando o RecyclerView precisa de um novo ViewHolder.
     * Este método infla o layout do item e cria um novo ViewHolder.
     *
     * @param parent O ViewGroup no qual o novo View será adicionado após ser vinculado a uma posição de adaptador.
     * @param viewType O tipo de view do novo View.
     * @return Um novo ViewHolder que contém uma View do tipo de view fornecido.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // Infla o layout do item.
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        // Cria e retorna um novo ViewHolder.
        return ItemViewHolder(view)
    }

    /**
     * Método que retorna a quantidade de itens que serão exibidos.
     * @return A quantidade de itens na lista.
     */
    override fun getItemCount(): Int = items.size

    /**
     * Método chamado pelo RecyclerView para exibir os dados na posição especificada.
     * Este método atualiza o conteúdo do ViewHolder para refletir o item na posição dada.
     *
     * @param holder O ViewHolder que deve ser atualizado para representar o conteúdo do item na posição fornecida no conjunto de dados.
     * @param position A posição do item dentro do conjunto de dados do adaptador.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    /**
     * Método chamado para atualizar a lista de itens que serão exibidos.
     * Este método atualiza a lista de itens e notifica o RecyclerView que os dados mudaram.
     *
     * @param newItems A nova lista de itens que serão exibidos.
     */
    fun updateItems(newItems: List<ItemModel>) {
        // Atualiza a lista de itens.
        items = newItems
        // Notifica o RecyclerView que os dados mudaram.
        notifyDataSetChanged()
    }
}