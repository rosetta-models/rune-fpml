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
import fpml.confirmation.AbstractLoanAllocationEvent;
import fpml.confirmation.AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder;
import fpml.confirmation.AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilderImpl;
import fpml.confirmation.AbstractLoanAllocationEvent.AbstractLoanAllocationEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.DateList;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanAllocationNoSettlePeriod;
import fpml.confirmation.LoanAllocationReference;
import fpml.confirmation.LoanSettlementDateAvailabilityEvent;
import fpml.confirmation.LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder;
import fpml.confirmation.LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilderImpl;
import fpml.confirmation.LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventImpl;
import fpml.confirmation.LoanSettlementDateAvailabilityEventSequence;
import fpml.confirmation.Money;
import fpml.confirmation.PeriodModel;
import fpml.confirmation.meta.LoanSettlementDateAvailabilityEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event structure defining information related to trade settlement date coordination.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanSettlementDateAvailabilityEvent", builder=LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilderImpl.class, version="${project.version}")
public interface LoanSettlementDateAvailabilityEvent extends AbstractLoanAllocationEvent {

	LoanSettlementDateAvailabilityEventMeta metaData = new LoanSettlementDateAvailabilityEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The amount settled.
	 */
	List<? extends Money> getAmount();
	/**
	 * Specific date or dates on which a trade may be settled.
	 */
	DateList getSpecificDates();
	PeriodModel getPeriodModel();
	/**
	 * Date on or after which a trade can be settled.
	 */
	Date getOnOrAfterDate();
	LoanSettlementDateAvailabilityEventSequence getLoanSettlementDateAvailabilityEventSequence();
	/**
	 * A period during which no settlement of a trade can occur, other than non-business days.
	 */
	List<? extends LoanAllocationNoSettlePeriod> getNoSettlePeriod();

	/*********************** Build Methods  ***********************/
	LoanSettlementDateAvailabilityEvent build();
	
	LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder toBuilder();
	
