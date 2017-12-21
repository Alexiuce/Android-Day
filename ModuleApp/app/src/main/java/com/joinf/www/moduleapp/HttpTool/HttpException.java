package com.joinf.www.moduleapp.HttpTool;

/**
 * Created by caijinzhu on 2017/12/21.
 * Http 异常处理类
 */


public class HttpException extends Exception {
   private static final long serialVersionUID = 1L;

   private int ecode;   /** 服务器返回的code */
   private Object emsg;

   public HttpException(int ecode, Object emsg){
       this.ecode = ecode;
       this.emsg = emsg;
   }

   public int getEcode(){ return ecode;}
   public Object getEmsg(){ return emsg;}
}
