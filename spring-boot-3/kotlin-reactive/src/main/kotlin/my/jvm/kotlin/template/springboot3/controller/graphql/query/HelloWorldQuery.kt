package my.jvm.kotlin.template.springboot3.controller.graphql.query

import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Component

@Component
class HelloWorldQuery: Query {
    fun helloWorld(): String = "Hello World!"
}