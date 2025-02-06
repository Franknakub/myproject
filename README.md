# แบบข้อเสนอโครงงาน

  

## ชื่อโครงงาน

  

_ตัวอย่าง:_ ระบบจัดการสินค้าออนไลน์ (Online Product Management)  

หรือ เกมผจญภัยในโลกอวกาศ (Space Adventure Game)

## สมาชิก

  

1. ชื่อ-นามสกุล รหัสนิสิต

2. ชื่อ-นามสกุล รหัสนิสิต

  

## รายละเอียดโดยย่อ

  

**คำแนะนำ**

  

- อธิบายโครงการโดยสรุป ใช้ภาษาที่กระชับ เข้าใจง่าย

- ระบุวัตถุประสงค์หรือสิ่งที่โปรแกรมต้องการแก้ปัญหา

- หากเป็นเกม ให้บอกแนวเกม รูปแบบการเล่น (gameplay) และเป้าหมายของผู้เล่น

  

**ตัวอย่างการเขียน (โปรแกรม)**

  

โครงงานนี้เป็นระบบจัดการสินค้าออนไลน์ (Online Product Management) ซึ่งมีวัตถุประสงค์เพื่ออำนวยความสะดวกให้ผู้ดูแลร้านค้าสามารถสร้าง เพิ่มเติม แก้ไข และลบข้อมูลสินค้าได้อย่างมีประสิทธิภาพ โดยผู้ใช้สามารถบันทึกข้อมูลสินค้าเก็บในไฟล์หรือฐานข้อมูล และเรียกกลับมาใช้ในภายหลังได้อย่างง่ายดาย

  

**ตัวอย่างการเขียน (เกม)**

  

โครงงานนี้เป็นเกมผจญภัย 2 มิติ (2D Adventure Game) ซึ่งผู้เล่นจะรับบทเป็นนักบินอวกาศผจญภัยในพื้นที่ต่างดาว ผู้เล่นสามารถขยับตัวละครเพื่อหลบหลีกอุปสรรคและต่อสู้กับศัตรู ในแต่ละด่านจะมีการเก็บคะแนนหรือประสบการณ์เพื่ออัปเกรดความสามารถของตัวละคร และสามารถบันทึกความคืบหน้าของเกมเพื่อเล่นต่อได้ในภายหลัง

  

## คุณลักษณะและขอบเขต

  

### คุณลักษณะขั้นต่ำ

  

ส่วนนี้เป็นข้อกำหนดของ Minimum Viable Product หรือ MVP ซึ่งเป็นเป้าหมายขั้นต่ำที่สามารถส่งมอบได้ (ใช้งานได้ในระดับเบื้องต้น) โดยให้ระบุสิ่งที่ตั้งใจและคาดว่าจะทำให้เสร็จได้ในกรอบเวลา ในรูปของรายการฟีเจอร์ต่าง ๆ ที่โปรแกรมสามารถทำได้

  

สำหรับแอปพลิเคชัน JavaFX อย่างน้อยต้องมีสิ่งเหล่านี้

  

- มีการสร้าง/เพิ่มเติม แสดง แก้ไข และลบข้อมูลได้

- มีหน้าจออย่างน้อย 2 หน้า

- สามารถบันทึกและเปิดไฟล์ข้อมูลกลับมาได้ อาจบันทึกในรูปแบบ CSV, JSON หรือแบบอื่น ๆ

  

**ตัวอย่างการเขียนสำหรับ Online Product Management**

  

- เป็นโปรแกรมจัดการสินค้าออนไลน์ โดยข้อมูลสินค้าจะประกอบด้วย ชื่อสินค้า รายละเอียด และราคา

- ผู้ใช้สามารถเพิ่ม แก้ไข และลบข้อมูลสินค้าได้

- มีหน้าจอใช้งานหลักซึ่งแสดงรายการสินค้าทั้งหมด และหน้าจอจัดการข้อมูลสำหรับเพิ่มหรือแก้ไขรายละเอียดสินค้า

- สามารถบันทึกข้อมูลสินค้าในรูปแบบ CSV หรือ JSON และสามารถเปิดไฟล์ข้อมูลขึ้นมาดูและแก้ไขในภายหลังได้

  

