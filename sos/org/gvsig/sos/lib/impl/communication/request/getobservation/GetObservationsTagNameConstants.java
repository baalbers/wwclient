package org.gvsig.sos.lib.impl.communication.request.getobservation;

/**
 * <p> This class contains constant values with all the supported capabilities document tag 
 * and attributes names. It also include the same information for the exception reports returned
 * by the server </p>  
 * 
 * @author Alain Tamayo Fong (alain_tamayo@yahoo.com)
 */
public class GetObservationsTagNameConstants {
	
	public static final String SOS_NAMESPACE = "http://www.opengis.net/sos/1.0";
	public static final String OWS_NAMESPACE = "http://www.opengis.net/ows/1.1";
	public static final String OWS_NAMESPACE_1_0 = "http://www.opengis.net/ows";
	public static final String GML_NAMESPACE = "http://www.opengis.net/gml";
	public static final String OGC_NAMESPACE = "http://www.opengis.net/ogc";
	public static final String XSI_NAMESPACE = "http://www.w3.org/2001/XMLSchema-instance";
	public static final String OM_NAMESPACE = "http://www.opengis.net/om/1.0";
	public static final String SCHEMA_LOCATION_NAMESPACE = "http://www.opengis.net/sos/1.0 http://schemas.opengis.net/sos/1.0.0/sosAll.xsd";
	 // Capabilities Document Sections
	 //public static final String SOS_CAPABILITIES_ROOT1_0_0 = "sos:Capabilities";
	 public static final String SOS_CAPABILITIES_ROOT1_0_0_SHORT = "Capabilities";
	 public static final String SOS_CAPABILITIES = "http://www.opengis.net/sos/1.0:Capabilities";
	 
	 //public final static String SERVICE_IDENTIFICATION = "ows:ServiceIdentification";
	 //public final static String SERVICE_PROVIDER = "ows:ServiceProvider";
	 //public final static String OPERATIONS_METADATA = "ows:OperationsMetadata";
	 //public final static String CONTENTS = "sos:Contents";
	 //public final static String FILTER_CAPABILITIES = "sos:Filter_Capabilities";
	 public final static String SERVICE_IDENTIFICATION = "http://www.opengis.net/ows/1.1:ServiceIdentification";
	 public final static String SERVICE_PROVIDER = "http://www.opengis.net/ows/1.1:ServiceProvider";
	 public final static String OPERATIONS_METADATA = "http://www.opengis.net/ows/1.1:OperationsMetadata";
	 public final static String CONTENTS = "http://www.opengis.net/sos/1.0:Contents";
	 public final static String FILTER_CAPABILITIES = "http://www.opengis.net/sos/1.0:Filter_Capabilities";
	 
	 public final static String VERSION = "version";
		
	 // ServiceIdentification Section
	 /*public static final String SOS_TITLE = "ows:Title";
	 public static final String SOS_ABSTRACT = "ows:Abstract";
	 public final static String SOS_KEYWORDS ="ows:Keywords";
	 public final static String SOS_KEYWORD ="ows:Keyword";
	 public final static String SOS_SERVICE_TYPE ="ows:ServiceType";
	 public final static String SOS_SERVICE_TYPE_VERSION ="ows:ServiceTypeVersion";
	 public final static String SOS_FEES = "ows:Fees";
	 public final static String SOS_ACCESS_CONTRAINTS = "ows:AccessConstraints";
	 public final static String SOS_PROFILE = "ows:profile";*/
	 
	 public static final String SOS_TITLE = "http://www.opengis.net/ows/1.1:Title";
	 public static final String SOS_ABSTRACT = "http://www.opengis.net/ows/1.1:Abstract";
	 public final static String SOS_KEYWORDS ="http://www.opengis.net/ows/1.1:Keywords";
	 public final static String SOS_KEYWORD ="http://www.opengis.net/ows/1.1:Keyword";
	 public final static String SOS_SERVICE_TYPE ="http://www.opengis.net/ows/1.1:ServiceType";
	 public final static String SOS_SERVICE_TYPE_VERSION ="http://www.opengis.net/ows/1.1:ServiceTypeVersion";
	 public final static String SOS_FEES = "http://www.opengis.net/ows/1.1:Fees";
	 public final static String SOS_ACCESS_CONTRAINTS = "http://www.opengis.net/ows/1.1:AccessConstraints";
	 public final static String SOS_PROFILE = "http://www.opengis.net/ows/1.1:profile";
	
