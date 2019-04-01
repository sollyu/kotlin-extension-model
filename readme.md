## 说明

这是一个kotlin语言的增强库，他的实现原理和kotlin原生增强库很像。

它集成了开发者常用的功能，就比如`String.md5`,`String.base64`等

## 使用

具体使用方法参照JitPack官方说明：[点击这里](https://jitpack.io/#sollyu/kotlin-extension-model/) 最新版本：[![](https://jitpack.io/v/sollyu/kotlin-extension-model.svg)](https://jitpack.io/#sollyu/kotlin-extension-model)

在需要使用增强的类中，直接实现`KIExtension*`类型即可使用

## 增强

### String类

```
String.mosaic
String.base64Encode
String.base64Decode
String.md5
String.md5_16
String.sha1
String.sha256
String.random
String.isContainChinese
String.isEmailValid
String.isPhoneNumber
String.toUpperCase
String.toLowerCase
```

### Date类

```
Date.format
Date.isToday
Date.isFuture
Date.isTomorrow
Date.add
Date.sub
Date.toCalendar
Date.dayMonth
Date.day
Date.toTime
Date.toSqlDate
```

### Calendar类

```
Calendar.formTimestamp
Calendar.fromDate
Calendar.getYear
Calendar.getMonth
Calendar.getDay
Calendar.getHour
Calendar.getMinute
Calendar.getSecond
Calendar.getMilliSecond
Calendar.toDate
```

### File类

```
File.readAsText
File.writeStringToFile
File.md5
File.deleteIfExist
File.clear
File.notExists
```