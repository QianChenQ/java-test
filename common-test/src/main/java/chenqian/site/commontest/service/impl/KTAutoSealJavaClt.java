
package chenqian.site.commontest.service.impl;

import java.io.File;

/**
 * @ClassName: KTAutoSealJavaClt
 * @Description: TODO
 * @author: ChuanHui
 * @date: 2017年10月28日 上午10:37:07
 */
public class KTAutoSealJavaClt {

    static {
        if ("32".equals(System.getProperty("sun.arch.data.model"))) {
            System.loadLibrary("AutoSealJava_x86");
        } else {
            System.loadLibrary("AutoSealJava_x64");
        }
    }

    // 分配空间
    public native long initilize_new(String strUrl, String strUser, String strPasswd);

    public native long initilize_new(String strUrl, String strUser, String strPasswd, boolean bSealColorPrintNotCtrl);

    public KTAutoSealJavaClt() {

    }

    public KTAutoSealJavaClt(String strUrl, String strUser, String strPasswd) {
        m_nHandle = 0;
        m_strLastError = "";
        m_nHandle = initilize_new(strUrl, strUser, strPasswd);
    }

    public KTAutoSealJavaClt(String strUrl, String strUser, String strPasswd, boolean bSealColorPrintNotCtrl) {
        m_nHandle = 0;
        m_strLastError = "";
        m_nHandle = initilize_new(strUrl, strUser, strPasswd, bSealColorPrintNotCtrl);
    }

    /**
     * @param strSealID 服务端存有的印章ID
     * @param nPage     印章盖在文档的页数（0代表第一页类推）
     * @param nX        印章圆点相对于所在页面坐标原点(0,0)的横向位移
     * @param nY        印章圆点相对于所在页面坐标原点(0,0)的纵向位移
     * @param bOverText 印章是否要浮现在文字上方标识
     * @return
     * @Title: first_add_seal_on_paper
     * @Description: 添加单个印章模板(多个印章模板循环调用)
     * @return: boolean false失败
     */
    public native boolean first_add_seal_on_paper(String strSealID, int nPage, int nX, int nY, boolean bOverText);

    // 添加单个印章模板以关键字查找pdf定位的形式(多个印章模板循环调用)
    public native boolean first_add_seal_on_paper(String strSealID, byte[] byKeyword, boolean bUnique, int nXOffset,
                                                  int nYOffset, boolean bOverText);

    /**
     * @param strSealID   印章id
     * @param byKeyword   utf-8编码的字符串
     * @param nPage       0开始代表第一页，N代表N+1页
     * @param nOrdinalNum 标识码
     *                    -2代表查找的关键字有且只能有一个;
     *                    -1代表查找文档中的所有关键字;
     *                    0代表查找某页nPage中的所有关键字;
     *                    >0代表某页nPage中的第几个关键字(序数查找形式从左到右、从上到下)
     * @param nXOffset    pdf坐标系X坐标方向偏移：小于0向左，大于0向右
     * @param nYOffset    pdf坐标系Y坐标方向偏移：小于0向上，大于0向下
     * @param bOverText   印章是否浮现于文字上方
     * @return
     * @Title: first_add_seal_on_paper
     * @Description: 添加单个印章模板以关键字查找pdf定位的形式(多个印章模板循环调用)
     * @return: boolean
     */
    public native boolean first_add_seal_on_paper(String strSealID, byte[] byKeyword, int nPage, int nOrdinalNum,
                                                  int nXOffset, int nYOffset, boolean bOverText);

    public native boolean first_add_remarks_replace_on_paper(String strSealID, String strRemarks, int nRemarkWidth,
                                                             byte[] byKeyword, boolean bUnique, int nXOffset, int nYOffset, boolean bOverText);

    public native boolean first_add_remarks_replace_on_paper(String strSealID, String strRemarks, int nRemarkWidth,
                                                             byte[] byKeyword, int nPage, int nOrdinalNum, int nXOffset, int nYOffset, boolean bOverText);

    public native boolean first_add_remarks_replace_on_paper(String strSealID, int nType, String strRemarks,
                                                             int nRemarkWidth, int nRemarkHeight, byte[] byKeyword, int nPage, int nOrdinalNum, int nXOffset,
                                                             int nYOffset, boolean bOverText);

    /**
     * @param strSealID
     * @param strRemarks   批注内容
     * @param nRemarkWidth
     * @param nPage
     * @param nX
     * @param nY
     * @param bOverText
     * @return
     * @Title: first_add_remarks_replace_on_paper
     * @Description: 签批
     * @return: boolean
     */
    public native boolean first_add_remarks_replace_on_paper(String strSealID, String strRemarks, int nRemarkWidth,
                                                             int nPage, int nX, int nY, boolean bOverText);

    /**
     * @param nType          通信中附加底图的方式： 1-为指定服务端存在ID底图，2-本地临时底图文件上传
     * @param strPicPathOrID 底图ID或文件路径名
     * @param nPage          底图所在页码：1代表第一页类推
     * @param nX             底图相对于所在页面坐标原点(0,0)的横向位移
     * @param nY             底图相对于所在页面坐标原点(0,0)的纵向位移
     * @param nWidth         底图本身在页面中需体现的宽度
     * @param nHeight        底图本身在页面中需体现的高度
     * @param bOverText
     * @return
     * @Title: second_add_backpic_on_paper
     * @Description: TODO
     * @return: boolean
     */
    public native boolean second_add_backpic_on_paper(int nType, String strPicPathOrID, int nPage, int nX, int nY,
                                                      int nWidth, int nHeight, boolean bOverText);

    public native boolean second_add_remarks_backpic_on_paper(int nType, String strSealID, String strRemarks, int nPage,
                                                              int nX, int nY, int nWidth, int nHeight, boolean bOverText);

