plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":domain"))
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.liquibase:liquibase-core")
    runtimeOnly("org.postgresql:postgresql")
}