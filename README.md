# Kollégiumi szobaelosztó
Ez az alkalmazás a kollégiumi szobajelentkezést bonyolítja le. A hallgatók a neptunkódjuk segítségével bejelentkezhetnek az oldalra. A bejelentkezés után lehetőségük van kiválasztani, hogy melyik szobában szeretnének lakni a következő félévben. Az adminisztrátor a végső szobabeosztást manuális hagyhatja jóvá, az egyéni igények kielégítése végett.

Készült a Projekt eszközök tárgyra a 2019/2020/2 félévben.


## 1.1 Backend osztályai:

* Controllers
  * BeosztasController.java
  * DiakController.java
  * EpuletController.java
  * SzobaController.java
  * UserController.java
* Entities
  * Beosztas.java
  * Diak.java
  * Epulet.java
  * Szoba.java
  * User.java
* Repositories
  * BeosztasRepository.java
  * DiakRepository.java
  * EpuletRepository.java
  * SzobaRepository.java
  * UserRepository.java
* Security
  * AuthenticatedUser.java
  * CustomBasicAuthenticationEntryPoint.java
  * MyUserDetailsService.java
  * WebSecurityConfig.java
