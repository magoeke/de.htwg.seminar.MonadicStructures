package url
// source: http://danielwestheide.com/blog/2012/12/26/the-neophytes-guide-to-scala-part-6-error-handling-with-try.html

import java.net.URL
import java.io.InputStream
import scala.util.Try

object parser { 
  def main(args: Array[String]) {
    val validUrl = "http://www.htwg-konstanz.de"
    val invalidUrl = "MSI"
    
    // Added some output for better understanding
    var res1 = getURL(validUrl)
    println(res1)
    res1 = getURL(invalidUrl)
    println(res1)
    
    // more exciting example
    var res2 = inputStreamForURL(validUrl)
    println(res2)
    res2 = inputStreamForURL(invalidUrl)
    println(res2)
  }
  
  def getURL(url: String): Try[URL] = { Try(new URL(url)) }
  
  def inputStreamForURL(url:String): Try[InputStream] = for {
    u <- getURL(url)
    c <- Try(u.openConnection())
  } yield c.getInputStream()
    
}