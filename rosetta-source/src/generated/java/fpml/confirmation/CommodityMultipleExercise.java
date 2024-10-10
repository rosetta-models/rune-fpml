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
import fpml.confirmation.CommodityMultipleExercise;
import fpml.confirmation.CommodityMultipleExercise.CommodityMultipleExerciseBuilder;
import fpml.confirmation.CommodityMultipleExercise.CommodityMultipleExerciseBuilderImpl;
import fpml.confirmation.CommodityMultipleExercise.CommodityMultipleExerciseImpl;
import fpml.confirmation.CommodityNotionalQuantity;
import fpml.confirmation.meta.CommodityMultipleExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining the multiple exercise provisions of an American style commodity option.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityMultipleExercise", builder=CommodityMultipleExercise.CommodityMultipleExerciseBuilderImpl.class, version="${project.version}")
public interface CommodityMultipleExercise extends RosettaModelObject {

	CommodityMultipleExerciseMeta metaData = new CommodityMultipleExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The integral multiple quantity defines a lower limit of the Notional Quantity that can be exercised and also defines a unit multiple of the Notional Quantity that can be exercised, i.e. only integer multiples of this Notional Quantity can be exercised.
	 */
	CommodityNotionalQuantity getIntegralMultipleQuantity();
	/**
	 * The minimum Notional Quantity that can be exercised on a given Exercise Date. See multipleExercise.
	 */
	CommodityNotionalQuantity getMinimumNotionalQuantity();

	/*********************** Build Methods  ***********************/
	CommodityMultipleExercise build();
	
	CommodityMultipleExercise.CommodityMultipleExerciseBuilder toBuilder();
	
