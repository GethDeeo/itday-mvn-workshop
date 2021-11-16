# IT Day - Maven workshop

## Előkövetelmények

**!!!** Ha még nem tetted, klónozd ezt a git repót.  
`git clone https://github.com/GethDeeo/itday-mvn-workshop.git`

**!!!** A leírásban parancsok esetén a filerendszeri útvonalakban a Windows-on megszokott `\`-t találjátok,  
Linux esetén mindenképpen a `/` használata szükséges.

* JDK 1.8 (például [Amazon Corretto 8](https://github.com/corretto/corretto-8/releases/latest))
  * `JAVA_HOME` környezeti változó helyes beállítása  
    Ellenőrzés: `java -version` (ha a `PATH` környezeti változó tartalmazza a `<JAVA_HOME>\bin` könyvtárat)
* _(opcionális)_ [Apache Maven](https://maven.apache.org/download.cgi) `3.6.3` (minimum)
  * a `PATH` környezeti változó tartalmazza a `<Maven>\bin` könyvtárat
* _(ajánlott)_ Bármilyen XML-barát szerkesztő/IDE  
  Sokat segít ha színez, kiegészíti legalább a záró tageket.

A projekten a [Maven Wrapper](https://github.com/takari/maven-wrapper) inicializálva van (ezért opcionális maga a Maven).  
Emiatt a parancssorban a megszokott `mvn <argumentumok>` forma helyett használható
(a projekt gyökerében állva) a `.\mvnw.cmd <argumentumok>` (Windows) vagy `./mvnw <argumentumok>` (Linux) forma is.

* Maven verzió ellenőrzése (különös tekintettel a Maven által használt JDK-ra):  
  `mvn -v`
* Projekt ellenőrzése:  
  `mvn clean verify`

## 0. intro

(~30 perc előadás)

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
   https://github.com/spockframework/spock-example
2. Fordításhoz szükséges GMavenPlus plugin bekötése  
   https://groovy.github.io/GMavenPlus/
3. Futtatáshoz szükséges SureFire plugin konfigurációja
4. Ellenőrzés

## 2. feladat: Új függőségek (1 külső + 1 provided) felvétele

A projekten rögtön 2 új függőséget kell felvenni, ahol az egyiket a projektnek kell tartalmaznia, míg a másikat az alkalmazás szerver képes biztosítani.  
(~15 perc + megbeszélés)

1. Függőségek vizsgálata (tranzitivitás)
2. Függőségek felvétele
   1. https://logging.apache.org/log4j/2.x/
   2. https://www.joda.org/joda-time/
4. Kivételek definiálása, `MANIFEST.MF` bővítése
5. Ellenőrzés

## 3. feladat: Központi tárolóba történő deploy szűkítéssel

A projekt EAR modulja tartalmaz minden szükséges dolgot, így elég csak azt feltölteni a központi tárolóba.  
(~15 perc + megbeszélés)

1. Modulok kizárása a deploy folyamatból
2. POM lapítása  
   https://www.mojohaus.org/flatten-maven-plugin/
3. Ellenőrzés
