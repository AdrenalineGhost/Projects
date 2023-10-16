// See https://aka.ms/new-console-template for more information

using BibliotheekConsole;
using BibliotheekConsole.Pattern;
using Catalogus;
using System.Collections;
using System.IO.IsolatedStorage;
using System.Runtime.CompilerServices;

IEnumerable<int> fibonacci(int x)
{
    var a = 1; var b = 2;
    yield return a; yield return b;
    for (int i = 0; i < x; i++)
    {
        var temp = a;
        a=b; b = temp + b;
        yield return b;
    }
}

//Dummy();

foreach (var item in fibonacci(10))
{
    Console.WriteLine(item);
}
foreach (var item in new Fibonacci(10))
{
    Console.WriteLine(item);
}

void YamlBibliotheek()
{
    YamlBibliotheek bib = new();
    IBibItem start = bib.Bibliotheek;
    Console.WriteLine(start.Toon(0));
 
}
void Dummy()
{
    DummyBibliotheek bib = new();
    IBibItem start = bib.Bibliotheek;
    Console.WriteLine(start.Toon(0));

    IBibItem item = start.Zoek("ID07");
    Console.WriteLine(item.Toon(0) + "\n");

    Console.WriteLine("ZoekTrefwoord:");
    ISet<IBibItem> gevonden = start.ZoekTrefwoord("en");
    foreach (IBibItem ib in gevonden)
    {
        Console.WriteLine(ib.Toon(0));
    }
}
void Test()
{
    var temp = new Director();
    Console.WriteLine(temp.BuildLibraryFromYAML("library.yaml").Toon(0));
}

class Fibonacci : IEnumerable<int>
{
    int n;
    public Fibonacci(int n)
    {
        this.n = n;
    }

    public IEnumerator<int> GetEnumerator()
    {
        int a = 1; int b = 2;
        yield return a;
        yield return b;

        for (int i = 0; i < n; i++)
        {
            int temp = a;
            a = b;
            b = temp + b;
            yield return b;
        }
    }

    IEnumerator IEnumerable.GetEnumerator()
    {
        return GetEnumerator();
    }
}

