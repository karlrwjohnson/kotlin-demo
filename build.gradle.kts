import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    war
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
    kotlin("plugin.jpa") version "1.6.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()

    // REMOVE after upgrading Spring Boot to >= 2.7
    // Required because graphql-spring-boot-starter is at 1.0.0-M4 instead of a stable release
    maven("https://repo.spring.io/milestone")
}

dependencies {
    implementation("com.h2database:h2:2.1.210")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-tomcat")
//    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
//    implementation("org.springframework.boot:spring-boot-starter-graphql")
    implementation("org.springframework.experimental:graphql-spring-boot-starter:1.0.0-M4")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-future") // Add `future {}` async builder
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8") // Add ability to await a Java CompletableFuture
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor") // Add ability to await a Reactor Mono or Flux
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.springframework.security:spring-security-test")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    implementation("com.graphql-java:graphql-java:17.3");

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        // Tell Kotlin to interpret any `javax.annotation.@Nonnull` annotation as a nullability flag
        // and assume it's a non-null value.
        freeCompilerArgs = listOf("-Xjsr305=strict")

        // Tell Kotlin to compile against Java 11
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
