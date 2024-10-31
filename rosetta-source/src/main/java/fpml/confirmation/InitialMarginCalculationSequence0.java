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
import fpml.confirmation.InitialMarginCalculationSequence0;
import fpml.confirmation.InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder;
import fpml.confirmation.InitialMarginCalculationSequence0.InitialMarginCalculationSequence0BuilderImpl;
import fpml.confirmation.InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Impl;
import fpml.confirmation.meta.InitialMarginCalculationSequence0Meta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="InitialMarginCalculationSequence0", builder=InitialMarginCalculationSequence0.InitialMarginCalculationSequence0BuilderImpl.class, version="${project.version}")
public interface InitialMarginCalculationSequence0 extends RosettaModelObject {

	InitialMarginCalculationSequence0Meta metaData = new InitialMarginCalculationSequence0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An element defining an initial margin expressed as a ratio of the Market Value of the collateral to the Purchase Price. A default value of initial margin ratio of 1.00 means there is no margin and thus no risk related with the collateral. See GMRA 2000 paragraph 2(z) and GMRA 2011 paragraph 2(bb).
	 */
	BigDecimal getMarginRatio();
	/**
	 * An element defining a margin ratio threshold which is the value above (when it&#39;s lower than initial margin ratio) or below (when it&#39;s higher than initial margin ratio) which parties agree they will not call a margin from each other.
	 */
	List<BigDecimal> getMarginRatioThreshold();

	/*********************** Build Methods  ***********************/
	InitialMarginCalculationSequence0 build();
	
	InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder toBuilder();
	
	static InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder builder() {
		return new InitialMarginCalculationSequence0.InitialMarginCalculationSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InitialMarginCalculationSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InitialMarginCalculationSequence0> getType() {
		return InitialMarginCalculationSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("marginRatio"), BigDecimal.class, getMarginRatio(), this);
		processor.processBasic(path.newSubPath("marginRatioThreshold"), BigDecimal.class, getMarginRatioThreshold(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InitialMarginCalculationSequence0Builder extends InitialMarginCalculationSequence0, RosettaModelObjectBuilder {
		InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder setMarginRatio(BigDecimal marginRatio);
		InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder addMarginRatioThreshold(BigDecimal marginRatioThreshold0);
		InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder addMarginRatioThreshold(BigDecimal marginRatioThreshold1, int _idx);
		InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder addMarginRatioThreshold(List<BigDecimal> marginRatioThreshold2);
		InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder setMarginRatioThreshold(List<BigDecimal> marginRatioThreshold3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("marginRatio"), BigDecimal.class, getMarginRatio(), this);
			processor.processBasic(path.newSubPath("marginRatioThreshold"), BigDecimal.class, getMarginRatioThreshold(), this);
		}
		

		InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder prune();
	}

	/*********************** Immutable Implementation of InitialMarginCalculationSequence0  ***********************/
	class InitialMarginCalculationSequence0Impl implements InitialMarginCalculationSequence0 {
		private final BigDecimal marginRatio;
		private final List<BigDecimal> marginRatioThreshold;
		
		protected InitialMarginCalculationSequence0Impl(InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder builder) {
			this.marginRatio = builder.getMarginRatio();
			this.marginRatioThreshold = ofNullable(builder.getMarginRatioThreshold()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("marginRatio")
		public BigDecimal getMarginRatio() {
			return marginRatio;
		}
		
		@Override
		@RosettaAttribute("marginRatioThreshold")
		public List<BigDecimal> getMarginRatioThreshold() {
			return marginRatioThreshold;
		}
		
		@Override
		public InitialMarginCalculationSequence0 build() {
			return this;
		}
		
		@Override
		public InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder toBuilder() {
			InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder builder) {
			ofNullable(getMarginRatio()).ifPresent(builder::setMarginRatio);
			ofNullable(getMarginRatioThreshold()).ifPresent(builder::setMarginRatioThreshold);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InitialMarginCalculationSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(marginRatio, _that.getMarginRatio())) return false;
			if (!ListEquals.listEquals(marginRatioThreshold, _that.getMarginRatioThreshold())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (marginRatio != null ? marginRatio.hashCode() : 0);
			_result = 31 * _result + (marginRatioThreshold != null ? marginRatioThreshold.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InitialMarginCalculationSequence0 {" +
				"marginRatio=" + this.marginRatio + ", " +
				"marginRatioThreshold=" + this.marginRatioThreshold +
			'}';
		}
	}

	/*********************** Builder Implementation of InitialMarginCalculationSequence0  ***********************/
	class InitialMarginCalculationSequence0BuilderImpl implements InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder {
	
		protected BigDecimal marginRatio;
		protected List<BigDecimal> marginRatioThreshold = new ArrayList<>();
	
		public InitialMarginCalculationSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("marginRatio")
		public BigDecimal getMarginRatio() {
			return marginRatio;
		}
		
		@Override
		@RosettaAttribute("marginRatioThreshold")
		public List<BigDecimal> getMarginRatioThreshold() {
			return marginRatioThreshold;
		}
		
		@Override
		@RosettaAttribute("marginRatio")
		public InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder setMarginRatio(BigDecimal marginRatio) {
			this.marginRatio = marginRatio==null?null:marginRatio;
			return this;
		}
		@Override
		@RosettaAttribute("marginRatioThreshold")
		public InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder addMarginRatioThreshold(BigDecimal marginRatioThreshold) {
			if (marginRatioThreshold!=null) this.marginRatioThreshold.add(marginRatioThreshold);
			return this;
		}
		
		@Override
		public InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder addMarginRatioThreshold(BigDecimal marginRatioThreshold, int _idx) {
			getIndex(this.marginRatioThreshold, _idx, () -> marginRatioThreshold);
			return this;
		}
		@Override 
		public InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder addMarginRatioThreshold(List<BigDecimal> marginRatioThresholds) {
			if (marginRatioThresholds != null) {
				for (BigDecimal toAdd : marginRatioThresholds) {
					this.marginRatioThreshold.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder setMarginRatioThreshold(List<BigDecimal> marginRatioThresholds) {
			if (marginRatioThresholds == null)  {
				this.marginRatioThreshold = new ArrayList<>();
			}
			else {
				this.marginRatioThreshold = marginRatioThresholds.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public InitialMarginCalculationSequence0 build() {
			return new InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Impl(this);
		}
		
		@Override
		public InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMarginRatio()!=null) return true;
			if (getMarginRatioThreshold()!=null && !getMarginRatioThreshold().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder o = (InitialMarginCalculationSequence0.InitialMarginCalculationSequence0Builder) other;
			
			
			merger.mergeBasic(getMarginRatio(), o.getMarginRatio(), this::setMarginRatio);
			merger.mergeBasic(getMarginRatioThreshold(), o.getMarginRatioThreshold(), (Consumer<BigDecimal>) this::addMarginRatioThreshold);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InitialMarginCalculationSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(marginRatio, _that.getMarginRatio())) return false;
			if (!ListEquals.listEquals(marginRatioThreshold, _that.getMarginRatioThreshold())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (marginRatio != null ? marginRatio.hashCode() : 0);
			_result = 31 * _result + (marginRatioThreshold != null ? marginRatioThreshold.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InitialMarginCalculationSequence0Builder {" +
				"marginRatio=" + this.marginRatio + ", " +
				"marginRatioThreshold=" + this.marginRatioThreshold +
			'}';
		}
	}
}