	static LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder builder() {
		return new LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanSettlementDateAvailabilityEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanSettlementDateAvailabilityEvent> getType() {
		return LoanSettlementDateAvailabilityEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.class, getAllocationReference());
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processRosetta(path.newSubPath("specificDates"), processor, DateList.class, getSpecificDates());
		processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.class, getPeriodModel());
		processor.processBasic(path.newSubPath("onOrAfterDate"), Date.class, getOnOrAfterDate(), this);
		processRosetta(path.newSubPath("loanSettlementDateAvailabilityEventSequence"), processor, LoanSettlementDateAvailabilityEventSequence.class, getLoanSettlementDateAvailabilityEventSequence());
		processRosetta(path.newSubPath("noSettlePeriod"), processor, LoanAllocationNoSettlePeriod.class, getNoSettlePeriod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanSettlementDateAvailabilityEventBuilder extends LoanSettlementDateAvailabilityEvent, AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder {
		Money.MoneyBuilder getOrCreateAmount(int _index);
		List<? extends Money.MoneyBuilder> getAmount();
		DateList.DateListBuilder getOrCreateSpecificDates();
		DateList.DateListBuilder getSpecificDates();
		PeriodModel.PeriodModelBuilder getOrCreatePeriodModel();
		PeriodModel.PeriodModelBuilder getPeriodModel();
		LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder getOrCreateLoanSettlementDateAvailabilityEventSequence();
		LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder getLoanSettlementDateAvailabilityEventSequence();
		LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder getOrCreateNoSettlePeriod(int _index);
		List<? extends LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder> getNoSettlePeriod();
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setComment(String comment);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addAllocationReference(LoanAllocationReference allocationReference0);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addAllocationReference(LoanAllocationReference allocationReference1, int _idx);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addAllocationReference(List<? extends LoanAllocationReference> allocationReference2);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setAllocationReference(List<? extends LoanAllocationReference> allocationReference3);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addAmount(Money amount0);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addAmount(Money amount1, int _idx);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addAmount(List<? extends Money> amount2);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setAmount(List<? extends Money> amount3);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setSpecificDates(DateList specificDates);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setPeriodModel(PeriodModel periodModel);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setOnOrAfterDate(Date onOrAfterDate);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setLoanSettlementDateAvailabilityEventSequence(LoanSettlementDateAvailabilityEventSequence loanSettlementDateAvailabilityEventSequence);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addNoSettlePeriod(LoanAllocationNoSettlePeriod noSettlePeriod0);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addNoSettlePeriod(LoanAllocationNoSettlePeriod noSettlePeriod1, int _idx);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addNoSettlePeriod(List<? extends LoanAllocationNoSettlePeriod> noSettlePeriod2);
		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setNoSettlePeriod(List<? extends LoanAllocationNoSettlePeriod> noSettlePeriod3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.LoanAllocationReferenceBuilder.class, getAllocationReference());
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("specificDates"), processor, DateList.DateListBuilder.class, getSpecificDates());
			processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.PeriodModelBuilder.class, getPeriodModel());
			processor.processBasic(path.newSubPath("onOrAfterDate"), Date.class, getOnOrAfterDate(), this);
			processRosetta(path.newSubPath("loanSettlementDateAvailabilityEventSequence"), processor, LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder.class, getLoanSettlementDateAvailabilityEventSequence());
			processRosetta(path.newSubPath("noSettlePeriod"), processor, LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder.class, getNoSettlePeriod());
		}
		

		LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder prune();
	}

	/*********************** Immutable Implementation of LoanSettlementDateAvailabilityEvent  ***********************/
	class LoanSettlementDateAvailabilityEventImpl extends AbstractLoanAllocationEvent.AbstractLoanAllocationEventImpl implements LoanSettlementDateAvailabilityEvent {
		private final List<? extends Money> amount;
		private final DateList specificDates;
		private final PeriodModel periodModel;
		private final Date onOrAfterDate;
		private final LoanSettlementDateAvailabilityEventSequence loanSettlementDateAvailabilityEventSequence;
		private final List<? extends LoanAllocationNoSettlePeriod> noSettlePeriod;
		
		protected LoanSettlementDateAvailabilityEventImpl(LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder builder) {
			super(builder);
			this.amount = ofNullable(builder.getAmount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.specificDates = ofNullable(builder.getSpecificDates()).map(f->f.build()).orElse(null);
			this.periodModel = ofNullable(builder.getPeriodModel()).map(f->f.build()).orElse(null);
			this.onOrAfterDate = builder.getOnOrAfterDate();
			this.loanSettlementDateAvailabilityEventSequence = ofNullable(builder.getLoanSettlementDateAvailabilityEventSequence()).map(f->f.build()).orElse(null);
			this.noSettlePeriod = ofNullable(builder.getNoSettlePeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		public List<? extends Money> getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("specificDates")
		public DateList getSpecificDates() {
			return specificDates;
		}
		
		@Override
		@RosettaAttribute("periodModel")
		public PeriodModel getPeriodModel() {
			return periodModel;
		}
		
		@Override
		@RosettaAttribute("onOrAfterDate")
		public Date getOnOrAfterDate() {
			return onOrAfterDate;
		}
		
		@Override
		@RosettaAttribute("loanSettlementDateAvailabilityEventSequence")
		public LoanSettlementDateAvailabilityEventSequence getLoanSettlementDateAvailabilityEventSequence() {
			return loanSettlementDateAvailabilityEventSequence;
		}
		
		@Override
		@RosettaAttribute("noSettlePeriod")
		public List<? extends LoanAllocationNoSettlePeriod> getNoSettlePeriod() {
			return noSettlePeriod;
		}
		
		@Override
		public LoanSettlementDateAvailabilityEvent build() {
			return this;
		}
		
		@Override
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder toBuilder() {
			LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getSpecificDates()).ifPresent(builder::setSpecificDates);
			ofNullable(getPeriodModel()).ifPresent(builder::setPeriodModel);
			ofNullable(getOnOrAfterDate()).ifPresent(builder::setOnOrAfterDate);
			ofNullable(getLoanSettlementDateAvailabilityEventSequence()).ifPresent(builder::setLoanSettlementDateAvailabilityEventSequence);
			ofNullable(getNoSettlePeriod()).ifPresent(builder::setNoSettlePeriod);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanSettlementDateAvailabilityEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(amount, _that.getAmount())) return false;
			if (!Objects.equals(specificDates, _that.getSpecificDates())) return false;
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(onOrAfterDate, _that.getOnOrAfterDate())) return false;
			if (!Objects.equals(loanSettlementDateAvailabilityEventSequence, _that.getLoanSettlementDateAvailabilityEventSequence())) return false;
			if (!ListEquals.listEquals(noSettlePeriod, _that.getNoSettlePeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (specificDates != null ? specificDates.hashCode() : 0);
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (onOrAfterDate != null ? onOrAfterDate.hashCode() : 0);
			_result = 31 * _result + (loanSettlementDateAvailabilityEventSequence != null ? loanSettlementDateAvailabilityEventSequence.hashCode() : 0);
			_result = 31 * _result + (noSettlePeriod != null ? noSettlePeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanSettlementDateAvailabilityEvent {" +
				"amount=" + this.amount + ", " +
				"specificDates=" + this.specificDates + ", " +
				"periodModel=" + this.periodModel + ", " +
				"onOrAfterDate=" + this.onOrAfterDate + ", " +
				"loanSettlementDateAvailabilityEventSequence=" + this.loanSettlementDateAvailabilityEventSequence + ", " +
				"noSettlePeriod=" + this.noSettlePeriod +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanSettlementDateAvailabilityEvent  ***********************/
	class LoanSettlementDateAvailabilityEventBuilderImpl extends AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilderImpl  implements LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder {
	
		protected List<Money.MoneyBuilder> amount = new ArrayList<>();
		protected DateList.DateListBuilder specificDates;
		protected PeriodModel.PeriodModelBuilder periodModel;
		protected Date onOrAfterDate;
		protected LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder loanSettlementDateAvailabilityEventSequence;
		protected List<LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder> noSettlePeriod = new ArrayList<>();
	
		public LoanSettlementDateAvailabilityEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("amount")
		public List<? extends Money.MoneyBuilder> getAmount() {
			return amount;
		}
		
		public Money.MoneyBuilder getOrCreateAmount(int _index) {
		
			if (amount==null) {
				this.amount = new ArrayList<>();
			}
			Money.MoneyBuilder result;
			return getIndex(amount, _index, () -> {
						Money.MoneyBuilder newAmount = Money.builder();
						return newAmount;
					});
		}
		
		@Override
		@RosettaAttribute("specificDates")
		public DateList.DateListBuilder getSpecificDates() {
			return specificDates;
		}
		
		@Override
		public DateList.DateListBuilder getOrCreateSpecificDates() {
			DateList.DateListBuilder result;
			if (specificDates!=null) {
				result = specificDates;
			}
			else {
				result = specificDates = DateList.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodModel")
		public PeriodModel.PeriodModelBuilder getPeriodModel() {
			return periodModel;
		}
		
		@Override
		public PeriodModel.PeriodModelBuilder getOrCreatePeriodModel() {
			PeriodModel.PeriodModelBuilder result;
			if (periodModel!=null) {
				result = periodModel;
			}
			else {
				result = periodModel = PeriodModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("onOrAfterDate")
		public Date getOnOrAfterDate() {
			return onOrAfterDate;
		}
		
		@Override
		@RosettaAttribute("loanSettlementDateAvailabilityEventSequence")
		public LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder getLoanSettlementDateAvailabilityEventSequence() {
			return loanSettlementDateAvailabilityEventSequence;
		}
		
		@Override
		public LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder getOrCreateLoanSettlementDateAvailabilityEventSequence() {
			LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder result;
			if (loanSettlementDateAvailabilityEventSequence!=null) {
				result = loanSettlementDateAvailabilityEventSequence;
			}
			else {
				result = loanSettlementDateAvailabilityEventSequence = LoanSettlementDateAvailabilityEventSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("noSettlePeriod")
		public List<? extends LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder> getNoSettlePeriod() {
			return noSettlePeriod;
		}
		
		public LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder getOrCreateNoSettlePeriod(int _index) {
		
			if (noSettlePeriod==null) {
				this.noSettlePeriod = new ArrayList<>();
			}
			LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder result;
			return getIndex(noSettlePeriod, _index, () -> {
						LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder newNoSettlePeriod = LoanAllocationNoSettlePeriod.builder();
						return newNoSettlePeriod;
					});
		}
		
		@Override
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addAllocationReference(LoanAllocationReference allocationReference) {
			if (allocationReference!=null) this.allocationReference.add(allocationReference.toBuilder());
			return this;
		}
		
		@Override
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addAllocationReference(LoanAllocationReference allocationReference, int _idx) {
			getIndex(this.allocationReference, _idx, () -> allocationReference.toBuilder());
			return this;
		}
		@Override 
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addAllocationReference(List<? extends LoanAllocationReference> allocationReferences) {
			if (allocationReferences != null) {
				for (LoanAllocationReference toAdd : allocationReferences) {
					this.allocationReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("allocationReference")
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setAllocationReference(List<? extends LoanAllocationReference> allocationReferences) {
			if (allocationReferences == null)  {
				this.allocationReference = new ArrayList<>();
			}
			else {
				this.allocationReference = allocationReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addAmount(Money amount) {
			if (amount!=null) this.amount.add(amount.toBuilder());
			return this;
		}
		
		@Override
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addAmount(Money amount, int _idx) {
			getIndex(this.amount, _idx, () -> amount.toBuilder());
			return this;
		}
		@Override 
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addAmount(List<? extends Money> amounts) {
			if (amounts != null) {
				for (Money toAdd : amounts) {
					this.amount.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("amount")
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setAmount(List<? extends Money> amounts) {
			if (amounts == null)  {
				this.amount = new ArrayList<>();
			}
			else {
				this.amount = amounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("specificDates")
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setSpecificDates(DateList specificDates) {
			this.specificDates = specificDates==null?null:specificDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("periodModel")
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setPeriodModel(PeriodModel periodModel) {
			this.periodModel = periodModel==null?null:periodModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onOrAfterDate")
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setOnOrAfterDate(Date onOrAfterDate) {
			this.onOrAfterDate = onOrAfterDate==null?null:onOrAfterDate;
			return this;
		}
		@Override
		@RosettaAttribute("loanSettlementDateAvailabilityEventSequence")
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setLoanSettlementDateAvailabilityEventSequence(LoanSettlementDateAvailabilityEventSequence loanSettlementDateAvailabilityEventSequence) {
			this.loanSettlementDateAvailabilityEventSequence = loanSettlementDateAvailabilityEventSequence==null?null:loanSettlementDateAvailabilityEventSequence.toBuilder();
			return this;
		}
		@Override
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addNoSettlePeriod(LoanAllocationNoSettlePeriod noSettlePeriod) {
			if (noSettlePeriod!=null) this.noSettlePeriod.add(noSettlePeriod.toBuilder());
			return this;
		}
		
		@Override
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addNoSettlePeriod(LoanAllocationNoSettlePeriod noSettlePeriod, int _idx) {
			getIndex(this.noSettlePeriod, _idx, () -> noSettlePeriod.toBuilder());
			return this;
		}
		@Override 
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder addNoSettlePeriod(List<? extends LoanAllocationNoSettlePeriod> noSettlePeriods) {
			if (noSettlePeriods != null) {
				for (LoanAllocationNoSettlePeriod toAdd : noSettlePeriods) {
					this.noSettlePeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("noSettlePeriod")
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder setNoSettlePeriod(List<? extends LoanAllocationNoSettlePeriod> noSettlePeriods) {
			if (noSettlePeriods == null)  {
				this.noSettlePeriod = new ArrayList<>();
			}
			else {
				this.noSettlePeriod = noSettlePeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public LoanSettlementDateAvailabilityEvent build() {
			return new LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventImpl(this);
		}
		
		@Override
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder prune() {
			super.prune();
			amount = amount.stream().filter(b->b!=null).<Money.MoneyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (specificDates!=null && !specificDates.prune().hasData()) specificDates = null;
			if (periodModel!=null && !periodModel.prune().hasData()) periodModel = null;
			if (loanSettlementDateAvailabilityEventSequence!=null && !loanSettlementDateAvailabilityEventSequence.prune().hasData()) loanSettlementDateAvailabilityEventSequence = null;
			noSettlePeriod = noSettlePeriod.stream().filter(b->b!=null).<LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmount()!=null && getAmount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSpecificDates()!=null && getSpecificDates().hasData()) return true;
			if (getPeriodModel()!=null && getPeriodModel().hasData()) return true;
			if (getOnOrAfterDate()!=null) return true;
			if (getLoanSettlementDateAvailabilityEventSequence()!=null && getLoanSettlementDateAvailabilityEventSequence().hasData()) return true;
			if (getNoSettlePeriod()!=null && getNoSettlePeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder o = (LoanSettlementDateAvailabilityEvent.LoanSettlementDateAvailabilityEventBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::getOrCreateAmount);
			merger.mergeRosetta(getSpecificDates(), o.getSpecificDates(), this::setSpecificDates);
			merger.mergeRosetta(getPeriodModel(), o.getPeriodModel(), this::setPeriodModel);
			merger.mergeRosetta(getLoanSettlementDateAvailabilityEventSequence(), o.getLoanSettlementDateAvailabilityEventSequence(), this::setLoanSettlementDateAvailabilityEventSequence);
			merger.mergeRosetta(getNoSettlePeriod(), o.getNoSettlePeriod(), this::getOrCreateNoSettlePeriod);
			
			merger.mergeBasic(getOnOrAfterDate(), o.getOnOrAfterDate(), this::setOnOrAfterDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanSettlementDateAvailabilityEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(amount, _that.getAmount())) return false;
			if (!Objects.equals(specificDates, _that.getSpecificDates())) return false;
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(onOrAfterDate, _that.getOnOrAfterDate())) return false;
			if (!Objects.equals(loanSettlementDateAvailabilityEventSequence, _that.getLoanSettlementDateAvailabilityEventSequence())) return false;
			if (!ListEquals.listEquals(noSettlePeriod, _that.getNoSettlePeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (specificDates != null ? specificDates.hashCode() : 0);
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (onOrAfterDate != null ? onOrAfterDate.hashCode() : 0);
			_result = 31 * _result + (loanSettlementDateAvailabilityEventSequence != null ? loanSettlementDateAvailabilityEventSequence.hashCode() : 0);
			_result = 31 * _result + (noSettlePeriod != null ? noSettlePeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanSettlementDateAvailabilityEventBuilder {" +
				"amount=" + this.amount + ", " +
				"specificDates=" + this.specificDates + ", " +
				"periodModel=" + this.periodModel + ", " +
				"onOrAfterDate=" + this.onOrAfterDate + ", " +
				"loanSettlementDateAvailabilityEventSequence=" + this.loanSettlementDateAvailabilityEventSequence + ", " +
				"noSettlePeriod=" + this.noSettlePeriod +
			'}' + " " + super.toString();
		}
	}
}
