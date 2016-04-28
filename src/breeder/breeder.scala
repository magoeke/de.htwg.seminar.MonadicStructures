package breeder

class PetOwner(pet: Pet) { def getPet: Option[Pet] = Option(pet) }
class Pet { def getBreeder: Option[Breeder] = Option(new Breeder) }
class Breeder { def getName: String = "Georg" }

object breeder {
  def main(args: Array[String]) {
    var hans = new PetOwner(new Pet())
    var moritz = new PetOwner(null)
 
    getBreeder(hans)
    getBreeder(moritz)
    
    //Added some output for understanding
    println(getBreeder(hans))
    getBreeder(hans).map(println)
    println(getBreeder(moritz))
    getBreeder(moritz).map(println)
  }
  
  def getBreeder(petOwner: PetOwner): Option[String] = {
    petOwner.getPet.flatMap(pet => 
      pet.getBreeder.map( breeder => breeder.getName))
  }
}