	 //ServiceProvider Section 
	 /*public static final String SOS_PROVIDER_NAME = "ows:ProviderName";
	 public static final String SOS_PROVIDER_SITE = "ows:ProviderSite";
	 public static final String SOS_SERVICE_CONTACT = "ows:ServiceContact";
	 
	 public static final String SOS_INDIVIDUAL_NAME ="ows:IndividualName";
	 public static final String SOS_ORGANIZATION_NAME ="ows:OrganizationName";
	 public static final String SOS_POSITION_NAME ="ows:PositionName";
	 public static final String SOS_CONTACT_INFO ="ows:ContactInfo";
	 public static final String SOS_ROLE ="ows:Role";
	 
	 public static final String SOS_PHONE ="ows:Phone";
	 public static final String SOS_ADDRESS ="ows:Address";
	 public static final String SOS_ONLINE_RESOURCE ="ows:OnlineResource";
	 public static final String SOS_HOURS_OF_SERVICE ="ows:HoursOfService";
	 public static final String SOS_CONTACT_INSTRUCTIONS ="ows:ContactInstructions";

	 public static final String SOS_VOICE ="ows:Voice";
	 public static final String SOS_FACSIMILE ="ows:Facsimile";
	 
	 public static final String SOS_DELIVERY_POINT ="ows:DeliveryPoint";
	 public static final String SOS_CITY ="ows:City";
	 public static final String SOS_ADMINISTRATIVE_AREA ="ows:AdministrativeArea";
	 public static final String SOS_POSTAL_CODE ="ows:PostalCode";
	 public static final String SOS_COUNTRY ="ows:Country";
	 public static final String SOS_ELECTRONIC_MAIL_ADDRESS ="ows:ElectronicMailAddress";*/
	 
	 public static final String SOS_PROVIDER_NAME = "http://www.opengis.net/ows/1.1:ProviderName";
	 public static final String SOS_PROVIDER_SITE = "http://www.opengis.net/ows/1.1:ProviderSite";
	 public static final String SOS_SERVICE_CONTACT = "http://www.opengis.net/ows/1.1:ServiceContact";
	 
	 public static final String SOS_INDIVIDUAL_NAME ="http://www.opengis.net/ows/1.1:IndividualName";
	 public static final String SOS_ORGANIZATION_NAME ="http://www.opengis.net/ows/1.1:OrganizationName";
	 public static final String SOS_POSITION_NAME ="http://www.opengis.net/ows/1.1:PositionName";
	 public static final String SOS_CONTACT_INFO ="http://www.opengis.net/ows/1.1:ContactInfo";
	 public static final String SOS_ROLE ="http://www.opengis.net/ows/1.1:Role";
	 
	 public static final String SOS_PHONE ="http://www.opengis.net/ows/1.1:Phone";
	 public static final String SOS_ADDRESS ="http://www.opengis.net/ows/1.1:Address";
	 public static final String SOS_ONLINE_RESOURCE ="http://www.opengis.net/ows/1.1:OnlineResource";
	 public static final String SOS_HOURS_OF_SERVICE ="http://www.opengis.net/ows/1.1:HoursOfService";
	 public static final String SOS_CONTACT_INSTRUCTIONS ="http://www.opengis.net/ows/1.1:ContactInstructions";

	 public static final String SOS_VOICE ="http://www.opengis.net/ows/1.1:Voice";
	 public static final String SOS_FACSIMILE ="http://www.opengis.net/ows/1.1:Facsimile";
	 
	 public static final String SOS_DELIVERY_POINT ="http://www.opengis.net/ows/1.1:DeliveryPoint";
	 public static final String SOS_CITY ="http://www.opengis.net/ows/1.1:City";
	 public static final String SOS_ADMINISTRATIVE_AREA ="http://www.opengis.net/ows/1.1:AdministrativeArea";
	 public static final String SOS_POSTAL_CODE ="http://www.opengis.net/ows/1.1:PostalCode";
	 public static final String SOS_COUNTRY ="http://www.opengis.net/ows/1.1:Country";
	 public static final String SOS_ELECTRONIC_MAIL_ADDRESS ="http://www.opengis.net/ows/1.1:ElectronicMailAddress";
	 
