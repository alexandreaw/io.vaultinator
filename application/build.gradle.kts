plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":database-adapter"))
    implementation(project(":restapi-adapter"))
    implementation(project(":encrypt-adapter"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.liquibase:liquibase-core")
    runtimeOnly("org.postgresql:postgresql")
}