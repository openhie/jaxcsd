package zw.co.hitrac.jaxcsd.api.parser;

import java.io.ByteArrayInputStream;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import junit.framework.TestCase;
import zw.co.hitrac.jaxcsd.api.domain.CSD;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdElement;
import zw.co.hitrac.jaxcsd.api.parser.util.CsdParserExtensions;
import zw.co.hitrac.jaxcsd.api.util.CsdElementConstants;

/**
 *
 * @author Charles Chigoriwa
 */
public class CsdParserTest extends TestCase {

    public CsdParserTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of parse method, of class CsdParser.
     */
    public void testParse() throws Exception {
        System.out.println("parse");
        XMLInputFactory f = XMLInputFactory.newInstance();
        XMLStreamReader r = f.createXMLStreamReader(new ByteArrayInputStream(getXml().getBytes()));
        CSD csd = new CSD();
        CsdParserExtensions csdParserExtensions = null;
        CsdParser csdParser = new CsdParser();
        CsdElement csdElement = new CsdElement(CsdElementConstants.CSD);
        csdParser.parse(csd, csdElement, r, csdParserExtensions);
        assertTrue(csd.getFacilityDirectory().isEmpty());
        assertTrue(csd.getServiceDirectory().isEmpty());
        assertTrue(csd.getOrganizationDirectory().isEmpty());
        assertTrue(!csd.getProviderDirectory().isEmpty());
        
    }

