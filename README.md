# IT Day - Maven workshop

---

**!!!** A kiinduló projekt még feltöltés alatt van, jelenleg a követelmények és a várható program tanulmányozható :)  
A feladatok leírása bővülni fog kellő mennyiségű mankóval (pl. irányított linkek).

---

## Előkövetelmények

TODO  
~**!!!** Ha még nem tetted, klónozd ezt a git repót és válts át a `develop` branchre!~  
~`git checkout develop`~

**!!!** A leírásban parancsok esetén a filerendszeri útvonalakban a Windows-on megszokott `\`-t találjátok,  
Linux esetén mindenképpen a `/` használata szükséges.

* JDK 1.8 (például [Amazon Corretto 8](https://github.com/corretto/corretto-8/releases/latest))
  * `JAVA_HOME` környezeti változó helyes beállítása  
    Ellenőrzés: `java -version` (ha a `PATH` környezeti változó tartalmazza a `<JAVA_HOME>\bin` könyvtárat)
* _(opcionális)_ [Apache Maven 3.8.3](https://maven.apache.org/download.cgi)
  * a `PATH` környezeti változó tartalmazza a `<Maven>\bin` könyvtárat
* _(ajánlott)_ Bármilyen XML-barát szerkesztő/IDE  
  Sokat segít ha színez, kiegészíti legalább a záró tageket.

A projekten a [Maven Wrapper](https://github.com/takari/maven-wrapper) inicializálva van (ezért opcionális maga a Maven).  
Emiatt a parancssorban a megszokott `mvn <argumentumok>` forma helyett használható
(a projekt gyökerében állva) a `.\mvnw.cmd <argumentumok>` (Windows) vagy `./mvnw <argumentumok>` (Linux) forma is.

* Maven verzió ellenőrzése (különös tekintettel a Maven által használt JDK-ra):  
  `mvn -v`
* ~Projekt ellenőrzése:~  
  ~`mvn clean verify`~

## 0. intro

TODO diasor (~30 perc előadás)

* Workshop programja, menete
* Alapfogalmak
  * `settings.xml`, `pom.xml`
  * Maven koordináta (G:A:V)
  * Leszármazás, aggregálás
  * Plugin (management, configuration, execution, `buildplan:list`)
  * Packaging, lifecycle
  * Függőség (scope, management, exclusion, `dependency:tree`)
  * Profil (activation)
* Projekt bemutatása
  * EJB modul
  * WAR modul
  * EAR modul
  * parent POM

## 1. feladat: Unit tesztelés Spock Framework (Groovy) segítségével

A (tisztán Java) projekten szeretne a csapat Spockot használni unit tesztekhez.  
(~15 perc + megbeszélés)

1. Spock + Groovy teszt-függőségek felvétele
2. Fordításhoz szükséges GMavenPlus plugin bekötése
3. Futtatáshoz szükséges SureFire plugin konfigurációja
4. Ellenőrzés

## 2. feladat: Új függőségek (1 külső + 1 provided) felvétele

A projekten rögtön 2 új függőséget kell felvenni, ahol az egyiket a projektnek kell tartalmaznia, míg a másikat az alkalmazás szerver képes biztosítani.  
(~15 perc + megbeszélés)

1. Függőségek vizsgálata (tranzitivitás)
2. Függőségek felvétele
3. Kivételek definiálása, `MANIFEST.MF` bővítése
4. Ellenőrzés

## 3. feladat: Központi tárolóba történő deploy szűkítéssel

A projekt EAR modulja tartalmaz minden szükséges dolgot, így elég csak azt feltölteni a központi tárolóba.  
(~15 perc + megbeszélés)

1. Modulok kizárása a deploy folyamatból
2. POM lapítása
3. Ellenőrzés
