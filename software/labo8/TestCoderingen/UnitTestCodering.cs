using Coderingen;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestCoderingen
{
    [TestClass]
    public class UnitTestCodering
    {
        [TestMethod]
        public void TestNoCodering()
        {
            ICodering codering = new NoCodering();
            string zin = "Dit is een oefening op Design Patterns";
            Controleer(codering, zin, zin);
        }

        [TestMethod]
        public void BlokCodering()
        {
            ICodering codering = new NoCodering();
            codering = new Blok(codering);
            string zin = "Dit is een oefening op Design Patterns";
            string result = "4pzvu4xzrhvyahrhing0pob3esyngc21ttreh4";
            Controleer(codering, zin, result);
        }

        [TestMethod]
        public void TestWisselCodering()
        {
            ICodering codering = new NoCodering();
            codering = new Wissel(codering);
            string zin = "Dit is een oefening op Design Patterns";
            string result = "iD tsie neo feneni gpoD segi naPttresn";
            Controleer(codering, zin, result);
        }

        [TestMethod]
        public void TestCijferCodering()
        {
            ICodering codering = new NoCodering();
            codering = new Cijfer(codering);
            string zin = "Dit is een oefening op Design Patterns";
            string result = "68105116321051153210110111032111101102101110105110103321111123268101115105103110328097116116101114110115";
            Controleer(codering, zin, result);
        }

        [TestMethod]
        public void TestWisselWisselCodering()
        {
            ICodering codering = new NoCodering();
            codering = new Wissel(codering);
            codering = new Wissel(codering);
            string zin = "Dit is een oefening op Design Patterns";
            string result = zin;
            Controleer(codering, zin, result);
        }

        [TestMethod]
        public void TestWisselBlokCijferCodering()
        {
            ICodering codering = new NoCodering();
            codering = new Wissel(codering);
            codering = new Blok(codering);
            codering = new Cijfer(codering);
            string zin = "Test";
            string result = "11610110156";
            Controleer(codering, zin, result);
        }

        private void Controleer(ICodering codering, string zin, string result)
        {
            string gecodeerd = codering.Codeer(zin);
            Assert.AreEqual(result, gecodeerd);
        }
    }
}
