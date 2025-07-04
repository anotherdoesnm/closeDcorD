plugins {
    id("com.android.application")
    id("kotlin-android")
}

val composeVersion = "1.0.3"

android {
    compileSdk = 31

    flavorDimensions.add("api")

    defaultConfig {
        applicationId = "com.xinto.opencord"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary  = true
        }

        buildConfigField("int", "DISCORD_VERSION_CODE", "89108")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    productFlavors {
        create("discord") {
            dimension = "api"
            
            isDefault = true

            buildConfigField("String", "URL_API", "\"https://api.old.server.spacebar.chat/api/v9\"")
            buildConfigField("String", "URL_CDN", "\"https://cdn.old.server.spacebar.chat\"")
            buildConfigField("String", "URL_GATEWAY", "\"wss://gateway.old.server.spacebar.chat/?v=9&encoding=json\"")
        }

        create("fosscord") {
            dimension = "api"

            applicationIdSuffix = ".fosscord"
            versionNameSuffix = "-fosscord"

            buildConfigField("String", "URL_API", "\"https://api.fosscord.com/v9\"")
            buildConfigField("String", "URL_CDN", "\"https://cdn.fosscord.com\"")
            buildConfigField("String", "URL_GATEWAY", "\"wss://gateway.fosscord.com/?v=9&encoding=json\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = freeCompilerArgs +
                "-Xopt-in=kotlin.RequiresOptIn"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.preference:preference-ktx:1.1.1")

    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    implementation("androidx.compose.material:material-icons-core:$composeVersion")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.compose.ui:ui-util:$composeVersion")
    implementation("androidx.compose.ui:ui:$composeVersion")

    implementation("io.coil-kt:coil-compose:1.4.0")

    val accompanistVersion = "0.18.0"
    implementation("com.google.accompanist:accompanist-navigation-animation:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-insets:$accompanistVersion")

    implementation("com.google.android.material:material:1.4.0")
    implementation("com.google.code.gson:gson:2.8.8")

    implementation("com.github.hcaptcha:hcaptcha-android-sdk:1.1.0")

    val retrofitVersion = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    val okHttpVersion = "4.9.1"
    implementation("com.squareup.okhttp3:okhttp:$okHttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okHttpVersion")

    implementation("com.github.X1nto:OverlappingPanelsCompose:1.1.0")
    
    implementation("io.insert-koin:koin-androidx-compose:3.1.2")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")

    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
}
