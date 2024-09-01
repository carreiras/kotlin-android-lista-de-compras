package carreiras.com.github.listadecompras.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Uma classe de modelo de dados que representa um item na lista de compras.
 * Esta classe é anotada com @Entity, indicando que ela representa uma tabela no banco de dados.
 * Cada instância da classe representa uma linha na tabela.
 * A classe é uma data class do Kotlin, o que significa que ela gera automaticamente métodos úteis, como equals(), hashCode() e toString().
 *
 * @author Ewerton Carreira
 * @version 1.0
 * @since 2023-03-01
 */
@Entity // Anotação que indica que esta classe é uma entidade, ou seja, uma tabela no banco de dados.
data class ItemModel(

    /**
     * A chave primária da tabela. Cada item na tabela terá um ID único.
     * A anotação @PrimaryKey indica que este campo é a chave primária da tabela.
     * A propriedade autoGenerate é definida como true, o que significa que o Room irá gerar automaticamente um valor único para cada novo item.
     */
    @PrimaryKey(autoGenerate = true)    // Anotação que indica que este campo é a chave primária da tabela.
    val id: Int = 0,    // O valor padrão é 0, mas será substituído pelo valor gerado automaticamente pelo Room.

    /**
     * O nome do item. Este campo será preenchido pelo usuário.
     * Não há anotações especiais neste campo, então ele será uma coluna regular na tabela.
     */
    val name: String
)
