package dk.opendesk.videoconversion.video;

import org.alfresco.model.ContentModel;
import org.alfresco.service.cmr.repository.ContentData;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.NodeService;

import javax.inject.Inject;
import java.util.Arrays;


public class VideoInputHandlerImpl implements VideoInputHandler {

    // TODO: using this constant should be changed... not compliant with Ansible
    private static final String ALFRESCO_ROOT_PATH = "/opt/alfresco";

    @Inject
    private NodeService nodeService;

    @Override
    public String getFormat(NodeRef nodeRef) {
        String cmContent = (String) nodeService.getProperty(nodeRef, ContentModel.PROP_NAME);
        String[] cmContentSplit = cmContent.split("\\.");
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
    public String getPath(NodeRef nodeRef) {

        ContentData contentData = (ContentData) nodeService.getProperty(nodeRef, ContentModel.PROP_CONTENT);

        return null;
    }
}
