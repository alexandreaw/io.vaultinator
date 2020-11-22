import com.linecorp.support.project.multi.recipe.configure
import com.linecorp.support.project.multi.recipe.configureByTypeHaving
import com.linecorp.support.project.multi.recipe.configureByTypePrefix
import com.linecorp.support.project.multi.recipe.configureByTypeSuffix
import com.linecorp.support.project.multi.recipe.matcher.ProjectMatchers.Companion.byLabel
import com.linecorp.support.project.multi.recipe.matcher.ProjectMatchers.Companion.byTypeHaving
import com.linecorp.support.project.multi.recipe.matcher.ProjectMatchers.Companion.byTypePrefix
import com.linecorp.support.project.multi.recipe.matcher.ProjectMatchers.Companion.byTypeSuffix
import com.linecorp.support.project.multi.recipe.matcher.and
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    id("org.springframework.boot").version("2.2.1.RELEASE").apply(false)
    id("io.spring.dependency-management").version("1.0.8.RELEASE").apply(false)
    kotlin("jvm") version "1.3.50"
    kotlin("plugin.spring") version "1.3.50"
    kotlin("kapt") version "1.3.50"
    id("com.linecorp.build-recipe-plugin") version "1.0.1"
    id("com.linecorp.recursive-git-log-plugin") version "1.0.1"
}

allprojects {
    repositories {
        mavenCentral()
    }
}

configureByTypePrefix("kotlin") {
    apply(plugin = "kotlin")

    configure<JavaPluginConvention> {
        sourceCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }

    tasks.test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
        testImplementation("io.mockk:mockk:1.10.2")
        testImplementation("com.nhaarman:expect.kt:1.0.1")
    }
}

configureByTypeSuffix("lib") {
    apply(plugin = "java-library")
}

configureByTypeHaving("boot") {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "kotlin-spring")

    configure<DependencyManagementExtension> {
        dependencies {
            dependencySet("org.jetbrains.kotlinx:1.3.2") {
                entry("kotlinx-coroutines-core")
                entry("kotlinx-coroutines-reactor")
            }
        }
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot")
        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

configure(byTypePrefix("kotlin") and byTypeHaving("boot")) {
    apply(plugin = "kotlin-kapt")

    dependencies {
        "kapt"("org.springframework.boot:spring-boot-configuration-processor:2.2.1.RELEASE")
    }
}

configure(byTypeHaving("boot") and byTypeSuffix("lib")) {
    tasks {
        withType<Jar> {
            enabled = true
        }

        withType<BootJar> {
            enabled = false
        }

        withType<BootRun> {
            enabled = false
        }
    }
}

configure(byTypeSuffix("boot-lib") and byLabel("db-adapter")) {
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.liquibase:liquibase-core")
        runtimeOnly("org.postgresql:postgresql")
    }
}

configure(byTypeSuffix("boot-lib") and byLabel("restapi-adapter")) {
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    }
}

configure(byTypeSuffix("boot-lib") and byLabel("encrypt-adapter")) {
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    }
}

configure(byTypeSuffix("boot-application") and byLabel("application")) {
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.liquibase:liquibase-core")
        runtimeOnly("org.postgresql:postgresql")
    }
}

