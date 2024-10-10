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
import fpml.confirmation.Currency;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder;
import fpml.confirmation.NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilderImpl;
import fpml.confirmation.NonNegativeAmountSchedule.NonNegativeAmountScheduleImpl;
import fpml.confirmation.NonNegativeSchedule;
import fpml.confirmation.NonNegativeSchedule.NonNegativeScheduleBuilder;
import fpml.confirmation.NonNegativeSchedule.NonNegativeScheduleBuilderImpl;
import fpml.confirmation.NonNegativeSchedule.NonNegativeScheduleImpl;
import fpml.confirmation.NonNegativeStep;
import fpml.confirmation.meta.NonNegativeAmountScheduleMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining a currency amount or a currency amount schedule.
 * @version ${project.version}
 */
@RosettaDataType(value="NonNegativeAmountSchedule", builder=NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilderImpl.class, version="${project.version}")
public interface NonNegativeAmountSchedule extends NonNegativeSchedule {

	NonNegativeAmountScheduleMeta metaData = new NonNegativeAmountScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The currency in which an amount is denominated.
	 */
	Currency getCurrency();

	/*********************** Build Methods  ***********************/
	NonNegativeAmountSchedule build();
	
	NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder toBuilder();
	
	static NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder builder() {
		return new NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonNegativeAmountSchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NonNegativeAmountSchedule> getType() {
		return NonNegativeAmountSchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, NonNegativeStep.class, getStep());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonNegativeAmountScheduleBuilder extends NonNegativeAmountSchedule, NonNegativeSchedule.NonNegativeScheduleBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder setInitialValue(BigDecimal initialValue);
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder addStep(NonNegativeStep step0);
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder addStep(NonNegativeStep step1, int _idx);
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder addStep(List<? extends NonNegativeStep> step2);
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder setStep(List<? extends NonNegativeStep> step3);
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder setId(String id);
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder setCurrency(Currency currency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, NonNegativeStep.NonNegativeStepBuilder.class, getStep());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
		}
		

		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of NonNegativeAmountSchedule  ***********************/
	class NonNegativeAmountScheduleImpl extends NonNegativeSchedule.NonNegativeScheduleImpl implements NonNegativeAmountSchedule {
		private final Currency currency;
		
		protected NonNegativeAmountScheduleImpl(NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder builder) {
			super(builder);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		public NonNegativeAmountSchedule build() {
			return this;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder toBuilder() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonNegativeAmountSchedule _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativeAmountSchedule {" +
				"currency=" + this.currency +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NonNegativeAmountSchedule  ***********************/
	class NonNegativeAmountScheduleBuilderImpl extends NonNegativeSchedule.NonNegativeScheduleBuilderImpl  implements NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder {
	
		protected Currency.CurrencyBuilder currency;
	
		public NonNegativeAmountScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialValue")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder setInitialValue(BigDecimal initialValue) {
			this.initialValue = initialValue==null?null:initialValue;
			return this;
		}
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder addStep(NonNegativeStep step) {
			if (step!=null) this.step.add(step.toBuilder());
			return this;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder addStep(NonNegativeStep step, int _idx) {
			getIndex(this.step, _idx, () -> step.toBuilder());
			return this;
		}
		@Override 
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder addStep(List<? extends NonNegativeStep> steps) {
			if (steps != null) {
				for (NonNegativeStep toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("step")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder setStep(List<? extends NonNegativeStep> steps) {
			if (steps == null)  {
				this.step = new ArrayList<>();
			}
			else {
				this.step = steps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		
		@Override
		public NonNegativeAmountSchedule build() {
			return new NonNegativeAmountSchedule.NonNegativeAmountScheduleImpl(this);
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder prune() {
			super.prune();
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder o = (NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonNegativeAmountSchedule _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonNegativeAmountScheduleBuilder {" +
				"currency=" + this.currency +
			'}' + " " + super.toString();
		}
	}
}
