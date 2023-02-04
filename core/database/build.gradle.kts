plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.study.database"
    compileSdk = 33

    defaultConfig {
        minSdk = 27
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Deps.core)
    implementation(Deps.appCompat)
    implementation(Deps.material)
    implementation(project(mapOf("path" to ":core:domain")))
    testImplementation(Deps.junitTest)
    androidTestImplementation(Deps.junit)
    androidTestImplementation(Deps.espressoCore)

    implementation(project(mapOf("path" to ":core:common")))

    implementation(Deps.room)
    kapt(Deps.roomCompiler)

    implementation(Deps.hilt)
    kapt(Deps.hiltCompiler)
}
