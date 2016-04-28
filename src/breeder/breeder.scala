package breeder

class PetOwner(pet: Pet) { def getPet: Option[Pet] = Option(pet) }
class Pet { def getBreeder: Option[Breeder] = Option(new Breeder) }
class Breeder { def getName: String = "Georg" }

object breeder {
  
  // This methods are created to handle Option step by step
  def findOutName(breeder: Breeder): String = breeder.getName
  def findOutBreeder(pet: Pet): Option[String] = pet.getBreeder.map(findOutName(_))
  def findOutPet(petOwner: PetOwner): Option[String] = petOwner.getPet.flatMap(findOutBreeder(_))
  
  def main(args: Array[String]) {
    var hans = new PetOwner(new Pet())
    var moritz = new PetOwner(null)
    
    findOutPet(hans)
    findOutPet(moritz)
  }
}