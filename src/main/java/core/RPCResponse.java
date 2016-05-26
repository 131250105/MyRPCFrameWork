package core;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

public class RPCResponse {
		
	private long responseId;
	
	private Object values;

	public long getResponseId() {
		return responseId;
	}

	public void setResponseId(long responseId) {
		this.responseId = responseId;
	}

	public Object getValues() {
		return values;
	}

	public void setValues(Object values) {
		this.values = values;
	}
	
	public byte[] encode(){
		Schema<RPCResponse> schema = RuntimeSchema.getSchema(RPCResponse.class);
		LinkedBuffer buffer = LinkedBuffer.allocate(4096);
		byte[] protostuff = null;
		try {
            protostuff = ProtostuffIOUtil.toByteArray(this, schema, buffer);
            
        } finally {
            buffer.clear();
        }
		
		return protostuff;
	}
	
	public RPCResponse decode(byte[] response){
		if(response == null || response.length <= 0) {
            return null;
        }
		RPCResponse result = new RPCResponse();
		Schema<RPCResponse> schema = RuntimeSchema.getSchema(RPCResponse.class);
		ProtostuffIOUtil.mergeFrom(response, result, schema);
		return result;
	}
	
}
