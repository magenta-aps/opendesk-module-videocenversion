# opendesk-module-template
This is the template for OpenDESK modules. The template should be used in the following way:

## Build the OpenDESK core AMP and jar

In order to build this module AMP you need to make sure that the OpenDESK core jar and AMP files 
are located in your local `.m2` folder. Do the following in order to build the OpenDESK core AMP:

```
$ git clone https://github.com/magenta-aps/OpenDESK.git
$ cd OpenDESK/backend
$ mvn clean install
```

The OpenDESK jar file can be build by first changing the `<package>` tag in the POM file 
to `jar` and then run `mvn clean install` again.

## Change the placeholder artifactId

The project is currently called `PLACEHOLDERARTIFACTID`. This must be changed to 
whatever the name of this module is. Do the following:

* In the POM, set the content of the `<artifactId>` tag to an appropriate name.
* Change the name of the folder `backend/src/main/amp/config/alfresco/module/PLACEHOLDERARTIFACTID` to the same value as the one used in the `<artifactId>`.
* Do the same for the folder `backend/src/main/java/dk/opendesk/PLACEHOLDERARTIFACTID`

## Add beans

If you need any Alfresco or OpenDESK beans you must add these to the file `backend/src/main/amp/config/alfresco/module/PLACEHOLDERARTIFACTID/context/bean-context.xml`. For example

```
<beans>
  <bean id="authorityBean" class="dk.opendesk.repo.beans.AuthorityBean">
    <property name="personBean" ref="personBean"/>
    <property name="authorityService" ref="AuthorityService"/>
  </bean>
</beans>
```

## IDE stuff

In IntelliJ IDEA, go to File -> Settings -> Build, Execution, Deployment -> Debugger -> Data Views -> 
Java and make sure that the "Enable 'toString()' object view" is disabled (this is an Alfresco 
specific thing...).