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
import fpml.confirmation.FxAccrualStrike;
import fpml.confirmation.FxAccrualStrike.FxAccrualStrikeBuilder;
import fpml.confirmation.FxAccrualStrike.FxAccrualStrikeBuilderImpl;
import fpml.confirmation.FxAccrualStrike.FxAccrualStrikeImpl;
import fpml.confirmation.FxOptionStrikePrice;
import fpml.confirmation.FxOptionStrikePrice.FxOptionStrikePriceBuilder;
import fpml.confirmation.FxOptionStrikePrice.FxOptionStrikePriceBuilderImpl;
import fpml.confirmation.FxOptionStrikePrice.FxOptionStrikePriceImpl;
import fpml.confirmation.Step;
import fpml.confirmation.StrikeQuoteBasisEnum;
import fpml.confirmation.meta.FxOptionStrikePriceMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type that describes the rate of exchange at which the option has been struck.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxOptionStrikePrice", builder=FxOptionStrikePrice.FxOptionStrikePriceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxOptionStrikePrice extends FxAccrualStrike {

	FxOptionStrikePriceMeta metaData = new FxOptionStrikePriceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The method by which the strike rate is quoted.
	 */
	StrikeQuoteBasisEnum getStrikeQuoteBasis();

	/*********************** Build Methods  ***********************/
	FxOptionStrikePrice build();
	
	FxOptionStrikePrice.FxOptionStrikePriceBuilder toBuilder();
	
	static FxOptionStrikePrice.FxOptionStrikePriceBuilder builder() {
		return new FxOptionStrikePrice.FxOptionStrikePriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxOptionStrikePrice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxOptionStrikePrice> getType() {
		return FxOptionStrikePrice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, Step.class, getStep());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("strikeQuoteBasis"), StrikeQuoteBasisEnum.class, getStrikeQuoteBasis(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxOptionStrikePriceBuilder extends FxOptionStrikePrice, FxAccrualStrike.FxAccrualStrikeBuilder {
		FxOptionStrikePrice.FxOptionStrikePriceBuilder setInitialValue(BigDecimal initialValue);
		FxOptionStrikePrice.FxOptionStrikePriceBuilder addStep(Step step0);
		FxOptionStrikePrice.FxOptionStrikePriceBuilder addStep(Step step1, int _idx);
		FxOptionStrikePrice.FxOptionStrikePriceBuilder addStep(List<? extends Step> step2);
		FxOptionStrikePrice.FxOptionStrikePriceBuilder setStep(List<? extends Step> step3);
		FxOptionStrikePrice.FxOptionStrikePriceBuilder setId(String id);
		FxOptionStrikePrice.FxOptionStrikePriceBuilder setStrikeQuoteBasis(StrikeQuoteBasisEnum strikeQuoteBasis);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("strikeQuoteBasis"), StrikeQuoteBasisEnum.class, getStrikeQuoteBasis(), this);
		}
		

		FxOptionStrikePrice.FxOptionStrikePriceBuilder prune();
	}

	/*********************** Immutable Implementation of FxOptionStrikePrice  ***********************/
	class FxOptionStrikePriceImpl extends FxAccrualStrike.FxAccrualStrikeImpl implements FxOptionStrikePrice {
		private final StrikeQuoteBasisEnum strikeQuoteBasis;
		
		protected FxOptionStrikePriceImpl(FxOptionStrikePrice.FxOptionStrikePriceBuilder builder) {
			super(builder);
			this.strikeQuoteBasis = builder.getStrikeQuoteBasis();
		}
		
		@Override
		@RosettaAttribute("strikeQuoteBasis")
		public StrikeQuoteBasisEnum getStrikeQuoteBasis() {
			return strikeQuoteBasis;
		}
		
		@Override
		public FxOptionStrikePrice build() {
			return this;
		}
		
		@Override
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder toBuilder() {
			FxOptionStrikePrice.FxOptionStrikePriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxOptionStrikePrice.FxOptionStrikePriceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStrikeQuoteBasis()).ifPresent(builder::setStrikeQuoteBasis);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxOptionStrikePrice _that = getType().cast(o);
		
			if (!Objects.equals(strikeQuoteBasis, _that.getStrikeQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strikeQuoteBasis != null ? strikeQuoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOptionStrikePrice {" +
				"strikeQuoteBasis=" + this.strikeQuoteBasis +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxOptionStrikePrice  ***********************/
	class FxOptionStrikePriceBuilderImpl extends FxAccrualStrike.FxAccrualStrikeBuilderImpl  implements FxOptionStrikePrice.FxOptionStrikePriceBuilder {
	
		protected StrikeQuoteBasisEnum strikeQuoteBasis;
	
		public FxOptionStrikePriceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("strikeQuoteBasis")
		public StrikeQuoteBasisEnum getStrikeQuoteBasis() {
			return strikeQuoteBasis;
		}
		
		@Override
		@RosettaAttribute("initialValue")
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder setInitialValue(BigDecimal initialValue) {
			this.initialValue = initialValue==null?null:initialValue;
			return this;
		}
		@Override
		@RosettaAttribute("step")
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder addStep(Step step) {
			if (step!=null) this.step.add(step.toBuilder());
			return this;
		}
		
		@Override
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder addStep(Step step, int _idx) {
			getIndex(this.step, _idx, () -> step.toBuilder());
			return this;
		}
		@Override 
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder addStep(List<? extends Step> steps) {
			if (steps != null) {
				for (Step toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder setStep(List<? extends Step> steps) {
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
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("strikeQuoteBasis")
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder setStrikeQuoteBasis(StrikeQuoteBasisEnum strikeQuoteBasis) {
			this.strikeQuoteBasis = strikeQuoteBasis==null?null:strikeQuoteBasis;
			return this;
		}
		
		@Override
		public FxOptionStrikePrice build() {
			return new FxOptionStrikePrice.FxOptionStrikePriceImpl(this);
		}
		
		@Override
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStrikeQuoteBasis()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxOptionStrikePrice.FxOptionStrikePriceBuilder o = (FxOptionStrikePrice.FxOptionStrikePriceBuilder) other;
			
			
			merger.mergeBasic(getStrikeQuoteBasis(), o.getStrikeQuoteBasis(), this::setStrikeQuoteBasis);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxOptionStrikePrice _that = getType().cast(o);
		
			if (!Objects.equals(strikeQuoteBasis, _that.getStrikeQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strikeQuoteBasis != null ? strikeQuoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOptionStrikePriceBuilder {" +
				"strikeQuoteBasis=" + this.strikeQuoteBasis +
			'}' + " " + super.toString();
		}
	}
}
