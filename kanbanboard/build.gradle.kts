plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jlleitschuh.gradle.ktlint")
    id("org.openjfx.javafxplugin")
    id("org.beryx.jlink")
    application
}

dependencies {
    implementation(project(":kanbanboard-backend"))
    implementation(project(":kanbanboard-frontend"))
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

application {
    mainModule.set("de.muspellheim.kanbanboard")
    mainClass.set("de.muspellheim.kanbanboard.AppKt")
    mainClassName = "de.muspellheim.kanbanboard.AppKt"
}

javafx {
    version = "15"
    modules("javafx.controls")
}

jlink {
    launcher {
        name = "kanbanboard"
    }
}
