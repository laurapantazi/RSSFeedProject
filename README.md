# RSSFeedProject

Implementation of a web application for RSS feeds 

## Functionality Overview

This application has the following features:
  * There are two types of users, clients and admins.
  * Admins have the ability to create, view and delete rss feeds. 
  * Clients can modify their personal interests at any time. In order to accomplish that, they fill a specific form in their profile that is based on keywords.
  * Clients when they log in, they can view url news based on their submitted form.
  * Users can login to the application using their username and password.
  * Clients can sign up, if they don't own an account.

## Prerequisites

  * Eclipse or another Java IDE
  * PostgreSQL
  * Apache Tomcat
  * Postgre JDBC driver - Connector/J

## Getting Started

1. Clone or download repository
2. Import project into Eclipse
3. Import the sample into Eclipse using File -> Import -> Git -> Projects from Git option.
4. Right click on the project and go to Properties > Project Facets and select Dynamic Web Module (if not already selected).
5. Deploy the sample into Tomcat server. Right click on the servlet sample and select Run As -> Run on Server option. Find and select the Tomcat profile server and press Finish.