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
import com.rosetta.util.ListEquals;
import fpml.confirmation.CalculationAmount;
import fpml.confirmation.CalculationAmount.CalculationAmountBuilder;
import fpml.confirmation.CalculationAmount.CalculationAmountBuilderImpl;
import fpml.confirmation.CalculationAmount.CalculationAmountImpl;
import fpml.confirmation.Currency;
import fpml.confirmation.Money;
import fpml.confirmation.Money.MoneyBuilder;
import fpml.confirmation.Money.MoneyBuilderImpl;
import fpml.confirmation.Money.MoneyImpl;
import fpml.confirmation.Step;
import fpml.confirmation.meta.CalculationAmountMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CalculationAmount", builder=CalculationAmount.CalculationAmountBuilderImpl.class, version="${project.version}")
public interface CalculationAmount extends Money {

	CalculationAmountMeta metaData = new CalculationAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A schedule of step date and value pairs. On each step date the associated step value becomes effective. A list of steps may be ordered in the document by ascending step date. An FpML document containing an unordered list of steps is still regarded as a conformant document.
	 */
	List<? extends Step> getStep();

	/*********************** Build Methods  ***********************/
	CalculationAmount build();
	
	CalculationAmount.CalculationAmountBuilder toBuilder();
	
	static CalculationAmount.CalculationAmountBuilder builder() {
		return new CalculationAmount.CalculationAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationAmount> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CalculationAmount> getType() {
		return CalculationAmount.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processRosetta(path.newSubPath("step"), processor, Step.class, getStep());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationAmountBuilder extends CalculationAmount, Money.MoneyBuilder {
		Step.StepBuilder getOrCreateStep(int _index);
		List<? extends Step.StepBuilder> getStep();
		CalculationAmount.CalculationAmountBuilder setCurrency(Currency currency);
		CalculationAmount.CalculationAmountBuilder setId(String id);
		CalculationAmount.CalculationAmountBuilder setAmount(BigDecimal amount);
		CalculationAmount.CalculationAmountBuilder addStep(Step step0);
		CalculationAmount.CalculationAmountBuilder addStep(Step step1, int _idx);
		CalculationAmount.CalculationAmountBuilder addStep(List<? extends Step> step2);
		CalculationAmount.CalculationAmountBuilder setStep(List<? extends Step> step3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
		}
		

		CalculationAmount.CalculationAmountBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationAmount  ***********************/
	class CalculationAmountImpl extends Money.MoneyImpl implements CalculationAmount {
		private final List<? extends Step> step;
		
		protected CalculationAmountImpl(CalculationAmount.CalculationAmountBuilder builder) {
			super(builder);
			this.step = ofNullable(builder.getStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("step")
		public List<? extends Step> getStep() {
			return step;
		}
		
		@Override
		public CalculationAmount build() {
			return this;
		}
		
		@Override
		public CalculationAmount.CalculationAmountBuilder toBuilder() {
			CalculationAmount.CalculationAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationAmount.CalculationAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStep()).ifPresent(builder::setStep);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CalculationAmount _that = getType().cast(o);
		
			if (!ListEquals.listEquals(step, _that.getStep())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (step != null ? step.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationAmount {" +
				"step=" + this.step +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CalculationAmount  ***********************/
	class CalculationAmountBuilderImpl extends Money.MoneyBuilderImpl  implements CalculationAmount.CalculationAmountBuilder {
	
		protected List<Step.StepBuilder> step = new ArrayList<>();
	
		public CalculationAmountBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("step")
		public List<? extends Step.StepBuilder> getStep() {
			return step;
		}
		
		public Step.StepBuilder getOrCreateStep(int _index) {
		
			if (step==null) {
				this.step = new ArrayList<>();
			}
			Step.StepBuilder result;
			return getIndex(step, _index, () -> {
						Step.StepBuilder newStep = Step.builder();
						return newStep;
					});
		}
		
		@Override
		@RosettaAttribute("currency")
		public CalculationAmount.CalculationAmountBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CalculationAmount.CalculationAmountBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public CalculationAmount.CalculationAmountBuilder setAmount(BigDecimal amount) {
			this.amount = amount==null?null:amount;
			return this;
		}
		@Override
		public CalculationAmount.CalculationAmountBuilder addStep(Step step) {
			if (step!=null) this.step.add(step.toBuilder());
			return this;
		}
		
		@Override
		public CalculationAmount.CalculationAmountBuilder addStep(Step step, int _idx) {
			getIndex(this.step, _idx, () -> step.toBuilder());
			return this;
		}
		@Override 
		public CalculationAmount.CalculationAmountBuilder addStep(List<? extends Step> steps) {
			if (steps != null) {
				for (Step toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("step")
		public CalculationAmount.CalculationAmountBuilder setStep(List<? extends Step> steps) {
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
		public CalculationAmount build() {
			return new CalculationAmount.CalculationAmountImpl(this);
		}
		
		@Override
		public CalculationAmount.CalculationAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationAmount.CalculationAmountBuilder prune() {
			super.prune();
			step = step.stream().filter(b->b!=null).<Step.StepBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStep()!=null && getStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationAmount.CalculationAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CalculationAmount.CalculationAmountBuilder o = (CalculationAmount.CalculationAmountBuilder) other;
			
			merger.mergeRosetta(getStep(), o.getStep(), this::getOrCreateStep);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CalculationAmount _that = getType().cast(o);
		
			if (!ListEquals.listEquals(step, _that.getStep())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (step != null ? step.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationAmountBuilder {" +
				"step=" + this.step +
			'}' + " " + super.toString();
		}
	}
}
