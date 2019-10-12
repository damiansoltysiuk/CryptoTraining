# Vigenere cipher

__Opis metody:__

Tekst szyfrujemy na podstawie hasła. Szyfrowanie odbywa się w sposób następujący. Każdą literę tekstu jawnego szyfrujemy korzystając z alfabetu zaczynającego się od odpowiadającej litery w haśle. W przypadku, gdy hasło jest krótsze od szyfrowanego tekstu powtarzamy je wielokrotnie.
Szyfrowanie i deszyfrowanie odbywa się na podstawie tablicy Vigenere'a.

__Opis procedury:__ 

Szyfrowany tekst znajduje się w zmiennej. Użytkownik podaje następnie hasło, korzystając jedynie z dużych liter z podstawowego alfabetu bez spacji i znaków interpunkcyjnych. Litery przepisywane są do tablicy hasło. Wartości ASCII tego hasła są przepisywane do tablicy tablica_ASCII (standardowo ustawiłem obie tablice na 200 elementów - jeżeli hasło byłoby dłuższe należy rozmiar ten w obu tablicach powiększyć). Gdy hasło jest krótsze następuje wartości wstawiane są od początku, aż zostanie wypełniona cała tablica. W przypadku gdy tekst jawny jest dłuższy niż 200 znaków należałoby również powiększyć obie wyżej wymienione tablice (w przypadku gdy byśmy tego nie zrobili korzystając z mojej procedury deszyfrującej odszyfrowanie powinno się powieść, jednak zostanie utracona ciągłość hasła i okres). Następnie otwierane są oba pliki i jeżeli operacja ta powiedzie się zaczyna się szyfrowanie. Za każdym razem pobierana jest jedna litera tekstu. Następnie według kod ASCII przydzielana jest ona do dwóch możliwych grup: duże lub małe litery. Wszystkie inne znaki w tym spacja podczas szyfrowania zostają usunięte. Każda pobrana litera jest następnie modyfikowana według odpowiadającej jej literze w haśle. Po zamianie każdej litery zapisywana jest ona w pliku wyjściowym. Na końcu oba pliki są zamykane i procedura kończy się.