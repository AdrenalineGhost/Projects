# https://dodona.ugent.be/nl/courses/1745/series/19263/activities/1743447324

import random
#====================================================================

class Worp:
    def __init__(self):
        self.dobbel1 = random.randint(1,6)
        self.dobbel2 = random.randint(1,6)
        
    def getWaarde(self):
        return self.dobbel1+self.dobbel2
    
    def __repr__(self):
        return "{sum} ({dobbel1} , {dobbel2})".format(sum = self.getWaarde(), dobbel1 = self.dobbel1, dobbel2 = self.dobbel2)

#====================================================================

class Persoon:
    def __init__(self):
        self("Geen naam" , 0)
        
    def __init__(self,name,age):
        self.name, self.age = name, age
        
    def __repr__(self):
        return "{name}, {age} jaar".format(self.name,self.age)
    
    def getName(self):
        return self.name

#====================================================================

class Speler(Persoon):
    def __init__(self, name,age):
        self.besteWorp = Worp()
        super().__init__(name,age)
        
    def __repr__(self):
        # return "{sup}, beste worp: {worp}".format(sup = super(Speler,self).__repr__(), worp = self.besteWorp.getWaarde())
        return "Doesnt work!"
        
    
    
#====================================================================

    
if __name__ == '__main__':
    w = Worp()
    sp = Speler("marwan" , 21)
    print(w)
    # print("\n")
    print(sp)

