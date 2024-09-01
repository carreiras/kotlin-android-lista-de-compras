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

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    /**
     * Método chamado para exibir os dados em um ViewHolder.
     * @param holder O ViewHolder que terá seus dados preenchidos.
     * @param position A posição do item na lista.
     */
    fun updateItems(newItems: List<ItemModel>) {
        // Obtém o item na posição especificada.
        items = newItems
        // Preenche os dados no ViewHolder.
        notifyDataSetChanged()
    }
}