plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":domain"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}