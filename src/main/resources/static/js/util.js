const formatTime = date => {
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const day = date.getDate();
    const hour = date.getHours();
    const minute = date.getMinutes();
    const second = date.getSeconds();

    return [year, month, day].map(formatNumber).join('-') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

const formatNumber = n => {
    n = n.toString();
    return n[1] ? n : '0' + n;
}


const objHasNull = dic => {
    for (var k in dic) {
        if (dic[k] === null || dic[k] === "") return true;
    }
    return false;
}

const UUID = function () {
    let date = new Date();
    return randomNString(6) + (date.getTime()).toString(16).substring(5) + randomNString(6);
};

const randomNString = n => {
    var data = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"];
    var result = "";
    for (var i = 0; i < n; i++) {
        var r = Math.floor(Math.random() * 60);     //取得0-62间的随机数，目的是以此当下标取数组data里的值！
        result += data[r];        //输出20次随机数的同时，让rrr加20次，就是20位的随机字符串了。
    }
    return result;
}






