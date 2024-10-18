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
import fpml.confirmation.AmountSchedule;
import fpml.confirmation.AmountSchedule.AmountScheduleBuilder;
import fpml.confirmation.AmountSchedule.AmountScheduleBuilderImpl;
import fpml.confirmation.AmountSchedule.AmountScheduleImpl;
import fpml.confirmation.Currency;
import fpml.confirmation.Schedule;
import fpml.confirmation.Schedule.ScheduleBuilder;
import fpml.confirmation.Schedule.ScheduleBuilderImpl;
import fpml.confirmation.Schedule.ScheduleImpl;
import fpml.confirmation.Step;
import fpml.confirmation.meta.AmountScheduleMeta;
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
@RosettaDataType(value="AmountSchedule", builder=AmountSchedule.AmountScheduleBuilderImpl.class, version="${project.version}")
public interface AmountSchedule extends Schedule {

	AmountScheduleMeta metaData = new AmountScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The currency in which an amount is denominated.
	 */
	Currency getCurrency();

	/*********************** Build Methods  ***********************/
	AmountSchedule build();
	
	AmountSchedule.AmountScheduleBuilder toBuilder();
	
	static AmountSchedule.AmountScheduleBuilder builder() {
		return new AmountSchedule.AmountScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AmountSchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AmountSchedule> getType() {
		return AmountSchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, Step.class, getStep());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AmountScheduleBuilder extends AmountSchedule, Schedule.ScheduleBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		AmountSchedule.AmountScheduleBuilder setInitialValue(BigDecimal initialValue);
		AmountSchedule.AmountScheduleBuilder addStep(Step step0);
		AmountSchedule.AmountScheduleBuilder addStep(Step step1, int _idx);
		AmountSchedule.AmountScheduleBuilder addStep(List<? extends Step> step2);
		AmountSchedule.AmountScheduleBuilder setStep(List<? extends Step> step3);
		AmountSchedule.AmountScheduleBuilder setId(String id);
		AmountSchedule.AmountScheduleBuilder setCurrency(Currency currency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
		}
		

		AmountSchedule.AmountScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of AmountSchedule  ***********************/
	class AmountScheduleImpl extends Schedule.ScheduleImpl implements AmountSchedule {
		private final Currency currency;
		
		protected AmountScheduleImpl(AmountSchedule.AmountScheduleBuilder builder) {
			super(builder);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		public AmountSchedule build() {
			return this;
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder toBuilder() {
			AmountSchedule.AmountScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AmountSchedule.AmountScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AmountSchedule _that = getType().cast(o);
		
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
			return "AmountSchedule {" +
				"currency=" + this.currency +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AmountSchedule  ***********************/
	class AmountScheduleBuilderImpl extends Schedule.ScheduleBuilderImpl  implements AmountSchedule.AmountScheduleBuilder {
	
		protected Currency.CurrencyBuilder currency;
	
		public AmountScheduleBuilderImpl() {
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
		public AmountSchedule.AmountScheduleBuilder setInitialValue(BigDecimal initialValue) {
			this.initialValue = initialValue==null?null:initialValue;
			return this;
		}
		@Override
		@RosettaAttribute("step")
		public AmountSchedule.AmountScheduleBuilder addStep(Step step) {
			if (step!=null) this.step.add(step.toBuilder());
			return this;
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder addStep(Step step, int _idx) {
			getIndex(this.step, _idx, () -> step.toBuilder());
			return this;
		}
		@Override 
		public AmountSchedule.AmountScheduleBuilder addStep(List<? extends Step> steps) {
			if (steps != null) {
				for (Step toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AmountSchedule.AmountScheduleBuilder setStep(List<? extends Step> steps) {
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
		public AmountSchedule.AmountScheduleBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public AmountSchedule.AmountScheduleBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		
		@Override
		public AmountSchedule build() {
			return new AmountSchedule.AmountScheduleImpl(this);
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmountSchedule.AmountScheduleBuilder prune() {
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
		public AmountSchedule.AmountScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AmountSchedule.AmountScheduleBuilder o = (AmountSchedule.AmountScheduleBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AmountSchedule _that = getType().cast(o);
		
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
			return "AmountScheduleBuilder {" +
				"currency=" + this.currency +
			'}' + " " + super.toString();
		}
	}
}
