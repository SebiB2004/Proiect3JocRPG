# Proiect3JocRPG
1. Instalare SQLite pentru Baza de Date

Cum sa iti aplici baza de date 
https://www.sqlite.org/index.html -> Downloads -> Precompiled Binaries -> sqlite-tools-win-x64-3470000.zip -> extract -> ca sa iti pornesti baza de date -> sqlite3.exe (sau la mine pe win11 e app(.exe))
Daca esti pe Linux -> actualizeaza pachetele (sudo apt update) -> sudo apt install sqlite3 (verifica daca e versiunea de actualitate) -> verifica instalarea prin comanda in terminal : "sqlite3 --version" (fara ghilimele)
// Exista o optiune pentru a combina SQLite cu IntelliJ , dar ai nevoie de IntelliJ Idea Ultimate , Ultimate avand un built-in tool pentru baze de date

2. Setup SQLite

Descarcare Maven Repository pentru SQLite JDBC : https://github.com/xerial/sqlite-jdbc?tab=readme-ov-file#download
Dupa descarcare va trebuii sa copiezi fisierul in proiectul java , in acest proiect ar venii : folder/directory unde este salvat proiectul -> Proiect3JocRPG-main->proiect3 si in acest folder vei crea un fisier cu numele lib in care vei copia fisierul cu JDBC.
Structura proiectului va arata ceva in genul acesta : .idea , imagini , lib , src , gitignore , proiect3.iml

3. Configurarea IDE-ului pentru a folosi .jar

Navigheaza la File -> Project Structure.
In fereastra care se deschide, alege Modules in meniul din stanga.
Selecteaza tab-ul Dependencies.
Apasa pe butonul +, apoi alege JARs or directories....
Gaseste folderul lib din proiectul tau, selecteaza fisierul .jar copiat acolo si apasa OK.
Vei vedea .jar-ul in lista de dependente. Confirma si inchide fereastra (Apply și OK). (Personal era un checkbox acolo , in caz de orice eu i-am dat si check si pare sa fie ok)

4. Verificarea Functionalitatii

Am creat o clasa simpla de test pentru a verifica daca recunoaste biblioteca SQLite numita SQLiteTest.java
