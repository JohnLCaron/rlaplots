plugins {
    kotlin("jvm") version "2.0.20"
}

group = "org.cryptobiotic"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://packages.jetbrains.team/maven/p/kds/kotlin-ds-maven")
}

dependencies {
    implementation(files("libs/rlauxe-1.0-SNAPSHOT-uber.jar"))

    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlin-statistics-jvm:0.3.1")
    implementation("org.jetbrains.kotlinx:kandy-lets-plot:0.7.0")

    implementation(libs.lets.plot)
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}