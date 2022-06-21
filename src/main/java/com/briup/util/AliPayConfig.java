package com.briup.util;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

public class AliPayConfig {
	/*
	 * 服务网关---沙箱环境
	 */
	
	private static String serverURL = "https://openapi.alipaydev.com/gateway.do";
	/*
	 * 应用ID
	 */
	private static String APP_ID = "2021000120612095";
	/*
	 * 用户私钥，可以替换成你自己的
	 */
	private static String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC4TCFoogCadsbNsJZvmzBuHUfCKZl3xMD+RuUb/sIZJPlEVryKjulinkM5Cbk5GB/fAQUsgOGY6GGRY/4xyJjGBuuA21F8e7GG86gmEOQAe2kbr+5QNvZ6ZIRSkO9fwy94rccY4Ud71zTvGyLwc9EWVvIOFu8o2DVmJ0KYtlJUUXR1G1sEHC7tAC+ODzT9nVlgIvHPa3uShKJMX/TK6eRz0bKzTigzTR2UMRZ2GJ2G5XwhonFRYUAd56ppFAXVD4PRTijvEU5npQxSY5wCI9wM2HGkJLP87rFQg4pWSy4fpyL4GW8bUPKdzQ2fMSuzzp9oiNRryFtRylI7RD/h/mshAgMBAAECggEBAKWTCCTX/xDHC176en00gLM9LR38f7uBkh4glW+sVrd+Z1AFWQhm0rjeFOjmmnj3+pJAeWR9ObFFfXrAyjvxy4eF6gjvgWsEOf9TYssoO59PQKQ2UDXS22gkbFk9i0GOu1SBU7E/nBhfxVfYGnDKrJuUa41K/3zDml33gbZvftHuf2EIgRnCNpG9ADtwWo/uCVEZC39qnusCgNgqMqCfvld2fne/W+PhmDp16L0voAwwZ/9RSxDmy48p6p87uC7F+Gvb1PX0iCteYpqP+wHIFIgZ0f5AEGWd1PsbiSXFu22Okfkmi3WJ+vyViWFLcHG0hSSFGt7RlaDZYu8IT2BAV9ECgYEA9Fnw/XgQfliLbwpUoj+rSU7WzCyiCLX9tvGxWiy31hxCPMYOK9+FmqXV1HA81HhWBcu5FqDH8GcSwJhxMWKj/IzspXBxW1lBo5wXz1zxM2QYbBDjBL4Lr4VL/PC2rwXGtnK0QJ6RQQ/4NynqU0+4LByvkW4kbfJao+Wl0Ar4vX0CgYEAwRVKv3yYoT69NJ51B07VFlho/iRT5bwL39njbFS7V1MyIQHCfmk5tWR/PGRWOb8eMb1vC9FuMzATPc1+0ZntwX6z2cIE+yXodZCRG1bHXmIal6xM3DVrnYyEniTA3srx5DczSofob3n+dvUMnFL4XRLxOcGUsLRk50tiBEU75XUCgYB5/q2i3t7dNbfnqHC40LDj2MjFB0Oetb4GKIUzUEA4VcN8NCW/IcnCfClV9vNn4OyR2DSAZ6VrEQr7vSBGV8knvfQoZQszYEy1MqlwjiaeUcsfqQ6uv3N2Hkbh8gxDNc8QKBR2brR2l1KFuBeVoKeC3o+JPERT4DwAuBcg11l4wQKBgAOTn2TYrAMgpGSbItPV1ACr9pXumldBGn81DA9vqmC9u8n8vFuXG2iOygSWXzqGncqSFcKESKROGa0lZ1n+nfbdn/tCqtD0LNAws19sRhkrfA6fNHVH0AyFE9fSGniGDeEKXLretaGLAvm1JFyo9MzUkv9c5KI5VT0rmk818RwZAoGBANbJwHSr1PxFm1vrdmgGR6Q8F4hJ2wKSOEx2J8czE/gKvwjVxNJUb7kUzqUG65SlXl6SfkfvIEf5AnHZE3HL68UJ/0BCakiaS8v4txXcTjSIxS/b8dUFu+E7l8S2YbdaME5jY4H/rwwcMoFNsivzd9C4WrJfPT17cHJrb6lqUOFh";
	/*
	 * 发送数据格式
	 */
	private static String format = "json";
	/*
	 * 设置字符集编码的格式 CHARSET
	 */
	private static String CHARSET ="utf-8";
	/*
	 * 支付宝的公钥，大家可以替换成自己的
	 */
	private static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhHfUilnAAiPOTG4AhFfMpkTbF8EpThAOrf8IRDmKNBPEbON84K7d/31d2AvPpD53qFUI4EKkwG3lf0cT0Ty4dSrzPkRrnm6E7Llq8jkwtdylKUq2hzgwtzgtLgc77pSCPJD19OuvNERkEGp8Kyz4fZxc/djX2N2Kl/P41b0Ji9Wt4iIjID9D3iN6YsI+N1VI2VLowvy6EV5BPRYzd1xGwr6R3wcY3Ggxb9C8HohPrSXDK0uXFBUdwMLKgCMviUyMZFjuHHUBUx1lrkItL7gFJcHoP1QcXz6sxkHdcU4wXTYGPi2eQ3n29LX5Lk+XUmeBVN3x/LeHGn1dl7ouIIJNtwIDAQAB";
	/*
	 * 支付宝签名 目前采用的是RSA2
	 */
	private static String signType = "RSA2";
	
	/*
	 *页面跳转同步通知也页面
	 */
	public static String return_url = "http://127.0.0.1:8888/estore/index.jsp";
	
	public static AlipayClient getAlipayClient() {
		return new DefaultAlipayClient(serverURL, APP_ID, APP_PRIVATE_KEY, format, CHARSET, ALIPAY_PUBLIC_KEY, signType);
	}

}
