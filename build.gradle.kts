plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.72" apply false
    id("org.jlleitschuh.gradle.ktlint") version "9.4.0" apply false
    id("org.openjfx.javafxplugin") version "0.0.9" apply false
    id("org.beryx.jlink") version "2.12.0"
}

allprojects {
    repositories {
        jcenter() 
    }
}

subprojects {
    version = "1.0"
}
