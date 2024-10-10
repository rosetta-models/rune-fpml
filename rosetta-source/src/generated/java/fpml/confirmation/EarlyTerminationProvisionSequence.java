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
import fpml.confirmation.EarlyTerminationProvisionSequence;
import fpml.confirmation.EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder;
import fpml.confirmation.EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilderImpl;
import fpml.confirmation.EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceImpl;
import fpml.confirmation.MandatoryEarlyTerminationModel;
import fpml.confirmation.OptionalEarlyTerminationModel;
import fpml.confirmation.meta.EarlyTerminationProvisionSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="EarlyTerminationProvisionSequence", builder=EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilderImpl.class, version="${project.version}")
public interface EarlyTerminationProvisionSequence extends RosettaModelObject {

	EarlyTerminationProvisionSequenceMeta metaData = new EarlyTerminationProvisionSequenceMeta();

	/*********************** Getter Methods  ***********************/
	MandatoryEarlyTerminationModel getMandatoryEarlyTerminationModel();
	OptionalEarlyTerminationModel getOptionalEarlyTerminationModel();

	/*********************** Build Methods  ***********************/
	EarlyTerminationProvisionSequence build();
	
	EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder toBuilder();
	
	static EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder builder() {
		return new EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EarlyTerminationProvisionSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EarlyTerminationProvisionSequence> getType() {
		return EarlyTerminationProvisionSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("mandatoryEarlyTerminationModel"), processor, MandatoryEarlyTerminationModel.class, getMandatoryEarlyTerminationModel());
		processRosetta(path.newSubPath("optionalEarlyTerminationModel"), processor, OptionalEarlyTerminationModel.class, getOptionalEarlyTerminationModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EarlyTerminationProvisionSequenceBuilder extends EarlyTerminationProvisionSequence, RosettaModelObjectBuilder {
		MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder getOrCreateMandatoryEarlyTerminationModel();
		MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder getMandatoryEarlyTerminationModel();
		OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder getOrCreateOptionalEarlyTerminationModel();
		OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder getOptionalEarlyTerminationModel();
		EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder setMandatoryEarlyTerminationModel(MandatoryEarlyTerminationModel mandatoryEarlyTerminationModel);
		EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder setOptionalEarlyTerminationModel(OptionalEarlyTerminationModel optionalEarlyTerminationModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("mandatoryEarlyTerminationModel"), processor, MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder.class, getMandatoryEarlyTerminationModel());
			processRosetta(path.newSubPath("optionalEarlyTerminationModel"), processor, OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder.class, getOptionalEarlyTerminationModel());
		}
		

		EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of EarlyTerminationProvisionSequence  ***********************/
	class EarlyTerminationProvisionSequenceImpl implements EarlyTerminationProvisionSequence {
		private final MandatoryEarlyTerminationModel mandatoryEarlyTerminationModel;
		private final OptionalEarlyTerminationModel optionalEarlyTerminationModel;
		
		protected EarlyTerminationProvisionSequenceImpl(EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder builder) {
			this.mandatoryEarlyTerminationModel = ofNullable(builder.getMandatoryEarlyTerminationModel()).map(f->f.build()).orElse(null);
			this.optionalEarlyTerminationModel = ofNullable(builder.getOptionalEarlyTerminationModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationModel")
		public MandatoryEarlyTerminationModel getMandatoryEarlyTerminationModel() {
			return mandatoryEarlyTerminationModel;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationModel")
		public OptionalEarlyTerminationModel getOptionalEarlyTerminationModel() {
			return optionalEarlyTerminationModel;
		}
		
		@Override
		public EarlyTerminationProvisionSequence build() {
			return this;
		}
		
		@Override
		public EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder toBuilder() {
			EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder builder) {
			ofNullable(getMandatoryEarlyTerminationModel()).ifPresent(builder::setMandatoryEarlyTerminationModel);
			ofNullable(getOptionalEarlyTerminationModel()).ifPresent(builder::setOptionalEarlyTerminationModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EarlyTerminationProvisionSequence _that = getType().cast(o);
		
			if (!Objects.equals(mandatoryEarlyTerminationModel, _that.getMandatoryEarlyTerminationModel())) return false;
			if (!Objects.equals(optionalEarlyTerminationModel, _that.getOptionalEarlyTerminationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mandatoryEarlyTerminationModel != null ? mandatoryEarlyTerminationModel.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationModel != null ? optionalEarlyTerminationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EarlyTerminationProvisionSequence {" +
				"mandatoryEarlyTerminationModel=" + this.mandatoryEarlyTerminationModel + ", " +
				"optionalEarlyTerminationModel=" + this.optionalEarlyTerminationModel +
			'}';
		}
	}

	/*********************** Builder Implementation of EarlyTerminationProvisionSequence  ***********************/
	class EarlyTerminationProvisionSequenceBuilderImpl implements EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder {
	
		protected MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder mandatoryEarlyTerminationModel;
		protected OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder optionalEarlyTerminationModel;
	
		public EarlyTerminationProvisionSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationModel")
		public MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder getMandatoryEarlyTerminationModel() {
			return mandatoryEarlyTerminationModel;
		}
		
		@Override
		public MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder getOrCreateMandatoryEarlyTerminationModel() {
			MandatoryEarlyTerminationModel.MandatoryEarlyTerminationModelBuilder result;
			if (mandatoryEarlyTerminationModel!=null) {
				result = mandatoryEarlyTerminationModel;
			}
			else {
				result = mandatoryEarlyTerminationModel = MandatoryEarlyTerminationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationModel")
		public OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder getOptionalEarlyTerminationModel() {
			return optionalEarlyTerminationModel;
		}
		
		@Override
		public OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder getOrCreateOptionalEarlyTerminationModel() {
			OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder result;
			if (optionalEarlyTerminationModel!=null) {
				result = optionalEarlyTerminationModel;
			}
			else {
				result = optionalEarlyTerminationModel = OptionalEarlyTerminationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationModel")
		public EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder setMandatoryEarlyTerminationModel(MandatoryEarlyTerminationModel mandatoryEarlyTerminationModel) {
			this.mandatoryEarlyTerminationModel = mandatoryEarlyTerminationModel==null?null:mandatoryEarlyTerminationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionalEarlyTerminationModel")
		public EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder setOptionalEarlyTerminationModel(OptionalEarlyTerminationModel optionalEarlyTerminationModel) {
			this.optionalEarlyTerminationModel = optionalEarlyTerminationModel==null?null:optionalEarlyTerminationModel.toBuilder();
			return this;
		}
		
		@Override
		public EarlyTerminationProvisionSequence build() {
			return new EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceImpl(this);
		}
		
		@Override
		public EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder prune() {
			if (mandatoryEarlyTerminationModel!=null && !mandatoryEarlyTerminationModel.prune().hasData()) mandatoryEarlyTerminationModel = null;
			if (optionalEarlyTerminationModel!=null && !optionalEarlyTerminationModel.prune().hasData()) optionalEarlyTerminationModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMandatoryEarlyTerminationModel()!=null && getMandatoryEarlyTerminationModel().hasData()) return true;
			if (getOptionalEarlyTerminationModel()!=null && getOptionalEarlyTerminationModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder o = (EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder) other;
			
			merger.mergeRosetta(getMandatoryEarlyTerminationModel(), o.getMandatoryEarlyTerminationModel(), this::setMandatoryEarlyTerminationModel);
			merger.mergeRosetta(getOptionalEarlyTerminationModel(), o.getOptionalEarlyTerminationModel(), this::setOptionalEarlyTerminationModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EarlyTerminationProvisionSequence _that = getType().cast(o);
		
			if (!Objects.equals(mandatoryEarlyTerminationModel, _that.getMandatoryEarlyTerminationModel())) return false;
			if (!Objects.equals(optionalEarlyTerminationModel, _that.getOptionalEarlyTerminationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mandatoryEarlyTerminationModel != null ? mandatoryEarlyTerminationModel.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationModel != null ? optionalEarlyTerminationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EarlyTerminationProvisionSequenceBuilder {" +
				"mandatoryEarlyTerminationModel=" + this.mandatoryEarlyTerminationModel + ", " +
				"optionalEarlyTerminationModel=" + this.optionalEarlyTerminationModel +
			'}';
		}
	}
}