	 // OperationMetadata Section
	/* public final static String OPERATION = "ows:Operation";
	 public final static String DCP = "ows:DCP";
	 public final static String XLINK_HREF ="xlink:href";
	 public final static String HTTP ="ows:HTTP";
	 public final static String GET ="ows:Get";
	 public final static String POST ="ows:Post";
	 public final static String NAME = "name";
	 public final static String PARAMETER = "ows:Parameter";
	 
	 public final static String ALLOWED_VALUES = "ows:AllowedValues";
	 public final static String VALUE = "ows:Value";
	 public final static String RANGE ="ows:Range";
	 public final static String ANY_VALUE ="ows:AnyValue";
	 public final static String NO_VALUES ="ows:NoValues";
	 public final static String MINIMUM_VALUE = "ows:MinimumValue";
	 public final static String MAXIMUM_VALUE ="ows:MaximumValue";
	 public final static String RANGE_CLOSURE ="ows:RangeClosure";
	 public final static String SPACING ="ows:Spacing";*/
	 
	 public final static String OPERATION = "http://www.opengis.net/ows/1.1:Operation";
	 public final static String DCP = "http://www.opengis.net/ows/1.1:DCP";
	 public final static String XLINK_HREF ="xlink:href";
	 public final static String HTTP ="http://www.opengis.net/ows/1.1:HTTP";
	 public final static String GET ="http://www.opengis.net/ows/1.1:Get";
	 public final static String POST ="http://www.opengis.net/ows/1.1:Post";
	 public final static String NAME = "name";
	 public final static String PARAMETER = "http://www.opengis.net/ows/1.1:Parameter";
	 
	 public final static String ALLOWED_VALUES = "http://www.opengis.net/ows/1.1:AllowedValues";
	 public final static String VALUE = "http://www.opengis.net/ows/1.1:Value";
	 public final static String RANGE ="http://www.opengis.net/ows/1.1:Range";
	 public final static String ANY_VALUE ="http://www.opengis.net/ows/1.1:AnyValue";
	 public final static String NO_VALUES ="http://www.opengis.net/ows/1.1:NoValues";
	 public final static String MINIMUM_VALUE = "http://www.opengis.net/ows/1.1:MinimumValue";
	 public final static String MAXIMUM_VALUE ="http://www.opengis.net/ows/1.1:MaximumValue";
	 public final static String RANGE_CLOSURE ="http://www.opengis.net/ows/1.1:RangeClosure";
	 public final static String SPACING ="http://www.opengis.net/ows/1.1:Spacing";
	 
	 public final static String GETCAPABILITIES ="GetCapabilities";
	 public final static String SOS_DESCRIBESENSOR ="DescribeSensor";
	 public final static String SOS_GETOBSERVATION ="GetObservation";
	 public static final String SOS_REGISTERSENSOR = "RegisterSensor"; 
	 public static final String SOS_INSERTOBSERVATION = "InsertObservation";
	 
		// Enhanced Profile Operations (Not supported)
	 public static final String SOS_GETOBSERVATIONID = "GetObservationById";
	 public static final String SOS_GETRESULT = "GetResult";
	 public static final String SOS_GETFEATUREOFINTEREST = "GetFeatureOfInterest";
	 public static final String SOS_GETFEATUREOFINTERESTTIME = "GetFeatureOfInterestTime";
	 public static final String SOS_DESCRIBEFEATURETYPE = "DescribeFeatureType";
	 public static final String SOS_DESCRIBEOBSERVATIONTIME = "DescribeObservationType";
	 public static final String SOS_DESCRIBERESULTMODEL = "DescribeResultModel";
	 
	 public final static String SOS_ONLINERESOURCE ="OnlineResource";

