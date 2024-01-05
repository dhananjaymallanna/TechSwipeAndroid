plugins {
    id("com.android.application")
}

android {
    namespace = "com.thelearningtogether.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.thelearningtogether.myapplication"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.squareup.picasso:picasso:2.8")
    implementation("io.reactivex:rxjava:1.1.8")
    implementation("io.reactivex:rxandroid:1.2.1")
/*    implementation("com.android.support:appcompat-v7:${supportLibVersion}")
    implementation("com.android.support:design:${supportLibVersion}")
    implementation("com.android.support:cardview-v7:${supportLibVersion}")*/

//Thanks for using https://jar-download.com

}