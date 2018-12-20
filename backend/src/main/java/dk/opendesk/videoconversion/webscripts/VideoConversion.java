package dk.opendesk.videoconversion.webscripts;

import dk.opendesk.webscripts.OpenDeskWebScript;
import org.json.JSONException;
import org.springframework.extensions.webscripts.WebScriptRequest;
import org.springframework.extensions.webscripts.WebScriptResponse;

import java.io.IOException;

public class VideoConversion extends OpenDeskWebScript {

    @Override
    public void execute(WebScriptRequest req, WebScriptResponse res) throws IOException {
        super.execute(req, res);
        try {
            objectResult.put("foo", "bar");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        write(res);
    }
}
