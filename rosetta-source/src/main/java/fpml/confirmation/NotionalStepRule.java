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
import fpml.confirmation.CalculationPeriodDatesReference;
import fpml.confirmation.Frequency;
import fpml.confirmation.NotionalStepRule;
import fpml.confirmation.NotionalStepRule.NotionalStepRuleBuilder;
import fpml.confirmation.NotionalStepRule.NotionalStepRuleBuilderImpl;
import fpml.confirmation.NotionalStepRule.NotionalStepRuleImpl;
import fpml.confirmation.NotionalStepRuleSequence;
import fpml.confirmation.meta.NotionalStepRuleMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a parametric representation of the notional step schedule, i.e. parameters used to generate the notional balance on each step date. The step change in notional can be expressed in terms of either a fixed amount or as a percentage of either the initial notional or previous notional amount. This parametric representation is intended to cover the more common amortizing/accreting.
 * @version ${project.version}
 */
@RosettaDataType(value="NotionalStepRule", builder=NotionalStepRule.NotionalStepRuleBuilderImpl.class, version="${project.version}")
public interface NotionalStepRule extends RosettaModelObject {

	NotionalStepRuleMeta metaData = new NotionalStepRuleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A pointer style reference to the associated calculation period dates component defined elsewhere in the document.
	 */
	CalculationPeriodDatesReference getCalculationPeriodDatesReference();
	/**
	 * The frequency at which the notional step changes occur. This frequency must be an integer multiple of the stream calculation period frequency.
	 */
	Frequency getStepFrequency();
	/**
	 * Effective date of the first change in notional (i.e. a calculation period start date).
	 */
	Date getFirstNotionalStepDate();
	/**
	 * Effective date of the last change in notional (i.e. a calculation period start date).
	 */
	Date getLastNotionalStepDate();
	/**
	 * The explicit amount that the notional changes on each step date. This can be a positive or negative amount.
	 */
	BigDecimal getNotionalStepAmount();
	NotionalStepRuleSequence getNotionalStepRuleSequence();

	/*********************** Build Methods  ***********************/
	NotionalStepRule build();
	
	NotionalStepRule.NotionalStepRuleBuilder toBuilder();
	
