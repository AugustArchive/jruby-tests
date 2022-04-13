plugins {
    kotlin("jvm") version "1.6.20"
    application
}

group = "dev.floofy"
version = "0.0.0-fuck.0"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jruby:jruby-complete:9.3.4.0")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.register<JavaExec>("runTests") {
    dependsOn("classes")

    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("dev.floofy.jruby.Jruby")
}
