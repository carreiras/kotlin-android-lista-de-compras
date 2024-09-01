package carreiras.com.github.listadecompras.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * A fábrica para a criação de instâncias do ViewModel `ItemsViewModel`.
 * Esta classe implementa a interface `ViewModelProvider.Factory` para fornecer uma maneira personalizada de instanciar ViewModels.
 *
 * @property application A instância da aplicação, usada para criar uma instância do `ItemsViewModel`.
 * @author Ewerton Carreira
 * @version 1.0
 * @since 2023-02-01
 */
class ItemsViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    /**
     * Cria uma nova instância do ViewModel especificado.
     * Este método verifica se a classe do ViewModel é `ItemsViewModel` e, em caso afirmativo, cria uma nova instância.
     * Se a classe do ViewModel não for `ItemsViewModel`, uma exceção `IllegalArgumentException` é lançada.
     *
     * @param modelClass A classe do ViewModel a ser instanciada.
     * @return Uma nova instância do ViewModel especificado.
     * @throws IllegalArgumentException Se a classe do ViewModel não for `ItemsViewModel`.
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Verifica se a classe do ViewModel é `ItemsViewModel`.
        if (modelClass.isAssignableFrom(ItemsViewModel::class.java)) {
            // Se for, cria uma nova instância do `ItemsViewModel` e retorna.
            // A anotação `@Suppress("UNCHECKED_CAST")` é usada para suprimir o aviso de cast inseguro.
            @Suppress("UNCHECKED_CAST")
            return ItemsViewModel(application) as T
        }
        // Se a classe do ViewModel não for `ItemsViewModel`, lança uma exceção `IllegalArgumentException`.
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}