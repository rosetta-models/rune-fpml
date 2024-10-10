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
import fpml.confirmation.FeatureModel;
import fpml.confirmation.FeatureModel.FeatureModelBuilder;
import fpml.confirmation.FeatureModel.FeatureModelBuilderImpl;
import fpml.confirmation.FeatureModel.FeatureModelImpl;
import fpml.confirmation.FxFeature;
import fpml.confirmation.OptionFeatures;
import fpml.confirmation.meta.FeatureModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A group containing Swap and Derivative features.
 * @version ${project.version}
 */
@RosettaDataType(value="FeatureModel", builder=FeatureModel.FeatureModelBuilderImpl.class, version="${project.version}")
public interface FeatureModel extends RosettaModelObject {

	FeatureModelMeta metaData = new FeatureModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Asian, Barrier, Knock and Pass Through features.
	 */
	OptionFeatures getFeature();
	/**
	 * Quanto, Composite, or Cross Currency FX features.
	 */
	FxFeature getFxFeature();

	/*********************** Build Methods  ***********************/
	FeatureModel build();
	
	FeatureModel.FeatureModelBuilder toBuilder();
	
	static FeatureModel.FeatureModelBuilder builder() {
		return new FeatureModel.FeatureModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FeatureModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FeatureModel> getType() {
		return FeatureModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("feature"), processor, OptionFeatures.class, getFeature());
		processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.class, getFxFeature());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FeatureModelBuilder extends FeatureModel, RosettaModelObjectBuilder {
		OptionFeatures.OptionFeaturesBuilder getOrCreateFeature();
		OptionFeatures.OptionFeaturesBuilder getFeature();
		FxFeature.FxFeatureBuilder getOrCreateFxFeature();
		FxFeature.FxFeatureBuilder getFxFeature();
		FeatureModel.FeatureModelBuilder setFeature(OptionFeatures feature);
		FeatureModel.FeatureModelBuilder setFxFeature(FxFeature fxFeature);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("feature"), processor, OptionFeatures.OptionFeaturesBuilder.class, getFeature());
			processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.FxFeatureBuilder.class, getFxFeature());
		}
		

		FeatureModel.FeatureModelBuilder prune();
	}

	/*********************** Immutable Implementation of FeatureModel  ***********************/
	class FeatureModelImpl implements FeatureModel {
		private final OptionFeatures feature;
		private final FxFeature fxFeature;
		
		protected FeatureModelImpl(FeatureModel.FeatureModelBuilder builder) {
			this.feature = ofNullable(builder.getFeature()).map(f->f.build()).orElse(null);
			this.fxFeature = ofNullable(builder.getFxFeature()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("feature")
		public OptionFeatures getFeature() {
			return feature;
		}
		
		@Override
		@RosettaAttribute("fxFeature")
		public FxFeature getFxFeature() {
			return fxFeature;
		}
		
		@Override
		public FeatureModel build() {
			return this;
		}
		
		@Override
		public FeatureModel.FeatureModelBuilder toBuilder() {
			FeatureModel.FeatureModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FeatureModel.FeatureModelBuilder builder) {
			ofNullable(getFeature()).ifPresent(builder::setFeature);
			ofNullable(getFxFeature()).ifPresent(builder::setFxFeature);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FeatureModel _that = getType().cast(o);
		
			if (!Objects.equals(feature, _that.getFeature())) return false;
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeatureModel {" +
				"feature=" + this.feature + ", " +
				"fxFeature=" + this.fxFeature +
			'}';
		}
	}

	/*********************** Builder Implementation of FeatureModel  ***********************/
	class FeatureModelBuilderImpl implements FeatureModel.FeatureModelBuilder {
	
		protected OptionFeatures.OptionFeaturesBuilder feature;
		protected FxFeature.FxFeatureBuilder fxFeature;
	
		public FeatureModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("feature")
		public OptionFeatures.OptionFeaturesBuilder getFeature() {
			return feature;
		}
		
		@Override
		public OptionFeatures.OptionFeaturesBuilder getOrCreateFeature() {
			OptionFeatures.OptionFeaturesBuilder result;
			if (feature!=null) {
				result = feature;
			}
			else {
				result = feature = OptionFeatures.builder();
			}
			
			return result;
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
		@RosettaAttribute("feature")
		public FeatureModel.FeatureModelBuilder setFeature(OptionFeatures feature) {
			this.feature = feature==null?null:feature.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxFeature")
		public FeatureModel.FeatureModelBuilder setFxFeature(FxFeature fxFeature) {
			this.fxFeature = fxFeature==null?null:fxFeature.toBuilder();
			return this;
		}
		
		@Override
		public FeatureModel build() {
			return new FeatureModel.FeatureModelImpl(this);
		}
		
		@Override
		public FeatureModel.FeatureModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeatureModel.FeatureModelBuilder prune() {
			if (feature!=null && !feature.prune().hasData()) feature = null;
			if (fxFeature!=null && !fxFeature.prune().hasData()) fxFeature = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFeature()!=null && getFeature().hasData()) return true;
			if (getFxFeature()!=null && getFxFeature().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeatureModel.FeatureModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FeatureModel.FeatureModelBuilder o = (FeatureModel.FeatureModelBuilder) other;
			
			merger.mergeRosetta(getFeature(), o.getFeature(), this::setFeature);
			merger.mergeRosetta(getFxFeature(), o.getFxFeature(), this::setFxFeature);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FeatureModel _that = getType().cast(o);
		
			if (!Objects.equals(feature, _that.getFeature())) return false;
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeatureModelBuilder {" +
				"feature=" + this.feature + ", " +
				"fxFeature=" + this.fxFeature +
			'}';
		}
	}
}
