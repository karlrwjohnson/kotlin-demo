package demo.graphql

import graphql.language.FloatValue
import graphql.language.IntValue
import graphql.language.StringValue
import graphql.schema.Coercing
import graphql.schema.CoercingParseLiteralException
import graphql.schema.GraphQLScalarType
import java.math.BigDecimal
import java.math.BigInteger

private val USD_COERCER = object : Coercing<BigDecimal, String> {
    /**
     * Called to convert a Java object result of a DataFetcher to a valid runtime value for the scalar type.
     *
     * Note : Throw {@link graphql.schema.CoercingSerializeException} if there is fundamental
     * problem during serialisation, don't return null to indicate failure.
     *
     * Note : You should not allow {@link java.lang.RuntimeException}s to come out of your serialize method, but rather
     * catch them and fire them as {@link graphql.schema.CoercingSerializeException} instead as per the method contract.
     *
     * @param dataFetcherResult is never null
     *
     * @return a serialized value which may be null.
     *
     * @throws graphql.schema.CoercingSerializeException if value input can't be serialized
     */
    override fun serialize(dataFetcherResult: Any): String =
        dataFetcherResult.toString()

    /**
     * Called to resolve an input from a query variable into a Java object acceptable for the scalar type.
     *
     * Note : You should not allow {@link java.lang.RuntimeException}s to come out of your parseValue method, but rather
     * catch them and fire them as {@link graphql.schema.CoercingParseValueException} instead as per the method contract.
     *
     * @param input is never null
     *
     * @return a parsed value which is never null
     *
     * @throws graphql.schema.CoercingParseValueException if value input can't be parsed
     */
    override fun parseValue(input: Any): BigDecimal =
        when (input) {
            is BigDecimal -> input
            is BigInteger -> input.toBigDecimal()
            is Double -> input.toBigDecimal()
            is Float -> input.toBigDecimal()
            is Int -> input.toBigDecimal()
            is String ->
                try {
                    BigDecimal(input)
                } catch (e: RuntimeException) {
                    throw CoercingParseLiteralException(e)
                }
            else -> throw CoercingParseLiteralException("USD must be a number or string, got ${input.javaClass.simpleName}")
        }

    /**
     * Called during query validation to convert a query input AST node into a Java object acceptable for the scalar type.  The input
     * object will be an instance of {@link graphql.language.Value}.
     *
     * Note : You should not allow {@link java.lang.RuntimeException}s to come out of your parseLiteral method, but rather
     * catch them and fire them as {@link graphql.schema.CoercingParseLiteralException} instead as per the method contract.
     *
     * @param input is never null
     *
     * @return a parsed value which is never null
     *
     * @throws graphql.schema.CoercingParseLiteralException if input literal can't be parsed
     */
    override fun parseLiteral(input: Any): BigDecimal =
        when (input) {
            is FloatValue -> input.value
            is IntValue -> input.value.toBigDecimal()
            is StringValue ->
                try {
                    BigDecimal(input.value)
                } catch (e: RuntimeException) {
                    throw CoercingParseLiteralException(e)
                }
            else -> throw CoercingParseLiteralException("USD must be a number or string, got ${input.javaClass.simpleName}")
        }
}

val USD_TYPE = GraphQLScalarType.newScalar()
    .name("USD")
    .coercing(USD_COERCER)
    .build()
