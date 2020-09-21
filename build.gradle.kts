plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.72" apply false
    id("org.jlleitschuh.gradle.ktlint") version "9.4.0" apply false
}

allprojects {
    repositories {
        jcenter() 
    }
}

subprojects {
    version = "1.0"
}
