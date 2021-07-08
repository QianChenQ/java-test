package com.kinsec;

import java.io.*;

public class KTAutoSealJavaClt
{
	static {
		if( System.getProperty("sun.arch.data.model").equals("32") )
			System.loadLibrary( "AutoSealJava_x86" );
		else
			System.loadLibrary( "AutoSealJava_x64" );
	}

	
	//����ռ�
	public native long initilize_new( String strUrl, String strUser, String strPasswd );
	public native long initilize_new( String strUrl, String strUser, String strPasswd, boolean bSealColorPrintNotCtrl );
	public KTAutoSealJavaClt( String strUrl, String strUser, String strPasswd )
	{
		m_nHandle = 0;
		m_strLastError = "";
		m_nHandle = initilize_new( strUrl, strUser, strPasswd );
	}
	public KTAutoSealJavaClt( String strUrl, String strUser, String strPasswd, boolean bSealColorPrintNotCtrl )
	{
		m_nHandle = 0;
		m_strLastError = "";
		m_nHandle = initilize_new( strUrl, strUser, strPasswd, bSealColorPrintNotCtrl );
	}
	
	//��ӵ���ӡ��ģ��(���ӡ��ģ��ѭ������)
	public native boolean first_add_seal_on_paper( String strSealID, int nPage, int nX, int nY, boolean bOverText );
	public boolean First_add_seal_on_paper( String strSealID, int nPage, int nX, int nY, boolean bOverText )
	{
		return first_add_seal_on_paper(  strSealID, nPage,  nX , nY,  bOverText );
	}

	//��ӵ���ӡ��ģ���Թؼ��ֲ���pdf��λ����ʽ(���ӡ��ģ��ѭ������)
	/*************************************************************************
	Function : first_add_seal_on_paper
	Purpose  : ���ӡ���Թؼ��ֲ���pdf��λ
	Params   : [in]  strSealID				- ӡ��id
 				[in]  byKeyword				- utf-8������ַ���
				[in]  bUnique			
						��(1)				- �ؼ�����pdf������ֻ����һ����������ñ���
						��(0)				- �ؼ�����pdf������жദ����ǩ�����
				[in]  nXOffset				- pdf����ϵX���귽��ƫ�ƣ�С��0���󣬴���0����
				[in]  nYOffset				- pdf����ϵY���귽��ƫ�ƣ�С��0���ϣ�����0����
				[in]  bOverText				- ӡ���Ƿ����������Ϸ�
	Return   : �ɹ����� ��(1)��ʧ�ܷ��� ��(0)
	*************************************************************************/
	public native boolean first_add_seal_on_paper( String strSealID, byte[] byKeyword, boolean bUnique, int nXOffset, int nYOffset, boolean bOverText );

	//��ӵ���ӡ��ģ���Թؼ��ֲ���pdf��λ����ʽ(���ӡ��ģ��ѭ������)
	/*************************************************************************
	Function : first_add_seal_on_paper
	Purpose  : ���ӡ���Թؼ��ֲ���pdf��λ
	Params   : [in]  strSealID				- ӡ��id
 				[in]  byKeyword			- utf-8������ַ���
				[in]  nPage			- 0��ʼ�����һҳ��N����N+1ҳ
				[in]  nOrdinalNum   - ��ʶ��
						-2������ҵĹؼ�������ֻ����һ����
						-1��������ĵ��е����йؼ��֣�
						0�������ĳҳnPage�е����йؼ��֣�
						>0����ĳҳnPage�еĵڼ����ؼ���(����������ʽ�����ҡ����ϵ���)
				[in]  nXOffset				- pdf����ϵX���귽��ƫ�ƣ�С��0���󣬴���0����
				[in]  nYOffset				- pdf����ϵY���귽��ƫ�ƣ�С��0���ϣ�����0����
				[in]  bOverText    -- ӡ���Ƿ����������Ϸ�
	Return   : �ɹ����� ��(1)��ʧ�ܷ��� ��(0)
	*************************************************************************/
	public native boolean first_add_seal_on_paper( String strSealID, byte[] byKeyword, int nPage, int nOrdinalNum, int nXOffset, int nYOffset, boolean bOverText );

