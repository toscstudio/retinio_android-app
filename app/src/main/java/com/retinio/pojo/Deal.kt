package com.retinio.pojo

/**
 * Created by championswimmer on 15/4/16.
 */

class Deal {
    enum class DealTypes {
        CHECKUP,
        EYEWEAR
    }
    var name:String = "";
    var desc:String = "";
    var storeName:String = "";
    var dealType:DealTypes = DealTypes.EYEWEAR;


}
