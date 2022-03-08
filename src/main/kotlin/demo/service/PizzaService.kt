package demo.service;

import demo.data.PizzaRepository
import demo.entities.PizzaEntity
import demo.graphql.types.Pizza
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
class PizzaService (
    val pizzaRepository: PizzaRepository
) {
    suspend fun listPizzas(): List<Pizza> {
        // `withContext(IO) { ... }` should wrap all database calls
        val entities: Iterable<PizzaEntity> = withContext(IO) { pizzaRepository.findAll() }

        // The GraphQL and database layers each have their own types.
        // They're identical in this simple example, but a mature application may need to make a distinction
        return entities.map(::Pizza)
    }
}
