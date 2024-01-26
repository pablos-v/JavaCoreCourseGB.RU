plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    // https://mvnrepository.com/artifact/com.google.guava/guava
    implementation("com.google.guava:guava:11.0.2")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}