package core;

import java.util.ArrayList;

import org.omg.CORBA.Request;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

public class RPCRequest {

	private long requestId;
	
	private String message;
	
	private ArrayList<Object> params = new ArrayList<Object>(20);

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<Object> getParams() {
		return params;
	}

	public void setParams(ArrayList<Object> params) {
		this.params = params;
	}
	
	
	public byte[] encode(){
		Schema<RPCRequest> schema = RuntimeSchema.getSchema(RPCRequest.class);
		LinkedBuffer buffer = LinkedBuffer.allocate(4096);
		byte[] protostuff = null;
		try {
            protostuff = ProtostuffIOUtil.toByteArray(this, schema, buffer);
            
        } finally {
            buffer.clear();
        }
		
		return protostuff;
	}
	
	public  RPCRequest decode(byte[] request){
		if(request == null || request.length <= 0) {
            return null;
        }
		RPCRequest result = new RPCRequest();
		Schema<RPCRequest> schema = RuntimeSchema.getSchema(RPCRequest.class);
		ProtostuffIOUtil.mergeFrom(request, result, schema);
		return result;
	}
	
}
