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

## 2️⃣ core
> core:ui
- feature module에서 공통적으로 사용되는 UI component 및 Util 등 관리
  
[참고 1 - RecyclerView 공통 코드]

1.1 MultiTypeAdapter : Multi Type RecyclerView 공통 Adapter
```
// 사용 예제
class SampleAdapter(
    private val onClickItem: (SampleListItem, View) -> Unit
) : MultiTypeAdapter<SampleListItem>(
    onClickListener = onClickItem,
    checkContentDiff = { old, new -> old == new }
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<SampleListItem> {
        val currentViewType = SampleViewType.entries[viewType] // Enum Type
        val inflater = LayoutInflater.from(parent.context)
        return when (currentViewType) {
            SampleViewType.TITLE -> TitleViewHolder(ItemTitleBinding.inflate(inflater, parent, false))
            SampleViewType.ITEM -> SampleItemViewHolder(ItemSampleBinding.inflate(inflater, parent, false))
            SampleViewType.IMAGE -> ImageViewHolder(ItemImageBinding.inflate(inflater, parent, false))
        } as BaseViewHolder<SampleListItem>
    }
}
```

1.2 SingleTypeAdapter : Single Type RecyclerView 공통 Adapter
```
// 사용 예제

class SampleAdapter(
    private val onClickItem: (SampleListItem, View) -> Unit
) : SingleTypeAdapter<SampleListItem>(
    onClickListener = onClickItem,
    checkContentDiff = { old, new -> old == new }
) {
    override fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder<SampleListItem> {
        return TitleViewHolder(
            ItemTitleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ) as BaseViewHolder<SampleListItem>
    }
}
```

[참고 2 - RecyclerView 공통 코드]

2.1 Navigator : feature 간 이동 로직 관리
```
// 사용 예제
/**
 * 각 화면간의 이동 관리 ( core:ui )
 */
interface Navigator {
    fun moveToBActivity(context: Context)
}

// 구현체 ( app )
class SampleNavigator @Inject constructor() : Navigator {
    override fun moveToBActivity(context: Context) {
        context.startActivity(
            Intent(context, BActivity::class.java)
        )
    }
}
```

<br/>

> core:domain
- UseCase 와 Repository Interface
- model 명 : 000Model (ex. SampleModel)

> core:data
- Datasource 와 Repository 구현체
- model 명 : 000Data (ex. SampleData)

[참고 1 - API 호출 Util 코드 사용]

1.1 Response Body를 반환해줍니다.
1.2 200 대 코드가 아닐 시 NetworkException이 던져(throw)집니다.

```
override suspend fun get(): Result<List<String>> {
    return runCatching {
        ApiCallUtil {
            sampleApi.getImagesInfo(
                page = 1,
                limit = 10
            )
        }.map { it.imageUrl }
    }
}
```

> core:database
- Room Local Database 관리
- model 명 : 000Entity (ex. SampleEntity)

> core:datastore
- DataStore 와 SharedPreference 관리
- model 명 : 000Entity (ex. SampleEntity)

> core:network
- Retrofit을 이용한 API 통신
- model 명 : 000Request(요청), 000Response(응답)
- API의 반환값은 Response<T>로 지정하는것을 권장합니다!
- kotlin-serialization가 적용되었습니다.
```
// 다른 Converter 사용 시 아래 Module에 추가해주세요 :-)
@Module
@InstallIn(SingletonComponent::class)
object ConverterFactoryModule {
    @Provides
    @Singleton
    fun provideJsonConverter(): Converter.Factory {
        return Json {
            coerceInputValues = true // null 값으로 들어오면 default value로 처리
            ignoreUnknownKeys = true // 프로퍼티로 선언되지 않은 key는 무시
        }.asConverterFactory("application/json".toMediaType())
    }
}
```

[참고 1 - AuthInterceptor]

- API 통신에 필요한 Authentication Header 전처리를 하는 곳입니다.
  
