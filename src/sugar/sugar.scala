package sugar

object sugar {
  def main(args: Array[String]) {
    val first = List(1, 2)
    val second = List(3, 4)
    val third = List(5, 6)
    
    // ------------------------------------ level 0 depth
    var res1 = for{f <- first} yield f*2
    var res2 = first.map(_ * 2)
    println(res1 == res2) // true
    
    // ------------------------------------ level 1 depth
    res1 = for{ 
      f <- first  
      s <- second } yield f*s
      
    res2 = first.flatMap(f => 
        second.map(s => f * s)
      )
    
    println(res1 == res2) // true
    
    // ------------------------------------ level 2 depth
    res1 = for{
      f <- first
      s <- second
      t <- third} yield f*s*t
    
    res2 = first.flatMap(f =>
        second.flatMap(s =>
          third.map(t => f*s*t)
        )
      )
      
    println(res1 == res2) // true
    
    // ------------------------------------ level 1 depth with filter
    def isEven(i: Int): Boolean = {
        return ((i % 2) == 0)
      }
      
    res1 = for{
      f <- first
      s <- second
      if (isEven(f*s))
    } yield f*s
    
    res2 = first.flatMap(f =>
      second.filter(s => isEven(f*s))
        .map(s => f*s))
    
    println(res1 == res2) // true
  }
  
}