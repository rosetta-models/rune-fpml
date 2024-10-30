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
import fpml.confirmation.AbstractFacilityContractEvent;
import fpml.confirmation.AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder;
import fpml.confirmation.AbstractFacilityContractEvent.AbstractFacilityContractEventBuilderImpl;
import fpml.confirmation.AbstractFacilityContractEvent.AbstractFacilityContractEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.FacilityRateChangeEvent;
import fpml.confirmation.FacilityRateChangeEvent.FacilityRateChangeEventBuilder;
import fpml.confirmation.FacilityRateChangeEvent.FacilityRateChangeEventBuilderImpl;
import fpml.confirmation.FacilityRateChangeEvent.FacilityRateChangeEventImpl;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.PeriodRate;
import fpml.confirmation.meta.FacilityRateChangeEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event describing changes in a facility-level rate.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FacilityRateChangeEvent", builder=FacilityRateChangeEvent.FacilityRateChangeEventBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FacilityRateChangeEvent extends AbstractFacilityContractEvent {

	FacilityRateChangeEventMeta metaData = new FacilityRateChangeEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * This represents a &#39;surcharge&#39; rate that may apply in addition to a regular margin (on outstanding loan contracts).
	 */
	PeriodRate getRate();

	/*********************** Build Methods  ***********************/
	FacilityRateChangeEvent build();
	
	FacilityRateChangeEvent.FacilityRateChangeEventBuilder toBuilder();
	
	static FacilityRateChangeEvent.FacilityRateChangeEventBuilder builder() {
		return new FacilityRateChangeEvent.FacilityRateChangeEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityRateChangeEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityRateChangeEvent> getType() {
		return FacilityRateChangeEvent.class;
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
	interface FacilityRateChangeEventBuilder extends FacilityRateChangeEvent, AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder {
		PeriodRate.PeriodRateBuilder getOrCreateRate();
		PeriodRate.PeriodRateBuilder getRate();
		FacilityRateChangeEvent.FacilityRateChangeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		FacilityRateChangeEvent.FacilityRateChangeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		FacilityRateChangeEvent.FacilityRateChangeEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		FacilityRateChangeEvent.FacilityRateChangeEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		FacilityRateChangeEvent.FacilityRateChangeEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		FacilityRateChangeEvent.FacilityRateChangeEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		FacilityRateChangeEvent.FacilityRateChangeEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		FacilityRateChangeEvent.FacilityRateChangeEventBuilder setComment(String comment);
		FacilityRateChangeEvent.FacilityRateChangeEventBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		FacilityRateChangeEvent.FacilityRateChangeEventBuilder setEffectiveDate(Date effectiveDate);
		FacilityRateChangeEvent.FacilityRateChangeEventBuilder setFacilityReference(FacilityReference facilityReference);
		FacilityRateChangeEvent.FacilityRateChangeEventBuilder addLoanContractReference(LoanContractReference loanContractReference0);
		FacilityRateChangeEvent.FacilityRateChangeEventBuilder addLoanContractReference(LoanContractReference loanContractReference1, int _idx);
		FacilityRateChangeEvent.FacilityRateChangeEventBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference2);
		FacilityRateChangeEvent.FacilityRateChangeEventBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference3);
		FacilityRateChangeEvent.FacilityRateChangeEventBuilder setRate(PeriodRate rate);

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
		

		FacilityRateChangeEvent.FacilityRateChangeEventBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityRateChangeEvent  ***********************/
	class FacilityRateChangeEventImpl extends AbstractFacilityContractEvent.AbstractFacilityContractEventImpl implements FacilityRateChangeEvent {
		private final PeriodRate rate;
		
		protected FacilityRateChangeEventImpl(FacilityRateChangeEvent.FacilityRateChangeEventBuilder builder) {
			super(builder);
			this.rate = ofNullable(builder.getRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rate")
		public PeriodRate getRate() {
			return rate;
		}
		
		@Override
		public FacilityRateChangeEvent build() {
			return this;
		}
		
		@Override
		public FacilityRateChangeEvent.FacilityRateChangeEventBuilder toBuilder() {
			FacilityRateChangeEvent.FacilityRateChangeEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityRateChangeEvent.FacilityRateChangeEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRate()).ifPresent(builder::setRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityRateChangeEvent _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityRateChangeEvent {" +
				"rate=" + this.rate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FacilityRateChangeEvent  ***********************/
	class FacilityRateChangeEventBuilderImpl extends AbstractFacilityContractEvent.AbstractFacilityContractEventBuilderImpl  implements FacilityRateChangeEvent.FacilityRateChangeEventBuilder {
	
		protected PeriodRate.PeriodRateBuilder rate;
	
		public FacilityRateChangeEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("rate")
		public PeriodRate.PeriodRateBuilder getRate() {
			return rate;
		}
		
		@Override
		public PeriodRate.PeriodRateBuilder getOrCreateRate() {
			PeriodRate.PeriodRateBuilder result;
			if (rate!=null) {
				result = rate;
			}
			else {
				result = rate = PeriodRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public FacilityRateChangeEvent.FacilityRateChangeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public FacilityRateChangeEvent.FacilityRateChangeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public FacilityRateChangeEvent.FacilityRateChangeEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FacilityRateChangeEvent.FacilityRateChangeEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public FacilityRateChangeEvent.FacilityRateChangeEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public FacilityRateChangeEvent.FacilityRateChangeEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public FacilityRateChangeEvent.FacilityRateChangeEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public FacilityRateChangeEvent.FacilityRateChangeEventBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public FacilityRateChangeEvent.FacilityRateChangeEventBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public FacilityRateChangeEvent.FacilityRateChangeEventBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public FacilityRateChangeEvent.FacilityRateChangeEventBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanContractReference")
		public FacilityRateChangeEvent.FacilityRateChangeEventBuilder addLoanContractReference(LoanContractReference loanContractReference) {
			if (loanContractReference!=null) this.loanContractReference.add(loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public FacilityRateChangeEvent.FacilityRateChangeEventBuilder addLoanContractReference(LoanContractReference loanContractReference, int _idx) {
			getIndex(this.loanContractReference, _idx, () -> loanContractReference.toBuilder());
			return this;
		}
		@Override 
		public FacilityRateChangeEvent.FacilityRateChangeEventBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences != null) {
				for (LoanContractReference toAdd : loanContractReferences) {
					this.loanContractReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FacilityRateChangeEvent.FacilityRateChangeEventBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
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
		public FacilityRateChangeEvent.FacilityRateChangeEventBuilder setRate(PeriodRate rate) {
			this.rate = rate==null?null:rate.toBuilder();
			return this;
		}
		
		@Override
		public FacilityRateChangeEvent build() {
			return new FacilityRateChangeEvent.FacilityRateChangeEventImpl(this);
		}
		
		@Override
		public FacilityRateChangeEvent.FacilityRateChangeEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityRateChangeEvent.FacilityRateChangeEventBuilder prune() {
			super.prune();
			if (rate!=null && !rate.prune().hasData()) rate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRate()!=null && getRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityRateChangeEvent.FacilityRateChangeEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FacilityRateChangeEvent.FacilityRateChangeEventBuilder o = (FacilityRateChangeEvent.FacilityRateChangeEventBuilder) other;
			
			merger.mergeRosetta(getRate(), o.getRate(), this::setRate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityRateChangeEvent _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityRateChangeEventBuilder {" +
				"rate=" + this.rate +
			'}' + " " + super.toString();
		}
	}
}
