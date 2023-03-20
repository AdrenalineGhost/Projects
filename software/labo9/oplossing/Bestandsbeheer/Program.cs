// See https://aka.ms/new-console-template for more information
//Read files
using Bestanden;

Console.Out.Write("Enter file name or STOP to exit: ");
string? filename = Console.ReadLine();
while (filename?.ToUpper() != "STOP")
{
    IFile file = new CachingProxyFile(filename);
    
    Console.WriteLine("=== 1 === " + filename + " ======");
    Console.WriteLine(file.Content);

    Console.WriteLine("=== 2 === " + filename + " ======");
    Console.WriteLine(file.Content);  //twee keer de content ophalen

    Console.WriteLine("============================");
    Console.Out.Write("\nEnter file name or STOP to exit: ");
    filename = Console.ReadLine();
}
