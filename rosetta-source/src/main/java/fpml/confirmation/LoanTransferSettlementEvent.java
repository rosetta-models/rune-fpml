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
import fpml.confirmation.LoanTransferSettlementEvent;
import fpml.confirmation.LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder;
import fpml.confirmation.LoanTransferSettlementEvent.LoanTransferSettlementEventBuilderImpl;
import fpml.confirmation.LoanTransferSettlementEvent.LoanTransferSettlementEventImpl;
import fpml.confirmation.Money;
import fpml.confirmation.meta.LoanTransferSettlementEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event structure defining the agent-to-counterparty trade settlement details.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTransferSettlementEvent", builder=LoanTransferSettlementEvent.LoanTransferSettlementEventBuilderImpl.class, version="${project.version}")
public interface LoanTransferSettlementEvent extends AbstractLoanAllocationSettlementEvent {

	LoanTransferSettlementEventMeta metaData = new LoanTransferSettlementEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The amount settled.
	 */
	Money getAmount();
	/**
	 * One or more accrual periods which reflect the constituent portions of the accrual amount.
	 */
	FacilityOutstandingsPosition getFacilityOutstandingsPosition();

	/*********************** Build Methods  ***********************/
	LoanTransferSettlementEvent build();
	
	LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder toBuilder();
	
	static LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder builder() {
		return new LoanTransferSettlementEvent.LoanTransferSettlementEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTransferSettlementEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTransferSettlementEvent> getType() {
		return LoanTransferSettlementEvent.class;
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
		processRosetta(path.newSubPath("facilityOutstandingsPosition"), processor, FacilityOutstandingsPosition.class, getFacilityOutstandingsPosition());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTransferSettlementEventBuilder extends LoanTransferSettlementEvent, AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilder {
		Money.MoneyBuilder getOrCreateAmount();
		Money.MoneyBuilder getAmount();
		FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder getOrCreateFacilityOutstandingsPosition();
		FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder getFacilityOutstandingsPosition();
		LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder setComment(String comment);
		LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder setAllocationReference(LoanAllocationReference allocationReference);
		LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder setSettlementDate(Date settlementDate);
		LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder setAmount(Money amount);
		LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder setFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition);

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
			processRosetta(path.newSubPath("facilityOutstandingsPosition"), processor, FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder.class, getFacilityOutstandingsPosition());
		}
		

		LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTransferSettlementEvent  ***********************/
	class LoanTransferSettlementEventImpl extends AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventImpl implements LoanTransferSettlementEvent {
		private final Money amount;
		private final FacilityOutstandingsPosition facilityOutstandingsPosition;
		
		protected LoanTransferSettlementEventImpl(LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder builder) {
			super(builder);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.facilityOutstandingsPosition = ofNullable(builder.getFacilityOutstandingsPosition()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		public Money getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("facilityOutstandingsPosition")
		public FacilityOutstandingsPosition getFacilityOutstandingsPosition() {
			return facilityOutstandingsPosition;
		}
		
		@Override
		public LoanTransferSettlementEvent build() {
			return this;
		}
		
		@Override
		public LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder toBuilder() {
			LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getFacilityOutstandingsPosition()).ifPresent(builder::setFacilityOutstandingsPosition);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTransferSettlementEvent _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(facilityOutstandingsPosition, _that.getFacilityOutstandingsPosition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (facilityOutstandingsPosition != null ? facilityOutstandingsPosition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTransferSettlementEvent {" +
				"amount=" + this.amount + ", " +
				"facilityOutstandingsPosition=" + this.facilityOutstandingsPosition +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTransferSettlementEvent  ***********************/
	class LoanTransferSettlementEventBuilderImpl extends AbstractLoanAllocationSettlementEvent.AbstractLoanAllocationSettlementEventBuilderImpl  implements LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder {
	
		protected Money.MoneyBuilder amount;
		protected FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder facilityOutstandingsPosition;
	
		public LoanTransferSettlementEventBuilderImpl() {
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
		public LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("allocationReference")
		public LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder setAllocationReference(LoanAllocationReference allocationReference) {
			this.allocationReference = allocationReference==null?null:allocationReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementDate")
		public LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder setSettlementDate(Date settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate;
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder setAmount(Money amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityOutstandingsPosition")
		public LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder setFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition) {
			this.facilityOutstandingsPosition = facilityOutstandingsPosition==null?null:facilityOutstandingsPosition.toBuilder();
			return this;
		}
		
		@Override
		public LoanTransferSettlementEvent build() {
			return new LoanTransferSettlementEvent.LoanTransferSettlementEventImpl(this);
		}
		
		@Override
		public LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder prune() {
			super.prune();
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (facilityOutstandingsPosition!=null && !facilityOutstandingsPosition.prune().hasData()) facilityOutstandingsPosition = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getFacilityOutstandingsPosition()!=null && getFacilityOutstandingsPosition().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder o = (LoanTransferSettlementEvent.LoanTransferSettlementEventBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getFacilityOutstandingsPosition(), o.getFacilityOutstandingsPosition(), this::setFacilityOutstandingsPosition);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTransferSettlementEvent _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(facilityOutstandingsPosition, _that.getFacilityOutstandingsPosition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (facilityOutstandingsPosition != null ? facilityOutstandingsPosition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTransferSettlementEventBuilder {" +
				"amount=" + this.amount + ", " +
				"facilityOutstandingsPosition=" + this.facilityOutstandingsPosition +
			'}' + " " + super.toString();
		}
	}
}