	static CommodityMultipleExercise.CommodityMultipleExerciseBuilder builder() {
		return new CommodityMultipleExercise.CommodityMultipleExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityMultipleExercise> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityMultipleExercise> getType() {
		return CommodityMultipleExercise.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("integralMultipleQuantity"), processor, CommodityNotionalQuantity.class, getIntegralMultipleQuantity());
		processRosetta(path.newSubPath("minimumNotionalQuantity"), processor, CommodityNotionalQuantity.class, getMinimumNotionalQuantity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityMultipleExerciseBuilder extends CommodityMultipleExercise, RosettaModelObjectBuilder {
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateIntegralMultipleQuantity();
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getIntegralMultipleQuantity();
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateMinimumNotionalQuantity();
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getMinimumNotionalQuantity();
		CommodityMultipleExercise.CommodityMultipleExerciseBuilder setIntegralMultipleQuantity(CommodityNotionalQuantity integralMultipleQuantity);
		CommodityMultipleExercise.CommodityMultipleExerciseBuilder setMinimumNotionalQuantity(CommodityNotionalQuantity minimumNotionalQuantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("integralMultipleQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getIntegralMultipleQuantity());
			processRosetta(path.newSubPath("minimumNotionalQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getMinimumNotionalQuantity());
		}
		

		CommodityMultipleExercise.CommodityMultipleExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityMultipleExercise  ***********************/
	class CommodityMultipleExerciseImpl implements CommodityMultipleExercise {
		private final CommodityNotionalQuantity integralMultipleQuantity;
		private final CommodityNotionalQuantity minimumNotionalQuantity;
		
		protected CommodityMultipleExerciseImpl(CommodityMultipleExercise.CommodityMultipleExerciseBuilder builder) {
			this.integralMultipleQuantity = ofNullable(builder.getIntegralMultipleQuantity()).map(f->f.build()).orElse(null);
			this.minimumNotionalQuantity = ofNullable(builder.getMinimumNotionalQuantity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("integralMultipleQuantity")
		public CommodityNotionalQuantity getIntegralMultipleQuantity() {
			return integralMultipleQuantity;
		}
		
		@Override
		@RosettaAttribute("minimumNotionalQuantity")
		public CommodityNotionalQuantity getMinimumNotionalQuantity() {
			return minimumNotionalQuantity;
		}
		
		@Override
		public CommodityMultipleExercise build() {
			return this;
		}
		
		@Override
		public CommodityMultipleExercise.CommodityMultipleExerciseBuilder toBuilder() {
			CommodityMultipleExercise.CommodityMultipleExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityMultipleExercise.CommodityMultipleExerciseBuilder builder) {
			ofNullable(getIntegralMultipleQuantity()).ifPresent(builder::setIntegralMultipleQuantity);
			ofNullable(getMinimumNotionalQuantity()).ifPresent(builder::setMinimumNotionalQuantity);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMultipleExercise _that = getType().cast(o);
		
			if (!Objects.equals(integralMultipleQuantity, _that.getIntegralMultipleQuantity())) return false;
			if (!Objects.equals(minimumNotionalQuantity, _that.getMinimumNotionalQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (integralMultipleQuantity != null ? integralMultipleQuantity.hashCode() : 0);
			_result = 31 * _result + (minimumNotionalQuantity != null ? minimumNotionalQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMultipleExercise {" +
				"integralMultipleQuantity=" + this.integralMultipleQuantity + ", " +
				"minimumNotionalQuantity=" + this.minimumNotionalQuantity +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityMultipleExercise  ***********************/
	class CommodityMultipleExerciseBuilderImpl implements CommodityMultipleExercise.CommodityMultipleExerciseBuilder {
	
		protected CommodityNotionalQuantity.CommodityNotionalQuantityBuilder integralMultipleQuantity;
		protected CommodityNotionalQuantity.CommodityNotionalQuantityBuilder minimumNotionalQuantity;
	
		public CommodityMultipleExerciseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("integralMultipleQuantity")
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getIntegralMultipleQuantity() {
			return integralMultipleQuantity;
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateIntegralMultipleQuantity() {
			CommodityNotionalQuantity.CommodityNotionalQuantityBuilder result;
			if (integralMultipleQuantity!=null) {
				result = integralMultipleQuantity;
			}
			else {
				result = integralMultipleQuantity = CommodityNotionalQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("minimumNotionalQuantity")
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getMinimumNotionalQuantity() {
			return minimumNotionalQuantity;
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateMinimumNotionalQuantity() {
			CommodityNotionalQuantity.CommodityNotionalQuantityBuilder result;
			if (minimumNotionalQuantity!=null) {
				result = minimumNotionalQuantity;
			}
			else {
				result = minimumNotionalQuantity = CommodityNotionalQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("integralMultipleQuantity")
		public CommodityMultipleExercise.CommodityMultipleExerciseBuilder setIntegralMultipleQuantity(CommodityNotionalQuantity integralMultipleQuantity) {
			this.integralMultipleQuantity = integralMultipleQuantity==null?null:integralMultipleQuantity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("minimumNotionalQuantity")
		public CommodityMultipleExercise.CommodityMultipleExerciseBuilder setMinimumNotionalQuantity(CommodityNotionalQuantity minimumNotionalQuantity) {
			this.minimumNotionalQuantity = minimumNotionalQuantity==null?null:minimumNotionalQuantity.toBuilder();
			return this;
		}
		
		@Override
		public CommodityMultipleExercise build() {
			return new CommodityMultipleExercise.CommodityMultipleExerciseImpl(this);
		}
		
		@Override
		public CommodityMultipleExercise.CommodityMultipleExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMultipleExercise.CommodityMultipleExerciseBuilder prune() {
			if (integralMultipleQuantity!=null && !integralMultipleQuantity.prune().hasData()) integralMultipleQuantity = null;
			if (minimumNotionalQuantity!=null && !minimumNotionalQuantity.prune().hasData()) minimumNotionalQuantity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIntegralMultipleQuantity()!=null && getIntegralMultipleQuantity().hasData()) return true;
			if (getMinimumNotionalQuantity()!=null && getMinimumNotionalQuantity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityMultipleExercise.CommodityMultipleExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityMultipleExercise.CommodityMultipleExerciseBuilder o = (CommodityMultipleExercise.CommodityMultipleExerciseBuilder) other;
			
			merger.mergeRosetta(getIntegralMultipleQuantity(), o.getIntegralMultipleQuantity(), this::setIntegralMultipleQuantity);
			merger.mergeRosetta(getMinimumNotionalQuantity(), o.getMinimumNotionalQuantity(), this::setMinimumNotionalQuantity);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityMultipleExercise _that = getType().cast(o);
		
			if (!Objects.equals(integralMultipleQuantity, _that.getIntegralMultipleQuantity())) return false;
			if (!Objects.equals(minimumNotionalQuantity, _that.getMinimumNotionalQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (integralMultipleQuantity != null ? integralMultipleQuantity.hashCode() : 0);
			_result = 31 * _result + (minimumNotionalQuantity != null ? minimumNotionalQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityMultipleExerciseBuilder {" +
				"integralMultipleQuantity=" + this.integralMultipleQuantity + ", " +
				"minimumNotionalQuantity=" + this.minimumNotionalQuantity +
			'}';
		}
	}
}
