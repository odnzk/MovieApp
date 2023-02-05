object Versions {
    // Base
    const val coreVersion = "1.9.0"
    const val appCompatVersion = "1.6.0"
    const val materialVersion = "1.8.0"
    const val constraintLayoutVersion = "2.1.4"
    const val fragmentKtxVersion = "1.5.5"
    const val activityVersion = "1.6.1"
    const val lifecycleVersion = "2.5.1"

    // Test
    const val junitVersion = "4.13.2"
    const val androidJunitVersion = "1.1.3"
    const val espressoVersion = "3.4.0"

    // Room
    const val roomVersion = "2.5.0"

    // DI
    const val daggerVersion = "2.41"
    const val hiltVersion = "2.44.2"

    // Navigation
    const val navigationVersion = "2.5.3"

    // Coroutines
    const val coroutinesVersion = "1.6.4"

    // Coil
    const val coilVersion = "2.2.2"

    // Retrofit
    const val retrofitVersion = "2.9.0"
    const val okHttpVersion = "4.10.0"
}

object Deps {
    // Base
    const val core = "androidx.core:core-ktx:${Versions.coreVersion}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragmentKtxVersion}"
    const val activity = "androidx.activity:activity-ktx:${Versions.activityVersion}"
    const val lifecycleViewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"


    // Test
    const val junitTest = "junit:junit:${Versions.junitVersion}"
    const val junit = "androidx.test.ext:junit:${Versions.androidJunitVersion}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"

    // Room
    const val room = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"

    // DI
    const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hiltVersion}"

    // Navigation
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"

    // Coroutines
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"

    // Loading images
    const val coil = "io.coil-kt:coil:${Versions.coilVersion}"

    // Network
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"

}

