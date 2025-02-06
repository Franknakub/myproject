# แบบข้อเสนอโครงงาน

  

## ชื่อโครงงาน


Final Journey

## สมาชิก
 

1. นายสุจินตกร แซ่โง้ว 6730300922

2. นายศุภวิชญ์ ไชญานุศักดิ์ 6730300591

  

## รายละเอียดโดยย่อ



โครงงานนี้เป็นเกมผจญภัย 2 มิติ(2D Adventure Game) ผสมกับเกมแนวเทิร์นเบส(turn based game) ซึ่งผู้เล่นจะรับบทเป็นผู้กล้าที่กำลังบุกตะลุยในปราสาทของจอมมาร เผื่อสังหารจอมมารและ"ช่วยโลกใบนี้ไว้" ผู้เล่นสามารถขยับตัวละครเพื่อไปชนศัตรูแล้วจะเข้า combat mode ที่เป็น turn based

  

## คุณลักษณะและขอบเขต

  
### คุณลักษณะขั้นต่ำ


- ตัวละครหลักเป็นตัวละครผู้กล้า ซึ่งจะสามรถเดินบนฉากได้4ทิศทาง 

- จะมีฉากศัตรูอยู่ในฉาก เมื่อเดินชนศัตรูจะเข้าcombat mode

- combat mode จะเป็นแนว turn based สลับกันออก action

- มี action หลักๆ 3 แบบ attack , skill, defence

- มีระบบ Save/Load เพื่อบันทึกความคืบหน้าของเกมและกลับมาเล่นต่อได้
  


### คุณลักษณะเพิ่มเติม


- การออกสกิลมี animation(เท่าที่ทำได้)

- มีศัตรูมากกว่า 2 ตัว

- มีระบบเลเวล และไอเท็มสวมใส่

- มีฉากมากกว่า 1

  

## แผนการดำเนินโครงงาน

  

ร่างแผนการดำเนินโครงงานในระยะเวลา 2 เดือน (8 สัปดาห์) โดยระบุผลลัพธ์ที่คาดหวังว่าจะทำได้เสร็จในแต่ละระยะ เช่น

 
 เริ่มต้นโครงงาน สัปดาห์ที่ 1-2 
- ส่งข้อเสนอโครงงาน
- สร้าง GitHub repository
- สร้างโครงงานด้วย Maven และเขียนโค้ดตั้งต้น 
- ศึกษาเกี่ยวเกมเเนว Turn based rpg ใน Internet
- เเบ่งงานกันทำว่าเเต่ละคนจะทำส่วนไหนบ้าง
- สร้างเป้าหมายในเเต่ละวัน เช่น วันนี้จะทำให้ตัวละครสามารถตีกันได้

สร้างต้นแบบ     สัปดาห์ที่ 3-4 
- โปรแกรม/เกมทำงานได้ในเบื้องต้น
- มีฟีเจอร์หลัก (core feature) ที่ใช้งานได้     
- ถ้ามีเวลาเหลือทำ Feature เพิ่มเติม เช่น ระบบไอเทมส่วมใส่,ระบบlevel up,skill อนิเมชั่น,ระบบธาตุ

 ทดลองใช้งาน  สัปดาห์ที่ 5-6 
- ฟีเจอร์ส่วนใหญ่พร้อมใช้งาน
- โปรแกรมสามารถใช้งานได้ แต่อาจต้องปรับแก้หรือเพิ่มเติม
- ถ้ามีเวลาเหลือทำ Feature เพิ่มเติม เช่น ระบบไอเทมส่วมใส่,ระบบlevel up,skill อนิเมชั่น,ระบบธาต

 พร้อมส่งมอบงาน   สัปดาห์ที่ 7-8 
 - โปรแกรม/เกมมีฟีเจอร์ครบถ้วนตามที่วางแผน
 - เอกสารประกอบสมบูรณ์ พร้อมสำหรับการนำเสนอ  
 - ซ้อมPresent 
 - อ่าน/จำข้อมูลที่จะนำเสนอก่อนมานำเสนอ

