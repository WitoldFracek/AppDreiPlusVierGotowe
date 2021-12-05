package com.example.appdreiplusvier

class RGBConverter {



    companion object {
        val hex = arrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')

        fun toHex(red: Int, green:Int, blue: Int): String {
            var ret = "#FF"
            ret += hex[(red % 256) / 16]
            ret += hex[(red % 16)]
            ret += hex[(green % 256) / 16]
            ret += hex[(green % 16)]
            ret += hex[(blue % 256) / 16]
            ret += hex[(blue % 16)]
            return ret
        }

        fun map(arg: Int, start: Int, end: Int, new_start: Int, new_end: Int): Int {
            return arg * (new_end - new_start) / (end - start)
        }
    }
}