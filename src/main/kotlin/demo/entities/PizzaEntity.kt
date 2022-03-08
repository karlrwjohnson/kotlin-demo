package demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "pizza")
class PizzaEntity(
    @Id
    @GeneratedValue
    val id:  UUID = UUID.randomUUID(),

    @Column(name = "name")
    val name: String,

    @Column(name = "price")
    val price: BigDecimal,
)