	 // Contents Section
	 /*public static final String SOS_OBSERVATION__LIST = "sos:ObservationList";
	 public static final String SOS_OBSERVATION_ = "sos:Observation";
	 public static final String GML_NAME = "gml:name";
	 public static final String SOS_DESCRIPTION = "gml:description";
	 public static final String SOS_ID = "gml:id";
	 public static final String SOS_INTENDED_APPLICATION = "intendedApplication";///------------------------------------------------->>>>>>>>>>>>
	 public static final String SOS_PROCEDURE = "sos:procedure";
	 public static final String SOS_OBSERVED_PROPERTY = "sos:observedProperty";
	 public static final String SOS_FEATURE_OF_INTEREST = "sos:featureOfInterest";
	 public static final String SOS_RESPONSE_FORMAT = "sos:responseFormat";
	 public static final String SOS_RESULT_MODEL = "sos:resultModel";
	 public static final String SOS_RESPONSE_MODE = "sos:responseMode";
	 public static final String SOS_BOUNDED_BY = "gml:boundedBy";
	 public static final String SOS_ENVELOPE = "gml:Envelope";
	 public static final String SOS_TIME = "sos:time";
	 public static final String SOS_NULL = "gml:Null"; ///------------------------------------------------------------------------->>>>>>>>>>>
	 public static final String ENVELOPE_LOWER_CORNER = "gml:lowerCorner";
	 public static final String ENVELOPE_UPPER_CORNER = "gml:upperCorner"; 
	 public static final String SRS_NAME = "srsName"; ///---------------------------------------------------------------------------->>>>>>>>>
	 public static final String TIME_BEGIN_POSITION = "gml:beginPosition";
	 public static final String TIME_END_POSITION = "gml:endPosition";
	 public static final String TIME_INDETERMINATE_POSITION = "indeterminatePosition";///-------------------------------------------------->>>>>>
	 public static final String TIME_PERIOD = "gml:TimePeriod";
	 public static final String TIME_INSTANT = "gml:TimeInstant";
	 public static final String TIME_INTERVAL = "timeInterval";//---------------------------------------------------------------------------->>>>>
	 public static final String TIME_UNIT = "unit";///------------------------------------------------------------------------------->>>>>>*/
	 
	 public static final String SOS_OBSERVATION__LIST = SOS_NAMESPACE + ":ObservationList";
	 public static final String SOS_OBSERVATION_ = SOS_NAMESPACE + ":Observation";
	 public static final String GML_NAME = GML_NAMESPACE + ":name";
	 public static final String SOS_DESCRIPTION = GML_NAMESPACE + ":description";
	 public static final String SOS_ID = "gml:id";
	 public static final String SOS_INTENDED_APPLICATION = SOS_NAMESPACE + ":intendedApplication";///------------------------------------------------->>>>>>>>>>>>
	 public static final String SOS_PROCEDURE = SOS_NAMESPACE + ":procedure";
	 public static final String SOS_OBSERVED_PROPERTY = SOS_NAMESPACE + ":observedProperty";
	 public static final String SOS_FEATURE_OF_INTEREST = SOS_NAMESPACE + ":featureOfInterest";
	 public static final String SOS_RESPONSE_FORMAT = SOS_NAMESPACE + ":responseFormat";
	 public static final String SOS_RESULT_MODEL = SOS_NAMESPACE + ":resultModel";
	 public static final String SOS_RESPONSE_MODE = SOS_NAMESPACE + ":responseMode";
	 public static final String SOS_BOUNDED_BY = GML_NAMESPACE + ":boundedBy";
	 public static final String SOS_ENVELOPE = GML_NAMESPACE + ":Envelope";
	 public static final String SOS_TIME = SOS_NAMESPACE + ":time";
	 public static final String SOS_TIME_PATCH = SOS_NAMESPACE + ":eventTime";
	 public static final String SOS_NULL = GML_NAMESPACE + ":Null"; ///------------------------------------------------------------------------->>>>>>>>>>>
	 public static final String ENVELOPE_LOWER_CORNER = GML_NAMESPACE + ":lowerCorner";
	 public static final String ENVELOPE_UPPER_CORNER = GML_NAMESPACE + ":upperCorner"; 
	 public static final String SRS_NAME = "srsName"; 
	 public static final String GML_SRS_NAME = GML_NAMESPACE + ":srsName";///---------------------------------------------------------------------------->>>>>>>>>
	 public static final String TIME_BEGIN_POSITION = GML_NAMESPACE + ":beginPosition";
	 public static final String TIME_END_POSITION = GML_NAMESPACE + ":endPosition";
	 public static final String TIME_INDETERMINATE_POSITION = "indeterminatePosition";///-------------------------------------------------->>>>>>
	 public static final String TIME_PERIOD = GML_NAMESPACE + ":TimePeriod";
	 public static final String TIME_INSTANT = GML_NAMESPACE + ":TimeInstant";
	 public static final String TIME_INTERVAL = GML_NAMESPACE + ":timeInterval";//---------------------------------------------------------------------------->>>>>
	 public static final String TIME_UNIT = "unit";///------------------------------------------------------------------------------->>>>>>
	 
