package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.BusinessUnit;
import fpml.confirmation.BusinessUnit.BusinessUnitBuilder;
import fpml.confirmation.BusinessUnit.BusinessUnitBuilderImpl;
import fpml.confirmation.BusinessUnit.BusinessUnitImpl;
import fpml.confirmation.ContactInformation;
import fpml.confirmation.CountryCode;
import fpml.confirmation.Unit;
import fpml.confirmation.meta.BusinessUnitMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that represents information about a unit within an organization.
 * @version ${project.version}
 */
@RosettaDataType(value="BusinessUnit", builder=BusinessUnit.BusinessUnitBuilderImpl.class, version="${project.version}")
public interface BusinessUnit extends RosettaModelObject {

	BusinessUnitMeta metaData = new BusinessUnitMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A name used to describe the organization unit
	 */
	String getName();
	/**
	 * An identifier used to uniquely identify organization unit
	 */
	Unit getBusinessUnitId();
	/**
	 * Information on how to contact the unit using various means.
	 */
	ContactInformation getContactInfo();
	/**
	 * The ISO 3166 standard code for the country where the individual works.
	 */
	CountryCode getCountry();
	String getId();

	/*********************** Build Methods  ***********************/
	BusinessUnit build();
	
	BusinessUnit.BusinessUnitBuilder toBuilder();
	
