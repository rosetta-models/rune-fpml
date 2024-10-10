package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import fpml.confirmation.BusinessUnitReference;
import fpml.confirmation.ContactInformation;
import fpml.confirmation.CountryCode;
import fpml.confirmation.Person;
import fpml.confirmation.Person.PersonBuilder;
import fpml.confirmation.Person.PersonBuilderImpl;
import fpml.confirmation.Person.PersonImpl;
import fpml.confirmation.PersonId;
import fpml.confirmation.PersonSequence;
import fpml.confirmation.meta.PersonMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type that represents information about a person connected with a trade or business process.
 * @version ${project.version}
 */
@RosettaDataType(value="Person", builder=Person.PersonBuilderImpl.class, version="${project.version}")
public interface Person extends RosettaModelObject {

	PersonMeta metaData = new PersonMeta();

	/*********************** Getter Methods  ***********************/
	PersonSequence getPersonSequence();
	/**
	 * An identifier assigned by a system for uniquely identifying the individual
	 */
	List<? extends PersonId> getPersonId();
	/**
	 * The unit for which the indvidual works.
	 */
	BusinessUnitReference getBusinessUnitReference();
	/**
	 * Information on how to contact the individual using various means.
	 */
	ContactInformation getContactInfo();
	/**
	 * The birth date of the person, e.g. 1970-01-01
	 */
	Date getDateOfBirth();
	/**
	 * The ISO 3166 standard code for the country where the individual works.
	 */
	CountryCode getCountry();
	String getId();

	/*********************** Build Methods  ***********************/
	Person build();
	
	Person.PersonBuilder toBuilder();
	
	static Person.PersonBuilder builder() {
		return new Person.PersonBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Person> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Person> getType() {
		return Person.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("personSequence"), processor, PersonSequence.class, getPersonSequence());
		processRosetta(path.newSubPath("personId"), processor, PersonId.class, getPersonId());
		processRosetta(path.newSubPath("businessUnitReference"), processor, BusinessUnitReference.class, getBusinessUnitReference());
		processRosetta(path.newSubPath("contactInfo"), processor, ContactInformation.class, getContactInfo());
		processor.processBasic(path.newSubPath("dateOfBirth"), Date.class, getDateOfBirth(), this);
		processRosetta(path.newSubPath("country"), processor, CountryCode.class, getCountry());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PersonBuilder extends Person, RosettaModelObjectBuilder {
		PersonSequence.PersonSequenceBuilder getOrCreatePersonSequence();
		PersonSequence.PersonSequenceBuilder getPersonSequence();
		PersonId.PersonIdBuilder getOrCreatePersonId(int _index);
		List<? extends PersonId.PersonIdBuilder> getPersonId();
		BusinessUnitReference.BusinessUnitReferenceBuilder getOrCreateBusinessUnitReference();
		BusinessUnitReference.BusinessUnitReferenceBuilder getBusinessUnitReference();
		ContactInformation.ContactInformationBuilder getOrCreateContactInfo();
		ContactInformation.ContactInformationBuilder getContactInfo();
		CountryCode.CountryCodeBuilder getOrCreateCountry();
		CountryCode.CountryCodeBuilder getCountry();
		Person.PersonBuilder setPersonSequence(PersonSequence personSequence);
		Person.PersonBuilder addPersonId(PersonId personId0);
		Person.PersonBuilder addPersonId(PersonId personId1, int _idx);
		Person.PersonBuilder addPersonId(List<? extends PersonId> personId2);
		Person.PersonBuilder setPersonId(List<? extends PersonId> personId3);
		Person.PersonBuilder setBusinessUnitReference(BusinessUnitReference businessUnitReference);
		Person.PersonBuilder setContactInfo(ContactInformation contactInfo);
		Person.PersonBuilder setDateOfBirth(Date dateOfBirth);
		Person.PersonBuilder setCountry(CountryCode country);
		Person.PersonBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("personSequence"), processor, PersonSequence.PersonSequenceBuilder.class, getPersonSequence());
			processRosetta(path.newSubPath("personId"), processor, PersonId.PersonIdBuilder.class, getPersonId());
			processRosetta(path.newSubPath("businessUnitReference"), processor, BusinessUnitReference.BusinessUnitReferenceBuilder.class, getBusinessUnitReference());
			processRosetta(path.newSubPath("contactInfo"), processor, ContactInformation.ContactInformationBuilder.class, getContactInfo());
			processor.processBasic(path.newSubPath("dateOfBirth"), Date.class, getDateOfBirth(), this);
			processRosetta(path.newSubPath("country"), processor, CountryCode.CountryCodeBuilder.class, getCountry());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		Person.PersonBuilder prune();
	}

	/*********************** Immutable Implementation of Person  ***********************/
	class PersonImpl implements Person {
		private final PersonSequence personSequence;
		private final List<? extends PersonId> personId;
		private final BusinessUnitReference businessUnitReference;
		private final ContactInformation contactInfo;
		private final Date dateOfBirth;
		private final CountryCode country;
		private final String id;
		