	 // Filter capabilities Section
	 public static final String SOS_SPATIAL_CAPABILITIES = OGC_NAMESPACE + ":Spatial_Capabilities";
	 public static final String SOS_TEMPORAL_CAPABILITIES = OGC_NAMESPACE + ":Temporal_Capabilities";
	 public static final String SOS_SCALAR_CAPABILITIES = OGC_NAMESPACE + ":Scalar_Capabilities";
	 public static final String SOS_ID_CAPABILITIES = OGC_NAMESPACE + ":Id_Capabilities";
	 public static final String SOS_GEOMETRY_OPERANDS = OGC_NAMESPACE + ":GeometryOperands";
	 public static final String SOS_SPATIAL_OPERATORS = OGC_NAMESPACE + ":SpatialOperators"; 
	 public static final String SOS_GEOMETRY_OPERAND = OGC_NAMESPACE + ":GeometryOperand";
	 public static final String SOS_SPATIAL_OPERATOR = OGC_NAMESPACE + ":SpatialOperator";
	 public static final String SOS_TEMPORAL_OPERANDS = OGC_NAMESPACE + ":TemporalOperands";
	 public static final String SOS_TEMPORAL_OPERATORS = OGC_NAMESPACE + ":TemporalOperators";
	 public static final String SOS_TEMPORAL_OPERATOR = OGC_NAMESPACE + ":TemporalOperator";
	 public static final String SOS_TEMPORAL_OPERAND = OGC_NAMESPACE + ":TemporalOperand";
	 public static final String SOS_COMPARISON_OPERATORS = OGC_NAMESPACE + ":ComparisonOperators";
	 public static final String SOS_LOGICAL_OPERATORS = OGC_NAMESPACE + ":LogicalOperators";
	 public static final String SOS_ARITHMETIC_OPERATORS = OGC_NAMESPACE + ":ArithmeticOperators"; 
	 public static final String SOS_COMPARISON_OPERATOR = OGC_NAMESPACE + ":ComparisonOperator";
	 public static final String SOS_LOGICAL_OPERATOR = OGC_NAMESPACE + ":LogicalOperator";
	 public static final String SOS_ARITHMETIC_OPERATOR = OGC_NAMESPACE + ":ArithmeticOperator";
	 public static final String SOS_EID = OGC_NAMESPACE + ":EID";
	 public static final String SOS_FID = OGC_NAMESPACE + ":FID"; 
	 
	 // Exceptions management
	 public static final String EXCEPTION_REPORT = OWS_NAMESPACE + ":ExceptionReport"; 
	 public static final String EXCEPTION_REPORT_1_0 = OWS_NAMESPACE_1_0 + ":ExceptionReport"; 
	 public static final String EXCEPTION = OWS_NAMESPACE + ":Exception"; 
	 public static final String EXCEPTION_1_0 = OWS_NAMESPACE_1_0 + ":Exception"; 
	 public static final String EXCEPTION_CODE = "exceptionCode";
	 public static final String EXCEPTION_LOCATOR = "locator";
	 public static final String EXCEPTION_TEXT = OWS_NAMESPACE + ":ExceptionText";
	 public static final String EXCEPTION_TEXT_1_0 = OWS_NAMESPACE_1_0 + ":ExceptionText";
	 
	 public static final String SERVICE_EXCEPTION_REPORT = "null:ServiceExceptionReport"; 
	 public static final String SERVICE_EXCEPTION = "ServiceException";
	 
	 public static final String XML_NAMESPACE = "xmlns";
	 
