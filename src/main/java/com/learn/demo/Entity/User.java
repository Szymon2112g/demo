package com.learn.demo.Entity;

import javax.persistence.*;

/*

DROP DATABASE  IF EXISTS `application_DB1`;

  CREATE DATABASE  IF NOT EXISTS `application_DB1`;
  USE `application_DB1`;

  --
  -- Table structure for table `user`
  --

  DROP TABLE IF EXISTS `user`;

  CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `point` int(50) NOT NULL,
  `money` int(50) NOT NULL,
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "point")
    private int point;

    @Column(name = "money")
    private int money;

    public User() {}

    public User(String username, int point, int money) {
        this.username = username;
        this.point = point;
        this.money = money;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
