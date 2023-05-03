# Todolist niveau Premium

## Prérequis

### Annotation processors

````conf
    id 'kotlin-kapt' 
````
Annotation processors

### Parcelize

-  https://developer.android.com/reference/android/os/Parcelable

fournit un générateur d'implémentation Parcelable.

````kotlin
import kotlinx.parcelize.Parcelize

@Parcelize
class User(val firstName: String, val lastName: String, val age: Int): Parcelable

````
@Parcelize nécessite que toutes les propriétés sérialisées soient déclarées dans le constructeur principal.

### Injection de dépendances

- Docs
  - https://developer.android.com/training/dependency-injection?hl=fr
  - https://developer.android.com/training/dependency-injection/hilt-android?hl=fr
  - https://www.youtube.com/watch?v=1Zt6aIqZnqU
- Codelabs
  - [Lab - Utiliser Hilt dans une application Android](https://developer.android.com/codelabs/android-hilt?hl=fr#0) 
- Samples


````conf
    id 'kotlin-kapt' 
    id 'androidx.navigation.safeargs.kotlin'
````

#### Navigation

- doc
  - https://developer.android.com/guide/navigation?hl=fr
- Codelab
  - https://developer.android.com/codelabs/android-navigation?hl=fr#0
- Exemples 
  - https://github.com/android/architecture-components-samples


### dataBinding

###  viewModel

###  Room
  - https://developer.android.com/training/data-storage/room?hl=fr
  - Injection de dépendances dans Android
    - https://developer.android.com/training/dependency-injection?hl=fr

## Installation des plugins

````conf
    id 'kotlin-kapt' 
    id 'kotlin-parcelize' 
    id 'dagger.hilt.android.plugin'
    id 'androidx.navigation.safeargs.kotlin'
````
### kotlin-kapt'

### kotlin-parcelize

## Références

- https://github.com/timemake/Updated_Kotlin_MVVM_ToDoList
- https://github.com/timemake/Kotlin-MVVM-ToDoList
- https://kim-pro.medium.com/kotlin-mvvm-todo-list-f137ecfc96bb
- [Kotlin MVVM ToDo List](https://www.youtube.com/playlist?list=PLoCYbRS6dPkJMThvLiPEaWGQ0tV2XL4v8)
- https://github.com/android/architecture-samples