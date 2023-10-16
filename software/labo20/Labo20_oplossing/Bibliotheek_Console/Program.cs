// See https://aka.ms/new-console-template for more information
using Bibliotheek;
using Bibliotheek.Stap1; //zonder reflexie
//using Bibliotheek.Stap2; //met reflexie

Library library = new();

//Console.Out.WriteLine("Aantal items: " + library.Items.Count);

Console.WriteLine("\n\nAlle titels op niveau 1:");
foreach (var item in library)
{
    Console.Out.WriteLine(item.Title);
}

Console.WriteLine("\n\nAlle titels:");
foreach (String titel in library.Titles)
{
    Console.WriteLine("-" + titel);
}

IVisitor visitor = new PrintVisitor();
library.Visit(visitor);  //voeg extra methode toe in Library 
//visitor.Visit(library);  //Gebruikt de extra methode van Library niet     
Console.Out.WriteLine();

IVisitor visitor2 = new AuteursVisitor();
visitor2.Visit(library);