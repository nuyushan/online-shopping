package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.briup.util.AliPayConfig;

@WebServlet("/orderPay")
public class OrderPayServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    int orderFormId= Integer.parseInt(req.getParameter("orderFormId"));
	    double cost = Double.parseDouble(req.getParameter("cost"));
	    System.out.println(orderFormId);
	    System.out.println(cost);
	    //支付扫码
	    
	    //实例化客户端

	    AlipayClient alipayClient = AliPayConfig.getAlipayClient();

	    //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay

	    AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();

	    //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。

	    AlipayTradePagePayModel model = new AlipayTradePagePayModel();
	    //订单支付
	    model.setBody("订单支付");
	    //订单名字
	    model.setSubject("书籍订单");
	    //订单号
	    model.setOutTradeNo(orderFormId+"");
	    //过期时间
	    model.setTimeoutExpress("30m");
	    //订单金额
	    model.setTotalAmount(cost+"");
	    //产品码
	    model.setProductCode("FAST_INSTANT_TRADE_PAY");
	    //设置参数
	    request.setBizModel(model);
        //回调地址
	    request.setReturnUrl(AliPayConfig.return_url);

	    try {
	    	AlipayTradePagePayResponse pageExecute = alipayClient.pageExecute(request);
	    	String result = pageExecute.getBody();
	        resp.setContentType("text/html;charset=utf-8");
	        resp.getWriter().println(result);
	        } catch (AlipayApiException e) {

	            e.printStackTrace();

	    }
	}
}
