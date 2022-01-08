import org.apache.jena.rdf.model.ModelFactory
import org.apache.jena.rdf.model.impl.PropertyImpl

import scala.collection.mutable.ListBuffer

object Main extends App {
    val model = ModelFactory.createDefaultModel()
    /*
    val s1 = model.createResource("http://upem.fr/example/macarron")
    val o1 = model.createResource("http://upem.fr/example/cookies")
    val p1 = model.createProperty("http://upem.fr/example/loves")
    val stat1 = model.createStatement(s1, p1, o1)
    model.add(stat1)
    val lst = model.listStatements()
    while (lst.hasNext())
        println(lst.next())
    println(model.size())
     */

    /* Question 3.1 : */
    model.read("file:drugbank_dump.nt", "N-TRIPLE")
    println(model.size())

    /* Question 3.2 : */
    def typePropertySize() = {
        val prop = model.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type")
        val lst = model.listResourcesWithProperty(prop).toList
        println(lst.size())
    }
    typePropertySize()


    /* Question 3.3 : */
    def numberOfDrugs() = {
        val prop = model.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type")
        val res = model.createResource("http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/drugs")
        val lst = model.listSubjectsWithProperty(prop, res).toList
        println(lst.size())
    }
    numberOfDrugs()

    /* Question 3.4 : */
    def distinctProperties() = {
        val lstst = model.listStatements()
        val properties = new ListBuffer[String]()
        while (lstst.hasNext) {
            val next = lstst.next()
            properties += next.getPredicate().getURI()
        }
        println(properties.distinct.size)
        /* Question 3.6 : */
        val propertiesfinal = properties.distinct.toList
        propertiesfinal.foreach(x => println(x))
    }
    distinctProperties()

    /* Question 3.5 : Il y a 3 namespaces w3, wiwiss et xmlns */

    /* Question 3.7 : */
    def nameOfDrugs() = {
        val prop = model.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type")
        val res = model.createResource("http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugbank/drugs")
        val lst = model.listSubjectsWithProperty(prop, res)
        val drugs = new ListBuffer[String]()
        while (lst.hasNext) {
            drugs += lst.next().getURI()
        }
        drugs.foreach(x => println(x))
    }
    nameOfDrugs()



}