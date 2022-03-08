package demo.graphql.types;

import demo.entities.PizzaEntity
import java.math.BigDecimal
import java.util.*

class Pizza(
    val id: UUID,
    val name: String,
    val price: BigDecimal
) {
    constructor(entity: PizzaEntity) : this(
        id = entity.id,
        name = entity.name,
        price = entity.price,
    )
}
