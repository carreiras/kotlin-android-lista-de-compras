package carreiras.com.github.kotlin_android_lista_de_compras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Classe ItemsAdapter que estende RecyclerView.Adapter.
 * Esta classe é responsável por fornecer a visualização dos itens na lista e manipular os eventos de clique.
 * Utiliza o padrão ViewHolder para melhorar o desempenho ao reutilizar as visualizações dos itens.
 *
 * @author Seu Nome
 * @version 1.0
 * @since 05/08/2021
 *
 */
class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    /**
     * Lista de itens que serão exibidos no RecyclerView.
     * É uma lista mutável para permitir adições e remoções de itens.
     */
    private var items = listOf<ItemModel>()

    /**
     * Classe interna ItemViewHolder que estende RecyclerView.ViewHolder.
     * Esta classe é responsável por fornecer a visualização de um único item na lista.
     * Utiliza o padrão ViewHolder para melhorar o desempenho ao reutilizar as visualizações dos itens.
     */
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        /**
         * TextView que exibe o nome do item.
         * É inicializado usando o método findViewById do objeto View passado para o construtor.
         */
        val textView = view.findViewById<TextView>(R.id.textViewItem)

        /**
         * Botão que, quando clicado, remove o item da lista.
         * É inicializado usando o método findViewById do objeto View passado para o construtor.
         */
        val button = view.findViewById<ImageButton>(R.id.imageButton)

        /**
         * Método que vincula os dados do item à visualização.
         * @param item O item a ser vinculado.
         * Define o texto do TextView para o nome do item.
         * Define um listener de clique para o botão que chama o método onRemove do item.
         */
        fun bind(item: ItemModel) {
            textView.text = item.name

            button.setOnClickListener {
                item.onRemove(item)
            }
        }
    }

    /**
     * Método que cria um novo ItemViewHolder.
     * @param parent O ViewGroup que contém as visualizações.
     * @param viewType O tipo de visualização.
     * @return Um novo ItemViewHolder.
     * Infla a visualização do item usando o LayoutInflater e retorna um novo ItemViewHolder com essa visualização.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    /**
     * Método que retorna o número de itens na lista.
     * @return O número de itens.
     * Retorna o tamanho da lista de itens.
     */
    override fun getItemCount(): Int = items.size

    /**
     * Método que vincula os dados do item à visualização.
     * @param holder O ItemViewHolder.
     * @param position A posição do item na lista.
     * Obtém o item na posição especificada e chama o método bind do ItemViewHolder com esse item.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    /**
     * Método que atualiza a lista de itens e notifica o RecyclerView que os dados foram alterados.
     * @param newItems A nova lista de itens a ser exibida.
     * Atualiza a lista de itens e chama o método notifyDataSetChanged para atualizar a visualização.
     */
    fun updateItems(newItems: List<ItemModel>) {
        items = newItems
        notifyDataSetChanged()
    }
}