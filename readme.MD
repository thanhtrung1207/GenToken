# Identity service
Để có thể tạo token thì cần tạo role gồm:

* Onboarding users
* Roles and permissions
* Authentication

## Điều kiện để chạy được
* Build tool: maven >= 3.9.5
* Java: 21
* Framework: Spring boot 3.2.x
* DBMS: MySQL

## Chuẩn bị
* Java SDK 21
* A MySQL server (Fix lỗi start Mysql Thịnh)

## Chạy
`mvn spring-boot:run`

## Build lại maven
`mvn clean package`

## Đã có sẵn một user với role admin
* Username : admin
* Password: admin

## Lưu ý khi mở lệnh hãy debug:
* Luồng đi của một request: controller -> Service -> Store đến DB

## Những dòng trong file application.yml với comment #change là có thể thay đôi
