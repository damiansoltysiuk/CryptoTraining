# AtBash

__Opis metody:__ 

Zasada jego działanie polega na podstawieniu zamiast jednej litery, litery lezącej po drugiej stronie alfabetu w takiej samej odległości od końca/początku. Najłatwiej będzie wyjaśnić to na przykładzie. Otóż za literę a powinniśmy podstawić literę z. Natomiast za literę c literę 3 od końca alfabetu a wiec literę x. Warto zauważyć, że aby odszyfrować wiadomość należy ją ponownie zaszyfrować. Otrzymamy tym samym tekst jawny.

__Opis procedury:__ 

Szyfrowany/deszyfrowany tekst znajduje się w zmiennej. Za każdym razem pobierana jest jedna litera tekstu. Następnie według kod ASCII przydzielana jest ona do trzech możliwych grup: duże litery, małe litery lub cyfry. Kolejna wykonywana operacja to odejmowanie wartości pierwszej litery alfabetu, tak ze teraz litera a otrzymuje numer 0, litera b 1 itd. Teraz wystarczy wykonać odejmowanie 25 - numer litery, aby otrzymać literę zaszyfrowaną. I tak jak szyfrujemy literę a to od 25 odejmujemy 0 i otrzymujemy 25, czyli numer litery z (trzeba pamiętać, ze liczymy w tym przypadku od zera wiec 26. litera (z) ma numer 25). Oczywiście jeżeli ktoś chciałby to może na początku odjąć liczbę o jeden mniejsza niż w moim przypadku i wtedy litera a będzie miała numer 1 i wtedy odejmujemy od 26.
