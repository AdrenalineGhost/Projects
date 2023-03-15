// See https://aka.ms/new-console-template for more information
using Bibliotheek;

//Dictionary<string, Func<Boek, string>> formats = new();
//Dictionary<string, Action<string>> show = new();
//Dictionary<string, Func<Boek, Boek, int>> sortMethods = new();

Dictionary<string, FormatDelegate> formats = new();
Dictionary<string, ShowDelegate> show = new();
Dictionary<string, SortDelegate> sortMethods = new();
InitDictionays();

BoekenLijst lijst = new BoekenLijst();
string type = ReadInput("Beschikbare formaten:", formats.Keys.ToArray());
string showtype = ReadInput("Beschikbare presentaties:", show.Keys.ToArray());
string sorttype = ReadInput("Beschikbare sorteermethodes:", sortMethods.Keys.ToArray());
lijst.Print(show[showtype], formats[type], sortMethods[sorttype]);


string ReadInput(string vraag, string[] waarden)
{
    Console.WriteLine(vraag);
    foreach (string t in waarden)
    {
        Console.WriteLine("\t" + t);
    }
    Console.Write("\nGeef je keuze: ");
    return Console.ReadLine();
}
void InitDictionays(){
    formats["csv"] = FormatCsv;
    formats["Mooi"] = FormatMooi;
    //extra formaten toegevoegd
    formats["titel"] = b => b.Titel;
    formats["uitgeverij"] = b => b.Titel + " (" + b.Uitgeverij + ")";

    show["print"] = b => Console.WriteLine(b);
    show["printGreen"] = PrintGreen;
    // show["messagebox"] = ShowBox;
    show["printToFile"] = WriteFile;

    sortMethods["titel"] = SortTitel;
    sortMethods["auteur"] = (b1, b2) => b1.Auteur.CompareTo(b2.Auteur); ;
    sortMethods["jaartal"] = SortJaartal;
    //extra sorteermethode toegevoegd
    sortMethods["all"] = SortAll;
}

#region Show functies
void WriteFile(string s)
{
    using StreamWriter file = new("boekenlijst.txt");
    file.Write(s);
    Console.WriteLine("Weggeschreven naar bin\\Debug\\net6.0\\boekenlijst.txt");
}


void PrintGreen(string s)
{
    Console.ForegroundColor = ConsoleColor.Green;
    Console.WriteLine(s);
    Console.ResetColor();
}

#endregion

#region Formatfuncties
string FormatCsv(Boek b)
{
    return $"{b.Id};{b.Titel};{b.Auteur};{b.Uitgeverij};{b.Jaartal}";
}

string FormatMooi(Boek b)
{
    return $"{b.Auteur} schreef het boek '{b.Titel}' in {b.Jaartal}.";
}
#endregion

#region sort functies
int SortTitel(Boek x, Boek y)
{
    return x.Titel.CompareTo(y.Titel);
}

int SortJaartal(Boek x, Boek y)
{
    return x.Jaartal.CompareTo(y.Jaartal);
}

int SortAll(Boek x, Boek y)
{
    string sortX = "" + x.Jaartal + "-" + x.Uitgeverij + "-" + x.Auteur + "-" + x.Titel;
    string sortY = "" + y.Jaartal + "-" + y.Uitgeverij + "-" + y.Auteur + "-" + y.Titel;
    return sortX.CompareTo(sortY);
}
#endregion

// Replace "Func<Boek, string>" with "FormatDelegate"
public delegate string FormatDelegate(Boek b);
// Replace "Action<string>" with "ShowDelegate"
public delegate void ShowDelegate(string s);
// Replace "Func<Boek, Boek, int>" with "SortDelegate"
public delegate int SortDelegate(Boek b1, Boek b2);