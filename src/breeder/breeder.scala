package breeder

class PetOwner(pet: Pet) { def getPet: Pet = pet }
class Pet { def getBreeder: Breeder = new Breeder }
class Breeder { def getName: String = "Georg" }

object breeder {
  def main(args: Array[String]) {
    var hans = new PetOwner(new Pet())
    hans.getPet.getBreeder.getName

    var moritz = new PetOwner(null)
    // This creates an NullPointerException.
    // Same Problem as in foo
    moritz.getPet.getBreeder.getName    
  }
}