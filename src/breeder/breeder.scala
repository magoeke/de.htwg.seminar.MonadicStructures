package breeder

class PetOwner(pet: Pet) { def getPet: Pet = pet }
class Pet { def getBreeder: Breeder = new Breeder }
class Breeder { def getName: String = "Georg" }

object breeder {
  def main(args: Array[String]) {
    var hans = new PetOwner(new Pet())
    hans.getPet.getBreeder.getName

    var moritz = new PetOwner(null)
    // nested if to avoid NullPointerException
    // other possible solution is try catch
    if(moritz.getPet != null) {
      if(moritz.getPet.getBreeder != null) {
        moritz.getPet.getBreeder.getName
      } else
        null
    } else
      null    
  }
}