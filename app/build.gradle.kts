plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
<<<<<<< HEAD
    namespace = "vcmsa.projects.budgettrackergroup10"
    compileSdk = 35

    compileOptions{
        var sourceCompatibilty = JavaVersion.VERSION_1_8
        targetCompatibility= JavaVersion.VERSION_1_8
    }

    kotlinOptions{
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }


    defaultConfig {
        applicationId = "vcmsa.projects.budgettrackergroup10"
        minSdk = 24
=======
    namespace = "vcmsa.projects.group10progpoepart2"
    compileSdk = 35

    defaultConfig {
        applicationId = "vcmsa.projects.group10progpoepart2"
        minSdk = 21
>>>>>>> e68ae72ca55ad4e262f9f27e13c88445b2318733
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
<<<<<<< HEAD

=======
>>>>>>> e68ae72ca55ad4e262f9f27e13c88445b2318733
}