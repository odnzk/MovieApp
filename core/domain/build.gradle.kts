plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    implementation(project("path" to ":core:common"))

    implementation(Deps.coroutinesCore)
    implementation(Deps.retrofit)
}
