### Watson Conversation with Messenger4J

* The used watson functions can be found in **`com.example.demo.Messenger.CallBackHandler.java`**

* While running the project if **`Nosuchmethod`** error occurs do check if the library **`com.squareup.okhttp3`** version in external libraries of the project mismatches with the version in wcs library i.e. riverson in path **`repo/org/riverson/wcs`** used for watson connection.

##### Required fields

* private static final String WATSON_CONVERSATION_USERNAME = "943cfb53-53e2-4b4d-b89a-32180ca0d732";

* private static final String WATSON_CONVERSATION_PASSWORD = "qW6NbHIzMBnL";

* private static final String WATCON_CONVERSATION_WORKSPACE_ID = "b3da6be6-940b-4717-9013-8907d80fb00e";

	* These three can be acquired from the watson conversation workspace where we build the conversation.
	
* String wcsClientId = "dummy_user_id";
			
	* This is the user id of the client with whom watson is connected to. May be it should be the facebook id of the user if it is connected to the facebook messenger.
		
##### Connecting to watson

	WcsClient watson = new WcsClient(
            WATSON_CONVERSATION_USERNAME,
            WATSON_CONVERSATION_PASSWORD,
            WATCON_CONVERSATION_WORKSPACE_ID);
            
##### Sending message to watson

		MessageResponse wcsRes = watson.sendMessage(wcsClientId, myMessage);

* myMessage is a string variable  that is sent to watson. Eg. "Hello", "how are you?"
	
##### Accessing message received from watson

* Accessing the received message from watson that is stored in wcsRes object

		String receipt = wcsRes01.getTextConcatenated("");