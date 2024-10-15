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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.AbstractFacilityEvent;
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventBuilder;
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventBuilderImpl;
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventImpl;
import fpml.confirmation.AccruingFeeChangeGroup;
import fpml.confirmation.AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder;
import fpml.confirmation.AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilderImpl;
import fpml.confirmation.AccruingFeeChangeGroup.AccruingFeeChangeGroupImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.meta.AccruingFeeChangeGroupMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Head of the substitution group for all facility events.
 * @version ${project.version}
 */
@RosettaDataType(value="AccruingFeeChangeGroup", builder=AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilderImpl.class, version="${project.version}")
public interface AccruingFeeChangeGroup extends AbstractFacilityEvent {

	AccruingFeeChangeGroupMeta metaData = new AccruingFeeChangeGroupMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	AccruingFeeChangeGroup build();
	
	AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder toBuilder();
	
	static AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder builder() {
		return new AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccruingFeeChangeGroup> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccruingFeeChangeGroup> getType() {
		return AccruingFeeChangeGroup.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.class, getBusinessEventPartiesModel());
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccruingFeeChangeGroupBuilder extends AccruingFeeChangeGroup, AbstractFacilityEvent.AbstractFacilityEventBuilder {
		AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder setComment(String comment);
		AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder setEffectiveDate(Date effectiveDate);
		AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder setFacilityReference(FacilityReference facilityReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.BusinessEventPartiesModelBuilder.class, getBusinessEventPartiesModel());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
		}
		

		AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder prune();
	}

	/*********************** Immutable Implementation of AccruingFeeChangeGroup  ***********************/
	class AccruingFeeChangeGroupImpl extends AbstractFacilityEvent.AbstractFacilityEventImpl implements AccruingFeeChangeGroup {
		
		protected AccruingFeeChangeGroupImpl(AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder builder) {
			super(builder);
		}
		
		@Override
		public AccruingFeeChangeGroup build() {
			return this;
		}
		
		@Override
		public AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder toBuilder() {
			AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeeChangeGroup {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AccruingFeeChangeGroup  ***********************/
	class AccruingFeeChangeGroupBuilderImpl extends AbstractFacilityEvent.AbstractFacilityEventBuilderImpl  implements AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder {
	
	
		public AccruingFeeChangeGroupBuilderImpl() {
		}
	
		@Override
		public AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null)  {
				this.eventIdentifier = new ArrayList<>();
			}
			else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("parentEventIdentifier")
		public AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		
		@Override
		public AccruingFeeChangeGroup build() {
			return new AccruingFeeChangeGroup.AccruingFeeChangeGroupImpl(this);
		}
		
		@Override
		public AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder o = (AccruingFeeChangeGroup.AccruingFeeChangeGroupBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeeChangeGroupBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
