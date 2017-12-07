package lesson8

fun space(numSpace: Int, numPlace: Int): MutableList<String> {
    val count = numSpace / numPlace
    var rest = numSpace % numPlace
    var number :Int
    val spaceString = mutableListOf<String>()
    var space = ""

    for (i in 0 until numPlace) {
        number = count
        if (rest > 0)
            number++
        rest--
        for (j in 0 until number) {
            space += " "
        }
        spaceString.add(space)
        space = ""
    }
    return spaceString
}