	static BusinessUnit.BusinessUnitBuilder builder() {
		return new BusinessUnit.BusinessUnitBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessUnit> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BusinessUnit> getType() {
		return BusinessUnit.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("businessUnitId"), processor, Unit.class, getBusinessUnitId());
		processRosetta(path.newSubPath("contactInfo"), processor, ContactInformation.class, getContactInfo());
		processRosetta(path.newSubPath("country"), processor, CountryCode.class, getCountry());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessUnitBuilder extends BusinessUnit, RosettaModelObjectBuilder {
		Unit.UnitBuilder getOrCreateBusinessUnitId();
		Unit.UnitBuilder getBusinessUnitId();
		ContactInformation.ContactInformationBuilder getOrCreateContactInfo();
		ContactInformation.ContactInformationBuilder getContactInfo();
		CountryCode.CountryCodeBuilder getOrCreateCountry();
		CountryCode.CountryCodeBuilder getCountry();
		BusinessUnit.BusinessUnitBuilder setName(String name);
		BusinessUnit.BusinessUnitBuilder setBusinessUnitId(Unit businessUnitId);
		BusinessUnit.BusinessUnitBuilder setContactInfo(ContactInformation contactInfo);
		BusinessUnit.BusinessUnitBuilder setCountry(CountryCode country);
		BusinessUnit.BusinessUnitBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("businessUnitId"), processor, Unit.UnitBuilder.class, getBusinessUnitId());
			processRosetta(path.newSubPath("contactInfo"), processor, ContactInformation.ContactInformationBuilder.class, getContactInfo());
			processRosetta(path.newSubPath("country"), processor, CountryCode.CountryCodeBuilder.class, getCountry());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		BusinessUnit.BusinessUnitBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessUnit  ***********************/
	class BusinessUnitImpl implements BusinessUnit {
		private final String name;
		private final Unit businessUnitId;
		private final ContactInformation contactInfo;
		private final CountryCode country;
		private final String id;
		
		protected BusinessUnitImpl(BusinessUnit.BusinessUnitBuilder builder) {
			this.name = builder.getName();
			this.businessUnitId = ofNullable(builder.getBusinessUnitId()).map(f->f.build()).orElse(null);
			this.contactInfo = ofNullable(builder.getContactInfo()).map(f->f.build()).orElse(null);
			this.country = ofNullable(builder.getCountry()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("businessUnitId")
		public Unit getBusinessUnitId() {
			return businessUnitId;
		}
		
		@Override
		@RosettaAttribute("contactInfo")
		public ContactInformation getContactInfo() {
			return contactInfo;
		}
		
		@Override
		@RosettaAttribute("country")
		public CountryCode getCountry() {
			return country;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public BusinessUnit build() {
			return this;
		}
		
		@Override
		public BusinessUnit.BusinessUnitBuilder toBuilder() {
			BusinessUnit.BusinessUnitBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessUnit.BusinessUnitBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getBusinessUnitId()).ifPresent(builder::setBusinessUnitId);
			ofNullable(getContactInfo()).ifPresent(builder::setContactInfo);
			ofNullable(getCountry()).ifPresent(builder::setCountry);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessUnit _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(businessUnitId, _that.getBusinessUnitId())) return false;
			if (!Objects.equals(contactInfo, _that.getContactInfo())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (businessUnitId != null ? businessUnitId.hashCode() : 0);
			_result = 31 * _result + (contactInfo != null ? contactInfo.hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessUnit {" +
				"name=" + this.name + ", " +
				"businessUnitId=" + this.businessUnitId + ", " +
				"contactInfo=" + this.contactInfo + ", " +
				"country=" + this.country + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of BusinessUnit  ***********************/
	class BusinessUnitBuilderImpl implements BusinessUnit.BusinessUnitBuilder {
	
		protected String name;
		protected Unit.UnitBuilder businessUnitId;
		protected ContactInformation.ContactInformationBuilder contactInfo;
		protected CountryCode.CountryCodeBuilder country;
		protected String id;
	
		public BusinessUnitBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("businessUnitId")
		public Unit.UnitBuilder getBusinessUnitId() {
			return businessUnitId;
		}
		
		@Override
		public Unit.UnitBuilder getOrCreateBusinessUnitId() {
			Unit.UnitBuilder result;
			if (businessUnitId!=null) {
				result = businessUnitId;
			}
			else {
				result = businessUnitId = Unit.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("contactInfo")
		public ContactInformation.ContactInformationBuilder getContactInfo() {
			return contactInfo;
		}
		
		@Override
		public ContactInformation.ContactInformationBuilder getOrCreateContactInfo() {
			ContactInformation.ContactInformationBuilder result;
			if (contactInfo!=null) {
				result = contactInfo;
			}
			else {
				result = contactInfo = ContactInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("country")
		public CountryCode.CountryCodeBuilder getCountry() {
			return country;
		}
		
		@Override
		public CountryCode.CountryCodeBuilder getOrCreateCountry() {
			CountryCode.CountryCodeBuilder result;
			if (country!=null) {
				result = country;
			}
			else {
				result = country = CountryCode.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		public BusinessUnit.BusinessUnitBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		@Override
		@RosettaAttribute("businessUnitId")
		public BusinessUnit.BusinessUnitBuilder setBusinessUnitId(Unit businessUnitId) {
			this.businessUnitId = businessUnitId==null?null:businessUnitId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("contactInfo")
		public BusinessUnit.BusinessUnitBuilder setContactInfo(ContactInformation contactInfo) {
			this.contactInfo = contactInfo==null?null:contactInfo.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("country")
		public BusinessUnit.BusinessUnitBuilder setCountry(CountryCode country) {
			this.country = country==null?null:country.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public BusinessUnit.BusinessUnitBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public BusinessUnit build() {
			return new BusinessUnit.BusinessUnitImpl(this);
		}
		
		@Override
		public BusinessUnit.BusinessUnitBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessUnit.BusinessUnitBuilder prune() {
			if (businessUnitId!=null && !businessUnitId.prune().hasData()) businessUnitId = null;
			if (contactInfo!=null && !contactInfo.prune().hasData()) contactInfo = null;
			if (country!=null && !country.prune().hasData()) country = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null) return true;
			if (getBusinessUnitId()!=null && getBusinessUnitId().hasData()) return true;
			if (getContactInfo()!=null && getContactInfo().hasData()) return true;
			if (getCountry()!=null && getCountry().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessUnit.BusinessUnitBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BusinessUnit.BusinessUnitBuilder o = (BusinessUnit.BusinessUnitBuilder) other;
			
			merger.mergeRosetta(getBusinessUnitId(), o.getBusinessUnitId(), this::setBusinessUnitId);
			merger.mergeRosetta(getContactInfo(), o.getContactInfo(), this::setContactInfo);
			merger.mergeRosetta(getCountry(), o.getCountry(), this::setCountry);
			
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessUnit _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(businessUnitId, _that.getBusinessUnitId())) return false;
			if (!Objects.equals(contactInfo, _that.getContactInfo())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (businessUnitId != null ? businessUnitId.hashCode() : 0);
			_result = 31 * _result + (contactInfo != null ? contactInfo.hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessUnitBuilder {" +
				"name=" + this.name + ", " +
				"businessUnitId=" + this.businessUnitId + ", " +
				"contactInfo=" + this.contactInfo + ", " +
				"country=" + this.country + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
