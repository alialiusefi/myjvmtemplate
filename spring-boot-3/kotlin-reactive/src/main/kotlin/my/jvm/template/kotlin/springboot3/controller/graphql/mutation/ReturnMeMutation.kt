package my.jvm.template.kotlin.springboot3.controller.graphql.mutation

import com.expediagroup.graphql.server.operations.Mutation
import org.springframework.stereotype.Component

@Component
class ReturnMeMutation: Mutation {

    suspend fun returnMe(string: String): String = string
}