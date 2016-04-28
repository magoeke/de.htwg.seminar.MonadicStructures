package foo

class Foo { def bar: Bar = new Bar }
class Bar { def baz: Baz = null }
class Baz { def compute: Int = 3}

object foo {
  def main(args: Array[String]) {
    val foo = new Foo;
    
    // NullPointerException normally unwanted but in this example provoked
    foo.bar.baz.compute 
  }
}