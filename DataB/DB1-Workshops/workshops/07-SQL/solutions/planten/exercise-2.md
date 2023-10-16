# 06 - Workshop SQL : Planten

## Oplossingen 2 - Aggregeren

1. Hoeveel planten telt het assortiment? Geef de kolom de naam 'aantal planten'.
    > aantal planten: 119
    ```sql
    SELECT COUNT(*) AS 'aantal planten' 
    FROM planten 
    ```

2. Hoeveel planten die bloeien (waarvoor kleur ingevuld) telt het assortiment?
    > aantal: 104
    ```sql
    SELECT COUNT(kleurID) AS Aantal 
    FROM planten 
    WHERE bl_b IS NOT NULL AND bl_e IS NOT NULL
    ```

3. Hoeveel verschillende bloeikleuren komen er in het assortiment voor?
    > aantal: 12
    ```sql
    SELECT COUNT(DISTINCT kleurID) AS Aantal 
    FROM planten 
    ```

4. Bij hoeveel leveranciers werd er reeds een bestelling geplaatst?
    > aantal leveranciers: 9
    ```sql
    SELECT COUNT(DISTINCT levCode) AS 'aantal leveranciers' 
    FROM bestellingen 
    ```

5. Hoeveel verschillende artikelen zijn er reeds besteld geweest.
    >  aantal: 68
    ```sql
    SELECT COUNT(DISTINCT artcodeLev) AS Aantal 
    FROM bestellijnen 
    ```

6. Geef een overzicht van het aantal leveranciers per woonplaats.
    > 4 in Lisse, 2 in Hillegom, 4 in Aalsmeer, 1 in Heemstede
    ```sql 
    SELECT woonplaats, COUNT(*) AS Aantal 
    FROM leveranciers 
    GROUP BY woonplaats 
    ```

7. Toon voor de tabel planten de gemiddelde hoogte en de som van alle hoogtes gedeeld door het aantal planten. Zijn deze gelijk? Waarom? 
    - Nee,  `NULL` waarden!
    > som: 337,1849 - gemiddeld: 364,7727
    ```sql
    SELECT SUM(hoogte)/COUNT(*), AVG(hoogte) 
    FROM planten 
    ``` 

8. Welke leveranciers bieden minstens 20 planten aan waarvan de levertermijn kleiner is dan 17 dagen. Toon code van de leverancier en het aantal verschillende planten. De leverancier die het meeste aantal planten aanbiedt staat bovenaan.
    >  4 records, 1ste record: levcode: 013 - aantal art.: 31
    ```sql
    SELECT levcode, COUNT(artcodelev) AS 'Aantal artikelen' 
    FROM offertes 
    WHERE levertermijn < 17 
    GROUP BY levcode 
    HAVING COUNT(artcodelev) > 20 
    ORDER BY  COUNT(artcodelev) DESC 
    ```

9. Geef per bestelling het aantal bestellijnen, gesorteerd op aantal lijnen.
    > 15 records
    ```sql
    SELECT bestelnr, COUNT(*) AS 'Aantal bestellijnen' 
    FROM bestellijnen 
    GROUP BY bestelnr 
    ORDER BY  COUNT(*) 
    ```

10. Wat is de laagste offerteprijs voor de plant met artikelcode 123.
    > laagste offerteprijs: 0,35
    ```sql
    SELECT MIN(offerteprijs) AS 'laagste offerteprijs' 
    FROM offertes 
    WHERE artcode='123' 
    ```

11. Hoeveel artikels met artcodelev B111 werden reeds besteld?
    > totaal aantal: 75
    ```sql
    SELECT SUM(aantal) AS 'Totaal aantal' 
    FROM bestellijnen 
    WHERE artCodeLev='B111' 
    ```

12. Geef per artikel (artcode) de minimale en maximale offerteprijs.
    > 119 records
    ```sql
    SELECT artcode, MIN(offerteprijs) AS 'min prijs', MAX(offerteprijs) AS 'max prijs' 
    FROM offertes 
    GROUP BY artcode 
    ```

13. Geef per levertermijn de gemiddelde offerteprijs.
    > 4 records - 1ste record: levertermijn: 7 - gemiddelde prijs: 0,651613
    ```sql
    SELECT levertermijn, AVG(offerteprijs) AS 'gemiddelde prijs' 
    FROM offertes 
    GROUP BY levertermijn 
    ```

14. Welke is alfabetisch gezien de eerste naam van de planten uit het assortiment.
    > naam: Acacia
    ```sql
    SELECT MIN(naam) 
    FROM planten 
    -- OF
    SELECT naam 
    FROM planten
    ORDER BY naam 
    LIMIT 1
    ```

15. Toon de lijst van de woonplaatsen waar 2 of meer leveranciers wonen. Sorteer alfabetisch.
    >  3 records - 4 in Aalsmeer, 2 in Hillegom, 4 in Lisse
    ```sql
    SELECT woonplaats, COUNT(*) AS Aantal 
    FROM Leveranciers 
    GROUP BY woonplaats 
    HAVING COUNT(*) >= 2 
    ORDER BY woonplaats 
    ```

## Oefeningen
Klik [hier](../../exercises.md) om terug te gaan naar de oefeningen.
