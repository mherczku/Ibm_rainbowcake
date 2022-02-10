# Ibm_rainbowcake

#### **Feladat:**

Egy API-ról lekért adatok listában és részletes nézetben történő megjelenítése.

#### Architektúra - RainbowCake

- https://rainbowcake.dev/
- DataSource réteg az alkalmazás esetében ki lett hagyva az egyszerűség kedvéért.
- Valamint a DetailPresenter-nek sincs szerepe, mivel a Fragmentnek nem kell hosszabb háttérfolyamatokat végeznie.

![](https://d33wubrfki0l68.cloudfront.net/5c87ced651e328f33727b33bbe9a871e482350a2/63186/images/arch_overview.png)

#### Felhasznált technológiák

- Kotlin Coroutines: Lehetővé teszik az aszinkron kódok írását

- Hilt Dependency Injection

- Timber: Loggolás, hibakezelés segítése

- UI:

  - OkHttp, Retrofit: Hálózati hívások

  - ConstraitLayout: Komplex felhasználó felületek elkészítésére

  - SwipeRefreshLayout: Lista nézetek manuális frissítéséhez

  - RecyclerView: Elemek megjelenítése listában

  - Glide: Képek betöltése internetről

  - NavigationDrawer: Elhúzható navigációs ablak

    
