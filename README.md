# My Recipe App

> **Not:** Bu proje bir Udemy kursundan alınarak geliştirilmiştir. Eğitim amaçlı bir örnek uygulamadır.

## Project Overview

My Recipe App, [TheMealDB](https://www.themealdb.com/) API'sini kullanarak yemek kategorilerini görüntüleyen basit bir Android uygulamasıdır. Uygulama, kullanıcılara farklı yemek kategorilerini keşfetme ve her kategorinin detaylı açıklamalarını görüntüleme imkanı sunar.

Uygulama, modern Android geliştirme pratiklerini öğrenmek isteyen geliştiriciler için eğitim amaçlı hazırlanmıştır. Jetpack Compose ile UI geliştirme, MVVM mimarisi, Retrofit ile network işlemleri ve Kotlin Coroutines kullanımı gibi temel konuları içermektedir.

## Features

- 📱 **Kategori Listesi**: Yemek kategorilerini grid layout'ta görüntüleme
- 🔍 **Kategori Detayları**: Seçilen kategorinin görseli, adı ve açıklamasını görüntüleme
- 🌐 **API Entegrasyonu**: TheMealDB API'sinden kategori verilerini çekme
- ⏳ **Loading State**: Veri yüklenirken loading göstergesi
- ⚠️ **Error Handling**: Hata durumlarında kullanıcıya bilgi verme

## Tech Stack

### Dil & Platform
- **Kotlin**: Programlama dili
- **Android SDK**: minSdk 24, targetSdk 34

### UI Framework
- **Jetpack Compose**: Modern declarative UI framework
- **Material Design 3**: UI bileşenleri

### Architecture
- **MVVM (Model-View-ViewModel)**: Mimari desen
- **State Management**: Compose State API

### Network & Data
- **Retrofit 2.9.0**: REST API client
- **Gson**: JSON serialization/deserialization
- **Kotlin Coroutines**: Asenkron işlemler

### Image Loading
- **Coil 2.4.0**: Image loading kütüphanesi

### Navigation
- **Navigation Compose 2.7.4**: Ekranlar arası geçiş

### Dependency Injection
- Manuel dependency injection (basit singleton pattern)

## Architecture

Uygulama **MVVM (Model-View-ViewModel)** mimarisi kullanılarak geliştirilmiştir:

### Katmanlar

1. **Presentation Layer**
   - `RecipeScreen`: Kategori listesi ekranı
   - `CategoryDetailScreen`: Kategori detay ekranı
   - Compose UI bileşenleri

2. **ViewModel Layer**
   - `MainViewModel`: UI state yönetimi ve business logic
   - `RecipeState`: UI state data class'ı (loading, list, error)

3. **Data Layer**
   - `ApiService`: Retrofit interface (API endpoint tanımları)
   - `Category`: Data model
   - `CategoriesResponse`: API response model

### Veri Akışı

```
UI (Compose) → ViewModel → ApiService → TheMealDB API
                ↓
            State Update
                ↓
UI Recomposition
```

## Module Structure

Proje tek modüllü (app) bir yapıdadır. Tüm kod `app/src/main/java/eu/tutorials/myrecipeapp/` dizini altında organize edilmiştir.

## Navigation & Screens

Uygulama şu anda iki ana ekran içermektedir:

1. **RecipeScreen (Home)**
   - Kategorileri 2 sütunlu grid layout'ta gösterir
   - Her kategori item'ı tıklanabilir
   - Loading ve error state'leri gösterir

2. **CategoryDetailScreen**
   - Seçilen kategorinin detaylarını gösterir
   - Kategori görseli, adı ve açıklaması
   - Scroll edilebilir içerik

> **Not:** Navigation Compose entegrasyonu kodda mevcut ancak tam olarak implement edilmemiş görünmektedir.

## Data Layer & APIs

### API Endpoint

Uygulama [TheMealDB](https://www.themealdb.com/api.php) API'sini kullanmaktadır:

- **Base URL**: `https://www.themealdb.com/api/json/v1/1/`
- **Endpoint**: `categories.php` - Tüm yemek kategorilerini döner

### Network Yapısı

- **Retrofit**: REST API client olarak kullanılıyor
- **Gson Converter**: JSON response'ları Kotlin data class'larına dönüştürüyor
- **Suspend Functions**: Coroutines ile asenkron API çağrıları
- **Error Handling**: Try-catch blokları ile basit hata yönetimi

## Local Storage

Uygulama şu anda local storage kullanmamaktadır. Tüm veriler API'den çekilmektedir.

## Permissions

Uygulama sadece internet erişimi için izin gerektirmektedir:

- `INTERNET`: TheMealDB API'sine istek yapabilmek için gerekli

## Getting Started

### Gereksinimler

- **Android Studio**: Hedgehog (2023.1.1) veya üzeri
- **JDK**: 1.8 veya üzeri
- **Android SDK**: minSdk 24, targetSdk 34
- **Gradle**: Proje ile birlikte gelen wrapper kullanılır

### Kurulum Adımları

1. **Projeyi klonlayın:**
   ```bash
   git clone <repository-url>
   cd MyRecipeApp
   ```

2. **Android Studio'da açın:**
   - File → Open → Proje dizinini seçin

3. **Gradle sync:**
   - Android Studio otomatik olarak Gradle sync yapacaktır
   - Gerekirse: File → Sync Project with Gradle Files

4. **Çalıştırın:**
   - Bir Android emülatör veya fiziksel cihaz bağlayın
   - Run butonuna tıklayın veya `Shift + F10` tuşlarına basın

### Özel Konfigürasyon

Uygulama herhangi bir API key veya özel konfigürasyon gerektirmez. TheMealDB API'si ücretsiz ve herkese açıktır.

## Build Variants

Proje standart build variant'ları kullanmaktadır:

- **Debug**: Geliştirme için, ProGuard kapalı
- **Release**: Production için, ProGuard açık (şu anda optimize edilmemiş)

## Testing

Proje temel test yapısını içermektedir:

- **Unit Tests**: `app/src/test/java/` - JUnit testleri
- **Instrumentation Tests**: `app/src/androidTest/java/` - UI testleri

Testler henüz implement edilmemiştir, sadece template dosyalar mevcuttur.

## Known Issues & Limitations

- Navigation Compose tam olarak implement edilmemiş (Screen.kt dosyası mevcut ancak kullanılmıyor)
- Error handling basit seviyede (sadece genel hata mesajı gösteriliyor)
- Offline destek yok (veriler sadece API'den çekiliyor)
- Kategori detay ekranına navigation henüz tam çalışmıyor
- Unit testler yazılmamış
- ProGuard kuralları optimize edilmemiş

## Future Improvements

- ✅ Navigation Compose entegrasyonunu tamamlamak
- ✅ Room database ile offline cache eklemek
- ✅ Daha detaylı error handling ve retry mekanizması
- ✅ Unit test coverage artırmak
- ✅ Kategoriye göre yemek listesi görüntüleme özelliği
- ✅ Arama ve filtreleme özellikleri
- ✅ Favorilere ekleme özelliği
- ✅ Dependency Injection için Hilt/Koin entegrasyonu

---

**Eğitim Notu:** Bu proje, Android geliştirme öğrenmek isteyenler için hazırlanmış bir örnek uygulamadır. Production-ready değildir ve eğitim amaçlı kullanılmalıdır.

