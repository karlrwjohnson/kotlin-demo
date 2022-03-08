package demo.data;

import demo.entities.PizzaEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository;
import java.util.*

@Repository
interface PizzaRepository: CrudRepository<PizzaEntity, UUID>
