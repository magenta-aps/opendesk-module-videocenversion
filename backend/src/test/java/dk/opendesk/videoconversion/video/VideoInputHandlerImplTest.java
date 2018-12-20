package dk.opendesk.videoconversion.video;

import com.tradeshift.test.remote.Remote;
import com.tradeshift.test.remote.RemoteTestRunner;
import org.alfresco.model.ContentModel;
import org.alfresco.repo.nodelocator.CompanyHomeNodeLocator;
import org.alfresco.repo.nodelocator.NodeLocatorService;
import org.alfresco.service.cmr.repository.ChildAssociationRef;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.NodeService;
import org.alfresco.service.namespace.NamespaceService;
import org.alfresco.service.namespace.QName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.alfresco.service.namespace.QName.createQName;
import static org.junit.Assert.assertTrue;



@RunWith(RemoteTestRunner.class)
@Remote(runnerClass=SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:alfresco/application-context.xml")
public class VideoInputHandlerImplTest {

    @Autowired
    @Qualifier("NodeService")
    private NodeService nodeService;

    @Autowired
    @Qualifier("nodeLocatorService")
    private NodeLocatorService nodeLocatorService;


    @Test
    public void formatIsMOV() {
        System.out.println(getCompanyHomeNodeRef());

        NodeRef parentFolderNodeRef = getCompanyHomeNodeRef();
        QName associationType = ContentModel.ASSOC_CONTAINS;
        QName associationQName = createQName(NamespaceService.CONTENT_MODEL_1_0_URI, QName.createValidLocalName("video.mov"));

        Map<QName, Serializable> properties = new HashMap<>();
        properties.put(ContentModel.PROP_NAME, "video.mov");
        ChildAssociationRef parentChildAssocRef = nodeService.createNode(
                parentFolderNodeRef,
                associationType,
                associationQName,
                ContentModel.TYPE_CONTENT,
                properties
        );

        NodeRef video = parentChildAssocRef.getChildRef();

        Map<QName, Serializable> video_properties = nodeService.getProperties(video);

        assertEquals("video.mov", video_properties.get(ContentModel.PROP_NAME));

    }


    private NodeRef getCompanyHomeNodeRef() {
        return nodeLocatorService.getNode(CompanyHomeNodeLocator.NAME, null, null);
    }
//    @Test
//    public void test() {
//        assertTrue(true);
//    }
}
