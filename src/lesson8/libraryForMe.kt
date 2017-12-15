package lesson8

fun space(numSpace: Int, numPlace: Int): MutableList<String> {
    val count = numSpace / numPlace
    var rest = numSpace % numPlace
    var number :Int
    val spaceString = mutableListOf<String>()

    for (i in 0 until numPlace) {
        val space = StringBuilder("")
        number = count
        if (rest > 0)
            number++
        rest--
        for (j in 0 until number) {
            space.append(" ")
        }
        spaceString.add(space.toString())
    }
    return spaceString
}


fun String.cleanRegex():String{
    val regex1 = Regex("\\.")
    val regex2 = Regex("\\*")
    val regex3 = Regex("\\+")
    val regex4 = Regex("\\?")

    val str = this
    if (regex1.findAll(str).count() > 0) str.replace(".*", "\\.")
    if (regex2.findAll(str).count() > 0) str.replace("*", "\\*")
    if (regex3.findAll(str).count() > 0) str.replace("+", "\\+")
    if (regex4.findAll(str).count() > 0) str.replace("?", "\\?")
    return str
}