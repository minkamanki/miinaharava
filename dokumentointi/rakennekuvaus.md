##Rakennekuvaus
Ohjelmassani on kolme erillistä pakkausta: main, pelilogiikka ja kayttoliittyma. Main pakkaus sisältää vain Main -luokan, jossa on ainoastaan main metodi, josta kutsutaan kayttoliittyma paketin Kayttoliittyma luokkaa. Kayttoliittyma pakkauksessa on tämän luokan lisäksi myös luokat Valikko, HiirikuuntelijaKentta, Piirtoalusta ja UusiPeli. Kayttoliittyma -luokalla on ilmentymät kaikista näistä luokista, ja se kutsuu näitä luokkia metodeissaan. Piirtoalusta on myös tietoinen Peli -luokasta, joka sijaitsee pelilogikka -pakkaukesssa. Siellä on lisäksi Kentta ja Laatta luokat. Tämän pakkauksen luokat vastaavat pelin logiikasta.  

Latta -luokassa on tiedot, yksittäisen laattaolion tiedot. Kentta luokassa ne asetetaan ja luodaan, ja niitä myös kutusutaan sitä kautta. Peli luokka pitää tietoa häviämisestä, sekä luo oikean tasoisen kentän.  

Valikko -luokka luo kolme nappia, joilla käyttäjä voi valita haluamansa tason pelille. Piirtoalusta piirtää kentän konkreettisena laattojen mukaisesti. HiirikuuntelijaKentta taas välittää tiedon mihin kohtaan käyttäjä on klikannut ja kummalla hiiren näppäimellä. Häviön tai voiton jälkeen ponnahtaa esiin uusi ikkuna, jonka luo UusiPeli luokka. Se luo kaksi nappia, joilla käyttäjä voi valita uuden pelin tai pelin lopetuksen.

![luokkakaavio](luokkakaavio.png)
