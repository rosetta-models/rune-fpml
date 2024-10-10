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
import fpml.confirmation.FxCounterCurrencyAmount;
import fpml.confirmation.FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder;
import fpml.confirmation.FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilderImpl;
import fpml.confirmation.FxCounterCurrencyAmount.FxCounterCurrencyAmountImpl;
import fpml.confirmation.FxStrikeReference;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder;
import fpml.confirmation.NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilderImpl;
import fpml.confirmation.NonNegativeAmountSchedule.NonNegativeAmountScheduleImpl;
import fpml.confirmation.NonNegativeStep;
import fpml.confirmation.meta.FxCounterCurrencyAmountMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxCounterCurrencyAmount", builder=FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilderImpl.class, version="${project.version}")
public interface FxCounterCurrencyAmount extends NonNegativeAmountSchedule {

	FxCounterCurrencyAmountMeta metaData = new FxCounterCurrencyAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * In case of multiple counter currency notionals, a strike reference to the appropriate strike may be provided.
	 */
	FxStrikeReference getStrikeReference();

	/*********************** Build Methods  ***********************/
	FxCounterCurrencyAmount build();
	
	FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder toBuilder();
	
	static FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder builder() {
		return new FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxCounterCurrencyAmount> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxCounterCurrencyAmount> getType() {
		return FxCounterCurrencyAmount.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, NonNegativeStep.class, getStep());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("strikeReference"), processor, FxStrikeReference.class, getStrikeReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxCounterCurrencyAmountBuilder extends FxCounterCurrencyAmount, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder {
		FxStrikeReference.FxStrikeReferenceBuilder getOrCreateStrikeReference();
		FxStrikeReference.FxStrikeReferenceBuilder getStrikeReference();
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder setInitialValue(BigDecimal initialValue);
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder addStep(NonNegativeStep step0);
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder addStep(NonNegativeStep step1, int _idx);
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder addStep(List<? extends NonNegativeStep> step2);
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder setStep(List<? extends NonNegativeStep> step3);
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder setId(String id);
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder setCurrency(Currency currency);
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder setStrikeReference(FxStrikeReference strikeReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, NonNegativeStep.NonNegativeStepBuilder.class, getStep());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("strikeReference"), processor, FxStrikeReference.FxStrikeReferenceBuilder.class, getStrikeReference());
		}
		

		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder prune();
	}

	/*********************** Immutable Implementation of FxCounterCurrencyAmount  ***********************/
	class FxCounterCurrencyAmountImpl extends NonNegativeAmountSchedule.NonNegativeAmountScheduleImpl implements FxCounterCurrencyAmount {
		private final FxStrikeReference strikeReference;
		
		protected FxCounterCurrencyAmountImpl(FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder builder) {
			super(builder);
			this.strikeReference = ofNullable(builder.getStrikeReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strikeReference")
		public FxStrikeReference getStrikeReference() {
			return strikeReference;
		}
		
		@Override
		public FxCounterCurrencyAmount build() {
			return this;
		}
		
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder toBuilder() {
			FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStrikeReference()).ifPresent(builder::setStrikeReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxCounterCurrencyAmount _that = getType().cast(o);
		
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCounterCurrencyAmount {" +
				"strikeReference=" + this.strikeReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxCounterCurrencyAmount  ***********************/
	class FxCounterCurrencyAmountBuilderImpl extends NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilderImpl  implements FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder {
	
		protected FxStrikeReference.FxStrikeReferenceBuilder strikeReference;
	
		public FxCounterCurrencyAmountBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("strikeReference")
		public FxStrikeReference.FxStrikeReferenceBuilder getStrikeReference() {
			return strikeReference;
		}
		
		@Override
		public FxStrikeReference.FxStrikeReferenceBuilder getOrCreateStrikeReference() {
			FxStrikeReference.FxStrikeReferenceBuilder result;
			if (strikeReference!=null) {
				result = strikeReference;
			}
			else {
				result = strikeReference = FxStrikeReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialValue")
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder setInitialValue(BigDecimal initialValue) {
			this.initialValue = initialValue==null?null:initialValue;
			return this;
		}
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder addStep(NonNegativeStep step) {
			if (step!=null) this.step.add(step.toBuilder());
			return this;
		}
		
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder addStep(NonNegativeStep step, int _idx) {
			getIndex(this.step, _idx, () -> step.toBuilder());
			return this;
		}
		@Override 
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder addStep(List<? extends NonNegativeStep> steps) {
			if (steps != null) {
				for (NonNegativeStep toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("step")
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder setStep(List<? extends NonNegativeStep> steps) {
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
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strikeReference")
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder setStrikeReference(FxStrikeReference strikeReference) {
			this.strikeReference = strikeReference==null?null:strikeReference.toBuilder();
			return this;
		}
		
		@Override
		public FxCounterCurrencyAmount build() {
			return new FxCounterCurrencyAmount.FxCounterCurrencyAmountImpl(this);
		}
		
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder prune() {
			super.prune();
			if (strikeReference!=null && !strikeReference.prune().hasData()) strikeReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStrikeReference()!=null && getStrikeReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder o = (FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder) other;
			
			merger.mergeRosetta(getStrikeReference(), o.getStrikeReference(), this::setStrikeReference);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxCounterCurrencyAmount _that = getType().cast(o);
		
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCounterCurrencyAmountBuilder {" +
				"strikeReference=" + this.strikeReference +
			'}' + " " + super.toString();
		}
	}
}
