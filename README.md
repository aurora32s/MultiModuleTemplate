## 기본 Multi Module Template
```
프로젝트에서 자주 사용되는 라이브러리를 포함하는 멀티모듈 기본 Template 입니다. :-)
```

## 📌 구성
|이름|설명|
|-----|----------|
|app|앱의 진입점(MainActivity)와 관련 파일 관리|
|build-logic|공통 Plugin 관리|
|core|app 및 Feature 에서 사용되는 공통 module|
|feature|기능 / 화면별 module|

<br/>

## 🛠 세부 구조
### 1️⃣ build-logic
> AndroidApplicationComposeConventionPlugin
- app module의 Compose 관련 설정 plugin
```
// app/build.gradle.kts
plugins {
    id("seomseom.android.application.compose")
}
```

> AndroidApplicationConventionPlugin
- app module 기본 설정 plugin
```
// app/build.gradle.kts
plugins {
    id("seomseom.android.application")
}
```

> AndroidFeatureConventionPlugin
- feature module 기본 설정 plugin
```
// [feature module]/build.gradle.kts
plugins {
    id("seomseom.android.feature")
}
```

> AndroidLibraryComposeConventionPlugin
- sub module (ex. ui, designsystem)의 Compose 관련 설정 plugin
```
// [sub module]/build.gradle.kts
plugins {
    id("seomseom.android.library.compose")
}
```

> AndroidLibraryConventionPlugin
- sub module 기본 설정 plugin
```
// [sub module]/build.gradle.kts
plugins {
    id("seomseom.android.library")
}
```

> AndroidHiltConventionPlugin
- hilt 사용을 위한 기본 설정 plugin
```
// [any module]/build.gradle.kts
plugins {
    id("seomseom.android.hilt")
}
```

### 2️⃣ core
