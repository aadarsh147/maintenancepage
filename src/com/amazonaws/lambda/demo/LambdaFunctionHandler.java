package com.amazonaws.lambda.demo;

import org.json.simple.JSONObject;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class LambdaFunctionHandler implements RequestHandler<Object, JSONObject> {

    @Override
    public JSONObject handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);

        // TODO: implement your handler
        
        // reading values from environment variables
        
        String bucketName = System.getenv("SourceBucket");
        String key = System.getenv("ObjectName");
        
        // creating s3 client 
        
        AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.AP_SOUTHEAST_1).build();
        
        

        JSONObject obj = new JSONObject();
        JSONObject obj1 = new JSONObject();
        
        // payload for load balancer
        
        obj.put("statusCode",new Integer(200));
        obj.put("statusDescription", "200 OK");
        obj.put("isBase64Encoded", new Boolean(false));
        obj1.put("Content-Type","text/html; chars()et=utf-8");
        obj.put("headers",obj1);
       
        obj.put("body",s3.getObjectAsString(bucketName, key));
        return obj;
    }

}
