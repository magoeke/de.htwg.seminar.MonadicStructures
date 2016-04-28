package url

import java.net.URL
import java.net.MalformedURLException

object parser { 
  def main(args: Array[String]) {
    val validUrl = "http://www.htwg-konstanz.de"
    val invalidUrl = "MSI"
    
    // Added some output for better understanding
    var res = getURL(validUrl)
    println(res)
    res = getURL(invalidUrl)
    println(res)
  }
  
  def getURL(url: String) = {
    try {
      new URL(url) // It's a valid URL
    } catch {
      case ex: MalformedURLException =>{
        null // It's no valid URL.
      }
    }
  }
}