	 //type of tags
	 
	 public static enum GETOBSERVATION_TYPES {GETOBSERVATION,OFFERING,PROCEDURE
		 ,OBSERVEDPROPERTY,RESPONSEFORMAT,RESULTMODEL,RESPONSEMODE,EVENTTIME
		 ,FEATUREOFINTEREST,SPATIALFILTER,OBJECTID,TEMPORALFILTER,TEMPORALFILTEROPERATOR
		 ,RESULT,COMPARISONFILTEROPERATOR,COMPARISONFILTER,SPATIALFILTEROPERATOR};
	 
	 //nombre de los namespace
	 public static final String XSINAME = "xmlns:xsi";
	 public static final String GMLNAME = "xmlns:gml";
	 public static final String OGCNAME = "xmlns:ogc";
	 public static final String SOSNAME = "xmlns:sos";
	 public static final String OMNAME = "xmlns:om";
	 public static final String SCHEMALOCATIONNAME = "xsi:schemaLocation";
	 public static final String OWSNAME = "xmlns:ows";
	 public static final String SOS = "sos";
	 
	 //Name of tags
	 public static final String SOS_GETOBSERVATION_REQUEST = "sos:GetObservation";
	 public static final String SOS_OFFERING_REQUEST = "sos:offering";
	 public static final String SOS_OBSERVEDPROPERTY_REQUEST = "sos:observedProperty";
	 public static final String SOS_RESPONSEFORMAT_REQUEST = "sos:responseFormat";
	 public static final String SOS_RESULTMODEL_REQUEST = "sos:resultModel";
	 public static final String SOS_RESPONSEMODE_REQUEST = "sos:responseMode";
	 public static final String SOS_PROCEDURE_REQUEST = "sos:procedure";
	 public static final String SOS_EVENTTIME_REQUEST = "sos:eventTime";
	 public static final String SOS_FEATUREOFINTEREST_REQUEST = "sos:featureOfInterest";
	 public static final String SOS_RESULT_REQUEST = "sos:result";

	 //FILTER TEMPORAL
	 
	 public static final String TEMPORAL_FILTER_TIMEINSTANT = "gml:TimeInstant";
	 public static final String TEMPORAL_FILTER_TIMEPERIOD = "gml:TimePeriod";
	 public static final String TEMPORAL_UNIT = "unit";
	 public static final String TEMPORAL_RADIX = "radix";
	 public static final String TEMPORAL_FACTOR = "factor";
	 
	 public static final String TEMPORAL_BEGINPOSITION ="gml:beginPosition";
	 public static final String TEMPORAL_BEGIN = "gml:begin";
	 public static final String TEMPORAL_ENDPOSITION = "gml:endPosition";
	 public static final String TEMPORAL_END = "gml:end";
	 public static final String TEMPORAL_DURATION = "gml:duration";
	 public static final String TEMPORAL_TIMEINTERVAL = "gml:timeInterval";
	 public static final String TEMPORAL_RELATEDTIME = "gml:relatedTime";
	 public static final String TEMPORAL_TIMEPOSITION = "gml:timePosition";
	 public static final String PROPERTY_NAME = "ogc:PropertyName";
	 public static final String OGC_LITERAL = "ogc:Literal";
	 public static final String OGC_TM_AFTER = "ogc:TM_After";
	 public static final String OGC_TM_BEFORE = "ogc:TM_Before";
	 public static final String OGC_TM_BEGINS = "ogc:TM_Begins";
	 public static final String OGC_TM_BEGUNBY = "ogc:TM_BegunBy";
	 public static final String OGC_TM_CONTAINS = "ogc:TM_Contains";
	 public static final String OGC_TM_DURING = "ogc:TM_During";
	 public static final String OGC_TM_ENDEDBY = "ogc:TM_EndedBy";
	 public static final String OGC_TM_ENDS = "ogc:TM_Ends";
	 public static final String OGC_TM_EQUAS = "ogc:TM_Equals";
	 public static final String OGC_TM_MEETS = "ogc:TM_Meets";
	 public static final String OGC_TM_METBY = "ogc:TM_MetBy";
	 public static final String OGC_TM_OVERLAPS = "ogc:TM_Overlaps";
	 public static final String OGC_TM_OVERLAPPEDBY = "ogc:TM_OverlappedBy";
	 
