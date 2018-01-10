package com.example.demo;

import org.riversun.wcs.WcsClient;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

public class App {
    //Parameters to connect to watson
    private static final String WATSON_CONVERSATION_USERNAME = "943cfb53-53e2-4b4d-b89a-32180ca0d732";
    private static final String WATSON_CONVERSATION_PASSWORD = "qW6NbHIzMBnL";
    private static final String WATCON_CONVERSATION_WORKSPACE_ID = "b3da6be6-940b-4717-9013-8907d80fb00e";

    public static void main(String[] args)
    {

        // Set unique id for each user to be able to talk to Watson at the same
        // time
        String wcsClientId = "dummy_user_id";

        // Create client for Watson Conversation Username, password,
        // workspaceId can be confirmed on the workspace screen of Watson
        // Conversation's workspace
        WcsClient watson = new WcsClient(
                WATSON_CONVERSATION_USERNAME,
                WATSON_CONVERSATION_PASSWORD,
                WATCON_CONVERSATION_WORKSPACE_ID);

        // Perform initial access (call welcome node)
        // Call #startConversation for the first access to workspace
        MessageResponse wcsWelcomeRes = watson.startConversation(wcsClientId);

        System.out.println("FROM WATSON:" + wcsWelcomeRes.getTextConcatenated(""));

        // The context variable is sent
        // at the next access and reflected in Watson
        // (wcsClientId,name,value)
        watson.put(wcsClientId, "myRemoteParam", "I need you!");

        // Send text to Watson
        final String myMessage01 = "Hi! Watson";
        MessageResponse wcsRes01 = watson.sendMessage(wcsClientId, myMessage01);
        System.out.println("FROM WATSON:" + wcsRes01.getTextConcatenated(""));

        // Send text and get response as text
        final String myMessage02 = "Hello! Watson";
        String wcsResText = watson.sendMessageForText(wcsClientId, myMessage02);
        System.out.println("FROM WATSON:" + wcsResText);
    }
}
