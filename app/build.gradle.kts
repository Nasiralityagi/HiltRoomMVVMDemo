plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.android.offlineexample"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
            isTestCoverageEnabled = true

            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://randomuser.me/\""
            )
            /*buildConfigField(
                "String",
                "BASE_URL",
                "\"https://5e510330f2c0d300147c034c.mockapi.io/\"")*/
        }

        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            isZipAlignEnabled = true

            proguardFile(getDefaultProguardFile("proguard-android.txt"))
            proguardFile(file("proguard-rules.pro"))

            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://randomuser.me/\""
            )
        }
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets {
        val commonTest = "src/commonTest/java"
        getByName("androidTest").java.srcDirs(commonTest)
        getByName("test").java.srcDirs(commonTest)
    }

    // work-runtime-ktx 2.1.0 and above now requires Java 8
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        dataBinding = true
        viewBinding = true
    }
}

kapt {
    useBuildCache = false
}

dependencies {
    //Android
    implementation(Dependencies.androidAppCompat)
    implementation(Dependencies.androidConstraintLayout)
    implementation(Dependencies.androidCore)

   // kapt(Dependencies.androidDataBindingCompiler)
    implementation(Dependencies.androidKtx)
    implementation(Dependencies.androidTestEspressoCore)
    implementation(Dependencies.recyclerview)
    implementation(Dependencies.lifecycleExtensions)
    implementation(Dependencies.activityKtx)

    //Navigation UI
    implementation(Dependencies.navigationUi)
    implementation(Dependencies.navigationUiKtx)
    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationFragmentKtx)


    //live data and view model
    implementation(Dependencies.androidLiveData)
    implementation(Dependencies.androidLiveDataKtx)
    implementation(Dependencies.androidViewModel)
    implementation(Dependencies.androidViewModelKtx)

    //Glide
    implementation(Dependencies.glide)

    //Room
    implementation(Dependencies.roomRuntime)
    kapt(Dependencies.roomCompiler)
    implementation(Dependencies.roomKtx)

    // Retrofit
    implementation(Dependencies.retrofitMoshi)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitGsonConverter)
    implementation(Dependencies.retrofitScalarsConverter)
    implementation(Dependencies.retrofitKotlixConverter)

    //okhttp
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpInterceptor)

    // Google Material Design
    implementation(Dependencies.materialDesign)

    // Kotlin
    implementation(Dependencies.kotlinStdLib)
    implementation(Dependencies.kotlinCoroutinesAndroid)
    implementation(Dependencies.kotlinCoroutinesCore)
    implementation(Dependencies.kotlinSerializationRuntime)

    // Leak Canary
    debugImplementation(Dependencies.leakCanary)

    // Tests
    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.mockk)
    testImplementation(Dependencies.okhttpTls)
    testImplementation(Dependencies.androidCoreTesting)
    testImplementation(Dependencies.okhttpMockWebServer)
    testImplementation(Dependencies.kotlinCoroutinesTest)

    androidTestImplementation(Dependencies.okhttpTls)
    androidTestImplementation(Dependencies.androidTestRules)
    androidTestImplementation(Dependencies.androidTestRunner)
    androidTestImplementation(Dependencies.androidTestExtJunit)
    androidTestImplementation(Dependencies.okhttpMockWebServer)

    // Timber
    implementation(Dependencies.timber)

    //Hilt
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.kaptHiltAndroidCompiler)
    implementation(Dependencies.hiltLifecycleViewmodel)
    kapt(Dependencies.kaptHiltCompiler)

    //new
    implementation(Dependencies.androidAppCompatRes)
    implementation(Dependencies.androidLifecycleExtension)
    implementation(Dependencies.gson)
    implementation(Dependencies.fragment)
    implementation(Dependencies.fragmentKtx)
    implementation(Dependencies.swipeRefresh)
}
