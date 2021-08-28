# Project Introduction
Multiple Files Upload
## Author: Cong Le Van

## Introduction applicationn
* Design a web application that allows upload mutiple files
* Upload/List/Delete


## Overview system

* System Architecture
![image](https://user-images.githubusercontent.com/17917747/131217705-cfb6595c-b4d7-4136-a45e-be046eb2b43a.png)

* Back-end 
  * Technology 
    * Java 8 
    * Spring boot 
    * MySQL 
    * Maven 3.6.1
  * Server side API : Using Java spring boot on the server with MySQL for the database 
    * POST /files: uploadFile()
    * GET  /files: getListFiles()
    * GET /files/{id}: getFile()
    * DELETE /files/{id}: deleteFile()
  * Strcucture code 
  ![image](https://user-images.githubusercontent.com/17917747/131217749-efe8916c-9206-4541-94d4-d82946dbd566.png)

  
* Front-end 
  * Technology 
    * React 17
    * Axios 0.21.1
    * Bootstrap 5
  * Implementation web pages using a modern web framework React
  * Structure code 
  ![image](https://user-images.githubusercontent.com/17917747/131217763-dc7c2d6a-0329-414a-9ba2-463cc9d6c2f4.png)

## Demo App 
* Upload and list files
![image](https://user-images.githubusercontent.com/17917747/131217783-bb6e3a51-d7d8-44c2-844b-7640bfbab9a7.png)

* Delete file
![image](https://user-images.githubusercontent.com/17917747/131217786-2bf9d863-2b12-4243-b3cc-facb5f138256.png)