สำหรับเกมซึ่งใช้ FXGL อย่างน้อยต้องมีสิ่งเหล่านี้

  

- มีตัวละครซึ่งเคลื่อนที่ได้

- มีอุปสรรคหรือศัตรูซึ่งทำอันตรายต่อตัวละครของผู้เล่นได้

- มีระบบคะแนนหรือประสบการณ์

- มีระบบ save/load เพื่อให้กลับมาเล่นต่อได้

  

**ตัวอย่างการเขียนสำหรับ Space Adventure Game**

  

- ตัวละครหลักเป็นยานอวกาศ ซึ่งสามารถควบคุมให้เคลื่อนที่ได้ 4 ทิศทาง และสามารถยิงกระสุนได้

- มีอุกกาบาศซึ่งเมื่อชนแล้วจะเสียพลังชีวิต และยานศัตรูซึ่งสามารถยิงโต้ตอบได้

- มีระบบคะแนนเพื่อให้ผู้เล่นเห็นความคืบหน้าของตนเอง

- มีด่านที่สามารถเล่นได้อย่างน้อย 2 ด่าน

- มีระบบ Save/Load เพื่อบันทึกความคืบหน้าของเกมและกลับมาเล่นต่อได้

  

### คุณลักษณะเพิ่มเติม

  

ระบุส่วนที่คิดจะทำเพิ่มเติมเมื่อมีเวลาพอ เช่น

  

- สามารถเรียงและคัดกรองรายการสินค้าตามเงื่อนไขได้

- สามารถกำหนดส่วนลดและโปรโมชันจับคู่สินค้าได้

- มียานอวกาศหลายแบบให้เลือก

- มีไอเทมสำหรับ power up ให้กระสุนแรงขึ้นได้

  

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

  

**คำแนะนำ**

  

- วิเคราะห์ล่วงหน้าถึงปัญหาที่อาจเกิดขึ้น ระบุให้ชัดเจนพร้อมแนวทางการแก้ไข

- อาจเป็นเรื่องของเทคนิค (เช่น การเรียนรู้ library ใหม่) หรือการจัดการเวลา

  

**ตัวอย่าง**

  

1. **ความท้าทายด้านเทคนิค**:

    - ยังไม่คุ้นเคยกับ JavaFX ในการทำ GUI

    - **แนวทางแก้ไข**: ศึกษาตัวอย่างและบทเรียนจากลิงก์ Pragmatic Coding (https://www.pragmaticcoding.ca/beginners/intro)

2. **ความท้าทายด้านการพัฒนาเกมด้วย FXGL**:

    - ต้องเรียนรู้ FXGL เพิ่มเติม เพราะเคยใช้แต่ JavaFX พื้นฐาน

    - **แนวทางแก้ไข**: ทำตาม tutorial ใน FXGL Wiki (https://github.com/AlmasB/FXGL/wiki/FXGL-11) เพื่อพัฒนาความเข้าใจ

3. **ความเสี่ยงด้านเวลา**:

    - หากใช้เวลาเรียนรู้ส่วนประกอบใหม่มากเกินไป อาจทำให้พัฒนาโค้ดไม่ทัน

    - **แนวทางแก้ไข**: วางแผนฝึกทักษะคู่ไปกับการพัฒนาโครงงาน และติดตามความคืบหน้า (progress) ของตนเองทุกสัปดาห์


## ต้นแบบและเอกสารอ้างอิง

- หากมีต้นแบบซอฟต์แวร์ (Prototype) หรือโค้ดตัวอย่างที่ใช้เป็นแบบอ้างอิง ให้ระบุชื่อโปรเจกต์/ลิงก์เอาไว้

- ใส่ข้อมูลแหล่งเรียนรู้ที่ใช้อ้างอิง เช่น เว็บไซต์ ตำรา หรือวิดีโอสอนต่าง ๆ

- FXGL Tutorial: [https://github.com/AlmasB/FXGL/wiki/FXGL-11](https://github.com/AlmasB/FXGL/wiki/FXGL-11)

- ลิงก์ GitHub ของโปรแกรมที่ใช้เป็นตัวอย่าง