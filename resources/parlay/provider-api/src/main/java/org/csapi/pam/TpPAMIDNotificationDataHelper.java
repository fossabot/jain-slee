package org.csapi.pam;


/**
 *	Generated from IDL definition of struct "TpPAMIDNotificationData"
 *	@author JacORB IDL compiler 
 */

public final class TpPAMIDNotificationDataHelper
{
	private static org.omg.CORBA.TypeCode _type = null;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_struct_tc(org.csapi.pam.TpPAMIDNotificationDataHelper.id(),"TpPAMIDNotificationData",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("Identities", org.csapi.pam.TpPAMFQNameListHelper.type(), null)});
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final org.csapi.pam.TpPAMIDNotificationData s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static org.csapi.pam.TpPAMIDNotificationData extract (final org.omg.CORBA.Any any)
	{
		return read(any.create_input_stream());
	}

	public static String id()
	{
		return "IDL:org/csapi/pam/TpPAMIDNotificationData:1.0";
	}
	public static org.csapi.pam.TpPAMIDNotificationData read (final org.omg.CORBA.portable.InputStream in)
	{
		org.csapi.pam.TpPAMIDNotificationData result = new org.csapi.pam.TpPAMIDNotificationData();
		result.Identities = org.csapi.pam.TpPAMFQNameListHelper.read(in);
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final org.csapi.pam.TpPAMIDNotificationData s)
	{
		org.csapi.pam.TpPAMFQNameListHelper.write(out,s.Identities);
	}
}
