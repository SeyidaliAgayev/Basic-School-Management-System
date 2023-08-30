package files.impl;

import data.GlobalData;
import data.PersonDynamicArrays;
import files.FileServiceInter;
import jakarta.xml.bind.Marshaller;
import model.Person;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import wrapper.PersonWrapper;


import java.io.*;



public class FileServiceImpl implements FileServiceInter {
    @Override
    public void writeInformation(String filePath, Person[] person) {
        try {

            jakarta.xml.bind.JAXBContext jaxbContext = JAXBContextFactory
                    .createContext(new Class[] {PersonWrapper.class}, null);
            org.eclipse.persistence.jaxb.JAXBMarshaller moxyMarshaller =
                    (org.eclipse.persistence.jaxb.JAXBMarshaller) jaxbContext.createMarshaller();
            moxyMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/xml");
            moxyMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            File file = new File(filePath);
            PersonWrapper personWrapper = new PersonWrapper();
            personWrapper.setPersons(person);
            if (!file.exists()) {
                moxyMarshaller.marshal(personWrapper,file);
            } else {
                try {
                    FileOutputStream outputStream = new FileOutputStream(file, true);
                    moxyMarshaller.marshal(personWrapper, outputStream);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        } catch (jakarta.xml.bind.JAXBException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void readInformation(String filePath) {
        try {
            jakarta.xml.bind.JAXBContext jaxbContext = JAXBContextFactory
                    .createContext(new Class[] {PersonWrapper.class}, null);
            org.eclipse.persistence.jaxb.JAXBUnmarshaller moxyUnmarshaller =
                    (org.eclipse.persistence.jaxb.JAXBUnmarshaller) jaxbContext.createUnmarshaller();

            File file = new File(filePath);
            PersonWrapper personWrapper = (PersonWrapper) moxyUnmarshaller.unmarshal(file);
            Person[] persons =  personWrapper.getPersons();
            for (Person person : persons) {
                System.out.println(person.toString());
            }
        } catch (jakarta.xml.bind.JAXBException exception) {
            exception.printStackTrace();
        }
    }
}
