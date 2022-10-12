import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    application
}

group = "academy.spring.webflux"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-web:2.6.7")
    implementation("org.springframework.boot:spring-boot-starter-webflux:2.6.7")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.1.7")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compileOnly("org.projectlombok:lombok:1.18.12")
    annotationProcessor("org.projectlombok:lombok:1.18.12")
    // Reactor Tools:
    implementation("io.projectreactor:reactor-tools:3.3.22.RELEASE")

    //DB
    implementation("io.r2dbc:r2dbc-postgresql:0.8.10.RELEASE")
    implementation("org.springframework.data:spring-data-r2dbc:1.1.9.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.7")

    testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.7")
    testImplementation("io.projectreactor:reactor-test:3.3.22.RELEASE")
    // BlockHound: Java agent to detect blocking calls from non-blocking threads.
    testImplementation("io.projectreactor.tools:blockhound:1.0.6.RELEASE")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}