	//ʹ��ӡ��id��Ӧ��֤�����ע����ǩ��ǩ�£��滻��id����Ӧ��ӡ�£�
	//�������עΪ�ַ������򳤶�����Ϊ256�ֽڣ���128���ַ���
	public native boolean first_add_remarks_replace_on_paper( String strSealID, String strRemarks, int nRemarkWidth, byte[] byKeyword, boolean bUnique, int nXOffset, int nYOffset, boolean bOverText );
	public native boolean first_add_remarks_replace_on_paper( String strSealID, String strRemarks, int nRemarkWidth, byte[] byKeyword, int nPage, int nOrdinalNum, int nXOffset, int nYOffset, boolean bOverText );
	public native boolean first_add_remarks_replace_on_paper( String strSealID, int nType, String strRemarks, int nRemarkWidth, int nRemarkHeight, byte[] byKeyword, int nPage, int nOrdinalNum, int nXOffset, int nYOffset, boolean bOverText );
	public native boolean first_add_remarks_replace_on_paper( String strSealID, String strRemarks, int nRemarkWidth, int nPage, int nX, int nY, boolean bOverText);

	//�������ӵ�ȫ��ӡ��ģ��
	public native boolean seal_on_paper_clear();

	//��ӵ�����ͼģ�����עģ��(�����ͼģ���ѭ�����ã���ͼȫ����С��಻����3M)
	public native boolean second_add_backpic_on_paper( int nType, String strPicPathOrID, int nPage, int nX, int nY, int nWidth, int nHeight, boolean bOverText );
	
	//�����עģ�壬һ���������first_add_seal_on_paper����֮����ã�nPageֵ0�����һҳ���Դ�����
	public native boolean second_add_remarks_backpic_on_paper( int nType, String strSealID, String strRemarks, int nPage, int nX, int nY, int nWidth, int nHeight, boolean bOverText );
	public native boolean second_add_remarks_backpic_on_paper( int nType, String strSealID, String strRemarks, int nPage, int nX, int nY, int nWidth, int nHeight );
	public native boolean second_add_remarks_backpic_on_paper( int nType, String strSealID, String strRemarks, int nPage, int nX, int nY );
	
	//�������ӵ�ȫ����ͼģ��
	public native boolean backpic_on_paper_clear();

	//ǩ��ת���ĵ�
	public native int final_convert_document( String strInFile, int nUniqueFlag, boolean bDoc2pdfOnly, String strOutFile );
	public   int Final_convert_document( String strInFile, int nUniqueFlag, boolean bDoc2pdfOnly, String strOutFile )
	{
		return final_convert_document( strInFile, nUniqueFlag, bDoc2pdfOnly, strOutFile );
	}

	//ǩ��ת���ĵ���չ����
	public native int final_convert_document_ex( String strInFile, String strExt1, String strExt2, boolean bDoc2pdfOnly, String strOutFile );
	public native int final_convert_document_ex( String strInFile, String strExt1, String strExt2, boolean bDoc2pdfOnly, boolean bPdfFormatSignature, String strOutFile );
	
	//�����ļ���ǩ��ת���ĵ�
	public native int final_convert_document2( byte[] docBuffer, String strDocExtern,int nUniqueFlag, boolean bDoc2pdfOnly, String strOutFile );
    //�����ļ���ǩ��ת���ĵ���չ����
	public native int final_convert_document2_ex( byte[] docBuffer, String strDocExtern ,String strExt1, String strExt2, boolean bDoc2pdfOnly, String strOutFile );
    
	//����ļ���ǩ��ת���ĵ�
	public native byte[] final_convert_document3( byte[] docBuffer, String strDocExtern,int nUniqueFlag, boolean bDoc2pdfOnly );
	//����ļ���ǩ��ת���ĵ���չ����
	public native byte[] final_convert_document3_ex( byte[] docBuffer, String strDocExtern, String strExt1, String strExt2, boolean bDoc2pdfOnly );
    
	// ��֤ǩ���ļ�
	public native String direct_verify_document( String strInFile );

	//�ͷ�handle�ռ�
	public native void finally_free();
	public native void finally_free_ex( long nHandle );
	public void KTFreeHandle()
	{
		finally_free_ex( m_nHandle );
	}
	
	//��ȡ�ַ�������
	public native String get_error_by_code( int nErrorCode );

