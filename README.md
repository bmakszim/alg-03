# Algoritmusok és adatszerkezetek gyakorlat házi feladat
## Makszim Balázs Imre ENSGO3

Feladat eredeti leírása:
https://www.hackerrank.com/challenges/abbr/problem

## Rövidítés

Az `a` sztringen az alábbi műveletek hajthatók végre:
- Az `a` kisbetűs betűinek tetszőleges számát nagybetűssé alakíthatjuk.
- Az összes megmaradó kisbetűt törölhetjük az `a` sztringből.

## Feladat:
Két sztring, `a` és `b` esetén döntsd el, hogy az `a` sztring az említett műveletek segítségével átalakítható-e úgy, hogy megegyezzen a `b` sztringgel. Ha igen, akkor írj ki **YES**-t egy új sorba. Ha nem, akkor írj ki **NO**-t.

### Példa:
- Ha `a = AbcDE` és `b = ABDE`, akkor az `a` sztring `b`-vé alakítható, mert az `a` kisbetűit nagybetűvé alakíthatjuk (`A` és `B`), majd törölhetjük a `c` karaktert, így a végeredmény `ABDE` lesz.
- Ha viszont `a = AbcDE` és `b = AFDE`, az átalakítás nem lehetséges, mivel nem lehet betűket megváltoztatni, csak nagybetűsíteni vagy törölni.

## A függvény leírása:

Készíts egy `abbreviation` nevű függvényt az alábbi paraméterekkel:

```java
String abbreviation(String a, String b)
```

### Bemenet:
* `a`: Az eredeti sztring.
* `b`: A cél sztring.

### Kimenet:
Térjen vissza `YES` értékkel, ha az `a` sztring átalakítható a `b` sztringgé, különben `NO` értékkel.

## Bemeneti formátum:
- Az első sorban egyetlen egész szám található, `q`, amely a lekérdezések számát adja meg.
- A következő `q` lekérdezés mindegyike két sorból áll:
  - Az első sor egy `a` sztringet tartalmaz.
  - A második sor egy `b` sztringet tartalmaz.

## Korlátozások:
- Az `a` sztring csak angol nagy- és kisbetűket tartalmaz (ASCII [A-Za-z]).
- A `b` sztring csak angol nagybetűket tartalmaz (ASCII [A-Z]).

## Kimeneti formátum:
Minden lekérdezésre egy új sorban írj ki egy `"YES"`-t vagy `"NO"`-t, attól függően, hogy az `a` sztring átalakítható-e a `b` sztringgé.

---

## Megoldás leírása:

A feladat megoldása dinamikus programozást (DP) használ, amely egy kétdimenziós táblát használ az átalakítások nyomon követésére.

### Dinamikus programozás (DP) táblázat

  A `dp[i][j]` értéke azt jelzi, hogy az első `i` karakterből álló `a` sztring átalakítható-e úgy, hogy megegyezzen az első `j` karakterből álló `b` sztringgel.
  
  Az átalakítások a következő műveletek által valósíthatók meg:
  1. **Nagybetűsítés**: Az `a` sztringben egy kisbetűs karaktert nagybetűvé alakíthatunk, ha az megegyezik a `b` sztring megfelelő karakterével.
  2. **Eltávolítás**: Az `a` sztringből kisbetűs karaktereket eltávolíthatunk anélkül, hogy bármilyen változást végeznénk a `b` sztringen.

### Kiinduló állapot

- **Alapértelmezett értékek**:  
  A `dp[0][0] = true`, mivel két üres sztring egyenlő.
  
  Az első sor (`dp[i][0]`) akkor lesz igaz, ha az `a` sztring első `i` karakterét teljesen kisbetűvé alakítjuk, mert ekkor az `a` sztring üres `b` sztringgé válhat.

### Átmeneti állapotok

- Ha az `a[i-1]` karakter és a `b[j-1]` karakter nagybetűs változatai megegyeznek, akkor a `dp[i][j]` értéke örökölhető az előző sorból (`dp[i-1][j-1]`).
  
- Ha az `a[i-1]` karakter kisbetűs, akkor azt el is hagyhatjuk, így a `dp[i][j]` örökölhető a `dp[i-1][j]` értékről, anélkül, hogy a `b` sztringet módosítanánk.

### Végeredmény

A végső eredmény a `dp[n][m]` cellában található, ahol `n` az `a` sztring hossza, és `m` a `b` sztring hossza. Ha `dp[n][m]` értéke igaz, akkor az `a` sztring átalakítható a `b` sztringgé, különben nem.

### Példa

#### Bemenet:

- `a = AbcDE`
- `b = ABDE`

#### DP táblázat (részletes magyarázattal):

|   |   | A | B | D | E |
|---|---|---|---|---|---|
|   | 0 | 1 | 2 | 3 | 4 |
| A | T | T | T | T | T |
| b |   | T | T | T | T |
| c |   |   | T | T | T |
| D |   |   |   | T | T |
| E |   |   |   |   | T |

Az `a` sztringből az első három karakter (`Abc`) kisbetűssé alakítható, majd a karakterek törölhetők, hogy a végén `ABDE`-t kapjunk. Ezért a válasz `"YES"` lesz.

#### Másik példa:

#### Bemenet:

- `a = AbcDE`
- `b = AFDE`

Az átalakítás nem lehetséges, mivel az `A` és az `F` nem egyezik meg, így a válasz `"NO"` lesz.
