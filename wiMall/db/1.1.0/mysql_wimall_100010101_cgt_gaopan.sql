/*
  SQLyog Enterprise Trial - MySQL GUI
  MySQL - 5.7.17-log
  创建小程序商城数据库表
  *********************************************************************
*/
##购物车详情表
DROP TABLE `WIML_CART_INFO`;
CREATE TABLE `WIML_CART_INFO` (                                                                            
	`ID_` VARCHAR(25) NOT NULL COMMENT '主键',                                               
	`USER_ID` VARCHAR(25) NOT NULL COMMENT '用户ID主键',                                   
	`PRICE_COUNT` double(10,2) DEFAULT NULL COMMENT '总价格',                               
	`PRODUCT_COUNT` int(25) DEFAULT NULL COMMENT '商品总数',                               
	`STATUS` int(5) DEFAULT '1' COMMENT '状态,1 有效，0 无效',                          
	`PRODUCT_NAME` VARCHAR(100) DEFAULT NULL COMMENT '商品名称',                                                         
	`PRODUCT_PRICE` double(10,2) DEFAULT NULL COMMENT '商品单价',                          
	`PRODUCT_ID` VARCHAR(25) DEFAULT NULL COMMENT '商品ID',                                  
	`CREATE_DATE_` date DEFAULT NULL COMMENT '创建时间',                                   
	`CREATE_BY_` VARCHAR(50) DEFAULT '"SYSTEME"',  
	`UPDATE_DATE_` date DEFAULT NULL COMMENT '更新时间',                                                         
	`UPDATE_BY_` VARCHAR(50) DEFAULT '"SYSTEME"',                                              
	PRIMARY KEY (`ID_`)                                                                        
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;   

##订单详情表
CREATE TABLE `WIML_ORDER_INFO` (               
	`ID_` VARCHAR(25) NOT NULL COMMENT '主键',    
	`PRODUCT_ID` VARCHAR(25) DEFAULT NULL COMMENT '商品主键ID',        
	`USER_ID` VARCHAR(25) DEFAULT NULL COMMENT '用户ID主键',           
	`STATUS` int(10) DEFAULT NULL COMMENT '状态,1 有效，0 无效',          
	`ORDER_PRICE` double(10,2) DEFAULT NULL COMMENT '订单价钱',  
	`COUNT_` VARCHAR(25) DEFAULT NULL,
	`ORDER_NO` VARCHAR(25) DEFAULT NULL COMMENT '订单编码', 
	`CREATE_DATE_` date DEFAULT NULL COMMENT '创建时间',                                   
	`CREATE_BY_` VARCHAR(50) DEFAULT '"SYSTEME"',  
	`UPDATE_DATE_` date DEFAULT NULL COMMENT '更新时间',                                                      
	`UPDATE_BY_` VARCHAR(50) DEFAULT '"SYSTEME"',                                              
	PRIMARY KEY (`ID_`)                                                                        
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC; 

## 图片
CREATE TABLE `WIML_PRICTURE_BYTE` (          
	`ID_` VARCHAR(25) NOT NULL,  
	`PRODUCT_ID` VARCHAR(25) DEFAULT NULL,       
	`IMAGE_NAME` VARCHAR(50) DEFAULT NULL,          
	`SIZE_` int(50) DEFAULT NULL,
	`CREATE_DATE_` date DEFAULT NULL COMMENT '创建时间',                                   
	`CREATE_BY_` VARCHAR(50) DEFAULT '"SYSTEME"',  
	`UPDATE_DATE_` date DEFAULT NULL COMMENT '更新时间',                                                      
	`UPDATE_BY_` VARCHAR(50) DEFAULT '"SYSTEME"',                                              
	PRIMARY KEY (`ID_`)                                                                        
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;   

## 商品详细表
CREATE TABLE `WIML_PRODUCT_INFO` (          
	`PRODUCT_ID_` VARCHAR(25) NOT NULL,  
	`TYPE_ID` VARCHAR(25) DEFAULT NULL,        
	`PRODUCT_NAME_` varchar(25) DEFAULT NULL,       
	`PRICE` double(10,2) DEFAULT NULL,     
	`MERO` varchar(100) DEFAULT NULL,      
	`IMG_ID` VARCHAR(25) DEFAULT NULL,       
	`INVENTORY` INT(20) DEFAULT NULL,   
	`CREATE_DATE_` date DEFAULT NULL COMMENT '创建时间',                                   
	`CREATE_BY_` VARCHAR(50) DEFAULT '"SYSTEME"',  
	`UPDATE_DATE_` date DEFAULT NULL COMMENT '更新时间',                                                      
	`UPDATE_BY_` VARCHAR(50) DEFAULT '"SYSTEME"',                                              
	PRIMARY KEY (`PRODUCT_ID_`)                                                                        
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

CREATE TABLE `WIML_PRODUCT_TYPE` (     
	`ID_` int(18) NOT NULL,  
	`NAME` varchar(25) DEFAULT NULL,       
	`MENO` varchar(25) DEFAULT NULL, 
	`CREATE_DATE_` date DEFAULT NULL COMMENT '创建时间',                                   
	`CREATE_BY_` VARCHAR(50) DEFAULT '"SYSTEME"',  
	`UPDATE_DATE_` date DEFAULT NULL COMMENT '更新时间',                                                      
	`UPDATE_BY_` VARCHAR(50) DEFAULT '"SYSTEME"',                                              
	PRIMARY KEY (`ID_`)                                                                        
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;














