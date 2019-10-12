# Matrix cipher

__Opis metody:__ 

Jest to prosty szyfr przestawieniowy oparty na figurze geometrycznej. W tym przypadku jest to kwadrat. Szyfrowanie polega na wprowadzeniu tekstu do macierzy po kolei wierszami a następnie odczytanie tekstu z macierzy kolumnami.

Przykład:

Tekst jawny: AlgorytmyiStrukturyDanych

Tekst zapisujemy w kwadrat 5x5

Algor

ytmyi

Struk

turyD

anych

Następnie odczytujemy kolumnami: AyStalttungmrryoyuycrikDh

Aby odszyfrować dany tekst należy operację powtórzyć drugi raz. Otrzymany tekst będzie tekstem jawnym.

__Opis procedury:__

Wszystkie znaki z pliku wejściowego przenoszone są do tablicy pomocniczej. Dodatkowo obliczana jest liczba tych znaków (i). Na podstawie tej liczby obliczana jest wielkość potrzebnej macierzy kwadratowej. Następnie macierz tą wypełniamy jakimiś symbolami. W moim przypadku macierz wypełniana jest spacjami. Następnie przepisujemy znaki z tablicy pomocniczej do macierzy a następnie odczytujemy z macierzy kolumnami zapisując do pliku wynikowego.