	//��ȡ�ϸ���������ʧ�ܵĴ����ַ�������
	public String get_last_error()
	{
		return m_strLastError;
	}
	
	private long m_nHandle;
	private String m_strLastError;

	private static void SealDemoTest()
	{
		KTAutoSealJavaClt clt = new KTAutoSealJavaClt( "125.77.73.161:2040", "test", "111111", true );       
		
		
		if( !clt.first_add_seal_on_paper( "E9AD490B16CD65458FBC1BCF9783C5EA", 0, 200, 200, true ) )
		{
			System.out.println( clt.get_last_error() );
			clt.finally_free();
			return;
		}
        /*
        
        boolean bRet = clt.second_add_remarks_backpic_on_paper( 3, "E9AD490B16CD65458FBC1BCF9783C5EA", "", 0, 0, 0, 0, 0, true );
        if( !bRet )
		{
			System.out.println( clt.get_last_error() );
			clt.finally_free();
			return;
		}
		
		try
		{
	        String remarks = "2019��10��08��";
			System.out.println( remarks );
			String keyword = "ʹ�õ�λ����";
			//boolean bRet = clt.first_add_seal_on_paper( "E9C37E0A37CA794F9BE8EB0E736189F5", 0, 200, 200, true );
			//boolean bRet = clt.first_add_seal_on_paper( "E9C37E0A37CA794F9BE8EB0E736189F5", 0, 200, 200, true );
			//boolean bRet = clt.first_add_seal_on_paper("AD47BD96BDE89A4A8CD4F2DC9A51A3DD", keyword.getBytes("utf-8"), true, 0, 0, true);
			//boolean bRet = clt.first_add_seal_on_paper("E9AD490B16CD65458FBC1BCF9783C5EA", keyword.getBytes("utf-8"), false, 0, 0, true);
			//boolean bRet = clt.first_add_seal_on_paper("56cf4221608f4dd7af0606d00a2e0f1d", keyword.getBytes("utf-8"), true, 0, 0, true);
			boolean bRet = clt.first_add_remarks_replace_on_paper("E9AD490B16CD65458FBC1BCF9783C5EA", remarks, 500, 0, 200, 200, true);
			//boolean bRet = clt.first_add_remarks_replace_on_paper("E9AD490B16CD65458FBC1BCF9783C5EA", remarks, 500, keyword.getBytes("utf-8"), false, 0, 0, true);
			if( !bRet )
			{
				System.out.println( clt.get_last_error() );
				clt.finally_free();
				return;
			}
		}	
		catch(Exception e)
		{
			 System.out.println("this is a test exception:" + e);
			 clt.finally_free();
			 return;
		}
        */
		//int nRet= clt.final_convert_document("c:/in.pdf" ,0, false, "c:/out.edc"  );
		//int nRet= clt.final_convert_document("c:/in.pdf" ,0, true, "c:/out.pdf"  );
		File file = new File("C:/Users/cq/Downloads/工程设计资质申请表.pdf");
		FileOutputStream fileOutputStream = null;
		FileInputStream fileInputStream = null;
		try {
			 fileInputStream = new FileInputStream(file);
			byte[] fileB = new byte[fileInputStream.available()];
			int read = fileInputStream.read(fileB);
			byte[] result = clt.final_convert_document3(fileB, "pdf", 0, false);
			File file1 = new File("C:/Users/cq/Downloads/2.pdf");
			if (!file1.exists()) {
				boolean newFile = file1.createNewFile();
			}
			fileOutputStream = new FileOutputStream(file1);
			fileOutputStream.write(result);
			fileOutputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println( "success!!!" );
        
 	     
        //pdfǩ���ĵ���֤
		//����JSON��Ϣ
		/*String info = clt.direct_verify_document("c:\\123_x.pdf");
		System.out.println( "[" + info + "]" );
		
		int nRet= clt.final_convert_document ("c:/test.pdf" ,0, false, "c:/1.edc"  );
		if( 0 != nRet )
		{
			System.out.println( nRet + "[" + clt.get_last_error() + "]" );
			clt.finally_free();
			return;
		}
		*/
		//System.out.println( "success!!!" );
        

		clt.finally_free();

	}

	public static void main(String[] args) 
	{
		 SealDemoTest();
	}
}

	 