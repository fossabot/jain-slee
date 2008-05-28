package org.csapi.cs;

/**
 *	Generated from IDL definition of alias "TpVolumeSet"
 *	@author JacORB IDL compiler 
 */

public final class TpVolumeSetHelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, org.csapi.cs.TpVolume[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static org.csapi.cs.TpVolume[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(org.csapi.cs.TpVolumeSetHelper.id(), "TpVolumeSet",org.omg.CORBA.ORB.init().create_sequence_tc(0, org.csapi.cs.TpVolumeHelper.type()));
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:org/csapi/cs/TpVolumeSet:1.0";
	}
	public static org.csapi.cs.TpVolume[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		org.csapi.cs.TpVolume[] _result;
		int _l_result6 = _in.read_long();
		_result = new org.csapi.cs.TpVolume[_l_result6];
		for (int i=0;i<_result.length;i++)
		{
			_result[i]=org.csapi.cs.TpVolumeHelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, org.csapi.cs.TpVolume[] _s)
	{
		
		_out.write_long(_s.length);
		for (int i=0; i<_s.length;i++)
		{
			org.csapi.cs.TpVolumeHelper.write(_out,_s[i]);
		}

	}
}