    public static String getXml() {
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<CSD xmlns=\"urn:ihe:iti:csd:2013\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:ihe:iti:csd:2013 CSD.xsd\">\n"
                + "	<organizationDirectory/>\n"
                + "	<serviceDirectory/>\n"
                + "	<facilityDirectory/>\n"
                + "	<providerDirectory>\n"
                + "		<provider oid=\"1.3.6.1.4.1.21367.200.99.1111\">\n"
                + "			<codedType code=\"105-007\" codingSchema=\"1.3.6.1.4.1.21367.100.1\">Physician/Medical Oncology</codedType>\n"
                + "			<demographic>\n"
                + "				<name>\n"
                + "					<commonName>Banargee, Dev</commonName>\n"
                + "					<honorific>Dr.</honorific>\n"
                + "					<forename>Dev</forename>\n"
                + "					<surname>Banerjee</surname>\n"
                + "				</name>\n"
                + "				<contactPoint>\n"
                + "					<codedType code=\"BP\" codingSchema=\"urn:ihe:iti:csd:2013:contactPoint\">555-777-1111</codedType>\n"
                + "				</contactPoint>\n"
                + "				<contactPoint>\n"
                + "					<codedType code=\"FAX\" codingSchema=\"urn:ihe:iti:csd:2013:contactPoint\">555-888-1111</codedType>\n"
                + "				</contactPoint>\n"
                + "				<address type=\"Mailing\">\n"
                + "					<addressLine component=\"streetAddress\">8909 Sunset Way</addressLine>\n"
                + "					<addressLine component=\"city\">Santa Fe</addressLine>\n"
                + "					<addressLine component=\"stateProvince\">NM</addressLine>\n"
                + "					<addressLine component=\"country\">USA</addressLine>\n"
                + "					<addressLine component=\"postalCode\">87505</addressLine>\n"
                + "				</address>\n"
                + "				<gender>M</gender>\n"
                + "			</demographic>\n"
                + "			<language code=\"en\" codingSchema=\"BCP 47\">English</language>\n"
                + "			<language code=\"bn\" codingSchema=\"BCP 47\">Bengali</language>\n"
                + "			<organizations>\n"
                + "				<organization oid=\"1.3.6.1.4.1.21367.200.99.1\"/>\n"
                + "				<organization oid=\"1.3.6.1.4.1.21367.200.99.3\"/>\n"
                + "			</organizations>\n"
                + "			<credential>\n"
                + "				<codedType code=\"108-001\" codingSchema=\"1.3.6.1.4.1.21367.100.1\"/>\n"
                + "				<number>A_Degree@Connectathon_domain_name</number>\n"
                + "				<issuingAuthority>Connectathon_Manager</issuingAuthority>\n"
                + "				<credentialIssueDate>2013-12-01</credentialIssueDate>\n"
                + "			</credential>\n"
                + "			<specialty code=\"109-003\" codingSchema=\"1.3.6.1.4.1.21367.100.1\"/>\n"
                + "			<record created=\"2013-12-01T14:00:00+00:00\" updated=\"2013-12-01T14:00:00+00:00\" status=\"Active\" sourceDirectory=\"http://www.ihe.net\"/>\n"
                + "		</provider>\n"
                + "		<provider oid=\"1.3.6.1.4.1.21367.200.99.1112\">\n"
                + "			<codedType code=\"105-113\" codingSchema=\"1.3.6.1.4.1.21367.100.1\">Physician/Mammographer</codedType>\n"
                + "			<demographic>\n"
                + "				<name>\n"
                + "					<commonName>McDonald, Mary</commonName>\n"
                + "					<honorific>Dr.</honorific>\n"
                + "					<forename>Mary</forename>\n"
                + "					<surname>McDonald</surname>\n"
                + "				</name>\n"
                + "				<contactPoint>\n"
                + "					<codedType code=\"BP\" codingSchema=\"urn:ihe:iti:csd:2013:contactPoint\">555-777-1111</codedType>\n"
                + "				</contactPoint>\n"
                + "				<contactPoint>\n"
                + "					<codedType code=\"FAX\" codingSchema=\"urn:ihe:iti:csd:2013:contactPoint\">555-888-1111</codedType>\n"
                + "				</contactPoint>\n"
                + "				<address type=\"Mailing\">\n"
                + "					<addressLine component=\"streetAddress\">8909 Sunset Way</addressLine>\n"
                + "					<addressLine component=\"city\">Santa Fe</addressLine>\n"
                + "					<addressLine component=\"stateProvince\">NM</addressLine>\n"
                + "					<addressLine component=\"country\">USA</addressLine>\n"
                + "					<addressLine component=\"postalCode\">87505</addressLine>\n"
                + "				</address>\n"
                + "				<gender>F</gender>\n"
                + "			</demographic>\n"
                + "			<language code=\"en\" codingSchema=\"BCP 47\">English</language>\n"
                + "			<organizations>\n"
                + "				<organization oid=\"1.3.6.1.4.1.21367.200.99.1\"/>\n"
                + "			</organizations>\n"
                + "			<credential>\n"
                + "				<codedType code=\"108-001\" codingSchema=\"1.3.6.1.4.1.21367.100.1\"/>\n"
                + "				<number>A_Degree@Connectathon_domain_name</number>\n"
                + "				<issuingAuthority>Connectathon_Manager</issuingAuthority>\n"
                + "				<credentialIssueDate>2013-12-01</credentialIssueDate>\n"
                + "			</credential>\n"
                + "			<specialty code=\"109-005\" codingSchema=\"1.3.6.1.4.1.21367.100.1\"/>\n"
                + "			<record created=\"2013-12-01T14:00:00+00:00\" updated=\"2013-12-01T14:00:00+00:00\" status=\"Active\" sourceDirectory=\"http://www.ihe.net\"/>\n"
                + "		</provider>\n"
                + "		<provider oid=\"1.3.6.1.4.1.21367.200.99.1113\">\n"
                + "			<codedType code=\"105-114\" codingSchema=\"1.3.6.1.4.1.21367.100.1\">Radiology Technician</codedType>\n"
                + "			<demographic>\n"
                + "				<name>\n"
                + "					<commonName>Johnson, Jack</commonName>\n"
                + "					<forename>Jack</forename>\n"
                + "					<surname>Johnson</surname>\n"
                + "				</name>\n"
                + "				<contactPoint>\n"
                + "					<codedType code=\"BP\" codingSchema=\"urn:ihe:iti:csd:2013:contactPoint\">555-777-2223</codedType>\n"
                + "				</contactPoint>\n"
                + "				<contactPoint>\n"
                + "					<codedType code=\"FAX\" codingSchema=\"urn:ihe:iti:csd:2013:contactPoint\">555-888-2223</codedType>\n"
                + "				</contactPoint>\n"
                + "				<address type=\"Mailing\">\n"
                + "					<addressLine component=\"streetAddress\">8909 Sunset Way</addressLine>\n"
                + "					<addressLine component=\"city\">Santa Fe</addressLine>\n"
                + "					<addressLine component=\"stateProvince\">NM</addressLine>\n"
                + "					<addressLine component=\"country\">USA</addressLine>\n"
                + "					<addressLine component=\"postalCode\">87505</addressLine>\n"
                + "				</address>\n"
                + "				<gender>M</gender>\n"
                + "			</demographic>\n"
                + "			<language code=\"en\" codingSchema=\"BCP 47\">English</language>\n"
                + "			<organizations>\n"
                + "				<organization oid=\"1.3.6.1.4.1.21367.200.99.1\"/>\n"
                + "			</organizations>\n"
                + "			<credential>\n"
                + "				<codedType code=\"108-002\" codingSchema=\"1.3.6.1.4.1.21367.100.1\"/>\n"
                + "				<number>A_Certificate@Connectathon_domain_name</number>\n"
                + "				<issuingAuthority>Connectathon_Manager</issuingAuthority>\n"
                + "				<credentialIssueDate>2013-12-01</credentialIssueDate>\n"
                + "			</credential>\n"
                + "			<specialty code=\"109-005\" codingSchema=\"1.3.6.1.4.1.21367.100.1\"/>\n"
                + "			<record created=\"2013-12-01T14:00:00+00:00\" updated=\"2013-12-01T14:00:00+00:00\" status=\"Active\" sourceDirectory=\"http://www.ihe.net\"/>\n"
                + "		</provider>\n"
                + "		<provider oid=\"1.3.6.1.4.1.21367.200.99.1114\">\n"
                + "			<codedType code=\"105-114\" codingSchema=\"1.3.6.1.4.1.21367.100.1\">Radiology Technician</codedType>\n"
                + "			<demographic>\n"
                + "				<name>\n"
                + "					<commonName>Carrara, Carla</commonName>\n"
                + "					<forename>Carla</forename>\n"
                + "					<surname>Carrara</surname>\n"
                + "				</name>\n"
                + "				<contactPoint>\n"
                + "					<codedType code=\"BP\" codingSchema=\"urn:ihe:iti:csd:2013:contactPoint\">555-777-1114</codedType>\n"
                + "				</contactPoint>\n"
                + "				<contactPoint>\n"
                + "					<codedType code=\"FAX\" codingSchema=\"urn:ihe:iti:csd:2013:contactPoint\">555-888-1114</codedType>\n"
                + "				</contactPoint>\n"
                + "				<address type=\"Mailing\">\n"
                + "					<addressLine component=\"streetAddress\">8909 Sunset Way</addressLine>\n"
                + "					<addressLine component=\"city\">Santa Fe</addressLine>\n"
                + "					<addressLine component=\"stateProvince\">NM</addressLine>\n"
                + "					<addressLine component=\"country\">USA</addressLine>\n"
                + "					<addressLine component=\"postalCode\">87505</addressLine>\n"
                + "				</address>\n"
                + "				<gender>F</gender>\n"
                + "			</demographic>\n"
                + "			<language code=\"es\" codingSchema=\"BCP 47\">Spanish</language>\n"
                + "			<organizations>\n"
                + "				<organization oid=\"1.3.6.1.4.1.21367.200.99.3\"/>\n"
                + "			</organizations>\n"
                + "			<credential>\n"
                + "				<codedType code=\"108-002\" codingSchema=\"1.3.6.1.4.1.21367.100.1\"/>\n"
                + "				<number>A_Certificate@Connectathon_domain_name</number>\n"
                + "				<issuingAuthority>Connectathon_Manager</issuingAuthority>\n"
                + "				<credentialIssueDate>2013-12-01</credentialIssueDate>\n"
                + "			</credential>\n"
                + "			<specialty code=\"109-005\" codingSchema=\"1.3.6.1.4.1.21367.100.1\"/>\n"
                + "			<record created=\"2013-12-01T14:00:00+00:00\" updated=\"2013-12-01T14:00:00+00:00\" status=\"Active\" sourceDirectory=\"http://www.ihe.net\"/>\n"
                + "		</provider>\n"
                + "		<provider oid=\"1.3.6.1.4.1.21367.200.99.1115\">\n"
                + "			<codedType code=\"105-007\" codingSchema=\"1.3.6.1.4.1.21367.100.1\">Physician/Medical Oncology</codedType>\n"
                + "			<demographic>\n"
                + "				<name>\n"
                + "					<commonName>Robertson, Robert</commonName>\n"
                + "					<forename>Robert</forename>\n"
                + "					<surname>Robertson</surname>\n"
                + "				</name>\n"
                + "				<contactPoint>\n"
                + "					<codedType code=\"BP\" codingSchema=\"urn:ihe:iti:csd:2013:contactPoint\">555-777-4445</codedType>\n"
                + "				</contactPoint>\n"
                + "				<contactPoint>\n"
                + "					<codedType code=\"FAX\" codingSchema=\"urn:ihe:iti:csd:2013:contactPoint\">555-888-4445</codedType>\n"
                + "				</contactPoint>\n"
                + "				<address type=\"Mailing\">\n"
                + "					<addressLine component=\"streetAddress\">2887 Commerce Blvd</addressLine>\n"
                + "					<addressLine component=\"city\">Orlando</addressLine>\n"
                + "					<addressLine component=\"stateProvince\">FL</addressLine>\n"
                + "					<addressLine component=\"country\">USA</addressLine>\n"
                + "					<addressLine component=\"postalCode\">32789</addressLine>\n"
                + "				</address>\n"
                + "				<gender>M</gender>\n"
                + "			</demographic>\n"
                + "			<language code=\"en\" codingSchema=\"BCP 47\">English</language>\n"
                + "			<organizations>\n"
                + "				<organization oid=\"1.3.6.1.4.1.21367.200.99.3\"/>\n"
                + "			</organizations>\n"
                + "			<credential>\n"
                + "				<codedType code=\"108-001\" codingSchema=\"1.3.6.1.4.1.21367.100.1\"/>\n"
                + "				<number>A_Degree@Connectathon_domain_name</number>\n"
                + "				<issuingAuthority>Connectathon_Manager</issuingAuthority>\n"
                + "				<credentialIssueDate>2013-12-01</credentialIssueDate>\n"
                + "			</credential>\n"
                + "			<specialty code=\"109-003\" codingSchema=\"1.3.6.1.4.1.21367.100.1\"/>\n"
                + "			<record created=\"2013-12-01T14:00:00+00:00\" updated=\"2013-12-01T14:00:00+00:00\" status=\"Active\" sourceDirectory=\"http://www.ihe.net\"/>\n"
                + "		</provider>		\n"
                + "		\n"
                + "		<provider oid=\"1.3.6.1.4.1.21367.200.99.1116\">\n"
                + "			<codedType code=\"105-003\" codingSchema=\"1.3.6.1.4.1.21367.100.1\">Nurse Practitioner</codedType>\n"
                + "			<demographic>\n"
                + "				<name>\n"
                + "					<commonName>Williamson, William</commonName>\n"
                + "					<forename>William</forename>\n"
                + "					<surname>Williamson</surname>\n"
                + "				</name>\n"
                + "				<contactPoint>\n"
                + "					<codedType code=\"BP\" codingSchema=\"urn:ihe:iti:csd:2013:contactPoint\">555-777-4445</codedType>\n"
                + "				</contactPoint>\n"
                + "				<contactPoint>\n"
                + "					<codedType code=\"FAX\" codingSchema=\"urn:ihe:iti:csd:2013:contactPoint\">555-888-4445</codedType>\n"
                + "				</contactPoint>\n"
                + "				<address type=\"Mailing\">\n"
                + "					<addressLine component=\"streetAddress\">2887 Commerce Blvd</addressLine>\n"
                + "					<addressLine component=\"city\">Orlando</addressLine>\n"
                + "					<addressLine component=\"stateProvince\">FL</addressLine>\n"
                + "					<addressLine component=\"country\">USA</addressLine>\n"
                + "					<addressLine component=\"postalCode\">32789</addressLine>\n"
                + "				</address>\n"
                + "				<gender>M</gender>\n"
                + "			</demographic>\n"
                + "			<language code=\"en\" codingSchema=\"BCP 47\">English</language>\n"
                + "			<organizations>\n"
                + "				<organization oid=\"1.3.6.1.4.1.21367.200.99.3\"/>\n"
                + "			</organizations>\n"
                + "			<credential>\n"
                + "				<codedType code=\"108-001\" codingSchema=\"1.3.6.1.4.1.21367.100.1\"/>\n"
                + "				<number>A_Degree@Connectathon_domain_name</number>\n"
                + "				<issuingAuthority>Connectathon_Manager</issuingAuthority>\n"
                + "				<credentialIssueDate>2013-12-01</credentialIssueDate>\n"
                + "			</credential>\n"
                + "			<specialty code=\"109-003\" codingSchema=\"1.3.6.1.4.1.21367.100.1\"/>\n"
                + "			<record created=\"2013-12-01T14:00:00+00:00\" updated=\"2013-12-01T14:00:00+00:00\" status=\"Active\" sourceDirectory=\"http://www.ihe.net\"/>\n"
                + "		</provider>		\n"
                + "		<provider oid=\"1.3.6.1.4.1.21367.200.99.1117\">\n"
                + "			<codedType code=\"105-003\" codingSchema=\"1.3.6.1.4.1.21367.100.1\">Nurse Practitioner</codedType>\n"
                + "			<demographic>\n"
                + "				<name>\n"
                + "					<commonName>Fredricks, Theodora</commonName>\n"
                + "					<forename>Theodora</forename>\n"
                + "					<surname>Fredricks</surname>\n"
                + "				</name>\n"
                + "				<contactPoint>\n"
                + "					<codedType code=\"BP\" codingSchema=\"urn:ihe:iti:csd:2013:contactPoint\">555-777-4945</codedType>\n"
                + "				</contactPoint>\n"
                + "				<contactPoint>\n"
                + "					<codedType code=\"FAX\" codingSchema=\"urn:ihe:iti:csd:2013:contactPoint\">555-888-4945</codedType>\n"
                + "				</contactPoint>\n"
                + "				<address type=\"Mailing\">\n"
                + "					<addressLine component=\"streetAddress\">2887 Commerce Blvd</addressLine>\n"
                + "					<addressLine component=\"city\">Orlando</addressLine>\n"
                + "					<addressLine component=\"stateProvince\">FL</addressLine>\n"
                + "					<addressLine component=\"country\">USA</addressLine>\n"
                + "					<addressLine component=\"postalCode\">32789</addressLine>\n"
                + "				</address>\n"
                + "				<gender>F</gender>\n"
                + "			</demographic>\n"
                + "			<language code=\"en\" codingSchema=\"BCP 47\">English</language>\n"
                + "			<organizations>\n"
                + "				<organization oid=\"1.3.6.1.4.1.21367.200.99.3\"/>\n"
                + "			</organizations>\n"
                + "			<credential>\n"
                + "				<codedType code=\"108-001\" codingSchema=\"1.3.6.1.4.1.21367.100.1\"/>\n"
                + "				<number>A_Degree@Connectathon_domain_name</number>\n"
                + "				<issuingAuthority>Connectathon_Manager</issuingAuthority>\n"
                + "				<credentialIssueDate>2013-12-01</credentialIssueDate>\n"
                + "			</credential>\n"
                + "			<specialty code=\"109-003\" codingSchema=\"1.3.6.1.4.1.21367.100.1\"/>\n"
                + "			<record created=\"2013-12-01T14:00:00+00:00\" updated=\"2013-12-01T14:00:00+00:00\" status=\"Active\" sourceDirectory=\"http://www.ihe.net\"/>\n"
                + "		</provider>\n"
                + "		<provider oid=\"1.3.6.1.4.1.21367.200.99.1118\">\n"
                + "			<codedType code=\"105-003\" codingSchema=\"1.3.6.1.4.1.21367.100.1\">Nurse Practitioner</codedType>\n"
                + "			<demographic>\n"
                + "				<name>\n"
                + "					<commonName>Grant, Glena</commonName>\n"
                + "					<forename>Glenda</forename>\n"
                + "					<surname>Grant</surname>\n"
                + "				</name>\n"
                + "				<contactPoint>\n"
                + "					<codedType code=\"BP\" codingSchema=\"urn:ihe:iti:csd:2013:contactPoint\">555-777-4945</codedType>\n"
                + "				</contactPoint>\n"
                + "				<contactPoint>\n"
                + "					<codedType code=\"FAX\" codingSchema=\"urn:ihe:iti:csd:2013:contactPoint\">555-888-4945</codedType>\n"
                + "				</contactPoint>\n"
                + "<address type=\"Mailing\">\n"
                + "					<addressLine component=\"streetAddress\">8909 Sunset Way</addressLine>\n"
                + "					<addressLine component=\"city\">Santa Fe</addressLine>\n"
                + "					<addressLine component=\"stateProvince\">NM</addressLine>\n"
                + "					<addressLine component=\"country\">USA</addressLine>\n"
                + "					<addressLine component=\"postalCode\">87505</addressLine>\n"
                + "				</address>\n"
                + "				<gender>F</gender>\n"
                + "			</demographic>\n"
                + "			<language code=\"en\" codingSchema=\"BCP 47\">English</language>\n"
                + "			<organizations>\n"
                + "				<organization oid=\"1.3.6.1.4.1.21367.200.99.1\"/>\n"
                + "			</organizations>\n"
                + "			<credential>\n"
                + "				<codedType code=\"108-001\" codingSchema=\"1.3.6.1.4.1.21367.100.1\"/>\n"
                + "				<number>A_Degree@Connectathon_domain_name</number>\n"
                + "				<issuingAuthority>Connectathon_Manager</issuingAuthority>\n"
                + "				<credentialIssueDate>2013-12-01</credentialIssueDate>\n"
                + "			</credential>\n"
                + "			<specialty code=\"109-003\" codingSchema=\"1.3.6.1.4.1.21367.100.1\"/>\n"
                + "			<record created=\"2013-12-01T14:00:00+00:00\" updated=\"2013-12-01T14:00:00+00:00\" status=\"Active\" sourceDirectory=\"http://www.ihe.net\"/>\n"
                + "		</provider>\n"
                + "		<provider oid=\"1.3.6.1.4.1.21367.200.99.1119\">\n"
                + "			<codedType code=\"105-003\" codingSchema=\"1.3.6.1.4.1.21367.100.1\">Nurse Practitioner</codedType>\n"
                + "			<demographic>\n"
                + "				<name>\n"
                + "					<commonName>Rogers, Rhonda</commonName>\n"
                + "					<forename>Rhonda</forename>\n"
                + "					<surname>Rogers</surname>\n"
                + "				</name>\n"
                + "				<contactPoint>\n"
                + "					<codedType code=\"BP\" codingSchema=\"urn:ihe:iti:csd:2013:contactPoint\">555-777-4945</codedType>\n"
                + "				</contactPoint>\n"
                + "				<contactPoint>\n"
                + "					<codedType code=\"FAX\" codingSchema=\"urn:ihe:iti:csd:2013:contactPoint\">555-888-4945</codedType>\n"
                + "				</contactPoint>\n"
                + "				<address type=\"Mailing\">\n"
                + "					<addressLine component=\"streetAddress\">2887 Commerce Blvd</addressLine>\n"
                + "					<addressLine component=\"city\">Orlando</addressLine>\n"
                + "					<addressLine component=\"stateProvince\">FL</addressLine>\n"
                + "					<addressLine component=\"country\">USA</addressLine>\n"
                + "					<addressLine component=\"postalCode\">32789</addressLine>\n"
                + "				</address>\n"
                + "				<gender>F</gender>\n"
                + "			</demographic>\n"
                + "			<language code=\"en\" codingSchema=\"BCP 47\">English</language>\n"
                + "			<organizations>\n"
                + "				<organization oid=\"1.3.6.1.4.1.21367.200.99.3\"/>\n"
                + "			</organizations>\n"
                + "			<credential>\n"
                + "				<codedType code=\"108-001\" codingSchema=\"1.3.6.1.4.1.21367.100.1\"/>\n"
                + "				<number>A_Degree@Connectathon_domain_name</number>\n"
                + "				<issuingAuthority>Connectathon_Manager</issuingAuthority>\n"
                + "				<credentialIssueDate>2013-12-01</credentialIssueDate>\n"
                + "			</credential>\n"
                + "			<specialty code=\"109-003\" codingSchema=\"1.3.6.1.4.1.21367.100.1\"/>\n"
                + "			<record created=\"2013-12-01T14:00:00+00:00\" updated=\"2013-12-01T14:00:00+00:00\" status=\"Active\" sourceDirectory=\"http://www.ihe.net\"/>\n"
                + "		</provider>\n"
                + "	</providerDirectory>\n"
                + "</CSD>";
        return s;
    }
}