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
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.CommitmentAdjustment;
import fpml.confirmation.LoanTradingEconomicBenefit;
import fpml.confirmation.LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder;
import fpml.confirmation.LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilderImpl;
import fpml.confirmation.LoanTradingEconomicBenefit.LoanTradingEconomicBenefitImpl;
import fpml.confirmation.Money;
import fpml.confirmation.meta.LoanTradingEconomicBenefitMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that combines a simple (money) amount with an optional event, for the purpose of defining economic benefit at settlement.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTradingEconomicBenefit", builder=LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilderImpl.class, version="${project.version}")
public interface LoanTradingEconomicBenefit extends RosettaModelObject {

	LoanTradingEconomicBenefitMeta metaData = new LoanTradingEconomicBenefitMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Economic benefit amount.
	 */
	Money getAmount();
	BusinessEventIdentifier getEventIdentifier();
	/**
	 * Any commitment adjustments which have occurred during settlement of the trade. Represented by the business event structure.
	 */
	CommitmentAdjustment getCommitmentAdjustment();

	/*********************** Build Methods  ***********************/
	LoanTradingEconomicBenefit build();
	
	LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder toBuilder();
	
	static LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder builder() {
		return new LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingEconomicBenefit> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradingEconomicBenefit> getType() {
		return LoanTradingEconomicBenefit.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("commitmentAdjustment"), processor, CommitmentAdjustment.class, getCommitmentAdjustment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingEconomicBenefitBuilder extends LoanTradingEconomicBenefit, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateAmount();
		Money.MoneyBuilder getAmount();
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier();
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getEventIdentifier();
		CommitmentAdjustment.CommitmentAdjustmentBuilder getOrCreateCommitmentAdjustment();
		CommitmentAdjustment.CommitmentAdjustmentBuilder getCommitmentAdjustment();
		LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder setAmount(Money amount);
		LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder setEventIdentifier(BusinessEventIdentifier eventIdentifier);
		LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder setCommitmentAdjustment(CommitmentAdjustment commitmentAdjustment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("commitmentAdjustment"), processor, CommitmentAdjustment.CommitmentAdjustmentBuilder.class, getCommitmentAdjustment());
		}
		

		LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingEconomicBenefit  ***********************/
	class LoanTradingEconomicBenefitImpl implements LoanTradingEconomicBenefit {
		private final Money amount;
		private final BusinessEventIdentifier eventIdentifier;
		private final CommitmentAdjustment commitmentAdjustment;
		
		protected LoanTradingEconomicBenefitImpl(LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder builder) {
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.eventIdentifier = ofNullable(builder.getEventIdentifier()).map(f->f.build()).orElse(null);
			this.commitmentAdjustment = ofNullable(builder.getCommitmentAdjustment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		public Money getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public BusinessEventIdentifier getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		@RosettaAttribute("commitmentAdjustment")
		public CommitmentAdjustment getCommitmentAdjustment() {
			return commitmentAdjustment;
		}
		
		@Override
		public LoanTradingEconomicBenefit build() {
			return this;
		}
		
		@Override
		public LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder toBuilder() {
			LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getEventIdentifier()).ifPresent(builder::setEventIdentifier);
			ofNullable(getCommitmentAdjustment()).ifPresent(builder::setCommitmentAdjustment);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingEconomicBenefit _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(commitmentAdjustment, _that.getCommitmentAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (commitmentAdjustment != null ? commitmentAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingEconomicBenefit {" +
				"amount=" + this.amount + ", " +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"commitmentAdjustment=" + this.commitmentAdjustment +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradingEconomicBenefit  ***********************/
	class LoanTradingEconomicBenefitBuilderImpl implements LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder {
	
		protected Money.MoneyBuilder amount;
		protected BusinessEventIdentifier.BusinessEventIdentifierBuilder eventIdentifier;
		protected CommitmentAdjustment.CommitmentAdjustmentBuilder commitmentAdjustment;
	
		public LoanTradingEconomicBenefitBuilderImpl() {
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
		@RosettaAttribute("eventIdentifier")
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier() {
			BusinessEventIdentifier.BusinessEventIdentifierBuilder result;
			if (eventIdentifier!=null) {
				result = eventIdentifier;
			}
			else {
				result = eventIdentifier = BusinessEventIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commitmentAdjustment")
		public CommitmentAdjustment.CommitmentAdjustmentBuilder getCommitmentAdjustment() {
			return commitmentAdjustment;
		}
		
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder getOrCreateCommitmentAdjustment() {
			CommitmentAdjustment.CommitmentAdjustmentBuilder result;
			if (commitmentAdjustment!=null) {
				result = commitmentAdjustment;
			}
			else {
				result = commitmentAdjustment = CommitmentAdjustment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amount")
		public LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder setAmount(Money amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("eventIdentifier")
		public LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder setEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			this.eventIdentifier = eventIdentifier==null?null:eventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commitmentAdjustment")
		public LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder setCommitmentAdjustment(CommitmentAdjustment commitmentAdjustment) {
			this.commitmentAdjustment = commitmentAdjustment==null?null:commitmentAdjustment.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradingEconomicBenefit build() {
			return new LoanTradingEconomicBenefit.LoanTradingEconomicBenefitImpl(this);
		}
		
		@Override
		public LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder prune() {
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (eventIdentifier!=null && !eventIdentifier.prune().hasData()) eventIdentifier = null;
			if (commitmentAdjustment!=null && !commitmentAdjustment.prune().hasData()) commitmentAdjustment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getEventIdentifier()!=null && getEventIdentifier().hasData()) return true;
			if (getCommitmentAdjustment()!=null && getCommitmentAdjustment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder o = (LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getEventIdentifier(), o.getEventIdentifier(), this::setEventIdentifier);
			merger.mergeRosetta(getCommitmentAdjustment(), o.getCommitmentAdjustment(), this::setCommitmentAdjustment);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingEconomicBenefit _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(commitmentAdjustment, _that.getCommitmentAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (commitmentAdjustment != null ? commitmentAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingEconomicBenefitBuilder {" +
				"amount=" + this.amount + ", " +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"commitmentAdjustment=" + this.commitmentAdjustment +
			'}';
		}
	}
}
