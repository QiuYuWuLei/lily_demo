package com.lily.demo.handler.test;

import org.springframework.stereotype.Controller;

@Controller
public class PdfServiceHandler {

//    private final static Logger logger = Logger.getLogger(PdfServiceHandler.class.getName());
//
//    @Autowired
//    private PdManager pdManager;
//    @Autowired
//    private UumWebapiService uumWebapiService;
//
//    @RequestMapping(value = "/api/merchant/pdf/htmlToPdf", method = RequestMethod.GET)
//    @ResponseBody
//    public void exportDriverExcel(HttpServletResponse response, @RequestParam String accessToken, @RequestParam String htmlContent) {
//        logger.info(String.format("HTML转pdf ---> %s", "accessToken=" + accessToken));
//
//        try {
////            //验证token有效性
////            Return<Account> retToken = uumWebapiService.checkTokenStr(accessToken, Account.class);
////            if (!retToken.isSuccessful()) {
////                response.getWriter().write("token无效~~~");
////            }
//
//            pdManager.exportPdf("test.pdf", htmlContent, response);
//        } catch (Exception e) {
//            logger.error(String.format("错误信息 --->retMsg[%s].", e.getMessage()));
//            e.printStackTrace();
//        }
//    }
}
