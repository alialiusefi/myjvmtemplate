import com.expediagroup.graphql.plugin.gradle.tasks.GraphQLGenerateSDLTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // spring
    id("org.springframework.boot") version "3.1.4"
    id("io.spring.dependency-management") version "1.1.3"

    // graphlql
    id("com.expediagroup.graphql") version "7.0.1"

    // kotlin
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
}

group = "my.jvm"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // graphql
    // https://github.com/ExpediaGroup/graphql-kotlin
    // expedia has good kotlin support and works with spring. can be counted as a spring boot starter even.
    implementation("com.expediagroup:graphql-kotlin-spring-server:7.0.1")
    implementation("com.expediagroup:graphql-kotlin-schema-generator:7.0.1")
    implementation("com.expediagroup:graphql-kotlin-hooks-provider:7.0.1")
    implementation("com.graphql-java:graphql-java:21.1")

    // rest


    // client
    // https://www.baeldung.com/guide-to-okhttp
    // implementation("com.squareup.okhttp3:okhttp")

    // jackson

    // grpc

    // arrow kt




    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

graphql {
    schema {
        packages = listOf("my.jvm.template.kotlin.springboot3.controller.graphql")
    }
}

tasks.withType<GraphQLGenerateSDLTask> {
    packages.add("my.jvm.template.kotlin.springboot3.controller.graphql")
    schemaFile.set(file("${project.projectDir}/src/main/resources/graphql/schema.graphql"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