**หมายเหตุ**

- ฟีเจอร์หลัก (core feature) หมายถึงฟีเจอร์สำคัญที่ทำให้โปรแกรม/เกมบรรลุวัตถุประสงค์หลัก

- MVP (Minimum Viable Product) คือเป้าหมายขั้นต่ำที่สามารถส่งมอบได้ อย่างไรก็ตาม ฟีเจอร์หลักอาจเป็น subset ของ MVP ได้ในบางกรณี

  

## การแบ่งงาน

ระบุแผนการแบ่งความรับผิดชอบของสมาชิกแต่ละคนในการทำโครงงาน ทั้งนี้ สมาชิกทุกคนต้องมีส่วนร่วมในการเขียนโค้ด เช่น
  

- **ศุภวิชญ์ ไชยานุศักดิ์**:

    - เขียนโค้ดส่วน 
       1. ตัวละครหลักเป็นตัวละครผู้กล้า ซึ่งจะสามรถเดินบนฉากได้4ทิศทาง
       2. จะมีศัตรูอยู่ในฉาก เมื่อเดินชนจะเข้าcombat mode
       3. combat mode จะเป็นแนว turn based สลับกันออก action

    - ออกเเบบตัวละคร
    - จัดการ GitHub repository
    - ทดสอบระบบ
    - ทำเอกสาร

- **สุจินตกร แซ่โง้ว**:

    - เขียนโค้ดส่วน
        1. มี action หลักๆ 3 แบบ attack , skill, defence
        2. มีระบบ Save/Load เพื่อบันทึกความคืบหน้าของเกมและกลับมาเล่นต่อได้

    - ออกเเบบตัวละคร
    - จัดการ GitHub repository
    - ทดสอบระบบ
    - ทำเอกสาร

  

## ความท้าทายและความเสี่ยง
  

**ความท้าทายด้านการพัฒนาเกมด้วย FXGL**:

    - ต้องเรียนรู้ FXGL เพิ่มเติม เพราะไม่รู้อะไรเลยเกียวกับ JavaFX และ FXGL

    - **แนวทางแก้ไข**: ทำตาม tutorial ใน FXGL Wiki (https://github.com/AlmasB/FXGL/wiki/FXGL-11) เพื่อพัฒนาความเข้าใจและศึกษาเพิ่มเติมจากวิดีโอในยูทูป หรือ สอบถามอาจารย์เพื่อเป็นแนวทาง

 **ความเสี่ยงด้านเวลา**:

    - หากใช้เวลาเรียนรู้ส่วนประกอบใหม่มากเกินไป อาจทำให้พัฒนาโค้ดไม่ทัน

    - **แนวทางแก้ไข**: วางแผนฝึกทักษะคู่ไปกับการพัฒนาโครงงาน และติดตามความคืบหน้า (progress) ของตนเองทุกสัปดาห์ และปรึกษาสอบถามความรู้เพิ่มเติมเพื่อเป็นแนวทางในการพัฒนาได้ไวขึ้น

 **ความท้าทายในการออกแบบไอเดียเกม**

    - เกมแนวturn basedจากที่ดูมาหาตัวอย่างได้น้อยมาก

    - **แนวทางแก้ไข**: ศึกษาเพิ่มเติมจากคยอื่นที่ทำไว้ในเครื่องมืออื่นนำมาประยุกต์ และปรึกษาอาจารย์เพื่อขอแนวทาง   


## ต้นแบบและเอกสารอ้างอิง

- FXGL Tutorial: [https://github.com/AlmasB/FXGL/wiki/FXGL-11](https://github.com/AlmasB/FXGL/wiki/FXGL-11)

- [ลิงก์ GitHub ของโปรแกรมที่ใช้เป็นตัวอย่าง](https://github.com/AlmasB/Zephyria)

- [ลิงก์ GitHub ของโปรแกรมที่ใช้เป็นตัวอย่าง](https://github.com/chandradharrao/Turn-Based-Console-Game-Using-Java/tree/main)