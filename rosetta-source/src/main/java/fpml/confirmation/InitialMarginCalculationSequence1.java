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
import fpml.confirmation.InitialMarginCalculationSequence1;
import fpml.confirmation.InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder;
import fpml.confirmation.InitialMarginCalculationSequence1.InitialMarginCalculationSequence1BuilderImpl;
import fpml.confirmation.InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Impl;
import fpml.confirmation.meta.InitialMarginCalculationSequence1Meta;
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
@RosettaDataType(value="InitialMarginCalculationSequence1", builder=InitialMarginCalculationSequence1.InitialMarginCalculationSequence1BuilderImpl.class, version="${project.version}")
public interface InitialMarginCalculationSequence1 extends RosettaModelObject {

	InitialMarginCalculationSequence1Meta metaData = new InitialMarginCalculationSequence1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An element defining a haircut expressed as the percentage difference between the Market Value of the collateral and the Purchase Price of the repo and calculated as 100 multiplied by a ratio of the difference between the Market Value of the collateral and the Purchase Price of the repo to the Market Value of the collateral. Haircut is alternative way to adjust the value of collateral sold in a repurchase agreement to initial margin ratio. Because an initial margin is a percentage of the Purchase Price, while a haircut is a percentage of the Market Value of collateral, the arithmetic of initial margins and haircuts is slightly different. For example, an initial margin of 102% is not equivalent to a haircut of 2%, but to 1.961% (ie 100/102%). See GMRA 2011 paragraph 2(aa).
	 */
	BigDecimal getHaircut();
	/**
	 * An element defining a haircut percentage threshold which is the value above (when it&#39;s lower than initial haircut) or below (when it&#39;s higher than initial haircut) which parties agree they will not call a margin from each other.
	 */
	List<BigDecimal> getHaircutThreshold();

	/*********************** Build Methods  ***********************/
	InitialMarginCalculationSequence1 build();
	
	InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder toBuilder();
	
	static InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder builder() {
		return new InitialMarginCalculationSequence1.InitialMarginCalculationSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InitialMarginCalculationSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InitialMarginCalculationSequence1> getType() {
		return InitialMarginCalculationSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("haircut"), BigDecimal.class, getHaircut(), this);
		processor.processBasic(path.newSubPath("haircutThreshold"), BigDecimal.class, getHaircutThreshold(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InitialMarginCalculationSequence1Builder extends InitialMarginCalculationSequence1, RosettaModelObjectBuilder {
		InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder setHaircut(BigDecimal haircut);
		InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder addHaircutThreshold(BigDecimal haircutThreshold0);
		InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder addHaircutThreshold(BigDecimal haircutThreshold1, int _idx);
		InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder addHaircutThreshold(List<BigDecimal> haircutThreshold2);
		InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder setHaircutThreshold(List<BigDecimal> haircutThreshold3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("haircut"), BigDecimal.class, getHaircut(), this);
			processor.processBasic(path.newSubPath("haircutThreshold"), BigDecimal.class, getHaircutThreshold(), this);
		}
		

		InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder prune();
	}

	/*********************** Immutable Implementation of InitialMarginCalculationSequence1  ***********************/
	class InitialMarginCalculationSequence1Impl implements InitialMarginCalculationSequence1 {
		private final BigDecimal haircut;
		private final List<BigDecimal> haircutThreshold;
		
		protected InitialMarginCalculationSequence1Impl(InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder builder) {
			this.haircut = builder.getHaircut();
			this.haircutThreshold = ofNullable(builder.getHaircutThreshold()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("haircut")
		public BigDecimal getHaircut() {
			return haircut;
		}
		
		@Override
		@RosettaAttribute("haircutThreshold")
		public List<BigDecimal> getHaircutThreshold() {
			return haircutThreshold;
		}
		
		@Override
		public InitialMarginCalculationSequence1 build() {
			return this;
		}
		
		@Override
		public InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder toBuilder() {
			InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder builder) {
			ofNullable(getHaircut()).ifPresent(builder::setHaircut);
			ofNullable(getHaircutThreshold()).ifPresent(builder::setHaircutThreshold);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InitialMarginCalculationSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(haircut, _that.getHaircut())) return false;
			if (!ListEquals.listEquals(haircutThreshold, _that.getHaircutThreshold())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (haircut != null ? haircut.hashCode() : 0);
			_result = 31 * _result + (haircutThreshold != null ? haircutThreshold.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InitialMarginCalculationSequence1 {" +
				"haircut=" + this.haircut + ", " +
				"haircutThreshold=" + this.haircutThreshold +
			'}';
		}
	}

	/*********************** Builder Implementation of InitialMarginCalculationSequence1  ***********************/
	class InitialMarginCalculationSequence1BuilderImpl implements InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder {
	
		protected BigDecimal haircut;
		protected List<BigDecimal> haircutThreshold = new ArrayList<>();
	
		public InitialMarginCalculationSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("haircut")
		public BigDecimal getHaircut() {
			return haircut;
		}
		
		@Override
		@RosettaAttribute("haircutThreshold")
		public List<BigDecimal> getHaircutThreshold() {
			return haircutThreshold;
		}
		
		@Override
		@RosettaAttribute("haircut")
		public InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder setHaircut(BigDecimal haircut) {
			this.haircut = haircut==null?null:haircut;
			return this;
		}
		@Override
		public InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder addHaircutThreshold(BigDecimal haircutThreshold) {
			if (haircutThreshold!=null) this.haircutThreshold.add(haircutThreshold);
			return this;
		}
		
		@Override
		public InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder addHaircutThreshold(BigDecimal haircutThreshold, int _idx) {
			getIndex(this.haircutThreshold, _idx, () -> haircutThreshold);
			return this;
		}
		@Override 
		public InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder addHaircutThreshold(List<BigDecimal> haircutThresholds) {
			if (haircutThresholds != null) {
				for (BigDecimal toAdd : haircutThresholds) {
					this.haircutThreshold.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("haircutThreshold")
		public InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder setHaircutThreshold(List<BigDecimal> haircutThresholds) {
			if (haircutThresholds == null)  {
				this.haircutThreshold = new ArrayList<>();
			}
			else {
				this.haircutThreshold = haircutThresholds.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public InitialMarginCalculationSequence1 build() {
			return new InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Impl(this);
		}
		
		@Override
		public InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getHaircut()!=null) return true;
			if (getHaircutThreshold()!=null && !getHaircutThreshold().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder o = (InitialMarginCalculationSequence1.InitialMarginCalculationSequence1Builder) other;
			
			
			merger.mergeBasic(getHaircut(), o.getHaircut(), this::setHaircut);
			merger.mergeBasic(getHaircutThreshold(), o.getHaircutThreshold(), (Consumer<BigDecimal>) this::addHaircutThreshold);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InitialMarginCalculationSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(haircut, _that.getHaircut())) return false;
			if (!ListEquals.listEquals(haircutThreshold, _that.getHaircutThreshold())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (haircut != null ? haircut.hashCode() : 0);
			_result = 31 * _result + (haircutThreshold != null ? haircutThreshold.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InitialMarginCalculationSequence1Builder {" +
				"haircut=" + this.haircut + ", " +
				"haircutThreshold=" + this.haircutThreshold +
			'}';
		}
	}
}
