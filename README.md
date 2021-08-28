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
  
* Front-end 
  * Technology 
    * React 17
    * Axios 0.21.1
    * Bootstrap 5
  * Implementation web pages using a modern web framework React

