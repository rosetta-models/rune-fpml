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
import fpml.confirmation.AbstractLoanContractEvent;
import fpml.confirmation.AbstractLoanContractEvent.AbstractLoanContractEventBuilder;
import fpml.confirmation.AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl;
import fpml.confirmation.AbstractLoanContractEvent.AbstractLoanContractEventImpl;
import fpml.confirmation.AdjustmentType;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractAdjustment;
import fpml.confirmation.LoanContractAdjustment.LoanContractAdjustmentBuilder;
import fpml.confirmation.LoanContractAdjustment.LoanContractAdjustmentBuilderImpl;
import fpml.confirmation.LoanContractAdjustment.LoanContractAdjustmentImpl;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.meta.LoanContractAdjustmentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event representing adjustment in the notional amount of a loan contract that has no cash flow effect. E.g. an amount adjustment due to a defaulted loan.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanContractAdjustment", builder=LoanContractAdjustment.LoanContractAdjustmentBuilderImpl.class, version="${project.version}")
public interface LoanContractAdjustment extends AbstractLoanContractEvent {

	LoanContractAdjustmentMeta metaData = new LoanContractAdjustmentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the type of adjustment applied - increase or decrease.
	 */
	AdjustmentType getAdjustment();
	MoneyWithParticipantShare getAmount();

	/*********************** Build Methods  ***********************/
	LoanContractAdjustment build();
	
	LoanContractAdjustment.LoanContractAdjustmentBuilder toBuilder();
	
	static LoanContractAdjustment.LoanContractAdjustmentBuilder builder() {
		return new LoanContractAdjustment.LoanContractAdjustmentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanContractAdjustment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanContractAdjustment> getType() {
		return LoanContractAdjustment.class;
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
		processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.class, getLoanContractReference());
		processRosetta(path.newSubPath("adjustment"), processor, AdjustmentType.class, getAdjustment());
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanContractAdjustmentBuilder extends LoanContractAdjustment, AbstractLoanContractEvent.AbstractLoanContractEventBuilder {
		AdjustmentType.AdjustmentTypeBuilder getOrCreateAdjustment();
		AdjustmentType.AdjustmentTypeBuilder getAdjustment();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		LoanContractAdjustment.LoanContractAdjustmentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LoanContractAdjustment.LoanContractAdjustmentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LoanContractAdjustment.LoanContractAdjustmentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LoanContractAdjustment.LoanContractAdjustmentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LoanContractAdjustment.LoanContractAdjustmentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LoanContractAdjustment.LoanContractAdjustmentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LoanContractAdjustment.LoanContractAdjustmentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LoanContractAdjustment.LoanContractAdjustmentBuilder setComment(String comment);
		LoanContractAdjustment.LoanContractAdjustmentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		LoanContractAdjustment.LoanContractAdjustmentBuilder setEffectiveDate(Date effectiveDate);
		LoanContractAdjustment.LoanContractAdjustmentBuilder setLoanContractReference(LoanContractReference loanContractReference);
		LoanContractAdjustment.LoanContractAdjustmentBuilder setAdjustment(AdjustmentType adjustment);
		LoanContractAdjustment.LoanContractAdjustmentBuilder setAmount(MoneyWithParticipantShare amount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.BusinessEventPartiesModelBuilder.class, getBusinessEventPartiesModel());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.LoanContractReferenceBuilder.class, getLoanContractReference());
			processRosetta(path.newSubPath("adjustment"), processor, AdjustmentType.AdjustmentTypeBuilder.class, getAdjustment());
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
		}
		

		LoanContractAdjustment.LoanContractAdjustmentBuilder prune();
	}

	/*********************** Immutable Implementation of LoanContractAdjustment  ***********************/
	class LoanContractAdjustmentImpl extends AbstractLoanContractEvent.AbstractLoanContractEventImpl implements LoanContractAdjustment {
		private final AdjustmentType adjustment;
		private final MoneyWithParticipantShare amount;
		
		protected LoanContractAdjustmentImpl(LoanContractAdjustment.LoanContractAdjustmentBuilder builder) {
			super(builder);
			this.adjustment = ofNullable(builder.getAdjustment()).map(f->f.build()).orElse(null);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("adjustment")
		public AdjustmentType getAdjustment() {
			return adjustment;
		}
		
		@Override
		@RosettaAttribute("amount")
		public MoneyWithParticipantShare getAmount() {
			return amount;
		}
		
		@Override
		public LoanContractAdjustment build() {
			return this;
		}
		
		@Override
		public LoanContractAdjustment.LoanContractAdjustmentBuilder toBuilder() {
			LoanContractAdjustment.LoanContractAdjustmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanContractAdjustment.LoanContractAdjustmentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAdjustment()).ifPresent(builder::setAdjustment);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContractAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(adjustment, _that.getAdjustment())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (adjustment != null ? adjustment.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractAdjustment {" +
				"adjustment=" + this.adjustment + ", " +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanContractAdjustment  ***********************/
	class LoanContractAdjustmentBuilderImpl extends AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl  implements LoanContractAdjustment.LoanContractAdjustmentBuilder {
	
		protected AdjustmentType.AdjustmentTypeBuilder adjustment;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
	
		public LoanContractAdjustmentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("adjustment")
		public AdjustmentType.AdjustmentTypeBuilder getAdjustment() {
			return adjustment;
		}
		
		@Override
		public AdjustmentType.AdjustmentTypeBuilder getOrCreateAdjustment() {
			AdjustmentType.AdjustmentTypeBuilder result;
			if (adjustment!=null) {
				result = adjustment;
			}
			else {
				result = adjustment = AdjustmentType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount() {
			return amount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		public LoanContractAdjustment.LoanContractAdjustmentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractAdjustment.LoanContractAdjustmentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LoanContractAdjustment.LoanContractAdjustmentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public LoanContractAdjustment.LoanContractAdjustmentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanContractAdjustment.LoanContractAdjustmentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LoanContractAdjustment.LoanContractAdjustmentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LoanContractAdjustment.LoanContractAdjustmentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanContractAdjustment.LoanContractAdjustmentBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public LoanContractAdjustment.LoanContractAdjustmentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public LoanContractAdjustment.LoanContractAdjustmentBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("loanContractReference")
		public LoanContractAdjustment.LoanContractAdjustmentBuilder setLoanContractReference(LoanContractReference loanContractReference) {
			this.loanContractReference = loanContractReference==null?null:loanContractReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustment")
		public LoanContractAdjustment.LoanContractAdjustmentBuilder setAdjustment(AdjustmentType adjustment) {
			this.adjustment = adjustment==null?null:adjustment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public LoanContractAdjustment.LoanContractAdjustmentBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		
		@Override
		public LoanContractAdjustment build() {
			return new LoanContractAdjustment.LoanContractAdjustmentImpl(this);
		}
		
		@Override
		public LoanContractAdjustment.LoanContractAdjustmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractAdjustment.LoanContractAdjustmentBuilder prune() {
			super.prune();
			if (adjustment!=null && !adjustment.prune().hasData()) adjustment = null;
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAdjustment()!=null && getAdjustment().hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractAdjustment.LoanContractAdjustmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanContractAdjustment.LoanContractAdjustmentBuilder o = (LoanContractAdjustment.LoanContractAdjustmentBuilder) other;
			
			merger.mergeRosetta(getAdjustment(), o.getAdjustment(), this::setAdjustment);
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContractAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(adjustment, _that.getAdjustment())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (adjustment != null ? adjustment.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractAdjustmentBuilder {" +
				"adjustment=" + this.adjustment + ", " +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}
}
