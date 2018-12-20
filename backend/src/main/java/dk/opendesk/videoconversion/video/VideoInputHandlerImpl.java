package dk.opendesk.videoconversion.video;

import org.alfresco.model.ContentModel;
import org.alfresco.service.cmr.repository.ContentData;

import java.util.Arrays;


public class VideoInputHandlerImpl implements VideoInputHandler {

    // TODO: using this constant should be changed... not compliant with Ansible
    private static final String ALFRESCO_ROOT_PATH = "/opt/alfresco";

//    @Inject
//    private NodeService nodeService;

    @Override
    public String getFormat(String filename) {
        String[] cmContentSplit = filename.split("\\.");
        int length = cmContentSplit.length;
        if (length > 1) {
            String extension = cmContentSplit[length - 1].toLowerCase();
            if (Arrays.asList(VideoFormat.FORMATS).contains(extension)) {
                return extension;
            }
        }

        return null;
    }

    @Override
    public String getPath(ContentData contentData) {



        return null;
    }
}
