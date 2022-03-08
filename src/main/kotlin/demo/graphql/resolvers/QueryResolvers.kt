package demo.graphql.resolvers

import demo.graphql.types.Pizza
import demo.service.PizzaService
import kotlinx.coroutines.delay
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class QueryResolvers(
    val pizzaService: PizzaService
) {
    @SchemaMapping(typeName = "Query")
    fun test() = true

    @SchemaMapping(typeName = "Query")
    suspend fun testAsync(@Argument delayMs: Long): Boolean {
        delay(delayMs)
        return true;
    }

    @SchemaMapping(typeName = "Query")
    suspend fun pizzas(): List<Pizza> = pizzaService.listPizzas()
}
