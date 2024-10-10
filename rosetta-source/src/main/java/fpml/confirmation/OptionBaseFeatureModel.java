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
import fpml.confirmation.FxFeature;
import fpml.confirmation.OptionBaseFeatureModel;
import fpml.confirmation.OptionBaseFeatureModel.OptionBaseFeatureModelBuilder;
import fpml.confirmation.OptionBaseFeatureModel.OptionBaseFeatureModelBuilderImpl;
import fpml.confirmation.OptionBaseFeatureModel.OptionBaseFeatureModelImpl;
import fpml.confirmation.StrategyFeature;
import fpml.confirmation.meta.OptionBaseFeatureModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model group containing Option Base Feature Elements.
 * @version ${project.version}
 */
@RosettaDataType(value="OptionBaseFeatureModel", builder=OptionBaseFeatureModel.OptionBaseFeatureModelBuilderImpl.class, version="${project.version}")
public interface OptionBaseFeatureModel extends RosettaModelObject {

	OptionBaseFeatureModelMeta metaData = new OptionBaseFeatureModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A quanto or composite FX feature.
	 */
	FxFeature getFxFeature();
	/**
	 * A simple strategy feature.
	 */
	StrategyFeature getStrategyFeature();

	/*********************** Build Methods  ***********************/
	OptionBaseFeatureModel build();
	
	OptionBaseFeatureModel.OptionBaseFeatureModelBuilder toBuilder();
	
	static OptionBaseFeatureModel.OptionBaseFeatureModelBuilder builder() {
		return new OptionBaseFeatureModel.OptionBaseFeatureModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionBaseFeatureModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionBaseFeatureModel> getType() {
		return OptionBaseFeatureModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.class, getFxFeature());
		processRosetta(path.newSubPath("strategyFeature"), processor, StrategyFeature.class, getStrategyFeature());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionBaseFeatureModelBuilder extends OptionBaseFeatureModel, RosettaModelObjectBuilder {
		FxFeature.FxFeatureBuilder getOrCreateFxFeature();
		FxFeature.FxFeatureBuilder getFxFeature();
		StrategyFeature.StrategyFeatureBuilder getOrCreateStrategyFeature();
		StrategyFeature.StrategyFeatureBuilder getStrategyFeature();
		OptionBaseFeatureModel.OptionBaseFeatureModelBuilder setFxFeature(FxFeature fxFeature);
		OptionBaseFeatureModel.OptionBaseFeatureModelBuilder setStrategyFeature(StrategyFeature strategyFeature);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.FxFeatureBuilder.class, getFxFeature());
			processRosetta(path.newSubPath("strategyFeature"), processor, StrategyFeature.StrategyFeatureBuilder.class, getStrategyFeature());
		}
		

		OptionBaseFeatureModel.OptionBaseFeatureModelBuilder prune();
	}

	/*********************** Immutable Implementation of OptionBaseFeatureModel  ***********************/
	class OptionBaseFeatureModelImpl implements OptionBaseFeatureModel {
		private final FxFeature fxFeature;
		private final StrategyFeature strategyFeature;
		
		protected OptionBaseFeatureModelImpl(OptionBaseFeatureModel.OptionBaseFeatureModelBuilder builder) {
			this.fxFeature = ofNullable(builder.getFxFeature()).map(f->f.build()).orElse(null);
			this.strategyFeature = ofNullable(builder.getStrategyFeature()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fxFeature")
		public FxFeature getFxFeature() {
			return fxFeature;
		}
		
		@Override
		@RosettaAttribute("strategyFeature")
		public StrategyFeature getStrategyFeature() {
			return strategyFeature;
		}
		
		@Override
		public OptionBaseFeatureModel build() {
			return this;
		}
		
		@Override
		public OptionBaseFeatureModel.OptionBaseFeatureModelBuilder toBuilder() {
			OptionBaseFeatureModel.OptionBaseFeatureModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionBaseFeatureModel.OptionBaseFeatureModelBuilder builder) {
			ofNullable(getFxFeature()).ifPresent(builder::setFxFeature);
			ofNullable(getStrategyFeature()).ifPresent(builder::setStrategyFeature);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionBaseFeatureModel _that = getType().cast(o);
		
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			if (!Objects.equals(strategyFeature, _that.getStrategyFeature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			_result = 31 * _result + (strategyFeature != null ? strategyFeature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionBaseFeatureModel {" +
				"fxFeature=" + this.fxFeature + ", " +
				"strategyFeature=" + this.strategyFeature +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionBaseFeatureModel  ***********************/
	class OptionBaseFeatureModelBuilderImpl implements OptionBaseFeatureModel.OptionBaseFeatureModelBuilder {
	
		protected FxFeature.FxFeatureBuilder fxFeature;
		protected StrategyFeature.StrategyFeatureBuilder strategyFeature;
	
		public OptionBaseFeatureModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fxFeature")
		public FxFeature.FxFeatureBuilder getFxFeature() {
			return fxFeature;
		}
		
		@Override
		public FxFeature.FxFeatureBuilder getOrCreateFxFeature() {
			FxFeature.FxFeatureBuilder result;
			if (fxFeature!=null) {
				result = fxFeature;
			}
			else {
				result = fxFeature = FxFeature.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strategyFeature")
		public StrategyFeature.StrategyFeatureBuilder getStrategyFeature() {
			return strategyFeature;
		}
		
		@Override
		public StrategyFeature.StrategyFeatureBuilder getOrCreateStrategyFeature() {
			StrategyFeature.StrategyFeatureBuilder result;
			if (strategyFeature!=null) {
				result = strategyFeature;
			}
			else {
				result = strategyFeature = StrategyFeature.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxFeature")
		public OptionBaseFeatureModel.OptionBaseFeatureModelBuilder setFxFeature(FxFeature fxFeature) {
			this.fxFeature = fxFeature==null?null:fxFeature.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("strategyFeature")
		public OptionBaseFeatureModel.OptionBaseFeatureModelBuilder setStrategyFeature(StrategyFeature strategyFeature) {
			this.strategyFeature = strategyFeature==null?null:strategyFeature.toBuilder();
			return this;
		}
		
		@Override
		public OptionBaseFeatureModel build() {
			return new OptionBaseFeatureModel.OptionBaseFeatureModelImpl(this);
		}
		
		@Override
		public OptionBaseFeatureModel.OptionBaseFeatureModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionBaseFeatureModel.OptionBaseFeatureModelBuilder prune() {
			if (fxFeature!=null && !fxFeature.prune().hasData()) fxFeature = null;
			if (strategyFeature!=null && !strategyFeature.prune().hasData()) strategyFeature = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFxFeature()!=null && getFxFeature().hasData()) return true;
			if (getStrategyFeature()!=null && getStrategyFeature().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionBaseFeatureModel.OptionBaseFeatureModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionBaseFeatureModel.OptionBaseFeatureModelBuilder o = (OptionBaseFeatureModel.OptionBaseFeatureModelBuilder) other;
			
			merger.mergeRosetta(getFxFeature(), o.getFxFeature(), this::setFxFeature);
			merger.mergeRosetta(getStrategyFeature(), o.getStrategyFeature(), this::setStrategyFeature);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionBaseFeatureModel _that = getType().cast(o);
		
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			if (!Objects.equals(strategyFeature, _that.getStrategyFeature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			_result = 31 * _result + (strategyFeature != null ? strategyFeature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionBaseFeatureModelBuilder {" +
				"fxFeature=" + this.fxFeature + ", " +
				"strategyFeature=" + this.strategyFeature +
			'}';
		}
	}
}
