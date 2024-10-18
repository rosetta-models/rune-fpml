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
import fpml.confirmation.FxForwardStrikePrice;
import fpml.confirmation.FxForwardStrikePrice.FxForwardStrikePriceBuilder;
import fpml.confirmation.FxForwardStrikePrice.FxForwardStrikePriceBuilderImpl;
import fpml.confirmation.FxForwardStrikePrice.FxForwardStrikePriceImpl;
import fpml.confirmation.QuoteBasisEnum;
import fpml.confirmation.Step;
import fpml.confirmation.meta.FxForwardStrikePriceMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type that describes the rate of exchange between the two currencies of the leg of a deal.
 * @version ${project.version}
 */
@RosettaDataType(value="FxForwardStrikePrice", builder=FxForwardStrikePrice.FxForwardStrikePriceBuilderImpl.class, version="${project.version}")
public interface FxForwardStrikePrice extends FxAccrualStrike {

	FxForwardStrikePriceMeta metaData = new FxForwardStrikePriceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Quoted Currency Pair that is used across the product.
	 */
	QuoteBasisEnum getQuoteBasis();

	/*********************** Build Methods  ***********************/
	FxForwardStrikePrice build();
	
	FxForwardStrikePrice.FxForwardStrikePriceBuilder toBuilder();
	
	static FxForwardStrikePrice.FxForwardStrikePriceBuilder builder() {
		return new FxForwardStrikePrice.FxForwardStrikePriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxForwardStrikePrice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxForwardStrikePrice> getType() {
		return FxForwardStrikePrice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, Step.class, getStep());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxForwardStrikePriceBuilder extends FxForwardStrikePrice, FxAccrualStrike.FxAccrualStrikeBuilder {
		FxForwardStrikePrice.FxForwardStrikePriceBuilder setInitialValue(BigDecimal initialValue);
		FxForwardStrikePrice.FxForwardStrikePriceBuilder addStep(Step step0);
		FxForwardStrikePrice.FxForwardStrikePriceBuilder addStep(Step step1, int _idx);
		FxForwardStrikePrice.FxForwardStrikePriceBuilder addStep(List<? extends Step> step2);
		FxForwardStrikePrice.FxForwardStrikePriceBuilder setStep(List<? extends Step> step3);
		FxForwardStrikePrice.FxForwardStrikePriceBuilder setId(String id);
		FxForwardStrikePrice.FxForwardStrikePriceBuilder setQuoteBasis(QuoteBasisEnum quoteBasis);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
		}
		

		FxForwardStrikePrice.FxForwardStrikePriceBuilder prune();
	}

	/*********************** Immutable Implementation of FxForwardStrikePrice  ***********************/
	class FxForwardStrikePriceImpl extends FxAccrualStrike.FxAccrualStrikeImpl implements FxForwardStrikePrice {
		private final QuoteBasisEnum quoteBasis;
		
		protected FxForwardStrikePriceImpl(FxForwardStrikePrice.FxForwardStrikePriceBuilder builder) {
			super(builder);
			this.quoteBasis = builder.getQuoteBasis();
		}
		
		@Override
		@RosettaAttribute("quoteBasis")
		public QuoteBasisEnum getQuoteBasis() {
			return quoteBasis;
		}
		
		@Override
		public FxForwardStrikePrice build() {
			return this;
		}
		
		@Override
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder toBuilder() {
			FxForwardStrikePrice.FxForwardStrikePriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxForwardStrikePrice.FxForwardStrikePriceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getQuoteBasis()).ifPresent(builder::setQuoteBasis);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxForwardStrikePrice _that = getType().cast(o);
		
			if (!Objects.equals(quoteBasis, _that.getQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quoteBasis != null ? quoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxForwardStrikePrice {" +
				"quoteBasis=" + this.quoteBasis +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxForwardStrikePrice  ***********************/
	class FxForwardStrikePriceBuilderImpl extends FxAccrualStrike.FxAccrualStrikeBuilderImpl  implements FxForwardStrikePrice.FxForwardStrikePriceBuilder {
	
		protected QuoteBasisEnum quoteBasis;
	
		public FxForwardStrikePriceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("quoteBasis")
		public QuoteBasisEnum getQuoteBasis() {
			return quoteBasis;
		}
		
		@Override
		@RosettaAttribute("initialValue")
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder setInitialValue(BigDecimal initialValue) {
			this.initialValue = initialValue==null?null:initialValue;
			return this;
		}
		@Override
		@RosettaAttribute("step")
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder addStep(Step step) {
			if (step!=null) this.step.add(step.toBuilder());
			return this;
		}
		
		@Override
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder addStep(Step step, int _idx) {
			getIndex(this.step, _idx, () -> step.toBuilder());
			return this;
		}
		@Override 
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder addStep(List<? extends Step> steps) {
			if (steps != null) {
				for (Step toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder setStep(List<? extends Step> steps) {
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
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("quoteBasis")
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder setQuoteBasis(QuoteBasisEnum quoteBasis) {
			this.quoteBasis = quoteBasis==null?null:quoteBasis;
			return this;
		}
		
		@Override
		public FxForwardStrikePrice build() {
			return new FxForwardStrikePrice.FxForwardStrikePriceImpl(this);
		}
		
		@Override
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getQuoteBasis()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxForwardStrikePrice.FxForwardStrikePriceBuilder o = (FxForwardStrikePrice.FxForwardStrikePriceBuilder) other;
			
			
			merger.mergeBasic(getQuoteBasis(), o.getQuoteBasis(), this::setQuoteBasis);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxForwardStrikePrice _that = getType().cast(o);
		
			if (!Objects.equals(quoteBasis, _that.getQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quoteBasis != null ? quoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxForwardStrikePriceBuilder {" +
				"quoteBasis=" + this.quoteBasis +
			'}' + " " + super.toString();
		}
	}
}
