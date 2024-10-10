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
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.FacilityEventGroup;
import fpml.confirmation.FacilityEventGroup.FacilityEventGroupBuilder;
import fpml.confirmation.FacilityEventGroup.FacilityEventGroupBuilderImpl;
import fpml.confirmation.FacilityEventGroup.FacilityEventGroupImpl;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.meta.FacilityEventGroupMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Head of the substitution group for all facility events.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityEventGroup", builder=FacilityEventGroup.FacilityEventGroupBuilderImpl.class, version="${project.version}")
public interface FacilityEventGroup extends AbstractFacilityEvent {

	FacilityEventGroupMeta metaData = new FacilityEventGroupMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FacilityEventGroup build();
	
	FacilityEventGroup.FacilityEventGroupBuilder toBuilder();
	
	static FacilityEventGroup.FacilityEventGroupBuilder builder() {
		return new FacilityEventGroup.FacilityEventGroupBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityEventGroup> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityEventGroup> getType() {
		return FacilityEventGroup.class;
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
	interface FacilityEventGroupBuilder extends FacilityEventGroup, AbstractFacilityEvent.AbstractFacilityEventBuilder {
		FacilityEventGroup.FacilityEventGroupBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		FacilityEventGroup.FacilityEventGroupBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		FacilityEventGroup.FacilityEventGroupBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		FacilityEventGroup.FacilityEventGroupBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		FacilityEventGroup.FacilityEventGroupBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		FacilityEventGroup.FacilityEventGroupBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		FacilityEventGroup.FacilityEventGroupBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		FacilityEventGroup.FacilityEventGroupBuilder setComment(String comment);
		FacilityEventGroup.FacilityEventGroupBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		FacilityEventGroup.FacilityEventGroupBuilder setEffectiveDate(Date effectiveDate);
		FacilityEventGroup.FacilityEventGroupBuilder setFacilityReference(FacilityReference facilityReference);

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
		

		FacilityEventGroup.FacilityEventGroupBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityEventGroup  ***********************/
	class FacilityEventGroupImpl extends AbstractFacilityEvent.AbstractFacilityEventImpl implements FacilityEventGroup {
		
		protected FacilityEventGroupImpl(FacilityEventGroup.FacilityEventGroupBuilder builder) {
			super(builder);
		}
		
		@Override
		public FacilityEventGroup build() {
			return this;
		}
		
		@Override
		public FacilityEventGroup.FacilityEventGroupBuilder toBuilder() {
			FacilityEventGroup.FacilityEventGroupBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityEventGroup.FacilityEventGroupBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
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
			return "FacilityEventGroup {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FacilityEventGroup  ***********************/
	class FacilityEventGroupBuilderImpl extends AbstractFacilityEvent.AbstractFacilityEventBuilderImpl  implements FacilityEventGroup.FacilityEventGroupBuilder {
	
	
		public FacilityEventGroupBuilderImpl() {
		}
	
		@Override
		public FacilityEventGroup.FacilityEventGroupBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public FacilityEventGroup.FacilityEventGroupBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public FacilityEventGroup.FacilityEventGroupBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public FacilityEventGroup.FacilityEventGroupBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public FacilityEventGroup.FacilityEventGroupBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public FacilityEventGroup.FacilityEventGroupBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public FacilityEventGroup.FacilityEventGroupBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public FacilityEventGroup.FacilityEventGroupBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public FacilityEventGroup.FacilityEventGroupBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public FacilityEventGroup.FacilityEventGroupBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public FacilityEventGroup.FacilityEventGroupBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		
		@Override
		public FacilityEventGroup build() {
			return new FacilityEventGroup.FacilityEventGroupImpl(this);
		}
		
		@Override
		public FacilityEventGroup.FacilityEventGroupBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityEventGroup.FacilityEventGroupBuilder prune() {
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
		public FacilityEventGroup.FacilityEventGroupBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FacilityEventGroup.FacilityEventGroupBuilder o = (FacilityEventGroup.FacilityEventGroupBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
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
			return "FacilityEventGroupBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
