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
import fpml.confirmation.AbstractLoanAllocationSettlementEvent;
import fpml.confirmation.AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder;
import fpml.confirmation.AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilderImpl;
import fpml.confirmation.AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.FacilityOutstandingsPosition;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanAllocationReference;
import fpml.confirmation.LoanAllocationSettlementEvent;
import fpml.confirmation.LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder;
import fpml.confirmation.LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilderImpl;
import fpml.confirmation.LoanAllocationSettlementEvent.LoanAllocationSettlementEventImpl;
import fpml.confirmation.LoanTradingCounterpartySettlementFundingFactors;
import fpml.confirmation.Money;
import fpml.confirmation.meta.LoanAllocationSettlementEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event structure defining the counterparty-to-counterparty trade settlement details.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanAllocationSettlementEvent", builder=LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilderImpl.class, version="${project.version}")
public interface LoanAllocationSettlementEvent extends AbstractLoanAllocationSettlementEvent {

	LoanAllocationSettlementEventMeta metaData = new LoanAllocationSettlementEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The amount settled.
	 */
	Money getAmount();
	/**
	 * Factors impacting the setttlement cash flows.
	 */
	LoanTradingCounterpartySettlementFundingFactors getFundingFactors();
	/**
	 * One or more accrual periods which reflect the constituent portions of the accrual amount.
	 */
	FacilityOutstandingsPosition getFacilityOutstandingsPosition();

	/*********************** Build Methods  ***********************/
	LoanAllocationSettlementEvent build();
	
	LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder toBuilder();
	
