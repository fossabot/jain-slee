package org.csapi.fw.fw_service.integrity;


/**
 *	Generated from IDL interface "IpFwOAM"
 *	@author JacORB IDL compiler V 2.1, 16-Feb-2004
 */

public class _IpFwOAMStub
	extends org.omg.CORBA.portable.ObjectImpl
	implements org.csapi.fw.fw_service.integrity.IpFwOAM
{
	private String[] ids = {"IDL:org/csapi/fw/fw_service/integrity/IpFwOAM:1.0","IDL:org/csapi/IpInterface:1.0"};
	public String[] _ids()
	{
		return ids;
	}

	public final static java.lang.Class _opsClass = org.csapi.fw.fw_service.integrity.IpFwOAMOperations.class;
	public java.lang.String systemDateTimeQuery(java.lang.String clientDateAndTime) throws org.csapi.TpCommonExceptions,org.csapi.P_INVALID_TIME_AND_DATE_FORMAT
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "systemDateTimeQuery", true);
				_os.write_string(clientDateAndTime);
				_is = _invoke(_os);
				java.lang.String _result = _is.read_string();
				return _result;
			}
			catch( org.omg.CORBA.portable.RemarshalException _rx ){}
			catch( org.omg.CORBA.portable.ApplicationException _ax )
			{
				String _id = _ax.getId();
				if( _id.equals("IDL:org/csapi/TpCommonExceptions:1.0"))
				{
					throw org.csapi.TpCommonExceptionsHelper.read(_ax.getInputStream());
				}
				else if( _id.equals("IDL:org/csapi/P_INVALID_TIME_AND_DATE_FORMAT:1.0"))
				{
					throw org.csapi.P_INVALID_TIME_AND_DATE_FORMATHelper.read(_ax.getInputStream());
				}
				else 
					throw new RuntimeException("Unexpected exception " + _id );
			}
			finally
			{
				this._releaseReply(_is);
			}
		}
		else
		{
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "systemDateTimeQuery", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			IpFwOAMOperations _localServant = (IpFwOAMOperations)_so.servant;
			java.lang.String _result;			try
			{
			_result = _localServant.systemDateTimeQuery(clientDateAndTime);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return _result;
		}

		}

	}

}
