plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.serialization") version "1.6.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val ktorversion = "2.3.9"
    implementation("io.ktor:ktor-client-core:$ktorversion")
    implementation("io.ktor:ktor-client-cio:$ktorversion")
    implementation("io.ktor:ktor-client-json:$ktorversion")
    implementation("io.ktor:ktor-client-serialization:$ktorversion")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}