	static LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder builder() {
		return new LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationSettlementEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAllocationSettlementEvent> getType() {
		return LoanAllocationSettlementEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.class, getAllocationReference());
		processor.processBasic(path.newSubPath("settlementDate"), Date.class, getSettlementDate(), this);
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processRosetta(path.newSubPath("fundingFactors"), processor, LoanTradingCounterpartySettlementFundingFactors.class, getFundingFactors());
		processRosetta(path.newSubPath("facilityOutstandingsPosition"), processor, FacilityOutstandingsPosition.class, getFacilityOutstandingsPosition());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationSettlementEventBuilder extends LoanAllocationSettlementEvent, AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder {
		Money.MoneyBuilder getOrCreateAmount();
		Money.MoneyBuilder getAmount();
		LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder getOrCreateFundingFactors();
		LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder getFundingFactors();
		FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder getOrCreateFacilityOutstandingsPosition();
		FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder getFacilityOutstandingsPosition();
		LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder setComment(String comment);
		LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder setAllocationReference(LoanAllocationReference allocationReference);
		LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder setSettlementDate(Date settlementDate);
		LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder setAmount(Money amount);
		LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder setFundingFactors(LoanTradingCounterpartySettlementFundingFactors fundingFactors);
		LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder setFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.LoanAllocationReferenceBuilder.class, getAllocationReference());
			processor.processBasic(path.newSubPath("settlementDate"), Date.class, getSettlementDate(), this);
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("fundingFactors"), processor, LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder.class, getFundingFactors());
			processRosetta(path.newSubPath("facilityOutstandingsPosition"), processor, FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder.class, getFacilityOutstandingsPosition());
		}
		

		LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationSettlementEvent  ***********************/
	class LoanAllocationSettlementEventImpl extends AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventImpl implements LoanAllocationSettlementEvent {
		private final Money amount;
		private final LoanTradingCounterpartySettlementFundingFactors fundingFactors;
		private final FacilityOutstandingsPosition facilityOutstandingsPosition;
		
		protected LoanAllocationSettlementEventImpl(LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder builder) {
			super(builder);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.fundingFactors = ofNullable(builder.getFundingFactors()).map(f->f.build()).orElse(null);
			this.facilityOutstandingsPosition = ofNullable(builder.getFacilityOutstandingsPosition()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		public Money getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("fundingFactors")
		public LoanTradingCounterpartySettlementFundingFactors getFundingFactors() {
			return fundingFactors;
		}
		
		@Override
		@RosettaAttribute("facilityOutstandingsPosition")
		public FacilityOutstandingsPosition getFacilityOutstandingsPosition() {
			return facilityOutstandingsPosition;
		}
		
		@Override
		public LoanAllocationSettlementEvent build() {
			return this;
		}
		
		@Override
		public LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder toBuilder() {
			LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getFundingFactors()).ifPresent(builder::setFundingFactors);
			ofNullable(getFacilityOutstandingsPosition()).ifPresent(builder::setFacilityOutstandingsPosition);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationSettlementEvent _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(fundingFactors, _that.getFundingFactors())) return false;
			if (!Objects.equals(facilityOutstandingsPosition, _that.getFacilityOutstandingsPosition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (fundingFactors != null ? fundingFactors.hashCode() : 0);
			_result = 31 * _result + (facilityOutstandingsPosition != null ? facilityOutstandingsPosition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementEvent {" +
				"amount=" + this.amount + ", " +
				"fundingFactors=" + this.fundingFactors + ", " +
				"facilityOutstandingsPosition=" + this.facilityOutstandingsPosition +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationSettlementEvent  ***********************/
	class LoanAllocationSettlementEventBuilderImpl extends AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilderImpl  implements LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder {
	
		protected Money.MoneyBuilder amount;
		protected LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder fundingFactors;
		protected FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder facilityOutstandingsPosition;
	
		public LoanAllocationSettlementEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("amount")
		public Money.MoneyBuilder getAmount() {
			return amount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateAmount() {
			Money.MoneyBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fundingFactors")
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder getFundingFactors() {
			return fundingFactors;
		}
		
		@Override
		public LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder getOrCreateFundingFactors() {
			LoanTradingCounterpartySettlementFundingFactors.LoanTradingCounterpartySettlementFundingFactorsBuilder result;
			if (fundingFactors!=null) {
				result = fundingFactors;
			}
			else {
				result = fundingFactors = LoanTradingCounterpartySettlementFundingFactors.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityOutstandingsPosition")
		public FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder getFacilityOutstandingsPosition() {
			return facilityOutstandingsPosition;
		}
		
		@Override
		public FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder getOrCreateFacilityOutstandingsPosition() {
			FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder result;
			if (facilityOutstandingsPosition!=null) {
				result = facilityOutstandingsPosition;
			}
			else {
				result = facilityOutstandingsPosition = FacilityOutstandingsPosition.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("allocationReference")
		public LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder setAllocationReference(LoanAllocationReference allocationReference) {
			this.allocationReference = allocationReference==null?null:allocationReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementDate")
		public LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder setSettlementDate(Date settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate;
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder setAmount(Money amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fundingFactors")
		public LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder setFundingFactors(LoanTradingCounterpartySettlementFundingFactors fundingFactors) {
			this.fundingFactors = fundingFactors==null?null:fundingFactors.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityOutstandingsPosition")
		public LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder setFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition) {
			this.facilityOutstandingsPosition = facilityOutstandingsPosition==null?null:facilityOutstandingsPosition.toBuilder();
			return this;
		}
		
		@Override
		public LoanAllocationSettlementEvent build() {
			return new LoanAllocationSettlementEvent.LoanAllocationSettlementEventImpl(this);
		}
		
		@Override
		public LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder prune() {
			super.prune();
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (fundingFactors!=null && !fundingFactors.prune().hasData()) fundingFactors = null;
			if (facilityOutstandingsPosition!=null && !facilityOutstandingsPosition.prune().hasData()) facilityOutstandingsPosition = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getFundingFactors()!=null && getFundingFactors().hasData()) return true;
			if (getFacilityOutstandingsPosition()!=null && getFacilityOutstandingsPosition().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder o = (LoanAllocationSettlementEvent.LoanAllocationSettlementEventBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getFundingFactors(), o.getFundingFactors(), this::setFundingFactors);
			merger.mergeRosetta(getFacilityOutstandingsPosition(), o.getFacilityOutstandingsPosition(), this::setFacilityOutstandingsPosition);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationSettlementEvent _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(fundingFactors, _that.getFundingFactors())) return false;
			if (!Objects.equals(facilityOutstandingsPosition, _that.getFacilityOutstandingsPosition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (fundingFactors != null ? fundingFactors.hashCode() : 0);
			_result = 31 * _result + (facilityOutstandingsPosition != null ? facilityOutstandingsPosition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementEventBuilder {" +
				"amount=" + this.amount + ", " +
				"fundingFactors=" + this.fundingFactors + ", " +
				"facilityOutstandingsPosition=" + this.facilityOutstandingsPosition +
			'}' + " " + super.toString();
		}
	}
}
