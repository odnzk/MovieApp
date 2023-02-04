object Versions {
    const val coreVersion = "1.9.0"
    const val appCompatVersion = "1.6.0"
    const val fragmentKtxVersion = "1.5.5"
    const val materialVersion = "1.8.0"
    const val constraintLayoutVersion = "2.1.4"
    const val junitVersion = "4.13.2"
    const val androidJunitVersion = "1.1.3"
    const val espressoVersion = "3.4.0"
    const val lifecycleVersion = "2.5.1"


    const val roomVersion = "2.5.0"
    const val daggerVersion = "2.41"
    const val workVersion = "2.7.1"
    const val hiltVersion = "2.44.2"
    const val navigationVersion = "2.5.3"
    const val activityVersion = "1.6.1"
    const val coroutinesVersion = "1.6.4"
    const val datastoreVersion = "1.0.0"
    const val glideVersion = "4.9.0"
    const val coilVersion = "2.2.2"
    const val retrofitVersion = "2.9.0"
    const val okHttpVersion = "4.10.0"
    const val moshiVersion = "1.14.0"
}

object Deps {
    const val core = "androidx.core:core-ktx:${Versions.coreVersion}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragmentKtxVersion}"
    const val activity = "androidx.activity:activity-ktx:${Versions.activityVersion}"

    const val junitTest = "junit:junit:${Versions.junitVersion}"
    const val junit = "androidx.test.ext:junit:${Versions.androidJunitVersion}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"

    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    const val lifecycleViewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val lifecycleCompiler =
        "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycleVersion}"


    const val room = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"

    const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"

    const val hilt = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hiltVersion}"

    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationRuntime =
        "androidx.navigation:navigation-runtime-ktx:${Versions.navigationVersion}"
    const val navigationSafeargs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}"

    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"

    const val datastore = "androidx.datastore:datastore-preferences:${Versions.datastoreVersion}"

    const val workmanagerRuntime = "androidx.work:work-runtime-ktx:${Versions.workVersion}"

    const val coil = "io.coil-kt:coil:${Versions.coilVersion}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"
    const val retrofitWithMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofitVersion}"
}

