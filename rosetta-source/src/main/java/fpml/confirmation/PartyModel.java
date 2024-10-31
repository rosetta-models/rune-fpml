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
import com.rosetta.util.ListEquals;
import fpml.confirmation.BusinessUnit;
import fpml.confirmation.ContactInformation;
import fpml.confirmation.PartyId;
import fpml.confirmation.PartyInformationModel;
import fpml.confirmation.PartyModel;
import fpml.confirmation.PartyModel.PartyModelBuilder;
import fpml.confirmation.PartyModel.PartyModelBuilderImpl;
import fpml.confirmation.PartyModel.PartyModelImpl;
import fpml.confirmation.PartyName;
import fpml.confirmation.Person;
import fpml.confirmation.meta.PartyModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A model group with the content model of a party.
 * @version ${project.version}
 */
@RosettaDataType(value="PartyModel", builder=PartyModel.PartyModelBuilderImpl.class, version="${project.version}")
public interface PartyModel extends RosettaModelObject {

	PartyModelMeta metaData = new PartyModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A party identifier, e.g. a S.W.I.F.T. bank identifier code (BIC).
	 */
	List<? extends PartyId> getPartyId();
	/**
	 * The legal name of the organization. A free format string. FpML does not define usage rules for this element.
	 */
	PartyName getPartyName();
	PartyInformationModel getPartyInformationModel();
	/**
	 * Information on how to contact the party using various means.
	 */
	ContactInformation getContactInfo();
	/**
	 * Optional organization unit information used to describe the organization units (e.g. trading desks) involved in a transaction or business process .
	 */
	List<? extends BusinessUnit> getBusinessUnit();
	/**
	 * Optional information about people involved in a transaction or busines process. (These are eomployees of the party).
	 */
	List<? extends Person> getPerson();

	/*********************** Build Methods  ***********************/
	PartyModel build();
	
	PartyModel.PartyModelBuilder toBuilder();
	
