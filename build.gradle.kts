plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.10" apply false
    id("org.jlleitschuh.gradle.ktlint") version "9.4.0" apply false
    id("org.openjfx.javafxplugin") version "0.0.9" apply false
    id("org.beryx.jlink") version "2.22.0" apply false
}

allprojects {
    repositories {
        jcenter() 
    }
}

subprojects {
    version = "1.0"
}