    public native boolean second_add_remarks_backpic_on_paper(int nType, String strSealID, String strRemarks, int nPage,
                                                              int nX, int nY, int nWidth, int nHeight);

    public native boolean second_add_remarks_backpic_on_paper(int nType, String strSealID, String strRemarks, int nPage,
                                                              int nX, int nY);

    /**
     * @return
     * @Title: backpic_on_paper_clear
     * @Description: 清空已添加的全部底图模板
     * @return: boolean
     */
    public native boolean backpic_on_paper_clear();

    /**
     * @return
     * @Title: seal_on_paper_clear
     * @Description: 清空已添加的全部印章模板
     * @return: boolean
     */
    public native boolean seal_on_paper_clear();

    /**
     * @param strInFile    输入的源文档绝对路径
     * @param nUniqueFlag  指定的动作标识，可设为线程ID、0等等
     * @param bDoc2pdfOnly 只是pdf转换标识：1代表只转换pdf,0代表需对文档签章
     * @param strOutFile   生成的签章文档或pdf文档的绝对路径
     * @return
     * @Title: final_convert_document
     * @Description: 输入文件路径转换生成指定文档
     * @return: int 成功返回0，失败返回错误号
     */
    public native int final_convert_document(String strInFile, int nUniqueFlag, boolean bDoc2pdfOnly,
                                             String strOutFile);

    // 输入文件路径转换生成指定文档的扩展方法
    public native int final_convert_document_ex(String strInFile, String strExt1, String strExt2, boolean bDoc2pdfOnly,
                                                String strOutFile);

    /**
     * @param docBuffer    文件内容
     * @param strDocExtern 文件的后缀命 例如”doc”,”txt”
     * @param nUniqueFlag  指定的动作标识，可设为线程ID、0等等
     * @param bDoc2pdfOnly 只是pdf转换标识：1代表只转换pdf,0代表需对文档签章
     * @param strOutFile   生成的签章文档或pdf文档的绝对路径
     * @return
     * @Title: final_convert_document2
     * @Description: 1.12 输入文件流转换生成指定文档
     * @return: int 成功返回0，失败返回错误号
     */
    public native int final_convert_document2(byte[] docBuffer, String strDocExtern, int nUniqueFlag,
                                              boolean bDoc2pdfOnly, String strOutFile);

    // 输入文件流签章转换文档扩展方法
    public native int final_convert_document2_ex(byte[] docBuffer, String strDocExtern, String strExt1, String strExt2,
                                                 boolean bDoc2pdfOnly, String strOutFile);

    /**
     * @param docBuffer    文件内容
     * @param strDocExtern 文件的后缀命 例如”doc”,”txt”
     * @param nUniqueFlag  指定的动作标识，可设为线程ID、0等等
     * @param bDoc2pdfOnly 只是pdf转换标识：1代表只转换pdf,0代表需对文档签章
     * @return
     * @Title: final_convert_document3
     * @Description: 1.14 输出文件流签章转换文档
     * @return: byte[] 返回最后的文件内容,失败返回空
     */
    public native byte[] final_convert_document3(byte[] docBuffer, String strDocExtern, int nUniqueFlag,
                                                 boolean bDoc2pdfOnly);

    // 输出文件流签章转换文档扩展方法
    public native byte[] final_convert_document3_ex(byte[] docBuffer, String strDocExtern, String strExt1,
                                                    String strExt2, boolean bDoc2pdfOnly);

    /**
     * @Title: finally_free
     * @Description: 释放handle空间
     * @return: void
     */
    public native void finally_free();

    public native void finally_free_ex(long nHandle);

    public void KTFreeHandle() {
        finally_free_ex(m_nHandle);
    }

    /**
     * @param nErrorCode
     * @return
     * @Title: get_error_by_code
     * @Description: 获取字符串描述
     * @return: String
     */
    public native String get_error_by_code(int nErrorCode);

    /**
     * @return
     * @Title: get_last_error
     * @Description: 获取上个方法调用失败的错误字符串描述
     * @return: String
     */
    public String get_last_error() {
        return m_strLastError;
    }

    private long m_nHandle;

    private String m_strLastError;

    public static void main(String[] args) {
        String sealId = "003896BD815AF541ABAB5A3CBA7FED28";
        String keyWords = "损失的";
        String strUrl = "192.168.171.82:2040", strUser = "test", strPasswd = "111111";
        String pdfPath = "D:/1/ServiceAgreement.pdf", edcPath = "d:/1/111.edc";
//        edcPath="opt/111.edc";
//        pdfPath="/opt/ServiceAgreement.pdf";
//        sealId = "5442141D0F82A64D8AD74F77EB2D10A3";
//        strUser = "dzzz";
//        strPasswd = "123456";
//        strUrl = "10.16.187.47:2040";
        KTAutoSealJavaClt clt = new KTAutoSealJavaClt(strUrl, strUser, strPasswd, true);
        try {
//            boolean b = clt.first_add_seal_on_paper(sealId, keyWords.getBytes("utf-8"), 0, 0, 1, 1, true);//overText
            boolean b = clt.first_add_remarks_replace_on_paper(sealId, " ", 256, 0, 100, 200, true);
            if (!b) {
                String last_error = clt.get_last_error();
                System.out.println("签批异常： " + last_error);
            }
        } catch (Exception e) {
            System.out.println("this is a test exception:" + e);
            clt.finally_free();
            return;
        }
        File filePdf = new File(pdfPath);
        File fileEdc = new File(edcPath);
        int i = clt.final_convert_document_ex(filePdf.getPath(), "", "", false, fileEdc.getPath());
        if (i != 0) {
            String last_error = clt.get_last_error();
            System.out.println(last_error);
        }
        clt.finally_free();
    }

}
