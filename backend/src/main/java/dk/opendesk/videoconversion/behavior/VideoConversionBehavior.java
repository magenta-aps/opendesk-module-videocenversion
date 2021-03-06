package dk.opendesk.videoconversion.behavior;

import dk.opendesk.videoconversion.video.VideoFormat;
import dk.opendesk.videoconversion.video.VideoInputHandler;
import org.alfresco.model.ContentModel;
import org.alfresco.repo.content.ContentServicePolicies;
import org.alfresco.repo.policy.Behaviour;
import org.alfresco.repo.policy.JavaBehaviour;
import org.alfresco.repo.policy.PolicyComponent;
import org.alfresco.service.cmr.repository.ContentData;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.NodeService;
import org.alfresco.service.namespace.NamespaceService;
import org.alfresco.service.namespace.QName;

public class VideoConversionBehavior implements ContentServicePolicies.OnContentUpdatePolicy {

    private static final String ON_CONTENT_UPDATE = "onContentUpdate";

    private NodeService nodeService;
    private PolicyComponent policyComponent;
    private VideoInputHandler videoInputHandler;

    @Override
    public void onContentUpdate(NodeRef nodeRef, boolean newContent) {
        String filename = (String) nodeService.getProperty(nodeRef, ContentModel.PROP_NAME);
        String videoFormat = videoInputHandler.getFormat(filename);
        if (videoFormat != null) {
            ContentData contentData = (ContentData) nodeService.getProperty(nodeRef, ContentModel.PROP_CONTENT);
            String path = videoInputHandler.getPath(contentData);
        }

    }

    public void init() {
        policyComponent.bindClassBehaviour(
                QName.createQName(NamespaceService.ALFRESCO_URI, ON_CONTENT_UPDATE),
                this,
                new JavaBehaviour(this, ON_CONTENT_UPDATE, Behaviour.NotificationFrequency.TRANSACTION_COMMIT)
                );
    }

    public void setPolicyComponent(PolicyComponent policyComponent) {
        this.policyComponent = policyComponent;
    }

    public void setNodeService(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    public void setVideoInputHandler(VideoInputHandler videoInputHandler) {
        this.videoInputHandler = videoInputHandler;
    }
}