	static PartyModel.PartyModelBuilder builder() {
		return new PartyModel.PartyModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyModel> getType() {
		return PartyModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyId"), processor, PartyId.class, getPartyId());
		processRosetta(path.newSubPath("partyName"), processor, PartyName.class, getPartyName());
		processRosetta(path.newSubPath("partyInformationModel"), processor, PartyInformationModel.class, getPartyInformationModel());
		processRosetta(path.newSubPath("contactInfo"), processor, ContactInformation.class, getContactInfo());
		processRosetta(path.newSubPath("businessUnit"), processor, BusinessUnit.class, getBusinessUnit());
		processRosetta(path.newSubPath("person"), processor, Person.class, getPerson());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyModelBuilder extends PartyModel, RosettaModelObjectBuilder {
		PartyId.PartyIdBuilder getOrCreatePartyId(int _index);
		List<? extends PartyId.PartyIdBuilder> getPartyId();
		PartyName.PartyNameBuilder getOrCreatePartyName();
		PartyName.PartyNameBuilder getPartyName();
		PartyInformationModel.PartyInformationModelBuilder getOrCreatePartyInformationModel();
		PartyInformationModel.PartyInformationModelBuilder getPartyInformationModel();
		ContactInformation.ContactInformationBuilder getOrCreateContactInfo();
		ContactInformation.ContactInformationBuilder getContactInfo();
		BusinessUnit.BusinessUnitBuilder getOrCreateBusinessUnit(int _index);
		List<? extends BusinessUnit.BusinessUnitBuilder> getBusinessUnit();
		Person.PersonBuilder getOrCreatePerson(int _index);
		List<? extends Person.PersonBuilder> getPerson();
		PartyModel.PartyModelBuilder addPartyId(PartyId partyId0);
		PartyModel.PartyModelBuilder addPartyId(PartyId partyId1, int _idx);
		PartyModel.PartyModelBuilder addPartyId(List<? extends PartyId> partyId2);
		PartyModel.PartyModelBuilder setPartyId(List<? extends PartyId> partyId3);
		PartyModel.PartyModelBuilder setPartyName(PartyName partyName);
		PartyModel.PartyModelBuilder setPartyInformationModel(PartyInformationModel partyInformationModel);
		PartyModel.PartyModelBuilder setContactInfo(ContactInformation contactInfo);
		PartyModel.PartyModelBuilder addBusinessUnit(BusinessUnit businessUnit0);
		PartyModel.PartyModelBuilder addBusinessUnit(BusinessUnit businessUnit1, int _idx);
		PartyModel.PartyModelBuilder addBusinessUnit(List<? extends BusinessUnit> businessUnit2);
		PartyModel.PartyModelBuilder setBusinessUnit(List<? extends BusinessUnit> businessUnit3);
		PartyModel.PartyModelBuilder addPerson(Person person0);
		PartyModel.PartyModelBuilder addPerson(Person person1, int _idx);
		PartyModel.PartyModelBuilder addPerson(List<? extends Person> person2);
		PartyModel.PartyModelBuilder setPerson(List<? extends Person> person3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyId"), processor, PartyId.PartyIdBuilder.class, getPartyId());
			processRosetta(path.newSubPath("partyName"), processor, PartyName.PartyNameBuilder.class, getPartyName());
			processRosetta(path.newSubPath("partyInformationModel"), processor, PartyInformationModel.PartyInformationModelBuilder.class, getPartyInformationModel());
			processRosetta(path.newSubPath("contactInfo"), processor, ContactInformation.ContactInformationBuilder.class, getContactInfo());
			processRosetta(path.newSubPath("businessUnit"), processor, BusinessUnit.BusinessUnitBuilder.class, getBusinessUnit());
			processRosetta(path.newSubPath("person"), processor, Person.PersonBuilder.class, getPerson());
		}
		

		PartyModel.PartyModelBuilder prune();
	}

	/*********************** Immutable Implementation of PartyModel  ***********************/
	class PartyModelImpl implements PartyModel {
		private final List<? extends PartyId> partyId;
		private final PartyName partyName;
		private final PartyInformationModel partyInformationModel;
		private final ContactInformation contactInfo;
		private final List<? extends BusinessUnit> businessUnit;
		private final List<? extends Person> person;
		
		protected PartyModelImpl(PartyModel.PartyModelBuilder builder) {
			this.partyId = ofNullable(builder.getPartyId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyName = ofNullable(builder.getPartyName()).map(f->f.build()).orElse(null);
			this.partyInformationModel = ofNullable(builder.getPartyInformationModel()).map(f->f.build()).orElse(null);
			this.contactInfo = ofNullable(builder.getContactInfo()).map(f->f.build()).orElse(null);
			this.businessUnit = ofNullable(builder.getBusinessUnit()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.person = ofNullable(builder.getPerson()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyId")
		public List<? extends PartyId> getPartyId() {
			return partyId;
		}
		
		@Override
		@RosettaAttribute("partyName")
		public PartyName getPartyName() {
			return partyName;
		}
		
		@Override
		@RosettaAttribute("partyInformationModel")
		public PartyInformationModel getPartyInformationModel() {
			return partyInformationModel;
		}
		
		@Override
		@RosettaAttribute("contactInfo")
		public ContactInformation getContactInfo() {
			return contactInfo;
		}
		
		@Override
		@RosettaAttribute("businessUnit")
		public List<? extends BusinessUnit> getBusinessUnit() {
			return businessUnit;
		}
		
		@Override
		@RosettaAttribute("person")
		public List<? extends Person> getPerson() {
			return person;
		}
		
		@Override
		public PartyModel build() {
			return this;
		}
		
		@Override
		public PartyModel.PartyModelBuilder toBuilder() {
			PartyModel.PartyModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyModel.PartyModelBuilder builder) {
			ofNullable(getPartyId()).ifPresent(builder::setPartyId);
			ofNullable(getPartyName()).ifPresent(builder::setPartyName);
			ofNullable(getPartyInformationModel()).ifPresent(builder::setPartyInformationModel);
			ofNullable(getContactInfo()).ifPresent(builder::setContactInfo);
			ofNullable(getBusinessUnit()).ifPresent(builder::setBusinessUnit);
			ofNullable(getPerson()).ifPresent(builder::setPerson);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyId, _that.getPartyId())) return false;
			if (!Objects.equals(partyName, _that.getPartyName())) return false;
			if (!Objects.equals(partyInformationModel, _that.getPartyInformationModel())) return false;
			if (!Objects.equals(contactInfo, _that.getContactInfo())) return false;
			if (!ListEquals.listEquals(businessUnit, _that.getBusinessUnit())) return false;
			if (!ListEquals.listEquals(person, _that.getPerson())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyId != null ? partyId.hashCode() : 0);
			_result = 31 * _result + (partyName != null ? partyName.hashCode() : 0);
			_result = 31 * _result + (partyInformationModel != null ? partyInformationModel.hashCode() : 0);
			_result = 31 * _result + (contactInfo != null ? contactInfo.hashCode() : 0);
			_result = 31 * _result + (businessUnit != null ? businessUnit.hashCode() : 0);
			_result = 31 * _result + (person != null ? person.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyModel {" +
				"partyId=" + this.partyId + ", " +
				"partyName=" + this.partyName + ", " +
				"partyInformationModel=" + this.partyInformationModel + ", " +
				"contactInfo=" + this.contactInfo + ", " +
				"businessUnit=" + this.businessUnit + ", " +
				"person=" + this.person +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyModel  ***********************/
	class PartyModelBuilderImpl implements PartyModel.PartyModelBuilder {
	
		protected List<PartyId.PartyIdBuilder> partyId = new ArrayList<>();
		protected PartyName.PartyNameBuilder partyName;
		protected PartyInformationModel.PartyInformationModelBuilder partyInformationModel;
		protected ContactInformation.ContactInformationBuilder contactInfo;
		protected List<BusinessUnit.BusinessUnitBuilder> businessUnit = new ArrayList<>();
		protected List<Person.PersonBuilder> person = new ArrayList<>();
	
		public PartyModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partyId")
		public List<? extends PartyId.PartyIdBuilder> getPartyId() {
			return partyId;
		}
		
		@Override
		public PartyId.PartyIdBuilder getOrCreatePartyId(int _index) {
		
			if (partyId==null) {
				this.partyId = new ArrayList<>();
			}
			PartyId.PartyIdBuilder result;
			return getIndex(partyId, _index, () -> {
						PartyId.PartyIdBuilder newPartyId = PartyId.builder();
						return newPartyId;
					});
		}
		
		@Override
		@RosettaAttribute("partyName")
		public PartyName.PartyNameBuilder getPartyName() {
			return partyName;
		}
		
		@Override
		public PartyName.PartyNameBuilder getOrCreatePartyName() {
			PartyName.PartyNameBuilder result;
			if (partyName!=null) {
				result = partyName;
			}
			else {
				result = partyName = PartyName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyInformationModel")
		public PartyInformationModel.PartyInformationModelBuilder getPartyInformationModel() {
			return partyInformationModel;
		}
		
		@Override
		public PartyInformationModel.PartyInformationModelBuilder getOrCreatePartyInformationModel() {
			PartyInformationModel.PartyInformationModelBuilder result;
			if (partyInformationModel!=null) {
				result = partyInformationModel;
			}
			else {
				result = partyInformationModel = PartyInformationModel.builder();
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
		@RosettaAttribute("businessUnit")
		public List<? extends BusinessUnit.BusinessUnitBuilder> getBusinessUnit() {
			return businessUnit;
		}
		
		@Override
		public BusinessUnit.BusinessUnitBuilder getOrCreateBusinessUnit(int _index) {
		
			if (businessUnit==null) {
				this.businessUnit = new ArrayList<>();
			}
			BusinessUnit.BusinessUnitBuilder result;
			return getIndex(businessUnit, _index, () -> {
						BusinessUnit.BusinessUnitBuilder newBusinessUnit = BusinessUnit.builder();
						return newBusinessUnit;
					});
		}
		
		@Override
		@RosettaAttribute("person")
		public List<? extends Person.PersonBuilder> getPerson() {
			return person;
		}
		
		@Override
		public Person.PersonBuilder getOrCreatePerson(int _index) {
		
			if (person==null) {
				this.person = new ArrayList<>();
			}
			Person.PersonBuilder result;
			return getIndex(person, _index, () -> {
						Person.PersonBuilder newPerson = Person.builder();
						return newPerson;
					});
		}
		
		@Override
		@RosettaAttribute("partyId")
		public PartyModel.PartyModelBuilder addPartyId(PartyId partyId) {
			if (partyId!=null) this.partyId.add(partyId.toBuilder());
			return this;
		}
		
		@Override
		public PartyModel.PartyModelBuilder addPartyId(PartyId partyId, int _idx) {
			getIndex(this.partyId, _idx, () -> partyId.toBuilder());
			return this;
		}
		@Override 
		public PartyModel.PartyModelBuilder addPartyId(List<? extends PartyId> partyIds) {
			if (partyIds != null) {
				for (PartyId toAdd : partyIds) {
					this.partyId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PartyModel.PartyModelBuilder setPartyId(List<? extends PartyId> partyIds) {
			if (partyIds == null)  {
				this.partyId = new ArrayList<>();
			}
			else {
				this.partyId = partyIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("partyName")
		public PartyModel.PartyModelBuilder setPartyName(PartyName partyName) {
			this.partyName = partyName==null?null:partyName.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partyInformationModel")
		public PartyModel.PartyModelBuilder setPartyInformationModel(PartyInformationModel partyInformationModel) {
			this.partyInformationModel = partyInformationModel==null?null:partyInformationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("contactInfo")
		public PartyModel.PartyModelBuilder setContactInfo(ContactInformation contactInfo) {
			this.contactInfo = contactInfo==null?null:contactInfo.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("businessUnit")
		public PartyModel.PartyModelBuilder addBusinessUnit(BusinessUnit businessUnit) {
			if (businessUnit!=null) this.businessUnit.add(businessUnit.toBuilder());
			return this;
		}
		
		@Override
		public PartyModel.PartyModelBuilder addBusinessUnit(BusinessUnit businessUnit, int _idx) {
			getIndex(this.businessUnit, _idx, () -> businessUnit.toBuilder());
			return this;
		}
		@Override 
		public PartyModel.PartyModelBuilder addBusinessUnit(List<? extends BusinessUnit> businessUnits) {
			if (businessUnits != null) {
				for (BusinessUnit toAdd : businessUnits) {
					this.businessUnit.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PartyModel.PartyModelBuilder setBusinessUnit(List<? extends BusinessUnit> businessUnits) {
			if (businessUnits == null)  {
				this.businessUnit = new ArrayList<>();
			}
			else {
				this.businessUnit = businessUnits.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("person")
		public PartyModel.PartyModelBuilder addPerson(Person person) {
			if (person!=null) this.person.add(person.toBuilder());
			return this;
		}
		
		@Override
		public PartyModel.PartyModelBuilder addPerson(Person person, int _idx) {
			getIndex(this.person, _idx, () -> person.toBuilder());
			return this;
		}
		@Override 
		public PartyModel.PartyModelBuilder addPerson(List<? extends Person> persons) {
			if (persons != null) {
				for (Person toAdd : persons) {
					this.person.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PartyModel.PartyModelBuilder setPerson(List<? extends Person> persons) {
			if (persons == null)  {
				this.person = new ArrayList<>();
			}
			else {
				this.person = persons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public PartyModel build() {
			return new PartyModel.PartyModelImpl(this);
		}
		
		@Override
		public PartyModel.PartyModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyModel.PartyModelBuilder prune() {
			partyId = partyId.stream().filter(b->b!=null).<PartyId.PartyIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (partyName!=null && !partyName.prune().hasData()) partyName = null;
			if (partyInformationModel!=null && !partyInformationModel.prune().hasData()) partyInformationModel = null;
			if (contactInfo!=null && !contactInfo.prune().hasData()) contactInfo = null;
			businessUnit = businessUnit.stream().filter(b->b!=null).<BusinessUnit.BusinessUnitBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			person = person.stream().filter(b->b!=null).<Person.PersonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyId()!=null && getPartyId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyName()!=null && getPartyName().hasData()) return true;
			if (getPartyInformationModel()!=null && getPartyInformationModel().hasData()) return true;
			if (getContactInfo()!=null && getContactInfo().hasData()) return true;
			if (getBusinessUnit()!=null && getBusinessUnit().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPerson()!=null && getPerson().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyModel.PartyModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyModel.PartyModelBuilder o = (PartyModel.PartyModelBuilder) other;
			
			merger.mergeRosetta(getPartyId(), o.getPartyId(), this::getOrCreatePartyId);
			merger.mergeRosetta(getPartyName(), o.getPartyName(), this::setPartyName);
			merger.mergeRosetta(getPartyInformationModel(), o.getPartyInformationModel(), this::setPartyInformationModel);
			merger.mergeRosetta(getContactInfo(), o.getContactInfo(), this::setContactInfo);
			merger.mergeRosetta(getBusinessUnit(), o.getBusinessUnit(), this::getOrCreateBusinessUnit);
			merger.mergeRosetta(getPerson(), o.getPerson(), this::getOrCreatePerson);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyId, _that.getPartyId())) return false;
			if (!Objects.equals(partyName, _that.getPartyName())) return false;
			if (!Objects.equals(partyInformationModel, _that.getPartyInformationModel())) return false;
			if (!Objects.equals(contactInfo, _that.getContactInfo())) return false;
			if (!ListEquals.listEquals(businessUnit, _that.getBusinessUnit())) return false;
			if (!ListEquals.listEquals(person, _that.getPerson())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyId != null ? partyId.hashCode() : 0);
			_result = 31 * _result + (partyName != null ? partyName.hashCode() : 0);
			_result = 31 * _result + (partyInformationModel != null ? partyInformationModel.hashCode() : 0);
			_result = 31 * _result + (contactInfo != null ? contactInfo.hashCode() : 0);
			_result = 31 * _result + (businessUnit != null ? businessUnit.hashCode() : 0);
			_result = 31 * _result + (person != null ? person.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyModelBuilder {" +
				"partyId=" + this.partyId + ", " +
				"partyName=" + this.partyName + ", " +
				"partyInformationModel=" + this.partyInformationModel + ", " +
				"contactInfo=" + this.contactInfo + ", " +
				"businessUnit=" + this.businessUnit + ", " +
				"person=" + this.person +
			'}';
		}
	}
}
