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
import fpml.confirmation.FacilityReference;
import fpml.confirmation.FacilityTermination;
import fpml.confirmation.FacilityTermination.FacilityTerminationBuilder;
import fpml.confirmation.FacilityTermination.FacilityTerminationBuilderImpl;
import fpml.confirmation.FacilityTermination.FacilityTerminationImpl;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.meta.FacilityTerminationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * An event describing the early termination of a facility.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityTermination", builder=FacilityTermination.FacilityTerminationBuilderImpl.class, version="${project.version}")
public interface FacilityTermination extends AbstractFacilityEvent {

	FacilityTerminationMeta metaData = new FacilityTerminationMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FacilityTermination build();
	
	FacilityTermination.FacilityTerminationBuilder toBuilder();
	
	static FacilityTermination.FacilityTerminationBuilder builder() {
		return new FacilityTermination.FacilityTerminationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityTermination> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityTermination> getType() {
		return FacilityTermination.class;
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
	interface FacilityTerminationBuilder extends FacilityTermination, AbstractFacilityEvent.AbstractFacilityEventBuilder {
		FacilityTermination.FacilityTerminationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		FacilityTermination.FacilityTerminationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		FacilityTermination.FacilityTerminationBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		FacilityTermination.FacilityTerminationBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		FacilityTermination.FacilityTerminationBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		FacilityTermination.FacilityTerminationBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		FacilityTermination.FacilityTerminationBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		FacilityTermination.FacilityTerminationBuilder setComment(String comment);
		FacilityTermination.FacilityTerminationBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		FacilityTermination.FacilityTerminationBuilder setEffectiveDate(Date effectiveDate);
		FacilityTermination.FacilityTerminationBuilder setFacilityReference(FacilityReference facilityReference);

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
		

		FacilityTermination.FacilityTerminationBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityTermination  ***********************/
	class FacilityTerminationImpl extends AbstractFacilityEvent.AbstractFacilityEventImpl implements FacilityTermination {
		
		protected FacilityTerminationImpl(FacilityTermination.FacilityTerminationBuilder builder) {
			super(builder);
		}
		
		@Override
		public FacilityTermination build() {
			return this;
		}
		
		@Override
		public FacilityTermination.FacilityTerminationBuilder toBuilder() {
			FacilityTermination.FacilityTerminationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityTermination.FacilityTerminationBuilder builder) {
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
			return "FacilityTermination {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FacilityTermination  ***********************/
	class FacilityTerminationBuilderImpl extends AbstractFacilityEvent.AbstractFacilityEventBuilderImpl  implements FacilityTermination.FacilityTerminationBuilder {
	
	
		public FacilityTerminationBuilderImpl() {
		}
	
		@Override
		public FacilityTermination.FacilityTerminationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public FacilityTermination.FacilityTerminationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public FacilityTermination.FacilityTerminationBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public FacilityTermination.FacilityTerminationBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public FacilityTermination.FacilityTerminationBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public FacilityTermination.FacilityTerminationBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public FacilityTermination.FacilityTerminationBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public FacilityTermination.FacilityTerminationBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public FacilityTermination.FacilityTerminationBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public FacilityTermination.FacilityTerminationBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public FacilityTermination.FacilityTerminationBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		
		@Override
		public FacilityTermination build() {
			return new FacilityTermination.FacilityTerminationImpl(this);
		}
		
		@Override
		public FacilityTermination.FacilityTerminationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityTermination.FacilityTerminationBuilder prune() {
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
		public FacilityTermination.FacilityTerminationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FacilityTermination.FacilityTerminationBuilder o = (FacilityTermination.FacilityTerminationBuilder) other;
			
			
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
			return "FacilityTerminationBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
