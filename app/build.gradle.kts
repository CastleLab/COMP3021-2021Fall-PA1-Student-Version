/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.2/userguide/building_java_projects.html
 */

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    java

    // Apply the application plugin to add support for building a CLI application in Java.
    application

    checkstyle
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    compileOnly("org.jetbrains:annotations:22.0.0")

    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.2")
}

application {
    // Define the main class for the application.
    mainClass.set("hk.ust.cse.comp3021.pa1.Main")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(16))
    }
}

checkstyle {
    toolVersion = "9.0"
}

tasks {
    withType<JavaCompile> {
        options.compilerArgs = listOf("--enable-preview")
        options.encoding = "UTF-8"
    }
    withType<Javadoc> {
        (options as? CoreJavadocOptions)?.apply {
            addStringOption("source", java.toolchain.languageVersion.get().toString())
            addBooleanOption("-enable-preview", true)
        }
    }
    withType<JavaExec> {
        jvmArgs("--enable-preview")
    }
    withType<Jar> {
        manifest {
            attributes.apply {
                this["Main-Class"] = application.mainClass.get()
            }
        }
    }
    withType<Test> {
        group = "verification"

        // Use JUnit Platform for unit tests.
        useJUnitPlatform()

        systemProperties(
            "junit.jupiter.execution.timeout.testable.method.default" to "2000 ms"
        )

        jvmArgs("--enable-preview")
    }

    create<Test>("testSanity") {
        useJUnitPlatform {
            includeTags("sanity")
        }
    }

    create<Test>("testProvided") {
        useJUnitPlatform {
            includeTags("provided")
        }
    }

    create<Test>("testActual") {
        useJUnitPlatform {
            includeTags("actual")
        }
    }
}
