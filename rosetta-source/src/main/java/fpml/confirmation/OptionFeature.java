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
import fpml.confirmation.OptionBaseFeatureModel;
import fpml.confirmation.OptionFeature;
import fpml.confirmation.OptionFeature.OptionFeatureBuilder;
import fpml.confirmation.OptionFeature.OptionFeatureBuilderImpl;
import fpml.confirmation.OptionFeature.OptionFeatureImpl;
import fpml.confirmation.OptionFeatureModel;
import fpml.confirmation.meta.OptionFeatureMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining option features.
 * @version ${project.version}
 */
@RosettaDataType(value="OptionFeature", builder=OptionFeature.OptionFeatureBuilderImpl.class, version="${project.version}")
public interface OptionFeature extends RosettaModelObject {

	OptionFeatureMeta metaData = new OptionFeatureMeta();

	/*********************** Getter Methods  ***********************/
	OptionBaseFeatureModel getOptionBaseFeatureModel();
	OptionFeatureModel getOptionFeatureModel();

	/*********************** Build Methods  ***********************/
	OptionFeature build();
	
	OptionFeature.OptionFeatureBuilder toBuilder();
	
	static OptionFeature.OptionFeatureBuilder builder() {
		return new OptionFeature.OptionFeatureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionFeature> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionFeature> getType() {
		return OptionFeature.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("optionBaseFeatureModel"), processor, OptionBaseFeatureModel.class, getOptionBaseFeatureModel());
		processRosetta(path.newSubPath("optionFeatureModel"), processor, OptionFeatureModel.class, getOptionFeatureModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionFeatureBuilder extends OptionFeature, RosettaModelObjectBuilder {
		OptionBaseFeatureModel.OptionBaseFeatureModelBuilder getOrCreateOptionBaseFeatureModel();
		OptionBaseFeatureModel.OptionBaseFeatureModelBuilder getOptionBaseFeatureModel();
		OptionFeatureModel.OptionFeatureModelBuilder getOrCreateOptionFeatureModel();
		OptionFeatureModel.OptionFeatureModelBuilder getOptionFeatureModel();
		OptionFeature.OptionFeatureBuilder setOptionBaseFeatureModel(OptionBaseFeatureModel optionBaseFeatureModel);
		OptionFeature.OptionFeatureBuilder setOptionFeatureModel(OptionFeatureModel optionFeatureModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("optionBaseFeatureModel"), processor, OptionBaseFeatureModel.OptionBaseFeatureModelBuilder.class, getOptionBaseFeatureModel());
			processRosetta(path.newSubPath("optionFeatureModel"), processor, OptionFeatureModel.OptionFeatureModelBuilder.class, getOptionFeatureModel());
		}
		

		OptionFeature.OptionFeatureBuilder prune();
	}

	/*********************** Immutable Implementation of OptionFeature  ***********************/
	class OptionFeatureImpl implements OptionFeature {
		private final OptionBaseFeatureModel optionBaseFeatureModel;
		private final OptionFeatureModel optionFeatureModel;
		
		protected OptionFeatureImpl(OptionFeature.OptionFeatureBuilder builder) {
			this.optionBaseFeatureModel = ofNullable(builder.getOptionBaseFeatureModel()).map(f->f.build()).orElse(null);
			this.optionFeatureModel = ofNullable(builder.getOptionFeatureModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("optionBaseFeatureModel")
		public OptionBaseFeatureModel getOptionBaseFeatureModel() {
			return optionBaseFeatureModel;
		}
		
		@Override
		@RosettaAttribute("optionFeatureModel")
		public OptionFeatureModel getOptionFeatureModel() {
			return optionFeatureModel;
		}
		
		@Override
		public OptionFeature build() {
			return this;
		}
		
		@Override
		public OptionFeature.OptionFeatureBuilder toBuilder() {
			OptionFeature.OptionFeatureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionFeature.OptionFeatureBuilder builder) {
			ofNullable(getOptionBaseFeatureModel()).ifPresent(builder::setOptionBaseFeatureModel);
			ofNullable(getOptionFeatureModel()).ifPresent(builder::setOptionFeatureModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionFeature _that = getType().cast(o);
		
			if (!Objects.equals(optionBaseFeatureModel, _that.getOptionBaseFeatureModel())) return false;
			if (!Objects.equals(optionFeatureModel, _that.getOptionFeatureModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionBaseFeatureModel != null ? optionBaseFeatureModel.hashCode() : 0);
			_result = 31 * _result + (optionFeatureModel != null ? optionFeatureModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionFeature {" +
				"optionBaseFeatureModel=" + this.optionBaseFeatureModel + ", " +
				"optionFeatureModel=" + this.optionFeatureModel +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionFeature  ***********************/
	class OptionFeatureBuilderImpl implements OptionFeature.OptionFeatureBuilder {
	
		protected OptionBaseFeatureModel.OptionBaseFeatureModelBuilder optionBaseFeatureModel;
		protected OptionFeatureModel.OptionFeatureModelBuilder optionFeatureModel;
	
		public OptionFeatureBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("optionBaseFeatureModel")
		public OptionBaseFeatureModel.OptionBaseFeatureModelBuilder getOptionBaseFeatureModel() {
			return optionBaseFeatureModel;
		}
		
		@Override
		public OptionBaseFeatureModel.OptionBaseFeatureModelBuilder getOrCreateOptionBaseFeatureModel() {
			OptionBaseFeatureModel.OptionBaseFeatureModelBuilder result;
			if (optionBaseFeatureModel!=null) {
				result = optionBaseFeatureModel;
			}
			else {
				result = optionBaseFeatureModel = OptionBaseFeatureModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionFeatureModel")
		public OptionFeatureModel.OptionFeatureModelBuilder getOptionFeatureModel() {
			return optionFeatureModel;
		}
		
		@Override
		public OptionFeatureModel.OptionFeatureModelBuilder getOrCreateOptionFeatureModel() {
			OptionFeatureModel.OptionFeatureModelBuilder result;
			if (optionFeatureModel!=null) {
				result = optionFeatureModel;
			}
			else {
				result = optionFeatureModel = OptionFeatureModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionBaseFeatureModel")
		public OptionFeature.OptionFeatureBuilder setOptionBaseFeatureModel(OptionBaseFeatureModel optionBaseFeatureModel) {
			this.optionBaseFeatureModel = optionBaseFeatureModel==null?null:optionBaseFeatureModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionFeatureModel")
		public OptionFeature.OptionFeatureBuilder setOptionFeatureModel(OptionFeatureModel optionFeatureModel) {
			this.optionFeatureModel = optionFeatureModel==null?null:optionFeatureModel.toBuilder();
			return this;
		}
		
		@Override
		public OptionFeature build() {
			return new OptionFeature.OptionFeatureImpl(this);
		}
		
		@Override
		public OptionFeature.OptionFeatureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionFeature.OptionFeatureBuilder prune() {
			if (optionBaseFeatureModel!=null && !optionBaseFeatureModel.prune().hasData()) optionBaseFeatureModel = null;
			if (optionFeatureModel!=null && !optionFeatureModel.prune().hasData()) optionFeatureModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOptionBaseFeatureModel()!=null && getOptionBaseFeatureModel().hasData()) return true;
			if (getOptionFeatureModel()!=null && getOptionFeatureModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionFeature.OptionFeatureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionFeature.OptionFeatureBuilder o = (OptionFeature.OptionFeatureBuilder) other;
			
			merger.mergeRosetta(getOptionBaseFeatureModel(), o.getOptionBaseFeatureModel(), this::setOptionBaseFeatureModel);
			merger.mergeRosetta(getOptionFeatureModel(), o.getOptionFeatureModel(), this::setOptionFeatureModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionFeature _that = getType().cast(o);
		
			if (!Objects.equals(optionBaseFeatureModel, _that.getOptionBaseFeatureModel())) return false;
			if (!Objects.equals(optionFeatureModel, _that.getOptionFeatureModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionBaseFeatureModel != null ? optionBaseFeatureModel.hashCode() : 0);
			_result = 31 * _result + (optionFeatureModel != null ? optionFeatureModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionFeatureBuilder {" +
				"optionBaseFeatureModel=" + this.optionBaseFeatureModel + ", " +
				"optionFeatureModel=" + this.optionFeatureModel +
			'}';
		}
	}
}
