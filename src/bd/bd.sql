/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : enramada

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 01/04/2019 00:17:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE IF NOT EXISTS SGDPN;
USE SGDPN;



-- ----------------------------
-- Table structure for imagenes
-- ----------------------------
DROP TABLE IF EXISTS `imagenes`;
CREATE TABLE `imagenes`  (
  `img_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `img_title` varchar(45) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `img_data` blob NOT NULL,
  PRIMARY KEY (`img_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- Table structure for persona
-- ----------------------------
DROP TABLE IF EXISTS `persona`;
CREATE TABLE `persona` (
  `id` int(11) NOT NULL,
  `cedula` varchar(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `telefono1` varchar(10) DEFAULT NULL,
  `telefono2` varchar(10) DEFAULT NULL,
  `calle` varchar(50) DEFAULT NULL,
  `numero` varchar(50) DEFAULT NULL,
  `sector` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



-- ----------------------------
-- Table structure for usuarios
-- ----------------------------
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `codigo_us` varchar(20) NOT NULL DEFAULT '',
  `nombre_us` varchar(50) DEFAULT NULL,
  `sexo_us` varchar(10) DEFAULT NULL,
  `tipo_us` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo_us`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
