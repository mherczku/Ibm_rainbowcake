# Ibm_rainbowcake

JetCompose-zal készített verzió: https://github.com/mherczku/ibm_jetcompose

#### **Feladat:**

Egy API-ról lekért adatok listában és részletes nézetben történő megjelenítése.

A paginaton egy endless recyclerview-val van megvalósítva.

#### Architektúra - RainbowCake

- https://rainbowcake.dev/
- DataSource réteg az alkalmazás esetében ki lett hagyva az egyszerűség kedvéért.
- Valamint a DetailPresenter-nek sincs feladata, mivel a Fragmentnek nem kell hosszabb háttérfolyamatokat végeznie.

![](https://d33wubrfki0l68.cloudfront.net/5c87ced651e328f33727b33bbe9a871e482350a2/63186/images/arch_overview.png)

#### Felhasznált technológiák

- Kotlin Coroutines

- Hilt Dependency Injection

- Timber: Loggolás

- OkHttp, Retrofit

- UI:  

  - ConstraitLayout

  - SwipeRefreshLayout

  - RecyclerView

  - Glide

  - NavigationDrawer

    
