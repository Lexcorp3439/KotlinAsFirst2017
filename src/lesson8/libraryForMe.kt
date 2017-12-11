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