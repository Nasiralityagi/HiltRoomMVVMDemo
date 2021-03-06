object Dependencies {
    const val androidAppCompat = "androidx.appcompat:appcompat:${Versions.androidAppCompat}"
    const val androidAppCompatRes = "androidx.appcompat:appcompat-resources:${Versions.androidAppCompat}"
    const val androidConstraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.androidConstraintLayout}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val androidCore = "androidx.core:core:${Versions.androidCore}"
    const val androidCoreTesting = "androidx.arch.core:core-testing:${Versions.androidCoreTesting}"
    //const val androidDataBindingCompiler ="androidx.databinding:databinding-compiler:${Versions.androidGradlePlugin}"
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val androidLifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.androidLiveData}"
    const val androidLiveData = "androidx.lifecycle:lifecycle-livedata:${Versions.androidLiveData}"
    const val androidLiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidLiveData}"
    const val androidViewModel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.androidViewModel}"
    const val androidViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidViewModel}"

    const val navigationUi = "androidx.navigation:navigation-ui:${Versions.androidNavigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.androidNavigation}"
    const val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.androidNavigation}"
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.androidNavigation}"

    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val okhttpTls = "com.squareup.okhttp3:okhttp-tls:${Versions.okhttp}"
    const val okhttpMockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}"

    const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.moshi}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofitScalarsConverter = "com.squareup.retrofit2:converter-scalars:${Versions.retrofit}"
    const val retrofitKotlixConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.retrofitKotlinxVersion}"

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinStdLib}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinStdLib}"
    const val kotlinCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
    const val kotlinCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    const val kotlinCoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutines}"
    const val kotlinSerializationGradlePugin = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlinStdLib}"
    const val kotlinSerializationRuntime = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.kotlinSerialization}"

    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"

    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"

    const val mockk = "io.mockk:mockk:${Versions.mockk}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    const val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefresh}"

    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val androidKtx = "androidx.core:core-ktx:${Versions.androidKtxVersion}"

    const val  lifecycleExtensions = "android.arch.lifecycle:extensions:${Versions.lifecycleExtensions}"
    const val  activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val  fragment = "androidx.fragment:fragment:1.2.0-beta02"
    const val  fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltAndroid}"
    const val kaptHiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroid}"
    const val hiltLifecycleViewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltAndroidLifecycle}"
    const val hiltAndroidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltAndroid}"
    const val kaptHiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltAndroidLifecycle}"

    const val junit = "junit:junit:${Versions.junit}"
    const val androidTestEspressoCore = "androidx.test.espresso:espresso-core:${Versions.androidTestEspressoCore}"
    const val androidTestExtJunit = "androidx.test.ext:junit:${Versions.androidTestExtJunit}"
    const val androidTestRules = "androidx.test:rules:${Versions.androidTestRules}"
    const val androidTestRunner = "androidx.test:runner:${Versions.androidTestRunner}"

}

object Versions {
    internal const val androidAppCompat = "1.2.0"
    internal const val androidConstraintLayout = "2.0.2"
    internal const val androidCore = "1.3.2"
    internal const val androidGradlePlugin = "4.1.0"
    internal const val androidLiveData = "2.2.0"
    internal const val androidCoreTesting = "2.0.1"
    internal const val androidTestEspressoCore = "3.3.0"
    internal const val androidTestExtJunit = "1.1.2"
    internal const val androidTestRules = "1.2.0"
    internal const val androidTestRunner = "1.2.0"
    internal const val androidViewModel = "2.2.0"
    internal const val androidNavigation = "2.3.1"
    internal const val retrofit = "2.6.1"
    internal const val moshi = "2.6.2"
    internal const val junit = "4.13.1"
    internal const val kotlinStdLib = "1.4.10"
    internal const val kotlinCoroutines = "1.3.0-RC"
    internal const val kotlinSerialization = "0.11.1"
    internal const val leakCanary = "2.0-alpha-3"
    internal const val materialDesign = "1.2.1"
    internal const val mockk = "1.9.3"
    internal const val okhttp = "4.0.1"
    internal const val roomVersion = "2.1.0"
    internal const val timber = "4.7.1"
    internal const val retrofitKotlinxVersion = "0.4.0"
    internal const val glideVersion = "4.5.0"
    internal const val gson = "2.8.6"
    internal const val swipeRefresh = "1.1.0"
    internal const val androidKtxVersion = "1.3.2"
    internal const val recyclerview = "1.1.0"
    internal const val lifecycleExtensions = "1.1.1"
    internal const val activityKtx = "1.1.0"
    internal const val fragmentKtx = "1.2.5"
    internal const val hiltAndroid = "2.28-alpha"
    internal const val hiltAndroidLifecycle = "1.0.0-alpha02"
}
