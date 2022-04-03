import java.io.FileInputStream
import java.util.*

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.truecaller.truecallerblog"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    if (project.hasProperty("app/keystore/keystore.properties")) {
        val keystoreProperties = Properties()
        keystoreProperties.load(FileInputStream(rootProject.file("app/keystore/keystore.properties")))
        signingConfigs {
            create("release") {
                keyAlias = keystoreProperties["keyAlias"] as String
                keyPassword = keystoreProperties["keyPassword"] as String
                storeFile = project.properties["storeFile"]?.let { file(it) }
                storePassword = keystoreProperties["storePassword"] as String
            }
        }
    }


    buildTypes {
        getByName("release") {
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


    buildFeatures {
        dataBinding = true
    }

    flavorDimensions.add("environment")
    productFlavors {
        create("dev") {
            resValue("string", "app_name", "TrueCallerBlog Exercise Dev")
            buildConfigField("String", "BASE_URL", "\"https://truecaller.blog/\"")
        }
        create("production") {
            resValue("string", "app_name", "TrueCallerBlog Exercise")
            buildConfigField("String", "BASE_URL", "\"https://truecaller.blog/\"")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    /**
     ******************************* Android Common Component************************************
     **/
    implementation(Deps.appCompat)
    implementation(Deps.materialDesign)
    implementation(Deps.constraintLayout)
    implementation(Deps.multidex)

    /**
     ******************************* Navigation Architecture ************************************
     **/
    implementation(Deps.navigationFragment)
    implementation(Deps.navigationUI)

    /**
     ******************************* ViewModel and LiveData ************************************
     **/
    implementation(Deps.lifecycleExt)

    /**
     ******************************* Network ************************************
     **/
    implementation(Deps.retrofit)
    implementation(Deps.retrofitScalarConverter)
    implementation(Deps.retrofitLogger)

    /**
     ******************************* DI ************************************************************
     **/
    implementation(Deps.hilt)
    kapt(Deps.hiltKapt)

    /**
     ******************************* Unit Testing ************************************
     **/
    testImplementation(Deps.junit)
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}