		protected PersonImpl(Person.PersonBuilder builder) {
			this.personSequence = ofNullable(builder.getPersonSequence()).map(f->f.build()).orElse(null);
			this.personId = ofNullable(builder.getPersonId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.businessUnitReference = ofNullable(builder.getBusinessUnitReference()).map(f->f.build()).orElse(null);
			this.contactInfo = ofNullable(builder.getContactInfo()).map(f->f.build()).orElse(null);
			this.dateOfBirth = builder.getDateOfBirth();
			this.country = ofNullable(builder.getCountry()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("personSequence")
		public PersonSequence getPersonSequence() {
			return personSequence;
		}
		
		@Override
		@RosettaAttribute("personId")
		public List<? extends PersonId> getPersonId() {
			return personId;
		}
		
		@Override
		@RosettaAttribute("businessUnitReference")
		public BusinessUnitReference getBusinessUnitReference() {
			return businessUnitReference;
		}
		
		@Override
		@RosettaAttribute("contactInfo")
		public ContactInformation getContactInfo() {
			return contactInfo;
		}
		
		@Override
		@RosettaAttribute("dateOfBirth")
		public Date getDateOfBirth() {
			return dateOfBirth;
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
		public Person build() {
			return this;
		}
		
		@Override
		public Person.PersonBuilder toBuilder() {
			Person.PersonBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Person.PersonBuilder builder) {
			ofNullable(getPersonSequence()).ifPresent(builder::setPersonSequence);
			ofNullable(getPersonId()).ifPresent(builder::setPersonId);
			ofNullable(getBusinessUnitReference()).ifPresent(builder::setBusinessUnitReference);
			ofNullable(getContactInfo()).ifPresent(builder::setContactInfo);
			ofNullable(getDateOfBirth()).ifPresent(builder::setDateOfBirth);
			ofNullable(getCountry()).ifPresent(builder::setCountry);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Person _that = getType().cast(o);
		
			if (!Objects.equals(personSequence, _that.getPersonSequence())) return false;
			if (!ListEquals.listEquals(personId, _that.getPersonId())) return false;
			if (!Objects.equals(businessUnitReference, _that.getBusinessUnitReference())) return false;
			if (!Objects.equals(contactInfo, _that.getContactInfo())) return false;
			if (!Objects.equals(dateOfBirth, _that.getDateOfBirth())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (personSequence != null ? personSequence.hashCode() : 0);
			_result = 31 * _result + (personId != null ? personId.hashCode() : 0);
			_result = 31 * _result + (businessUnitReference != null ? businessUnitReference.hashCode() : 0);
			_result = 31 * _result + (contactInfo != null ? contactInfo.hashCode() : 0);
			_result = 31 * _result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Person {" +
				"personSequence=" + this.personSequence + ", " +
				"personId=" + this.personId + ", " +
				"businessUnitReference=" + this.businessUnitReference + ", " +
				"contactInfo=" + this.contactInfo + ", " +
				"dateOfBirth=" + this.dateOfBirth + ", " +
				"country=" + this.country + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of Person  ***********************/
	class PersonBuilderImpl implements Person.PersonBuilder {
	
		protected PersonSequence.PersonSequenceBuilder personSequence;
		protected List<PersonId.PersonIdBuilder> personId = new ArrayList<>();
		protected BusinessUnitReference.BusinessUnitReferenceBuilder businessUnitReference;
		protected ContactInformation.ContactInformationBuilder contactInfo;
		protected Date dateOfBirth;
		protected CountryCode.CountryCodeBuilder country;
		protected String id;
	
		public PersonBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("personSequence")
		public PersonSequence.PersonSequenceBuilder getPersonSequence() {
			return personSequence;
		}
		
		@Override
		public PersonSequence.PersonSequenceBuilder getOrCreatePersonSequence() {
			PersonSequence.PersonSequenceBuilder result;
			if (personSequence!=null) {
				result = personSequence;
			}
			else {
				result = personSequence = PersonSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("personId")
		public List<? extends PersonId.PersonIdBuilder> getPersonId() {
			return personId;
		}
		
		public PersonId.PersonIdBuilder getOrCreatePersonId(int _index) {
		
			if (personId==null) {
				this.personId = new ArrayList<>();
			}
			PersonId.PersonIdBuilder result;
			return getIndex(personId, _index, () -> {
						PersonId.PersonIdBuilder newPersonId = PersonId.builder();
						return newPersonId;
					});
		}
		
		@Override
		@RosettaAttribute("businessUnitReference")
		public BusinessUnitReference.BusinessUnitReferenceBuilder getBusinessUnitReference() {
			return businessUnitReference;
		}
		
		@Override
		public BusinessUnitReference.BusinessUnitReferenceBuilder getOrCreateBusinessUnitReference() {
			BusinessUnitReference.BusinessUnitReferenceBuilder result;
			if (businessUnitReference!=null) {
				result = businessUnitReference;
			}
			else {
				result = businessUnitReference = BusinessUnitReference.builder();
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
		@RosettaAttribute("dateOfBirth")
		public Date getDateOfBirth() {
			return dateOfBirth;
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
		@RosettaAttribute("personSequence")
		public Person.PersonBuilder setPersonSequence(PersonSequence personSequence) {
			this.personSequence = personSequence==null?null:personSequence.toBuilder();
			return this;
		}
		@Override
		public Person.PersonBuilder addPersonId(PersonId personId) {
			if (personId!=null) this.personId.add(personId.toBuilder());
			return this;
		}
		
		@Override
		public Person.PersonBuilder addPersonId(PersonId personId, int _idx) {
			getIndex(this.personId, _idx, () -> personId.toBuilder());
			return this;
		}
		@Override 
		public Person.PersonBuilder addPersonId(List<? extends PersonId> personIds) {
			if (personIds != null) {
				for (PersonId toAdd : personIds) {
					this.personId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("personId")
		public Person.PersonBuilder setPersonId(List<? extends PersonId> personIds) {
			if (personIds == null)  {
				this.personId = new ArrayList<>();
			}
			else {
				this.personId = personIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("businessUnitReference")
		public Person.PersonBuilder setBusinessUnitReference(BusinessUnitReference businessUnitReference) {
			this.businessUnitReference = businessUnitReference==null?null:businessUnitReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("contactInfo")
		public Person.PersonBuilder setContactInfo(ContactInformation contactInfo) {
			this.contactInfo = contactInfo==null?null:contactInfo.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dateOfBirth")
		public Person.PersonBuilder setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth==null?null:dateOfBirth;
			return this;
		}
		@Override
		@RosettaAttribute("country")
		public Person.PersonBuilder setCountry(CountryCode country) {
			this.country = country==null?null:country.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public Person.PersonBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public Person build() {
			return new Person.PersonImpl(this);
		}
		
		@Override
		public Person.PersonBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Person.PersonBuilder prune() {
			if (personSequence!=null && !personSequence.prune().hasData()) personSequence = null;
			personId = personId.stream().filter(b->b!=null).<PersonId.PersonIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (businessUnitReference!=null && !businessUnitReference.prune().hasData()) businessUnitReference = null;
			if (contactInfo!=null && !contactInfo.prune().hasData()) contactInfo = null;
			if (country!=null && !country.prune().hasData()) country = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPersonSequence()!=null && getPersonSequence().hasData()) return true;
			if (getPersonId()!=null && getPersonId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBusinessUnitReference()!=null && getBusinessUnitReference().hasData()) return true;
			if (getContactInfo()!=null && getContactInfo().hasData()) return true;
			if (getDateOfBirth()!=null) return true;
			if (getCountry()!=null && getCountry().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Person.PersonBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Person.PersonBuilder o = (Person.PersonBuilder) other;
			
			merger.mergeRosetta(getPersonSequence(), o.getPersonSequence(), this::setPersonSequence);
			merger.mergeRosetta(getPersonId(), o.getPersonId(), this::getOrCreatePersonId);
			merger.mergeRosetta(getBusinessUnitReference(), o.getBusinessUnitReference(), this::setBusinessUnitReference);
			merger.mergeRosetta(getContactInfo(), o.getContactInfo(), this::setContactInfo);
			merger.mergeRosetta(getCountry(), o.getCountry(), this::setCountry);
			
			merger.mergeBasic(getDateOfBirth(), o.getDateOfBirth(), this::setDateOfBirth);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Person _that = getType().cast(o);
		
			if (!Objects.equals(personSequence, _that.getPersonSequence())) return false;
			if (!ListEquals.listEquals(personId, _that.getPersonId())) return false;
			if (!Objects.equals(businessUnitReference, _that.getBusinessUnitReference())) return false;
			if (!Objects.equals(contactInfo, _that.getContactInfo())) return false;
			if (!Objects.equals(dateOfBirth, _that.getDateOfBirth())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (personSequence != null ? personSequence.hashCode() : 0);
			_result = 31 * _result + (personId != null ? personId.hashCode() : 0);
			_result = 31 * _result + (businessUnitReference != null ? businessUnitReference.hashCode() : 0);
			_result = 31 * _result + (contactInfo != null ? contactInfo.hashCode() : 0);
			_result = 31 * _result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PersonBuilder {" +
				"personSequence=" + this.personSequence + ", " +
				"personId=" + this.personId + ", " +
				"businessUnitReference=" + this.businessUnitReference + ", " +
				"contactInfo=" + this.contactInfo + ", " +
				"dateOfBirth=" + this.dateOfBirth + ", " +
				"country=" + this.country + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