	 //FILTER COMPARISON
	 
	 public static final String COMPARISON_ISEQUALTO = "ogc:PropertyIsEqualTo";
	 public static final String COMPARISON_ISGREATERTHAN= "ogc:PropertyIsGreaterThan";
	 public static final String COMPARISON_ISGREATHEROREQUAL = "ogc:PropertyIsGreaterThanOrEqualTo";
	 public static final String COMPARISON_ISLESSTHAN = "ogc:PropertyIsLessThan";
	 public static final String COMPARISON_ISLESSOREQUAL = "ogc:PropertyIsLessThanOrEqualTo";
	 public static final String COMPARISON_ISNOTEQUALTO = "ogc:PropertyIsNotEqualTo";
	 public static final String COMPARISON_ISBETWEEN = "ogc:PropertyIsBetween";
	 public static final String COMPARISON_ISLIKE = "ogc:PropertyIsLike";
	 public static final String COMPARISON_ISNULL = "ogc:PropertyIsNull";
	 public static final String COMPARISON_LOWERBOUNDARY = "ogc:LowerBoundary";
	 public static final String COMPARISON_UPPERBOUNDARY = "ogc:UpperBoundary";	 
	 public static final String OGC_WILCARD = "wilCard";
	 public static final String OGC_SINGLECHAR = "singleChar";
	 public static final String OGC_ESCAPECHAR = "escapeChar";
	 public static final String XSD_UNITS = "units";
	 
	 //FEATURE OF INTEREST COMPONENTS
	 
	 public static final String SOS_OBJECTID = "sos:ObjectID";


	 //FILTER SPATIAL
	 public static final String SPATIAL_FILTER_BBOX = "ogc:BBOX";
	 public static final String SPATIAL_FILTER_CONTAINS = "ogc:Contains";
	 public static final String SPATIAL_FILTER_CROSSES = "ogc:Crosses";
	 public static final String SPATIAL_FILTER_DISJOINT = "ogc:Disjoint";
	 public static final String SPATIAL_FILTER_EQUALS = "ogc:Equals";
	 public static final String SPATIAL_FILTER_INTERSECTS = "ogc:Intersects";
	 public static final String SPATIAL_FILTER_OVERLAPS = "ogc:Overlaps";
	 public static final String SPATIAL_FILTER_TOUCHES = "ogc:Touches";
	 public static final String SPATIAL_FILTER_WITHIN = "ogc:Within";
	 public static final String SPATIAL_FILTER_BEYOND = "ogc:Beyond";
	 public static final String SPATIAL_FILTER_DWITHIN = "ogc:DWithin";
	 
	 public static final String GML_ENVELOPE ="gml:Envelope";
	 public static final String GML_POLYGON = "gml:Polygon";
	 public static final String GML_POINT = "gml:Point";
	 public static final String GML_POS = "gml:Pos";
	 public static final String GML_COORDINATES = "gml:coordinates";
	 public static final String GML_LINESTRING = "gml:LineString";
	 public static final String GML_LINEARRING = "gml:LinearRing";
	 public static final String GML_OUTER_BOUNDARY_IS = "gml:outerBoundaryIS";
	 public static final String GML_INNER_BOUNDARY_IS = "gml:innerBoundaryIS";
	 public static final String GML_POSLIST = "gml:posList";
	 public static final String GML_UPPERCORNER = "gml:upperCorner";
	 public static final String GML_LOWERCORNER = "gml:lowerCorner";
	 public static final String SPATIAL_BINARYTYPE = "BinarySpatialOpType";
	 public static final String SPATIAL_BUFFERTYPE = "DistanceBufferType";
	 public static final String SPATIAL_DISTANCETYPE = "Distance";
	 public static final String GML_GEOMETRY = "gml:_Geometry";
	 
	 public static final String GML_METADATAPROPERTY = "gml:metaDataProperty";
	 public static final String GML_DESCRIPTION = "gml:description";
	 public static final String GML_NAME_PROPERTY = "gml:name";
	 public static final String GML_ID = "gml:id";
	 public static final String GML_SRS_NAME_PROPERTY = "srsName";
	 
}
