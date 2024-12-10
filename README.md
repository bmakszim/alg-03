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