	static NotionalStepRule.NotionalStepRuleBuilder builder() {
		return new NotionalStepRule.NotionalStepRuleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotionalStepRule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NotionalStepRule> getType() {
		return NotionalStepRule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationPeriodDatesReference"), processor, CalculationPeriodDatesReference.class, getCalculationPeriodDatesReference());
		processRosetta(path.newSubPath("stepFrequency"), processor, Frequency.class, getStepFrequency());
		processor.processBasic(path.newSubPath("firstNotionalStepDate"), Date.class, getFirstNotionalStepDate(), this);
		processor.processBasic(path.newSubPath("lastNotionalStepDate"), Date.class, getLastNotionalStepDate(), this);
		processor.processBasic(path.newSubPath("notionalStepAmount"), BigDecimal.class, getNotionalStepAmount(), this);
		processRosetta(path.newSubPath("notionalStepRuleSequence"), processor, NotionalStepRuleSequence.class, getNotionalStepRuleSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalStepRuleBuilder extends NotionalStepRule, RosettaModelObjectBuilder {
		CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder getOrCreateCalculationPeriodDatesReference();
		CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder getCalculationPeriodDatesReference();
		Frequency.FrequencyBuilder getOrCreateStepFrequency();
		Frequency.FrequencyBuilder getStepFrequency();
		NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder getOrCreateNotionalStepRuleSequence();
		NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder getNotionalStepRuleSequence();
		NotionalStepRule.NotionalStepRuleBuilder setCalculationPeriodDatesReference(CalculationPeriodDatesReference calculationPeriodDatesReference);
		NotionalStepRule.NotionalStepRuleBuilder setStepFrequency(Frequency stepFrequency);
		NotionalStepRule.NotionalStepRuleBuilder setFirstNotionalStepDate(Date firstNotionalStepDate);
		NotionalStepRule.NotionalStepRuleBuilder setLastNotionalStepDate(Date lastNotionalStepDate);
		NotionalStepRule.NotionalStepRuleBuilder setNotionalStepAmount(BigDecimal notionalStepAmount);
		NotionalStepRule.NotionalStepRuleBuilder setNotionalStepRuleSequence(NotionalStepRuleSequence notionalStepRuleSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationPeriodDatesReference"), processor, CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder.class, getCalculationPeriodDatesReference());
			processRosetta(path.newSubPath("stepFrequency"), processor, Frequency.FrequencyBuilder.class, getStepFrequency());
			processor.processBasic(path.newSubPath("firstNotionalStepDate"), Date.class, getFirstNotionalStepDate(), this);
			processor.processBasic(path.newSubPath("lastNotionalStepDate"), Date.class, getLastNotionalStepDate(), this);
			processor.processBasic(path.newSubPath("notionalStepAmount"), BigDecimal.class, getNotionalStepAmount(), this);
			processRosetta(path.newSubPath("notionalStepRuleSequence"), processor, NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder.class, getNotionalStepRuleSequence());
		}
		

		NotionalStepRule.NotionalStepRuleBuilder prune();
	}

	/*********************** Immutable Implementation of NotionalStepRule  ***********************/
	class NotionalStepRuleImpl implements NotionalStepRule {
		private final CalculationPeriodDatesReference calculationPeriodDatesReference;
		private final Frequency stepFrequency;
		private final Date firstNotionalStepDate;
		private final Date lastNotionalStepDate;
		private final BigDecimal notionalStepAmount;
		private final NotionalStepRuleSequence notionalStepRuleSequence;
		
		protected NotionalStepRuleImpl(NotionalStepRule.NotionalStepRuleBuilder builder) {
			this.calculationPeriodDatesReference = ofNullable(builder.getCalculationPeriodDatesReference()).map(f->f.build()).orElse(null);
			this.stepFrequency = ofNullable(builder.getStepFrequency()).map(f->f.build()).orElse(null);
			this.firstNotionalStepDate = builder.getFirstNotionalStepDate();
			this.lastNotionalStepDate = builder.getLastNotionalStepDate();
			this.notionalStepAmount = builder.getNotionalStepAmount();
			this.notionalStepRuleSequence = ofNullable(builder.getNotionalStepRuleSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDatesReference")
		public CalculationPeriodDatesReference getCalculationPeriodDatesReference() {
			return calculationPeriodDatesReference;
		}
		
		@Override
		@RosettaAttribute("stepFrequency")
		public Frequency getStepFrequency() {
			return stepFrequency;
		}
		
		@Override
		@RosettaAttribute("firstNotionalStepDate")
		public Date getFirstNotionalStepDate() {
			return firstNotionalStepDate;
		}
		
		@Override
		@RosettaAttribute("lastNotionalStepDate")
		public Date getLastNotionalStepDate() {
			return lastNotionalStepDate;
		}
		
		@Override
		@RosettaAttribute("notionalStepAmount")
		public BigDecimal getNotionalStepAmount() {
			return notionalStepAmount;
		}
		
		@Override
		@RosettaAttribute("notionalStepRuleSequence")
		public NotionalStepRuleSequence getNotionalStepRuleSequence() {
			return notionalStepRuleSequence;
		}
		
		@Override
		public NotionalStepRule build() {
			return this;
		}
		
		@Override
		public NotionalStepRule.NotionalStepRuleBuilder toBuilder() {
			NotionalStepRule.NotionalStepRuleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotionalStepRule.NotionalStepRuleBuilder builder) {
			ofNullable(getCalculationPeriodDatesReference()).ifPresent(builder::setCalculationPeriodDatesReference);
			ofNullable(getStepFrequency()).ifPresent(builder::setStepFrequency);
			ofNullable(getFirstNotionalStepDate()).ifPresent(builder::setFirstNotionalStepDate);
			ofNullable(getLastNotionalStepDate()).ifPresent(builder::setLastNotionalStepDate);
			ofNullable(getNotionalStepAmount()).ifPresent(builder::setNotionalStepAmount);
			ofNullable(getNotionalStepRuleSequence()).ifPresent(builder::setNotionalStepRuleSequence);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalStepRule _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodDatesReference, _that.getCalculationPeriodDatesReference())) return false;
			if (!Objects.equals(stepFrequency, _that.getStepFrequency())) return false;
			if (!Objects.equals(firstNotionalStepDate, _that.getFirstNotionalStepDate())) return false;
			if (!Objects.equals(lastNotionalStepDate, _that.getLastNotionalStepDate())) return false;
			if (!Objects.equals(notionalStepAmount, _that.getNotionalStepAmount())) return false;
			if (!Objects.equals(notionalStepRuleSequence, _that.getNotionalStepRuleSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodDatesReference != null ? calculationPeriodDatesReference.hashCode() : 0);
			_result = 31 * _result + (stepFrequency != null ? stepFrequency.hashCode() : 0);
			_result = 31 * _result + (firstNotionalStepDate != null ? firstNotionalStepDate.hashCode() : 0);
			_result = 31 * _result + (lastNotionalStepDate != null ? lastNotionalStepDate.hashCode() : 0);
			_result = 31 * _result + (notionalStepAmount != null ? notionalStepAmount.hashCode() : 0);
			_result = 31 * _result + (notionalStepRuleSequence != null ? notionalStepRuleSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalStepRule {" +
				"calculationPeriodDatesReference=" + this.calculationPeriodDatesReference + ", " +
				"stepFrequency=" + this.stepFrequency + ", " +
				"firstNotionalStepDate=" + this.firstNotionalStepDate + ", " +
				"lastNotionalStepDate=" + this.lastNotionalStepDate + ", " +
				"notionalStepAmount=" + this.notionalStepAmount + ", " +
				"notionalStepRuleSequence=" + this.notionalStepRuleSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of NotionalStepRule  ***********************/
	class NotionalStepRuleBuilderImpl implements NotionalStepRule.NotionalStepRuleBuilder {
	
		protected CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder calculationPeriodDatesReference;
		protected Frequency.FrequencyBuilder stepFrequency;
		protected Date firstNotionalStepDate;
		protected Date lastNotionalStepDate;
		protected BigDecimal notionalStepAmount;
		protected NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder notionalStepRuleSequence;
	
		public NotionalStepRuleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("calculationPeriodDatesReference")
		public CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder getCalculationPeriodDatesReference() {
			return calculationPeriodDatesReference;
		}
		
		@Override
		public CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder getOrCreateCalculationPeriodDatesReference() {
			CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder result;
			if (calculationPeriodDatesReference!=null) {
				result = calculationPeriodDatesReference;
			}
			else {
				result = calculationPeriodDatesReference = CalculationPeriodDatesReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("stepFrequency")
		public Frequency.FrequencyBuilder getStepFrequency() {
			return stepFrequency;
		}
		
		@Override
		public Frequency.FrequencyBuilder getOrCreateStepFrequency() {
			Frequency.FrequencyBuilder result;
			if (stepFrequency!=null) {
				result = stepFrequency;
			}
			else {
				result = stepFrequency = Frequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("firstNotionalStepDate")
		public Date getFirstNotionalStepDate() {
			return firstNotionalStepDate;
		}
		
		@Override
		@RosettaAttribute("lastNotionalStepDate")
		public Date getLastNotionalStepDate() {
			return lastNotionalStepDate;
		}
		
		@Override
		@RosettaAttribute("notionalStepAmount")
		public BigDecimal getNotionalStepAmount() {
			return notionalStepAmount;
		}
		
		@Override
		@RosettaAttribute("notionalStepRuleSequence")
		public NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder getNotionalStepRuleSequence() {
			return notionalStepRuleSequence;
		}
		
		@Override
		public NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder getOrCreateNotionalStepRuleSequence() {
			NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder result;
			if (notionalStepRuleSequence!=null) {
				result = notionalStepRuleSequence;
			}
			else {
				result = notionalStepRuleSequence = NotionalStepRuleSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDatesReference")
		public NotionalStepRule.NotionalStepRuleBuilder setCalculationPeriodDatesReference(CalculationPeriodDatesReference calculationPeriodDatesReference) {
			this.calculationPeriodDatesReference = calculationPeriodDatesReference==null?null:calculationPeriodDatesReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("stepFrequency")
		public NotionalStepRule.NotionalStepRuleBuilder setStepFrequency(Frequency stepFrequency) {
			this.stepFrequency = stepFrequency==null?null:stepFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("firstNotionalStepDate")
		public NotionalStepRule.NotionalStepRuleBuilder setFirstNotionalStepDate(Date firstNotionalStepDate) {
			this.firstNotionalStepDate = firstNotionalStepDate==null?null:firstNotionalStepDate;
			return this;
		}
		@Override
		@RosettaAttribute("lastNotionalStepDate")
		public NotionalStepRule.NotionalStepRuleBuilder setLastNotionalStepDate(Date lastNotionalStepDate) {
			this.lastNotionalStepDate = lastNotionalStepDate==null?null:lastNotionalStepDate;
			return this;
		}
		@Override
		@RosettaAttribute("notionalStepAmount")
		public NotionalStepRule.NotionalStepRuleBuilder setNotionalStepAmount(BigDecimal notionalStepAmount) {
			this.notionalStepAmount = notionalStepAmount==null?null:notionalStepAmount;
			return this;
		}
		@Override
		@RosettaAttribute("notionalStepRuleSequence")
		public NotionalStepRule.NotionalStepRuleBuilder setNotionalStepRuleSequence(NotionalStepRuleSequence notionalStepRuleSequence) {
			this.notionalStepRuleSequence = notionalStepRuleSequence==null?null:notionalStepRuleSequence.toBuilder();
			return this;
		}
		
		@Override
		public NotionalStepRule build() {
			return new NotionalStepRule.NotionalStepRuleImpl(this);
		}
		
		@Override
		public NotionalStepRule.NotionalStepRuleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalStepRule.NotionalStepRuleBuilder prune() {
			if (calculationPeriodDatesReference!=null && !calculationPeriodDatesReference.prune().hasData()) calculationPeriodDatesReference = null;
			if (stepFrequency!=null && !stepFrequency.prune().hasData()) stepFrequency = null;
			if (notionalStepRuleSequence!=null && !notionalStepRuleSequence.prune().hasData()) notionalStepRuleSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationPeriodDatesReference()!=null && getCalculationPeriodDatesReference().hasData()) return true;
			if (getStepFrequency()!=null && getStepFrequency().hasData()) return true;
			if (getFirstNotionalStepDate()!=null) return true;
			if (getLastNotionalStepDate()!=null) return true;
			if (getNotionalStepAmount()!=null) return true;
			if (getNotionalStepRuleSequence()!=null && getNotionalStepRuleSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalStepRule.NotionalStepRuleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NotionalStepRule.NotionalStepRuleBuilder o = (NotionalStepRule.NotionalStepRuleBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriodDatesReference(), o.getCalculationPeriodDatesReference(), this::setCalculationPeriodDatesReference);
			merger.mergeRosetta(getStepFrequency(), o.getStepFrequency(), this::setStepFrequency);
			merger.mergeRosetta(getNotionalStepRuleSequence(), o.getNotionalStepRuleSequence(), this::setNotionalStepRuleSequence);
			
			merger.mergeBasic(getFirstNotionalStepDate(), o.getFirstNotionalStepDate(), this::setFirstNotionalStepDate);
			merger.mergeBasic(getLastNotionalStepDate(), o.getLastNotionalStepDate(), this::setLastNotionalStepDate);
			merger.mergeBasic(getNotionalStepAmount(), o.getNotionalStepAmount(), this::setNotionalStepAmount);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalStepRule _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodDatesReference, _that.getCalculationPeriodDatesReference())) return false;
			if (!Objects.equals(stepFrequency, _that.getStepFrequency())) return false;
			if (!Objects.equals(firstNotionalStepDate, _that.getFirstNotionalStepDate())) return false;
			if (!Objects.equals(lastNotionalStepDate, _that.getLastNotionalStepDate())) return false;
			if (!Objects.equals(notionalStepAmount, _that.getNotionalStepAmount())) return false;
			if (!Objects.equals(notionalStepRuleSequence, _that.getNotionalStepRuleSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodDatesReference != null ? calculationPeriodDatesReference.hashCode() : 0);
			_result = 31 * _result + (stepFrequency != null ? stepFrequency.hashCode() : 0);
			_result = 31 * _result + (firstNotionalStepDate != null ? firstNotionalStepDate.hashCode() : 0);
			_result = 31 * _result + (lastNotionalStepDate != null ? lastNotionalStepDate.hashCode() : 0);
			_result = 31 * _result + (notionalStepAmount != null ? notionalStepAmount.hashCode() : 0);
			_result = 31 * _result + (notionalStepRuleSequence != null ? notionalStepRuleSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalStepRuleBuilder {" +
				"calculationPeriodDatesReference=" + this.calculationPeriodDatesReference + ", " +
				"stepFrequency=" + this.stepFrequency + ", " +
				"firstNotionalStepDate=" + this.firstNotionalStepDate + ", " +
				"lastNotionalStepDate=" + this.lastNotionalStepDate + ", " +
				"notionalStepAmount=" + this.notionalStepAmount + ", " +
				"notionalStepRuleSequence=" + this.notionalStepRuleSequence +
			'}';
		}
	}
}
