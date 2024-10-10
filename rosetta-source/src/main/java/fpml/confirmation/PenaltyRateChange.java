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
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.FacilityRateChangeEvent;
import fpml.confirmation.FacilityRateChangeEvent.FacilityRateChangeEventBuilder;
import fpml.confirmation.FacilityRateChangeEvent.FacilityRateChangeEventBuilderImpl;
import fpml.confirmation.FacilityRateChangeEvent.FacilityRateChangeEventImpl;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.PenaltyRateChange;
import fpml.confirmation.PenaltyRateChange.PenaltyRateChangeBuilder;
import fpml.confirmation.PenaltyRateChange.PenaltyRateChangeBuilderImpl;
import fpml.confirmation.PenaltyRateChange.PenaltyRateChangeImpl;
import fpml.confirmation.PeriodRate;
import fpml.confirmation.meta.PenaltyRateChangeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * An event representing a change in the penalty rate applicable to outstanding loans.
 * @version ${project.version}
 */
@RosettaDataType(value="PenaltyRateChange", builder=PenaltyRateChange.PenaltyRateChangeBuilderImpl.class, version="${project.version}")
public interface PenaltyRateChange extends FacilityRateChangeEvent {

	PenaltyRateChangeMeta metaData = new PenaltyRateChangeMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	PenaltyRateChange build();
	
	PenaltyRateChange.PenaltyRateChangeBuilder toBuilder();
	
	static PenaltyRateChange.PenaltyRateChangeBuilder builder() {
		return new PenaltyRateChange.PenaltyRateChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PenaltyRateChange> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PenaltyRateChange> getType() {
		return PenaltyRateChange.class;
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
		processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.class, getLoanContractReference());
		processRosetta(path.newSubPath("rate"), processor, PeriodRate.class, getRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PenaltyRateChangeBuilder extends PenaltyRateChange, FacilityRateChangeEvent.FacilityRateChangeEventBuilder {
		PenaltyRateChange.PenaltyRateChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		PenaltyRateChange.PenaltyRateChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		PenaltyRateChange.PenaltyRateChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		PenaltyRateChange.PenaltyRateChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		PenaltyRateChange.PenaltyRateChangeBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		PenaltyRateChange.PenaltyRateChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		PenaltyRateChange.PenaltyRateChangeBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		PenaltyRateChange.PenaltyRateChangeBuilder setComment(String comment);
		PenaltyRateChange.PenaltyRateChangeBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		PenaltyRateChange.PenaltyRateChangeBuilder setEffectiveDate(Date effectiveDate);
		PenaltyRateChange.PenaltyRateChangeBuilder setFacilityReference(FacilityReference facilityReference);
		PenaltyRateChange.PenaltyRateChangeBuilder addLoanContractReference(LoanContractReference loanContractReference0);
		PenaltyRateChange.PenaltyRateChangeBuilder addLoanContractReference(LoanContractReference loanContractReference1, int _idx);
		PenaltyRateChange.PenaltyRateChangeBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference2);
		PenaltyRateChange.PenaltyRateChangeBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference3);
		PenaltyRateChange.PenaltyRateChangeBuilder setRate(PeriodRate rate);

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
			processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.LoanContractReferenceBuilder.class, getLoanContractReference());
			processRosetta(path.newSubPath("rate"), processor, PeriodRate.PeriodRateBuilder.class, getRate());
		}
		

		PenaltyRateChange.PenaltyRateChangeBuilder prune();
	}

	/*********************** Immutable Implementation of PenaltyRateChange  ***********************/
	class PenaltyRateChangeImpl extends FacilityRateChangeEvent.FacilityRateChangeEventImpl implements PenaltyRateChange {
		
		protected PenaltyRateChangeImpl(PenaltyRateChange.PenaltyRateChangeBuilder builder) {
			super(builder);
		}
		
		@Override
		public PenaltyRateChange build() {
			return this;
		}
		
		@Override
		public PenaltyRateChange.PenaltyRateChangeBuilder toBuilder() {
			PenaltyRateChange.PenaltyRateChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PenaltyRateChange.PenaltyRateChangeBuilder builder) {
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
			return "PenaltyRateChange {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PenaltyRateChange  ***********************/
	class PenaltyRateChangeBuilderImpl extends FacilityRateChangeEvent.FacilityRateChangeEventBuilderImpl  implements PenaltyRateChange.PenaltyRateChangeBuilder {
	
	
		public PenaltyRateChangeBuilderImpl() {
		}
	
		@Override
		public PenaltyRateChange.PenaltyRateChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public PenaltyRateChange.PenaltyRateChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public PenaltyRateChange.PenaltyRateChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public PenaltyRateChange.PenaltyRateChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public PenaltyRateChange.PenaltyRateChangeBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public PenaltyRateChange.PenaltyRateChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public PenaltyRateChange.PenaltyRateChangeBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public PenaltyRateChange.PenaltyRateChangeBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public PenaltyRateChange.PenaltyRateChangeBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public PenaltyRateChange.PenaltyRateChangeBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public PenaltyRateChange.PenaltyRateChangeBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		public PenaltyRateChange.PenaltyRateChangeBuilder addLoanContractReference(LoanContractReference loanContractReference) {
			if (loanContractReference!=null) this.loanContractReference.add(loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public PenaltyRateChange.PenaltyRateChangeBuilder addLoanContractReference(LoanContractReference loanContractReference, int _idx) {
			getIndex(this.loanContractReference, _idx, () -> loanContractReference.toBuilder());
			return this;
		}
		@Override 
		public PenaltyRateChange.PenaltyRateChangeBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences != null) {
				for (LoanContractReference toAdd : loanContractReferences) {
					this.loanContractReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("loanContractReference")
		public PenaltyRateChange.PenaltyRateChangeBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences == null)  {
				this.loanContractReference = new ArrayList<>();
			}
			else {
				this.loanContractReference = loanContractReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("rate")
		public PenaltyRateChange.PenaltyRateChangeBuilder setRate(PeriodRate rate) {
			this.rate = rate==null?null:rate.toBuilder();
			return this;
		}
		
		@Override
		public PenaltyRateChange build() {
			return new PenaltyRateChange.PenaltyRateChangeImpl(this);
		}
		
		@Override
		public PenaltyRateChange.PenaltyRateChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PenaltyRateChange.PenaltyRateChangeBuilder prune() {
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
		public PenaltyRateChange.PenaltyRateChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PenaltyRateChange.PenaltyRateChangeBuilder o = (PenaltyRateChange.PenaltyRateChangeBuilder) other;
			
			
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
			return "PenaltyRateChangeBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
