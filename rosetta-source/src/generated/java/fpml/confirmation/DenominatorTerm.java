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
import fpml.confirmation.DenominatorTerm;
import fpml.confirmation.DenominatorTerm.DenominatorTermBuilder;
import fpml.confirmation.DenominatorTerm.DenominatorTermBuilderImpl;
import fpml.confirmation.DenominatorTerm.DenominatorTermImpl;
import fpml.confirmation.WeightedPartialDerivative;
import fpml.confirmation.meta.DenominatorTermMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The type defining a denominator term of the formula. Its value is (sum of weighted partials) ^ power.
 * @version ${project.version}
 */
@RosettaDataType(value="DenominatorTerm", builder=DenominatorTerm.DenominatorTermBuilderImpl.class, version="${project.version}")
public interface DenominatorTerm extends RosettaModelObject {

	DenominatorTermMeta metaData = new DenominatorTermMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A partial derivative multiplied by a weighting factor.
	 */
	WeightedPartialDerivative getWeightedPartial();
	/**
	 * The power to which this term is raised.
	 */
	Integer getPower();

	/*********************** Build Methods  ***********************/
	DenominatorTerm build();
	
	DenominatorTerm.DenominatorTermBuilder toBuilder();
	
	static DenominatorTerm.DenominatorTermBuilder builder() {
		return new DenominatorTerm.DenominatorTermBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DenominatorTerm> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DenominatorTerm> getType() {
		return DenominatorTerm.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("weightedPartial"), processor, WeightedPartialDerivative.class, getWeightedPartial());
		processor.processBasic(path.newSubPath("power"), Integer.class, getPower(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DenominatorTermBuilder extends DenominatorTerm, RosettaModelObjectBuilder {
		WeightedPartialDerivative.WeightedPartialDerivativeBuilder getOrCreateWeightedPartial();
		WeightedPartialDerivative.WeightedPartialDerivativeBuilder getWeightedPartial();
		DenominatorTerm.DenominatorTermBuilder setWeightedPartial(WeightedPartialDerivative weightedPartial);
		DenominatorTerm.DenominatorTermBuilder setPower(Integer power);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("weightedPartial"), processor, WeightedPartialDerivative.WeightedPartialDerivativeBuilder.class, getWeightedPartial());
			processor.processBasic(path.newSubPath("power"), Integer.class, getPower(), this);
		}
		

		DenominatorTerm.DenominatorTermBuilder prune();
	}

	/*********************** Immutable Implementation of DenominatorTerm  ***********************/
	class DenominatorTermImpl implements DenominatorTerm {
		private final WeightedPartialDerivative weightedPartial;
		private final Integer power;
		
		protected DenominatorTermImpl(DenominatorTerm.DenominatorTermBuilder builder) {
			this.weightedPartial = ofNullable(builder.getWeightedPartial()).map(f->f.build()).orElse(null);
			this.power = builder.getPower();
		}
		
		@Override
		@RosettaAttribute("weightedPartial")
		public WeightedPartialDerivative getWeightedPartial() {
			return weightedPartial;
		}
		
		@Override
		@RosettaAttribute("power")
		public Integer getPower() {
			return power;
		}
		
		@Override
		public DenominatorTerm build() {
			return this;
		}
		
		@Override
		public DenominatorTerm.DenominatorTermBuilder toBuilder() {
			DenominatorTerm.DenominatorTermBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DenominatorTerm.DenominatorTermBuilder builder) {
			ofNullable(getWeightedPartial()).ifPresent(builder::setWeightedPartial);
			ofNullable(getPower()).ifPresent(builder::setPower);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DenominatorTerm _that = getType().cast(o);
		
			if (!Objects.equals(weightedPartial, _that.getWeightedPartial())) return false;
			if (!Objects.equals(power, _that.getPower())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (weightedPartial != null ? weightedPartial.hashCode() : 0);
			_result = 31 * _result + (power != null ? power.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DenominatorTerm {" +
				"weightedPartial=" + this.weightedPartial + ", " +
				"power=" + this.power +
			'}';
		}
	}

	/*********************** Builder Implementation of DenominatorTerm  ***********************/
	class DenominatorTermBuilderImpl implements DenominatorTerm.DenominatorTermBuilder {
	
		protected WeightedPartialDerivative.WeightedPartialDerivativeBuilder weightedPartial;
		protected Integer power;
	
		public DenominatorTermBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("weightedPartial")
		public WeightedPartialDerivative.WeightedPartialDerivativeBuilder getWeightedPartial() {
			return weightedPartial;
		}
		
		@Override
		public WeightedPartialDerivative.WeightedPartialDerivativeBuilder getOrCreateWeightedPartial() {
			WeightedPartialDerivative.WeightedPartialDerivativeBuilder result;
			if (weightedPartial!=null) {
				result = weightedPartial;
			}
			else {
				result = weightedPartial = WeightedPartialDerivative.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("power")
		public Integer getPower() {
			return power;
		}
		
		@Override
		@RosettaAttribute("weightedPartial")
		public DenominatorTerm.DenominatorTermBuilder setWeightedPartial(WeightedPartialDerivative weightedPartial) {
			this.weightedPartial = weightedPartial==null?null:weightedPartial.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("power")
		public DenominatorTerm.DenominatorTermBuilder setPower(Integer power) {
			this.power = power==null?null:power;
			return this;
		}
		
		@Override
		public DenominatorTerm build() {
			return new DenominatorTerm.DenominatorTermImpl(this);
		}
		
		@Override
		public DenominatorTerm.DenominatorTermBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DenominatorTerm.DenominatorTermBuilder prune() {
			if (weightedPartial!=null && !weightedPartial.prune().hasData()) weightedPartial = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getWeightedPartial()!=null && getWeightedPartial().hasData()) return true;
			if (getPower()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DenominatorTerm.DenominatorTermBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DenominatorTerm.DenominatorTermBuilder o = (DenominatorTerm.DenominatorTermBuilder) other;
			
			merger.mergeRosetta(getWeightedPartial(), o.getWeightedPartial(), this::setWeightedPartial);
			
			merger.mergeBasic(getPower(), o.getPower(), this::setPower);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DenominatorTerm _that = getType().cast(o);
		
			if (!Objects.equals(weightedPartial, _that.getWeightedPartial())) return false;
			if (!Objects.equals(power, _that.getPower())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (weightedPartial != null ? weightedPartial.hashCode() : 0);
			_result = 31 * _result + (power != null ? power.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DenominatorTermBuilder {" +
				"weightedPartial=" + this.weightedPartial + ", " +
				"power=" + this.power +
			'}';
		}
	}
}
