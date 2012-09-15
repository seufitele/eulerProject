package problems41to50

import scala.collection.mutable.ArrayBuffer
import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.HashSet
import scala.collection.mutable.TreeSet

//Pentagonal numbers are generated by the formula, Pn=n(3n1)/2. 
//The first ten pentagonal numbers are:
//
//1, 5, 12, 22, 35, 51, 70, 92, 117, 145, ...
//
//It can be seen that P4 + P7 = 22 + 70 = 92 = P8. 
//However, their difference, 70 - 22 = 48, is not pentagonal.
//
//Find the pair of pentagonal numbers, Pj and Pk, for which 
//their sum and difference is pentagonal and 
//D = |Pk  Pj| is minimised; what is the value of D?
object Problem44 
{
	def main(args: Array[String]) 
	{
		def pentagonal(n : Long) = (n * (3 * n - 1)) / 2
		def isPentagonal(n : Long) = ((math.sqrt((24 * n) + 1) + 1) / 6).isWhole
		def penStream(n : Long) : Stream[Long] = pentagonal(n) #:: penStream(n + 1)
		
		lazy val penS = penStream(1)
		
		val sols = for (penta <- penS; penta2 <- penS.takeWhile(_ < penta); 
						if (isPentagonal(penta + penta2) && isPentagonal(penta - penta2))) 
				   yield (penta, penta2)
		
		val resp = sols.take(1).head
		println(resp._1 - resp._2) //5482660
	}

}