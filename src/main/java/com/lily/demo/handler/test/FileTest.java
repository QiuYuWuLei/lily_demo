package com.lily.demo.handler.test;

public class FileTest {
//     /**
    //     * @param filePath 文件将要保存的目录
    //     * @param method   请求方法，包括POST和GET
    //     * @param url      请求的路径
    //     * @return
    //     * @功能 下载临时素材接口
    //     */
//
//    public static File saveUrlAs(String url, String filePath, String fileName, String method) {
//        //System.out.println("fileName---->"+filePath);
//        //创建不同的文件夹目录
//        File file = new File(filePath);
//        //判断文件夹是否存在
//        if (!file.exists()) {
//            //如果文件夹不存在，则创建新的的文件夹
//            file.mkdirs();
//        }
//        FileOutputStream fileOut = null;
//        HttpURLConnection conn = null;
//        InputStream inputStream = null;
//        try {
//            // 建立链接
//            URL httpUrl = new URL(url);
//            conn = (HttpURLConnection) httpUrl.openConnection();
//
//
//            String newUrl = url;
//            Map<String, List<String>> map = conn.getHeaderFields();
//            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                //如果发现有重定向了新的地址
//                if ("Location".equals(key)) {
//                    //获取新地址
//                    newUrl = map.get(key).get(0);
//                    break;
//                }
//            }
//
//            // 重新实例化url对象
//            httpUrl = new URL(newUrl);
//            // 重新打开和URL之间的连接
//            conn = (HttpURLConnection) httpUrl.openConnection();
//
//            // 设置通用的请求属性
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("Accept-Charset", "UTF-8");
//            conn.setRequestProperty("contentType", "UTF-8");
//            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
//            conn.setRequestProperty("Accept-Language", Locale.getDefault().toString());
//            // 建立实际的连接
////            conn.connect();
//
//
//            //以Post方式提交表单，默认get方式
//            conn.setRequestMethod(method);
//            conn.setDoInput(true);
//            conn.setDoOutput(true);
//            // post方式不能使用缓存
//            conn.setUseCaches(false);
////            //连接指定的资源
//            conn.connect();
//            //获取网络输入流
//            inputStream = conn.getInputStream();
//            BufferedInputStream bis = new BufferedInputStream(inputStream);
//            //判断文件的保存路径后面是否以/结尾
//            if (!filePath.endsWith("/")) {
//
//                filePath += "/";
//
//            }
//            //写入到文件（注意文件保存路径的后面一定要加上文件的名称）
//            fileOut = new FileOutputStream(filePath + fileName);
//            BufferedOutputStream bos = new BufferedOutputStream(fileOut);
//
//            byte[] buf = new byte[4096];
//            int length = bis.read(buf);
//            //保存文件
//            while (length != -1) {
//                bos.write(buf, 0, length);
//                length = bis.read(buf);
//            }
//            bos.close();
//            conn.disconnect();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("抛出异常！！");
//        }
//
//        return file;
//
//    }
//
//    /***
//     *
//     * @param date
//     * @param dateFormat : e.g:yyyy-MM-dd HH:mm:ss
//     * @return
//     */
//    public static String formatDateByPattern(Date date, String dateFormat) {
//        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
//        String formatTimeStr = null;
//        if (date != null) {
//            String formatStr = sdf.format(date);
//            formatTimeStr = formatStr.replace("00", "0");
//        }
//        return formatTimeStr;
//    }
//
//
//    /***
//     * convert Date to cron ,eg.  "0 07 10 15 1 ? 2016"
//     * @param date  : 时间点
//     * @return
//     */
//    public static String getCron(Date date) {
//        Date date1 = new Date(1543989600000L);
//        String dateFormat = "ss mm HH * * ?";
//        return formatDateByPattern(date, dateFormat);
//    }
//
//    /**
//     * 读取 excel 中的图片
//     *
//     * @return
//     */
//    public Map<String, PictureData> getPictureDataMap(XSSFWorkbook wb) {
////        String filePath = UpLoadFileUtil.getFilePath(request, file);
////        InputStream inputStream = null;
//
//        /** 验证文件是否合法 */
////
////        if (!validateExcel(filePath)) {
////
////            System.out.println(errorInfo);
////
////            return null;
////
////        }
//
//        /** 判断文件的类型，是2003还是2007 */
//
//        // 判断是2003 还是 2007
////        XSSFWorkbook wb = null;
////        try {
////            wb = new XSSFWorkbook(inputStream);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//
//        // 得到第一个shell
//        XSSFSheet sheet = wb.getSheetAt(0);
//
//        Map<String, PictureData> map = new HashMap<>();
//        for (POIXMLDocumentPart dr : sheet.getRelations()) {
//            if (dr instanceof XSSFDrawing) {
//                XSSFDrawing drawing = (XSSFDrawing) dr;
//                List<XSSFShape> shapesList = drawing.getShapes();
//                if (shapesList != null && shapesList.size() > 0) {
//                    for (XSSFShape shape : shapesList) {
//                        XSSFPicture pic = (XSSFPicture) shape;
//                        XSSFClientAnchor anchor = pic.getPreferredSize();
//                        CTMarker cTMarker = anchor.getFrom();
//                        String rowIndex = cTMarker.getRow() + "";
//                        String colIndex = cTMarker.getCol() + "";
//                        map.put(rowIndex + ":" + colIndex, pic.getPictureData());
//                    }
//                }
//            }
//        }
//        return map;
//    }
//
//    /**
//     * java生成pdf测试
//     */
//    public static void fillTemplate() throws DocumentException {
//        // 模板路径
//        String templatePath = "C:\\Users\\lily\\Desktop\\pdfTest\\test.pdf";
//        // 生成的新文件路径
//        String newPDFPath = "D:\\ceshi.pdf";
//        PdfReader reader;
//        FileOutputStream out;
//        ByteArrayOutputStream bos;
//        PdfStamper stamper;
//        try {
//            out = new FileOutputStream(newPDFPath);// 输出流
//            reader = new PdfReader(templatePath);// 读取pdf模板
//            bos = new ByteArrayOutputStream();
//            stamper = new PdfStamper(reader, bos);
//            AcroFields form = stamper.getAcroFields();
//
//            String[] str = {"123456789", "TOP__ONE", "男", "1991-01-01", "130222111133338888", "河北省保定市"};
//            int i = 0;
//            Iterator<String> it = form.getFields().keySet().iterator();
//            while (it.hasNext()) {
//                String name = it.next().toString();
//                System.out.println(name);
//                form.setField(name, str[i++]);
//            }
//            stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true
//            stamper.close();
//
//            Document doc = new Document();
//            PdfCopy copy = new PdfCopy(doc, out);
//            doc.open();
//            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
//            copy.addPage(importPage);
//            doc.close();
//
//        } catch (IOException e) {
//            System.out.println(1);
//        } catch (DocumentException e) {
//            System.out.println(2);
//        }
//    }
//
//    /**
//     * html 转 pdf
//     *
//     * @param outputFile
//     * @param url
//     * @return
//     * @throws Exception
//     */
////    public static boolean htmlToPdf(String outputFile, String url) throws Exception {
////        File outFile = new File(outputFile);
////        if (!outFile.exists()) {
////            outFile.getParentFile().mkdirs();
////        }
////
////
////        OutputStream os = new FileOutputStream(outputFile);
////
////        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
////        org.w3c.dom.Document doc = builder.parse(new ByteArrayInputStream(url.getBytes("UTF-8")));
////
//////Document document = new Document(PageSize.A4, 50, 50, 50, 50);
////        ITextRenderer renderer = new ITextRenderer();
////
////        renderer.setDocument(doc, null);
////
//////renderer.setDocument(url);
////        String fontPath = FileTest.class.getClassLoader().getResource("").toString().replaceAll("file:/", "") + "simsun.ttc";
////        System.out.println(fontPath);
////
////
//////// 解决中文支持问题
//////        ITextFontResolver fontResolver = renderer.getFontResolver();
//////        fontResolver.addFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
////        renderer.layout();
////        renderer.createPDF(os);
////        os.flush();
////        os.close();
////
////
////        System.out.println("文件转换成功");
////        return true;
////    }
//
//    /**
//     * 获取html字符串
//     *
//     * @return
//     */
//    public static String getHtmlStr() {
//        String printHtml = "<html>";
//        printHtml += "<head>";
//        printHtml += "<title>我的第一个 HTML 页面</title>";
//        printHtml += "</head>";
//        printHtml += "<body>";
//        printHtml += "<p>body hhjfh hdfhdsh元素的内容会显示在浏览器中。</p>";
//        printHtml += "<p>title hfdjfh jfhdkfhk 元素的内容会显示在浏览器的标题栏中。</p>";
//        printHtml += "</body>";
//        printHtml += "</html>";
//        printHtml = "localhost:6204/api/merchant/pdf/htmlToPdf?accessToken=gddg&htmlContent=<html><head><title>我的第一个 HTML 页面</title><style>table, th, td{ border: 1px solid blue;}</style></head><body><table><tr><td><p>元素的内容会显示在浏览器中。</p></td><td><p>元素的内容会显示在浏览器的标题栏中。</p></td></tr></table></body></html>";
//        return printHtml;
//    }
//
//
//    public static void main(String[] args) throws Exception {
////        String photoUrl = "http://121.199.13.244/home/static/src/test/merch/regularOrder.xlsx";
////        String fileName = photoUrl.substring(photoUrl.lastIndexOf("/"));
////        //System.out.println("fileName---->"+fileName);
////        String filePath = "d:\\test";
////        File file = saveUrlAs(photoUrl, filePath, fileName, "GET");
////        System.out.println("Run ok!/n<BR>Get URL file " + file);
//
////        String cron= getCron(new Date());
////        System.out.println("########################" + cron);
//
//        //生成pdf测试
////        fillTemplate();
//
////        htmlToPdf("D:\\print.pdf", getHtmlStr());
//
//    }

}
