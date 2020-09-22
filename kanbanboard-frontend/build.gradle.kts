plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jlleitschuh.gradle.ktlint")
    id("org.openjfx.javafxplugin")
    `java-library`
}

dependencies {
    implementation(project(":kanbanboard-contract"))
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

javafx {
    version = "15"
    modules("javafx.controls", "javafx.fxml")
}
